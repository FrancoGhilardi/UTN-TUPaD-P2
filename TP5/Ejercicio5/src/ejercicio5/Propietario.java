package ejercicio5;

import java.util.Objects;

public class Propietario {

    private final String nombre;
    private final String dni;
    private Computadora computadora;

    public Propietario(String nombre, String dni) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.dni = Objects.requireNonNull(dni, "dni").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (!this.dni.matches("\\d{7,9}")) {
            throw new IllegalArgumentException("DNI inválido (7–9 dígitos)");
        }
    }

    public void setComputadora(Computadora nueva) {
        if (this.computadora == nueva) {
            return;
        }

        if (this.computadora != null) {
            Computadora anterior = this.computadora;
            this.computadora = null;
            if (anterior.getPropietario() == this) {
                anterior.removePropietario();
            }
        }

        this.computadora = nueva;
        if (nueva != null && nueva.getPropietario() != this) {
            nueva.setPropietario(this);
        }
    }

    public void removeComputadora() {
        setComputadora(null);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Computadora getComputadora() {
        return computadora;
    }

    @Override
    public String toString() {
        return "Propietario{" + nombre + ", dni=" + dni
                + ", computadora=" + (computadora != null ? computadora.getNumeroSerie() : "-") + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Propietario)) {
            return false;
        }
        return dni.equals(((Propietario) o).dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }
}
