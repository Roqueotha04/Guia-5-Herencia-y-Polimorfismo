package ejercicio4;

import java.util.Objects;

public class Serie extends Multimedia{
    private int numeroDeTemporadas;
    private static int datoEstatico=1;
    private String creador;

    public Serie() {
        super();
        this.numeroDeTemporadas = 3;
    }

    public Serie (String titulo, String creador){
        super (titulo);
        this.creador=creador;
        this.numeroDeTemporadas=3;
    }

    public Serie(String titulo, String genero, int numeroDeTemporadas, String creador) {
        super(titulo, genero);
        this.numeroDeTemporadas = numeroDeTemporadas;
        this.creador = creador;
    }

    @Override
    public String toString() {
        return "Serie{" + super.toString() +
                ", numeroDeTemporadas=" + numeroDeTemporadas +
                ", creador='"    + creador + '\'' +
                '}';
    }

    ///Declaro el metodo como estatico y recibe un array de series
    public static Serie BuscarSerieConMasTemporadas(Serie series []){
        Serie serieAux=series[0];
        for (int i=1;i< series.length;i++){
            if (serieAux.compareTo(series[i])<0){
                serieAux=series[i];
            }
        }
        return serieAux;
    }

    @Override
    public int compareTo(Object a) {
        if (a instanceof Serie) {
            if (this.numeroDeTemporadas == ((Serie) a).numeroDeTemporadas) {
                return 0;
            } else if (this.numeroDeTemporadas > ((Serie) a).numeroDeTemporadas) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }


    public int getNumeroDeTemporadas() {
        return numeroDeTemporadas;
    }

    public void setNumeroDeTemporadas(int numeroDeTemporadas) {
        this.numeroDeTemporadas = numeroDeTemporadas;
    }

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }
}
