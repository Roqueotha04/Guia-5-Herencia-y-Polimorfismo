package ejercicio7;

import java.util.Scanner;

public class SocioAusente extends Socio{
    ///Le asigno una cuota anual y un booleano para definir si han pagado la cuota anual o no
    private double cuotaAnual;
    private Boolean pagado;

    public SocioAusente(String nombreSocio, double saldo, double cuotaAnual) {
        super(nombreSocio, saldo, cuotaAnual);
        this.cuotaAnual=cuotaAnual;
        this.pagado=false;
    }

    ///Genero el metodo para pagar la cuota anual
    @Override
    public void pagarCuota(){
        Scanner teclado= new Scanner(System.in);
        char pago;
        if (pagado==true){
            System.out.println("No posee cuotas impagas, muchas gracias señor/a " + getNombreSocio());
        }else{
            mostrarDeuda();
            System.out.println("Desea pagar la cuota ahora? s/n");
            pago=teclado.nextLine().charAt(0);
            if (pago == 's'){
                if (getSaldo()>getDeuda()){
                    setSaldo(getSaldo()-getDeuda());
                    System.out.println("Pago realizado con exito, su nuevo saldo es de " + getSaldo());
                    setDeuda(0);
                    pagado=true;
                }else{
                    System.out.println("Saldo insuficiente");
                }
            }else{
                System.out.println("Pago no realizado");
            }
        }
        System.out.println("");
    }

    @Override
    public void mostrarDeuda() {
        System.out.println("La cuota del socio ausente " + getNombreSocio()+ " es una cuota anual de: " + cuotaAnual);
    }
}
