package ejerciciodos;

public class Rectangulo extends Figura {

    private final double ancho;
    private final double alto;

    public Rectangulo(String nombre, double ancho, double alto) {
        super(nombre);
        if (ancho <= 0 || alto <= 0) {
            throw new IllegalArgumentException("Ancho y alto deben ser positivos");
        }
        this.ancho = ancho;
        this.alto = alto;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }
}
