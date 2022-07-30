package clase8;

import java.util.Date;


public class BusquedaVuelo {
    Vuelo v1=new Vuelo("BsAs","Neuquen",new Date(2022-1900,4,22),new Date(2022-1900,4,27),01);
    Vuelo v2=new Vuelo("BsAs","Neuquen",new Date(2022-1900,5,22),new Date(2022-1900,6,27),02);
    Vuelo v3=new Vuelo("Neuquen","BsAs",new Date(2022-1900,2,22),new Date(2022-1900,4,27),03);
    Vuelo v4=new Vuelo("Neuquen","BsAs",new Date(2022-1900,4,27),new Date(2022-1900,4,29),04);
    Vuelo v5=new Vuelo("BsAs","Neuquen",new Date(2022-1900,4,2),new Date(2022-1900,4,27),05);

    Vuelo listaVuelos[]={v1,v2,v3,v4,v5};

    public BusquedaVuelo(Vuelo[] listaVuelos) {
        this.listaVuelos = listaVuelos;
    }

    public BusquedaVuelo() {
    }

    public void busquedaVuelos(String origen, String destino, Date fechaSalida, Date fechaRegreso){

        for (int i=0; i<listaVuelos.length; i++){
            if (listaVuelos[i].getCiudadOrigen()==origen && listaVuelos[i].getCiudadDestino()==destino && listaVuelos[i].getInicioDisponibilidad()==fechaSalida && listaVuelos[i].getFinDisponibilidad()==fechaRegreso){
                System.out.println("El vuelo "+ listaVuelos[i].getIdVuelo()+" está disponible en fechas solicitadas" );
            } else {
                System.out.println("no se encontró nada");
            }
        }
    }
}
