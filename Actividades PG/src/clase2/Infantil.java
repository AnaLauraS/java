package clase2;

import java.util.Scanner;

public class Infantil extends Menu {
    public Infantil(double precioBase) {
        super(precioBase);
        this.setMensaje("Se cobran $3 por juguete adicional. Ingrese cantidad de juguetes");
    }

    @Override
    public double calculoPrecio() {
        Scanner scan = new Scanner(System.in);
        int cantidadJuguetes = scan.nextInt();
        while (cantidadJuguetes<0){
            System.out.println("No ingresó una cantidad valida. Reintente.");
            cantidadJuguetes = scan.nextInt();
        }
        return this.getPrecioBase()+cantidadJuguetes*3;
    }

    // debido a que lo diseño con Scanner para cumplir con la consigna de que se indique al usuario cómo armar el menú, cuando quiero hacer correr el test se tilda porque la pantalla desde donde se ejecuta es de solo lectura y no me permite continuar con el proceso. Por eso, creo acá el método que me servirá para el test

    public double precioFinal (int cantidadJuguetes){
        if (cantidadJuguetes>0) {
            return this.getPrecioBase() + cantidadJuguetes * 3;
        } else {
            System.out.println("ingresó una cantidad inválida, por lo que no se modificó el menú");
            return this.getPrecioBase();
        }

    }

    // 3pesos por juguete
}
