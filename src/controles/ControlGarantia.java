//package controles;
//
//import dominio.Garantia;
//import java.util.List;
//
//
//public class ControlGarantia implements BaseControl<Garantia>{
//
//    public ControlGarantia() {
//    }
//
//    @Override
//    public Garantia buscarporID(int id) {
//        return fachada.buscarPorIDGarantia(id);
//    }
//
//    @Override
//    public List<Garantia> buscarTodas() {
//        return fachada.buscarTodasGarantia();
//    }
//
//    @Override
//    public boolean guardar(Garantia entidad) {
//        return fachada.guardarGarantia(entidad);
//    }
//
//    @Override
//    public boolean actualizar(Garantia entidad) {
//        return fachada.actualizarGarantia(entidad);
//    }
//
//    @Override
//    public boolean eliminar(int id) {
//        return fachada.eliminarGarantia(id);
//    }
//    
//}
