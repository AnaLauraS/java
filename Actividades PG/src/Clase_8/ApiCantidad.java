package Clase_8;

public class ApiCantidad {

    public int descuento(int cant){
        int mensaje= 0;
        if(cant > 12){
            mensaje = 15;
        }
        return mensaje;
    }
}
