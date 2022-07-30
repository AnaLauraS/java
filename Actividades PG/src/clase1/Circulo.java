package clase1;

public class Circulo extends Figura {
    public Circulo(double dato) {
        super(dato);
    }

    @Override
    public double area() {
        if (this.getDato() > 0) {
            return this.getDato() * this.getDato() * Math.PI;
        } else {
            System.out.println("El valor del radio o lado debe ser mayor que cero");
            return 0;
        }
    }

}
