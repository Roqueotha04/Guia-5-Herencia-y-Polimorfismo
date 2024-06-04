package ejercicio5;
import java.util.ArrayList;

public class Empresa {
    private ArrayList <ClienteMinorista> clientes;
    private ArrayList<Factura> facturas;
    private ArrayList<Producto> productos;

    ///Es importante inicializar todos los arreglos de la clase para porder utilizarlos.
    public Empresa() {
        clientes=new ArrayList<>();
        facturas=new ArrayList<>();
        productos=new ArrayList<>();
    }

    public void agregarNuevoCliente (ClienteMinorista cliente){
        this.clientes.add(cliente);
    }

    ///Previo a cargar la factura verifico que los elementos se encuentren en la empresa con contains y containsALl
    public void cargarNuevaFactura (ClienteMinorista cliente,ArrayList<Producto>productos){
        if (clientes.contains(cliente)&& productos.containsAll(productos)){
            this.facturas.add(new Factura(cliente,productos));
        }else{
            System.out.println("Cliente o productos invalidos");
        }
    }

    //Muestra una factura buscandola por un indice en el array, se puede buscar por diversos campos.
    public void mostrarUnaFactura(int indice){
        if (indice<facturas.size()){
            facturas.get(indice).mostrarFactura();
        }
    }

    public void cargarNuevoProducto (Producto producto){
        this.productos.add(producto);
    }

    public ArrayList<ClienteMinorista> getClientes() {
        return clientes;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }
}
