import ejercicio1.*;
import ejercicio2.*;
import ejercicio3.*;
import ejercicio4.*;
import ejercicio5.*;
import ejercicio6.*;
import ejercicio7.*;
import ejercicio8.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        char control = 's';
        Scanner teclado= new Scanner(System.in);
        int numero;
        do{
            System.out.println("Que ejercicio desea ver?");
            numero=teclado.nextInt();
            switch (numero){
                case 1:
                   ejercicio1();
                break;
                case 2:
                    ejercicio2();
                    break;
                case 3:
                    ejercicio3();
                    break;
                case 4:
                    ejercicio4();
                    break;
                case 5:
                    ejercicio5();
                    break;
                case 6:
                    ejercicio6();
                    break;
                case 7:
                    ejercicio7();
                    break;
                case 8:
                    ejercicio8();
                    break;
            }

            System.out.println("Desea ver otro ejercicio? s/n");
            control=teclado.next().charAt(0);
        }while (control == 's');

    }

    public static void ejercicio1(){
        Scanner teclado1= new Scanner(System.in);
        System.out.println("Ingrese el nombre");
        String nombre=teclado1.nextLine();

        System.out.println("Ingrese la edad");
        int edad=teclado1.nextInt();


        System.out.println("Ingrese el genero");

        teclado1.nextLine();
        char sexo=teclado1.nextLine().charAt(0);

        System.out.println("Ingrese el peso");
        float peso=teclado1.nextFloat();

        System.out.println("Ingrese la altura en metros");
        float altura=teclado1.nextFloat();

        Persona persona1= new Persona(nombre,edad,sexo,peso,altura);
        Persona persona2= new Persona(nombre,edad,sexo);

        Persona persona3= new Persona();
        persona3.setNombre(nombre);
        persona3.setEdad(edad);
        persona3.setSexo(sexo);
        persona3.setAltura(altura);
        persona3.setPeso(peso);

        persona1.analizarIMC();
        persona2.analizarIMC();
        persona3.analizarIMC();

        persona1.esMayorDeEdad();
        persona2.esMayorDeEdad();
        persona3.esMayorDeEdad();

        System.out.println(persona1.toString());
        System.out.println(persona2.toString());
        System.out.println(persona3.toString());
    }

    public static void ejercicio2(){
        Scanner teclado2= new Scanner(System.in);
        System.out.println("Ingrese la longitud del arreglo de passwords que desea");
        int dimension=teclado2.nextInt();
        System.out.println("Indique la longitud de las password que desea");
        int longitud=teclado2.nextInt();

        Password []contrasenias =new Password[dimension];
        Boolean [] fuerzaPasswords= new Boolean[dimension];

        for (int i=0;i<dimension;i++){
            contrasenias[i] = new Password(longitud);
            fuerzaPasswords[i]= contrasenias[i].esFuerte();

            System.out.println("Contrasenia: " + contrasenias[i].getContrasenia() + " es fuerte = " + fuerzaPasswords[i]);
        }
    }

    public static void ejercicio3(){
        Electrodomestico [] electrodomesticos = new Electrodomestico[10];
        electrodomesticos[0] = new Electrodomestico(500.0f, "Blanco", 'A', 10.0f);
        electrodomesticos[1] = new Electrodomestico(700.0f, "Negro", 'B', 15.0f);
        electrodomesticos[2] = new Television(600.0f, "Rojo", 'C', 12.0f,50,false);
        electrodomesticos[3] = new Lavadora(800.0f, "Gris", 'D', 18.0f,60);
        electrodomesticos[4] = new Electrodomestico(900.0f, "Azul", 'E', 20.0f);
        electrodomesticos[5] = new Electrodomestico();
        electrodomesticos[6] = new Lavadora(1000.0f,"Negro",'A',50.0f,20);
        electrodomesticos[7] = new Lavadora();
        electrodomesticos[8] = new Television();
        electrodomesticos[9] = new Television(800.0f,"Rojo",'C',80.0f,90,true);

        ///Realizo la llamada del metodo estatico
        Electrodomestico.sumaPrecioFinal(electrodomesticos);
    }
    public static void ejercicio4(){
        Videojuego [] videojuegos = new Videojuego[5];
        Serie [] series= new Serie [5];
        videojuegos[0]=new Videojuego("Rayman 2",20);
        videojuegos[1]=new Videojuego("Detroit Become Human",30);
        videojuegos[2]=new Videojuego("Budokai Tenkaichi 3","Accion",1000,"Bandai Namco");
        videojuegos[3]=new Videojuego();
        videojuegos[4]=new Videojuego("Fifa 22",60);

        series [0]=new Serie("Okupas","Drama",1,"Bruno Stagnaro");
        series [1]=new Serie("Black Mirror", "Ciencia Ficcion");
        series [2]=new Serie("Breaking Bad", "Accion", 6, "Vince Gilligan");
        series [3]=new Serie("Un show Mas", "Comedia",8,"JQ Quintel");
        series [4]=new Serie();

        videojuegos[1].entregar();
        videojuegos[2].entregar();

        series[1].entregar();
        series[3].entregar();
        series[3].devolver();

        ///Realizo la llamada de los metodos estaticos para buscar series o videojuegos.
        System.out.println("La cantidad de elementos multimedia prestados es de " + Multimedia.contarMultimediaEntregada(series,videojuegos));
        System.out.println("Serie con mas temporadas " + Serie.BuscarSerieConMasTemporadas(series).toString());
        System.out.println("Videojuego con mas horas " + Videojuego.BuscarVideoJuegoConMasHoras(videojuegos).toString());
    }
    public static void ejercicio5(){
        Empresa empresa = new Empresa ();
        ///Cargo clientes a la empresa, estos seran los que use luego para realizar las compras
        empresa.agregarNuevoCliente(new ClienteMinorista("Juansito","Rivadavia 123","23-12345678-2"));
        empresa.agregarNuevoCliente(new ClienteMinorista("Carlitos","Belgrano 123","12-23456789-3"));
        empresa.agregarNuevoCliente(new ClienteMayorista("Marcelo","Av. Mario Bravo 23","32-11122233-9",20.3f));
        ///Cargo los productos a elegir, cargo el nombre y precio, puesto que la cantidad la debe elegir el cliente proximamente
        empresa.cargarNuevoProducto(new Producto("remera",50));
        empresa.cargarNuevoProducto(new Producto("pantalon",10));
        empresa.cargarNuevoProducto(new Producto("buzo",20));
        empresa.cargarNuevoProducto(new Producto("zapatillas",30));
        empresa.cargarNuevoProducto(new Producto("camperas",70));


        ///Creo un array de productos para pasar a la factura
        ArrayList<Producto>productosCliente =new ArrayList<>();
        productosCliente.add(empresa.getProductos().get(0));
        productosCliente.add(empresa.getProductos().get(2));
        productosCliente.add(empresa.getProductos().get(3));

        ///Cargo una nueva factura, requiere de un cliente existente y productos que esten en la empresa.
        empresa.cargarNuevaFactura(empresa.getClientes().get(2),productosCliente);

        empresa.mostrarUnaFactura(0);
    }
    public static void ejercicio6(){
        EmpresaVehiculos empresa=new EmpresaVehiculos();
        empresa.agregarVehiculo(new Automovil("ABC123", "Toyota", "Corolla", 2018, 50000, 50.0, "disponible"));
        empresa.agregarVehiculo(new Automovil("DEF456", "Honda", "Civic", 2019, 40000, 55.0, "disponible"));
        empresa.agregarVehiculo(new Automovil("GHI789", "Ford", "Focus", 2020, 30000, 60.0, "alquilado"));
        empresa.agregarVehiculo(new Automovil("JKL012", "Chevrolet", "Cruze", 2017, 60000, 45.0, "disponible"));
        empresa.agregarVehiculo(new Automovil("MNO345", "Volkswagen", "Golf", 2016, 70000, 40.0, "en reparacion"));


        empresa.alquilarVehiculo(empresa.getAutos().get(0),"Carlos");
        empresa.alquilarVehiculo(empresa.getAutos().get(2),"Juan");
        empresa.alquilarVehiculo(empresa.getAutos().get(3),"Jeremias");
        empresa.alquilarVehiculo(empresa.getAutos().get(1),"Agustin");

        empresa.devolverVehiculo(empresa.getAutos().get(2));
        //empresa.alquilarVehiculo(empresa.getAutos().get(2),"Ricardo");
        empresa.devolverVehiculo(empresa.getAutos().get(0));
        empresa.alquilarVehiculo(empresa.getAutos().get(0),"Sergio");


        empresa.listarEstadoFlota();
        System.out.println("Historial auto");
        empresa.mostrarHistorialUnVehiculo(empresa.getAutos().get(0));
    }
    public static void ejercicio7(){
        ClubDeSocios club=new ClubDeSocios();
        club.cargarSocio(new SocioNormal("Juan Pérez", 160.0, 50.0));
        club.cargarSocio(new SocioNormal("María López", 180.0, 75.0));
        club.cargarSocio(new SocioVitalicio("Pedro Gómez", 200.0));
        club.cargarSocio(new SocioAusente("Ana Martínez", 130.0, 60.0));
        club.cargarSocio(new SocioAusente("Luis Rodríguez", 80.0, 100.0));
        club.cargarSocio(new SocioNormal("Laura García", 220.0, 110.0));

        club.mostrarEstadoDeudaSocios();
        System.out.println("Pago de cuotas");
        club.pagoDeCuota(club.getSocios().get(1));
        club.pagoDeCuota(club.getSocios().get(2));
        club.pagoDeCuota(club.getSocios().get(4));

        club.mostrarEstadoDeudaSocios();
    }

    public static void ejercicio8(){
        VideoClub roberto = new VideoClub();

        cargarArrayPeliculas(roberto);
        cargarArrayClientes(roberto);


        System.out.println("¡Bienvenido al VideoClub de Roberto!");
        Scanner teclado = new Scanner(System.in);
        char control = 's';
        int numero;

        do {
            System.out.println("¿En qué puedo ayudarlo?\n1. Otorgar un CD\n2. Devolver una Pelicula\n3. Consultar Alquileres Vigentes\n4.Consultar devoluciones en un dia especifico\n" +
                    "5.Mostrar ultimos alquileres de un cliente\n6.Mostrar titulos mas alquilados\n7.Mostrar titulos mas alquilados por genero\n8.Ver informacion detallada de una pelicula");
            numero = teclado.nextInt();
            teclado.nextLine();
            switch (numero) {
                case 1:{
                    System.out.println("Ingrese el título de la película que desea ver: ");
                    String peli = teclado.nextLine();
                    Pelicula pelicula = roberto.buscarPeliculaPorTitulo(peli);
                    if (pelicula != null) {
                        if (pelicula.revisarStock()) {
                            System.out.println("Dígame su nombre para verificar si es cliente: ");
                            String nombre = teclado.nextLine();
                            Cliente cliente = roberto.buscarClientePorNombre(nombre);

                            if (cliente != null) {
                                System.out.println("Genial " + cliente.getNombreYApellido() + " ahora le otorgo la película");

                            } else {

                                System.out.println("Parece que no está registrado, ahora lo registro.");
                                cliente = roberto.cargarUnCliente(teclado);
                                roberto.agregarUnCliente(cliente);
                            }
                            roberto.agregarBoleta(cliente,pelicula);
                            cliente.mostrarCliente();
                        }
                    }
                    break;
            }
                case 2:{
                    System.out.println("Dígame su nombre por favor para ubicarlo: ");
                    String nombre = teclado.nextLine();
                    Cliente cliente = roberto.buscarClientePorNombre(nombre);
                    if (cliente != null) {
                        System.out.println("Genial, estas son sus boletas a deber: ");
                        cliente.mostrarArrayBoletas();
                        System.out.println("Ingrese por favor el ID de la boleta que desea devolver: ");
                        int id = teclado.nextInt();
                        BoletaDeDevolucion boleta = roberto.buscarBoletaPorId(id);
                        if (boleta != null) {
                            roberto.devolverPelicula(boleta);
                            cliente.mostrarCliente();
                        }
                    }
                    break;
            }
                case 3:{
                    System.out.println("Total de boletas aquí: ");
                    roberto.mostrarTotalBoletasActivas();
                    break;
            }
                case 4: {
                    LocalDate fecha;
                    System.out.println("¿Dentro de cuántos días quiere saber?");
                    int dia = teclado.nextInt();
                    fecha = LocalDate.now().plusDays(dia);
                    roberto.mostrarPelisSeDevuelvenDiaEspecifico(fecha);
                    break;
                }
                case 5:
                    System.out.println("Dígame su nombre por favor para ubicarlo: ");
                    String nombre = teclado.nextLine();
                    Cliente cliente = roberto.buscarClientePorNombre(nombre);
                    if (cliente != null) {
                        cliente.mostrarUltimosAlquileresDeCliente();
                    }else{
                        System.out.println("El cliente no se encuentra en el sistema");
                    }
                    break;
                case 6:
                    roberto.obtener5TitulosMasAlquilados();
                    break;
                case 7:
                    System.out.println("Ingrese el genero que desea consultar");
                    String genero= teclado.nextLine();
                    roberto.mostrarTitulosMasSolicitadosPorGenero(genero);
                    break;
                case 8:
                    System.out.println("Ingrese el título de la película que desea ver: ");
                    String peli = teclado.nextLine();
                    Pelicula pelicula = roberto.buscarPeliculaPorTitulo(peli);
                    roberto.mostrarPeliculaDetallada(pelicula);
                    break;
            }
            System.out.println("¿Puedo ofrecerle algo más?");
            control = teclado.next().charAt(0);
        } while (control == 's');
    }

    public static void cargarArrayClientes(VideoClub roberto) {
        roberto.agregarUnCliente(new Cliente("Juan Gonzalez", "2236123456", "Los Alacalufes 1820"));
        roberto.agregarUnCliente(new Cliente("Pedro Pascal", "2235234567", "genova 3710"));
        roberto.agregarUnCliente(new Cliente("Cristian Alvarez", "2234111222", "fortunato de la plaza 1341"));
        roberto.agregarUnCliente(new Cliente("Julian Kartun", "2233111333", "Independecia y la costa"));
        roberto.agregarUnCliente(new Cliente("Charo Lopez", "2235333111", "Laprida 1234"));
    }
    public static void cargarArrayPeliculas (VideoClub roberto){
        roberto.agregarUnaPelicula(new Pelicula("John Wick", 2014, 101, "R", "EE.UU", 150, "Protagonizada por Keanu Reeves, esta película de acción sigue a un ex asesino a sueldo que regresa a su antiguo mundo criminal para vengarse de quienes le han hecho daño, desatando una ola de violencia en su camino.", "Accion"));
        roberto.agregarUnaPelicula(new Pelicula("Piratas del Caribe: La maldición del Perla Negra", 2003, 143, "PG-13", "EE.UU", 100, "Protagonizada por Johnny Depp como el icónico Capitán Jack Sparrow, esta película de aventuras sigue a un grupo de piratas en busca de un tesoro maldito en el Caribe, enfrentándose a peligrosos enemigos y criaturas sobrenaturales.", "Aventura"));
        roberto.agregarUnaPelicula(new Pelicula("El Señor de los Anillos: La Comunidad del Anillo", 2001, 178, "PG-13", "EE.UU y NZL", 80, "Basada en la obra de J.R.R. Tolkien, esta epopeya de fantasía dirigida por Peter Jackson sigue a Frodo Bolsón y un grupo de compañeros mientras buscan destruir un poderoso anillo que podría sumir al mundo en la oscuridad.", "Aventura"));
        roberto.agregarUnaPelicula(new Pelicula("Intocable", 2011, 112, "R", "FRA", 120, "Basada en una historia real, esta comedia dramática francesa sigue la improbable amistad entre un millonario tetrapléjico y su joven y poco convencional cuidador, interpretado por Omar Sy.", "Drama"));
        roberto.agregarUnaPelicula(new Pelicula("Mad Max: Fury Road", 2015, 120, "R", "AUS Y EE.UU", 120, "Dirigida por George Miller, esta película de acción post-apocalíptica sigue a Max Rockatansky, interpretado por Tom Hardy, mientras lucha por sobrevivir en un mundo desolado y se une a un grupo de rebeldes liderado por Furiosa, interpretada por Charlize Theron.", "Accion"));
        roberto.agregarUnaPelicula(new Pelicula("La Lista de Schindler", 1993, 195, "R", "EE.UU", 100, "Dirigida por Steven Spielberg, esta película dramática histórica se basa en la verdadera historia de Oskar Schindler, interpretado por Liam Neeson, un empresario alemán que salvó a más de mil judíos durante el Holocausto.", "Drama"));
        roberto.agregarUnaPelicula(new Pelicula("El Conjuro", 2013, 112, "R", "EE.UU", 75, "Basada en eventos reales, esta película de terror sigue a los investigadores paranormales Ed y Lorraine Warren, interpretados por Patrick Wilson y Vera Farmiga, mientras enfrentan a una presencia maligna en una casa embrujada.", "Horror"));
        roberto.agregarUnaPelicula(new Pelicula("La La Land", 2016, 128, "PG-13", "FRA", 170, "Protagonizada por Ryan Gosling y Emma Stone, esta película musical romántica cuenta la historia de un pianista de jazz y una aspirante a actriz en Los Ángeles, mientras luchan por alcanzar sus sueños y encontrar el amor.", "Drama"));
        roberto.agregarUnaPelicula(new Pelicula("John Wick 4", 2023, 142, "R", "EE.UU", 55, "Jhon Wick debe dar su ultima batalla en la pelicula mas epica de la historia de Hollywood","Accion"));
        roberto.agregarUnaPelicula(new Pelicula("Blackfish", 2013, 83, "PG-13", "EE.UU", 40, "Este documental expone la verdad detrás de la cautividad de orcas en parques acuáticos y las controversias que rodean a la industria del entretenimiento marino.", "Documental"));
        roberto.agregarUnaPelicula(new Pelicula("Forrest Gump", 1994, 142, "PG-13", "EE.UU", 80, "Dirigida por Robert Zemeckis, esta película sigue la vida de Forrest Gump, interpretado por Tom Hanks, un hombre con discapacidad intelectual que vive una vida extraordinaria mientras atraviesa eventos clave en la historia de Estados Unidos. Una historia conmovedora sobre amor, amistad y superación de adversidades.", "Accion"));
        roberto.agregarUnaPelicula(new Pelicula("Exit Through the Gift Shop", 2010, 87, "R", "R.U", 30, "Dirigido por el misterioso artista callejero Banksy, este documental examina la cultura del arte callejero y sigue la historia de un hombre obsesionado con capturar la esencia de este movimiento artístico en un documental.", "Documental"));
        roberto.agregarUnaPelicula(new Pelicula("El Padrino", 1972, 175, "NC-17", "EEUU", 25, "Mafia", "Accion"));
        roberto.agregarUnaPelicula(new Pelicula("Coco", 2017, 105, "G", "MEX", 15, "Esta hermosa película nos habla de la importancia de la familia.", "Aventura"));
        roberto.agregarUnaPelicula(new Pelicula("Titanic", 1997, 194, "PG-13", "EEUU", 34, "es un drama romántico basado en los eventos históricos del hundimiento del RMS Titanic en 1912. La trama se centra en la historia de amor entre Jack Dawson, un joven aventurero interpretado por Leonardo DiCaprio, y Rose DeWitt Bukater", "Drama"));
    }

}