package ejercicio2;

public class Ejercicio2 {

    public static void main(String[] args) {

        Biblioteca b = new Biblioteca("Biblioteca UTN");

        Autor a1 = new Autor("A-001", "Julio Cortázar", "Argentina");
        Autor a2 = new Autor("A-002", "Isabel Allende", "Chile");
        Autor a3 = new Autor("A-003", "Gabriel García Márquez", "Colombia");

        b.agregarLibro("ISBN-001", "Rayuela", 1963, a1);
        b.agregarLibro("ISBN-002", "Bestiario", 1951, a1);
        b.agregarLibro("ISBN-003", "La casa de los espíritus", 1982, a2);
        b.agregarLibro("ISBN-004", "El amor en los tiempos del cólera", 1985, a3);
        b.agregarLibro("ISBN-005", "Doce cuentos peregrinos", 1992, a3);

        System.out.println("\nListado:");
        b.listarLibros();

        System.out.println("\nBuscar ISBN-003:");
        b.buscarLibroPorIsbn("ISBN-003").ifPresentOrElse(
                Libro::mostrarInfo,
                () -> System.out.println("No encontrado")
        );

        System.out.println("\nLibros del año 1985:");
        b.filtrarLibrosPorAnio(1985).forEach(Libro::mostrarInfo);

        System.out.println("\nEliminar ISBN-002:");
        boolean eliminado = b.eliminarLibro("ISBN-002");
        System.out.println("¿Eliminado? " + eliminado);
        b.listarLibros();

        System.out.println("\nCantidad total de libros:");
        System.out.println(b.obtenerCantidadLibros());

        System.out.println("\nAutores disponibles:");
        b.mostrarAutoresDisponibles();
    }

}
