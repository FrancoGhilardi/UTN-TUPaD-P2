package ejercicio12;

import java.math.BigDecimal;
import java.util.Objects;

public class Impuesto {

    private final BigDecimal monto;
    private final Contribuyente contribuyente;

    public Impuesto(BigDecimal monto, Contribuyente contribuyente) {
        Objects.requireNonNull(monto, "monto");
        if (monto.signum() < 0) {
            throw new IllegalArgumentException("monto no puede ser negativo");
        }
        this.monto = monto;
        this.contribuyente = Objects.requireNonNull(contribuyente, "contribuyente");
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public Contribuyente getContribuyente() {
        return contribuyente;
    }

    @Override
    public String toString() {
        return "Impuesto{monto=" + monto + ", de=" + contribuyente.getNombre() + "}";
    }
}
