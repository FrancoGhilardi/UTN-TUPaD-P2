package ejercicio6;

import java.util.Objects;

public class Cliente {

    private final String nombre;
    private final String dni;
    private Reserva reserva;

    public Cliente(String nombre, String dni) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.dni = Objects.requireNonNull(dni, "dni").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (!this.dni.matches("\\d{7,9}")) {
            throw new IllegalArgumentException("DNI inválido (7–9 dígitos)");
        }
    }

    public void setReserva(Reserva nueva) {
        if (this.reserva == nueva) {
            return;
        }

        if (this.reserva != null) {
            Reserva anterior = this.reserva;
            this.reserva = null;
            if (anterior.getCliente() == this) {
                anterior.removeCliente();
            }
        }

        this.reserva = nueva;
        if (nueva != null && nueva.getCliente() != this) {
            nueva.setCliente(this);
        }
    }

    public void removeReserva() {
        setReserva(null);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Reserva getReserva() {
        return reserva;
    }

    @Override
    public String toString() {
        return "ClienteR{" + nombre + ", dni=" + dni
                + ", reserva=" + (reserva != null ? reserva.getCodigo() : "-") + "}";
    }
}
