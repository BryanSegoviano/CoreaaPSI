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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author bryan
 */
@Entity
@Table(name = "mecanicos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mecanico.findAll", query = "SELECT m FROM Mecanico m"),
    @NamedQuery(name = "Mecanico.findByIdmecanico", query = "SELECT m FROM Mecanico m WHERE m.idmecanico = :idmecanico"),
    @NamedQuery(name = "Mecanico.findByNombre", query = "SELECT m FROM Mecanico m WHERE m.nombre = :nombre"),
    @NamedQuery(name = "Mecanico.findByTelefono", query = "SELECT m FROM Mecanico m WHERE m.telefono = :telefono"),
    @NamedQuery(name = "Mecanico.findByUsuario", query = "SELECT m FROM Mecanico m WHERE m.usuario = :usuario"),
    @NamedQuery(name = "Mecanico.findByPassword", query = "SELECT m FROM Mecanico m WHERE m.password = :password")})
public class Mecanico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmecanico")
    private Integer idmecanico;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "telefono")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public Mecanico() {
    }

    public Mecanico(Integer idmecanico) {
        this.idmecanico = idmecanico;
    }

    public Mecanico(Integer idmecanico, String nombre, String telefono, String usuario, String password) {
        this.idmecanico = idmecanico;
        this.nombre = nombre;
        this.telefono = telefono;
        this.usuario = usuario;
        this.password = password;
    }

    public Integer getIdmecanico() {
        return idmecanico;
    }

    public void setIdmecanico(Integer idmecanico) {
        this.idmecanico = idmecanico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmecanico != null ? idmecanico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mecanico)) {
            return false;
        }
        Mecanico other = (Mecanico) object;
        if ((this.idmecanico == null && other.idmecanico != null) || (this.idmecanico != null && !this.idmecanico.equals(other.idmecanico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Mecanico[ idmecanico=" + idmecanico + " ]";
    }
    
}
