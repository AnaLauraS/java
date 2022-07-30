package clase2;

import java.util.Scanner;

public class Vegetariano extends Menu{
    public Vegetariano(double precioBase) {
        super(precioBase);
        this.setMensaje("Puede añadir más especias, eso aumenta el precio un 1%. Y puede agregar más salsa, cada una sale $2. Ingrese primero la cantidad de especias a agregar y luego la cantidad de salsas");
    }

    @Override
    public double calculoPrecio() {
        Scanner scan = new Scanner(System.in);
        int cantidadEspecias = scan.nextInt();
        int cantidadSalsas = scan.nextInt();
        while (cantidadEspecias<0 | cantidadSalsas<0){
            System.out.println("No ingresó una cantidad valida. Reintente.");
            cantidadEspecias = scan.nextInt();
            cantidadSalsas = scan.nextInt();
        }
        return this.getPrecioBase()+cantidadEspecias*0.01*this.getPrecioBase()+cantidadSalsas*2;
    }

    // debido a que lo diseño con Scanner para cumplir con la consigna de que se indique al usuario cómo armar el menú, cuando quiero hacer correr el test se tilda porque la pantalla desde donde se ejecuta es de solo lectura y no me permite continuar con el proceso. Por eso, creo acá el método que me servirá para el test

    public double precioFinal (int especias, int salsas){
        if (especias<0 | salsas<0){
            System.out.println("No ingresó una cantidad valida. No se modifica valor.");
            return this.getPrecioBase();
        }
        return this.getPrecioBase()+especias*0.01*this.getPrecioBase()+salsas*2;
    }

    // 1porciento por especias y 2pesos por salsa vegetariana
}
