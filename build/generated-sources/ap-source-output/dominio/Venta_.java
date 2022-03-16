package dominio;

import dominio.Cliente;
import dominio.Relventapieza;
import dominio.Relventaservicio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-03-15T21:21:12")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Integer> idventa;
    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, Double> total;
    public static volatile ListAttribute<Venta, Relventaservicio> relventaservicioList;
    public static volatile SingularAttribute<Venta, String> notas;
    public static volatile ListAttribute<Venta, Relventapieza> relventapiezaList;
    public static volatile SingularAttribute<Venta, Cliente> idcliente;

}