package org.example;

import java.util.Random;

public class App {
    public static void main(String[] args) {

    }

    static void primerProcedimiento() {
        System.out.println("PRIMER METODO INVOCADO CORRECTAMENTE");
    }
    static void doble(int x) {
        System.out.println(x * 2);
    }
    static void cuadrado(int x) {
        System.out.println(x * x);
    }
    static void perimetroCuadrado(int lado) {
        System.out.println(lado * 4);
    }
    static void areaRectangulo(int ancho, int altura) {
        System.out.println(ancho * altura);
    }
    static void mayor(int x, int y) {
        if (x > y) {
            System.out.println(x);
        } else {
            System.out.println(y);
        }
    }
    static void promedio(int x, int y) {
        System.out.println((x + y) / 2);
    }
    static void repetirTexto(int veces) {
        for (int i = 0; i < veces; i++) {
            System.out.println("Hola mundo");
        }
    }
    static void repetirTextoConError(int veces) {
        if (veces <= 0) {
            System.out.println("Error");
            return;
        }

        repetirTexto(veces);
    }
    static void saludar(String nombre) {
        System.out.println("Buen dia " + nombre);
    }
    static void imprimirCaracter(char c) {
        for (int i = 0; i < 10; i++) {
            System.out.print(c + " ");
        }
        System.out.println(" ");
    }
    static void esPar(int x) {
        if (x % 2 == 0) {
            System.out.println("Es par");
        } else {
            System.out.println("No es par");
        }
    }
    static void aleatorio(int x) {
        Random random = new Random();
        System.out.println(random.nextInt(x) + 1);
    }
    static void aleatorioConRango(int x, int y) {
        Random random = new Random();
        System.out.println(random.nextInt(x, y + 1));
    }
    static void imprimirHasta(int x) {
        for (int i = 0; i <= x; i++) {
            System.out.println(i);
        }
    }
}
