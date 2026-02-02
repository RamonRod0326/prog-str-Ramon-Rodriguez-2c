import java.util.Scanner;

public class ActividadIfElseTarifa {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int edad = pedirEdad(sc);
        boolean esEstudiante = pedirEsEstudiante(sc);

        if (!edadValida(edad)) {
            System.out.println("Edad inválida");
            return;
        }

        int tarifa = calcularTarifa(edad, esEstudiante);
        imprimirResultado(edad, esEstudiante, tarifa);

        sc.close();
    }

    public static int pedirEdad(Scanner sc) {
        System.out.print("Ingrese la edad: ");
        return sc.nextInt();
    }

    public static boolean pedirEsEstudiante(Scanner sc) {
        System.out.print("¿Es estudiante? (true/false): ");
        return sc.nextBoolean();
    }

    public static boolean edadValida(int edad) {
        return edad >= 0 && edad <= 120;
    }

    public static int calcularTarifa(int edad, boolean esEstudiante) {

        if (edad < 12) {
            return 50;

        } else if (edad <= 17) {

            if (esEstudiante) {
                return 60;
            } else {
                return 80;
            }

        } else { 

            if (esEstudiante) {
                return 90;
            } else {
                return 120;
            }
        }
    }

    public static void imprimirResultado(int edad, boolean esEstudiante, int tarifa) {
        System.out.println("\n--- RESUMEN ---");
        System.out.println("Edad ingresada: " + edad);
        System.out.println("Es estudiante: " + esEstudiante);
        System.out.println("Tarifa final: $" + tarifa);
    }
}
