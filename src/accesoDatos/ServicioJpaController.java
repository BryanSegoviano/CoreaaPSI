/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import accesoDatos.exceptions.IllegalOrphanException;
import accesoDatos.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Relventaservicio;
import dominio.Servicio;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bryan
 */
public class ServicioJpaController implements Serializable {

    public ServicioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicio servicio) {
        if (servicio.getRelventaservicioList() == null) {
            servicio.setRelventaservicioList(new ArrayList<Relventaservicio>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Relventaservicio> attachedRelventaservicioList = new ArrayList<Relventaservicio>();
            for (Relventaservicio relventaservicioListRelventaservicioToAttach : servicio.getRelventaservicioList()) {
                relventaservicioListRelventaservicioToAttach = em.getReference(relventaservicioListRelventaservicioToAttach.getClass(), relventaservicioListRelventaservicioToAttach.getIdrelVentaServicio());
                attachedRelventaservicioList.add(relventaservicioListRelventaservicioToAttach);
            }
            servicio.setRelventaservicioList(attachedRelventaservicioList);
            em.persist(servicio);
            for (Relventaservicio relventaservicioListRelventaservicio : servicio.getRelventaservicioList()) {
                Servicio oldIdservicioOfRelventaservicioListRelventaservicio = relventaservicioListRelventaservicio.getIdservicio();
                relventaservicioListRelventaservicio.setIdservicio(servicio);
                relventaservicioListRelventaservicio = em.merge(relventaservicioListRelventaservicio);
                if (oldIdservicioOfRelventaservicioListRelventaservicio != null) {
                    oldIdservicioOfRelventaservicioListRelventaservicio.getRelventaservicioList().remove(relventaservicioListRelventaservicio);
                    oldIdservicioOfRelventaservicioListRelventaservicio = em.merge(oldIdservicioOfRelventaservicioListRelventaservicio);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicio servicio) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio persistentServicio = em.find(Servicio.class, servicio.getIdservicio());
            List<Relventaservicio> relventaservicioListOld = persistentServicio.getRelventaservicioList();
            List<Relventaservicio> relventaservicioListNew = servicio.getRelventaservicioList();
            List<String> illegalOrphanMessages = null;
            for (Relventaservicio relventaservicioListOldRelventaservicio : relventaservicioListOld) {
                if (!relventaservicioListNew.contains(relventaservicioListOldRelventaservicio)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Relventaservicio " + relventaservicioListOldRelventaservicio + " since its idservicio field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Relventaservicio> attachedRelventaservicioListNew = new ArrayList<Relventaservicio>();
            for (Relventaservicio relventaservicioListNewRelventaservicioToAttach : relventaservicioListNew) {
                relventaservicioListNewRelventaservicioToAttach = em.getReference(relventaservicioListNewRelventaservicioToAttach.getClass(), relventaservicioListNewRelventaservicioToAttach.getIdrelVentaServicio());
                attachedRelventaservicioListNew.add(relventaservicioListNewRelventaservicioToAttach);
            }
            relventaservicioListNew = attachedRelventaservicioListNew;
            servicio.setRelventaservicioList(relventaservicioListNew);
            servicio = em.merge(servicio);
            for (Relventaservicio relventaservicioListNewRelventaservicio : relventaservicioListNew) {
                if (!relventaservicioListOld.contains(relventaservicioListNewRelventaservicio)) {
                    Servicio oldIdservicioOfRelventaservicioListNewRelventaservicio = relventaservicioListNewRelventaservicio.getIdservicio();
                    relventaservicioListNewRelventaservicio.setIdservicio(servicio);
                    relventaservicioListNewRelventaservicio = em.merge(relventaservicioListNewRelventaservicio);
                    if (oldIdservicioOfRelventaservicioListNewRelventaservicio != null && !oldIdservicioOfRelventaservicioListNewRelventaservicio.equals(servicio)) {
                        oldIdservicioOfRelventaservicioListNewRelventaservicio.getRelventaservicioList().remove(relventaservicioListNewRelventaservicio);
                        oldIdservicioOfRelventaservicioListNewRelventaservicio = em.merge(oldIdservicioOfRelventaservicioListNewRelventaservicio);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = servicio.getIdservicio();
                if (findServicio(id) == null) {
                    throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.");
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
            Servicio servicio;
            try {
                servicio = em.getReference(Servicio.class, id);
                servicio.getIdservicio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Relventaservicio> relventaservicioListOrphanCheck = servicio.getRelventaservicioList();
            for (Relventaservicio relventaservicioListOrphanCheckRelventaservicio : relventaservicioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Servicio (" + servicio + ") cannot be destroyed since the Relventaservicio " + relventaservicioListOrphanCheckRelventaservicio + " in its relventaservicioList field has a non-nullable idservicio field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(servicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicio> findServicioEntities() {
        return findServicioEntities(true, -1, -1);
    }

    public List<Servicio> findServicioEntities(int maxResults, int firstResult) {
        return findServicioEntities(false, maxResults, firstResult);
    }

    private List<Servicio> findServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicio.class));
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

    public Servicio findServicio(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicio> rt = cq.from(Servicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
