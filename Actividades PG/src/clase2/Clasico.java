package clase2;

public class Clasico extends Menu {
    public Clasico(double precioBase) {
        super(precioBase);
        this.setMensaje("Este menú no puede personalizarse");
    }

    @Override
    public double calculoPrecio() {
        return this.getPrecioBase();
    }

    // sin recargos
}
