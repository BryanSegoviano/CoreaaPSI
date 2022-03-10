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
import dominio.Pieza;
import dominio.RelServicioPieza;
import dominio.Servicio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author bryan
 */
public class RelServicioPiezaJpaController implements Serializable {

    public RelServicioPiezaJpaController() {
        this.emf = Persistence.createEntityManagerFactory("CoreaaPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RelServicioPieza relServicioPieza) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pieza idpieaza = relServicioPieza.getIdpieaza();
            if (idpieaza != null) {
                idpieaza = em.getReference(idpieaza.getClass(), idpieaza.getIdpieza());
                relServicioPieza.setIdpieaza(idpieaza);
            }
            Servicio idservicio = relServicioPieza.getIdservicio();
            if (idservicio != null) {
                idservicio = em.getReference(idservicio.getClass(), idservicio.getIdservicio());
                relServicioPieza.setIdservicio(idservicio);
            }
            em.persist(relServicioPieza);
            if (idpieaza != null) {
                idpieaza.getRelServicioPiezaList().add(relServicioPieza);
                idpieaza = em.merge(idpieaza);
            }
            if (idservicio != null) {
                idservicio.getRelServicioPiezaList().add(relServicioPieza);
                idservicio = em.merge(idservicio);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RelServicioPieza relServicioPieza) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            RelServicioPieza persistentRelServicioPieza = em.find(RelServicioPieza.class, relServicioPieza.getIdrelServicioPieza());
            Pieza idpieazaOld = persistentRelServicioPieza.getIdpieaza();
            Pieza idpieazaNew = relServicioPieza.getIdpieaza();
            Servicio idservicioOld = persistentRelServicioPieza.getIdservicio();
            Servicio idservicioNew = relServicioPieza.getIdservicio();
            if (idpieazaNew != null) {
                idpieazaNew = em.getReference(idpieazaNew.getClass(), idpieazaNew.getIdpieza());
                relServicioPieza.setIdpieaza(idpieazaNew);
            }
            if (idservicioNew != null) {
                idservicioNew = em.getReference(idservicioNew.getClass(), idservicioNew.getIdservicio());
                relServicioPieza.setIdservicio(idservicioNew);
            }
            relServicioPieza = em.merge(relServicioPieza);
            if (idpieazaOld != null && !idpieazaOld.equals(idpieazaNew)) {
                idpieazaOld.getRelServicioPiezaList().remove(relServicioPieza);
                idpieazaOld = em.merge(idpieazaOld);
            }
            if (idpieazaNew != null && !idpieazaNew.equals(idpieazaOld)) {
                idpieazaNew.getRelServicioPiezaList().add(relServicioPieza);
                idpieazaNew = em.merge(idpieazaNew);
            }
            if (idservicioOld != null && !idservicioOld.equals(idservicioNew)) {
                idservicioOld.getRelServicioPiezaList().remove(relServicioPieza);
                idservicioOld = em.merge(idservicioOld);
            }
            if (idservicioNew != null && !idservicioNew.equals(idservicioOld)) {
                idservicioNew.getRelServicioPiezaList().add(relServicioPieza);
                idservicioNew = em.merge(idservicioNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = relServicioPieza.getIdrelServicioPieza();
                if (findRelServicioPieza(id) == null) {
                    throw new NonexistentEntityException("The relServicioPieza with id " + id + " no longer exists.");
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
            RelServicioPieza relServicioPieza;
            try {
                relServicioPieza = em.getReference(RelServicioPieza.class, id);
                relServicioPieza.getIdrelServicioPieza();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The relServicioPieza with id " + id + " no longer exists.", enfe);
            }
            Pieza idpieaza = relServicioPieza.getIdpieaza();
            if (idpieaza != null) {
                idpieaza.getRelServicioPiezaList().remove(relServicioPieza);
                idpieaza = em.merge(idpieaza);
            }
            Servicio idservicio = relServicioPieza.getIdservicio();
            if (idservicio != null) {
                idservicio.getRelServicioPiezaList().remove(relServicioPieza);
                idservicio = em.merge(idservicio);
            }
            em.remove(relServicioPieza);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RelServicioPieza> findRelServicioPiezaEntities() {
        return findRelServicioPiezaEntities(true, -1, -1);
    }

    public List<RelServicioPieza> findRelServicioPiezaEntities(int maxResults, int firstResult) {
        return findRelServicioPiezaEntities(false, maxResults, firstResult);
    }

    private List<RelServicioPieza> findRelServicioPiezaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RelServicioPieza.class));
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

    public RelServicioPieza findRelServicioPieza(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RelServicioPieza.class, id);
        } finally {
            em.close();
        }
    }

    public int getRelServicioPiezaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RelServicioPieza> rt = cq.from(RelServicioPieza.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
