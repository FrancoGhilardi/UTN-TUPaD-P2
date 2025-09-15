package ejercicio2;

import java.util.Objects;

/**
 * Objeto-valor inmutable usado por agregación en Celular.
 */
public final class Bateria {

    private final String modelo;
    private final int capacidadmAh;

    public Bateria(String modelo, int capacidadmAh) {
        this.modelo = Objects.requireNonNull(modelo, "modelo no puede ser null").strip();
        if (this.modelo.isEmpty()) {
            throw new IllegalArgumentException("modelo vacío");
        }
        if (capacidadmAh <= 0) {
            throw new IllegalArgumentException("capacidad inválida");
        }
        this.capacidadmAh = capacidadmAh;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidadmAh() {
        return capacidadmAh;
    }

    @Override
    public String toString() {
        return "Bateria{" + modelo + ", " + capacidadmAh + "mAh}";
    }
}
