package ejerciciodos;

public abstract class Figura {

    private final String nombre;

    protected Figura(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre de la figura es obligatorio");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularArea();
}
