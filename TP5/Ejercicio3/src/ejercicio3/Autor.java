package ejercicio3;

import java.util.Objects;

public class Autor {

    private final String nombre;
    private final String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.nacionalidad = Objects.requireNonNull(nacionalidad, "nacionalidad").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (this.nacionalidad.isEmpty()) {
            throw new IllegalArgumentException("nacionalidad vacía");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    @Override
    public String toString() {
        return "Autor{" + nombre + " - " + nacionalidad + "}";
    }
}
