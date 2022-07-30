package clase8;

import java.util.Date;

public class BusquedaHotel {
    private Hotel[] listaHoteles;

    public BusquedaHotel(Hotel[] listaHoteles) {
        this.listaHoteles = listaHoteles;
    }

    public void agregarHotel (Hotel h){
        listaHoteles[listaHoteles.length]=h;
    }

    public void busquedaHoteles(String ciudad, Date fechaIngreso, Date fechaSalida){

        for (int i=0; i<listaHoteles.length; i++){
            if (listaHoteles[i].getCiudad()==ciudad && (listaHoteles[i].getInicioDisponibilidad()==fechaIngreso | listaHoteles[i].getInicioDisponibilidad().before(fechaIngreso)) && (listaHoteles[i].getFinDisponibilidad()==fechaSalida | listaHoteles[i].getFinDisponibilidad().after(fechaSalida))){
                System.out.println("El hotel "+ listaHoteles[i].getNombre()+" está disponible en fechas solicitadas" );
            }
        }
    }
    // por fecha de entrada, fecha de salida, ciudad.
}
