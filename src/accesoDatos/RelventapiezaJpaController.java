/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import accesoDatos.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Pieza;
import dominio.Relventapieza;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bryan
 */
public class RelventapiezaJpaController implements Serializable {

    public RelventapiezaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Relventapieza relventapieza) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pieza idpieza = relventapieza.getIdpieza();
            if (idpieza != null) {
                idpieza = em.getReference(idpieza.getClass(), idpieza.getIdpieza());
                relventapieza.setIdpieza(idpieza);
            }
            em.persist(relventapieza);
            if (idpieza != null) {
                idpieza.getRelventapiezaList().add(relventapieza);
                idpieza = em.merge(idpieza);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Relventapieza relventapieza) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relventapieza persistentRelventapieza = em.find(Relventapieza.class, relventapieza.getIdrelventapieza());
            Pieza idpiezaOld = persistentRelventapieza.getIdpieza();
            Pieza idpiezaNew = relventapieza.getIdpieza();
            if (idpiezaNew != null) {
                idpiezaNew = em.getReference(idpiezaNew.getClass(), idpiezaNew.getIdpieza());
                relventapieza.setIdpieza(idpiezaNew);
            }
            relventapieza = em.merge(relventapieza);
            if (idpiezaOld != null && !idpiezaOld.equals(idpiezaNew)) {
                idpiezaOld.getRelventapiezaList().remove(relventapieza);
                idpiezaOld = em.merge(idpiezaOld);
            }
            if (idpiezaNew != null && !idpiezaNew.equals(idpiezaOld)) {
                idpiezaNew.getRelventapiezaList().add(relventapieza);
                idpiezaNew = em.merge(idpiezaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = relventapieza.getIdrelventapieza();
                if (findRelventapieza(id) == null) {
                    throw new NonexistentEntityException("The relventapieza with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relventapieza relventapieza;
            try {
                relventapieza = em.getReference(Relventapieza.class, id);
                relventapieza.getIdrelventapieza();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relventapieza with id " + id + " no longer exists.", enfe);
            }
            Pieza idpieza = relventapieza.getIdpieza();
            if (idpieza != null) {
                idpieza.getRelventapiezaList().remove(relventapieza);
                idpieza = em.merge(idpieza);
            }
            em.remove(relventapieza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Relventapieza> findRelventapiezaEntities() {
        return findRelventapiezaEntities(true, -1, -1);
    }

    public List<Relventapieza> findRelventapiezaEntities(int maxResults, int firstResult) {
        return findRelventapiezaEntities(false, maxResults, firstResult);
    }

    private List<Relventapieza> findRelventapiezaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Relventapieza.class));
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

    public Relventapieza findRelventapieza(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Relventapieza.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelventapiezaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Relventapieza> rt = cq.from(Relventapieza.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
