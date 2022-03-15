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
@Table(name = "relventapieza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relventapieza.findAll", query = "SELECT r FROM Relventapieza r"),
    @NamedQuery(name = "Relventapieza.findByIdrelventapieza", query = "SELECT r FROM Relventapieza r WHERE r.idrelventapieza = :idrelventapieza"),
    @NamedQuery(name = "Relventapieza.findByCantidad", query = "SELECT r FROM Relventapieza r WHERE r.cantidad = :cantidad")})
public class Relventapieza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelventapieza")
    private Integer idrelventapieza;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private String cantidad;
    @JoinColumn(name = "idpieza", referencedColumnName = "idpieza")
    @ManyToOne(optional = false)
    private Pieza idpieza;
    @JoinColumn(name = "idventa", referencedColumnName = "idventa")
    @ManyToOne(optional = false)
    private Venta idventa;

    public Relventapieza() {
    }

    public Relventapieza(Integer idrelventapieza) {
        this.idrelventapieza = idrelventapieza;
    }

    public Relventapieza(Integer idrelventapieza, String cantidad) {
        this.idrelventapieza = idrelventapieza;
        this.cantidad = cantidad;
    }

    public Relventapieza(String cantidad, Pieza idpieza, Venta idventa) {
        this.cantidad = cantidad;
        this.idpieza = idpieza;
        this.idventa = idventa;
    }

    public Integer getIdrelventapieza() {
        return idrelventapieza;
    }

    public void setIdrelventapieza(Integer idrelventapieza) {
        this.idrelventapieza = idrelventapieza;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public Pieza getIdpieza() {
        return idpieza;
    }

    public void setIdpieza(Pieza idpieza) {
        this.idpieza = idpieza;
    }

    public Venta getIdventa() {
        return idventa;
    }

    public void setIdventa(Venta idventa) {
        this.idventa = idventa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelventapieza != null ? idrelventapieza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relventapieza)) {
            return false;
        }
        Relventapieza other = (Relventapieza) object;
        if ((this.idrelventapieza == null && other.idrelventapieza != null) || (this.idrelventapieza != null && !this.idrelventapieza.equals(other.idrelventapieza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Relventapieza[ idrelventapieza=" + idrelventapieza + " ]";
    }
    
}
