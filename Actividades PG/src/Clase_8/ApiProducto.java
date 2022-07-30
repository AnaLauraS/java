package Clase_8;

public class ApiProducto {

    public int descuento(Producto producto){
        int mensaje= 0;
        if(producto.getTipo().equals("lata")){
            mensaje = 10;
        }
        return mensaje;
    }
}
