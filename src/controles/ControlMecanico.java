package controles;

import dominio.Mecanico;
import accesoDatos.MecanicoJpaController;
import accesoDatos.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Persistence;

public class ControlMecanico implements BaseControl<Mecanico>{

    private final MecanicoJpaController mecanico;

    public ControlMecanico() {
        this.mecanico = new MecanicoJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }
    
    @Override
    public Mecanico buscarporID(int id) {
        return this.mecanico.findMecanico(id);
    }

    @Override
    public List<Mecanico> buscarTodas() {
        return this.mecanico.findMecanicoEntities();
    }

    @Override
    public boolean guardar(Mecanico entidad) {
        this.mecanico.create(entidad);
        return true;
    }

    @Override
    public boolean actualizar(Mecanico entidad) {
        try {
            this.mecanico.edit(entidad);
            return true;
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        try {
            this.mecanico.destroy(id);
        } catch (Exception ex) {
            Logger.getLogger(ControlAdministrador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
