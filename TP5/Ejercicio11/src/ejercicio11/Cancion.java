package ejercicio11;

import java.util.Objects;

public class Cancion {

    private final String titulo;
    private final int duracionSeg;
    private final Artista artista;

    public Cancion(String titulo, int duracionSeg, Artista artista) {
        this.titulo = Objects.requireNonNull(titulo, "titulo").strip();
        if (this.titulo.isEmpty()) {
            throw new IllegalArgumentException("titulo vacío");
        }
        if (duracionSeg <= 0) {
            throw new IllegalArgumentException("duracionSeg debe ser > 0");
        }
        this.duracionSeg = duracionSeg;
        this.artista = Objects.requireNonNull(artista, "artista");
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracionSeg() {
        return duracionSeg;
    }

    public Artista getArtista() {
        return artista;
    }

    @Override
    public String toString() {
        return "Cancion{\"" + titulo + "\" de " + artista.getNombre() + ", " + duracionSeg + "s}";
    }
}
