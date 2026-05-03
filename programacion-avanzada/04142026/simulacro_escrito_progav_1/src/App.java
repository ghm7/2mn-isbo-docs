import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Ingrese el numero de ejercicio del simulacro (0-8): ");
        int ejercicio = input.nextInt();

        switch (ejercicio) {
            case 0:
                ejercicio0();
                break;
            case 1:
                ejercicio1();
                break;
            case 2:
                ejercicio2(input);
                break;
            case 3:
                ejercicio3();
                break;
            case 4:
                ejercicio4();
                break;
            case 5:
                ejercicio5(input);
                break;
            case 6:
                ejercicio6(random);
                break;
            case 7:
                ejercicio7(input);
                break;
            case 8:
                ejercicio8(input);
                break;
            default:
                System.out.println("Ejercicio invalido.");
                break;
        }

        input.close();
    }

    private static void ejercicio0() {
        int a = 2;
        int b = 4;

        System.out.println(a + b);
        System.out.println(a + b / 2);
        System.out.println(a + b / 2 < 4);
        a = b;
        System.out.println(a + b / 2 < 5);
    }

    private static void ejercicio1() {
        int numero = 0;

        if (numero == 0) {
            System.out.println("es 0");
        } else {
            System.out.println("es otro numero");
        }
    }

    private static void ejercicio2(Scanner input) {
        System.out.print("Ingrese el primer numero: ");
        int primerNumero = input.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        int segundoNumero = input.nextInt();

        if (primerNumero > segundoNumero) {
            System.out.println(primerNumero);
        } else if (segundoNumero > primerNumero) {
            System.out.println(segundoNumero);
        }
    }

    private static void ejercicio3() {
        int numero = 98;

        if (numero % 2 == 0 && numero < 100) {
            System.out.println("Cumple");
        } else {
            System.out.println("NO cumple");
        }
    }

    private static void ejercicio4() {
        for (int i = 46; i < 250; i++) {
            System.out.println(i);
        }
    }

    private static void ejercicio5(Scanner input) {
        int numero;

        do {
            System.out.print("Ingrese un numero: ");
            numero = input.nextInt();
        } while (numero % 2 != 0);
    }

    private static void ejercicio6(Random random) {
        int animal = random.nextInt(3);

        switch (animal) {
            case 0:
                System.out.println("Gato");
                break;
            case 1:
                System.out.println("Perro");
                break;
            case 2:
                System.out.println("Vaca");
                break;
            default:
                break;
        }
    }

    private static void ejercicio7(Scanner input) {
        int cantidad = 0;
        int numero;

        do {
            System.out.print("Ingrese un numero: ");
            numero = input.nextInt();

            if (numero != 100) {
                cantidad++;
            }
        } while (numero != 100);

        System.out.println("Cantidad de numeros ingresados previamente: " + cantidad);
    }

    private static void ejercicio8(Scanner input) {
        System.out.print("Ingrese la cantidad de notas: ");
        int cantidad = input.nextInt();
        double suma = 0;

        for (int i = 0; i < cantidad; i++) {
            System.out.print("Ingrese una nota: ");
            double nota = input.nextDouble();
            suma += nota;
        }

        System.out.println("Cantidad de notas leidas: " + cantidad);

        if (cantidad > 0) {
            System.out.println("Promedio: " + (suma / cantidad));
        } else {
            System.out.println("Promedio: 0");
        }
    }
}
