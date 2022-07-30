package Clase8.Sync;

import java.time.LocalDate;

public class Hotel {

    private final String nombre;
    private final LocalDate entrada;
    private final LocalDate salida;
    private final String ciudad;

    public Hotel(String nombre, LocalDate entrada, LocalDate salida, String ciudad) {
        this.nombre = nombre;
        this.entrada = entrada;
        this.salida = salida;
        this.ciudad = ciudad;
    }

    public LocalDate getEntrada() {
        return entrada;
    }

    public LocalDate getSalida() {
        return salida;
    }

    public String getCiudad() {
        return ciudad;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "nombre='" + nombre + '\'' +
                ", llegada=" + entrada +
                ", salida=" + salida +
                ", ciudad='" + ciudad + '\'' +
                '}';
    }
}
