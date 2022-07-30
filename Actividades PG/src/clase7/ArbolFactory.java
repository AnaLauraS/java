package clase7;

import java.util.HashMap;

public class ArbolFactory {

    private static final HashMap<String,Arbol> arbolera = new HashMap<>();

    public Arbol getArbol (String color){
        Arbol arbol = arbolera.get(color);
        if (arbol == null){
            arbol = new Arbol(color);
            arbolera.put(color,arbol);
            switch (color){
                case "verde": arbol.setAlto(200);
                    arbol.setAncho(400);
                    arbol.setTipo("Ornamental");
                    break;
                case "rojo":arbol.setAlto(500);
                    arbol.setAncho(300);
                    arbol.setTipo("Frutal");
                    break;
                case "celeste":arbol.setAlto(100);
                    arbol.setAncho(200);
                    arbol.setTipo("Frutal");
                    break;
            }
            System.out.println("Arbol " + arbol.getTipo() + " creado");
        }
        return arbol;
    }
}
