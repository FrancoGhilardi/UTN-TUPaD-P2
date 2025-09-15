package ejercicio11;

public class Reproductor {

    private int volumen = 50;
    private boolean reproduciendo;

    public void setVolumen(int v) {
        if (v < 0 || v > 100) {
            throw new IllegalArgumentException("volumen debe estar entre 0 y 100");
        }
        this.volumen = v;
    }

    public void reproducirSinGuardar(Cancion c) {
        System.out.println("▶ Reproducción efímera: " + c.getTitulo() + " - " + c.getArtista().getNombre());
    }

    public void reproducir(Cancion c) {
        this.reproduciendo = true;
        System.out.println("▶ Reproduciendo: " + c);
    }

    public void pausar() {
        if (reproduciendo) {
            reproduciendo = false;
            System.out.println("⏸ Pausa");
        } else {
            System.out.println("ℹ No hay reproducción activa");
        }
    }

    public void detener() {
        if (reproduciendo) {
            reproduciendo = false;
            System.out.println("⏹ Detenido");
        } else {
            System.out.println("ℹ Nada que detener");
        }
    }

    @Override
    public String toString() {
        return "Reproductor{volumen=" + volumen + ", reproduciendo=" + reproduciendo + "}";
    }
}
