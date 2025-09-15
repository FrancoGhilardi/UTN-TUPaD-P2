package ejercicio3;

public class Ejercicio3 {

    public static void main(String[] args) {
        Autor a = new Autor("Julio Cortázar", "Argentina");
        Editorial e = new Editorial("Sudamericana", "Av. Libertad 123, CABA");
        Libro l = new Libro("Rayuela", "978-987-1138-07-2", a, e);

        System.out.println("Estado inicial:");
        System.out.println(l);

        l.setEditorial(new Editorial("Alfaguara", "Calle Falsa 123, CABA"));

        l.setAutor(new Autor("Jorge L. Borges", "Argentina"));

        System.out.println("\nLuego de cambios:");
        System.out.println("Autor actual: " + l.getAutor().getNombre());
        System.out.println("Editorial actual: " + l.getEditorial().getNombre());
        System.out.println(l);
    }

}
