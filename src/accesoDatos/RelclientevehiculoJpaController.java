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
import dominio.Cliente;
import dominio.Relclientevehiculo;
import dominio.Vehiculo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bryan
 */
public class RelclientevehiculoJpaController implements Serializable {

    public RelclientevehiculoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Relclientevehiculo relclientevehiculo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente idcliente = relclientevehiculo.getIdcliente();
            if (idcliente != null) {
                idcliente = em.getReference(idcliente.getClass(), idcliente.getIdcliente());
                relclientevehiculo.setIdcliente(idcliente);
            }
            Vehiculo idvehiculo = relclientevehiculo.getIdvehiculo();
            if (idvehiculo != null) {
                idvehiculo = em.getReference(idvehiculo.getClass(), idvehiculo.getIdvehiculo());
                relclientevehiculo.setIdvehiculo(idvehiculo);
            }
            em.persist(relclientevehiculo);
            if (idcliente != null) {
                idcliente.getRelclientevehiculoList().add(relclientevehiculo);
                idcliente = em.merge(idcliente);
            }
            if (idvehiculo != null) {
                idvehiculo.getRelclientevehiculoList().add(relclientevehiculo);
                idvehiculo = em.merge(idvehiculo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Relclientevehiculo relclientevehiculo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Relclientevehiculo persistentRelclientevehiculo = em.find(Relclientevehiculo.class, relclientevehiculo.getIdrelclientevehiculo());
            Cliente idclienteOld = persistentRelclientevehiculo.getIdcliente();
            Cliente idclienteNew = relclientevehiculo.getIdcliente();
            Vehiculo idvehiculoOld = persistentRelclientevehiculo.getIdvehiculo();
            Vehiculo idvehiculoNew = relclientevehiculo.getIdvehiculo();
            if (idclienteNew != null) {
                idclienteNew = em.getReference(idclienteNew.getClass(), idclienteNew.getIdcliente());
                relclientevehiculo.setIdcliente(idclienteNew);
            }
            if (idvehiculoNew != null) {
                idvehiculoNew = em.getReference(idvehiculoNew.getClass(), idvehiculoNew.getIdvehiculo());
                relclientevehiculo.setIdvehiculo(idvehiculoNew);
            }
            relclientevehiculo = em.merge(relclientevehiculo);
            if (idclienteOld != null && !idclienteOld.equals(idclienteNew)) {
                idclienteOld.getRelclientevehiculoList().remove(relclientevehiculo);
                idclienteOld = em.merge(idclienteOld);
            }
            if (idclienteNew != null && !idclienteNew.equals(idclienteOld)) {
                idclienteNew.getRelclientevehiculoList().add(relclientevehiculo);
                idclienteNew = em.merge(idclienteNew);
            }
            if (idvehiculoOld != null && !idvehiculoOld.equals(idvehiculoNew)) {
                idvehiculoOld.getRelclientevehiculoList().remove(relclientevehiculo);
                idvehiculoOld = em.merge(idvehiculoOld);
            }
            if (idvehiculoNew != null && !idvehiculoNew.equals(idvehiculoOld)) {
                idvehiculoNew.getRelclientevehiculoList().add(relclientevehiculo);
                idvehiculoNew = em.merge(idvehiculoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = relclientevehiculo.getIdrelclientevehiculo();
                if (findRelclientevehiculo(id) == null) {
                    throw new NonexistentEntityException("The relclientevehiculo with id " + id + " no longer exists.");
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
            Relclientevehiculo relclientevehiculo;
            try {
                relclientevehiculo = em.getReference(Relclientevehiculo.class, id);
                relclientevehiculo.getIdrelclientevehiculo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relclientevehiculo with id " + id + " no longer exists.", enfe);
            }
            Cliente idcliente = relclientevehiculo.getIdcliente();
            if (idcliente != null) {
                idcliente.getRelclientevehiculoList().remove(relclientevehiculo);
                idcliente = em.merge(idcliente);
            }
            Vehiculo idvehiculo = relclientevehiculo.getIdvehiculo();
            if (idvehiculo != null) {
                idvehiculo.getRelclientevehiculoList().remove(relclientevehiculo);
                idvehiculo = em.merge(idvehiculo);
            }
            em.remove(relclientevehiculo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Relclientevehiculo> findRelclientevehiculoEntities() {
        return findRelclientevehiculoEntities(true, -1, -1);
    }

    public List<Relclientevehiculo> findRelclientevehiculoEntities(int maxResults, int firstResult) {
        return findRelclientevehiculoEntities(false, maxResults, firstResult);
    }

    private List<Relclientevehiculo> findRelclientevehiculoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Relclientevehiculo.class));
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

    public Relclientevehiculo findRelclientevehiculo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Relclientevehiculo.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelclientevehiculoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Relclientevehiculo> rt = cq.from(Relclientevehiculo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
