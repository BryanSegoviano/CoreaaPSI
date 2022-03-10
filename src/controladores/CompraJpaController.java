/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import dominio.Compra;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.RelCompraPieza;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bryan
 */
public class CompraJpaController implements Serializable {

    public CompraJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CoreaaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Compra compra) {
        if (compra.getRelCompraPiezaList() == null) {
            compra.setRelCompraPiezaList(new ArrayList<RelCompraPieza>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<RelCompraPieza> attachedRelCompraPiezaList = new ArrayList<RelCompraPieza>();
            for (RelCompraPieza relCompraPiezaListRelCompraPiezaToAttach : compra.getRelCompraPiezaList()) {
                relCompraPiezaListRelCompraPiezaToAttach = em.getReference(relCompraPiezaListRelCompraPiezaToAttach.getClass(), relCompraPiezaListRelCompraPiezaToAttach.getIdrelCompraPiezas());
                attachedRelCompraPiezaList.add(relCompraPiezaListRelCompraPiezaToAttach);
            }
            compra.setRelCompraPiezaList(attachedRelCompraPiezaList);
            em.persist(compra);
            for (RelCompraPieza relCompraPiezaListRelCompraPieza : compra.getRelCompraPiezaList()) {
                Compra oldIdcompraOfRelCompraPiezaListRelCompraPieza = relCompraPiezaListRelCompraPieza.getIdcompra();
                relCompraPiezaListRelCompraPieza.setIdcompra(compra);
                relCompraPiezaListRelCompraPieza = em.merge(relCompraPiezaListRelCompraPieza);
                if (oldIdcompraOfRelCompraPiezaListRelCompraPieza != null) {
                    oldIdcompraOfRelCompraPiezaListRelCompraPieza.getRelCompraPiezaList().remove(relCompraPiezaListRelCompraPieza);
                    oldIdcompraOfRelCompraPiezaListRelCompraPieza = em.merge(oldIdcompraOfRelCompraPiezaListRelCompraPieza);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Compra compra) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra persistentCompra = em.find(Compra.class, compra.getIdcompra());
            List<RelCompraPieza> relCompraPiezaListOld = persistentCompra.getRelCompraPiezaList();
            List<RelCompraPieza> relCompraPiezaListNew = compra.getRelCompraPiezaList();
            List<String> illegalOrphanMessages = null;
            for (RelCompraPieza relCompraPiezaListOldRelCompraPieza : relCompraPiezaListOld) {
                if (!relCompraPiezaListNew.contains(relCompraPiezaListOldRelCompraPieza)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RelCompraPieza " + relCompraPiezaListOldRelCompraPieza + " since its idcompra field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<RelCompraPieza> attachedRelCompraPiezaListNew = new ArrayList<RelCompraPieza>();
            for (RelCompraPieza relCompraPiezaListNewRelCompraPiezaToAttach : relCompraPiezaListNew) {
                relCompraPiezaListNewRelCompraPiezaToAttach = em.getReference(relCompraPiezaListNewRelCompraPiezaToAttach.getClass(), relCompraPiezaListNewRelCompraPiezaToAttach.getIdrelCompraPiezas());
                attachedRelCompraPiezaListNew.add(relCompraPiezaListNewRelCompraPiezaToAttach);
            }
            relCompraPiezaListNew = attachedRelCompraPiezaListNew;
            compra.setRelCompraPiezaList(relCompraPiezaListNew);
            compra = em.merge(compra);
            for (RelCompraPieza relCompraPiezaListNewRelCompraPieza : relCompraPiezaListNew) {
                if (!relCompraPiezaListOld.contains(relCompraPiezaListNewRelCompraPieza)) {
                    Compra oldIdcompraOfRelCompraPiezaListNewRelCompraPieza = relCompraPiezaListNewRelCompraPieza.getIdcompra();
                    relCompraPiezaListNewRelCompraPieza.setIdcompra(compra);
                    relCompraPiezaListNewRelCompraPieza = em.merge(relCompraPiezaListNewRelCompraPieza);
                    if (oldIdcompraOfRelCompraPiezaListNewRelCompraPieza != null && !oldIdcompraOfRelCompraPiezaListNewRelCompraPieza.equals(compra)) {
                        oldIdcompraOfRelCompraPiezaListNewRelCompraPieza.getRelCompraPiezaList().remove(relCompraPiezaListNewRelCompraPieza);
                        oldIdcompraOfRelCompraPiezaListNewRelCompraPieza = em.merge(oldIdcompraOfRelCompraPiezaListNewRelCompraPieza);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = compra.getIdcompra();
                if (findCompra(id) == null) {
                    throw new NonexistentEntityException("The compra with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra compra;
            try {
                compra = em.getReference(Compra.class, id);
                compra.getIdcompra();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The compra with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<RelCompraPieza> relCompraPiezaListOrphanCheck = compra.getRelCompraPiezaList();
            for (RelCompraPieza relCompraPiezaListOrphanCheckRelCompraPieza : relCompraPiezaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Compra (" + compra + ") cannot be destroyed since the RelCompraPieza " + relCompraPiezaListOrphanCheckRelCompraPieza + " in its relCompraPiezaList field has a non-nullable idcompra field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(compra);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Compra> findCompraEntities() {
        return findCompraEntities(true, -1, -1);
    }

    public List<Compra> findCompraEntities(int maxResults, int firstResult) {
        return findCompraEntities(false, maxResults, firstResult);
    }

    private List<Compra> findCompraEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Compra.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Compra findCompra(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Compra.class, id);
        } finally {
            em.close();
        }
    }

    public int getCompraCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Compra> rt = cq.from(Compra.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
