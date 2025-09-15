package ejercicio4;

import java.util.Objects;

public class Cliente {

    private final String nombre;
    private final String dni;
    private TarjetaDeCredito tarjeta;

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

    public void setTarjeta(TarjetaDeCredito nueva) {
        if (this.tarjeta == nueva) {
            return;
        }
        if (this.tarjeta != null) {
            TarjetaDeCredito anterior = this.tarjeta;
            this.tarjeta = null;
            if (anterior.getCliente() == this) {
                anterior.removeCliente();
            }
        }
        this.tarjeta = nueva;
        if (nueva != null && nueva.getCliente() != this) {
            nueva.setCliente(this);
        }
    }

    public void removeTarjeta() {
        setTarjeta(null);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public TarjetaDeCredito getTarjeta() {
        return tarjeta;
    }

    @Override
    public String toString() {
        return "Cliente{" + nombre + ", dni=" + dni
                + ", tarjeta=" + (tarjeta != null ? tarjeta.getNumero() : "-") + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cliente)) {
            return false;
        }
        return dni.equals(((Cliente) o).dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }
}
