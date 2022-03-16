package controles;

import dominio.RelCompraPieza;
import accesoDatos.RelCompraPiezaJpaController;
import accesoDatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class ControlRelCompraPieza implements BaseControl<RelCompraPieza> {

    private final RelCompraPiezaJpaController relCP;
    
    public ControlRelCompraPieza() {
        this.relCP = new RelCompraPiezaJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }

    @Override
    public RelCompraPieza buscarporID(int id) {
        return this.relCP.findRelCompraPieza(id);
    }

    @Override
    public List<RelCompraPieza> buscarTodas() {
        return this.relCP.findRelCompraPiezaEntities();
    }

    @Override
    public boolean guardar(RelCompraPieza entidad) {
        this.relCP.create(entidad);
        return true;
    }

    @Override
    public boolean actualizar(RelCompraPieza entidad) {
        try {
            this.relCP.edit(entidad);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.relCP.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
