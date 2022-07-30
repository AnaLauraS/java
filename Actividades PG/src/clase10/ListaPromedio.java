package clase10;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ListaPromedio {

    // para usar el logger lo instancio con la clase que va a loguear
    private static final Logger logger = Logger.getLogger(ListaPromedio.class);
    private List<Integer> enteros = new ArrayList<>();

    public ListaPromedio (List<Integer> enteros) throws Exception {
        super();
        this.enteros=enteros;
        // aca mismo evaluo la lista apra emitir los logs
        if (enteros.size()>5){
            logger.info("La longitud de la lista es mayor a 5");
        } if (enteros.size()>10){
            logger.info("La longitud de la lista es mayor a 10");
        } if (enteros.size()==0){
            throw new Exception();
        }
    }

    public List<Integer> getEnteros() {
        return enteros;
    }

    public void setEnteros(List<Integer> enteros) {
        this.enteros = enteros;
    }

    public int calculaMinimo (){
        return this.enteros.stream().min(Integer::compare).get();
    }

    public int calcularMaximo (){
        return this.enteros.stream().max(Integer::compare).get();
    }

    public double promediarLista() throws Exception {
        double promedio = 0;
        double suma = 0;
        if (this.enteros.size() > 0) {
            for (Integer entero : this.enteros) {
                suma += entero;
            }
            promedio = suma / this.enteros.size();
            return promedio;

        } else {
            throw new Exception();
        }
    }
}
