/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "piezas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pieza.findAll", query = "SELECT p FROM Pieza p"),
    @NamedQuery(name = "Pieza.findByIdpieza", query = "SELECT p FROM Pieza p WHERE p.idpieza = :idpieza"),
    @NamedQuery(name = "Pieza.findByNombre", query = "SELECT p FROM Pieza p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pieza.findByCosto", query = "SELECT p FROM Pieza p WHERE p.costo = :costo"),
    @NamedQuery(name = "Pieza.findByCantidad", query = "SELECT p FROM Pieza p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Pieza.findByFechaGarantia", query = "SELECT p FROM Pieza p WHERE p.fechaGarantia = :fechaGarantia")})
public class Pieza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpieza")
    private Integer idpieza;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "costo")
    private double costo;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @Column(name = "fecha_garantia")
    @Temporal(TemporalType.DATE)
    private Date fechaGarantia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpieza")
    private List<RelCompraPieza> relCompraPiezaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpieza")
    private List<Relventapieza> relventapiezaList;

    public Pieza() {
    }

    public Pieza(Integer idpieza) {
        this.idpieza = idpieza;
    }

    public Pieza(String nombre, double costo, int cantidad) {
        this.nombre = nombre;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public Pieza(Integer idpieza, String nombre, double costo, int cantidad) {
        this.idpieza = idpieza;
        this.nombre = nombre;
        this.costo = costo;
        this.cantidad = cantidad;
    }

    public Integer getIdpieza() {
        return idpieza;
    }

    public void setIdpieza(Integer idpieza) {
        this.idpieza = idpieza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaGarantia() {
        return fechaGarantia;
    }

    public void setFechaGarantia(Date fechaGarantia) {
        this.fechaGarantia = fechaGarantia;
    }

    @XmlTransient
    public List<RelCompraPieza> getRelCompraPiezaList() {
        return relCompraPiezaList;
    }

    public void setRelCompraPiezaList(List<RelCompraPieza> relCompraPiezaList) {
        this.relCompraPiezaList = relCompraPiezaList;
    }

    @XmlTransient
    public List<Relventapieza> getRelventapiezaList() {
        return relventapiezaList;
    }

    public void setRelventapiezaList(List<Relventapieza> relventapiezaList) {
        this.relventapiezaList = relventapiezaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpieza != null ? idpieza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pieza)) {
            return false;
        }
        Pieza other = (Pieza) object;
        if ((this.idpieza == null && other.idpieza != null) || (this.idpieza != null && !this.idpieza.equals(other.idpieza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
}
