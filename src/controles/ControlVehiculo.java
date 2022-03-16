package controles;

import dominio.Vehiculo;
import accesoDatos.VehiculoJpaController;
import accesoDatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;


public class ControlVehiculo implements BaseControl<Vehiculo> {

    private final VehiculoJpaController vehiculoAccesoDatos;

    public ControlVehiculo() {
                this.vehiculoAccesoDatos = new VehiculoJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));

    }

    @Override
    public Vehiculo buscarporID(int id) {
        return this.vehiculoAccesoDatos.findVehiculo(id);
    }

    @Override
    public List<Vehiculo> buscarTodas() {
        return this.vehiculoAccesoDatos.findVehiculoEntities();
    }

    @Override
    public boolean guardar(Vehiculo entidad) {
        this.vehiculoAccesoDatos.create(entidad);
        return true;
    }

    @Override
    public boolean actualizar(Vehiculo entidad) {
        try {
            this.vehiculoAccesoDatos.edit(entidad);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.vehiculoAccesoDatos.destroy(id);
            return true;
        } catch (Exception e) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

}
