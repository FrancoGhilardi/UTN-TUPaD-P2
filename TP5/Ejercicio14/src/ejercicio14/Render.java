package ejercicio14;

import java.util.Objects;

public final class Render {

    private final String formato;
    private final Proyecto proyecto;

    public Render(String formato, Proyecto proyecto) {
        this.formato = Objects.requireNonNull(formato, "formato").strip();
        if (this.formato.isEmpty()) {
            throw new IllegalArgumentException("formato vacío");
        }
        this.proyecto = Objects.requireNonNull(proyecto, "proyecto");
    }

    public String getFormato() {
        return formato;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    @Override
    public String toString() {
        return "Render{" + proyecto.getNombre() + " → ." + formato + "}";
    }
}
