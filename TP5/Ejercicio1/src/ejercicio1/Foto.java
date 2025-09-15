package ejercicio1;
import java.util.Arrays;
import java.util.Objects;

/** Entidad-valor inmutable para composición dentro de Pasaporte. */
public final class Foto {
    private final byte[] imagen;
    private final String formato;

    public Foto(byte[] imagen, String formato) {
        Objects.requireNonNull(imagen, "imagen no puede ser null");
        Objects.requireNonNull(formato, "formato no puede ser null");
        this.imagen = Arrays.copyOf(imagen, imagen.length);
        this.formato = formato.strip();
        if (this.formato.isEmpty()) {
            throw new IllegalArgumentException("formato no puede ser vacío");
        }
    }

    public byte[] getImagen() {
        return Arrays.copyOf(imagen, imagen.length); 
    }

    public String getFormato() {
        return formato;
    }

    @Override
    public String toString() {
        return "Foto{formato='" + formato + "', bytes=" + imagen.length + "}";
    }
}
