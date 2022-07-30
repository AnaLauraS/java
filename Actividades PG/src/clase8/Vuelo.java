package clase8;

import java.util.Date;

public class Vuelo {
    private String ciudadDestino;
    private String ciudadOrigen;
    private Date inicioDisponibilidad;
    private Date finDisponibilidad;
    private int idVuelo;

    public Vuelo(String ciudadDestino, String ciudadOrigen, Date inicioDisponibilidad, Date finDisponibilidad, int idVuelo) {
        this.ciudadDestino = ciudadDestino;
        this.ciudadOrigen = ciudadOrigen;
        this.inicioDisponibilidad = inicioDisponibilidad;
        this.finDisponibilidad = finDisponibilidad;
        this.idVuelo = idVuelo;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public Date getInicioDisponibilidad() {
        return inicioDisponibilidad;
    }

    public void setInicioDisponibilidad(Date inicioDisponibilidad) {
        this.inicioDisponibilidad = inicioDisponibilidad;
    }

    public Date getFinDisponibilidad() {
        return finDisponibilidad;
    }

    public void setFinDisponibilidad(Date finDisponibilidad) {
        this.finDisponibilidad = finDisponibilidad;
    }
}
