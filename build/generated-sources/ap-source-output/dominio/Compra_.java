package dominio;

import dominio.RelCompraPieza;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-19T23:08:27")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Integer> idcompra;
    public static volatile SingularAttribute<Compra, Date> fecha;
    public static volatile SingularAttribute<Compra, Double> total;
    public static volatile ListAttribute<Compra, RelCompraPieza> relCompraPiezaList;

}