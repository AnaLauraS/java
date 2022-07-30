package Clase8.Sync;

import java.time.LocalDate;
import java.util.List;

public class FacadeService implements IFacadeService{

    private VueloService vueloService;
    private HotelService hotelService;

    public FacadeService() {
        vueloService = new VueloService();
        hotelService = new HotelService();
    }

    @Override
    public String buscarPlanTuristico(LocalDate salida, LocalDate llegada, String origen, String destino,
                                      List<Vuelo> vuelos, List<Hotel> hoteles) {
        vueloService.setVuelos(vuelos);
        hotelService.setHoteles(hoteles);
        PlanDeVuelo planesDeVuelo = vueloService.BuscarVuelos(salida,llegada,origen,destino);
        List<Hotel> alojamiento = hotelService.BuscarHotel(salida,llegada,destino);
        String respuesta = "";

        for (Vuelo vuelo: planesDeVuelo.getVuelosDeIda()){
            respuesta += "*********** Vuelos de Ida ***********\n";
            respuesta += vuelo.toString() + "\n";
        }
        for (Vuelo vuelo: planesDeVuelo.getVuelosDeRegreso()){
            respuesta += "*********** Vuelos de regreso ***********\n";
            respuesta += vuelo.toString() + "\n";
        }

        for (Hotel hotel: alojamiento){
            respuesta += "*********** Hoteles ***********\n";
            respuesta += hotel.toString() + "\n";
        }

        return respuesta;
    }
}
