package clase7;

public class Main {
    public static void main(String[] args) {
        int contadorVerdes=0;
        int contadorRojos=0;
        int contadorCelestes=0;
        ArbolFactory plantador = new ArbolFactory();

        String[] color=new String[]{"rojo","celeste","verde"};


        for (int i=0; i<1000000; i++){
            int aleatorio = (int) (Math.random()*3);
            String valor=color[aleatorio];
            plantador.getArbol(valor);
            switch (valor){
                case "verde": contadorVerdes++;
                    break;
                case "rojo": contadorRojos++;
                    break;
                case "celeste": contadorCelestes++;
                    break;
            }
        }
        System.out.println("Se crearon "+ contadorCelestes + " árboles celestes, "+ contadorVerdes + " árboles verdes y "+ contadorRojos + " árboles rojos");

        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
    }
}
