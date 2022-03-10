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
@Table(name = "rel_servicio_pieza")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RelServicioPieza.findAll", query = "SELECT r FROM RelServicioPieza r"),
    @NamedQuery(name = "RelServicioPieza.findByIdrelServicioPieza", query = "SELECT r FROM RelServicioPieza r WHERE r.idrelServicioPieza = :idrelServicioPieza"),
    @NamedQuery(name = "RelServicioPieza.findByCantidad", query = "SELECT r FROM RelServicioPieza r WHERE r.cantidad = :cantidad")})
public class RelServicioPieza implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrel_servicio_pieza")
    private Integer idrelServicioPieza;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private int cantidad;
    @JoinColumn(name = "idpieaza", referencedColumnName = "idpieza")
    @ManyToOne(optional = false)
    private Pieza idpieaza;
    @JoinColumn(name = "idservicio", referencedColumnName = "idservicio")
    @ManyToOne(optional = false)
    private Servicio idservicio;

    public RelServicioPieza() {
    }

    public RelServicioPieza(Integer idrelServicioPieza) {
        this.idrelServicioPieza = idrelServicioPieza;
    }

    public RelServicioPieza(Integer idrelServicioPieza, int cantidad) {
        this.idrelServicioPieza = idrelServicioPieza;
        this.cantidad = cantidad;
    }

    public Integer getIdrelServicioPieza() {
        return idrelServicioPieza;
    }

    public void setIdrelServicioPieza(Integer idrelServicioPieza) {
        this.idrelServicioPieza = idrelServicioPieza;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Pieza getIdpieaza() {
        return idpieaza;
    }

    public void setIdpieaza(Pieza idpieaza) {
        this.idpieaza = idpieaza;
    }

    public Servicio getIdservicio() {
        return idservicio;
    }

    public void setIdservicio(Servicio idservicio) {
        this.idservicio = idservicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelServicioPieza != null ? idrelServicioPieza.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelServicioPieza)) {
            return false;
        }
        RelServicioPieza other = (RelServicioPieza) object;
        if ((this.idrelServicioPieza == null && other.idrelServicioPieza != null) || (this.idrelServicioPieza != null && !this.idrelServicioPieza.equals(other.idrelServicioPieza))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.RelServicioPieza[ idrelServicioPieza=" + idrelServicioPieza + " ]";
    }
    
}
