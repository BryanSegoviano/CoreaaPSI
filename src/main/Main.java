package main;

import accesoDatos.ClienteJpaController;
import accesoDatos.RelclientevehiculoJpaController;
import accesoDatos.VehiculoJpaController;
import dominio.Cliente;
import dominio.Relclientevehiculo;
import dominio.Vehiculo;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
//

public class Main {

    public static void main(String[] args) {
        
        EntityManagerFactory et = Persistence.createEntityManagerFactory("CoreaaPU");
        ClienteJpaController clientes = new ClienteJpaController(et);
        VehiculoJpaController vehiculos = new VehiculoJpaController(et);
        RelclientevehiculoJpaController clientevehiculos = new RelclientevehiculoJpaController(et);
        
//        System.out.println(vehiculos.findVehiculo(27));
//        List<Relclientevehiculo> clienteVehiculo = clientevehiculos.findRelclientevehiculoEntities();
//        for (Relclientevehiculo relclientevehiculo : clienteVehiculo) {
//            System.out.println(relclientevehiculo.getIdvehiculo());
//        }
        //CLIENTES
        //Agregar cliente       
//        Cliente cliente = new Cliente("P.O", "Maria Juarez", "6441572891");
//        clientes.create(cliente);
        //Consultar cliente
//        Cliente clienteBD = clientes.findCliente(34);
//        System.out.println(clienteBD);
        //Editar cliente
//        try {
//            Cliente clienteBD = clientes.findCliente(33);
//            cliente.setDireccion("Colonia México");
//            clientes.edit(clienteBD);
//        }catch(Exception ex){
//            System.out.println(ex);
//        }

        //VEHICULOS
        //Agregar vehiculo y relacion con un cliente
//        Vehiculo vehiculo = new Vehiculo("2007", "Huzui", "Huzui");
//        vehiculos.create(vehiculo);
//        Cliente clienteBD = clientes.findCliente(34);
//        Relclientevehiculo relClientevehiculo = new Relclientevehiculo(clienteBD, vehiculo);
//        clientevehiculos.create(relClientevehiculo);
        //Consultar vehiculo
//        Vehiculo vehiculoBD = vehiculos.findVehiculo(28);
//        System.out.println(vehiculoBD);
        //Editar vehiculo
//        try {
//            Vehiculo vehiculoBD = vehiculos.findVehiculo(28);
//            vehiculoBD.setNombre("Honda");
//            vehiculos.edit(vehiculoBD);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }

    }

}
