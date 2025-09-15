package ejercicio4;

import java.util.Objects;

public class Banco {

    private final String nombre;
    private final String cuit; 

    public Banco(String nombre, String cuit) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.cuit = Objects.requireNonNull(cuit, "cuit").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (!this.cuit.matches("\\d{11}")) {
            throw new IllegalArgumentException("CUIT inválido (11 dígitos)");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuit() {
        return cuit;
    }

    @Override
    public String toString() {
        return "Banco{" + nombre + ", CUIT=" + cuit + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Banco)) {
            return false;
        }
        return cuit.equals(((Banco) o).getCuit());
    }

    @Override
    public int hashCode() {
        return cuit.hashCode();
    }
}
