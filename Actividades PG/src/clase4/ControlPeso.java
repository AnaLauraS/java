package clase4;

public class ControlPeso extends Control{
    public ControlPeso() {
        this.valorMin = 1200;
        this.valorMax = 1300;
    }

    @Override
    public String validarCalidad(Articulo a) {
        if (a.getPeso()<2000 && a.getPeso()>1000){
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
