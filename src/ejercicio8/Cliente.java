package ejercicio8;

import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private String nombreYApellido;
    private String telefono;
    private String direccion;

    private ArrayList<BoletaDeDevolucion> boleta;

    public Cliente() {
        boleta = new ArrayList<>();
    }

    public Cliente(String nombreYApellido, String telefono, String direccion) {
        this.nombreYApellido = nombreYApellido;
        this.telefono = telefono;
        this.direccion = direccion;
        boleta = new ArrayList<>();
    }

    public void asignarBoleta(BoletaDeDevolucion boleta) {
        this.boleta.add(boleta);
    }

    public void mostrarArrayBoletas() {
        for (BoletaDeDevolucion boleta : boleta) {
            if (!boleta.getDevuelta()) {
                boleta.mostrarBoletaParaCliente();
            }
        }
    }

    public void mostrarCliente() {
        System.out.println("_____________");
        toString();
        mostrarArrayBoletas();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombreYApellido='" + nombreYApellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }

    public void mostrarUltimosAlquileresDeCliente() {
        System.out.println("Últimos 10 alquileres de " + nombreYApellido + ":");
        int num = Math.max(0, boleta.size() - 10);
        for (int i=num;i < boleta.size(); i++) {
            boleta.get(i).mostrarBoletaParaCliente();
        }
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public String getTelefono() {
        return telefono;
    }
}
