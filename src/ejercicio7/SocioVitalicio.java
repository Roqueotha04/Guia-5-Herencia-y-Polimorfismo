package ejercicio7;

public class SocioVitalicio extends Socio {

    ///No agrego variables, sin embargo sobreescribo los metodos.
    ///La deuda la inicializo como 0 por defecto.
    public SocioVitalicio(String nombreSocio, double saldo) {
        super(nombreSocio, saldo, 0);
    }

    @Override
    public void pagarCuota() {
        mostrarDeuda();
        System.out.println("Muchas gracias por ser un socio vitalicio señor/a " + getNombreSocio());
        System.out.println("");
    }

    @Override
    public void mostrarDeuda() {
        System.out.println("La deuda del socio vitalicio " + getNombreSocio() + " es de " + getDeuda() + " no es necesario pagar nada");
    }
}
