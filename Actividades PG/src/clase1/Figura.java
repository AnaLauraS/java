package clase1;

public abstract class Figura {
    private double dato;

    public Figura(double dato) {
        this.dato = dato;
    }

    public double getDato() {
        return dato;
    }

    public void setDato(double dato) {
        this.dato = dato;
    }

    public abstract double area();
}
