package clase9;

import java.util.HashMap;

public class RopaFactory {
    private static final HashMap<String, Ropa> baul = new HashMap<>();

    public static Ropa getRopa (String tipo) {
        Ropa prenda = baul.get(tipo);
        if (prenda == null) {
            prenda = new Ropa(tipo);
            baul.put(tipo, prenda);
        }
        return prenda;
    }

}
