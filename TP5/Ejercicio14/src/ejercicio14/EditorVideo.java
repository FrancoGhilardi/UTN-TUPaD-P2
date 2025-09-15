package ejercicio14;

import java.util.Objects;

public class EditorVideo {

    public void exportar(String formato, Proyecto proyecto) {
        Objects.requireNonNull(formato, "formato");
        Objects.requireNonNull(proyecto, "proyecto");
        Render r = new Render(formato, proyecto);
        System.out.println("▶ Exportando " + proyecto.getNombre() + " a ." + formato + " ... listo.");
        System.out.println("  " + r);
    }

    public Render exportarRetornando(String formato, Proyecto proyecto) {
        return new Render(formato, proyecto);
    }
}
