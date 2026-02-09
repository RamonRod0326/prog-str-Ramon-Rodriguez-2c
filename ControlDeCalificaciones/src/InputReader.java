import java.util.Scanner;

public class InputReader {

    private final Scanner scanner = new Scanner(System.in);

    public String leerNombreAlumno() {
        String nombre;
        do {
            System.out.print("Ingresa el nombre del alumno: ");
            nombre = scanner.nextLine().trim();
        } while (nombre.isEmpty());
        return nombre;
    }

    public double leerCalificacionParcial(int numeroParcial) {
        return leerDoubleEnRango(
                "Ingresa la calificación del parcial " + numeroParcial + ": ",
                0, 100
        );
    }

    public int leerAsistencia() {
        return leerIntEnRango(
                "Ingresa el porcentaje de asistencia: ",
                0, 100
        );
    }

    public boolean leerEntregaProyecto() {
        while (true) {
            System.out.print("¿Entregó el proyecto? (true/false): ");
            if (scanner.hasNextBoolean()) {
                boolean entrego = scanner.nextBoolean();
                scanner.nextLine();
                return entrego;
            } else {
                scanner.next();
                System.out.println("Entrada inválida. Usa true o false.");
            }
        }
    }

    private double leerDoubleEnRango(String mensaje, double minimo, double maximo) {
        double valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                if (valor >= minimo && valor <= maximo) {
                    scanner.nextLine();
                    return valor;
                }
            } else {
                scanner.next();
            }
            System.out.println("Valor fuera de rango.");
        }
    }

    private int leerIntEnRango(String mensaje, int minimo, int maximo) {
        int valor;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                valor = scanner.nextInt();
                if (valor >= minimo && valor <= maximo) {
                    scanner.nextLine();
                    return valor;
                }
            } else {
                scanner.next();
            }
            System.out.println("Valor fuera de rango.");
        }
    }
}
