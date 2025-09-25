package ejercicio2;

import java.util.*;
import java.util.stream.Collectors;

public class Biblioteca {

    private final String nombre;
    private final List<Libro> libros = new ArrayList<>();

    public Biblioteca(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("nombre inválido");
        }
        this.nombre = nombre.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarLibro(String isbn, String titulo, int anioPublicacion, Autor autor) {

        buscarLibroPorIsbn(isbn).ifPresent(l -> {
            throw new IllegalArgumentException("Ya existe un libro con ISBN=" + isbn);
        });
        libros.add(new Libro(isbn, titulo, anioPublicacion, autor));
    }

    public void listarLibros() {
        if (libros.isEmpty()) {
            System.out.println("Biblioteca vacía");
            return;
        }
        libros.forEach(Libro::mostrarInfo);
    }

    public Optional<Libro> buscarLibroPorIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            return Optional.empty();
        }
        String key = isbn.trim();
        return libros.stream().filter(l -> l.getIsbn().equalsIgnoreCase(key)).findFirst();
    }

    public boolean eliminarLibro(String isbn) {
        return buscarLibroPorIsbn(isbn).map(libros::remove).orElse(false);
    }

    public int obtenerCantidadLibros() {
        return libros.size();
    }

    public List<Libro> filtrarLibrosPorAnio(int anio) {
        return libros.stream()
                .filter(l -> l.getAnioPublicacion() == anio)
                .collect(Collectors.toUnmodifiableList());
    }

    public void mostrarAutoresDisponibles() {

        libros.stream()
                .map(Libro::getAutor)
                .distinct()
                .forEach(Autor::mostrarInfo);
    }

    public List<Libro> getLibros() {
        return Collections.unmodifiableList(libros);
    }
}
