package clase19;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List <Contacto> contactos = new ArrayList<>();

        Contacto c1 = new Contacto("maria", "email1", 122);
        Contacto c2 = new Contacto("jose", "email2", 3456);
        Contacto c3 = new Contacto("fulano", "email3", 6546);
        Contacto c4 = new Contacto("fulana", "email4", 576);
        Contacto c5 = new Contacto("fernanda", "email5", 887);

        contactos.add(c1);
        contactos.add(c2);
        contactos.add(c3);
        contactos.add(c4);
        contactos.add(c5);

        // inicio el sistema de escritura
        FileOutputStream escritura = null;
        FileInputStream lectura = null;

        // lista que va a tener lo que recuperemos de la lectura
        List <Contacto> contactosRecuperados = null;

        // intento crear el archivo y escribirlo
        try {
            // creo el archivo de escritura (ojo que sobreescribe todo el archivo)
            escritura = new FileOutputStream("contactos.txt");

            // creo el objeto que va a escribir en el archivo y le digo en qué archivo
            ObjectOutputStream oEscitura = new ObjectOutputStream(escritura);

            // llamo a ese objeto para que escriba
            oEscitura.writeObject(contactos);
            oEscitura.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // ahora intento abrir el archivo y leerlo
        try {
            lectura = new FileInputStream("contactos.txt");

            //creo el objeto que leerá
            ObjectInputStream oLectura = new ObjectInputStream(lectura);

            //guardo en una lista lo recuperado
            contactosRecuperados = (ArrayList<Contacto>)oLectura.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // pruebo qué me trae lo que recuperé:
        for (Contacto c:contactosRecuperados) {
            System.out.println("Contacto recuperado: "+ c.getNombre());
        }
    }
}
