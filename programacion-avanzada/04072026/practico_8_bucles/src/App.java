import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el numero de ejercicio del practico 8 (1-10): ");
        int ejercicio = input.nextInt();

        switch (ejercicio) {
            case 1:
                ejercicio1();
                break;
            case 2:
                ejercicio2();
                break;
            case 3:
                ejercicio3(input);
                break;
            case 4:
                ejercicio4();
                break;
            case 5:
                ejercicio5(input);
                break;
            case 6:
                ejercicio6();
                break;
            case 7:
                ejercicio7(input);
                break;
            case 8:
                ejercicio8(input);
                break;
            case 9:
                ejercicio9(input);
                break;
            case 10:
                ejercicio10(input);
                break;
            default:
                System.out.println("Ejercicio invalido.");
                break;
        }

        input.close();
    }

    private static void ejercicio1() {
        for (int i = 1000; i <= 2000; i++) {
            System.out.println(i);
        }
    }

    private static void ejercicio2() {
        for (int i = -1; i > -1000; i--) {
            System.out.println(i);
        }
    }

    private static void ejercicio3(Scanner input) {
        System.out.print("Ingrese un numero positivo: ");
        int numero = input.nextInt();

        while (numero > 0) {
            System.out.print("Ingrese otro numero positivo: ");
            numero = input.nextInt();
        }

        System.out.println("FIN");
    }

    private static void ejercicio4() {
        for (int i = 100; i <= 888; i++) {
            if (i % 10 == 8) {
                System.out.println(i);
            }
        }
    }

    private static void ejercicio5(Scanner input) {
        int numero;

        do {
            System.out.print("Ingrese un numero entre 100 y 200: ");
            numero = input.nextInt();
        } while (numero < 100 || numero > 200);

        System.out.println("Numero aceptado: " + numero);
    }

    private static void ejercicio6() {
        for (int i = 2000; i <= 4000; i++) {
            if (i % 2 == 0 || i % 3 == 0) {
                System.out.println(i);
            }
        }
    }

    private static void ejercicio7(Scanner input) {
        System.out.print("Ingrese la cantidad de numeros: ");
        int cantidad = input.nextInt();
        int suma = 0;

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese un numero: ");
            int numero = input.nextInt();
            suma += numero;
        }

        System.out.println("Suma: " + suma);
    }

    private static void ejercicio8(Scanner input) {
        int suma = 0;

        while (suma != 100) {
            System.out.print("Ingrese un numero. Suma actual: " + suma + ": ");
            int numero = input.nextInt();
            suma += numero;
        }

        System.out.println("La suma es 100.");
    }

    private static void ejercicio9(Scanner input) {
        System.out.print("Ingrese la cantidad de notas: ");
        int cantidad = input.nextInt();
        double suma = 0;

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese una nota: ");
            double nota = input.nextDouble();
            suma += nota;
        }

        System.out.println("Suma: " + suma);

        if (cantidad > 0) {
            System.out.println("Promedio: " + (suma / cantidad));
        } else {
            System.out.println("No se ingresaron notas.");
        }
    }

    private static void ejercicio10(Scanner input) {
        int paresSeguidos = 0;

        while (paresSeguidos < 2) {
            System.out.print("Ingrese un numero: ");
            int numero = input.nextInt();

            if (numero % 2 == 0) {
                paresSeguidos++;
            } else {
                paresSeguidos = 0;
            }
        }

        System.out.println("Se ingresaron dos pares seguidos.");
    }
}
