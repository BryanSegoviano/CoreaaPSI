package controles;

import dominio.Relventaservicio;
import accesoDatos.RelventaservicioJpaController;
import accesoDatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class ControlRelVentaServicio implements BaseControl<Relventaservicio>{

    private final RelventaservicioJpaController relVsAccesoDatos;
    
    public ControlRelVentaServicio() {
        this.relVsAccesoDatos = new RelventaservicioJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }
    
    @Override
    public Relventaservicio buscarporID(int id) {
        return this.relVsAccesoDatos.findRelventaservicio(id);
    }

    @Override
    public List<Relventaservicio> buscarTodas() {
        return this.relVsAccesoDatos.findRelventaservicioEntities();
    }

    @Override
    public boolean guardar(Relventaservicio entidad) {
        this.relVsAccesoDatos.create(entidad);
        return true;
    }

    @Override
    public boolean actualizar(Relventaservicio entidad) {
        try {
            this.relVsAccesoDatos.edit(entidad);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.relVsAccesoDatos.destroy(id);
            return true;
        } catch (Exception e) {
        }
        return false;
    }
    
}
