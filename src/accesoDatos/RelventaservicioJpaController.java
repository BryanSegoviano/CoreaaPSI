/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import accesoDatos.exceptions.NonexistentEntityException;
import dominio.Relventaservicio;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Servicio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bryan
 */
public class RelventaservicioJpaController implements Serializable {

    public RelventaservicioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Relventaservicio relventaservicio) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio idservicio = relventaservicio.getIdservicio();
            if (idservicio != null) {
                idservicio = em.getReference(idservicio.getClass(), idservicio.getIdservicio());
                relventaservicio.setIdservicio(idservicio);
            }
            em.persist(relventaservicio);
            if (idservicio != null) {
                idservicio.getRelventaservicioList().add(relventaservicio);
                idservicio = em.merge(idservicio);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Relventaservicio relventaservicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relventaservicio persistentRelventaservicio = em.find(Relventaservicio.class, relventaservicio.getIdrelVentaServicio());
            Servicio idservicioOld = persistentRelventaservicio.getIdservicio();
            Servicio idservicioNew = relventaservicio.getIdservicio();
            if (idservicioNew != null) {
                idservicioNew = em.getReference(idservicioNew.getClass(), idservicioNew.getIdservicio());
                relventaservicio.setIdservicio(idservicioNew);
            }
            relventaservicio = em.merge(relventaservicio);
            if (idservicioOld != null && !idservicioOld.equals(idservicioNew)) {
                idservicioOld.getRelventaservicioList().remove(relventaservicio);
                idservicioOld = em.merge(idservicioOld);
            }
            if (idservicioNew != null && !idservicioNew.equals(idservicioOld)) {
                idservicioNew.getRelventaservicioList().add(relventaservicio);
                idservicioNew = em.merge(idservicioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = relventaservicio.getIdrelVentaServicio();
                if (findRelventaservicio(id) == null) {
                    throw new NonexistentEntityException("The relventaservicio with id " + id + " no longer exists.");
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
            Relventaservicio relventaservicio;
            try {
                relventaservicio = em.getReference(Relventaservicio.class, id);
                relventaservicio.getIdrelVentaServicio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relventaservicio with id " + id + " no longer exists.", enfe);
            }
            Servicio idservicio = relventaservicio.getIdservicio();
            if (idservicio != null) {
                idservicio.getRelventaservicioList().remove(relventaservicio);
                idservicio = em.merge(idservicio);
            }
            em.remove(relventaservicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Relventaservicio> findRelventaservicioEntities() {
        return findRelventaservicioEntities(true, -1, -1);
    }

    public List<Relventaservicio> findRelventaservicioEntities(int maxResults, int firstResult) {
        return findRelventaservicioEntities(false, maxResults, firstResult);
    }

    private List<Relventaservicio> findRelventaservicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Relventaservicio.class));
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

    public Relventaservicio findRelventaservicio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Relventaservicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelventaservicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Relventaservicio> rt = cq.from(Relventaservicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
