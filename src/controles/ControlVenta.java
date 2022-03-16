package controles;

import dominio.Venta;
import accesoDatos.VentaJpaController;
import accesoDatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class ControlVenta implements BaseControl<Venta> {

    private final VentaJpaController ventaDatos;

    public ControlVenta() {
        this.ventaDatos = new VentaJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }

    @Override
    public Venta buscarporID(int id) {
        return this.ventaDatos.findVenta(id);
    }

    @Override
    public List<Venta> buscarTodas() {
        return this.ventaDatos.findVentaEntities();
    }

    @Override
    public boolean guardar(Venta entidad) {
        this.ventaDatos.create(entidad);
        return true;
    }

    @Override
    public boolean actualizar(Venta entidad) {
        try {
            this.ventaDatos.edit(entidad);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.ventaDatos.destroy(id);
            return true;
        } catch (Exception e) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

}
