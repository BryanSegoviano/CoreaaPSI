package controles;

import dominio.Servicio;
import accesoDatos.ServicioJpaController;
import accesoDatos.exceptions.IllegalOrphanException;
import accesoDatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class ControlServicio implements BaseControl<Servicio> {

    private final ServicioJpaController servicioAccesoDatos;

    public ControlServicio() {
        this.servicioAccesoDatos = new ServicioJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }

    @Override
    public Servicio buscarporID(int id) {
        return this.servicioAccesoDatos.findServicio(id);
    }

    @Override
    public List<Servicio> buscarTodas() {
       return this.servicioAccesoDatos.findServicioEntities();
    }

    @Override
    public boolean guardar(Servicio entidad) {
        this.servicioAccesoDatos.create(entidad);
        return true;
    }

    @Override
    public boolean actualizar(Servicio entidad) {
        try{
            this.servicioAccesoDatos.edit(entidad);
            return true;
        }catch(Exception ex){
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE,null,ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.servicioAccesoDatos.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(ControlServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}