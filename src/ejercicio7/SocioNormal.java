package ejercicio7;

import java.util.Scanner;

public class SocioNormal extends Socio {
    ///Le asigno un precio de cuota mensual, cuotas mensuales y cuotas pagas para manejar el pago de las mismas
    private double PrecioCuotaMensual;
    private int cuotasPagasDelAnio;
    private int cuotasPendientes;

    public SocioNormal(String nombreSocio, double saldo, double precioCuotaMensual) {
        super(nombreSocio, saldo, precioCuotaMensual);
        PrecioCuotaMensual = precioCuotaMensual;
        this.cuotasPagasDelAnio = 0;
        this.cuotasPendientes = 1;
    }

    ///Analizo cuantas cuotas debe pagar y le permito realizar el pago
    @Override
    public void pagarCuota (){
        if (cuotasPendientes==0){
            System.out.println("No adeuda cuotas, muchas gracias señor/a " + getNombreSocio());
        }else{
            Scanner teclado= new Scanner(System.in);
            char pago;
            mostrarDeuda();
            System.out.println("Desea pagar el total? s/n");
            pago=teclado.nextLine().charAt(0);

            if (pago == 's'){
                if (getSaldo()>getDeuda()){
                    double saldoNuevo=getSaldo()-getDeuda();
                    setSaldo(saldoNuevo);
                    System.out.println("Pago realizado con exito, su nuevo saldo es de " + getSaldo());
                    cuotasPagasDelAnio+=cuotasPendientes;
                    cuotasPendientes=0;
                    setDeuda(0);
                }else{
                    System.out.println("Saldo insuficiente ");
                }
            }else{
                System.out.println("Pago no realizado ");
            }
        }
        System.out.println("");
    }

    public int getCuotasPagasDelAnio() {
        return cuotasPagasDelAnio;
    }

    public void setCuotasPagasDelAnio(int cuotasPagasDelAnio) {
        this.cuotasPagasDelAnio = cuotasPagasDelAnio;
    }

    public int getCuotasPendientes() {
        return cuotasPendientes;
    }

    public void setCuotasPendientes(int cuotasPendientes) {
        this.cuotasPendientes = cuotasPendientes;
    }

    @Override
    public void mostrarDeuda () {
        System.out.println("El socio normal " + getNombreSocio() + " debe " + cuotasPendientes + " cuotas y adeuda un total de: " + getDeuda());
    }
}
