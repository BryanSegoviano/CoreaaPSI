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
import dominio.Venta;
import java.util.ArrayList;
import java.util.List;
import dominio.Cliente;
import dominio.Vehiculo;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bryan
 */
public class VehiculoJpaController implements Serializable {

    public VehiculoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CoreaaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Vehiculo vehiculo) {
        if (vehiculo.getVentaList() == null) {
            vehiculo.setVentaList(new ArrayList<Venta>());
        }
        if (vehiculo.getClienteList() == null) {
            vehiculo.setClienteList(new ArrayList<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Venta> attachedVentaList = new ArrayList<Venta>();
            for (Venta ventaListVentaToAttach : vehiculo.getVentaList()) {
                ventaListVentaToAttach = em.getReference(ventaListVentaToAttach.getClass(), ventaListVentaToAttach.getIdventa());
                attachedVentaList.add(ventaListVentaToAttach);
            }
            vehiculo.setVentaList(attachedVentaList);
            List<Cliente> attachedClienteList = new ArrayList<Cliente>();
            for (Cliente clienteListClienteToAttach : vehiculo.getClienteList()) {
                clienteListClienteToAttach = em.getReference(clienteListClienteToAttach.getClass(), clienteListClienteToAttach.getIdcliente());
                attachedClienteList.add(clienteListClienteToAttach);
            }
            vehiculo.setClienteList(attachedClienteList);
            em.persist(vehiculo);
            for (Venta ventaListVenta : vehiculo.getVentaList()) {
                Vehiculo oldIdvehiculoOfVentaListVenta = ventaListVenta.getIdvehiculo();
                ventaListVenta.setIdvehiculo(vehiculo);
                ventaListVenta = em.merge(ventaListVenta);
                if (oldIdvehiculoOfVentaListVenta != null) {
                    oldIdvehiculoOfVentaListVenta.getVentaList().remove(ventaListVenta);
                    oldIdvehiculoOfVentaListVenta = em.merge(oldIdvehiculoOfVentaListVenta);
                }
            }
            for (Cliente clienteListCliente : vehiculo.getClienteList()) {
                Vehiculo oldIdvehiculoOfClienteListCliente = clienteListCliente.getIdvehiculo();
                clienteListCliente.setIdvehiculo(vehiculo);
                clienteListCliente = em.merge(clienteListCliente);
                if (oldIdvehiculoOfClienteListCliente != null) {
                    oldIdvehiculoOfClienteListCliente.getClienteList().remove(clienteListCliente);
                    oldIdvehiculoOfClienteListCliente = em.merge(oldIdvehiculoOfClienteListCliente);
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
            List<Venta> ventaListOld = persistentVehiculo.getVentaList();
            List<Venta> ventaListNew = vehiculo.getVentaList();
            List<Cliente> clienteListOld = persistentVehiculo.getClienteList();
            List<Cliente> clienteListNew = vehiculo.getClienteList();
            List<String> illegalOrphanMessages = null;
            for (Venta ventaListOldVenta : ventaListOld) {
                if (!ventaListNew.contains(ventaListOldVenta)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Venta " + ventaListOldVenta + " since its idvehiculo field is not nullable.");
                }
            }
            for (Cliente clienteListOldCliente : clienteListOld) {
                if (!clienteListNew.contains(clienteListOldCliente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cliente " + clienteListOldCliente + " since its idvehiculo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Venta> attachedVentaListNew = new ArrayList<Venta>();
            for (Venta ventaListNewVentaToAttach : ventaListNew) {
                ventaListNewVentaToAttach = em.getReference(ventaListNewVentaToAttach.getClass(), ventaListNewVentaToAttach.getIdventa());
                attachedVentaListNew.add(ventaListNewVentaToAttach);
            }
            ventaListNew = attachedVentaListNew;
            vehiculo.setVentaList(ventaListNew);
            List<Cliente> attachedClienteListNew = new ArrayList<Cliente>();
            for (Cliente clienteListNewClienteToAttach : clienteListNew) {
                clienteListNewClienteToAttach = em.getReference(clienteListNewClienteToAttach.getClass(), clienteListNewClienteToAttach.getIdcliente());
                attachedClienteListNew.add(clienteListNewClienteToAttach);
            }
            clienteListNew = attachedClienteListNew;
            vehiculo.setClienteList(clienteListNew);
            vehiculo = em.merge(vehiculo);
            for (Venta ventaListNewVenta : ventaListNew) {
                if (!ventaListOld.contains(ventaListNewVenta)) {
                    Vehiculo oldIdvehiculoOfVentaListNewVenta = ventaListNewVenta.getIdvehiculo();
                    ventaListNewVenta.setIdvehiculo(vehiculo);
                    ventaListNewVenta = em.merge(ventaListNewVenta);
                    if (oldIdvehiculoOfVentaListNewVenta != null && !oldIdvehiculoOfVentaListNewVenta.equals(vehiculo)) {
                        oldIdvehiculoOfVentaListNewVenta.getVentaList().remove(ventaListNewVenta);
                        oldIdvehiculoOfVentaListNewVenta = em.merge(oldIdvehiculoOfVentaListNewVenta);
                    }
                }
            }
            for (Cliente clienteListNewCliente : clienteListNew) {
                if (!clienteListOld.contains(clienteListNewCliente)) {
                    Vehiculo oldIdvehiculoOfClienteListNewCliente = clienteListNewCliente.getIdvehiculo();
                    clienteListNewCliente.setIdvehiculo(vehiculo);
                    clienteListNewCliente = em.merge(clienteListNewCliente);
                    if (oldIdvehiculoOfClienteListNewCliente != null && !oldIdvehiculoOfClienteListNewCliente.equals(vehiculo)) {
                        oldIdvehiculoOfClienteListNewCliente.getClienteList().remove(clienteListNewCliente);
                        oldIdvehiculoOfClienteListNewCliente = em.merge(oldIdvehiculoOfClienteListNewCliente);
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
            List<Venta> ventaListOrphanCheck = vehiculo.getVentaList();
            for (Venta ventaListOrphanCheckVenta : ventaListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Vehiculo (" + vehiculo + ") cannot be destroyed since the Venta " + ventaListOrphanCheckVenta + " in its ventaList field has a non-nullable idvehiculo field.");
            }
            List<Cliente> clienteListOrphanCheck = vehiculo.getClienteList();
            for (Cliente clienteListOrphanCheckCliente : clienteListOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Vehiculo (" + vehiculo + ") cannot be destroyed since the Cliente " + clienteListOrphanCheckCliente + " in its clienteList field has a non-nullable idvehiculo field.");
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
