package dominio;

import dominio.Pieza;
import dominio.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-03-15T21:21:12")
@StaticMetamodel(Relventapieza.class)
public class Relventapieza_ { 

    public static volatile SingularAttribute<Relventapieza, Venta> idventa;
    public static volatile SingularAttribute<Relventapieza, Pieza> idpieza;
    public static volatile SingularAttribute<Relventapieza, String> cantidad;
    public static volatile SingularAttribute<Relventapieza, Integer> idrelventapieza;

}