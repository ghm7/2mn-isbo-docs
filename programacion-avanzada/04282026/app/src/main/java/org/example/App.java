package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese una cadena de texto: ");
        String str = input.hasNextLine() ? input.nextLine() : "";


        // 1.
        System.out.println(str.length());

        // 2.
        if (str.isEmpty()) {
          System.out.println("Cadena vacia");
        }

        // 3.
        if (str.contains("xD")) {
          System.out.println("xD");
        }

        // 4.
        System.out.println(str.toUpperCase());

        // 5.
        System.out.println(str.toLowerCase());

        // 6.
        System.out.println(str.trim());

        // 7.
        if (str.equals("Hola Mundo")) {
          System.out.println("Chau mundo");
        }

        // 8.
        System.out.println(str.replace("a", "A"));

        // 9.
        System.out.println("Ingrese una letra para quitarla del string original");
        String letraAQuitar = input.nextLine();
        System.out.println(str.replace(letraAQuitar, ""));

        // 10.
        String letraAEncontrar = input.nextLine();
        int idx = str.indexOf(letraAEncontrar);

        if (idx == -1) {
          System.out.println("No se encontro");
        } else {
          System.out.println(idx);
        }

        // 11.
        // Due of crashing with empty strings
        if (str != " ") {
          System.out.println(str.substring(idx));
        }

        // 12.
        if (str.isEmpty() || str.equals(" ")) {
            System.out.println("Vuelve a ingresar un string");
            str = input.hasNextLine() ? input.nextLine() : "";
        }

        //13
    }
}
