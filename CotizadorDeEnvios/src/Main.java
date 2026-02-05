public class Main {
    public static void main(String[] args) {

        InputHandler inputHandler = new InputHandler();
        ShippingCalculator shippingCalculator = new ShippingCalculator();
        OutputHandler outputHandler = new OutputHandler();

        double peso = inputHandler.leerPesos();
        int distancia = (int) inputHandler.leerDistancia();
        int tipoServicio = inputHandler.LeerTipoServicio();
        boolean zonaRemota = inputHandler.LeerZonaRemota();

        double subtotal = shippingCalculator.calcularSubtotal(tipoServicio, peso, distancia, zonaRemota);
        double iva = shippingCalculator.calcularIVA(subtotal);
        double total = shippingCalculator.calcularTotal(subtotal, iva);

        outputHandler.imprimirTicket(tipoServicio, peso, distancia, zonaRemota, subtotal, iva, total);
    }
}