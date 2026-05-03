package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int lastIdx = 0;
        int option = -1;

        while (option != 0) { 
            System.out.print("\033[H\033[2J");
            System.out.flush();
            PrintMenu();
            option = input.hasNextInt() ? input.nextInt() : -1;
            input.nextLine();

            if (option == 0){
                return;
            }

            System.out.println("Ingrese una cadena de texto: ");
            String str = input.hasNextLine() ? input.nextLine() : "";

            switch (option) {
                case 1:
                    Exercise1(str);
                    break;
                case 2:
                    Exercise2(str);
                    break;
                case 3:
                    Exercise3(str);
                    break;
                case 4:
                    Exercise4(str);
                    break;
                case 5:
                    Exercise5(str);
                    break;
                case 6:
                    Exercise6(str);
                    break;
                case 7:
                    Exercise7(str);
                    break;
                case 8:
                    Exercise8(str);
                    break;
                case 9:
                    Exercise9(input, str);
                    break;
                case 10:
                    lastIdx = Exercise10(input, str);
                    break;
                case 11:
                    Exercise11(str, lastIdx);
                    break;
                case 12:
                    str = Exercise12(input, str);
                    break;
                case 0:
                    System.out.println("Saliendo del programa");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }

            System.out.println("Presiona cualquier tecla para continuar.");
            input.nextLine();
        }
    }

    public static void PrintMenu() {
        System.out.println("\nSeleccione un ejercicio:");
        System.out.println("1. Mostrar la longitud de la cadena");
        System.out.println("2. Verificar si la cadena esta vacia");
        System.out.println("3. Buscar si contiene xD");
        System.out.println("4. Convertir la cadena a mayusculas");
        System.out.println("5. Convertir la cadena a minusculas");
        System.out.println("6. Quitar espacios al inicio y al final");
        System.out.println("7. Comparar con Hola Mundo");
        System.out.println("8. Reemplazar a por A");
        System.out.println("9. Quitar una letra de la cadena");
        System.out.println("10. Buscar la posicion de una letra");
        System.out.println("11. Mostrar substring desde la posicion encontrada");
        System.out.println("12. Pedir otra cadena si esta vacia");
        System.out.println("0. Salir");
        System.out.print("Opcion: ");
    }

    public static void Exercise1(String str) {
        System.out.println(str.length());
    }

    public static void Exercise2(String str) {
        if (str.isEmpty()) {
          System.out.println("Cadena vacia");
        }
    }

    public static void Exercise3(String str) {
        if (str.contains("xD")) {
          System.out.println("xD");
        }
    }

    public static void Exercise4(String str) {
        System.out.println(str.toUpperCase());
    }

    public static void Exercise5(String str) {
        System.out.println(str.toLowerCase());
    }

    public static void Exercise6(String str) {
        System.out.println(str.trim());
    }

    public static void Exercise7(String str) {
        if (str.equals("Hola Mundo")) {
          System.out.println("Chau mundo");
        }
    }

    public static void Exercise8(String str) {
        System.out.println(str.replace("a", "A"));
    }

    public static void Exercise9(Scanner input, String str) {
        System.out.println("Ingrese una letra para quitarla del string original");
        String letraAQuitar = input.nextLine();
        System.out.println(str.replace(letraAQuitar, ""));
    }

    public static int Exercise10(Scanner input, String str) {
        System.out.println("Ingrese una letra para encontrarla en el string original");
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
        if (!str.equals(" ") && idx >= 0) {
          System.out.println(str.substring(idx));
        } else {
          System.out.println("No hay una posicion valida para crear el substring");
        }
    }

    public static String Exercise12(Scanner input, String str) {
        if (str.isEmpty() || str.equals(" ")) {
            System.out.println("Vuelve a ingresar un string");
            str = input.hasNextLine() ? input.nextLine() : "";
        }
        return str;
    }
}
