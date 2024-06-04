package ejercicio6;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmpresaVehiculos {
    ArrayList<Automovil>autos;

    public EmpresaVehiculos(){
        autos= new ArrayList<>();
    }

    public void agregarVehiculo (Automovil A){
        autos.add(A);
    }

    ///Verifico que el auto se encuentre en el array de vehiculos.
    public void alquilarVehiculo (Automovil A,String nombreCliente){
        if (autos.contains(A)){
            if (A.getEstado().equals("disponible")){
                ///Creo un alquiler el cual se guardara en el historial de vehiculos
                Alquiler alquiler=new Alquiler(nombreCliente, LocalDate.now(),A.getEstado(),A.getPatente());
                A.setEstado("alquilado");
                A.CargarHistorial(alquiler);
            }else{
                System.out.println("El auto no se encuentra disponible");
            }
        }else{
            System.out.println("Auto invalido\n");
        }

    }

    ///Para mostrar el historial de un vehiculo encapsulo el llamado a la funcion en empresa
    public void mostrarHistorialUnVehiculo (Automovil A){
        A.mostrarHistorialAlquileresAuto();
    }

    public void devolverVehiculo (Automovil A){
        if (autos.contains(A)){
            if (A.getEstado().equals("alquilado")){
                A.revisionTecnica();
                if (A.getEstado().equals("optimo")){
                    A.setEstado("disponible");
                }else{
                    System.out.println("El auto debe ser reparado ");
                }
            }else{
                System.out.println("El auto no se encuentra en prestamo");
            }
        }else{
            System.out.println("Auto invalido\n");
        }

    }

    ///Si la empresa posee vehiculos muestro todos con un for each y el metodo toString.
    public void listarEstadoFlota(){
        if (!autos.isEmpty()){
            System.out.println("Estado de la flota: ");
            for (Automovil auto:autos) {
                System.out.println("Vehiculo: " + auto.getPatente() + " Estado: " + auto.getEstado());
            }
        }else{
            System.out.println("Flota vacia");
        }
        System.out.println("");
    }
    public ArrayList<Automovil> getAutos() {
        return autos;
    }

}
