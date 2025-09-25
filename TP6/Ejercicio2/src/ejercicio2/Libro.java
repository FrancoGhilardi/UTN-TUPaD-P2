package ejercicio2;

import java.util.Objects;

public class Libro {

    private final String isbn;
    private String titulo;
    private int anioPublicacion;
    private Autor autor;

    public Libro(String isbn, String titulo, int anioPublicacion, Autor autor) {
        this.isbn = validarIsbn(isbn);
        setTitulo(titulo);
        setAnioPublicacion(anioPublicacion);
        setAutor(autor);
    }

    private String validarIsbn(String v) {
        if (v == null || v.isBlank()) {
            throw new IllegalArgumentException("ISBN inválido");
        }
        return v.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("título inválido");
        }
        this.titulo = titulo.trim();
    }

    public void setAnioPublicacion(int anioPublicacion) {
        if (anioPublicacion < 1440) {
            throw new IllegalArgumentException("año de publicación inválido");
        }
        this.anioPublicacion = anioPublicacion;
    }

    public void setAutor(Autor autor) {
        if (autor == null) {
            throw new IllegalArgumentException("autor obligatorio");
        }
        this.autor = autor;
    }

    public void mostrarInfo() {
        System.out.printf(
                "Libro{isbn='%s', titulo='%s', anio=%d, autor='%s'}%n",
                isbn, titulo, anioPublicacion, autor.getNombre()
        );
    }

    @Override
    public String toString() {
        return "Libro{isbn='" + isbn + "', titulo='" + titulo + "', anio=" + anioPublicacion + ", autor=" + autor + "}";
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Libro l) && isbn.equals(l.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}
