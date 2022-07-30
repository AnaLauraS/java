package Clase8.Sync;

import java.util.ArrayList;
import java.util.List;

public class PlanDeVuelo {
    private List<Vuelo> vuelosDeIda;
    private List<Vuelo> vuelosDeRegreso;

    public PlanDeVuelo() {
        this.vuelosDeIda = new ArrayList<>();
        this.vuelosDeRegreso = new ArrayList<>();
    }

    public void RegistrarVueloIda(Vuelo vuelo){
        vuelosDeIda.add(vuelo);
    }

    public void RegistrarVueloRegreso (Vuelo vuelo){
        vuelosDeRegreso.add(vuelo);
    }

    public List<Vuelo> getVuelosDeIda() {
        return vuelosDeIda;
    }

    public List<Vuelo> getVuelosDeRegreso() {
        return vuelosDeRegreso;
    }
}
