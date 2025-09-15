package ejercicio12;

import java.util.Objects;

public class Contribuyente {

    private final String nombre;
    private final String cuil;

    public Contribuyente(String nombre, String cuil) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.cuil = normalizarCuil(Objects.requireNonNull(cuil, "cuil"));
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (!this.cuil.matches("\\d{11}")) {
            throw new IllegalArgumentException("CUIL inválido (11 dígitos)");
        }
    }

    private static String normalizarCuil(String v) {
        return v.replaceAll("[^0-9]", "");
    }

    public String getNombre() {
        return nombre;
    }

    public String getCuil() {
        return cuil;
    }

    @Override
    public String toString() {
        return "Contribuyente{" + nombre + ", CUIL=" + cuil + "}";
    }
}
