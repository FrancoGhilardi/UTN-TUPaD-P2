package ejercicio6;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Reserva {

    private final String codigo;
    private final LocalDateTime fechaHoraInicio;
    private final Duration duracion;
    private Mesa mesa;
    private Cliente cliente;

    public Reserva(String codigo, LocalDateTime inicio, Duration duracion, Mesa mesa) {
        this.codigo = Objects.requireNonNull(codigo, "codigo").strip();
        if (this.codigo.isEmpty()) {
            throw new IllegalArgumentException("codigo vacío");
        }

        this.fechaHoraInicio = Objects.requireNonNull(inicio, "fechaHoraInicio");
        this.duracion = Objects.requireNonNull(duracion, "duracion");
        if (this.duracion.isNegative() || this.duracion.isZero()) {
            throw new IllegalArgumentException("duración debe ser positiva");
        }

        this.mesa = Objects.requireNonNull(mesa, "mesa");
    }

    public void setMesa(Mesa nuevaMesa) {
        this.mesa = Objects.requireNonNull(nuevaMesa, "mesa");
    }

    public void setCliente(Cliente nuevo) {
        if (this.cliente == nuevo) {
            return;
        }

        if (this.cliente != null) {
            Cliente anterior = this.cliente;
            this.cliente = null;
            if (anterior.getReserva() == this) {
                anterior.removeReserva();
            }
        }

        this.cliente = nuevo;
        if (nuevo != null && nuevo.getReserva() != this) {
            nuevo.setReserva(this);
        }
    }

    public void removeCliente() {
        setCliente(null);
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public Duration getDuracion() {
        return duracion;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    @Override
    public String toString() {
        return "Reserva{" + codigo
                + ", inicio=" + fechaHoraInicio
                + ", dur=" + duracion.toMinutes() + "m"
                + ", mesa=" + mesa
                + ", cliente=" + (cliente != null ? cliente.getDni() : "-")
                + "}";
    }
}
