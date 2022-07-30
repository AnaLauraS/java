package clase6;

public class Main {
    public static void main(String[] args) throws SerieNoHabilitadaException {
        Serie serie1 = new Serie("nombre", 3);
        Serie serie2 = new Serie("nombre2", 6);

        BuscSerieProxy b=new BuscSerieProxy();
        System.out.println(b.getSerie(serie1));
        System.out.println(b.getSerie(serie2));

    }
}
