package org.example;

public class App {
    public static void main(String[] args) {

    }

    // Ejercicio 1
    static int constante() {
        return 7;
    }

    // Ejercicio 2
    static int suma(int x, int y) {
        return x + y;
    }

    // Ejercicio 3
    static boolean esPositivo(int numero) {
        return numero > 0;
    }

    // Ejercicio 4
    static int valorAbsoluto(int numero) {
        if (!esPositivo(numero)) {
            return numero * -1;
        }

        return numero;
    }

    // Ejercicio 5
    static int minutosEnSegundos(int minutos) {
        return minutos * 60;
    }

    // Ejercicio 6
    static String devuelveSinEspaciosYMinusculas(String texto) {
        return texto.trim().toLowerCase();
    }

    // Ejercicio 7
    static boolean hayPermiso(int edad, boolean permiso) {
        return edad >= 18 || permiso;
    }

    // Ejercicio 8
    static boolean cumpleRequisitos(int e, int s, boolean hayAntec) {
        return !hayAntec && 
    }
}


