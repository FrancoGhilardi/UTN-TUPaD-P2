package ejercicio10;

import java.util.Objects;

public class Titular {

    private final String nombre;
    private final String dni;
    private CuentaBancaria cuenta;

    public Titular(String nombre, String dni) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.dni = Objects.requireNonNull(dni, "dni").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (!this.dni.matches("\\d{7,9}")) {
            throw new IllegalArgumentException("DNI inválido (7–9 dígitos)");
        }
    }

    public void setCuenta(CuentaBancaria nueva) {
        if (this.cuenta == nueva) {
            return;
        }

        if (this.cuenta != null) {
            CuentaBancaria anterior = this.cuenta;
            this.cuenta = null;
            if (anterior.getTitular() == this) {
                anterior.removeTitular();
            }
        }

        this.cuenta = nueva;
        if (nueva != null && nueva.getTitular() != this) {
            nueva.setTitular(this);
        }
    }

    public void removeCuenta() {
        setCuenta(null);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public CuentaBancaria getCuenta() {
        return cuenta;
    }

    @Override
    public String toString() {
        return "TitularCta{" + nombre + ", dni=" + dni
                + ", cbu=" + (cuenta != null ? cuenta.getCbu() : "-") + "}";
    }
}
