package ejercicio9;

import java.util.Objects;

public class Profesional {

    private final String nombre;
    private final String especialidad;

    public Profesional(String nombre, String especialidad) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.especialidad = Objects.requireNonNull(especialidad, "especialidad").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (this.especialidad.isEmpty()) {
            throw new IllegalArgumentException("especialidad vacía");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "Profesional{" + nombre + ", " + especialidad + "}";
    }
}
