/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import controladores.exceptions.IllegalOrphanException;
import controladores.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.RelServicioPieza;
import dominio.Servicio;
import java.util.ArrayList;
import java.util.List;
import dominio.Venta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bryan
 */
public class ServicioJpaController implements Serializable {

    public ServicioJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CoreaaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicio servicio) {
        if (servicio.getRelServicioPiezaList() == null) {
            servicio.setRelServicioPiezaList(new ArrayList<RelServicioPieza>());
        }
        if (servicio.getVentaList() == null) {
            servicio.setVentaList(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<RelServicioPieza> attachedRelServicioPiezaList = new ArrayList<RelServicioPieza>();
            for (RelServicioPieza relServicioPiezaListRelServicioPiezaToAttach : servicio.getRelServicioPiezaList()) {
                relServicioPiezaListRelServicioPiezaToAttach = em.getReference(relServicioPiezaListRelServicioPiezaToAttach.getClass(), relServicioPiezaListRelServicioPiezaToAttach.getIdrelServicioPieza());
                attachedRelServicioPiezaList.add(relServicioPiezaListRelServicioPiezaToAttach);
            }
            servicio.setRelServicioPiezaList(attachedRelServicioPiezaList);
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : servicio.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getIdventa());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            servicio.setVentaList(attachedVentaList);
            em.persist(servicio);
            for (RelServicioPieza relServicioPiezaListRelServicioPieza : servicio.getRelServicioPiezaList()) {
                Servicio oldIdservicioOfRelServicioPiezaListRelServicioPieza = relServicioPiezaListRelServicioPieza.getIdservicio();
                relServicioPiezaListRelServicioPieza.setIdservicio(servicio);
                relServicioPiezaListRelServicioPieza = em.merge(relServicioPiezaListRelServicioPieza);
                if (oldIdservicioOfRelServicioPiezaListRelServicioPieza != null) {
                    oldIdservicioOfRelServicioPiezaListRelServicioPieza.getRelServicioPiezaList().remove(relServicioPiezaListRelServicioPieza);
                    oldIdservicioOfRelServicioPiezaListRelServicioPieza = em.merge(oldIdservicioOfRelServicioPiezaListRelServicioPieza);
                }
            }
            for (Venta ventaListVenta : servicio.getVentaList()) {
                Servicio oldIdserviciosOfVentaListVenta = ventaListVenta.getIdservicios();
                ventaListVenta.setIdservicios(servicio);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldIdserviciosOfVentaListVenta != null) {
                    oldIdserviciosOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldIdserviciosOfVentaListVenta = em.merge(oldIdserviciosOfVentaListVenta);
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
            List<RelServicioPieza> relServicioPiezaListOld = persistentServicio.getRelServicioPiezaList();
            List<RelServicioPieza> relServicioPiezaListNew = servicio.getRelServicioPiezaList();
            List<Venta> ventaListOld = persistentServicio.getVentaList();
            List<Venta> ventaListNew = servicio.getVentaList();
            List<String> illegalOrphanMessages = null;
            for (RelServicioPieza relServicioPiezaListOldRelServicioPieza : relServicioPiezaListOld) {
                if (!relServicioPiezaListNew.contains(relServicioPiezaListOldRelServicioPieza)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain RelServicioPieza " + relServicioPiezaListOldRelServicioPieza + " since its idservicio field is not nullable.");
                }
            }
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + ventaListOldVenta + " since its idservicios field is not nullable.");
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
            servicio.setRelServicioPiezaList(relServicioPiezaListNew);
            List<Venta> attachedVentaListNew = new ArrayList<Venta>();
            for (Venta ventaListNewVentaToAttach : ventaListNew) {
                ventaListNewVentaToAttach = em.getReference(ventaListNewVentaToAttach.getClass(), ventaListNewVentaToAttach.getIdventa());
                attachedVentaListNew.add(ventaListNewVentaToAttach);
            }
            ventaListNew = attachedVentaListNew;
            servicio.setVentaList(ventaListNew);
            servicio = em.merge(servicio);
            for (RelServicioPieza relServicioPiezaListNewRelServicioPieza : relServicioPiezaListNew) {
                if (!relServicioPiezaListOld.contains(relServicioPiezaListNewRelServicioPieza)) {
                    Servicio oldIdservicioOfRelServicioPiezaListNewRelServicioPieza = relServicioPiezaListNewRelServicioPieza.getIdservicio();
                    relServicioPiezaListNewRelServicioPieza.setIdservicio(servicio);
                    relServicioPiezaListNewRelServicioPieza = em.merge(relServicioPiezaListNewRelServicioPieza);
                    if (oldIdservicioOfRelServicioPiezaListNewRelServicioPieza != null && !oldIdservicioOfRelServicioPiezaListNewRelServicioPieza.equals(servicio)) {
                        oldIdservicioOfRelServicioPiezaListNewRelServicioPieza.getRelServicioPiezaList().remove(relServicioPiezaListNewRelServicioPieza);
                        oldIdservicioOfRelServicioPiezaListNewRelServicioPieza = em.merge(oldIdservicioOfRelServicioPiezaListNewRelServicioPieza);
                    }
                }
            }
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Servicio oldIdserviciosOfVentaListNewVenta = ventaListNewVenta.getIdservicios();
                    ventaListNewVenta.setIdservicios(servicio);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldIdserviciosOfVentaListNewVenta != null && !oldIdserviciosOfVentaListNewVenta.equals(servicio)) {
                        oldIdserviciosOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldIdserviciosOfVentaListNewVenta = em.merge(oldIdserviciosOfVentaListNewVenta);
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
            List<RelServicioPieza> relServicioPiezaListOrphanCheck = servicio.getRelServicioPiezaList();
            for (RelServicioPieza relServicioPiezaListOrphanCheckRelServicioPieza : relServicioPiezaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Servicio (" + servicio + ") cannot be destroyed since the RelServicioPieza " + relServicioPiezaListOrphanCheckRelServicioPieza + " in its relServicioPiezaList field has a non-nullable idservicio field.");
            }
            List<Venta> ventaListOrphanCheck = servicio.getVentaList();
            for (Venta ventaListOrphanCheckVenta : ventaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Servicio (" + servicio + ") cannot be destroyed since the Venta " + ventaListOrphanCheckVenta + " in its ventaList field has a non-nullable idservicios field.");
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
