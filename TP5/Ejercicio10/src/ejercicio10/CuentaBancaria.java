package ejercicio10;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class CuentaBancaria {

    private final String cbu;
    private BigDecimal saldo;
    private ClaveSeguridad clave;
    private Titular titular;

    public CuentaBancaria(String cbu, ClaveSeguridad clave) {
        this.cbu = validarCbu(cbu);
        this.clave = Objects.requireNonNull(clave, "clave");
        this.saldo = BigDecimal.ZERO;
    }

    private static String validarCbu(String v) {
        Objects.requireNonNull(v, "cbu");
        String d = v.replaceAll("\\s+", "");
        if (!d.matches("\\d{22}")) {
            throw new IllegalArgumentException("CBU inválido (22 dígitos)");
        }
        return d;
    }

    public void cambiarClave(ClaveSeguridad nueva) {
        this.clave = Objects.requireNonNull(nueva, "clave");
    }

    /**
     * Operaciones básicas con validaciones.
     */
    public void depositar(BigDecimal monto) {
        Objects.requireNonNull(monto, "monto");
        if (monto.signum() <= 0) {
            throw new IllegalArgumentException("monto debe ser positivo");
        }
        this.saldo = this.saldo.add(monto);
    }

    public void extraer(BigDecimal monto) {
        Objects.requireNonNull(monto, "monto");
        if (monto.signum() <= 0) {
            throw new IllegalArgumentException("monto debe ser positivo");
        }
        if (this.saldo.compareTo(monto) < 0) {
            throw new IllegalStateException("saldo insuficiente");
        }
        this.saldo = this.saldo.subtract(monto);
    }

    public void setTitular(Titular nuevo) {
        if (this.titular == nuevo) {
            return;
        }

        if (this.titular != null) {
            Titular anterior = this.titular;
            this.titular = null;
            if (anterior.getCuenta() == this) {
                anterior.removeCuenta();
            }
        }

        this.titular = nuevo;
        if (nuevo != null && nuevo.getCuenta() != this) {
            nuevo.setCuenta(this);
        }
    }

    public void removeTitular() {
        setTitular(null);
    }

    public String getCbu() {
        return cbu;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public ClaveSeguridad getClave() {
        return clave;
    }

    public Titular getTitular() {
        return titular;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{CBU=" + cbu
                + ", saldo=" + saldo
                + ", titular=" + (titular != null ? titular.getDni() : "-")
                + ", claveModif=" + (clave != null ? clave.getUltimaModificacion() : "-") + "}";
    }

    public void cambiarClaveConCodigo(String nuevoCodigo) {
        this.cambiarClave(new ClaveSeguridad(nuevoCodigo, LocalDateTime.now()));
    }
}
