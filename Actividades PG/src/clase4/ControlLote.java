package clase4;

public class ControlLote extends Control{

    public ControlLote() {
        this.valorMin = 1000;
        this.valorMax = 2000;
    }

    @Override
    public String validarCalidad(Articulo a) {
        if (a.getLote()<2000 && a.getLote()>1000){
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
