package dominio;

import dominio.Relclientevehiculo;
import dominio.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-19T23:08:27")
@StaticMetamodel(Vehiculo.class)
public class Vehiculo_ { 

    public static volatile SingularAttribute<Vehiculo, String> marca;
    public static volatile ListAttribute<Vehiculo, Venta> ventaList;
    public static volatile SingularAttribute<Vehiculo, Integer> idvehiculo;
    public static volatile SingularAttribute<Vehiculo, String> modelo;
    public static volatile SingularAttribute<Vehiculo, String> nombre;
    public static volatile ListAttribute<Vehiculo, Relclientevehiculo> relclientevehiculoList;

}