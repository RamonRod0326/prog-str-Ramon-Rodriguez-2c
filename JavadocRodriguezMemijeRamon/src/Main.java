import java.util.Scanner;

/**
 * Clase principal que muestra un menú en consola
 * para realizar distintas operaciones matemáticas.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("===== MENÚ =====");
            System.out.println("1. Calcular IMC");
            System.out.println("2. Calcular área de un rectángulo");
            System.out.println("3. Convertir °C a °F");
            System.out.println("4. Calcular área de un círculo");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa tu peso (kg): ");
                    double peso = scanner.nextDouble();
                    System.out.print("Ingresa tu estatura (m): ");
                    double estatura = scanner.nextDouble();
                    double imc = calcularIMC(peso, estatura);
                    System.out.println("Tu IMC es: " + imc);
                    break;

                case 2:
                    System.out.print("Ingresa la base: ");
                    double base = scanner.nextDouble();
                    System.out.print("Ingresa la altura: ");
                    double altura = scanner.nextDouble();
                    System.out.println("Área del rectángulo: " + areaRectangulo(base, altura));
                    break;

                case 3:
                    System.out.print("Ingresa los grados Celsius: ");
                    double celsius = scanner.nextDouble();
                    System.out.println("Grados Fahrenheit: " + celsiusAFahrenheit(celsius));
                    break;

                case 4:
                    System.out.print("Ingresa el radio del círculo: ");
                    double radio = scanner.nextDouble();
                    System.out.println("Área del círculo: " + areaCirculo(radio));
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }

            System.out.println();

        } while (opcion != 5);

        scanner.close();
    }

    /**
     * Calcula el Índice de Masa Corporal (IMC).
     *
     * @param peso peso de la persona en kilogramos
     * @param estatura estatura de la persona en metros
     * @return valor del IMC calculado
     */
    public static double calcularIMC(double peso, double estatura) {
        return peso / (estatura * estatura);
    }

    /**
     * Calcula el área de un rectángulo.
     *
     * @param base medida de la base del rectángulo
     * @param altura medida de la altura del rectángulo
     * @return área del rectángulo
     */
    public static double areaRectangulo(double base, double altura) {
        return base * altura;
    }

    /**
     * Convierte grados Celsius a grados Fahrenheit.
     *
     * @param celsius temperatura en grados Celsius
     * @return temperatura convertida a grados Fahrenheit
     */
    public static double celsiusAFahrenheit(double celsius) {
        return (celsius * 1.8) + 32;
    }

    /**
     * Calcula el área de un círculo.
     *
     * @param radio radio del círculo
     * @return área del círculo
     */
    public static double areaCirculo(double radio) {
        return Math.PI * radio * radio;
    }
}
