/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Cliente;
import dominio.Servicio;
import dominio.Vehiculo;
import dominio.Venta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bryan
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CoreaaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente idcliente = venta.getIdcliente();
            if (idcliente != null) {
                idcliente = em.getReference(idcliente.getClass(), idcliente.getIdcliente());
                venta.setIdcliente(idcliente);
            }
            Servicio idservicios = venta.getIdservicios();
            if (idservicios != null) {
                idservicios = em.getReference(idservicios.getClass(), idservicios.getIdservicio());
                venta.setIdservicios(idservicios);
            }
            Vehiculo idvehiculo = venta.getIdvehiculo();
            if (idvehiculo != null) {
                idvehiculo = em.getReference(idvehiculo.getClass(), idvehiculo.getIdvehiculo());
                venta.setIdvehiculo(idvehiculo);
            }
            em.persist(venta);
            if (idcliente != null) {
                idcliente.getVentaList().add(venta);
                idcliente = em.merge(idcliente);
            }
            if (idservicios != null) {
                idservicios.getVentaList().add(venta);
                idservicios = em.merge(idservicios);
            }
            if (idvehiculo != null) {
                idvehiculo.getVentaList().add(venta);
                idvehiculo = em.merge(idvehiculo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getIdventa());
            Cliente idclienteOld = persistentVenta.getIdcliente();
            Cliente idclienteNew = venta.getIdcliente();
            Servicio idserviciosOld = persistentVenta.getIdservicios();
            Servicio idserviciosNew = venta.getIdservicios();
            Vehiculo idvehiculoOld = persistentVenta.getIdvehiculo();
            Vehiculo idvehiculoNew = venta.getIdvehiculo();
            if (idclienteNew != null) {
                idclienteNew = em.getReference(idclienteNew.getClass(), idclienteNew.getIdcliente());
                venta.setIdcliente(idclienteNew);
            }
            if (idserviciosNew != null) {
                idserviciosNew = em.getReference(idserviciosNew.getClass(), idserviciosNew.getIdservicio());
                venta.setIdservicios(idserviciosNew);
            }
            if (idvehiculoNew != null) {
                idvehiculoNew = em.getReference(idvehiculoNew.getClass(), idvehiculoNew.getIdvehiculo());
                venta.setIdvehiculo(idvehiculoNew);
            }
            venta = em.merge(venta);
            if (idclienteOld != null && !idclienteOld.equals(idclienteNew)) {
                idclienteOld.getVentaList().remove(venta);
                idclienteOld = em.merge(idclienteOld);
            }
            if (idclienteNew != null && !idclienteNew.equals(idclienteOld)) {
                idclienteNew.getVentaList().add(venta);
                idclienteNew = em.merge(idclienteNew);
            }
            if (idserviciosOld != null && !idserviciosOld.equals(idserviciosNew)) {
                idserviciosOld.getVentaList().remove(venta);
                idserviciosOld = em.merge(idserviciosOld);
            }
            if (idserviciosNew != null && !idserviciosNew.equals(idserviciosOld)) {
                idserviciosNew.getVentaList().add(venta);
                idserviciosNew = em.merge(idserviciosNew);
            }
            if (idvehiculoOld != null && !idvehiculoOld.equals(idvehiculoNew)) {
                idvehiculoOld.getVentaList().remove(venta);
                idvehiculoOld = em.merge(idvehiculoOld);
            }
            if (idvehiculoNew != null && !idvehiculoNew.equals(idvehiculoOld)) {
                idvehiculoNew.getVentaList().add(venta);
                idvehiculoNew = em.merge(idvehiculoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = venta.getIdventa();
                if (findVenta(id) == null) {
                    throw new NonexistentEntityException("The venta with id " + id + " no longer exists.");
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
            Venta venta;
            try {
                venta = em.getReference(Venta.class, id);
                venta.getIdventa();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The venta with id " + id + " no longer exists.", enfe);
            }
            Cliente idcliente = venta.getIdcliente();
            if (idcliente != null) {
                idcliente.getVentaList().remove(venta);
                idcliente = em.merge(idcliente);
            }
            Servicio idservicios = venta.getIdservicios();
            if (idservicios != null) {
                idservicios.getVentaList().remove(venta);
                idservicios = em.merge(idservicios);
            }
            Vehiculo idvehiculo = venta.getIdvehiculo();
            if (idvehiculo != null) {
                idvehiculo.getVentaList().remove(venta);
                idvehiculo = em.merge(idvehiculo);
            }
            em.remove(venta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Venta> findVentaEntities() {
        return findVentaEntities(true, -1, -1);
    }

    public List<Venta> findVentaEntities(int maxResults, int firstResult) {
        return findVentaEntities(false, maxResults, firstResult);
    }

    private List<Venta> findVentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Venta.class));
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

    public Venta findVenta(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Venta.class, id);
        } finally {
            em.close();
        }
    }

    public int getVentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Venta> rt = cq.from(Venta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
