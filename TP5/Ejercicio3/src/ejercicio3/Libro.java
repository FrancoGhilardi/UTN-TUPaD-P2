package ejercicio3;

import java.util.Objects;

/**
 * Agregado principal: asocia unidireccionalmente a Autor y agrega Editorial.
 */
public class Libro {

    private final String titulo;
    private final String isbn;
    private Autor autor;
    private Editorial editorial;

    public Libro(String titulo, String isbn, Autor autor, Editorial editorial) {
        this.titulo = Objects.requireNonNull(titulo, "titulo").strip();
        this.isbn = validarIsbn(Objects.requireNonNull(isbn, "isbn").strip());
        this.autor = Objects.requireNonNull(autor, "autor");
        this.editorial = Objects.requireNonNull(editorial, "editorial");
        if (this.titulo.isEmpty()) {
            throw new IllegalArgumentException("titulo vacío");
        }
    }

    private static String validarIsbn(String v) {
        if (!v.matches("[0-9-]{10,17}")) {
            throw new IllegalArgumentException("ISBN inválido");
        }
        return v;
    }

    public void setAutor(Autor autor) {
        this.autor = Objects.requireNonNull(autor, "autor");
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = Objects.requireNonNull(editorial, "editorial");
    }

    public String getTitulo() {
        return titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    @Override
    public String toString() {
        return "Libro{\"" + titulo + "\" | ISBN=" + isbn
                + " | Autor=" + autor + " | Editorial=" + editorial + "}";
    }
}
