package clase5;

public class ServicioDescarga implements Servicio{
    @Override
    public String descargar(Usuario u) {
        return "Por ser usuario premium, descargás todo";
    }
}
