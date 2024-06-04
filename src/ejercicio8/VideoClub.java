package ejercicio8;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class VideoClub {
    private ArrayList<Pelicula> peliculas;
    private ArrayList<Cliente> clientes;
    private ArrayList<BoletaDeDevolucion> boletas;

    public VideoClub() {
        peliculas = new ArrayList<>();
        clientes = new ArrayList<>();
        boletas = new ArrayList<>();
    }

    public void agregarUnaPelicula(Pelicula peli) {
        peliculas.add(peli);
    }

    public void agregarUnCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    ///Verifico la existencia de la boleta en el array de boletas
    public void devolverPelicula (BoletaDeDevolucion boleta){
        if (boletas.contains(boleta)){
            boleta.devolverPelicula();
        }
    }
    ///Verfico la existencia del cliente y la pelicula
    ///Agrego la boleta y luego de crearla la cargo al cliente
    public void agregarBoleta(Cliente cliente, Pelicula pelicula) {
        if (clientes.contains(cliente)&&peliculas.contains(pelicula)){
            BoletaDeDevolucion boleta=new BoletaDeDevolucion(pelicula,cliente);
            boletas.add(boleta);
            cliente.asignarBoleta(boleta);
        }else{
            System.out.println("cliente o boleta no encontrados");
        }
    }

    public void mostrarTotalBoletasActivas() {
        for (BoletaDeDevolucion boleta : boletas) {
            if (!boleta.getDevuelta()) {
                System.out.println(boleta.toString());
            }
        }
    }

    public void mostrarTotalClientes() {
        for (Cliente cliente : clientes) {
            cliente.mostrarCliente();
        }
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<BoletaDeDevolucion> getBoletas() {
        return boletas;
    }

    ///Busco la boleta por id para generar un sistema donde se puedan visualizar y elegir peliculas por id
    public BoletaDeDevolucion buscarBoletaPorId(int id) {
        for (BoletaDeDevolucion boleta : boletas) {
            if (id == boleta.getId()) {
                return boleta;
            }
        }
        return null;
    }

    ///Metodo creado para cargar clientes que aun no estan en el sistema.
    ///Primero se solicitan los datos y al final se crea la instancia, se retorna el cliente.
    public Cliente cargarUnCliente (Scanner teclado){
        System.out.println("Ingrese su nombre y apellido: ");
        String nombre=teclado.nextLine();
        System.out.println("Ingrese su numero de telefono");
        String telefono=teclado.nextLine();
        System.out.println("Ingrese su direccion");
        String direccion= teclado.nextLine();
        Cliente cliente=new Cliente(nombre,telefono,direccion);
        return cliente;
    }

    public Cliente buscarClientePorNombre(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombreYApellido().equalsIgnoreCase(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public Pelicula buscarPeliculaPorTitulo(String titulo) {
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getTitulo().equalsIgnoreCase(titulo)) {
                return pelicula;
            }
        }
        return null;
    }

    ///Utilizo la fecha para comparar y recorro el array de boletas entero
    ///Muestro solo las boletas que aun no se han devuelto
    public void mostrarPelisSeDevuelvenDiaEspecifico(LocalDate fecha) {
        for (BoletaDeDevolucion boleta : boletas) {
            if (fecha.equals(boleta.getFechaDeDevolucion()) && !boleta.getDevuelta()) {
                System.out.println(boleta.toString());
            }
        }
    }

    public void mostrarPeliculaDetallada(Pelicula pelicula){
        if (peliculas.contains(pelicula)){
            System.out.println(pelicula.toString());
        }else{
            System.out.println("Pelicula no encontrada");
        }

    }

    public void mostrarTitulosMasSolicitadosPorGenero(String genero) {
        ///Creo un array para separar los titulos por genero
        ArrayList<String> titulosPorGenero = new ArrayList<>();
        ArrayList<String>titulosOrdenados=new ArrayList<>();
        for (BoletaDeDevolucion boleta : boletas) {
            Pelicula pelicula = boleta.getPeli();
            if (pelicula.getGenero().equalsIgnoreCase(genero)&& !titulosPorGenero.contains(pelicula.getTitulo())) {
                titulosPorGenero.add(pelicula.getTitulo());
            }
        }
        if (titulosPorGenero.isEmpty()) {
            System.out.println("No se encontraron películas para el género especificado o no se han alquilado aun");
            return;
        }
        ///Ordeno por popularidad con un metodo de ordenamiento
        System.out.println("Películas del género '" + genero + "' ordenadas por popularidad:");
        int numero=titulosPorGenero.size();
        ///Asigno una variable entera para la dimension, esto ya que voy borrando los elementos del array auxiliar de titulosPorGenero
        for (int i = 0; i <= numero; i++) {
            String tituloMasAlquilado = null;
            int vecesMasAlquilado = -1;
            for (String titulo : titulosPorGenero) {
                int veces = 0;
                for (BoletaDeDevolucion boleta : boletas) {
                    ///Busco en las boletas, veo la cantidad de veces que un titulo especifico fue alquilado a la vez.
                    ///Solo utilizo el titulo de la pelicula para facilitar la busqueda y muestra.
                    ///De necesitarse se puede buscar la pelicula por titulo con los metodos previamente creados
                    if (boleta.getPeli().getTitulo().equals(titulo)) {
                        veces++;
                    }
                }
                ///Si encuentro que un titulo fue alquilado mas veces lo convierto en el titulo mas alquilado nuevo
                if (veces > vecesMasAlquilado) {
                    tituloMasAlquilado = titulo;
                    vecesMasAlquilado = veces;
                }
            }
            ///Cargo en otro array el titulo mas solicitado y remuevo el mismo del array auxiliar
            if (tituloMasAlquilado != null) {
                titulosOrdenados.add(tituloMasAlquilado);
                titulosPorGenero.remove(tituloMasAlquilado);
            }

        }
        for (String string:titulosOrdenados) {
            System.out.println(string);
        }
    }

    ///Otra forma de buscar los titulos mas alquilados, en este caso los mas alquilados de todos.
    ///Se crea un array y se lo recorre
    public void obtener5TitulosMasAlquilados() {
        ArrayList<Pelicula> peliculasMasAlquiladas = new ArrayList<>();

        // Contar la cantidad de veces que se alquila cada película
        for (Pelicula pelicula : peliculas) {
            int vecesAlquilado = contarVecesAlquilado(pelicula.getTitulo());
            agregarOrdenado(peliculasMasAlquiladas, pelicula, vecesAlquilado);
        }

        for (int i=0;i<5;i++){
            System.out.println(peliculasMasAlquiladas.get(i).toString());
        }
    }

    // Método auxiliar para contar la cantidad de veces que se alquila una película específica
    private int contarVecesAlquilado(String titulo) {
        int contador = 0;
        for (BoletaDeDevolucion boleta : boletas) {
            if (boleta.getPeli().getTitulo().equals(titulo)) {
                contador++;
            }
        }
        return contador;
    }

    // Método auxiliar para agregar una película de manera ordenada a la lista de las más alquiladas
    private void agregarOrdenado(ArrayList<Pelicula> lista, Pelicula pelicula, int veces) {
        for (int i = 0; i < lista.size(); i++) {
            if (veces > contarVecesAlquilado(lista.get(i).getTitulo())) {
                lista.add(i, pelicula);
                return;
            }
        }
        lista.add(pelicula);
    }
}
