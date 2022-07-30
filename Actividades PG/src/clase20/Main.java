package clase20;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Empleado e1 = new Empleado("carlos", "mendez", "l01", 23.56D);
        Empleado e2 = new Empleado("maria", "fulano", "l02", 123.56D);
        Empleado e3 = new Empleado("josefa", "estevanez", "l03", 233.56D);
        Empleado e4 = new Empleado("jose", "koi", "l04", 23.50D);

        List <Empleado> listaEmpleados = new ArrayList<>();
        listaEmpleados.add(e1);
        listaEmpleados.add(e2);
        listaEmpleados.add(e3);
        listaEmpleados.add(e4);

        Empresa empresa1 = new Empresa("Benito SRL", 1234);
        empresa1.setEmpleados(listaEmpleados);

        // inicio el sistema de escritura
        FileOutputStream escritura = null;

        // lista que va a tener lo que recuperemos de la lectura
        List <Empleado> empleadosRecuperados = null;

        // intento crear el archivo y escribirlo
        try {
            // creo el archivo de escritura (ojo que sobreescribe todo el archivo)
            escritura = new FileOutputStream("empleados.txt");

            // creo el objeto que va a escribir en el archivo y le digo en qué archivo
            BufferedOutputStream oEscritura = new BufferedOutputStream(escritura);

            // creo el string a mostrar:
            String texto = "";
            for (Empleado e: listaEmpleados) {
                texto+= e.getNombre()+";"+e.getApellido()+";"+e.getLegajo()+";"+e.getSueldo()+"\n";
            }
            System.out.println(texto);

            // llamo a ese objeto para que escriba
            oEscritura.write(texto.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
