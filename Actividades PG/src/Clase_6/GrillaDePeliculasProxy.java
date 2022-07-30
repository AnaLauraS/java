package Clase_6;

public class GrillaDePeliculasProxy implements IGrillaDePeliculas{

    private GrillaDePeliculas grilla;
    private IP ip;

    public Pelicula getPelicula(String nombrePelicula) throws PeliculaNoHabilitadaException {
        Pelicula peli = grilla.getPelicula(nombrePelicula);
        if(! ip.getPais().equalsIgnoreCase(peli.getPais())){
            throw new PeliculaNoHabilitadaException(nombrePelicula+" no habilitada en "+getLaIP().getPais());
        }
        return peli;
    }

    public GrillaDePeliculasProxy(GrillaDePeliculas grilla) {
        this.grilla = grilla;
    }

    public void setLaIP(IP laIP) {
        this.ip = laIP;
    }

    public IP getLaIP() {
        return ip;
    }

    public void setGrilla(GrillaDePeliculas grilla) {
        this.grilla = grilla;
    }
}
