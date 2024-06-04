package ejercicio1;

import java.util.Random;

public class Persona {
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    ///Genero una constante que almacena el valor por defecto a utilizar.
    private static final char SEXO_POR_DEFECTO = 'H';
    private float peso;
    private float altura;

    public Persona (){
        this.nombre="";
        this.edad=0;
        generaDni();
        this.sexo=SEXO_POR_DEFECTO;
        this.peso=0;
        this.altura=0;
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        generaDni();
        comprobarSexo(sexo);
        this.peso=0;
        this.altura=0;
    }

    public Persona(String nombre, int edad, char sexo, float peso, float altura) {
        this.nombre = nombre;
        this.edad = edad;
        generaDni();
        comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
    }

    ///Calculo el imc y retorno un valor constante segun el resultado
    public int calcularIMC (){
        float IMC = (float) (this.peso / Math.pow(altura,2));
        if (IMC <20){
            return -1;
        }else if (IMC>20 && IMC <25){
            return 0;
        }else{
            return 1;
        }
    }

    ///Doy respuesta al resultado del imc.
    public void analizarIMC(){
        if (this.calcularIMC()>0){
            System.out.println("La persona tiene sobrepeso");
        }else if (this.calcularIMC()==0){
            System.out.println("La persona esta en su peso ideal");
        }else{
            System.out.println("La persona se encuentra debajo del peso ideal");
        }
    }

    public boolean esMayorDeEdad(){
        if (this.edad>=18){
            System.out.println("La persona es mayor de edad");
            return true;
        }
        System.out.println("La persona es menor de edad");
        return false;
    }

    ///Genero el metodo toString para la muestra de la persona
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", DNI='" + DNI + '\'' +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }

    private void generaDni (){
        Random random = new Random();
        int numeroAleatorio = random.nextInt(8999999) + 10000000;
        this.DNI= Integer.toString(numeroAleatorio);
    }

    ///Compruebo el sexo y sino le asigno el valor de la constante
    private void comprobarSexo (char sexo){
        if (this.sexo!='H' && this.sexo!='M'){
            this.sexo=SEXO_POR_DEFECTO;
        }else{
            this.sexo=sexo;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
