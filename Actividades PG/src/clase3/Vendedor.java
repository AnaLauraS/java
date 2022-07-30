package clase3;

public abstract class Vendedor {

    private String nombre;
    private int cantVentas;

    public Vendedor(String nombre, int cantVentas) {
        this.nombre = nombre;
        this.cantVentas = cantVentas;
    }

    public int mostrarCategoria(){
        return calcularPuntos();
    }

    public void vender(int n){
        this.cantVentas+=n;
    }

    public int getCantVentas() {
        return cantVentas;
    }

    public void setCantVentas(int cantVentas) {
        this.cantVentas = cantVentas;
    }

    public abstract int calcularPuntos();

    public String recategorizar(){
        if (this.mostrarCategoria()<20){
            return(this.nombre +" tiene "+this.mostrarCategoria()+" puntos, por lo que es categoría Novato");
        } else if (this.mostrarCategoria()<31){
            return(this.nombre +" tiene "+this.mostrarCategoria()+" puntos, por lo que es categoría Aprendices");
        } else if (this.mostrarCategoria()<41){
            return(this.nombre +" tiene "+this.mostrarCategoria()+" puntos, por lo que es categoría Buenos");
        } else {
            return(this.nombre +" tiene "+this.mostrarCategoria()+" puntos, por lo que es categoría Maestros");
        }
    }


    // mostrar categoria: devuelve cantidad de puntos alcanzados
    //Los vendedores se categorizan de la siguiente manera:
    //Menos de 20 puntos = novatos.
    /*        Entre 20 y 30 puntos = aprendices.
            Entre 31 y 40 puntos = buenos.
    Más de 40 puntos = maestros.

    mostrarcategoria usa calcular puntos
    recategorizar usa mostrarcategoria y devuelve  nombre del vendedor el total de puntos y la categoría.
    */
}
