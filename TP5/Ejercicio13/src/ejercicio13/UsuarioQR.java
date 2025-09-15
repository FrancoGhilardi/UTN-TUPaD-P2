package ejercicio13;

import java.util.Objects;

public class UsuarioQR {

    private final String nombre;
    private final String dni;

    public UsuarioQR(String nombre, String dni) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.dni = Objects.requireNonNull(dni, "dni").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (!this.dni.matches("\\d{7,9}")) {
            throw new IllegalArgumentException("DNI inválido (7–9 dígitos)");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return "UsuarioQR{" + nombre + ", dni=" + dni + "}";
    }
}
