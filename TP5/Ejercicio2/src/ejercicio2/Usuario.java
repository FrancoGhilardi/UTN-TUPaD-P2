package ejercicio2;
import java.util.Objects;

/**
 * Usuario asignado a un Celular (asociación 1↔1 bidireccional).
 */
public class Usuario {

    private final String nombre;
    private final String dni;
    private Celular celular;

    public Usuario(String nombre, String dni) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.dni = Objects.requireNonNull(dni, "dni").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (this.dni.isEmpty()) {
            throw new IllegalArgumentException("dni vacío");
        }
    }

    public void setCelular(Celular nuevo) {
        if (this.celular == nuevo) {
            return;
        }
        if (this.celular != null) {
            Celular anterior = this.celular;
            this.celular = null;
            if (anterior.getUsuario() == this) {
                anterior.removeUsuario();
            }
        }
        this.celular = nuevo;
        if (nuevo != null && nuevo.getUsuario() != this) {
            nuevo.setUsuario(this);
        }
    }

    public void removeCelular() {
        setCelular(null);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public Celular getCelular() {
        return celular;
    }

    @Override
    public String toString() {
        return "Usuario{" + nombre + ", dni=" + dni + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Usuario)) {
            return false;
        }
        return dni.equals(((Usuario) o).dni);
    }

    @Override
    public int hashCode() {
        return dni.hashCode();
    }
}
