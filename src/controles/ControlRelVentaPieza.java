package controles;

import dominio.Relventapieza;
import accesoDatos.RelventapiezaJpaController;
import accesoDatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;
public class ControlRelVentaPieza implements BaseControl<Relventapieza> {

    private final RelventapiezaJpaController relVP;

    public ControlRelVentaPieza() {
        this.relVP= new RelventapiezaJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }

    @Override
    public Relventapieza buscarporID(int id) {
        return this.relVP.findRelventapieza(id);
    }

    @Override
    public List<Relventapieza> buscarTodas() {
        return this.relVP.findRelventapiezaEntities();
    }

    @Override
    public boolean guardar(Relventapieza entidad) {
        this.relVP.create(entidad);
        return true;
    }

    @Override
    public boolean actualizar(Relventapieza entidad) {
        try {
            this.relVP.edit(entidad);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.relVP.destroy(id);
            return true;
        } catch (Exception e) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

}
