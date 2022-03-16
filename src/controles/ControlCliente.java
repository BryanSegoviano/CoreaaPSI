package controles;

import dominio.Cliente;
import accesoDatos.ClienteJpaController;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class ControlCliente implements BaseControl<Cliente>{

    private final ClienteJpaController clienteJpaController;
    
    public ControlCliente() {
        this.clienteJpaController = new ClienteJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }
    
    @Override
    public Cliente buscarporID(int id) {
        return clienteJpaController.findCliente(id);
    }

    @Override
    public List<Cliente> buscarTodas() {
        return clienteJpaController.findClienteEntities();
    }

    @Override
    public boolean guardar(Cliente entidad) {
        this.clienteJpaController.create(entidad);;
        return true;
    }

    @Override
    public boolean actualizar(Cliente entidad) {
        try {
            this.clienteJpaController.edit(entidad);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.clienteJpaController.destroy(id);
            return true;
        } catch (Exception e) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    
}
