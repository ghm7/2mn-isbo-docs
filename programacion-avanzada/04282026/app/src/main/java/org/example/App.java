package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Ingrese una cadena de texto: ");
        String str = input.hasNextLine() ? input.nextLine() : "";

        Exercise1(str);
        Exercise2(str);
        Exercise3(str);
        Exercise4(str);
        Exercise5(str);
        Exercise6(str);
        Exercise7(str);
        Exercise8(str);
        Exercise9(input, str);
        int idx = Exercise10(input, str);
        Exercise11(str, idx);
        str = Exercise12(input, str);
        Exercise13();
    }

    public static void Exercise1(String str) {
        // 1.
        System.out.println(str.length());
    }

    public static void Exercise2(String str) {
        // 2.
        if (str.isEmpty()) {
          System.out.println("Cadena vacia");
        }
    }

    public static void Exercise3(String str) {
        // 3.
        if (str.contains("xD")) {
          System.out.println("xD");
        }
    }

    public static void Exercise4(String str) {
        // 4.
        System.out.println(str.toUpperCase());
    }

    public static void Exercise5(String str) {
        // 5.
        System.out.println(str.toLowerCase());
    }

    public static void Exercise6(String str) {
        // 6.
        System.out.println(str.trim());
    }

    public static void Exercise7(String str) {
        // 7.
        if (str.equals("Hola Mundo")) {
          System.out.println("Chau mundo");
        }
    }

    public static void Exercise8(String str) {
        // 8.
        System.out.println(str.replace("a", "A"));
    }

    public static void Exercise9(Scanner input, String str) {
        // 9.
        System.out.println("Ingrese una letra para quitarla del string original");
        String letraAQuitar = input.nextLine();
        System.out.println(str.replace(letraAQuitar, ""));
    }

    public static int Exercise10(Scanner input, String str) {
        // 10.
        String letraAEncontrar = input.nextLine();
        int idx = str.indexOf(letraAEncontrar);

        if (idx == -1) {
          System.out.println("No se encontro");
        } else {
          System.out.println(idx);
        }
        return idx;
    }

    public static void Exercise11(String str, int idx) {
        // 11.
        // Due of crashing with empty strings
        if (str != " ") {
          System.out.println(str.substring(idx));
        }
    }

    public static String Exercise12(Scanner input, String str) {
        // 12.
        if (str.isEmpty() || str.equals(" ")) {
            System.out.println("Vuelve a ingresar un string");
            str = input.hasNextLine() ? input.nextLine() : "";
        }
        return str;
    }

    public static void Exercise13() {
        //13
    }
}
