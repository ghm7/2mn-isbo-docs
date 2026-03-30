import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
    
        // 1. Imprimir en pantalla "H" 50 veces
        for (int i = 0; i < 50; i++ ) {
            System.out.println("H");
        }

        // 2. Imprimir en pantalla los números del 0 al 100
        for (int i = 0; i <= 100; i++) {
            System.out.println(i);
        }

        // 3. Imprimir en pantalla los números del 1 al 99.
        for (int i = 1; i < 100; i++) {
            System.out.println(i);
        }

        // 4. Imprimir en pantalla los pares del 0 al 100.
        for (int i = 0; i <= 100; i = i + 2) {
            System.out.println(i);
        }

        // 5. Imprimir en pantalla los números del 70 al 100.
        for (int i = 70; i <= 200; i++) {
            System.out.println(i);
        }

        // 6. Imprimir en pantalla los números del 0 al 100, pero en orden descendiente.
        for (int i = 100; i >= 0; i--) {
            System.out.println(i);
        }

        // 7. Imprimir los multiplso de 3 entre 0 y 100.
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }

        // 8. Leer un numero que ingrese el usuario, imprimir "Hola" esa cantidad de veces que el usuario ingreso
        System.out.println("Ingrese la cantidad de holas que quiere");
        int variable8 = input.nextInt();

        for (int i = 0; i < variable8; i++) {
            System.out.println("Hola");
        }

        // 9. Imprimir la tabla del 3. (3x1, 3x2, 3x3...)
        for (int i = 1; i <= 10; i++) {
            int x = i * 3;

            System.out.println(i + " x 3 = " + x);
        }

        // 10. Imprimir todos los múltiplos de 4 entre 200 y 300, incluyendo a ambos en el rango.
        for (int i = 200; i <= 300; i++) {
            if (i % 4 == 0) {
                System.out.println(i);
            }
        }

        // 11. Imprimir un cuadrado formado por el caracter x. El mismo debe ser de 5x5.
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i > 0 && i < 4) {
                    if (j == 0 || j == 4) {
                        System.out.print("x ");
                    } else {
                        System.out.print("  ");
                    }
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }


        // 12 Similar al anterior pero ahora con una medida que ingrese el usuario por teclado.
        System.out.println("Elija la dimension del cuadrado:");
        int variable12 = input.nextInt();
        for (int i = 0; i < variable12; i++) {
            for (int j = 0; j < variable12; j++) {
                if (i > 0 && i < (variable12 - 1)) {
                    if (j == 0 || j == (variable12 - 1)) {
                        System.out.print("x ");
                    } else {
                        System.out.print("  ");
                    }
                } else {
                    System.out.print("x ");
                }
            }
            System.out.println();
        }
    
        // 13 Imprimir todos los números que terminan en 4 entre 200 y 300
        for (int i = 200; i < 300; i++) {
            if (i % 10 == 4) {
                System.out.println(i);
            }
        }

        // 14 Pedir un numero, sumar todos los números desde el 0 al numero ingresado, imprimir el resultado en pantalla.
        int accumulator = 0;

        System.out.println("Ingrese un numero:");
        int variable14 = input.nextInt();

        for (int i = 0; i < variable14; i++) {
            accumulator += i;
        }
        accumulator += variable14;

        System.out.println(accumulator);
    }
}
