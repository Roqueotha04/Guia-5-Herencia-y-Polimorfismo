package ejercicio8;

import java.time.LocalDate;

public class BoletaDeDevolucion {
    private static int idBoleta = 0;
    private int id;
    private LocalDate fechaDeRetiro;
    private LocalDate fechaDeDevolucion;
    private Cliente clientesito;
    private Pelicula peli;
    private Boolean devuelta;

    public BoletaDeDevolucion(LocalDate fechaDeRetiro, LocalDate fechaDeDevolucion, Cliente clientesito, Pelicula peli) {
        this.fechaDeRetiro = fechaDeRetiro;
        this.fechaDeDevolucion = fechaDeDevolucion;
        this.clientesito = clientesito;
        this.peli = peli;
    }
    public BoletaDeDevolucion(Pelicula peli, Cliente cliente) {
        idBoleta++;
        id = idBoleta;
        this.devuelta = false;
        clientesito = cliente;
        this.peli = peli;
        int i = peli.getLimiteCopias();
        i--;
        peli.setLimiteCopias(i);
        fechaDeRetiro = LocalDate.now();
        int dia = LocalDate.now().getDayOfMonth();
        fechaDeDevolucion = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), dia + 7);
    }

    @Override
    public String toString() {
        return "BoletaDeDevolucion{" +
                "id=" + id +
                ", fechaDeRetiro=" + fechaDeRetiro +
                ", fechaDeDevolucion=" + fechaDeDevolucion +
                ", clientesito=" + clientesito +
                ", peli=" + peli +
                ", devuelta=" + devuelta +
                '}';
    }

    public void devolverPelicula() {
        peli.setLimiteCopias(peli.getLimiteCopias() + 1);
        this.devuelta = true;
    }

    public void mostrarBoletaParaCliente() {
        System.out.println("\n--------------------------");
        System.out.println("Id de la boleta: " + id);
        System.out.println("Titulo de pelicula: " + peli.getTitulo());
        System.out.println("Fecha de retiro: " + fechaDeRetiro);
        System.out.println("Fecha de devolucion: " + fechaDeDevolucion);
    }

    public Boolean getDevuelta() {
        return devuelta;
    }

    public int getId() {
        return id;
    }

    public LocalDate getFechaDeDevolucion() {
        return fechaDeDevolucion;
    }

    public Pelicula getPeli() {
        return peli;
    }


}
