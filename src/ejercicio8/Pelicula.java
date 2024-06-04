package ejercicio8;

public class Pelicula {
    private String genero;
    private String titulo;
    private int fechaDeLanzamiento;
    private int duracionEnMinutos;
    private String clasifAudiencia;
    private String siglasPais;
    private String descripcion;
    private int limiteCopias;

    public Pelicula(String titulo, int fecha, int duracionMin, String calificacion, String sigla, int limiteFijo, String descripcion, String genero) {
        this.titulo = titulo;
        this.fechaDeLanzamiento = fecha;
        this.duracionEnMinutos = duracionMin;
        this.clasifAudiencia = calificacion;
        this.siglasPais = sigla;
        this.descripcion = descripcion;
        this.limiteCopias = limiteFijo;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "genero='" + genero + '\'' +
                ", titulo='" + titulo + '\'' +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                ", duracionEnMinutos=" + duracionEnMinutos +
                ", clasifAudiencia='" + clasifAudiencia + '\'' +
                ", siglasPais='" + siglasPais + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", limiteCopias=" + limiteCopias +
                '}';
    }

    public boolean revisarStock(){
        if (this.limiteCopias>0){
            return true;
        }
        return false;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getLimiteCopias() {
        return limiteCopias;
    }

    public void setLimiteCopias(int limiteCopias) {
        this.limiteCopias = limiteCopias;
    }

    public String getGenero() {
        return genero;
    }
}
