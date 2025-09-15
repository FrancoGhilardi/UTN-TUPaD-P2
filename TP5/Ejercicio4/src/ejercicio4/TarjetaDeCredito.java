package ejercicio4;

import java.time.YearMonth;
import java.util.Objects;

public class TarjetaDeCredito {

    private final String numero;
    private final YearMonth fechaVencimiento;
    private Banco banco;
    private Cliente cliente;

    public TarjetaDeCredito(String numero, YearMonth fechaVencimiento, Banco banco) {
        this.numero = validarNumero(numero);
        this.fechaVencimiento = Objects.requireNonNull(fechaVencimiento, "fechaVencimiento");
        if (fechaVencimiento.isBefore(YearMonth.now())) {
            throw new IllegalArgumentException("La tarjeta está vencida");
        }
        this.banco = Objects.requireNonNull(banco, "banco");
    }

    private static String validarNumero(String n) {
        Objects.requireNonNull(n, "numero");
        String digits = n.replaceAll("\\s+", "");
        if (!digits.matches("\\d{13,19}")) {
            throw new IllegalArgumentException("Número de tarjeta inválido (13–19 dígitos)");
        }
        return digits;
    }

    public void setCliente(Cliente nuevo) {
        if (this.cliente == nuevo) {
            return;
        }
        if (this.cliente != null) {
            Cliente anterior = this.cliente;
            this.cliente = null;
            if (anterior.getTarjeta() == this) {
                anterior.removeTarjeta();
            }
        }
        this.cliente = nuevo;
        if (nuevo != null && nuevo.getTarjeta() != this) {
            nuevo.setTarjeta(this);
        }
    }

    public void removeCliente() {
        setCliente(null);
    }

    public void setBanco(Banco nuevoBanco) {
        this.banco = Objects.requireNonNull(nuevoBanco, "banco");
    }

    public String getNumero() {
        return numero;
    }

    public YearMonth getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Banco getBanco() {
        return banco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + numero + ", vence=" + fechaVencimiento
                + ", banco=" + banco.getNombre()
                + ", cliente=" + (cliente != null ? cliente.getDni() : "-") + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof TarjetaDeCredito)) {
            return false;
        }
        return numero.equals(((TarjetaDeCredito) o).numero);
    }

    @Override
    public int hashCode() {
        return numero.hashCode();
    }
}
