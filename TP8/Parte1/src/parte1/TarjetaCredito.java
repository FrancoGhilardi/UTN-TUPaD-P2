package parte1;

/**
 * Tarjeta de crédito que aplica un porcentaje de descuento fijo Luego intenta
 * procesar el pago.
 */
public class TarjetaCredito implements Pago, PagoConDescuento {

    private final String banco;
    private final String numeroEnmascarado;
    private final double porcentajeDescuento; // 0..100

    public TarjetaCredito(String banco, String numeroEnmascarado, double porcentajeDescuento) {
        if (banco == null || banco.isBlank()) {
            throw new IllegalArgumentException("Banco obligatorio.");
        }
        if (numeroEnmascarado == null || numeroEnmascarado.isBlank()) {
            throw new IllegalArgumentException("Número enmascarado obligatorio.");
        }
        if (porcentajeDescuento < 0 || porcentajeDescuento > 100) {
            throw new IllegalArgumentException("Descuento debe estar entre 0 y 100.");
        }
        this.banco = banco;
        this.numeroEnmascarado = numeroEnmascarado;
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double aplicarDescuento(double importe) {
        if (importe < 0) {
            throw new IllegalArgumentException("Importe invalido.");
        }
        double factor = 1.0 - (porcentajeDescuento / 100.0);
        return importe * factor;
    }

    @Override
    public boolean procesarPago(double importe) {
        if (importe < 0) {
            throw new IllegalArgumentException("Importe inválido.");
        }
        System.out.printf("Procesando pago con Tarjeta %s (%s) por $%.2f%n", banco, numeroEnmascarado, importe);
        return true;
    }
}
