package clase8;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        /*Vuelo v1=new Vuelo("BsAs","Neuquen",new Date(2022-1900,4,22),new Date(2022-1900,4,27),01);
        Vuelo v2=new Vuelo("BsAs","Neuquen",new Date(2022-1900,5,22),new Date(2022-1900,6,27),02);
        Vuelo v3=new Vuelo("Neuquen","BsAs",new Date(2022-1900,2,22),new Date(2022-1900,4,27),03);
        Vuelo v4=new Vuelo("Neuquen","BsAs",new Date(2022-1900,4,27),new Date(2022-1900,4,29),04);
        Vuelo v5=new Vuelo("BsAs","Neuquen",new Date(2022-1900,4,2),new Date(2022-1900,4,27),05);

        Vuelo lista[]={v1,v2,v3,v4,v5};
        BusquedaVuelo buscadorV = new BusquedaVuelo(lista);*/

        BusquedaVuelo buscadorV = new BusquedaVuelo();

        Hotel h1=new Hotel("BsAs",new Date(2022-1900,4,22),new Date(2022-1900,4,27),"hotel1");
        Hotel h2=new Hotel("Neuquen",new Date(2022-1900,5,22),new Date(2022-1900,6,27),"hotel2");
        Hotel h3=new Hotel("Neuquen",new Date(2022-1900,7,22),new Date(2022-1900,10,27),"hotel3");
        Hotel h4=new Hotel("BsAs",new Date(2022-1900,2,22),new Date(2022-1900,8,27),"hotel4");
        Hotel h5=new Hotel("BsAs",new Date(2022-1900,1,22),new Date(2022-1900,4,27),"hotel5");

        Hotel lista2[]={h1,h2,h3,h4,h5};
        BusquedaHotel buscadorH = new BusquedaHotel(lista2);

        BusquedaFacade buscador = new BusquedaFacade(buscadorH,buscadorV);
        buscador.busqueda("BsAs","Neuquen",new Date(2022-1900,2,22),new Date(2022-1900,4,27));

    }
}
