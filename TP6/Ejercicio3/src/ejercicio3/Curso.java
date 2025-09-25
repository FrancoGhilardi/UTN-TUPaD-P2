package ejercicio3;

import java.util.Objects;

public class Curso {

    private final String codigo;
    private String nombre;
    private Profesor profesor;

    public Curso(String codigo, String nombre) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("código inválido");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("nombre inválido");
        }
        this.codigo = codigo.trim();
        this.nombre = nombre.trim();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String n) {
        if (n == null || n.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.nombre = n.trim();
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor nuevo) {
        if (this.profesor == nuevo) {
            return;
        }

        Profesor anterior = this.profesor;
        if (anterior != null) {
            anterior.detachCursoSilently(this);
        }

        this.profesor = nuevo;

        if (nuevo != null) {
            nuevo.attachCursoSilently(this);
        }
    }

    public void mostrarInfo() {
        System.out.printf("Curso{codigo='%s', nombre='%s', profesor='%s'}%n",
                codigo, nombre, (profesor != null ? profesor.getNombre() : "—"));
    }

    @Override
    public String toString() {
        return "Curso{codigo='%s', nombre='%s'}".formatted(codigo, nombre);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Curso c) && codigo.equals(c.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}
