package clase5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServicioDescargaProxyTest {

    @Test
    void descargar() {
        Usuario u=new Usuario("fulano","Premium");
        Usuario o=new Usuario("otro","free");
        ServicioDescargaProxy ser=new ServicioDescargaProxy();

        assertEquals("No es un usuario premium asi que no puede descargar musica offline",ser.descargar(o));
        assertEquals("Por ser usuario premium, descargás todo",ser.descargar(u));
    }
}