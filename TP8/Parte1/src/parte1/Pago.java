package parte1;

/**
 * Medio de pago que procesa un importe final. Retorna true si el pago fue
 * aprobado.
 */
public interface Pago {

    boolean procesarPago(double importe);
}
