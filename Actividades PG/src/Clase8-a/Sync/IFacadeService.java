package Clase8.Sync;

import java.time.LocalDate;
import java.util.List;

public interface IFacadeService {
    String buscarPlanTuristico(LocalDate salida, LocalDate llegada, String origen, String destino,
                               List<Vuelo> vuelos, List<Hotel> hoteles);
}
