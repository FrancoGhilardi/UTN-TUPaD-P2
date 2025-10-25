package parte1;

/**
 * Capacidad de aplicar un descuento sobre un importe. La semántica del
 * descuento queda definida por la clase concreta.
 */
public interface PagoConDescuento {

    double aplicarDescuento(double importe);
}
