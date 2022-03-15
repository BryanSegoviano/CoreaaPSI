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
import dominio.Cliente;
import dominio.Relventaservicio;
import java.util.ArrayList;
import java.util.List;
import dominio.Relventapieza;
import dominio.Venta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bryan
 */
public class VentaJpaController implements Serializable {

    public VentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Venta venta) {
        if (venta.getRelventaservicioList() == null) {
            venta.setRelventaservicioList(new ArrayList<Relventaservicio>());
        }
        if (venta.getRelventapiezaList() == null) {
            venta.setRelventapiezaList(new ArrayList<Relventapieza>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente idcliente = venta.getIdcliente();
            if (idcliente != null) {
                idcliente = em.getReference(idcliente.getClass(), idcliente.getIdcliente());
                venta.setIdcliente(idcliente);
            }
            List<Relventaservicio> attachedRelventaservicioList = new ArrayList<Relventaservicio>();
            for (Relventaservicio relventaservicioListRelventaservicioToAttach : venta.getRelventaservicioList()) {
                relventaservicioListRelventaservicioToAttach = em.getReference(relventaservicioListRelventaservicioToAttach.getClass(), relventaservicioListRelventaservicioToAttach.getIdrelVentaServicio());
                attachedRelventaservicioList.add(relventaservicioListRelventaservicioToAttach);
            }
            venta.setRelventaservicioList(attachedRelventaservicioList);
            List<Relventapieza> attachedRelventapiezaList = new ArrayList<Relventapieza>();
            for (Relventapieza relventapiezaListRelventapiezaToAttach : venta.getRelventapiezaList()) {
                relventapiezaListRelventapiezaToAttach = em.getReference(relventapiezaListRelventapiezaToAttach.getClass(), relventapiezaListRelventapiezaToAttach.getIdrelventapieza());
                attachedRelventapiezaList.add(relventapiezaListRelventapiezaToAttach);
            }
            venta.setRelventapiezaList(attachedRelventapiezaList);
            em.persist(venta);
            if (idcliente != null) {
                idcliente.getVentaList().add(venta);
                idcliente = em.merge(idcliente);
            }
            for (Relventaservicio relventaservicioListRelventaservicio : venta.getRelventaservicioList()) {
                Venta oldIdventaOfRelventaservicioListRelventaservicio = relventaservicioListRelventaservicio.getIdventa();
                relventaservicioListRelventaservicio.setIdventa(venta);
                relventaservicioListRelventaservicio = em.merge(relventaservicioListRelventaservicio);
                if (oldIdventaOfRelventaservicioListRelventaservicio != null) {
                    oldIdventaOfRelventaservicioListRelventaservicio.getRelventaservicioList().remove(relventaservicioListRelventaservicio);
                    oldIdventaOfRelventaservicioListRelventaservicio = em.merge(oldIdventaOfRelventaservicioListRelventaservicio);
                }
            }
            for (Relventapieza relventapiezaListRelventapieza : venta.getRelventapiezaList()) {
                Venta oldIdventaOfRelventapiezaListRelventapieza = relventapiezaListRelventapieza.getIdventa();
                relventapiezaListRelventapieza.setIdventa(venta);
                relventapiezaListRelventapieza = em.merge(relventapiezaListRelventapieza);
                if (oldIdventaOfRelventapiezaListRelventapieza != null) {
                    oldIdventaOfRelventapiezaListRelventapieza.getRelventapiezaList().remove(relventapiezaListRelventapieza);
                    oldIdventaOfRelventapiezaListRelventapieza = em.merge(oldIdventaOfRelventapiezaListRelventapieza);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Venta venta) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Venta persistentVenta = em.find(Venta.class, venta.getIdventa());
            Cliente idclienteOld = persistentVenta.getIdcliente();
            Cliente idclienteNew = venta.getIdcliente();
            List<Relventaservicio> relventaservicioListOld = persistentVenta.getRelventaservicioList();
            List<Relventaservicio> relventaservicioListNew = venta.getRelventaservicioList();
            List<Relventapieza> relventapiezaListOld = persistentVenta.getRelventapiezaList();
            List<Relventapieza> relventapiezaListNew = venta.getRelventapiezaList();
            List<String> illegalOrphanMessages = null;
            for (Relventaservicio relventaservicioListOldRelventaservicio : relventaservicioListOld) {
                if (!relventaservicioListNew.contains(relventaservicioListOldRelventaservicio)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Relventaservicio " + relventaservicioListOldRelventaservicio + " since its idventa field is not nullable.");
                }
            }
            for (Relventapieza relventapiezaListOldRelventapieza : relventapiezaListOld) {
                if (!relventapiezaListNew.contains(relventapiezaListOldRelventapieza)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Relventapieza " + relventapiezaListOldRelventapieza + " since its idventa field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idclienteNew != null) {
                idclienteNew = em.getReference(idclienteNew.getClass(), idclienteNew.getIdcliente());
                venta.setIdcliente(idclienteNew);
            }
            List<Relventaservicio> attachedRelventaservicioListNew = new ArrayList<Relventaservicio>();
            for (Relventaservicio relventaservicioListNewRelventaservicioToAttach : relventaservicioListNew) {
                relventaservicioListNewRelventaservicioToAttach = em.getReference(relventaservicioListNewRelventaservicioToAttach.getClass(), relventaservicioListNewRelventaservicioToAttach.getIdrelVentaServicio());
                attachedRelventaservicioListNew.add(relventaservicioListNewRelventaservicioToAttach);
            }
            relventaservicioListNew = attachedRelventaservicioListNew;
            venta.setRelventaservicioList(relventaservicioListNew);
            List<Relventapieza> attachedRelventapiezaListNew = new ArrayList<Relventapieza>();
            for (Relventapieza relventapiezaListNewRelventapiezaToAttach : relventapiezaListNew) {
                relventapiezaListNewRelventapiezaToAttach = em.getReference(relventapiezaListNewRelventapiezaToAttach.getClass(), relventapiezaListNewRelventapiezaToAttach.getIdrelventapieza());
                attachedRelventapiezaListNew.add(relventapiezaListNewRelventapiezaToAttach);
            }
            relventapiezaListNew = attachedRelventapiezaListNew;
            venta.setRelventapiezaList(relventapiezaListNew);
            venta = em.merge(venta);
            if (idclienteOld != null && !idclienteOld.equals(idclienteNew)) {
                idclienteOld.getVentaList().remove(venta);
                idclienteOld = em.merge(idclienteOld);
            }
            if (idclienteNew != null && !idclienteNew.equals(idclienteOld)) {
                idclienteNew.getVentaList().add(venta);
                idclienteNew = em.merge(idclienteNew);
            }
            for (Relventaservicio relventaservicioListNewRelventaservicio : relventaservicioListNew) {
                if (!relventaservicioListOld.contains(relventaservicioListNewRelventaservicio)) {
                    Venta oldIdventaOfRelventaservicioListNewRelventaservicio = relventaservicioListNewRelventaservicio.getIdventa();
                    relventaservicioListNewRelventaservicio.setIdventa(venta);
                    relventaservicioListNewRelventaservicio = em.merge(relventaservicioListNewRelventaservicio);
                    if (oldIdventaOfRelventaservicioListNewRelventaservicio != null && !oldIdventaOfRelventaservicioListNewRelventaservicio.equals(venta)) {
                        oldIdventaOfRelventaservicioListNewRelventaservicio.getRelventaservicioList().remove(relventaservicioListNewRelventaservicio);
                        oldIdventaOfRelventaservicioListNewRelventaservicio = em.merge(oldIdventaOfRelventaservicioListNewRelventaservicio);
                    }
                }
            }
            for (Relventapieza relventapiezaListNewRelventapieza : relventapiezaListNew) {
                if (!relventapiezaListOld.contains(relventapiezaListNewRelventapieza)) {
                    Venta oldIdventaOfRelventapiezaListNewRelventapieza = relventapiezaListNewRelventapieza.getIdventa();
                    relventapiezaListNewRelventapieza.setIdventa(venta);
                    relventapiezaListNewRelventapieza = em.merge(relventapiezaListNewRelventapieza);
                    if (oldIdventaOfRelventapiezaListNewRelventapieza != null && !oldIdventaOfRelventapiezaListNewRelventapieza.equals(venta)) {
                        oldIdventaOfRelventapiezaListNewRelventapieza.getRelventapiezaList().remove(relventapiezaListNewRelventapieza);
                        oldIdventaOfRelventapiezaListNewRelventapieza = em.merge(oldIdventaOfRelventapiezaListNewRelventapieza);
                    }
                }
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

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
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
            List<String> illegalOrphanMessages = null;
            List<Relventaservicio> relventaservicioListOrphanCheck = venta.getRelventaservicioList();
            for (Relventaservicio relventaservicioListOrphanCheckRelventaservicio : relventaservicioListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Venta (" + venta + ") cannot be destroyed since the Relventaservicio " + relventaservicioListOrphanCheckRelventaservicio + " in its relventaservicioList field has a non-nullable idventa field.");
            }
            List<Relventapieza> relventapiezaListOrphanCheck = venta.getRelventapiezaList();
            for (Relventapieza relventapiezaListOrphanCheckRelventapieza : relventapiezaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Venta (" + venta + ") cannot be destroyed since the Relventapieza " + relventapiezaListOrphanCheckRelventapieza + " in its relventapiezaList field has a non-nullable idventa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente idcliente = venta.getIdcliente();
            if (idcliente != null) {
                idcliente.getVentaList().remove(venta);
                idcliente = em.merge(idcliente);
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
