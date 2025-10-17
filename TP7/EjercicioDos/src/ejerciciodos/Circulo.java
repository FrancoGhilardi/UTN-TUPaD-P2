package ejerciciodos;

public class Circulo extends Figura {

    private final double radio;

    public Circulo(String nombre, double radio) {
        super(nombre);
        if (radio <= 0) {
            throw new IllegalArgumentException("El radio debe ser positivo");
        }
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}
