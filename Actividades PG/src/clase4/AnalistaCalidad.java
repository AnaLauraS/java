package clase4;

public class AnalistaCalidad {
    private Control inicial;
    private final String MENSAJE_APRO = "Todos los controles pasaron con éxito";
    private final String MENSAJE_RECH = "El artículo no pasó los controles de calidad";

    public AnalistaCalidad() {
        this.inicial = new ControlLote();
        Control controlDePeso = new ControlPeso();
        Control controlDeEnvase = new ControlEnvase();

        inicial.setSiguiente(controlDePeso);
        controlDePeso.setSiguiente(controlDeEnvase);
    }

    // método que si devuelve true quiere decir que pasó todos los controles
    public boolean analizarCalidad (Articulo a){
        return MENSAJE_APRO.equalsIgnoreCase(inicial.validarCalidad(a));
    }

    // hace el circuito: lote - peso -
}
