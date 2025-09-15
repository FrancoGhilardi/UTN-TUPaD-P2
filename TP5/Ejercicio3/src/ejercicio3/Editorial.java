package ejercicio3;

import java.util.Objects;

public class Editorial {

    private final String nombre;
    private final String direccion;

    public Editorial(String nombre, String direccion) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.direccion = Objects.requireNonNull(direccion, "direccion").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (this.direccion.isEmpty()) {
            throw new IllegalArgumentException("dirección vacía");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    @Override
    public String toString() {
        return "Editorial{" + nombre + " - " + direccion + "}";
    }
}
