package dominio;

import dominio.Servicio;
import dominio.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-03-15T21:21:12")
@StaticMetamodel(Relventaservicio.class)
public class Relventaservicio_ { 

    public static volatile SingularAttribute<Relventaservicio, Venta> idventa;
    public static volatile SingularAttribute<Relventaservicio, Servicio> idservicio;
    public static volatile SingularAttribute<Relventaservicio, Integer> idrelVentaServicio;

}