package parte1;

/**
 * PayPal como medio de pago simple, sin descuento.
 */
public class PayPal implements Pago {

    private final String emailCuenta;

    public PayPal(String emailCuenta) {
        if (emailCuenta == null || emailCuenta.isBlank()) {
            throw new IllegalArgumentException("Email de cuenta obligatorio.");
        }
        this.emailCuenta = emailCuenta;
    }

    @Override
    public boolean procesarPago(double importe) {
        if (importe < 0) {
            throw new IllegalArgumentException("Importe invalido.");
        }
        System.out.printf("Procesando pago con PayPal (%s) por $%.2f%n", emailCuenta, importe);
        return true;
    }
}
