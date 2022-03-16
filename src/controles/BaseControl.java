package controles;

import java.util.List;

public interface BaseControl<T> {

    public abstract T buscarporID(int id);

    public abstract List<T> buscarTodas();

    public abstract boolean guardar(T entidad);

    public abstract boolean actualizar(T entidad);

    public abstract boolean eliminar(int id);

}
