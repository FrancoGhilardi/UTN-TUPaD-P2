package ejercicio5;

import java.util.Objects;

public class Computadora {

    private final String marca;
    private final String numeroSerie;
    private PlacaMadre placaMadre;
    private Propietario propietario;

    public Computadora(String marca, String numeroSerie, PlacaMadre placaMadre) {
        this.marca = Objects.requireNonNull(marca, "marca").strip();
        this.numeroSerie = Objects.requireNonNull(numeroSerie, "numeroSerie").strip();
        if (this.marca.isEmpty()) {
            throw new IllegalArgumentException("marca vacía");
        }
        if (!this.numeroSerie.matches("[A-Za-z0-9-]{5,30}")) {
            throw new IllegalArgumentException("numeroSerie inválido (5–30 alfanumérico)");
        }
        this.placaMadre = Objects.requireNonNull(placaMadre, "placaMadre");
    }

    public void reemplazarPlacaMadre(PlacaMadre nueva) {
        this.placaMadre = Objects.requireNonNull(nueva, "placaMadre");
    }

    public void setPropietario(Propietario nuevo) {
        if (this.propietario == nuevo) {
            return;
        }

        if (this.propietario != null) {
            Propietario anterior = this.propietario;
            this.propietario = null;
            if (anterior.getComputadora() == this) {
                anterior.removeComputadora();
            }
        }

        this.propietario = nuevo;
        if (nuevo != null && nuevo.getComputadora() != this) {
            nuevo.setComputadora(this);
        }
    }

    public void removePropietario() {
        setPropietario(null);
    }

    public String getMarca() {
        return marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public PlacaMadre getPlacaMadre() {
        return placaMadre;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    @Override
    public String toString() {
        return "Computadora{" + marca + ", nSerie=" + numeroSerie
                + ", placa=" + placaMadre
                + ", propietario=" + (propietario != null ? propietario.getDni() : "-") + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Computadora)) {
            return false;
        }
        return numeroSerie.equals(((Computadora) o).numeroSerie);
    }

    @Override
    public int hashCode() {
        return numeroSerie.hashCode();
    }
}
