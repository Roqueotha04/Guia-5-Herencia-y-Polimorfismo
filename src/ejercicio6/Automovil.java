package ejercicio6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Automovil {
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private int kilometraje;
    private double precioAlquilerDiario;
    private String estado;
    private ArrayList<Alquiler>alquilerAuto;

    public Automovil() {
        this.alquilerAuto=new ArrayList<>();
    }

    public Automovil(String patente, String marca, String modelo, int anio, int kilometraje, double precioAlquilerDiario, String estado) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
        this.precioAlquilerDiario = precioAlquilerDiario;
        setEstado(estado);
        this.alquilerAuto=new ArrayList<>();
        ///Si el estado es alquilado por defecto creo una factura por defecto para evitar errores en el futuro.
        ///Se podria solicitar el nombre del cliente y desarrollar un sistema completo o no permitir el ingreso de autos ya alquilados.
        ///No es la unica manera de resolver el problema.
        if (estado.equals("alquilado")){
            alquilerAuto.add(new Alquiler("nombreAConfirmar", LocalDate.now(),estado,patente));
        }

    }

    ///Constructor creado para los autos que se inicializan como alquilados,
    public Automovil(String patente, String marca, String modelo, int anio, int kilometraje, double precioAlquilerDiario, String estado,ArrayList<Alquiler>alquileres) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.kilometraje = kilometraje;
        this.precioAlquilerDiario = precioAlquilerDiario;
        setEstado(estado);
        this.alquilerAuto=new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Automovil{" +
                "patente='" + patente + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", anio=" + anio +
                ", kilometraje=" + kilometraje +
                ", precioAlquilerDiario=" + precioAlquilerDiario +
                ", estado='" + estado + '\'' +
                '}';
    }

    ///Verifico el valor del estado con el metodo equals.
    public void setEstado(String estado) {
        String estadoAuto = estado.toLowerCase();
        if (estadoAuto.equals("en reparacion") || estadoAuto.equals("alquilado") || estadoAuto.equals("disponible") || estadoAuto.equals("optimo") || estadoAuto.equals("en revision")) {
            this.estado = estadoAuto;
        } else {
            this.estado = "en revision";
        }
    }

    ///Modifico el estado del vehiculo y agrego el alquiler al historial.
    public void CargarHistorial (Alquiler alquiler){
        alquilerAuto.add(alquiler);
        System.out.println("Auto alquilado con exito");
    }

    public String getEstado() {
        return this.estado;
    }

    public void mostrarHistorialAlquileresAuto (){
        for (Alquiler alquiler:alquilerAuto) {
            System.out.println(alquiler.toString());
        }
    }

    ///LLamo a una funcion para revisar los kilometros recorridos y si el coche ha sufrido daños
    ///Ambos casos los genero de manera aleatoria con Rand para darle algo mas de funcionalidad al programa
    public void revisionTecnica (){
        Random random= new Random();
        System.out.println("\nRevisando el auto...");
        setEstado("en revision");
        System.out.println("El auto se encuentra " + getEstado());
        int kilometros= random.nextInt(1,10000);
        System.out.println("El auto recorrio " + kilometros + " kilometros");
        this.kilometraje+=kilometros;

        int danios = random.nextInt(1,4);
        if (danios==1){
            setEstado("en reparacion");
            System.out.println("El auto se encuentra " + getEstado());
        }else{
            setEstado("optimo");
            System.out.println("El auto se encuentra " + getEstado());
        }

        alquilerAuto.get(alquilerAuto.size()-1).setDevuelto(true);
        System.out.println("");
    }

    public String getPatente() {
        return patente;
    }
}
