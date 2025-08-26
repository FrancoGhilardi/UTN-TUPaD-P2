package tp3.domain;

import java.time.Year;

public class Libro {

    private String titulo;
    private String autor;
    private int anioPublicacion;

    public Libro(String titulo, String autor, int anioPublicacion) {
        this.titulo = validarNoVacio(titulo, "titulo");
        this.autor = validarNoVacio(autor, "autor");
        setAnioPublicacion(anioPublicacion);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anio) {
        int anioActual = Year.now().getValue();
        if (anio < 1450 || anio > anioActual) {
            throw new IllegalArgumentException("Año de publicación inválido: " + anio);
        }
        this.anioPublicacion = anio;
    }

    public String mostrarInfo() {
        return String.format("Libro: \"%s\" de %s (%d)", titulo, autor, anioPublicacion);
    }

    @Override
    public String toString() {
        return mostrarInfo();
    }

    private static String validarNoVacio(String v, String campo) {
        if (v == null || v.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " es obligatorio");
        }
        return v.trim();
    }
}
