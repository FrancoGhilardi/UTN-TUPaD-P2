package ejercicio1;
import java.time.LocalDate;
import java.util.Objects;

/** Agregado raíz: compone Foto y se asocia bidireccionalmente con Titular. */
public class Pasaporte {
    private final String numero;            
    private final LocalDate fechaEmision;   
    private final Foto foto;                
    private Titular titular;                

    public Pasaporte(String numero, LocalDate fechaEmision, Foto foto) {
        this.numero = Objects.requireNonNull(numero, "numero no puede ser null").strip();
        this.fechaEmision = Objects.requireNonNull(fechaEmision, "fechaEmision no puede ser null");
        this.foto = Objects.requireNonNull(foto, "foto (composición) no puede ser null");
        if (this.numero.isEmpty()) throw new IllegalArgumentException("numero vacío");
        if (fechaEmision.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("fechaEmision no puede ser futura");
        }
    }

    /* Manejo de asociación bidireccional con Titular */
    public void setTitular(Titular nuevo) {
        if (this.titular == nuevo) return;

        if (this.titular != null) {
            Titular anterior = this.titular;
            this.titular = null;
            if (anterior.getPasaporte() == this) {
                anterior.removePasaporte();
            }
        }

        this.titular = nuevo;
        if (nuevo != null && nuevo.getPasaporte() != this) {
            nuevo.setPasaporte(this);
        }
    }

    public void removeTitular() {
        setTitular(null);
    }

    public String getNumero() { return numero; }
    public LocalDate getFechaEmision() { return fechaEmision; }
    public Foto getFoto() { return foto; }
    public Titular getTitular() { return titular; }

    @Override
    public String toString() {
        return "Pasaporte{numero='" + numero + "', fechaEmision=" + fechaEmision +
               ", titular=" + (titular != null ? titular.getDni() : "sin asignar") + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pasaporte)) return false;
        Pasaporte that = (Pasaporte) o;
        return numero.equals(that.numero);
    }

    @Override
    public int hashCode() {
        return numero.hashCode();
    }
}
