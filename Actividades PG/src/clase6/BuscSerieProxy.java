package clase6;

public class BuscSerieProxy implements ISerie{
    @Override
    public String getSerie(Serie serie) throws SerieNoHabilitadaException{
        if (serie.getCantVistas()>5){
            throw new SerieNoHabilitadaException("Ha superado la cantidad de reproducciones permitidas");
        } else {
            BuscSerie buscador = new BuscSerie();
            return buscador.getSerie(serie);
        }
    }
}


