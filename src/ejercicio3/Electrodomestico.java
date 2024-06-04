package ejercicio3;

public class Electrodomestico {
    protected float precioBase;
    protected String color;
    protected char consumoEnergetico;
    protected float peso;

    private static final float PRECIO_BASE_CONSTANTE=100;
    private static final String COLOR_CONSTANTE="blanco";
    private static final char CONSUMO_ENERGETICO_CONSTANTE='F';
    private static final float PESO_CONSTANTE=5;

    ///Genero las constantes para los valores por defecto
    public Electrodomestico() {
        this.precioBase = PRECIO_BASE_CONSTANTE;
        this.color = COLOR_CONSTANTE;
        this.consumoEnergetico = CONSUMO_ENERGETICO_CONSTANTE;
        this.peso = PESO_CONSTANTE;
    }

    public Electrodomestico(float precioBase, float peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = COLOR_CONSTANTE;
        this.consumoEnergetico = CONSUMO_ENERGETICO_CONSTANTE;
    }

    public Electrodomestico(float precioBase, String color, char consumoEnergetico, float peso) {
        this.precioBase = precioBase;
        comprobarColor(color);
        comprobarConsumo(consumoEnergetico);
        this.peso = peso;
    }

    ///Compruebo el valor del consumoEnergetico, sino le asigno un valor por defecto
    public void comprobarConsumo(char letra) {
        char[] arr = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        boolean flag=false;

        for(int i = 0; i < arr.length && !flag; ++i) {
            if (letra == arr[i]) {
                this.consumoEnergetico=letra;
                flag=true;
            }
        }
        if(!flag){
            this.consumoEnergetico=CONSUMO_ENERGETICO_CONSTANTE;
        }
    }

    ///Compruebo el color, sino le asigno un valor por defecto
    public void comprobarColor(String color) {
        String[] arr = new String[]{"blanco", "negro", "rojo", "azul", "gris"};
        boolean flag=false;

        for(int i = 0; i < arr.length && !flag ; i++) {
            if (color.equals(arr[i])) {
                this.color = color;
                flag=true;
            }
        }
        if(!flag){
            this.color=COLOR_CONSTANTE;
        }
    }

    ///Calculo segun el valor de consumo energetico.
    ///Pueden haber diversas soluciones para este problema, esta es una de las mas simples para las herramientas actuales
    public float precioFinal() {
        float precioFinal=this.precioBase;

        switch (this.consumoEnergetico) {
            case 'A':
                precioFinal += 100;
                break;
            case 'B':
                precioFinal += 80;
                break;
            case 'C':
                precioFinal += 60;
                break;
            case 'D':
                precioFinal += 50;
                break;
            case 'E':
                precioFinal += 30;
                break;
            case 'F':
                precioFinal += 10;
        }

        if (0.0 < this.peso && this.peso <= 19.0) {
            precioFinal += 10;
        } else if (this.peso <= 49.0) {
            precioFinal += 50;
        } else if (this.peso <= 79.0) {
            precioFinal += 80;
        } else if (80.0 <= this.peso) {
            precioFinal += 100;
        }

        return precioFinal;
    }


    ///en este caso no es necesario realizar el casteo especifico debido a que el metodo precioFinal()
    ///Se encuentra ya en lavadora, por lo que busca primero el metodo en las clases hijas.
    ///Declaro el metodo como estatico
    public static void sumaPrecioFinal (Electrodomestico electrodomesticos []){
        if (electrodomesticos!=null){
            float totalLavadora=0;
            float totalTelevisores=0;
            float total=0;
            ///Utilizo instanceof para sumar el valor en los acumuladores, no casteo las clases.
            for (int i=0;i<electrodomesticos.length;i++){
                if (electrodomesticos[i] instanceof Lavadora){
                    totalLavadora+= electrodomesticos[i].precioFinal();
                } else if (electrodomesticos[i] instanceof Television) {
                    totalTelevisores+=electrodomesticos[i].precioFinal();
                }
                total=electrodomesticos[i].precioFinal();
            }
            System.out.println("Precio total de lavadora= " +totalLavadora + "\n Precio total de televisores= " + totalTelevisores +"\n precio total de electrodomesticos= " + total);
        }
    }


    public float getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(float precioBase) {
        this.precioBase = precioBase;
    }

    public String getColor() {
        return color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public float getPeso() {
        return peso;
    }
}
