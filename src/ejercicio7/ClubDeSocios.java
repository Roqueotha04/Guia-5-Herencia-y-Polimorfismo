package ejercicio7;

import java.util.ArrayList;
import java.util.Scanner;

public class ClubDeSocios {
    ArrayList<Socio> socios;

    public ClubDeSocios() {
        this.socios = new ArrayList<>();
    }

    public void cargarSocio (Socio socio){
        socios.add(socio);
    }

    ///Encapsulo el metodo de los socios para el pago de cuotas
    ///verifico que el mismo exista en el array de socios.
    public void pagoDeCuota (Socio socio){
        if(socios.contains(socio)){
            socio.pagarCuota();
        }else{
            System.out.println("Socio invalido");
        }

    }

    ///Verifico que hayan elementos en la lista de socios
    public void mostrarEstadoDeudaSocios (){
        if(!socios.isEmpty()){
            System.out.println("Estado de deuda de todos los socios: ");
            for (Socio socio:socios) {
                socio.mostrarDeuda();
            }
            System.out.println("");
        }else{
            System.out.println("Lista de socios vacia");
        }

    }

    public void modificarEstadoSocio (Socio socio){
        if (socios.contains(socio)){
            if (socio.getActivo()){
                socio.darDeBaja();
            }else{
                socio.darDeAlta();
            }
        }else{
            System.out.println("socio invalido");
        }

    }

    public ArrayList<Socio> getSocios() {
        return socios;
    }
}
