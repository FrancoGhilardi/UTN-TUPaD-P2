package ejercicio10;

import java.time.LocalDateTime;
import java.util.Objects;

public final class ClaveSeguridad {

    private final String codigo;
    private final LocalDateTime ultimaModificacion;

    public ClaveSeguridad(String codigo, LocalDateTime ultimaModificacion) {
        this.codigo = Objects.requireNonNull(codigo, "codigo").strip();
        this.ultimaModificacion = Objects.requireNonNull(ultimaModificacion, "ultimaModificacion");
        if (!this.codigo.matches("\\d{4,8}")) {
            throw new IllegalArgumentException("codigo inválido (4–8 dígitos)");
        }
        if (ultimaModificacion.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("ultimaModificacion futura");
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDateTime getUltimaModificacion() {
        return ultimaModificacion;
    }

    @Override
    public String toString() {
        return "ClaveSeguridad{****, modif=" + ultimaModificacion + "}";
    }
}
