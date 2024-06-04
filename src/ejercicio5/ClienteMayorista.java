package ejercicio5;

public class ClienteMayorista extends ClienteMinorista{
    private float porcentajeDescuento;

    public ClienteMayorista(String nombre, String domicilio, String cuit, float porcentajeDescuento) {
        super(nombre, domicilio, cuit);
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public float getPorcentajeDescuento() {
        return porcentajeDescuento;
    }
}
