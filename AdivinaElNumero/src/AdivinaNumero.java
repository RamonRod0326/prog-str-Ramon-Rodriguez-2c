
import java.util.Random;
import java.util.Scanner;

public class AdivinaNumero {

    public static void main(String[] args) {
        jugar();
    }

    private static void jugar() {
        Scanner scanner = new Scanner(System.in);
        int numeroSecreto = generarNumeroSecreto();
        ejecutarJuego(scanner, numeroSecreto);
        scanner.close();
    }

    private static int generarNumeroSecreto() {
        Random random = new Random();
        return random.nextInt(100) + 1;
    }

    private static void ejecutarJuego(Scanner scanner, int numeroSecreto) {
        int intentos = 0;
        int intentosMaximos = 7;
        boolean gano = false;
        int fueraDeRango = 0;
        int noNumericos = 0;

        while (intentos < intentosMaximos && !gano) {

            pedirNumero(intentos);

            if (!scanner.hasNextInt()) {
                scanner.next();
                noNumericos++;
                continue;
            }

            int numeroUsuario = scanner.nextInt();

            if (numeroUsuario < 1 || numeroUsuario > 100) {
                fueraDeRango++;
                continue;
            }

            intentos++;

            if (numeroUsuario == numeroSecreto) {
                gano = true;
            } else if (numeroUsuario < numeroSecreto) {
                mostrarMayor();
            } else {
                mostrarMenor();
            }
        }

        mostrarResultadoFinal(gano, numeroSecreto, intentos, fueraDeRango, noNumericos);
    }

    private static void pedirNumero(int intentoActual) {
        System.out.print("Ingresa un número (intento " + (intentoActual + 1) + "): ");
    }

    private static void mostrarMayor() {
        System.out.println("El número secreto es mayor");
    }

    private static void mostrarMenor() {
        System.out.println("El número secreto es menor");
    }

    private static void mostrarResultadoFinal(boolean gano, int numeroSecreto, int intentos,
            int fueraDeRango, int noNumericos) {
        if (gano) {
            System.out.println("Ganaste");
        } else {
            System.out.println("Perdiste");
            System.out.println("El número secreto era: " + numeroSecreto);
        }

        System.out.println("Intentos usados: " + intentos);
        System.out.println("Fuera de rango: " + fueraDeRango);
        System.out.println("Entradas no numéricas: " + noNumericos);
    }
}
