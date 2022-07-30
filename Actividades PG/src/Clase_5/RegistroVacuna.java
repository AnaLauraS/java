package Clase_5;

public class RegistroVacuna implements Registro{

    @Override
    public String vacunar(Persona persona) {
        return (persona.getNombre()+" con el dni "+persona.getDNI()+
                " se vacuno ");
    }
}
