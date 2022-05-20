package dominio;

import dominio.Relventaservicio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-19T23:08:27")
@StaticMetamodel(Servicio.class)
public class Servicio_ { 

    public static volatile SingularAttribute<Servicio, Date> fecha;
    public static volatile SingularAttribute<Servicio, Date> proximoServicio;
    public static volatile ListAttribute<Servicio, Relventaservicio> relventaservicioList;
    public static volatile SingularAttribute<Servicio, Double> costo;
    public static volatile SingularAttribute<Servicio, String> concepto;
    public static volatile SingularAttribute<Servicio, Integer> idservicio;

}