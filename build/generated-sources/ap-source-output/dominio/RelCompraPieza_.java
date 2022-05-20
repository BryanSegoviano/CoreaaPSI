package dominio;

import dominio.Compra;
import dominio.Pieza;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-05-19T23:08:27")
@StaticMetamodel(RelCompraPieza.class)
public class RelCompraPieza_ { 

    public static volatile SingularAttribute<RelCompraPieza, Compra> idcompra;
    public static volatile SingularAttribute<RelCompraPieza, Integer> idrelCompraPiezas;
    public static volatile SingularAttribute<RelCompraPieza, Pieza> idpieza;
    public static volatile SingularAttribute<RelCompraPieza, Integer> cantidad;

}