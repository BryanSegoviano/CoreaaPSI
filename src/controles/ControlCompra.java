package controles;

import dominio.Compra;
import accesoDatos.CompraJpaController;
import accesoDatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class ControlCompra implements BaseControl<Compra> {

    private final CompraJpaController compraJpaController;

    public ControlCompra() {
        this.compraJpaController = new CompraJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }

    @Override
    public Compra buscarporID(int id) {
        return this.compraJpaController.findCompra(id);
    }

    @Override
    public List<Compra> buscarTodas() {
        return this.compraJpaController.findCompraEntities();
    }

    @Override
    public boolean guardar(Compra entidad) {
        this.compraJpaController.create(entidad);
        return true;
    }

    @Override
    public boolean actualizar(Compra entidad) {
        try {
            this.compraJpaController.edit(entidad);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.compraJpaController.destroy(id);
            return true;
        } catch (Exception e) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

}
