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
@Table(name = "relventaservicio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relventaservicio.findAll", query = "SELECT r FROM Relventaservicio r"),
    @NamedQuery(name = "Relventaservicio.findByIdrelVentaServicio", query = "SELECT r FROM Relventaservicio r WHERE r.idrelVentaServicio = :idrelVentaServicio")})
public class Relventaservicio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelVentaServicio")
    private Integer idrelVentaServicio;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
    @ManyToOne(optional = false)
    private Servicio idservicio;
    @JoinColumn(name = "idventa", referencedColumnName = "idventa")
    @ManyToOne(optional = false)
    private Venta idventa;

    public Relventaservicio() {
    }

    public Relventaservicio(Integer idrelVentaServicio) {
        this.idrelVentaServicio = idrelVentaServicio;
    }

    public Relventaservicio(Servicio idservicio, Venta idventa) {
        this.idservicio = idservicio;
        this.idventa = idventa;
    }

    public Integer getIdrelVentaServicio() {
        return idrelVentaServicio;
    }

    public void setIdrelVentaServicio(Integer idrelVentaServicio) {
        this.idrelVentaServicio = idrelVentaServicio;
    }

    public Servicio getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Servicio idservicio) {
        this.idservicio = idservicio;
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
        hash += (idrelVentaServicio != null ? idrelVentaServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relventaservicio)) {
            return false;
        }
        Relventaservicio other = (Relventaservicio) object;
        if ((this.idrelVentaServicio == null && other.idrelVentaServicio != null) || (this.idrelVentaServicio != null && !this.idrelVentaServicio.equals(other.idrelVentaServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Relventaservicio[ idrelVentaServicio=" + idrelVentaServicio + " ]";
    }
    
}
