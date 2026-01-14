import java.util.Scanner;

public class App {

    public static double IVA = 0.16;
    public static double UMBRAL_DESCUENTO = 1000;
    public static double DESCUENTO = 0.10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double subtotal = obtenerDouble(scanner, "Dame el subtotal de la compra:");
        double total = calcularTotal(subtotal);

        System.out.println("Total a pagar: " + total);

        scanner.close();
    }

    public static double obtenerDouble(Scanner scanner, String mensaje) {
        System.out.println(mensaje);
        return scanner.nextDouble();
    }

    public static double calcularTotal(double subtotal) {
        double total = subtotal + (subtotal * IVA);
        return calcularDescuento(total);
    }

    public static double calcularDescuento(double totalIVA) {
        if (totalIVA >= UMBRAL_DESCUENTO) {
            totalIVA = totalIVA - (totalIVA * DESCUENTO);
        }
        return totalIVA;
    }
}
