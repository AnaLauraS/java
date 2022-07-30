package Clase_8;

public class FacadeDescuento implements IDescuento{
    //atributos de nuestras APIs
    private ApiTarjeta Apitarjeta;
    private ApiProducto Apiproducto;
    private ApiCantidad Apicant;

    //constructor
    public FacadeDescuento() {
        Apitarjeta = new ApiTarjeta();
        Apiproducto = new ApiProducto();
        Apicant = new ApiCantidad();
    }

    //descuento
    @Override
    public int descuento(Producto producto, Tarjeta tarjeta, int cant) {
        int descuentoGral=0;
        descuentoGral+= Apitarjeta.descuento(tarjeta);
        descuentoGral+= Apiproducto.descuento(producto);
        descuentoGral+= Apicant.descuento(cant);
        return descuentoGral;
    }
}
