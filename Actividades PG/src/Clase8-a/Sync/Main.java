package Clase8.Sync;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalDate inicial = LocalDate.of(2022,6,12);
        LocalTime time = LocalTime.of(12,30);

        List<Vuelo> vuelos = new ArrayList<>();
        vuelos.add(new Vuelo(inicial, time, inicial, time.plusHours(1),"Bogotá", "Medellín"));
        vuelos.add(new Vuelo(inicial.plusDays(10), time, inicial.plusDays(10), time.plusHours(1),"Medellín", "Bogotá"));

        List<Hotel> hoteles = new ArrayList<>();
        hoteles.add(new Hotel("Hilton",inicial,inicial.plusDays(10),"Medellín"));

        IFacadeService facadeService = new FacadeService();

        String res = facadeService.buscarPlanTuristico(inicial,inicial.plusDays(10),"Bogotá","Medellín",vuelos, hoteles);

        System.out.println(res);
    }
}
