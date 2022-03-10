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
@Table(name = "servicios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Servicio.findAll", query = "SELECT s FROM Servicio s"),
    @NamedQuery(name = "Servicio.findByIdservicio", query = "SELECT s FROM Servicio s WHERE s.idservicio = :idservicio"),
    @NamedQuery(name = "Servicio.findByFecha", query = "SELECT s FROM Servicio s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "Servicio.findByCosto", query = "SELECT s FROM Servicio s WHERE s.costo = :costo"),
    @NamedQuery(name = "Servicio.findByConcepto", query = "SELECT s FROM Servicio s WHERE s.concepto = :concepto"),
    @NamedQuery(name = "Servicio.findByProximoServicio", query = "SELECT s FROM Servicio s WHERE s.proximoServicio = :proximoServicio")})
public class Servicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idservicio")
    private Integer idservicio;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "costo")
    private double costo;
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "proximo_servicio")
    @Temporal(TemporalType.DATE)
    private Date proximoServicio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicio")
    private List<RelServicioPieza> relServicioPiezaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idservicios")
    private List<Venta> ventaList;

    public Servicio() {
    }

    public Servicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public Servicio(Integer idservicio, Date fecha, double costo) {
        this.idservicio = idservicio;
        this.fecha = fecha;
        this.costo = costo;
    }

    public Integer getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Integer idservicio) {
        this.idservicio = idservicio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getProximoServicio() {
        return proximoServicio;
    }

    public void setProximoServicio(Date proximoServicio) {
        this.proximoServicio = proximoServicio;
    }

    @XmlTransient
    public List<RelServicioPieza> getRelServicioPiezaList() {
        return relServicioPiezaList;
    }

    public void setRelServicioPiezaList(List<RelServicioPieza> relServicioPiezaList) {
        this.relServicioPiezaList = relServicioPiezaList;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idservicio != null ? idservicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servicio)) {
            return false;
        }
        Servicio other = (Servicio) object;
        if ((this.idservicio == null && other.idservicio != null) || (this.idservicio != null && !this.idservicio.equals(other.idservicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Servicio[ idservicio=" + idservicio + " ]";
    }
    
}
