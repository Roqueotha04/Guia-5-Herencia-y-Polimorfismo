package ejercicio5;

public class Producto {
    private String nombre;
    private float precioUnitario;

    public Producto() {
    }

    public Producto(String item, float precioUnitario) {
        this.nombre= item;
        this.precioUnitario = precioUnitario;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String item) {
        this.nombre = item;
    }

    public float getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(float precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
