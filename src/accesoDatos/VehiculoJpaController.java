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
import dominio.Relclientevehiculo;
import dominio.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bryan
 */
public class VehiculoJpaController implements Serializable {

    public VehiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vehiculo vehiculo) {
        if (vehiculo.getRelclientevehiculoList() == null) {
            vehiculo.setRelclientevehiculoList(new ArrayList<Relclientevehiculo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Relclientevehiculo> attachedRelclientevehiculoList = new ArrayList<Relclientevehiculo>();
            for (Relclientevehiculo relclientevehiculoListRelclientevehiculoToAttach : vehiculo.getRelclientevehiculoList()) {
                relclientevehiculoListRelclientevehiculoToAttach = em.getReference(relclientevehiculoListRelclientevehiculoToAttach.getClass(), relclientevehiculoListRelclientevehiculoToAttach.getIdrelclientevehiculo());
                attachedRelclientevehiculoList.add(relclientevehiculoListRelclientevehiculoToAttach);
            }
            vehiculo.setRelclientevehiculoList(attachedRelclientevehiculoList);
            em.persist(vehiculo);
            for (Relclientevehiculo relclientevehiculoListRelclientevehiculo : vehiculo.getRelclientevehiculoList()) {
                Vehiculo oldIdvehiculoOfRelclientevehiculoListRelclientevehiculo = relclientevehiculoListRelclientevehiculo.getIdvehiculo();
                relclientevehiculoListRelclientevehiculo.setIdvehiculo(vehiculo);
                relclientevehiculoListRelclientevehiculo = em.merge(relclientevehiculoListRelclientevehiculo);
                if (oldIdvehiculoOfRelclientevehiculoListRelclientevehiculo != null) {
                    oldIdvehiculoOfRelclientevehiculoListRelclientevehiculo.getRelclientevehiculoList().remove(relclientevehiculoListRelclientevehiculo);
                    oldIdvehiculoOfRelclientevehiculoListRelclientevehiculo = em.merge(oldIdvehiculoOfRelclientevehiculoListRelclientevehiculo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Vehiculo vehiculo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Vehiculo persistentVehiculo = em.find(Vehiculo.class, vehiculo.getIdvehiculo());
            List<Relclientevehiculo> relclientevehiculoListOld = persistentVehiculo.getRelclientevehiculoList();
            List<Relclientevehiculo> relclientevehiculoListNew = vehiculo.getRelclientevehiculoList();
            List<String> illegalOrphanMessages = null;
            for (Relclientevehiculo relclientevehiculoListOldRelclientevehiculo : relclientevehiculoListOld) {
                if (!relclientevehiculoListNew.contains(relclientevehiculoListOldRelclientevehiculo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Relclientevehiculo " + relclientevehiculoListOldRelclientevehiculo + " since its idvehiculo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Relclientevehiculo> attachedRelclientevehiculoListNew = new ArrayList<Relclientevehiculo>();
            for (Relclientevehiculo relclientevehiculoListNewRelclientevehiculoToAttach : relclientevehiculoListNew) {
                relclientevehiculoListNewRelclientevehiculoToAttach = em.getReference(relclientevehiculoListNewRelclientevehiculoToAttach.getClass(), relclientevehiculoListNewRelclientevehiculoToAttach.getIdrelclientevehiculo());
                attachedRelclientevehiculoListNew.add(relclientevehiculoListNewRelclientevehiculoToAttach);
            }
            relclientevehiculoListNew = attachedRelclientevehiculoListNew;
            vehiculo.setRelclientevehiculoList(relclientevehiculoListNew);
            vehiculo = em.merge(vehiculo);
            for (Relclientevehiculo relclientevehiculoListNewRelclientevehiculo : relclientevehiculoListNew) {
                if (!relclientevehiculoListOld.contains(relclientevehiculoListNewRelclientevehiculo)) {
                    Vehiculo oldIdvehiculoOfRelclientevehiculoListNewRelclientevehiculo = relclientevehiculoListNewRelclientevehiculo.getIdvehiculo();
                    relclientevehiculoListNewRelclientevehiculo.setIdvehiculo(vehiculo);
                    relclientevehiculoListNewRelclientevehiculo = em.merge(relclientevehiculoListNewRelclientevehiculo);
                    if (oldIdvehiculoOfRelclientevehiculoListNewRelclientevehiculo != null && !oldIdvehiculoOfRelclientevehiculoListNewRelclientevehiculo.equals(vehiculo)) {
                        oldIdvehiculoOfRelclientevehiculoListNewRelclientevehiculo.getRelclientevehiculoList().remove(relclientevehiculoListNewRelclientevehiculo);
                        oldIdvehiculoOfRelclientevehiculoListNewRelclientevehiculo = em.merge(oldIdvehiculoOfRelclientevehiculoListNewRelclientevehiculo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = vehiculo.getIdvehiculo();
                if (findVehiculo(id) == null) {
                    throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.");
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
            Vehiculo vehiculo;
            try {
                vehiculo = em.getReference(Vehiculo.class, id);
                vehiculo.getIdvehiculo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The vehiculo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Relclientevehiculo> relclientevehiculoListOrphanCheck = vehiculo.getRelclientevehiculoList();
            for (Relclientevehiculo relclientevehiculoListOrphanCheckRelclientevehiculo : relclientevehiculoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Vehiculo (" + vehiculo + ") cannot be destroyed since the Relclientevehiculo " + relclientevehiculoListOrphanCheckRelclientevehiculo + " in its relclientevehiculoList field has a non-nullable idvehiculo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(vehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Vehiculo> findVehiculoEntities() {
        return findVehiculoEntities(true, -1, -1);
    }

    public List<Vehiculo> findVehiculoEntities(int maxResults, int firstResult) {
        return findVehiculoEntities(false, maxResults, firstResult);
    }

    private List<Vehiculo> findVehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Vehiculo.class));
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

    public Vehiculo findVehiculo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Vehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getVehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Vehiculo> rt = cq.from(Vehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
