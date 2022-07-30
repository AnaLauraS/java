package clase2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    Menu clasico1=new Clasico(5);
    Menu infantil1=new Infantil(2.5);
    Menu vegetariano1=new Vegetariano(10);

    @Test
    void armadoDelMenu() {
        assertEquals(5,clasico1.armadoDelMenu());
    }

    @Test
    void infantilMenu(){
        assertEquals(5.5,((Infantil)infantil1).precioFinal(1));
        assertEquals(2.5,((Infantil)infantil1).precioFinal(-1));
    }

    @Test
    void vegeMenu(){
        assertEquals(12.2,((Vegetariano)vegetariano1).precioFinal(2,1));
        assertEquals(10,((Vegetariano)vegetariano1).precioFinal(-1,3));
        assertEquals(10,((Vegetariano)vegetariano1).precioFinal(0,0));
    }
}