import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Ingrese el numero de ejercicio del practico 7 (1-10): ");
        int ejercicio = input.nextInt();
        input.nextLine();

        switch (ejercicio) {
            case 1:
                ejercicio1();
                break;
            case 2:
                ejercicio2(input);
                break;
            case 3:
                ejercicio3(input);
                break;
            case 4:
                ejercicio4(input);
                break;
            case 5:
                ejercicio5(input);
                break;
            case 6:
                ejercicio6(input);
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
        while (true) {
            System.out.println("Error");
        }
    }

    private static void ejercicio2(Scanner input) {
        int numero;

        do {
            System.out.print("Ingrese un numero (0 para finalizar): ");
            numero = input.nextInt();
        } while (numero != 0);
    }

    private static void ejercicio3(Scanner input) {
        System.out.print("Ingrese un numero positivo: ");
        int numero = input.nextInt();

        while (numero <= 0) {
            System.out.print("Ese numero no es positivo. Ingrese uno positivo: ");
            numero = input.nextInt();
        }

        System.out.println("Numero aceptado: " + numero);
    }

    private static void ejercicio4(Scanner input) {
        System.out.print("Ingrese una contrasena de al menos 8 caracteres: ");
        String contrasena = input.nextLine();

        while (contrasena.length() < 8) {
            System.out.print("La contrasena es muy corta. Ingrese otra: ");
            contrasena = input.nextLine();
        }

        System.out.println("Contrasena aceptada.");
    }

    private static void ejercicio5(Scanner input) {
        int numero;

        do {
            System.out.print("Ingrese un numero entre 10 y 20: ");
            numero = input.nextInt();
        } while (numero < 10 || numero > 20);

        System.out.println("Numero aceptado: " + numero);
    }

    private static void ejercicio6(Scanner input) {
        int suma = 0;
        int numero;

        do {
            System.out.print("Ingrese un numero (0 para finalizar): ");
            numero = input.nextInt();
            suma += numero;
        } while (numero != 0);

        System.out.println("Suma: " + suma);
    }

    private static void ejercicio7(Scanner input) {
        int cantidad = 0;
        int numero;

        do {
            System.out.print("Ingrese un numero (0 para finalizar): ");
            numero = input.nextInt();

            if (numero != 0) {
                cantidad++;
            }
        } while (numero != 0);

        System.out.println("Cantidad ingresada: " + cantidad);
    }

    private static void ejercicio8(Scanner input) {
        double suma = 0;
        int cantidad = 0;
        double nota;

        do {
            System.out.print("Ingrese una nota (0 o negativo para finalizar): ");
            nota = input.nextDouble();

            if (nota > 0) {
                suma += nota;
                cantidad++;
            }
        } while (nota > 0);

        if (cantidad > 0) {
            System.out.println("Promedio: " + (suma / cantidad));
        } else {
            System.out.println("No se ingresaron notas.");
        }
    }

    private static void ejercicio9(Scanner input) {
        int pares = 0;
        int impares = 0;
        int mayoresA100 = 0;
        int numero;

        do {
            System.out.print("Ingrese un numero (0 para finalizar): ");
            numero = input.nextInt();

            if (numero != 0) {
                if (numero % 2 == 0) {
                    pares++;
                } else {
                    impares++;
                }

                if (numero > 100) {
                    mayoresA100++;
                }
            }
        } while (numero != 0);

        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
        System.out.println("Mayores a 100: " + mayoresA100);
    }

    private static void ejercicio10(Scanner input) {
        int numeroSecreto = 42;
        int intentos = 0;
        int numero;

        do {
            System.out.print("Adivine el numero: ");
            numero = input.nextInt();
            intentos++;

            if (numero < numeroSecreto) {
                System.out.println("El numero a adivinar es mayor.");
            } else if (numero > numeroSecreto) {
                System.out.println("El numero a adivinar es menor.");
            }
        } while (numero != numeroSecreto);

        System.out.println("Correcto. Intentos: " + intentos);
    }
}
