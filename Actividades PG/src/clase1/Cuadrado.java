package clase1;

public class Cuadrado extends Figura {
    public Cuadrado(double dato) {
        super(dato);
    }

    @Override
    public double area() {
        if (this.getDato() > 0) {
            return this.getDato()*this.getDato();
        } else {
            System.out.println("El valor del radio o lado debe ser mayor que cero");
            return 0;
        }
    }
}
