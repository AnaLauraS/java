package clase4;

public abstract class Control {
    protected int valorMin;
    protected int valorMax;
    protected Control siguienteControl;

    protected Control getSiguiente(){
        return this.siguienteControl;
    }
    protected void setSiguiente(Control ctl){
        this.siguienteControl = ctl;
    }

    public abstract String validarCalidad(Articulo a);
}
