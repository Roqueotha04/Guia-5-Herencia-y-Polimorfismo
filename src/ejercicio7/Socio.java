package ejercicio7;

import java.util.Scanner;

///Creo la clase como abstracta ya que no realizare instancias de socios y puedo trabajar con todas las clases hijas asi
public abstract class Socio {
    private static int numeroDeSocioIncremento=0;
    private int numeroDeSocio;
    private String nombreSocio;
    private double saldo;
    private double deuda;
    private Boolean activo;

    public Socio(String nombreSocio, double saldo, double deuda) {
        numeroDeSocioIncremento++;
        this.numeroDeSocio = numeroDeSocioIncremento;
        this.nombreSocio = nombreSocio;
        this.saldo = saldo;
        this.deuda = deuda;
        activo=true;
    }

    public void darDeBaja (){
        this.activo=false;
    }

    public void darDeAlta(){
        this.activo=true;
    }

    public Boolean getActivo() {
        return activo;
    }

    public double getDeuda() {
        return deuda;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    ///Implemento los metodos abstractos para mostrar la deuda y el pago de cuota
    public abstract void pagarCuota ();
    public abstract void mostrarDeuda ();
}
