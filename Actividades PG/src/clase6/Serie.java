package clase6;

public class Serie {
    private String nombre;
    private int cantVistas;

    public Serie(String nombre, int cantVistas) {
        this.nombre = nombre;
        this.cantVistas = cantVistas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantVistas() {
        return cantVistas;
    }

    public void setCantVistas(int cantVistas) {
        this.cantVistas = cantVistas;
    }
}
