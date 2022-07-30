package Clase_5;

import java.util.Date;

public class RegistroProxy implements Registro{

    @Override
    public String vacunar(Persona persona) {
        Date hoy = new Date();
        String mensaje = "Vuelva cuando sea su turno";
        if(hoy.after(persona.getFecha())){
            Registro registro = new RegistroVacuna();
            mensaje = registro.vacunar(persona);
        }


        return mensaje;
    }
}
