import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        // 1.
        System.out.println("Leer un número, luego imprimirlo en pantalla:");
        int varEjercicio1 = input.nextInt();
        System.out.println(varEjercicio1);

        // 2.
        System.out.println("Leer un número, luego imprimir el doble del mismo en pantalla:");
        int varEjercicio2 = input.nextInt();
        System.out.println(varEjercicio2*2);
        
        // 3.
        System.out.println("Leer un número, imprimir el mismo pero sumándole 10 antes:");
        int varEjercicio3 = input.nextInt();
        varEjercicio3 += 10;
        System.out.println(varEjercicio3);

        // 4.
        System.out.println("Leer un número, imprimir el mismo multiplicado por 10:");
        int varEjercicio4 = input.nextInt();
        varEjercicio4 *= 10;
        System.out.println(varEjercicio4);

        // 5.
        System.out.println("Leer un número, asumir que será la medida del lado de un cuadrado. Del mismo imprimir su perímetro y también su área:");
        int varEjercicio5 = input.nextInt();
        System.out.println(String.format("Perímetro: %s", varEjercicio5 * 4));
        System.out.println(String.format("Area: %s", varEjercicio5 * varEjercicio5));

        // 6.
        // Leer una medida para un base de un triángulo, también su altura, en base a la altura`, 
        // imprimir su área (puede ser aproximada). 
        // Recordar que el área es base por altura dividido 2:

        System.out.println("Calcular area de un triangulo");
        System.out.print("Base: ");
        int varEjercicio6_base = input.nextInt();
        System.out.print("Altura: ");
        int varEjercicio6_altura = input.nextInt();
        System.out.println();
        System.out.print("Area: ");
        System.out.print((varEjercicio6_base * varEjercicio6_altura) / 2);
        System.out.println();
        
        // 7.
        // Para un rectángulo, leer un valor para su base, y otro valor para su altura. Una vez
        // tenemos los 2 valores, calcular e imprimir su área y su perímetro.

        System.out.println("Altura:");
        int varEjercicio7_altura = input.nextInt();
        System.out.println("Base: ");
        int varEjercicio7_base = input.nextInt();
        System.out.print("Area: ");
        System.out.println(varEjercicio7_base * varEjercicio7_altura);
        System.out.print("Perímetro: ");
        System.out.println((varEjercicio7_base + varEjercicio7_altura) * 2);

        // 8.
        System.out.println("Leer 3 números, imprimir la suma de los 3:");
        int varEjercicio8_1 = input.nextInt();
        int varEjercicio8_2 = input.nextInt();
        int varEjercicio8_3 = input.nextInt();
        System.out.println(varEjercicio8_1 + varEjercicio8_2 + varEjercicio8_3);

        // 9.
        System.out.println("Leer una edad:");
        int varEjercicio9_edad = input.nextInt();

        if (varEjercicio9_edad >= 18) {
            System.out.println("Es mayor");
        } else {
            System.out.println("Es menor");
        }

        // 10.
        System.out.println("Leer un número, imprimir si es par o impar:");
        int varEjercicio10 = input.nextInt();

        if (varEjercicio10 % 2 == 0) {
            System.out.println("ES PAR");
        } else {
            System.out.println("ES IMPAR");
        }

        // 11.
        System.out.println("Leer dos notas, imprimir la más alta:");
        int varEjercicio11_nota1 = input.nextInt();
        int varEjercicio11_nota2 = input.nextInt();

        if (varEjercicio11_nota1 > varEjercicio11_nota2) {
            System.out.println(varEjercicio11_nota1);
        } else {
            System.out.println(varEjercicio11_nota2);
        }

        // 12.
        System.out.println("Leer un número, imprimir el doble si es par, sino el triple:");
        int varEjercicio12 = input.nextInt();

        if (varEjercicio12 % 2 == 0) {
            System.out.println(varEjercicio12 * 2);
        } else {
            System.out.println(varEjercicio12 * 3);
        }

        // 13.
        System.out.println("Leer tres notas, imprimir la mayor:");
        int varEjercicio13_nota1 = input.nextInt();
        int varEjercicio13_nota2 = input.nextInt();
        int varEjercicio13_nota3 = input.nextInt();
        int varEjercicio13_mayor = varEjercicio13_nota1;

        if (varEjercicio13_nota2 > varEjercicio13_mayor) {
            varEjercicio13_mayor = varEjercicio13_nota2;
        }

        if (varEjercicio13_nota3 > varEjercicio13_mayor) {
            varEjercicio13_mayor = varEjercicio13_nota3;
        }

        System.out.println(varEjercicio13_mayor);

        // 14.
        System.out.println("Leer un número:");
        int varEjercicio14 = input.nextInt();

        if (varEjercicio14 > 100) {
            System.out.println("Muy Bien");
        } else {
            System.out.println("Leer nuevamente el número:");
            varEjercicio14 = input.nextInt();

            if (varEjercicio14 > 100) {
                System.out.println("Bien");
            } else {
                System.out.println("Mal");
            }
        }

        // 15.
        System.out.println("Leer 5 notas, imprimir la mayor:");
        int varEjercicio15_nota1 = input.nextInt();
        int varEjercicio15_nota2 = input.nextInt();
        int varEjercicio15_nota3 = input.nextInt();
        int varEjercicio15_nota4 = input.nextInt();
        int varEjercicio15_nota5 = input.nextInt();
        int varEjercicio15_mayor = varEjercicio15_nota1;

        if (varEjercicio15_nota2 > varEjercicio15_mayor) {
            varEjercicio15_mayor = varEjercicio15_nota2;
        }

        if (varEjercicio15_nota3 > varEjercicio15_mayor) {
            varEjercicio15_mayor = varEjercicio15_nota3;
        }

        if (varEjercicio15_nota4 > varEjercicio15_mayor) {
            varEjercicio15_mayor = varEjercicio15_nota4;
        }

        if (varEjercicio15_nota5 > varEjercicio15_mayor) {
            varEjercicio15_mayor = varEjercicio15_nota5;
        }

        System.out.println(varEjercicio15_mayor);

        input.close();
    }
}
