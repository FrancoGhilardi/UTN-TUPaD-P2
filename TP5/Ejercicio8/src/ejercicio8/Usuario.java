package ejercicio8;
import java.util.Objects;

public class Usuario {
    private final String nombre;
    private final String dni;     
    private Documento documento;   

    public Usuario(String nombre, String dni) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.dni = Objects.requireNonNull(dni, "dni").strip();
        if (this.nombre.isEmpty()) throw new IllegalArgumentException("nombre vacío");
        if (!this.dni.matches("\\d{7,9}")) throw new IllegalArgumentException("DNI inválido (7–9 dígitos)");
    }

    public void setDocumento(Documento nuevo) {
        if (this.documento == nuevo) return;

        if (this.documento != null) {
            Documento anterior = this.documento;
            this.documento = null;
            if (anterior.getUsuario() == this) anterior.removeUsuario();
        }

        this.documento = nuevo;
        if (nuevo != null && nuevo.getUsuario() != this) {
            nuevo.setUsuario(this);
        }
    }

    public void removeDocumento() { setDocumento(null); }

    public String getNombre() { return nombre; }
    public String getDni() { return dni; }
    public Documento getDocumento() { return documento; }

    @Override public String toString() {
        return "UsuarioD{" + nombre + ", dni=" + dni +
               ", documento=" + (documento != null ? documento.getId() : "-") + "}";
    }
}

