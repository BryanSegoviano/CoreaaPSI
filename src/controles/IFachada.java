package controles;

import dominio.*;
import java.util.List;

public interface IFachada {

    //Administrador
    public abstract Administrador buscarPorIDAdministrador(int id);

    public abstract List<Administrador> buscarTodasAdministrador();

    public abstract boolean guardarAdministrador(Administrador entidad);

    public abstract boolean actualizarAdministrador(Administrador entidad);

    public abstract boolean eliminarAdministrador(int id);

    //Cliente
    public abstract Cliente buscarPorIDCliente(int id);

    public abstract List<Cliente> buscarTodasCliente();

    public abstract boolean guardarCliente(Cliente entidad);

    public abstract boolean actualizarCliente(Cliente entidad);

    public abstract boolean eliminarCliente(int id);

    //Compras
    public abstract Compra buscarPorIDCompra(int id);

    public abstract List<Compra> buscarTodasCompra();

    public abstract boolean guardarCompra(Compra entidad);

    public abstract boolean actualizarCompra(Compra entidad);

    public abstract boolean eliminarCompra(int id);

//    //Garantia
//    public abstract Garantia buscarPorIDGarantia(int id);
//
//    public abstract List<Garantia> buscarTodasGarantia();
//
//    public abstract boolean guardarGarantia(Garantia entidad);
//
//    public abstract boolean actualizarGarantia(Garantia entidad);
//
//    public abstract boolean eliminarGarantia(int id);

    //Mecanico
    public abstract Mecanico buscarPorIDMecanico(int id);

    public abstract List<Mecanico> buscarTodasMecanico();

    public abstract boolean guardarMecanico(Mecanico entidad);

    public abstract boolean actualizarMecanico(Mecanico entidad);

    public abstract boolean eliminarMecanico(int id);

    //Pieza
    public abstract Pieza buscarPorIDPieza(int id);

    public abstract List<Pieza> buscarTodasPieza();

    public abstract boolean guardarPieza(Pieza entidad);

    public abstract boolean actualizarPieza(Pieza entidad);

    public abstract boolean eliminarPieza(int id);

    //RelCompraPieza
    public abstract RelCompraPieza buscarPorIDRelCompraPieza(int id);

    public abstract List<RelCompraPieza> buscarTodasRelCompraPieza();

    public abstract boolean guardarRelCompraPieza(RelCompraPieza entidad);

    public abstract boolean actualizarRelCompraPieza(RelCompraPieza entidad);

    public abstract boolean eliminarRelCompraPieza(int id);

    //Relclientevehiculo
    public abstract Relclientevehiculo buscarPorIDRelclientevehiculo(int id);

    public abstract List<Relclientevehiculo> buscarTodasRelclientevehiculo();

    public abstract boolean guardarRelclientevehiculo(Relclientevehiculo entidad);

    public abstract boolean actualizarRelclientevehiculo(Relclientevehiculo entidad);

    public abstract boolean eliminarRelclientevehiculo(int id);

    //RelVentaPieza
    public abstract Relventapieza buscarPorIDRelVentaPieza(int id);

    public abstract List<Relventapieza> buscarTodasRelventapieza();

    public abstract boolean guardarRelventapieza(Relventapieza entidad);

    public abstract boolean actualizarRelventapieza(Relventapieza entidad);

    public abstract boolean eliminarRelventapieza(int id);

    //Relventaservicio
    public abstract Relventaservicio buscarPorIDRelventaservicio(int id);

    public abstract List<Relventaservicio> buscarTodasRelventaservicio();

    public abstract boolean guardarRelventaservicio(Relventaservicio entidad);

    public abstract boolean actualizarRelventaservicio(Relventaservicio entidad);

    public abstract boolean eliminarRelventaservicio(int id);

    //Servicio
    public abstract Servicio buscarPorIDServicio(int id);

    public abstract List<Servicio> buscarTodasServicio();

    public abstract boolean guardarServicio(Servicio entidad);

    public abstract boolean actualizarServicio(Servicio entidad);

    public abstract boolean eliminarServicio(int id);

    //Vehiculo
    public abstract Vehiculo buscarPorIDVehiculo(int id);

    public abstract List<Vehiculo> buscarTodasVehiculo();

    public abstract boolean guardarVehiculo(Vehiculo entidad);

    public abstract boolean actualizarVehiculo(Vehiculo entidad);

    public abstract boolean eliminarVehiculo(int id);

    //Venta
    public abstract Venta buscarPorIDVenta(int id);

    public abstract List<Venta> buscarTodasVenta();

    public abstract boolean guardarVenta(Venta entidad);

    public abstract boolean actualizarVenta(Venta entidad);

    public abstract boolean eliminarVenta(int id);

}
