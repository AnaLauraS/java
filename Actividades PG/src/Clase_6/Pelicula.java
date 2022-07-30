package Clase_6;

public class Pelicula {

    private String nombre;
    private String pais;
    private String link;

    public Pelicula(String nombre, String pais, String link) {
        this.nombre = nombre;
        this.pais = pais;
        this.link = link;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
