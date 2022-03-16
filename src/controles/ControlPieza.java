package controles;

import dominio.Pieza;
import accesoDatos.PiezaJpaController;
import accesoDatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class ControlPieza implements BaseControl<Pieza> {

    private final PiezaJpaController piezaAccesoDatos;

    public ControlPieza() {
        this.piezaAccesoDatos = new PiezaJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }

    @Override
    public Pieza buscarporID(int id) {
        return this.piezaAccesoDatos.findPieza(id);
    }

    @Override
    public List<Pieza> buscarTodas() {
        return this.piezaAccesoDatos.findPiezaEntities();
    }

    @Override
    public boolean guardar(Pieza entidad) {
        this.piezaAccesoDatos.create(entidad);
        return true;
    }

    @Override
    public boolean actualizar(Pieza entidad) {
        try {
            this.piezaAccesoDatos.edit(entidad);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.piezaAccesoDatos.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(ControlPieza.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
