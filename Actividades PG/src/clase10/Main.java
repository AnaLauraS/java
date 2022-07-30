package clase10;

import org.apache.log4j.Logger;
import java.util.Arrays;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {

        // con esta forma puedo crear arreglos y pasarlos como lista Arrays.asList(1,2,3,4,5,6,7,8)
        try {
            ListaPromedio lista1=new ListaPromedio(Arrays.asList(1,2,3,4,5,6,7,8));
            //ListaPromedio lista2=new ListaPromedio(Arrays.asList());
            Integer min1=lista1.calculaMinimo();
            logger.info("El minimo de la lista es " + min1);
            Integer max1=lista1.calcularMaximo();
            logger.info("El máximo de la lista es " + max1);
            logger.info("El promedio de la lista es " + lista1.promediarLista());
        } catch (Exception e){
            logger.error("La lista es igual a 0", e);
        }
    }
}
