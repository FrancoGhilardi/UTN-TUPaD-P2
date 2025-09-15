package ejercicio6;

import java.util.Objects;

public class Mesa {

    private final String id;
    private final int capacidad;

    public Mesa(String id, int capacidad) {
        this.id = Objects.requireNonNull(id, "id").strip();
        if (this.id.isEmpty()) {
            throw new IllegalArgumentException("id vacío");
        }
        if (capacidad <= 0) {
            throw new IllegalArgumentException("capacidad inválida");
        }
        this.capacidad = capacidad;
    }

    public String getId() {
        return id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Mesa{" + id + ", cap=" + capacidad + "}";
    }
}
