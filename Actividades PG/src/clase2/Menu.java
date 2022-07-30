package clase2;

public abstract class Menu {
    private double precioBase;
    private String mensaje;

    public Menu(double precioBase) {
        this.precioBase = precioBase;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public double armadoDelMenu() {
        System.out.println(this.getMensaje());
        return calculoPrecio();
    };

    public abstract double calculoPrecio();
    // funcion armado con mensaje sobre como armar el menu y devuelve el costo final
    // funcion calculo de precio
}
