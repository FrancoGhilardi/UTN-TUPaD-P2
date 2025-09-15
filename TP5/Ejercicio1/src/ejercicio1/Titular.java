package ejercicio1;
import java.util.Objects;

/** Persona titular del pasaporte. Mantiene asociación bidireccional con Pasaporte. */
public class Titular {
    private final String nombre;
    private final String dni; 
    private Pasaporte pasaporte; 

    public Titular(String nombre, String dni) {
        this.nombre = Objects.requireNonNull(nombre, "nombre no puede ser null").strip();
        this.dni = Objects.requireNonNull(dni, "dni no puede ser null").strip();
        if (this.nombre.isEmpty()) throw new IllegalArgumentException("nombre vacío");
        if (this.dni.isEmpty()) throw new IllegalArgumentException("dni vacío");
    }

    /* Asociación bidireccional */
    public void setPasaporte(Pasaporte nuevo) {
        if (this.pasaporte == nuevo) return;

        if (this.pasaporte != null) {
            Pasaporte anterior = this.pasaporte;
            this.pasaporte = null;
            anterior.removeTitular();
        }

        this.pasaporte = nuevo;
        if (nuevo != null && nuevo.getTitular() != this) {
            nuevo.setTitular(this); 
        }
    }

    public void removePasaporte() {
        setPasaporte(null);
    }

    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public Pasaporte getPasaporte() { return pasaporte; }

    @Override
    public String toString() {
        return "Titular{nombre='" + nombre + "', dni='" + dni + "'}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Titular)) return false;
        Titular titular = (Titular) o;
        return dni.equals(titular.dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }
}
