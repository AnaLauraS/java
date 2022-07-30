package clase3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VendedorTest {
    Vendedor empleado1=new Empleado("fulano",2,5,5);
    Vendedor afiliado1=new Afiliado("Otro",10);

    @Test
    void recategorizar() {
        assertEquals(150,afiliado1.calcularPuntos());
        assertEquals("Otro tiene 150 puntos, por lo que es categoría Maestros",afiliado1.recategorizar());
        assertEquals(85,empleado1.calcularPuntos());
    }
}