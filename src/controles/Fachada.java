package controles;

import dominio.*;
import java.util.List;

public class Fachada implements IFachada {

    public Fachada() {
    }

    private final ControlAdministrador controlAdmor = new ControlAdministrador();
    private final ControlCliente controlCliente = new ControlCliente();
    private final ControlCompra controlCompra = new ControlCompra();
//    private final ControlGarantia controlGarantia = new ControlGarantia();
    private final ControlMecanico controlMecanico = new ControlMecanico();
    private final ControlPieza controlPieza = new ControlPieza();
    private final ControlRelClienteVehiculo controlRelCV = new ControlRelClienteVehiculo();
    private final ControlRelVentaPieza controlRelVP = new ControlRelVentaPieza();
    private final ControlRelCompraPieza controlRelCP = new ControlRelCompraPieza();
    private final ControlRelVentaServicio controlVS = new ControlRelVentaServicio();
    private final ControlServicio controlServicio = new ControlServicio();
    private final ControlVehiculo controlVehiculo = new ControlVehiculo();
    private final ControlVenta controlVenta = new ControlVenta();

    @Override
    public Administrador buscarPorIDAdministrador(int id) {
        return controlAdmor.buscarporID(id);
    }

    @Override
    public List<Administrador> buscarTodasAdministrador() {
        return controlAdmor.buscarTodas();
    }

    @Override
    public boolean guardarAdministrador(Administrador entidad) {
        return this.controlAdmor.guardar(entidad);
    }

    @Override
    public boolean actualizarAdministrador(Administrador entidad) {
        return this.controlAdmor.actualizar(entidad);
    }

    @Override
    public boolean eliminarAdministrador(int id) {
        return this.controlAdmor.eliminar(id);
    }

    @Override
    public Cliente buscarPorIDCliente(int id) {
        return controlCliente.buscarporID(id);
    }

    @Override
    public List<Cliente> buscarTodasCliente() {
        return controlCliente.buscarTodas();
    }

    @Override
    public boolean guardarCliente(Cliente entidad) {
        return this.controlCliente.guardar(entidad);
    }

    @Override
    public boolean actualizarCliente(Cliente entidad) {
        return this.controlCliente.actualizar(entidad);
    }

    @Override
    public boolean eliminarCliente(int id) {
        return this.controlCliente.eliminar(id);
    }

    @Override
    public Compra buscarPorIDCompra(int id) {
        return controlCompra.buscarporID(id);
    }

    @Override
    public List<Compra> buscarTodasCompra() {
        return controlCompra.buscarTodas();
    }

    @Override
    public boolean guardarCompra(Compra entidad) {
        return this.controlCompra.guardar(entidad);
    }

    @Override
    public boolean actualizarCompra(Compra entidad) {
        return this.controlCompra.actualizar(entidad);
    }

    @Override
    public boolean eliminarCompra(int id) {
        return this.controlCompra.eliminar(id);
    }

//    @Override
//    public Garantia buscarPorIDGarantia(int id) {
//        return controlGarantia.buscarporID(id);
//    }
//
//    @Override
//    public List<Garantia> buscarTodasGarantia() {
//        return controlGarantia.buscarTodas();
//    }
//
//    @Override
//    public boolean guardarGarantia(Garantia entidad) {
//        return this.controlGarantia.guardar(entidad);
//    }
//
//    @Override
//    public boolean actualizarGarantia(Garantia entidad) {
//        return this.controlGarantia.actualizar(entidad);
//    }
//
//    @Override
//    public boolean eliminarGarantia(int id) {
//        return this.controlGarantia.eliminar(id);
//    }
//
    @Override
    public Mecanico buscarPorIDMecanico(int id) {
        return controlMecanico.buscarporID(id);
    }

    @Override
    public List<Mecanico> buscarTodasMecanico() {
        return controlMecanico.buscarTodas();
    }

    @Override
    public boolean guardarMecanico(Mecanico entidad) {
        return this.controlMecanico.guardar(entidad);
    }

    @Override
    public boolean actualizarMecanico(Mecanico entidad) {
        return this.controlMecanico.actualizar(entidad);
    }

    @Override
    public boolean eliminarMecanico(int id) {
        return this.controlMecanico.eliminar(id);
    }

    @Override
    public Pieza buscarPorIDPieza(int id) {
        return controlPieza.buscarporID(id);
    }

    @Override
    public List<Pieza> buscarTodasPieza() {
        return controlPieza.buscarTodas();
    }

    @Override
    public boolean guardarPieza(Pieza entidad) {
        return this.controlPieza.guardar(entidad);
    }

    @Override
    public boolean actualizarPieza(Pieza entidad) {
        return this.controlPieza.actualizar(entidad);
    }

    @Override
    public boolean eliminarPieza(int id) {
        return this.controlPieza.eliminar(id);
    }

    @Override
    public RelCompraPieza buscarPorIDRelCompraPieza(int id) {
        return controlRelCP.buscarporID(id);
    }

    @Override
    public List<RelCompraPieza> buscarTodasRelCompraPieza() {
        return controlRelCP.buscarTodas();
    }

    @Override
    public boolean guardarRelCompraPieza(RelCompraPieza entidad) {
        return this.controlRelCP.guardar(entidad);
    }

    @Override
    public boolean actualizarRelCompraPieza(RelCompraPieza entidad) {
        return this.controlRelCP.actualizar(entidad);
    }

    @Override
    public boolean eliminarRelCompraPieza(int id) {
        return this.controlRelCP.eliminar(id);
    }

    @Override
    public Servicio buscarPorIDServicio(int id) {
        return controlServicio.buscarporID(id);
    }

    @Override
    public List<Servicio> buscarTodasServicio() {
        return controlServicio.buscarTodas();
    }

    @Override
    public boolean guardarServicio(Servicio entidad) {
        return this.controlServicio.guardar(entidad);
    }

    @Override
    public boolean actualizarServicio(Servicio entidad) {
        return this.controlServicio.actualizar(entidad);
    }

    @Override
    public boolean eliminarServicio(int id) {
        return this.controlServicio.eliminar(id);
    }

    @Override
    public Vehiculo buscarPorIDVehiculo(int id) {
        return controlVehiculo.buscarporID(id);
    }

    @Override
    public List<Vehiculo> buscarTodasVehiculo() {
        return controlVehiculo.buscarTodas();
    }

    @Override
    public boolean guardarVehiculo(Vehiculo entidad) {
        return this.controlVehiculo.guardar(entidad);
    }

    @Override
    public boolean actualizarVehiculo(Vehiculo entidad) {
        return this.controlVehiculo.actualizar(entidad);
    }

    @Override
    public boolean eliminarVehiculo(int id) {
        return this.controlVehiculo.eliminar(id);
    }

    @Override
    public Venta buscarPorIDVenta(int id) {
        return controlVenta.buscarporID(id);
    }

    @Override
    public List<Venta> buscarTodasVenta() {
        return controlVenta.buscarTodas();
    }

    @Override
    public boolean guardarVenta(Venta entidad) {
        return this.controlVenta.guardar(entidad);
    }

    @Override
    public boolean actualizarVenta(Venta entidad) {
        return this.controlVenta.actualizar(entidad);
    }

    @Override
    public boolean eliminarVenta(int id) {
        return this.controlVenta.eliminar(id);
    }

    @Override
    public Relclientevehiculo buscarPorIDRelclientevehiculo(int id) {
        return this.controlRelCV.buscarporID(id);
    }

    @Override
    public List<Relclientevehiculo> buscarTodasRelclientevehiculo() {
        return this.controlRelCV.buscarTodas();
    }

    @Override
    public boolean guardarRelclientevehiculo(Relclientevehiculo entidad) {
        return this.controlRelCV.guardar(entidad);
    }

    @Override
    public boolean actualizarRelclientevehiculo(Relclientevehiculo entidad) {
        return this.controlRelCV.actualizar(entidad);
    }

    @Override
    public boolean eliminarRelclientevehiculo(int id) {
        return this.controlRelCV.eliminar(id);
    }

    @Override
    public Relventapieza buscarPorIDRelVentaPieza(int id) {
        return this.controlRelVP.buscarporID(id);
    }

    @Override
    public List<Relventapieza> buscarTodasRelventapieza() {
        return this.controlRelVP.buscarTodas();
    }

    @Override
    public boolean guardarRelventapieza(Relventapieza entidad) {
        return this.controlRelVP.guardar(entidad);
    }

    @Override
    public boolean actualizarRelventapieza(Relventapieza entidad) {
        return this.controlRelVP.actualizar(entidad);
    }

    @Override
    public boolean eliminarRelventapieza(int id) {
        return this.controlRelVP.eliminar(id);
    }

    @Override
    public Relventaservicio buscarPorIDRelventaservicio(int id) {
        return this.controlVS.buscarporID(id);
    }

    @Override
    public List<Relventaservicio> buscarTodasRelventaservicio() {
        return this.controlVS.buscarTodas();
    }

    @Override
    public boolean guardarRelventaservicio(Relventaservicio entidad) {
        return this.controlVS.guardar(entidad);
    }

    @Override
    public boolean actualizarRelventaservicio(Relventaservicio entidad) {
        return this.controlVS.actualizar(entidad);
    }

    @Override
    public boolean eliminarRelventaservicio(int id) {
        return this.controlVS.eliminar(id);
    }

}
