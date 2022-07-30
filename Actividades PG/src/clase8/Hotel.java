package clase8;

import java.util.Date;

public class Hotel {
    private String ciudad;
    private Date inicioDisponibilidad;
    private Date finDisponibilidad;
    private String nombre;

    public Hotel(String ciudad, Date inicioDisponibilidad, Date finDisponibilidad, String nombre) {
        this.ciudad = ciudad;
        this.inicioDisponibilidad = inicioDisponibilidad;
        this.finDisponibilidad = finDisponibilidad;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
