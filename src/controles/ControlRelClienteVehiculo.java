package controles;

import dominio.Relclientevehiculo;
import accesoDatos.RelclientevehiculoJpaController;
import accesoDatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class ControlRelClienteVehiculo implements BaseControl<Relclientevehiculo> {

    private final RelclientevehiculoJpaController relCV;

    public ControlRelClienteVehiculo() {
        this.relCV = new RelclientevehiculoJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }

    @Override
    public Relclientevehiculo buscarporID(int id) {
        return this.relCV.findRelclientevehiculo(id);
    }

    @Override
    public List<Relclientevehiculo> buscarTodas() {
        return this.relCV.findRelclientevehiculoEntities();
    }

    @Override
    public boolean guardar(Relclientevehiculo entidad) {
        this.relCV.create(entidad);
        return true;
    }

    @Override
    public boolean actualizar(Relclientevehiculo entidad) {
        try {
            this.relCV.edit(entidad);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.relCV.destroy(id);
            return true;
        } catch (Exception e) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

}
