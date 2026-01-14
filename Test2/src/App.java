import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Total");
        double x = scanner.nextDouble();

        double t = x + (x * 0.16); 

        if (x > 1000) {
            t = t - (t * 0.10); 
        }

        System.out.println("Total a pagar: " + t);
        scanner.close();
    }
}
