package Clase_8;

public class ApiTarjeta {

    public int descuento(Tarjeta tarjeta){
        int mensaje= 0;
        if(tarjeta.getBanco().equals("Star Bank")){
            mensaje = 20;
        }
        return mensaje;
    }
}
