package clase1;

import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FiguraTest {
    Figura cir = new Circulo(3.2);
    Figura cua= new Cuadrado(2.8);

    @Test
    void area() {
        assertEquals(32,Math.round(cir.area()));
        assertEquals(8, Math.round(cua.area()));
    }
}