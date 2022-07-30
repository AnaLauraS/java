package clase6;

public class BuscSerie implements ISerie{
    @Override
    public String getSerie(Serie serie) {
        return "www."+serie.getNombre();
    }
}
