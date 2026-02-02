import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        mostrarMenu();
        int opcion = pedirOpcion(sc);
        double a = pedirNumero(sc, "Numero1");
        double b = pedirNumero(sc, "Numero2");

        ejecutarOperacion(opcion, a, b);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("MENÚ DE OPERACIONES");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");
    }

    public static int pedirOpcion(Scanner sc) {
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public static double pedirNumero(Scanner sc, String nombre) {
        System.out.print("Ingrese el valor de " + nombre + ": ");
        return sc.nextDouble();
    }

    public static void ejecutarOperacion(int opcion, double numero1, double numero2) {

        switch (opcion) {
            case 1:
                imprimirResultado("Suma", numero1, numero2, numero1 + numero2);
                break;

            case 2:
                imprimirResultado("Resta", numero1, numero2, numero1 - numero2);
                break;

            case 3:
                imprimirResultado("Multiplicación", numero1, numero2, numero1 * numero2);
                break;

            case 4:
                System.out.println("Operación: División");
                System.out.println("Valores: numero1 = " + numero1 + ", numero2 = " + numero2);

                if (numero2 == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    System.out.println("Resultado: " + (numero1 / numero2));
                }
                break;

            default:
                System.out.println("Opción inválida");
                break;
        }
    }

    public static void imprimirResultado(String operacion, double a, double b, double resultado) {
        System.out.println("Operación: " + operacion);
        System.out.println("Valores: a = " + a + ", b = " + b);
        System.out.println("Resultado: " + resultado);
    }
}
