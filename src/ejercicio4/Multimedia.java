package ejercicio4;

///Creo una clase llamada Multimedia ya que Serie y Videojuego comparten atributos.
///Creo una clase abstracta ya que no generare instancias de multimedia y me aseguro de que ambos implementen los metodos que requiero
public abstract class Multimedia {

    protected String titulo;
    protected String genero;
    protected boolean entregado;

    public Multimedia (){
        entregado=false;
    }

    public Multimedia (String titulo){
        this.titulo=titulo;
        entregado=false;
    }

    public Multimedia(String titulo, String genero) {
        this.titulo = titulo;
        this.genero = genero;
        this.entregado = false;
    }

    public void entregar (){
        this.entregado=true;
    }

    public void devolver (){
        this.entregado=false;
    }

    public boolean isEntregado (){
        return this.entregado;
    }

    @Override
    public String toString() {
        return "Multimedia{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", entregado=" + entregado +
                '}';
    }

    ///Genero un metodo para comparar que sea generico para todas las clases,
    public abstract int compareTo (Object a);

    ///Declaro el metodo como estatico y recibe los dos arrays
    public static int contarMultimediaEntregada (Serie series[],Videojuego videojuegos[]){
        int contador=0;
        for (int i=0;i< series.length;i++){
            if (series[i].isEntregado()){
                contador++;
            }
        }
        for (int i=0;i< videojuegos.length;i++){
            if (videojuegos[i].isEntregado()){
                contador++;
            }
        }
        return contador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
