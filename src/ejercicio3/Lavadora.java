package ejercicio3;

public class Lavadora extends Electrodomestico{
    private double carga;
    private static final double CARGA_CONSTANTE=5;

    public Lavadora() {
        super();
        this.carga = CARGA_CONSTANTE;
    }

    public Lavadora(float precio, float peso) {
        super(precio, peso);
        this.carga = CARGA_CONSTANTE;
    }

    public Lavadora(float precio, String color, char consumo, float peso, double carga) {
        super(precio, color, consumo, peso);
        this.carga = carga;
    }

    public double getCarga() {
        return this.carga;
    }

    ///Sobreescribo el metodo precioFinal
    @Override
    public float precioFinal() {
        float precioFinal;
        precioFinal= super.precioFinal();
        if (this.carga>30){

            precioFinal+=30;
        }

        return precioFinal;
    }
}
