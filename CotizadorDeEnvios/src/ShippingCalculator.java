public class ShippingCalculator {
//constantes
    private static final double TARIFA_ESTANDAR = 50.0;
    private static final double TARIFA_EXPRES = 90.0;
    private static final double COSTO_POR_KG = 12.0;
    private static final double RECARGO_ZONA_REMOTA = 1.10;
    private static final double IVA_PORCENTAJE = 0.16;

    public double calcularSubtotal(int tipoServicio, double peso, int distancia, boolean zonaRemota) {
        double subtotal = 0;

        subtotal += (tipoServicio == 1) ? TARIFA_ESTANDAR : TARIFA_EXPRES;

        subtotal += peso * COSTO_POR_KG;

        if (distancia <= 50) {
            subtotal += 20;
        } else if (distancia <= 200) {
            subtotal += 60;
        } else {
            subtotal += 120;
        }

        if (zonaRemota) {
            subtotal *= RECARGO_ZONA_REMOTA;
        }

        return subtotal;
    }

    public double calcularIVA(double subtotal) {
        return subtotal * IVA_PORCENTAJE;
    }

    public double calcularTotal(double subtotal, double iva) {
        return subtotal + iva;
    }
}