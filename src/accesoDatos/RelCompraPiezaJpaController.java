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
import dominio.Compra;
import dominio.Pieza;
import dominio.RelCompraPieza;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author bryan
 */
public class RelCompraPiezaJpaController implements Serializable {

    public RelCompraPiezaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RelCompraPieza relCompraPieza) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Compra idcompra = relCompraPieza.getIdcompra();
            if (idcompra != null) {
                idcompra = em.getReference(idcompra.getClass(), idcompra.getIdcompra());
                relCompraPieza.setIdcompra(idcompra);
            }
            Pieza idpieza = relCompraPieza.getIdpieza();
            if (idpieza != null) {
                idpieza = em.getReference(idpieza.getClass(), idpieza.getIdpieza());
                relCompraPieza.setIdpieza(idpieza);
            }
            em.persist(relCompraPieza);
            if (idcompra != null) {
                idcompra.getRelCompraPiezaList().add(relCompraPieza);
                idcompra = em.merge(idcompra);
            }
            if (idpieza != null) {
                idpieza.getRelCompraPiezaList().add(relCompraPieza);
                idpieza = em.merge(idpieza);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RelCompraPieza relCompraPieza) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RelCompraPieza persistentRelCompraPieza = em.find(RelCompraPieza.class, relCompraPieza.getIdrelCompraPiezas());
            Compra idcompraOld = persistentRelCompraPieza.getIdcompra();
            Compra idcompraNew = relCompraPieza.getIdcompra();
            Pieza idpiezaOld = persistentRelCompraPieza.getIdpieza();
            Pieza idpiezaNew = relCompraPieza.getIdpieza();
            if (idcompraNew != null) {
                idcompraNew = em.getReference(idcompraNew.getClass(), idcompraNew.getIdcompra());
                relCompraPieza.setIdcompra(idcompraNew);
            }
            if (idpiezaNew != null) {
                idpiezaNew = em.getReference(idpiezaNew.getClass(), idpiezaNew.getIdpieza());
                relCompraPieza.setIdpieza(idpiezaNew);
            }
            relCompraPieza = em.merge(relCompraPieza);
            if (idcompraOld != null && !idcompraOld.equals(idcompraNew)) {
                idcompraOld.getRelCompraPiezaList().remove(relCompraPieza);
                idcompraOld = em.merge(idcompraOld);
            }
            if (idcompraNew != null && !idcompraNew.equals(idcompraOld)) {
                idcompraNew.getRelCompraPiezaList().add(relCompraPieza);
                idcompraNew = em.merge(idcompraNew);
            }
            if (idpiezaOld != null && !idpiezaOld.equals(idpiezaNew)) {
                idpiezaOld.getRelCompraPiezaList().remove(relCompraPieza);
                idpiezaOld = em.merge(idpiezaOld);
            }
            if (idpiezaNew != null && !idpiezaNew.equals(idpiezaOld)) {
                idpiezaNew.getRelCompraPiezaList().add(relCompraPieza);
                idpiezaNew = em.merge(idpiezaNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = relCompraPieza.getIdrelCompraPiezas();
                if (findRelCompraPieza(id) == null) {
                    throw new NonexistentEntityException("The relCompraPieza with id " + id + " no longer exists.");
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
            RelCompraPieza relCompraPieza;
            try {
                relCompraPieza = em.getReference(RelCompraPieza.class, id);
                relCompraPieza.getIdrelCompraPiezas();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relCompraPieza with id " + id + " no longer exists.", enfe);
            }
            Compra idcompra = relCompraPieza.getIdcompra();
            if (idcompra != null) {
                idcompra.getRelCompraPiezaList().remove(relCompraPieza);
                idcompra = em.merge(idcompra);
            }
            Pieza idpieza = relCompraPieza.getIdpieza();
            if (idpieza != null) {
                idpieza.getRelCompraPiezaList().remove(relCompraPieza);
                idpieza = em.merge(idpieza);
            }
            em.remove(relCompraPieza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RelCompraPieza> findRelCompraPiezaEntities() {
        return findRelCompraPiezaEntities(true, -1, -1);
    }

    public List<RelCompraPieza> findRelCompraPiezaEntities(int maxResults, int firstResult) {
        return findRelCompraPiezaEntities(false, maxResults, firstResult);
    }

    private List<RelCompraPieza> findRelCompraPiezaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RelCompraPieza.class));
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

    public RelCompraPieza findRelCompraPieza(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RelCompraPieza.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelCompraPiezaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RelCompraPieza> rt = cq.from(RelCompraPieza.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
