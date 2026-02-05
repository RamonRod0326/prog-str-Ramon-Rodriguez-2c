import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;
// solo texto 
    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public double leerPesos() {
        return leerDoubleEnRango("Peso (0.1 - 50.0 kg): ", 0.1, 50.0);
    }

    public int leerDistancia() {
        return leerIntEnRango("Distancia (1 - 2000 km): ", 1, 2000);
    }

    public int LeerTipoServicio() {
        return leerIntEnRango("Tipo de servicio (1- Estándar, 2- Exprés): ", 1, 2);
    }

    public boolean LeerZonaRemota() {
        return leerSiNo("¿Es una zona remota? (si/no): ");
    }

    private double leerDoubleEnRango(String mensaje, double min, double max) {
        double valor;
        do {
            System.out.print(mensaje);
            while (!scanner.hasNextDouble()) { // Lo que escribio el usuario NO es un double?
                System.out.println("Error: Ingrese un número válido (ejemplo: 10.5).");
                scanner.next();
            }
            valor = scanner.nextDouble();
        } while (valor < min || valor > max);
        return valor;
    }

    private int leerIntEnRango(String mensaje, int min, int max) {
        int valor;
        do {
            System.out.print(mensaje);
            while (!scanner.hasNextInt()) { // Lo que escribio el usuario NO es un int?
                System.out.println("Error: Ingrese un número entero.");
                scanner.next();
            }
            valor = scanner.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    private boolean leerSiNo(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.next().toLowerCase();
            if (entrada.equals("si") || entrada.equals("sí")) return true;
            if (entrada.equals("no")) return false; //String es un objeto por lo tanto no se puede comparar con ==
            System.out.println("Error: Por favor escriba 'si' o 'no'.");
        }
    }
}