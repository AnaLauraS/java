package clase3;

public class Empleado extends Vendedor{
    private int antiguedad;
    private int cantAfiliados;

    public Empleado(String nombre, int cantVentas, int ant, int af) {
        super(nombre, cantVentas);
        this.antiguedad=ant;
        this.cantAfiliados=af;
    };

    public void conseguirAfiliado (int n){
        this.cantAfiliados+=n;
    };

    @Override
    public int calcularPuntos() {
        return this.cantAfiliados*10+this.antiguedad*5+this.getCantVentas()*5;
    }


    // objetivo conseguirAfiliado: 10 puntos, y vender: 5 puntos
    // + 5 puntos por año de antiguedad
}
