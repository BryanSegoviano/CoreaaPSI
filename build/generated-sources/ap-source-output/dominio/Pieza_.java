package dominio;

import dominio.RelCompraPieza;
import dominio.Relventapieza;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-19T23:08:27")
@StaticMetamodel(Pieza.class)
public class Pieza_ { 

    public static volatile SingularAttribute<Pieza, Double> costo;
    public static volatile SingularAttribute<Pieza, Integer> idpieza;
    public static volatile SingularAttribute<Pieza, Date> fechaGarantia;
    public static volatile ListAttribute<Pieza, Relventapieza> relventapiezaList;
    public static volatile SingularAttribute<Pieza, Integer> cantidad;
    public static volatile SingularAttribute<Pieza, String> nombre;
    public static volatile ListAttribute<Pieza, RelCompraPieza> relCompraPiezaList;

}