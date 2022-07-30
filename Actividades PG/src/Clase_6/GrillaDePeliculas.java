package Clase_6;

import java.util.HashMap;

public class GrillaDePeliculas implements IGrillaDePeliculas{


    @Override
    public Pelicula getPelicula(String nombre) {
        Pelicula peli = null;

        HashMap<String,Pelicula> peliculas = new HashMap<>();
        peliculas.put("No way home",new Pelicula("No way home","argentina","link1"));
        peliculas.put("Love and Thunder",new Pelicula("Love and Thunder","brasil","link2"));
        peliculas.put("El Paseo 5",new Pelicula("El Paseo 5","colombia","link3"));

        if(peliculas.containsKey(nombre)){
            return peliculas.get(nombre);
        }

        return peli;
    }
}
