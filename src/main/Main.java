//package main;
//
//import accesoDatos.AdministradorJpaController;
//import accesoDatos.ClienteJpaController;
//import accesoDatos.GarantiaJpaController;
//import accesoDatos.MecanicoJpaController;
//import accesoDatos.PiezaJpaController;
//import accesoDatos.RelclientevehiculoJpaController;
//import accesoDatos.RelventapiezaJpaController;
//import accesoDatos.RelventaservicioJpaController;
//import accesoDatos.ServicioJpaController;
//import accesoDatos.VehiculoJpaController;
//import accesoDatos.VentaJpaController;
//import dominio.Administrador;
//import dominio.Cliente;
//import dominio.Garantia;
//import dominio.Mecanico;
//import dominio.Pieza;
//import dominio.Relclientevehiculo;
//import dominio.Relventapieza;
//import dominio.Relventaservicio;
//import dominio.Servicio;
//import dominio.Vehiculo;
//import dominio.Venta;
//import java.util.ArrayList;
//import java.util.Date;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//public class Main {
//
//    public static void main(String[] args) {
//        EntityManagerFactory et = Persistence.createEntityManagerFactory("CoreaaPU");
//
////        AdministradorJpaController adminDAO = new AdministradorJpaController(Persistence.createEntityManagerFactory("CoreaaPU"));
////        Administrador admin = new Administrador("Bryan", "644201923", "BryanAdmin", "4321");
////        adminDAO.create(admin);
////        GarantiaJpaController garantiaDAO = new GarantiaJpaController();
////        Garantia garantia = new Garantia(new Date());
////        garantiaDAO.create(garantia);
////        MecanicoJpaController mecanicoDAO = new MecanicoJpaController(et);
////        Mecanico mecanico = new Mecanico("Bob", "644112345", "BobMecanico", "mecanico");
////        mecanicoDAO.create(mecanico);
//        //PASOS PARA AGREGAR UN CLIENTE, VEHICULO Y RELACIONAR UN SOLO VEHICULO CON
//        //UN CLIENTE.
////        VehiculoJpaController vehiculoDAO = new VehiculoJpaController(et);
////        Vehiculo vehiculo = new Vehiculo("2022", "Maverick", "Ford");
////        vehiculoDAO.create(vehiculo);
////        ClienteJpaController clientes = new ClienteJpaController(et);
////        Cliente cliente = new Cliente("Montecarlo", "Alfonso", "642131");
////        clientes.create(cliente);      
////        RelclientevehiculoJpaController clientevehiculo = new RelclientevehiculoJpaController(et);
////        Relclientevehiculo relClientevehiculo = new Relclientevehiculo(cliente, vehiculo);
////        clientevehiculo.create(relClientevehiculo);
////        PiezaJpaController piezas = new PiezaJpaController(et);
////        Pieza pieza = new Pieza("Bujes", 13.50, 0);
////        piezas.create(pieza);
//
////PASOS PARA AGREGAR UNA VENTA, SERVICIOS, PIEZAS Y RELACIONAR QUE SERVICIOS Y
////PIEZAS LE PERTENECEN A UNA VENTA.
//        ClienteJpaController clientes = new ClienteJpaController(et);
//        VentaJpaController ventas = new VentaJpaController(et);
//        PiezaJpaController piezas = new PiezaJpaController(et);
//        ServicioJpaController servicios = new ServicioJpaController(et);
//        RelventaservicioJpaController ventasservicio = new RelventaservicioJpaController(et);
//        RelventapiezaJpaController ventapieza = new RelventapiezaJpaController(et);
//
//        ArrayList<Servicio> listaServicio = new ArrayList<>();
//        ArrayList<Pieza> listaPieza = new ArrayList<>();
//
//        Servicio servicio = new Servicio(new Date(), 70.50, "Cambio de bujes3");
//        Servicio servicio2 = new Servicio(new Date(), 10.10, "Cambio de balatas3");
//        Servicio servicio3 = new Servicio(new Date(), 70, "Cambio de aceite3");
//        listaServicio.add(servicio);
//        listaServicio.add(servicio2);
//        listaServicio.add(servicio3);
//
//        for (int i = 0; i < listaServicio.size(); i++) {
//            servicios.create(listaServicio.get(i));
//        }
//
//        Pieza pieza = new Pieza("Suspension3", 200.99, 3);
//        Pieza pieza2 = new Pieza("Bujes3", 13.55, 5);
//        Pieza pieza3 = new Pieza("Manijas3", 101, 3);
//        listaPieza.add(pieza);
//        listaPieza.add(pieza2);
//        listaPieza.add(pieza3);
//        for (int i = 0; i < listaPieza.size(); i++) {
//            piezas.create(listaPieza.get(i));
//        }
//
//        Date fecha = new Date();
//        Cliente cliente = clientes.findCliente(1);
//        String notas = "3ra venta de prueba";
//        Double total = 140.60;
//
//        Venta venta = new Venta(fecha, total, notas, cliente);
//        ventas.create(venta);
//
//        for (int i = 0; i < listaServicio.size(); i++) {
//            Relventaservicio relVentaServicio = new Relventaservicio(listaServicio.get(i), venta);
//            ventasservicio.create(relVentaServicio);
//        }
//
//        for (int i = 0; i < listaPieza.size(); i++) {
//            Relventapieza relVentaPieza = new Relventapieza(listaPieza.get(i).getCantidad() + "", listaPieza.get(i), venta);
//            ventapieza.create(relVentaPieza);
//        }
//
//    }
//
//}
