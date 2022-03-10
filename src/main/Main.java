package main;

import controladores.AdministradorJpaController;
import controladores.ClienteJpaController;
import controladores.GarantiaJpaController;
import controladores.MecanicoJpaController;
import controladores.VehiculoJpaController;
import dominio.Administrador;
import dominio.Cliente;
import dominio.Garantia;
import dominio.Mecanico;
import dominio.Vehiculo;
import java.util.Date;


public class Main {


    public static void main(String[] args) {
        AdministradorJpaController adminDAO = new AdministradorJpaController();
        Administrador admin = new Administrador("Luis", "644446783", "LuisAdmin1", "pass");
        adminDAO.create(admin);
        
//        GarantiaJpaController garantiaDAO = new GarantiaJpaController();
//        Garantia garantia = new Garantia(new Date());
//        garantiaDAO.create(garantia);
        
//        VehiculoJpaController vehiculoDAO = new VehiculoJpaController();
//        Vehiculo vehiculo = new Vehiculo("2011", "Toyota", "Ford");
//        vehiculoDAO.create(vehiculo);
        
//        MecanicoJpaController mecanicoDAO = new MecanicoJpaController();
//        Mecanico mecanico = new Mecanico("Alberto", "53444", "AlbertoMecanico", "4321");
//        mecanicoDAO.create(mecanico);

//         ClienteJpaController clienteDAO = new ClienteJpaController();
//         Cliente cliente = new Cliente("Villa Itson", "Fernando", "641203", vehiculoDAO.findVehiculo(1));
//        clienteDAO.create(cliente);

    }
    
}
