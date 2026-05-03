public class App {
    public static void main(String[] args) throws Exception {

        // 1.
        int x = 7;
        if(x == 0) {
            System.out.println("es 0");
        } else {
            System.out.println("no es 0");
        }

        // 2.
        if (x > 0) {
            System.out.println(x);
        } else {
            System.out.println("Numero invalido");
        }

        // 3.
        if (x >= 18) {
            System.out.println("Es mayor");
        } else {
            System.out.println("Es menor");
        }

        // 4.
        if (x > 100) {
            System.out.println("Es mayor a 100");

            if (x > 1000) {
                System.out.println("Es mayor a 1000");
            }
        } 

        // 5.
        if (x % 2 == 0) {
            System.out.println("Es par");
        } else {
            System.out.println("Es impar");
        }

        // 6.
        if (x % 5 == 0) {
            System.out.println("Es múltiplo de 5");
        } else {
            System.out.println("no lo es");
        }

        // 7.
        int var1 = 2;
        int var2 = 3;

        if (var1 > var2) {
            System.out.println(var1);
        } else {
            System.out.println(var2);
        }

        // 8.
        int variableEjercicio8 = 3;
        int variable2Ejercicio8 = 4;
        int variable3Ejercicio8 = 10;
        
        int promedioEjercicio8 = (variableEjercicio8 + variable2Ejercicio8 + variable3Ejercicio8) / 3;

        if (promedioEjercicio8 >= 5) {
            System.out.println("aprueba");
        } else {
            System.out.println("se va ape");
        }
        
        // 9.
        int variableEjercicio9 = 293;

        if (variableEjercicio9 % 10 == 3) {
            System.out.println("el ultimo dígito es 3");
        } else {
            System.out.println("no termina en 3");
        }


        // Repartido 5 analizar if else
        int variableRepartido5 = 30;

        if (variableRepartido5 % 2 == 0) {
            variableRepartido5++;
        }
        variableRepartido5++;

        System.out.println(variableRepartido5);
    }
}
