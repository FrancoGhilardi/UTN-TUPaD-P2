package tp3;

import tp3.domain.Estudiante;
import tp3.domain.Gallina;
import tp3.domain.Libro;
import tp3.domain.Mascota;
import tp3.domain.NaveEspacial;

public class Main {

    public static void main(String[] args) {
        // Registro de Estudiantes
        Estudiante e = new Estudiante("Ana", "Gómez", "Programación II", 6.5);
        System.out.println("[1] " + e.mostrarInfo());
        e.subirCalificacion(2.0);
        e.bajarCalificacion(1.0);
        System.out.println("[1] Post-actualización: " + e.mostrarInfo());

        // Registro de Mascotas
        Mascota m = new Mascota("Luna", "Perro", 3);
        System.out.println("[2] " + m.mostrarInfo());
        m.cumplirAnios();
        m.cumplirAnios();
        System.out.println("[2] Tras cumplir años: " + m.mostrarInfo());

        // Encapsulamiento con Libro
        Libro libro = new Libro("El arte de programar", "D. Knuth", 1968);
        System.out.println("[3] " + libro.mostrarInfo());
        try {
            libro.setAnioPublicacion(3000);
        } catch (IllegalArgumentException ex) {
            System.out.println("[3] Intento inválido de año: " + ex.getMessage());
        }
        libro.setAnioPublicacion(1998);
        System.out.println("[3] Final: " + libro.mostrarInfo());

        // Gestión de Gallinas
        Gallina g1 = new Gallina(1L, 1);
        Gallina g2 = new Gallina(2L, 2);
        g1.envejecer();
        g1.ponerHuevo();
        g1.ponerHuevo();
        g2.ponerHuevo();
        System.out.println("[4] " + g1.mostrarEstado());
        System.out.println("[4] " + g2.mostrarEstado());

        // Simulación de Nave Espacial
        NaveEspacial nave = new NaveEspacial("Explorer", 50, 100);
        System.out.println("[5] Estado inicial: " + nave.mostrarEstado());

        boolean avanzo = nave.avanzar(60);
        System.out.println("[5] Intento avanzar 60: " + (avanzo ? "OK" : "FALLÓ (combustible insuficiente)"));

        int cargado = nave.recargarCombustible(30);
        System.out.println("[5] Recarga: " + cargado + " unidades. " + nave.mostrarEstado());

        boolean despego = nave.despegar();
        System.out.println("[5] Despegue: " + (despego ? "OK" : "FALLÓ") + ". " + nave.mostrarEstado());

        boolean avanzo2 = nave.avanzar(60);
        System.out.println("[5] Avanzar 60 post-recarga: " + (avanzo2 ? "OK" : "FALLÓ") + ". " + nave.mostrarEstado());

    }

}
