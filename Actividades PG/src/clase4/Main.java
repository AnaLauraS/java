package clase4;

public class Main {
    public static void main(String[] args) {
        Articulo a1 = new Articulo("a1",1000,1000,"sano");
        Articulo a2 = new Articulo("a2",1100,1250,"sano");

        AnalistaCalidad analista = new AnalistaCalidad();
        System.out.println(analista.analizarCalidad(a1));
        System.out.println(analista.analizarCalidad(a2));
    }
}
