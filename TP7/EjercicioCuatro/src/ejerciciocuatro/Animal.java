package ejerciciocuatro;

public abstract class Animal {

    private final String nombre;

    protected Animal(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public abstract String hacerSonido();

    public String describirAnimal() {
        return String.format("Soy un %s llamado %s", getClass().getSimpleName(), nombre);
    }
}
