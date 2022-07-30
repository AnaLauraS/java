package clase5;

public class ServicioDescargaProxy implements Servicio{
    @Override
    public String descargar(Usuario u) {
        if (u.getTipo().equalsIgnoreCase("Premium")){
            ServicioDescarga serv = new ServicioDescarga();
            return serv.descargar(u);
        }else {
            return "No es un usuario premium asi que no puede descargar musica offline";
        }
    }
}
