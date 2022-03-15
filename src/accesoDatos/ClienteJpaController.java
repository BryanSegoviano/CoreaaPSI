/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoDatos;

import accesoDatos.exceptions.IllegalOrphanException;
import accesoDatos.exceptions.NonexistentEntityException;
import dominio.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Relclientevehiculo;
import java.util.ArrayList;
import java.util.List;
import dominio.Venta;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bryan
 */
public class ClienteJpaController implements Serializable {

    public ClienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cliente cliente) {
        if (cliente.getRelclientevehiculoList() == null) {
            cliente.setRelclientevehiculoList(new ArrayList<Relclientevehiculo>());
        }
        if (cliente.getVentaList() == null) {
            cliente.setVentaList(new ArrayList<Venta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Relclientevehiculo> attachedRelclientevehiculoList = new ArrayList<Relclientevehiculo>();
            for (Relclientevehiculo relclientevehiculoListRelclientevehiculoToAttach : cliente.getRelclientevehiculoList()) {
                relclientevehiculoListRelclientevehiculoToAttach = em.getReference(relclientevehiculoListRelclientevehiculoToAttach.getClass(), relclientevehiculoListRelclientevehiculoToAttach.getIdrelclientevehiculo());
                attachedRelclientevehiculoList.add(relclientevehiculoListRelclientevehiculoToAttach);
            }
            cliente.setRelclientevehiculoList(attachedRelclientevehiculoList);
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : cliente.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getIdventa());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            cliente.setVentaList(attachedVentaList);
            em.persist(cliente);
            for (Relclientevehiculo relclientevehiculoListRelclientevehiculo : cliente.getRelclientevehiculoList()) {
                Cliente oldIdclienteOfRelclientevehiculoListRelclientevehiculo = relclientevehiculoListRelclientevehiculo.getIdcliente();
                relclientevehiculoListRelclientevehiculo.setIdcliente(cliente);
                relclientevehiculoListRelclientevehiculo = em.merge(relclientevehiculoListRelclientevehiculo);
                if (oldIdclienteOfRelclientevehiculoListRelclientevehiculo != null) {
                    oldIdclienteOfRelclientevehiculoListRelclientevehiculo.getRelclientevehiculoList().remove(relclientevehiculoListRelclientevehiculo);
                    oldIdclienteOfRelclientevehiculoListRelclientevehiculo = em.merge(oldIdclienteOfRelclientevehiculoListRelclientevehiculo);
                }
            }
            for (Venta ventaListVenta : cliente.getVentaList()) {
                Cliente oldIdclienteOfVentaListVenta = ventaListVenta.getIdcliente();
                ventaListVenta.setIdcliente(cliente);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldIdclienteOfVentaListVenta != null) {
                    oldIdclienteOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldIdclienteOfVentaListVenta = em.merge(oldIdclienteOfVentaListVenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cliente cliente) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente persistentCliente = em.find(Cliente.class, cliente.getIdcliente());
            List<Relclientevehiculo> relclientevehiculoListOld = persistentCliente.getRelclientevehiculoList();
            List<Relclientevehiculo> relclientevehiculoListNew = cliente.getRelclientevehiculoList();
            List<Venta> ventaListOld = persistentCliente.getVentaList();
            List<Venta> ventaListNew = cliente.getVentaList();
            List<String> illegalOrphanMessages = null;
            for (Relclientevehiculo relclientevehiculoListOldRelclientevehiculo : relclientevehiculoListOld) {
                if (!relclientevehiculoListNew.contains(relclientevehiculoListOldRelclientevehiculo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Relclientevehiculo " + relclientevehiculoListOldRelclientevehiculo + " since its idcliente field is not nullable.");
                }
            }
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + ventaListOldVenta + " since its idcliente field is not nullable.");
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
            cliente.setRelclientevehiculoList(relclientevehiculoListNew);
            List<Venta> attachedVentaListNew = new ArrayList<Venta>();
            for (Venta ventaListNewVentaToAttach : ventaListNew) {
                ventaListNewVentaToAttach = em.getReference(ventaListNewVentaToAttach.getClass(), ventaListNewVentaToAttach.getIdventa());
                attachedVentaListNew.add(ventaListNewVentaToAttach);
            }
            ventaListNew = attachedVentaListNew;
            cliente.setVentaList(ventaListNew);
            cliente = em.merge(cliente);
            for (Relclientevehiculo relclientevehiculoListNewRelclientevehiculo : relclientevehiculoListNew) {
                if (!relclientevehiculoListOld.contains(relclientevehiculoListNewRelclientevehiculo)) {
                    Cliente oldIdclienteOfRelclientevehiculoListNewRelclientevehiculo = relclientevehiculoListNewRelclientevehiculo.getIdcliente();
                    relclientevehiculoListNewRelclientevehiculo.setIdcliente(cliente);
                    relclientevehiculoListNewRelclientevehiculo = em.merge(relclientevehiculoListNewRelclientevehiculo);
                    if (oldIdclienteOfRelclientevehiculoListNewRelclientevehiculo != null && !oldIdclienteOfRelclientevehiculoListNewRelclientevehiculo.equals(cliente)) {
                        oldIdclienteOfRelclientevehiculoListNewRelclientevehiculo.getRelclientevehiculoList().remove(relclientevehiculoListNewRelclientevehiculo);
                        oldIdclienteOfRelclientevehiculoListNewRelclientevehiculo = em.merge(oldIdclienteOfRelclientevehiculoListNewRelclientevehiculo);
                    }
                }
            }
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Cliente oldIdclienteOfVentaListNewVenta = ventaListNewVenta.getIdcliente();
                    ventaListNewVenta.setIdcliente(cliente);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldIdclienteOfVentaListNewVenta != null && !oldIdclienteOfVentaListNewVenta.equals(cliente)) {
                        oldIdclienteOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldIdclienteOfVentaListNewVenta = em.merge(oldIdclienteOfVentaListNewVenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = cliente.getIdcliente();
                if (findCliente(id) == null) {
                    throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.");
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
            Cliente cliente;
            try {
                cliente = em.getReference(Cliente.class, id);
                cliente.getIdcliente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cliente with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Relclientevehiculo> relclientevehiculoListOrphanCheck = cliente.getRelclientevehiculoList();
            for (Relclientevehiculo relclientevehiculoListOrphanCheckRelclientevehiculo : relclientevehiculoListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Relclientevehiculo " + relclientevehiculoListOrphanCheckRelclientevehiculo + " in its relclientevehiculoList field has a non-nullable idcliente field.");
            }
            List<Venta> ventaListOrphanCheck = cliente.getVentaList();
            for (Venta ventaListOrphanCheckVenta : ventaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Cliente (" + cliente + ") cannot be destroyed since the Venta " + ventaListOrphanCheckVenta + " in its ventaList field has a non-nullable idcliente field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(cliente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cliente> findClienteEntities() {
        return findClienteEntities(true, -1, -1);
    }

    public List<Cliente> findClienteEntities(int maxResults, int firstResult) {
        return findClienteEntities(false, maxResults, firstResult);
    }

    private List<Cliente> findClienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cliente.class));
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

    public Cliente findCliente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cliente.class, id);
        } finally {
            em.close();
        }
    }

    public int getClienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cliente> rt = cq.from(Cliente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
