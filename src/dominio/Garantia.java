/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "garantias")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garantia.findAll", query = "SELECT g FROM Garantia g"),
    @NamedQuery(name = "Garantia.findByIdgarantia", query = "SELECT g FROM Garantia g WHERE g.idgarantia = :idgarantia"),
    @NamedQuery(name = "Garantia.findByFechaVencimiento", query = "SELECT g FROM Garantia g WHERE g.fechaVencimiento = :fechaVencimiento")})
public class Garantia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idgarantia")
    private Integer idgarantia;
    @Basic(optional = false)
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    public Garantia() {
    }

    public Garantia(Integer idgarantia) {
        this.idgarantia = idgarantia;
    }

    public Garantia(Integer idgarantia, Date fechaVencimiento) {
        this.idgarantia = idgarantia;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIdgarantia() {
        return idgarantia;
    }

    public void setIdgarantia(Integer idgarantia) {
        this.idgarantia = idgarantia;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idgarantia != null ? idgarantia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Garantia)) {
            return false;
        }
        Garantia other = (Garantia) object;
        if ((this.idgarantia == null && other.idgarantia != null) || (this.idgarantia != null && !this.idgarantia.equals(other.idgarantia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Garantia[ idgarantia=" + idgarantia + " ]";
    }
    
}
