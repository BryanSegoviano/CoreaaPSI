package controles;

import dominio.Administrador;
import accesoDatos.AdministradorJpaController;
import accesoDatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class ControlAdministrador implements BaseControl<Administrador> {

    private final AdministradorJpaController adminAccesoDatos;

    public ControlAdministrador() {
        this.adminAccesoDatos = new AdministradorJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }

    @Override
    public Administrador buscarporID(int id) {
        return this.adminAccesoDatos.findAdministrador(id);
    }

    @Override
    public List<Administrador> buscarTodas() {
        return this.adminAccesoDatos.findAdministradorEntities();
    }

    @Override
    public boolean guardar(Administrador entidad) {
        this.adminAccesoDatos.create(entidad);
        return true;
    }

    @Override
    public boolean actualizar(Administrador entidad) {
        try {
            this.adminAccesoDatos.edit(entidad);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.adminAccesoDatos.destroy(id);
            return true;
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
