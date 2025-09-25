package ejercicio3;

import java.util.*;

public class Profesor {

    private final String id;
    private String nombre;
    private String especialidad;
    private final List<Curso> cursos = new ArrayList<>();

    public Profesor(String id, String nombre, String especialidad) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id inválido");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("nombre inválido");
        }
        if (especialidad == null || especialidad.isBlank()) {
            throw new IllegalArgumentException("especialidad inválida");
        }
        this.id = id.trim();
        this.nombre = nombre.trim();
        this.especialidad = especialidad.trim();
    }

    void attachCursoSilently(Curso c) {
        if (c != null && !cursos.contains(c)) {
            cursos.add(c);
        }
    }

    void detachCursoSilently(Curso c) {
        if (c != null) {
            cursos.remove(c);
        }
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setNombre(String n) {
        if (n == null || n.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.nombre = n.trim();
    }

    public void setEspecialidad(String e) {
        if (e == null || e.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.especialidad = e.trim();
    }

    public void agregarCurso(Curso c) {
        if (c == null) {
            throw new IllegalArgumentException("curso nulo");
        }
        if (!cursos.contains(c)) {
            cursos.add(c);
        }
        if (c.getProfesor() != this) {
            c.setProfesor(this); 
        }
    }

    public void eliminarCurso(Curso c) {
        if (c == null) {
            return;
        }
        if (cursos.remove(c) && c.getProfesor() == this) {
            c.setProfesor(null);
        }
    }

    public void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Sin cursos asignados.");
            return;
        }
        cursos.forEach(cur -> System.out.printf("- %s %s%n", cur.getCodigo(), cur.getNombre()));
    }

    public void mostrarInfo() {
        System.out.printf("Profesor{id='%s', nombre='%s', especialidad='%s', cursos=%d}%n",
                id, nombre, especialidad, cursos.size());
    }

    public List<Curso> getCursos() {
        return Collections.unmodifiableList(cursos);
    }

    @Override
    public String toString() {
        return "Profesor{id='%s', nombre='%s'}".formatted(id, nombre);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Profesor p) && id.equals(p.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
