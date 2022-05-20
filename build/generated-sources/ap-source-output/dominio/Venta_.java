package dominio;

import dominio.Cliente;
import dominio.Relventapieza;
import dominio.Vehiculo;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-19T23:08:27")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Integer> idventa;
    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, Double> total;
    public static volatile SingularAttribute<Venta, String> vendedor;
    public static volatile SingularAttribute<Venta, String> notas;
    public static volatile SingularAttribute<Venta, Vehiculo> idvehiculo;
    public static volatile ListAttribute<Venta, Relventapieza> relventapiezaList;
    public static volatile SingularAttribute<Venta, Cliente> idcliente;

}