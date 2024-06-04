package ejercicio4;

public class Videojuego extends Multimedia{
    private int horasEstimadas;
    private String compania;

    public Videojuego() {
        super();
        this.horasEstimadas = 10;
    }

    public Videojuego(String titulo, int horasEstimadas) {
        super(titulo);
        this.horasEstimadas = horasEstimadas;
    }

    public Videojuego(String titulo, String genero, int horasEstimadas, String compania) {
        super(titulo, genero);
        this.horasEstimadas = horasEstimadas;
        this.compania = compania;
    }

    @Override
    public String toString() {
        return "Videojuego{" + super.toString() +
                "horasEstimadas=" + horasEstimadas +
                ", compania='" + compania + '\'' +
                '}';
    }

    ///Declaro el array como estatico y recibe un array de videojuegos.
    public static Videojuego BuscarVideoJuegoConMasHoras (Videojuego videojuegos []){
        Videojuego videojuegoAux=videojuegos[0];
            for (int i=1;i< videojuegos.length;i++){
                if (videojuegoAux.compareTo(videojuegos[i])<0){
                    videojuegoAux=videojuegos[i];
                }
            }
      return videojuegoAux;
    }

    @Override
    public int compareTo(Object a) {
        if (a instanceof Videojuego) {
            if (this.horasEstimadas == ((Videojuego) a).horasEstimadas) {
                return 0;
            } else if (this.horasEstimadas > ((Videojuego) a).horasEstimadas) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    public int getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(int horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public String getCompania() {
        return compania;
    }

    public void setCompania(String compania) {
        this.compania = compania;
    }
}
