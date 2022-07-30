package clase4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalistaCalidadTest {

    @Test
    void analizarCalidad() {
        AnalistaCalidad analista = new AnalistaCalidad();
        Articulo a1 = new Articulo("a1",1000,1000,"sano");
        assertFalse(analista.analizarCalidad(a1));
    }
}