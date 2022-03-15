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
@Table(name = "relclientevehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relclientevehiculo.findAll", query = "SELECT r FROM Relclientevehiculo r"),
    @NamedQuery(name = "Relclientevehiculo.findByIdrelclientevehiculo", query = "SELECT r FROM Relclientevehiculo r WHERE r.idrelclientevehiculo = :idrelclientevehiculo")})
public class Relclientevehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idrelclientevehiculo")
    private Integer idrelclientevehiculo;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @JoinColumn(name = "idvehiculo", referencedColumnName = "idvehiculo")
    @ManyToOne(optional = false)
    private Vehiculo idvehiculo;

    public Relclientevehiculo() {
    }

    public Relclientevehiculo(Integer idrelclientevehiculo) {
        this.idrelclientevehiculo = idrelclientevehiculo;
    }

    public Relclientevehiculo(Cliente idcliente, Vehiculo idvehiculo) {
        this.idcliente = idcliente;
        this.idvehiculo = idvehiculo;
    }

    public Integer getIdrelclientevehiculo() {
        return idrelclientevehiculo;
    }

    public void setIdrelclientevehiculo(Integer idrelclientevehiculo) {
        this.idrelclientevehiculo = idrelclientevehiculo;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    public Vehiculo getIdvehiculo() {
        return idvehiculo;
    }

    public void setIdvehiculo(Vehiculo idvehiculo) {
        this.idvehiculo = idvehiculo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idrelclientevehiculo != null ? idrelclientevehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relclientevehiculo)) {
            return false;
        }
        Relclientevehiculo other = (Relclientevehiculo) object;
        if ((this.idrelclientevehiculo == null && other.idrelclientevehiculo != null) || (this.idrelclientevehiculo != null && !this.idrelclientevehiculo.equals(other.idrelclientevehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Relclientevehiculo[ idrelclientevehiculo=" + idrelclientevehiculo + " ]";
    }
    
}
