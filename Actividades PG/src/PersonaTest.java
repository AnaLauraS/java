import static org.junit.jupiter.api.Assertions.*;

class PersonaTest {
    Persona p= new Persona("Ana", "Laura","email@email",32);
    @org.junit.jupiter.api.Test
    void muestraNombreCompleto() {

        assertEquals ("Laura, Ana",p.muestraNombreCompleto());
    }

    @org.junit.jupiter.api.Test
    void mayorDeEdad() {
        assertEquals (true,p.mayorDeEdad());
    }
}