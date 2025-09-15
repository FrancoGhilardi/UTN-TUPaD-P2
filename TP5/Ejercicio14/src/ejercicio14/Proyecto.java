package ejercicio14;

import java.util.Objects;

public class Proyecto {

    private final String nombre;
    private final int duracionMin;

    public Proyecto(String nombre, int duracionMin) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (duracionMin <= 0) {
            throw new IllegalArgumentException("duracionMin debe ser > 0");
        }
        this.duracionMin = duracionMin;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionMin() {
        return duracionMin;
    }

    @Override
    public String toString() {
        return "Proyecto{" + nombre + ", " + duracionMin + " min}";
    }
}
