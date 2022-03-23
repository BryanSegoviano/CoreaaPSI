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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ventas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByIdventa", query = "SELECT v FROM Venta v WHERE v.idventa = :idventa"),
    @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha"),
    @NamedQuery(name = "Venta.findByTotal", query = "SELECT v FROM Venta v WHERE v.total = :total"),
    @NamedQuery(name = "Venta.findByNotas", query = "SELECT v FROM Venta v WHERE v.notas = :notas"),
    @NamedQuery(name = "Venta.findByVendedor", query = "SELECT v FROM Venta v WHERE v.vendedor = :vendedor")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idventa")
    private Integer idventa;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "total")
    private double total;
    @Column(name = "notas")
    private String notas;
    @Basic(optional = false)
    @Column(name = "vendedor")
    private String vendedor;
    @JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
    @ManyToOne(optional = false)
    private Cliente idcliente;
    @JoinColumn(name = "idvehiculo", referencedColumnName = "idvehiculo")
    @ManyToOne(optional = false)
    private Vehiculo idvehiculo;

    public Venta() {
    }

    public Venta(Integer idventa) {
        this.idventa = idventa;
    }

    public Venta(Date fecha, double total, String notas) {
        this.fecha = fecha;
        this.total = total;
        this.notas = notas;
    }

    public Venta(Date fecha, double total, String notas, Cliente idcliente, Vehiculo idvehiculo) {
        this.fecha = fecha;
        this.total = total;
        this.notas = notas;
        this.idcliente = idcliente;
        this.idvehiculo = idvehiculo;
    }
    
    public Venta(Date fecha, double total, String notas, String vendedor, Cliente idcliente, Vehiculo idvehiculo) {
        this.fecha = fecha;
        this.total = total;
        this.notas = notas;
        this.vendedor = vendedor;
        this.idcliente = idcliente;
        this.idvehiculo = idvehiculo;
    }
    
    public Venta(Integer idventa, Date fecha, double total, String vendedor) {
        this.idventa = idventa;
        this.fecha = fecha;
        this.total = total;
        this.vendedor = vendedor;
    }

    public Integer getIdventa() {
        return idventa;
    }

    public void setIdventa(Integer idventa) {
        this.idventa = idventa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
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
        hash += (idventa != null ? idventa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idventa == null && other.idventa != null) || (this.idventa != null && !this.idventa.equals(other.idventa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Venta{" + "idventa=" + idventa + ", fecha=" + fecha + ", total=" + total + ", notas=" + notas + ", vendedor=" + vendedor + ", idcliente=" + idcliente + ", idvehiculo=" + idvehiculo + '}';
    }
    
}
