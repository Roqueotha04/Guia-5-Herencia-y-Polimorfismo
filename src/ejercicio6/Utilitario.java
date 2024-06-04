package ejercicio6;

public class Utilitario extends Automovil{
    private String cargaTransportada;
    public Utilitario(){
        super();
    }

    public Utilitario(String patente, String marca, String modelo, int anio, int kilometraje, double precioAlquilerDiario, String estado, String cargaTransportada) {
        super(patente, marca, modelo, anio, kilometraje, precioAlquilerDiario, estado);
        this.cargaTransportada = cargaTransportada;
    }
}
