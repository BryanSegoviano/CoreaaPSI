/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "rel_compra_piezas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelCompraPieza.findAll", query = "SELECT r FROM RelCompraPieza r"),
    @NamedQuery(name = "RelCompraPieza.findByIdrelCompraPiezas", query = "SELECT r FROM RelCompraPieza r WHERE r.idrelCompraPiezas = :idrelCompraPiezas"),
    @NamedQuery(name = "RelCompraPieza.findByCantidad", query = "SELECT r FROM RelCompraPieza r WHERE r.cantidad = :cantidad")})
public class RelCompraPieza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrel_compra_piezas")
    private Integer idrelCompraPiezas;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idcompra", referencedColumnName = "idcompra")
    @ManyToOne(optional = false)
    private Compra idcompra;
    @JoinColumn(name = "idpieza", referencedColumnName = "idpieza")
    @ManyToOne(optional = false)
    private Pieza idpieza;

    public RelCompraPieza() {
    }

    public RelCompraPieza(Integer idrelCompraPiezas) {
        this.idrelCompraPiezas = idrelCompraPiezas;
    }

    public RelCompraPieza(Integer idrelCompraPiezas, int cantidad) {
        this.idrelCompraPiezas = idrelCompraPiezas;
        this.cantidad = cantidad;
    }

    public Integer getIdrelCompraPiezas() {
        return idrelCompraPiezas;
    }

    public void setIdrelCompraPiezas(Integer idrelCompraPiezas) {
        this.idrelCompraPiezas = idrelCompraPiezas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Compra getIdcompra() {
        return idcompra;
    }

    public void setIdcompra(Compra idcompra) {
        this.idcompra = idcompra;
    }

    public Pieza getIdpieza() {
        return idpieza;
    }

    public void setIdpieza(Pieza idpieza) {
        this.idpieza = idpieza;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelCompraPiezas != null ? idrelCompraPiezas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelCompraPieza)) {
            return false;
        }
        RelCompraPieza other = (RelCompraPieza) object;
        if ((this.idrelCompraPiezas == null && other.idrelCompraPiezas != null) || (this.idrelCompraPiezas != null && !this.idrelCompraPiezas.equals(other.idrelCompraPiezas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.RelCompraPieza[ idrelCompraPiezas=" + idrelCompraPiezas + " ]";
    }
    
}
