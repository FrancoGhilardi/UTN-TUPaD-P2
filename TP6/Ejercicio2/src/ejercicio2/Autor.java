package ejercicio2;

import java.util.Objects;

public class Autor {

    private final String id;
    private String nombre;
    private String nacionalidad;

    public Autor(String id, String nombre, String nacionalidad) {
        this.id = validarId(id);
        setNombre(nombre);
        setNacionalidad(nacionalidad);
    }

    private String validarId(String v) {
        if (v == null || v.isBlank()) {
            throw new IllegalArgumentException("id inválido");
        }
        return v.trim();
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("nombre inválido");
        }
        this.nombre = nombre.trim();
    }

    public void setNacionalidad(String nacionalidad) {
        if (nacionalidad == null || nacionalidad.isBlank()) {
            throw new IllegalArgumentException("nacionalidad inválida");
        }
        this.nacionalidad = nacionalidad.trim();
    }

    public void mostrarInfo() {
        System.out.printf("Autor{id='%s', nombre='%s', nacionalidad='%s'}%n", id, nombre, nacionalidad);
    }

    @Override
    public String toString() {
        return "Autor{id='" + id + "', nombre='" + nombre + "', nacionalidad='" + nacionalidad + "'}";
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Autor a) && id.equals(a.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
