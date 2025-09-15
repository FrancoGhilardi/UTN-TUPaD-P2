package ejercicio7;

import java.util.Objects;

public final class Motor {

    private final String tipo;
    private final String numeroSerie;

    public Motor(String tipo, String numeroSerie) {
        this.tipo = Objects.requireNonNull(tipo, "tipo").strip();
        this.numeroSerie = Objects.requireNonNull(numeroSerie, "numeroSerie").strip();
        if (this.tipo.isEmpty()) {
            throw new IllegalArgumentException("tipo vacío");
        }
        if (!this.numeroSerie.matches("[A-Za-z0-9-]{5,30}")) {
            throw new IllegalArgumentException("numeroSerie inválido (5–30 alfanumérico)");
        }
    }

    public String getTipo() {
        return tipo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    @Override
    public String toString() {
        return "Motor{" + tipo + ", nSerie=" + numeroSerie + "}";
    }
}
