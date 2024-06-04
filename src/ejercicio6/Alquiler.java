package ejercicio6;

import java.time.LocalDate;

public class Alquiler {
    private String nombreCliente;
    private LocalDate fecha;
    private String estadoEntregado;
    private Boolean devuelto;
    private String patente;

    public Alquiler(String nombreCliente, LocalDate fecha, String estadoEntregado, String patente) {
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.estadoEntregado = estadoEntregado;
        this.devuelto=false;
        this.patente=patente;
    }

    public void setDevuelto(Boolean devuelto) {
        this.devuelto = devuelto;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "nombreCliente='" + nombreCliente + '\'' +
                ", fecha=" + fecha +
                ", estadoEntregado='" + estadoEntregado + '\'' +
                ", devuelto='" + devuelto + '\'' +
                ", autoAlquilado=" + patente +
                '}';
    }
}
