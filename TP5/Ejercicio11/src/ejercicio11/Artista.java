package ejercicio11;

import java.util.Objects;

public class Artista {

    private final String nombre;
    private final String genero;

    public Artista(String nombre, String genero) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.genero = Objects.requireNonNull(genero, "genero").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (this.genero.isEmpty()) {
            throw new IllegalArgumentException("genero vacío");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Artista{" + nombre + ", " + genero + "}";
    }
}
