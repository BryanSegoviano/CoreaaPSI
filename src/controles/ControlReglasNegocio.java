package controles;

import accesoDatos.AdministradorJpaController;
import accesoDatos.MecanicoJpaController;
import accesoDatos.PiezaJpaController;
import accesoDatos.RelclientevehiculoJpaController;
import dominio.Administrador;
import dominio.Mecanico;
import dominio.Pieza;
import dominio.Relclientevehiculo;
import dominio.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;

public class ControlReglasNegocio {

    private final PiezaJpaController accesoDatosPiezaJPA;
    private final AdministradorJpaController accesoDatosAdministradorJPA;
    private final MecanicoJpaController accesoDatosMecanicosJPA;
    private final RelclientevehiculoJpaController accesoDatosRelClienteVehiculoJPA;

    public ControlReglasNegocio() {
        this.accesoDatosPiezaJPA = new PiezaJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
        this.accesoDatosAdministradorJPA = new AdministradorJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
        this.accesoDatosMecanicosJPA = new MecanicoJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
        this.accesoDatosRelClienteVehiculoJPA = new RelclientevehiculoJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
    }

    public boolean validaExistenciaPiezas(int idPieza) {
        if (this.accesoDatosPiezaJPA.findPieza(idPieza).getCantidad() > 0) {
            return true;
        }
        return false;
    }

    public void sumarPiezas(int idPieza, int cantidad) {
        this.accesoDatosPiezaJPA.findPieza(idPieza).setCantidad(this.accesoDatosPiezaJPA.findPieza(idPieza).getCantidad() + cantidad);
    }

    public boolean restarPiezas(int idPieza, int cantidad) {
        int cantidad2 = this.accesoDatosPiezaJPA.findPieza(idPieza).getCantidad();
        System.out.println("Pieza: " + this.accesoDatosPiezaJPA.findPieza(idPieza).toString());
        System.out.println("Existencia: " + cantidad2);
        int nuevaExistencia = cantidad2 - cantidad;
        System.out.println("Existencia - cantidad: " + (cantidad2 - cantidad));
//        pieza.setCantidad(nuevaExistencia);
        this.accesoDatosPiezaJPA.findPieza(idPieza).setCosto(nuevaExistencia);
        System.out.println("Nueva existencia: " + this.accesoDatosPiezaJPA.findPieza(idPieza).getCantidad());
        return true;
    }

    public List<Vehiculo> recuperaVehiculoCliente(int idCliente) {
        List<Vehiculo> listaVehiculos = new ArrayList<Vehiculo>();
        List<Relclientevehiculo> listaCV = accesoDatosRelClienteVehiculoJPA.findRelclientevehiculoEntities();
        for (Relclientevehiculo relCV : listaCV) {
            int idClienteRelCV = relCV.getIdcliente().getIdcliente();
            if (idClienteRelCV == idCliente) {
                Vehiculo vehiculo = relCV.getIdvehiculo();
                listaVehiculos.add(vehiculo);
            }
        }
        return listaVehiculos;
    }

    public boolean validarCredenciales(String usuario, String pass) {
        boolean permiso =false;
        List<Administrador> listaAdministradores = accesoDatosAdministradorJPA.findAdministradorEntities();
        List<Mecanico> listaMEcanicos = accesoDatosMecanicosJPA.findMecanicoEntities();
        for (Administrador administrador : listaAdministradores) {
            if (administrador.getPassword().equalsIgnoreCase(pass) && administrador.getUsuario().equalsIgnoreCase(usuario)) {
                return true;
            }
        }
        for (Mecanico mecanico : listaMEcanicos) {
            if (mecanico.getUsuario().equalsIgnoreCase(usuario) && mecanico.getPassword().equalsIgnoreCase(pass)) {
                permiso = true;
            }
        }
        return permiso;
    }
}