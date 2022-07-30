package clase19;

import java.io.Serializable;

public class Contacto implements Serializable {
    private String nombre;
    private String email;
    private int tel;

    public Contacto(String nombre, String email, int tel) {
        this.nombre = nombre;
        this.email = email;
        this.tel = tel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
}
