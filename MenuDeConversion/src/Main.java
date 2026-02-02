import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ejecutarPrograma();
    }

    static void ejecutarPrograma() {

        int opcion;
        int cAF = 0, fAC = 0, kmAM = 0, mAK = 0;

        do {
            mostrarMenu();
            opcion = leerOpcion();

            switch (opcion) {
                case 1 -> {
                    convertirCelsiusAFahrenheit();
                    cAF++;
                }
                case 2 -> {
                    convertirFahrenheitACelsius();
                    fAC++;
                }
                case 3 -> {
                    convertirKmAMillas();
                    kmAM++;
                }
                case 4 -> {
                    convertirMillasAKm();
                    mAK++;
                }
                case 5 -> System.out.println("Saliendo del programa...");
            }

            System.out.println();

        } while (opcion != 5);

        mostrarResumen(cAF, fAC, kmAM, mAK);
    }

    static void mostrarMenu() {
        System.out.println("----- MENÚ -----");
        System.out.println("1) °C a °F");
        System.out.println("2) °F a °C");
        System.out.println("3) Km a Millas");
        System.out.println("4) Millas a Km");
        System.out.println("5) Salir");
    }

    static int leerOpcion() {
        while (true) {
            System.out.print("Elige una opción (1-5): ");
            if (sc.hasNextInt()) {
                int opcion = sc.nextInt();
                if (opcion >= 1 && opcion <= 5) {
                    return opcion;
                }
                System.out.println("Opción inválida.");
            } else {
                System.out.println("Debes ingresar un número.");
                sc.next();
            }
        }
    }

    static double leerNumero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (sc.hasNextDouble()) {
                return sc.nextDouble();
            }
            System.out.println("Entrada inválida. Ingresa un número.");
            sc.next();
        }
    }

    static void convertirCelsiusAFahrenheit() {
        double c = leerNumero("Ingresa grados Celsius: ");
        double f = (c * 9 / 5) + 32;
        System.out.println("Resultado: " + f + " °F");
    }

    static void convertirFahrenheitACelsius() {
        double f = leerNumero("Ingresa grados Fahrenheit: ");
        double c = (f - 32) * 5 / 9;
        System.out.println("Resultado: " + c + " °C");
    }

    static void convertirKmAMillas() {
        double km = leerNumero("Ingresa kilómetros: ");
        double millas = km * 0.621371;
        System.out.println("Resultado: " + millas + " millas");
    }

    static void convertirMillasAKm() {
        double millas = leerNumero("Ingresa millas: ");
        double km = millas / 0.621371;
        System.out.println("Resultado: " + km + " km");
    }

    static void mostrarResumen(int cAF, int fAC, int kmAM, int mAK) {
        int total = cAF + fAC + kmAM + mAK;

        System.out.println("----- RESUMEN -----");
        System.out.println("Total de conversiones: " + total);
        System.out.println("°C a °F: " + cAF);
        System.out.println("°F a °C: " + fAC);
        System.out.println("Km a Millas: " + kmAM);
        System.out.println("Millas a Km: " + mAK);
    }
}
