package clase20;

import java.util.List;

public class Empresa {
    private String razonSocial;
    private int CUIT;
    private List <Empleado> empleados;

    public Empresa(String razonSocial, int CUIT) {
        this.razonSocial = razonSocial;
        this.CUIT = CUIT;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public int getCUIT() {
        return CUIT;
    }

    public void setCUIT(int CUIT) {
        this.CUIT = CUIT;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
