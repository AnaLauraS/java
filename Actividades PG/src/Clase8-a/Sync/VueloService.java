package Clase8.Sync;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class VueloService {

    private List<Vuelo> vuelos;

    public VueloService() {
        this.vuelos = new ArrayList<>();
    }

    public PlanDeVuelo BuscarVuelos(LocalDate salida, LocalDate regreso, String origen, String destino){
        PlanDeVuelo resultados = new PlanDeVuelo();

        for (Vuelo vuelo: vuelos) {
            if (vuelo.getSalida().equals(salida)
                    && vuelo.getCiudadOrigen().equalsIgnoreCase(origen)
                    && vuelo.getCiudadDestino().equalsIgnoreCase(destino)){
                resultados.RegistrarVueloIda(vuelo);
            }
            if (vuelo.getSalida().equals(regreso)
                    && vuelo.getCiudadOrigen().equalsIgnoreCase(destino)
                    && vuelo.getCiudadDestino().equalsIgnoreCase(origen)){
                resultados.RegistrarVueloRegreso(vuelo);
            }
        }

        return resultados;
    }

    public void setVuelos(List<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
}
