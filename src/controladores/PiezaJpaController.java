/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import dominio.Pieza;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.RelServicioPieza;
import java.util.ArrayList;
import java.util.List;
import dominio.RelCompraPieza;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bryan
 */
public class PiezaJpaController implements Serializable {

    public PiezaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CoreaaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pieza pieza) {
        if (pieza.getRelServicioPiezaList() == null) {
            pieza.setRelServicioPiezaList(new ArrayList<RelServicioPieza>());
        }
        if (pieza.getRelCompraPiezaList() == null) {
            pieza.setRelCompraPiezaList(new ArrayList<RelCompraPieza>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<RelServicioPieza> attachedRelServicioPiezaList = new ArrayList<RelServicioPieza>();
            for (RelServicioPieza relServicioPiezaListRelServicioPiezaToAttach : pieza.getRelServicioPiezaList()) {
                relServicioPiezaListRelServicioPiezaToAttach = em.getReference(relServicioPiezaListRelServicioPiezaToAttach.getClass(), relServicioPiezaListRelServicioPiezaToAttach.getIdrelServicioPieza());
                attachedRelServicioPiezaList.add(relServicioPiezaListRelServicioPiezaToAttach);
            }
            pieza.setRelServicioPiezaList(attachedRelServicioPiezaList);
            List<RelCompraPieza> attachedRelCompraPiezaList = new ArrayList<RelCompraPieza>();
            for (RelCompraPieza relCompraPiezaListRelCompraPiezaToAttach : pieza.getRelCompraPiezaList()) {
                relCompraPiezaListRelCompraPiezaToAttach = em.getReference(relCompraPiezaListRelCompraPiezaToAttach.getClass(), relCompraPiezaListRelCompraPiezaToAttach.getIdrelCompraPiezas());
                attachedRelCompraPiezaList.add(relCompraPiezaListRelCompraPiezaToAttach);
            }
            pieza.setRelCompraPiezaList(attachedRelCompraPiezaList);
            em.persist(pieza);
            for (RelServicioPieza relServicioPiezaListRelServicioPieza : pieza.getRelServicioPiezaList()) {
                Pieza oldIdpieazaOfRelServicioPiezaListRelServicioPieza = relServicioPiezaListRelServicioPieza.getIdpieaza();
                relServicioPiezaListRelServicioPieza.setIdpieaza(pieza);
                relServicioPiezaListRelServicioPieza = em.merge(relServicioPiezaListRelServicioPieza);
                if (oldIdpieazaOfRelServicioPiezaListRelServicioPieza != null) {
                    oldIdpieazaOfRelServicioPiezaListRelServicioPieza.getRelServicioPiezaList().remove(relServicioPiezaListRelServicioPieza);
                    oldIdpieazaOfRelServicioPiezaListRelServicioPieza = em.merge(oldIdpieazaOfRelServicioPiezaListRelServicioPieza);
                }
            }
            for (RelCompraPieza relCompraPiezaListRelCompraPieza : pieza.getRelCompraPiezaList()) {
                Pieza oldIdpiezaOfRelCompraPiezaListRelCompraPieza = relCompraPiezaListRelCompraPieza.getIdpieza();
                relCompraPiezaListRelCompraPieza.setIdpieza(pieza);
                relCompraPiezaListRelCompraPieza = em.merge(relCompraPiezaListRelCompraPieza);
                if (oldIdpiezaOfRelCompraPiezaListRelCompraPieza != null) {
                    oldIdpiezaOfRelCompraPiezaListRelCompraPieza.getRelCompraPiezaList().remove(relCompraPiezaListRelCompraPieza);
                    oldIdpiezaOfRelCompraPiezaListRelCompraPieza = em.merge(oldIdpiezaOfRelCompraPiezaListRelCompraPieza);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pieza pieza) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pieza persistentPieza = em.find(Pieza.class, pieza.getIdpieza());
            List<RelServicioPieza> relServicioPiezaListOld = persistentPieza.getRelServicioPiezaList();
            List<RelServicioPieza> relServicioPiezaListNew = pieza.getRelServicioPiezaList();
            List<RelCompraPieza> relCompraPiezaListOld = persistentPieza.getRelCompraPiezaList();
            List<RelCompraPieza> relCompraPiezaListNew = pieza.getRelCompraPiezaList();
            List<String> illegalOrphanMessages = null;
            for (RelServicioPieza relServicioPiezaListOldRelServicioPieza : relServicioPiezaListOld) {
                if (!relServicioPiezaListNew.contains(relServicioPiezaListOldRelServicioPieza)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RelServicioPieza " + relServicioPiezaListOldRelServicioPieza + " since its idpieaza field is not nullable.");
                }
            }
            for (RelCompraPieza relCompraPiezaListOldRelCompraPieza : relCompraPiezaListOld) {
                if (!relCompraPiezaListNew.contains(relCompraPiezaListOldRelCompraPieza)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RelCompraPieza " + relCompraPiezaListOldRelCompraPieza + " since its idpieza field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<RelServicioPieza> attachedRelServicioPiezaListNew = new ArrayList<RelServicioPieza>();
            for (RelServicioPieza relServicioPiezaListNewRelServicioPiezaToAttach : relServicioPiezaListNew) {
                relServicioPiezaListNewRelServicioPiezaToAttach = em.getReference(relServicioPiezaListNewRelServicioPiezaToAttach.getClass(), relServicioPiezaListNewRelServicioPiezaToAttach.getIdrelServicioPieza());
                attachedRelServicioPiezaListNew.add(relServicioPiezaListNewRelServicioPiezaToAttach);
            }
            relServicioPiezaListNew = attachedRelServicioPiezaListNew;
            pieza.setRelServicioPiezaList(relServicioPiezaListNew);
            List<RelCompraPieza> attachedRelCompraPiezaListNew = new ArrayList<RelCompraPieza>();
            for (RelCompraPieza relCompraPiezaListNewRelCompraPiezaToAttach : relCompraPiezaListNew) {
                relCompraPiezaListNewRelCompraPiezaToAttach = em.getReference(relCompraPiezaListNewRelCompraPiezaToAttach.getClass(), relCompraPiezaListNewRelCompraPiezaToAttach.getIdrelCompraPiezas());
                attachedRelCompraPiezaListNew.add(relCompraPiezaListNewRelCompraPiezaToAttach);
            }
            relCompraPiezaListNew = attachedRelCompraPiezaListNew;
            pieza.setRelCompraPiezaList(relCompraPiezaListNew);
            pieza = em.merge(pieza);
            for (RelServicioPieza relServicioPiezaListNewRelServicioPieza : relServicioPiezaListNew) {
                if (!relServicioPiezaListOld.contains(relServicioPiezaListNewRelServicioPieza)) {
                    Pieza oldIdpieazaOfRelServicioPiezaListNewRelServicioPieza = relServicioPiezaListNewRelServicioPieza.getIdpieaza();
                    relServicioPiezaListNewRelServicioPieza.setIdpieaza(pieza);
                    relServicioPiezaListNewRelServicioPieza = em.merge(relServicioPiezaListNewRelServicioPieza);
                    if (oldIdpieazaOfRelServicioPiezaListNewRelServicioPieza != null && !oldIdpieazaOfRelServicioPiezaListNewRelServicioPieza.equals(pieza)) {
                        oldIdpieazaOfRelServicioPiezaListNewRelServicioPieza.getRelServicioPiezaList().remove(relServicioPiezaListNewRelServicioPieza);
                        oldIdpieazaOfRelServicioPiezaListNewRelServicioPieza = em.merge(oldIdpieazaOfRelServicioPiezaListNewRelServicioPieza);
                    }
                }
            }
            for (RelCompraPieza relCompraPiezaListNewRelCompraPieza : relCompraPiezaListNew) {
                if (!relCompraPiezaListOld.contains(relCompraPiezaListNewRelCompraPieza)) {
                    Pieza oldIdpiezaOfRelCompraPiezaListNewRelCompraPieza = relCompraPiezaListNewRelCompraPieza.getIdpieza();
                    relCompraPiezaListNewRelCompraPieza.setIdpieza(pieza);
                    relCompraPiezaListNewRelCompraPieza = em.merge(relCompraPiezaListNewRelCompraPieza);
                    if (oldIdpiezaOfRelCompraPiezaListNewRelCompraPieza != null && !oldIdpiezaOfRelCompraPiezaListNewRelCompraPieza.equals(pieza)) {
                        oldIdpiezaOfRelCompraPiezaListNewRelCompraPieza.getRelCompraPiezaList().remove(relCompraPiezaListNewRelCompraPieza);
                        oldIdpiezaOfRelCompraPiezaListNewRelCompraPieza = em.merge(oldIdpiezaOfRelCompraPiezaListNewRelCompraPieza);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pieza.getIdpieza();
                if (findPieza(id) == null) {
                    throw new NonexistentEntityException("The pieza with id " + id + " no longer exists.");
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
            Pieza pieza;
            try {
                pieza = em.getReference(Pieza.class, id);
                pieza.getIdpieza();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pieza with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<RelServicioPieza> relServicioPiezaListOrphanCheck = pieza.getRelServicioPiezaList();
            for (RelServicioPieza relServicioPiezaListOrphanCheckRelServicioPieza : relServicioPiezaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pieza (" + pieza + ") cannot be destroyed since the RelServicioPieza " + relServicioPiezaListOrphanCheckRelServicioPieza + " in its relServicioPiezaList field has a non-nullable idpieaza field.");
            }
            List<RelCompraPieza> relCompraPiezaListOrphanCheck = pieza.getRelCompraPiezaList();
            for (RelCompraPieza relCompraPiezaListOrphanCheckRelCompraPieza : relCompraPiezaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pieza (" + pieza + ") cannot be destroyed since the RelCompraPieza " + relCompraPiezaListOrphanCheckRelCompraPieza + " in its relCompraPiezaList field has a non-nullable idpieza field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(pieza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pieza> findPiezaEntities() {
        return findPiezaEntities(true, -1, -1);
    }

    public List<Pieza> findPiezaEntities(int maxResults, int firstResult) {
        return findPiezaEntities(false, maxResults, firstResult);
    }

    private List<Pieza> findPiezaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pieza.class));
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

    public Pieza findPieza(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pieza.class, id);
        } finally {
            em.close();
        }
    }

    public int getPiezaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pieza> rt = cq.from(Pieza.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
