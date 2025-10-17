package ejerciciotres;

public abstract class Empleado {

    private final String nombre;

    protected Empleado(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract double calcularSueldo();
}
