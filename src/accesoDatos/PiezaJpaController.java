/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import accesoDatos.exceptions.IllegalOrphanException;
import accesoDatos.exceptions.NonexistentEntityException;
import dominio.Pieza;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.RelCompraPieza;
import java.util.ArrayList;
import java.util.List;
import dominio.Relventapieza;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bryan
 */
public class PiezaJpaController implements Serializable {

    public PiezaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pieza pieza) {
        if (pieza.getRelCompraPiezaList() == null) {
            pieza.setRelCompraPiezaList(new ArrayList<RelCompraPieza>());
        }
        if (pieza.getRelventapiezaList() == null) {
            pieza.setRelventapiezaList(new ArrayList<Relventapieza>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<RelCompraPieza> attachedRelCompraPiezaList = new ArrayList<RelCompraPieza>();
            for (RelCompraPieza relCompraPiezaListRelCompraPiezaToAttach : pieza.getRelCompraPiezaList()) {
                relCompraPiezaListRelCompraPiezaToAttach = em.getReference(relCompraPiezaListRelCompraPiezaToAttach.getClass(), relCompraPiezaListRelCompraPiezaToAttach.getIdrelCompraPiezas());
                attachedRelCompraPiezaList.add(relCompraPiezaListRelCompraPiezaToAttach);
            }
            pieza.setRelCompraPiezaList(attachedRelCompraPiezaList);
            List<Relventapieza> attachedRelventapiezaList = new ArrayList<Relventapieza>();
            for (Relventapieza relventapiezaListRelventapiezaToAttach : pieza.getRelventapiezaList()) {
                relventapiezaListRelventapiezaToAttach = em.getReference(relventapiezaListRelventapiezaToAttach.getClass(), relventapiezaListRelventapiezaToAttach.getIdrelventapieza());
                attachedRelventapiezaList.add(relventapiezaListRelventapiezaToAttach);
            }
            pieza.setRelventapiezaList(attachedRelventapiezaList);
            em.persist(pieza);
            for (RelCompraPieza relCompraPiezaListRelCompraPieza : pieza.getRelCompraPiezaList()) {
                Pieza oldIdpiezaOfRelCompraPiezaListRelCompraPieza = relCompraPiezaListRelCompraPieza.getIdpieza();
                relCompraPiezaListRelCompraPieza.setIdpieza(pieza);
                relCompraPiezaListRelCompraPieza = em.merge(relCompraPiezaListRelCompraPieza);
                if (oldIdpiezaOfRelCompraPiezaListRelCompraPieza != null) {
                    oldIdpiezaOfRelCompraPiezaListRelCompraPieza.getRelCompraPiezaList().remove(relCompraPiezaListRelCompraPieza);
                    oldIdpiezaOfRelCompraPiezaListRelCompraPieza = em.merge(oldIdpiezaOfRelCompraPiezaListRelCompraPieza);
                }
            }
            for (Relventapieza relventapiezaListRelventapieza : pieza.getRelventapiezaList()) {
                Pieza oldIdpiezaOfRelventapiezaListRelventapieza = relventapiezaListRelventapieza.getIdpieza();
                relventapiezaListRelventapieza.setIdpieza(pieza);
                relventapiezaListRelventapieza = em.merge(relventapiezaListRelventapieza);
                if (oldIdpiezaOfRelventapiezaListRelventapieza != null) {
                    oldIdpiezaOfRelventapiezaListRelventapieza.getRelventapiezaList().remove(relventapiezaListRelventapieza);
                    oldIdpiezaOfRelventapiezaListRelventapieza = em.merge(oldIdpiezaOfRelventapiezaListRelventapieza);
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
            List<RelCompraPieza> relCompraPiezaListOld = persistentPieza.getRelCompraPiezaList();
            List<RelCompraPieza> relCompraPiezaListNew = pieza.getRelCompraPiezaList();
            List<Relventapieza> relventapiezaListOld = persistentPieza.getRelventapiezaList();
            List<Relventapieza> relventapiezaListNew = pieza.getRelventapiezaList();
            List<String> illegalOrphanMessages = null;
            for (RelCompraPieza relCompraPiezaListOldRelCompraPieza : relCompraPiezaListOld) {
                if (!relCompraPiezaListNew.contains(relCompraPiezaListOldRelCompraPieza)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RelCompraPieza " + relCompraPiezaListOldRelCompraPieza + " since its idpieza field is not nullable.");
                }
            }
            for (Relventapieza relventapiezaListOldRelventapieza : relventapiezaListOld) {
                if (!relventapiezaListNew.contains(relventapiezaListOldRelventapieza)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Relventapieza " + relventapiezaListOldRelventapieza + " since its idpieza field is not nullable.");
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
            pieza.setRelCompraPiezaList(relCompraPiezaListNew);
            List<Relventapieza> attachedRelventapiezaListNew = new ArrayList<Relventapieza>();
            for (Relventapieza relventapiezaListNewRelventapiezaToAttach : relventapiezaListNew) {
                relventapiezaListNewRelventapiezaToAttach = em.getReference(relventapiezaListNewRelventapiezaToAttach.getClass(), relventapiezaListNewRelventapiezaToAttach.getIdrelventapieza());
                attachedRelventapiezaListNew.add(relventapiezaListNewRelventapiezaToAttach);
            }
            relventapiezaListNew = attachedRelventapiezaListNew;
            pieza.setRelventapiezaList(relventapiezaListNew);
            pieza = em.merge(pieza);
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
            for (Relventapieza relventapiezaListNewRelventapieza : relventapiezaListNew) {
                if (!relventapiezaListOld.contains(relventapiezaListNewRelventapieza)) {
                    Pieza oldIdpiezaOfRelventapiezaListNewRelventapieza = relventapiezaListNewRelventapieza.getIdpieza();
                    relventapiezaListNewRelventapieza.setIdpieza(pieza);
                    relventapiezaListNewRelventapieza = em.merge(relventapiezaListNewRelventapieza);
                    if (oldIdpiezaOfRelventapiezaListNewRelventapieza != null && !oldIdpiezaOfRelventapiezaListNewRelventapieza.equals(pieza)) {
                        oldIdpiezaOfRelventapiezaListNewRelventapieza.getRelventapiezaList().remove(relventapiezaListNewRelventapieza);
                        oldIdpiezaOfRelventapiezaListNewRelventapieza = em.merge(oldIdpiezaOfRelventapiezaListNewRelventapieza);
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
            List<RelCompraPieza> relCompraPiezaListOrphanCheck = pieza.getRelCompraPiezaList();
            for (RelCompraPieza relCompraPiezaListOrphanCheckRelCompraPieza : relCompraPiezaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pieza (" + pieza + ") cannot be destroyed since the RelCompraPieza " + relCompraPiezaListOrphanCheckRelCompraPieza + " in its relCompraPiezaList field has a non-nullable idpieza field.");
            }
            List<Relventapieza> relventapiezaListOrphanCheck = pieza.getRelventapiezaList();
            for (Relventapieza relventapiezaListOrphanCheckRelventapieza : relventapiezaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pieza (" + pieza + ") cannot be destroyed since the Relventapieza " + relventapiezaListOrphanCheckRelventapieza + " in its relventapiezaList field has a non-nullable idpieza field.");
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
