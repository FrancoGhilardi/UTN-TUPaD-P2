package ejercicio11;

public class Ejercicio11 {

    public static void main(String[] args) {
        Artista a1 = new Artista("Gustavo Cerati", "Rock");
        Artista a2 = new Artista("Spinetta", "Rock");

        Cancion c1 = new Cancion("Crimen", 270, a1);
        Cancion c2 = new Cancion("Seguir viviendo sin tu amor", 260, a2);

        Reproductor rep = new Reproductor();
        rep.setVolumen(70);

        System.out.println(rep);

        rep.reproducirSinGuardar(c1);

        rep.reproducir(c2);
        rep.pausar();
        rep.reproducir(c1);
        rep.detener();

        System.out.println(rep);
    }

}
