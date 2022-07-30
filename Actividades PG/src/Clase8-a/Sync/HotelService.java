package Clase8.Sync;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HotelService {

    private List<Hotel> hoteles;

    public HotelService() {
        hoteles = new ArrayList<>();
    }

    public List<Hotel> BuscarHotel(LocalDate entrada, LocalDate salida, String ciudad){
        List<Hotel> resultado = new ArrayList<>();
        for (Hotel hotel : hoteles){
            if (hotel.getEntrada().equals(entrada)
                    && hotel.getSalida().equals(salida)
                    && hotel.getCiudad().equalsIgnoreCase(ciudad)){
                resultado.add(hotel);
            }
        }

        return resultado;
    }

    public void setHoteles(List<Hotel> hoteles) {
        this.hoteles = hoteles;
    }
}
