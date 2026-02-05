public class OutputHandler {
    public void imprimirTicket(int tipoServicio, double peso, int distancia, boolean zonaRemota,
            double subtotal, double iva, double total) {

        String servicio = (tipoServicio == 1) ? "Estándar" : "Exprés";

        System.out.println("\n----- TICKET DE ENVÍO -----");
        System.out.println("Tipo de Servicio: " + servicio);
        System.out.println("Peso:             " + peso + " kg");
        System.out.println("Distancia:        " + distancia + " km");
        System.out.println("Zona Remota:      " + (zonaRemota ? "Sí" : "No"));
        System.out.println("---------------------------");

        System.out.printf("Subtotal:        $%10.2f%n", subtotal);
        System.out.printf("IVA (16%%):       $%10.2f%n", iva);
        System.out.printf("TOTAL A PAGAR:   $%10.2f%n", total);
        System.out.println("---------------------------");
    }
}