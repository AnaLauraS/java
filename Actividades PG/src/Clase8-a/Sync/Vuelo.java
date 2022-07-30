package Clase8.Sync;

import java.time.LocalDate;
import java.time.LocalTime;

public class Vuelo {
    private LocalDate salida;
    private LocalTime horaDeSalida;
    private LocalDate llegada;
    private LocalTime horaDeLlegada;
    private String ciudadOrigen;
    private String ciudadDestino;

    public Vuelo(LocalDate salida, LocalTime horaDeSalida, LocalDate llegada, LocalTime horaDeLlegada, String ciudadOrigen, String ciudadDestino) {
        this.salida = salida;
        this.horaDeSalida = horaDeSalida;
        this.llegada = llegada;
        this.horaDeLlegada = horaDeLlegada;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }

    public LocalDate getSalida() {
        return salida;
    }

    public LocalTime getHoraDeSalida() {
        return horaDeSalida;
    }

    public LocalDate getLlegada() {
        return llegada;
    }

    public LocalTime getHoraDeLlegada() {
        return horaDeLlegada;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "salida=" + salida +
                ", horaDeSalida=" + horaDeSalida +
                ", llegada=" + llegada +
                ", horaDeLlegada=" + horaDeLlegada +
                ", ciudadOrigen='" + ciudadOrigen + '\'' +
                ", ciudadDestino='" + ciudadDestino + '\'' +
                '}';
    }
}
