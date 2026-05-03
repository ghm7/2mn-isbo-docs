import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el numero de ejercicio del practico 9 (1-14): ");
        int ejercicio = input.nextInt();

        switch (ejercicio) {
            case 1:
                ejercicio1(random);
                break;
            case 2:
                ejercicio2(random);
                break;
            case 3:
                ejercicio3(random);
                break;
            case 4:
                ejercicio4(random);
                break;
            case 5:
                ejercicio5(random);
                break;
            case 6:
                ejercicio6(random);
                break;
            case 7:
                ejercicio7(random);
                break;
            case 8:
                ejercicio8(random);
                break;
            case 9:
                ejercicio9(random);
                break;
            case 10:
                ejercicio10(random);
                break;
            case 11:
                ejercicio11(random);
                break;
            case 12:
                ejercicio12(random);
                break;
            case 13:
                ejercicio13(random);
                break;
            case 14:
                ejercicio14(random, input);
                break;
            default:
                System.out.println("Ejercicio invalido.");
                break;
        }

        input.close();
    }

    private static void ejercicio1(Random random) {
        int numero = random.nextInt();
        System.out.println(numero);
    }

    private static void ejercicio2(Random random) {
        int numero = random.nextInt();
        System.out.println(numero);

        if (numero > 0) {
            System.out.println("positivo");
        } else if (numero < 0) {
            System.out.println("negativo");
        } else {
            System.out.println("cero");
        }
    }

    private static void ejercicio3(Random random) {
        int numero = random.nextInt(6);
        System.out.println(numero);
    }

    private static void ejercicio4(Random random) {
        int numero = random.nextInt();
        System.out.println(numero);

        if (numero % 2 == 0) {
            System.out.println("par");
        } else {
            System.out.println("impar");
        }
    }

    private static void ejercicio5(Random random) {
        int dado = random.nextInt(6) + 1;
        System.out.println(dado);
    }

    private static void ejercicio6(Random random) {
        for (int i = 0; i < 10; i++) {
            int dado = random.nextInt(6) + 1;
            System.out.println(dado);
        }
    }

    private static void ejercicio7(Random random) {
        int numero = random.nextInt(51) + 50;
        System.out.println(numero);
    }

    private static void ejercicio8(Random random) {
        int numero = random.nextInt(100) + 1;
        System.out.println(numero);

        if (numero >= 50) {
            System.out.println("Nada");
        } else if (numero >= 20) {
            System.out.println("Bronce");
        } else if (numero >= 4) {
            System.out.println("Plata");
        } else {
            System.out.println("Oro");
        }
    }

    private static void ejercicio9(Random random) {
        boolean valor = random.nextBoolean();
        System.out.println(valor);
    }

    private static void ejercicio10(Random random) {
        int numero = random.nextInt(21) - 10;
        System.out.println(numero);
    }

    private static void ejercicio11(Random random) {
        int numero;

        do {
            numero = random.nextInt(51);
            System.out.println(numero);
        } while (numero != 7);
    }

    private static void ejercicio12(Random random) {
        int dado1;
        int dado2;

        do {
            dado1 = random.nextInt(6) + 1;
            dado2 = random.nextInt(6) + 1;
            System.out.println(dado1 + " - " + dado2);
        } while (dado1 != dado2);
    }

    private static void ejercicio13(Random random) {
        int cantidad = random.nextInt(10) + 1;
        System.out.println("Cantidad: " + cantidad);

        for (int i = 0; i < cantidad; i++) {
            System.out.println("Hola mundo");
        }
    }

    private static void ejercicio14(Random random, Scanner input) {
        int numeroSecreto = random.nextInt(100) + 1;
        int numero;

        do {
            System.out.print("Adivine el numero: ");
            numero = input.nextInt();

            if (numero < numeroSecreto) {
                System.out.println("El numero a buscar es mayor.");
            } else if (numero > numeroSecreto) {
                System.out.println("El numero a buscar es menor.");
            }
        } while (numero != numeroSecreto);

        System.out.println("Correcto.");
    }
}
