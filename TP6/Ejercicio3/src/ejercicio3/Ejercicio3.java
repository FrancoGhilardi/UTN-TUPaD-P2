
package ejercicio3;

import java.util.Map;


public class Ejercicio3 {

    public static void main(String[] args) {
        Profesor p1 = new Profesor("P-001", "Ada Lovelace", "Algoritmos");
        Profesor p2 = new Profesor("P-002", "Edsger Dijkstra", "Estructuras");
        Profesor p3 = new Profesor("P-003", "Barbara Liskov", "Arquitectura");

        Curso c1 = new Curso("CS101", "Introducción a la Prog.");
        Curso c2 = new Curso("CS102", "Estructuras de Datos");
        Curso c3 = new Curso("CS103", "Arquitectura de Comp.");
        Curso c4 = new Curso("CS104", "Sistemas Operativos");
        Curso c5 = new Curso("CS105", "Bases de Datos");

        
        Universidad u = new Universidad("UTN Universidad");
        u.agregarProfesor(p1); u.agregarProfesor(p2); u.agregarProfesor(p3);
        u.agregarCurso(c1); u.agregarCurso(c2); u.agregarCurso(c3); u.agregarCurso(c4); u.agregarCurso(c5);

       
        u.asignarProfesorACurso("CS101", "P-001");
        u.asignarProfesorACurso("CS102", "P-002");
        u.asignarProfesorACurso("CS103", "P-003");
        u.asignarProfesorACurso("CS104", "P-003");
        u.asignarProfesorACurso("CS105", "P-002");

        
        System.out.println("\nCursos:");
        u.listarCursos();
        System.out.println("\nProfesores:");
        u.listarProfesores();

        
        System.out.println("\nReasignar CS105 a P-003:");
        u.asignarProfesorACurso("CS105", "P-003");
        u.listarCursos();
        System.out.println("\nCursos de P-002:"); p2.listarCursos();
        System.out.println("Cursos de P-003:"); p3.listarCursos();

        
        System.out.println("\nEliminar curso CS104:");
        u.eliminarCurso("CS104");
        System.out.println("Cursos de P-003:"); p3.listarCursos();

        
        System.out.println("\nEliminar profesor P-003:");
        u.eliminarProfesor("P-003");
        System.out.println("Cursos (deben tener profesor='—' donde aplicaba):");
        u.listarCursos();

        
        System.out.println("\nReporte cantidad de cursos por profesor:");
        for (Map.Entry<Profesor, Long> e : u.cantidadCursosPorProfesor().entrySet()) {
            System.out.printf("- %s: %d cursos%n", e.getKey().getNombre(), e.getValue());
        }
    }
    
}
