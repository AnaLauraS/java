package clase8;

import java.util.Date;

public class BusquedaFacade implements Busqueda {
    private BusquedaHotel buscadorHoteles;
    private BusquedaVuelo buscadorVuelos;

    public BusquedaFacade(BusquedaHotel buscadorHoteles, BusquedaVuelo buscadorVuelos) {
        this.buscadorHoteles = buscadorHoteles;
        this.buscadorVuelos = buscadorVuelos;
    }

    @Override
    public void busqueda(String ciudadOrigen, String ciudadDestino, Date fechaSalida, Date fechaRegreso) {
        this.buscadorHoteles.busquedaHoteles(ciudadDestino,fechaSalida,fechaRegreso);
        this.buscadorVuelos.busquedaVuelos(ciudadOrigen,ciudadDestino,fechaSalida,fechaRegreso);
    }

    // Los parámetros de búsqueda: ciudad del hotel, y la fecha desde-donde
}
