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
        System.err.print("Area: ");
        System.out.print((varEjercicio7_base * varEjercicio7_altura) / 2);

        input.close();
    }
}
