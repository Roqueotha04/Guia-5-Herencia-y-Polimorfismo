package ejercicio5;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Factura {
    private ArrayList<String> contenido;
    private static int cantFacturas = 0;
    ClienteMinorista cliente;
    ArrayList<Producto>productos;
    float total;
    public Factura(ClienteMinorista cliente, ArrayList <Producto> productos ) {
        ++cantFacturas;
        this.contenido=new ArrayList<>();
        this.cliente=cliente;
        this.productos=productos;
        total=0;
        cargarRenglones();

    }

    private void cargarRenglones() {
        ///Agrego los renglones para el cliente
        this.agregarRenglon("Factura nro: " + cantFacturas);
        this.agregarRenglon("Fecha: " + LocalDate.now());
        this.agregarRenglon("Nombre del cliente: " + cliente.nombre);
        this.agregarRenglon("Direccion: " + cliente.domicilio);
        this.agregarRenglon("CUIT del cliente: " + cliente.cuit);

        ///Cargo los productos y calculo el total
        total=agregarProductos(productos);
        this.agregarRenglon("Precio total: " + total);
        ///Verifico la instancia del objeto
        if (cliente instanceof ClienteMayorista){
            this.agregarRenglon("Precio con Descuento " + aplicarDescuento(total,((ClienteMayorista) cliente).getPorcentajeDescuento()));
        }else{
            this.agregarRenglon("Sin descuento aplicable");
        }
    }

    public void agregarRenglon(String linea) {
        this.contenido.add(linea);
    }

    ///agrego los productos recorriendo el array y creando los renglones
    public float agregarProductos (ArrayList<Producto>productos){
        Scanner teclado= new Scanner(System.in);
        int cantidad=0;
        float total=0;
        for (Producto producto: productos){
            System.out.println("Cuantas unidades de: " + producto.getNombre());
            cantidad=teclado.nextInt();
            total+=cantidad*producto.getPrecioUnitario();
            agregarRenglon("Producto: " + producto.getNombre() + " Precio: " + producto.getPrecioUnitario() +" Cantidad: "+ cantidad + " Total: " + cantidad*producto.getPrecioUnitario());
        }
        return total;
    }

    public float aplicarDescuento (float total, float porcentajeDescuento){
        total-= total * porcentajeDescuento/100;
        return total;
    }

    ///Recorro el array de strings que cree para la factura
    public void mostrarFactura (){
        for (String string:contenido) {
            System.out.println(string);
        }
    }

}
