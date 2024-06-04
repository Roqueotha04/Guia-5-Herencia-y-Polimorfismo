package ejercicio3;

public class Television extends Electrodomestico{

    private int resolucion;
    private boolean tdt;

    private static final int RESOLUCION_CONSTANTE  = 20;
    private boolean TDT_CONSTANTE = false;

    public Television() {
        super ();
        resolucion=RESOLUCION_CONSTANTE;
        tdt=TDT_CONSTANTE;
    }

    public Television(float precio, float peso) {
        super(precio, peso);
        resolucion=RESOLUCION_CONSTANTE;
        tdt=TDT_CONSTANTE;
    }

    public Television(float precio, String color, char consumo, float peso, int resolucion, boolean tdt) {
        super(precio, color, consumo, peso);
        this.resolucion = resolucion;
        this.tdt = tdt;
    }

    ///Sobreescribo el metodo precioFinal
    @Override
    public float precioFinal() {
        float precioFinal= super.precioFinal();
        if (this.resolucion>40){
            precioFinal+=precioFinal*30/100;
        }else if (this.tdt=true){
            precioFinal+=50;
        }
        return precioFinal;
    }

    public int getResolucion() {
        return resolucion;
    }

    public boolean isTdt() {
        return tdt;
    }

    public boolean isTDT_CONSTANTE() {
        return TDT_CONSTANTE;
    }
}
