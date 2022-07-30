package clase4;

public class ControlEnvase extends Control{
    public ControlEnvase() {
        this.valorMin = 0;
        this.valorMax = 1;
    }

    @Override
    public String validarCalidad(Articulo a) {
        if (a.getEnvasado()== "sano" | a.getEnvasado() == "casi sano"){
            if (this.getSiguiente()!=null) {
                return this.getSiguiente().validarCalidad(a);
            } else {
                return "Todos los controles pasaron con éxito";
            }
        } else {
            return "El artículo no pasó los controles de calidad";
        }
    }
}
