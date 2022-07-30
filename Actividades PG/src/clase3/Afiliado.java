package clase3;

public class Afiliado extends Vendedor {
    public Afiliado(String nombre, int cantVentas) {
        super(nombre, cantVentas);
    }

    @Override
    public int calcularPuntos() {
        return this.getCantVentas()*15;
    }

    // objetivo vender: 15 puntos
}
