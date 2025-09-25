package ejercicio3;

import java.util.*;
import java.util.stream.Collectors;

public class Universidad {

    private final String nombre;
    private final List<Profesor> profesores = new ArrayList<>();
    private final List<Curso> cursos = new ArrayList<>();

    public Universidad(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("nombre inválido");
        }
        this.nombre = nombre.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarProfesor(Profesor p) {
        if (p == null) {
            throw new IllegalArgumentException("profesor nulo");
        }
        if (buscarProfesorPorId(p.getId()).isPresent()) {
            throw new IllegalArgumentException("Profesor duplicado: " + p.getId());
        }
        profesores.add(p);
    }

    public void agregarCurso(Curso c) {
        if (c == null) {
            throw new IllegalArgumentException("curso nulo");
        }
        if (buscarCursoPorCodigo(c.getCodigo()).isPresent()) {
            throw new IllegalArgumentException("Curso duplicado: " + c.getCodigo());
        }
        cursos.add(c);
    }

    public Optional<Profesor> buscarProfesorPorId(String id) {
        if (id == null || id.isBlank()) {
            return Optional.empty();
        }
        String key = id.trim();
        return profesores.stream().filter(p -> p.getId().equalsIgnoreCase(key)).findFirst();
    }

    public Optional<Curso> buscarCursoPorCodigo(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            return Optional.empty();
        }
        String key = codigo.trim();
        return cursos.stream().filter(c -> c.getCodigo().equalsIgnoreCase(key)).findFirst();
    }

    public void asignarProfesorACurso(String codigoCurso, String idProfesor) {
        Curso c = buscarCursoPorCodigo(codigoCurso)
                .orElseThrow(() -> new NoSuchElementException("Curso no encontrado"));
        Profesor p = buscarProfesorPorId(idProfesor)
                .orElseThrow(() -> new NoSuchElementException("Profesor no encontrado"));
        c.setProfesor(p);
    }

    public void listarProfesores() {
        profesores.forEach(Profesor::mostrarInfo);
    }

    public void listarCursos() {
        cursos.forEach(Curso::mostrarInfo);
    }

    public boolean eliminarCurso(String codigo) {
        Optional<Curso> oc = buscarCursoPorCodigo(codigo);
        if (oc.isEmpty()) {
            return false;
        }
        Curso c = oc.get();
        Profesor prof = c.getProfesor();
        if (prof != null) {
            prof.eliminarCurso(c);
        }
        return cursos.remove(c);
    }

    public boolean eliminarProfesor(String id) {
        Optional<Profesor> op = buscarProfesorPorId(id);
        if (op.isEmpty()) {
            return false;
        }
        Profesor p = op.get();
        for (Curso c : new ArrayList<>(p.getCursos())) {
            p.eliminarCurso(c);
        }
        return profesores.remove(p);
    }

    public Map<Profesor, Long> cantidadCursosPorProfesor() {
        return profesores.stream()
                .collect(Collectors.toMap(
                        prof -> prof,
                        prof -> (long) prof.getCursos().size()
                ));
    }

    public List<Profesor> getProfesores() {
        return Collections.unmodifiableList(profesores);
    }

    public List<Curso> getCursos() {
        return Collections.unmodifiableList(cursos);
    }
}
