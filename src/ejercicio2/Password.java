package ejercicio2;

import java.util.Random;

public class Password {

    private int longitud;
    private String contrasenia;

    public Password (){
        longitud=8;
        generarContrasenia();
    }

    public Password (int longitud){
        this.longitud=longitud;
        generarContrasenia();
    }

    ///Genero un string random concatenando caracteres y utilizando el emtodo rand.
    private void generarContrasenia (){
        ///cargo un string con los caracteres
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_-+=<>?";
        Random random = new Random();
        String stringRandom = "";

        for (int i = 0; i < this.longitud; i++) {
            ///elijo un string random mediante el indice
            int indice = random.nextInt(caracteres.length());
            ///lo agrego a la cadena que será la contraseña luego
            stringRandom += caracteres.charAt(indice);
        }
        this.contrasenia=stringRandom;

    }

    public boolean esFuerte (){
        int contadorMayus=0;
        int contadorMinus=0;
        int contadorNum=0;
    ///Verifico y cuento la cantidad de caracteres de cada tipo segun los metodos isUpperCase, isLowerCase y isDigit.
        for (int i=0;i<longitud;i++){
            if (Character.isUpperCase(contrasenia.charAt(i))){
                contadorMayus++;
            } else if (Character.isLowerCase(contrasenia.charAt(i))){
                contadorMinus++;
            } else if (Character.isDigit(contrasenia.charAt(i))){
                contadorNum++;
            }

        }
        return contadorNum>5 && contadorMayus>2 && contadorMinus>1;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
