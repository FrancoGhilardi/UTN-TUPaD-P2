package ejercicio5;

import java.util.Objects;

public final class PlacaMadre {

    private final String modelo;
    private final String chipset;

    public PlacaMadre(String modelo, String chipset) {
        this.modelo = Objects.requireNonNull(modelo, "modelo").strip();
        this.chipset = Objects.requireNonNull(chipset, "chipset").strip();
        if (this.modelo.isEmpty()) {
            throw new IllegalArgumentException("modelo vacío");
        }
        if (this.chipset.isEmpty()) {
            throw new IllegalArgumentException("chipset vacío");
        }
    }

    public String getModelo() {
        return modelo;
    }

    public String getChipset() {
        return chipset;
    }

    @Override
    public String toString() {
        return "PlacaMadre{" + modelo + ", " + chipset + "}";
    }
}
