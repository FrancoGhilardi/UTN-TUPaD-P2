package ejercicio2;
import java.util.Objects;

/**
 * Agregado que agrega una Bateria (agregación) y se asocia 1↔1 con Usuario.
 */
public class Celular {

    private final String imei;
    private final String marca;
    private final String modelo;
    private Bateria bateria;
    private Usuario usuario;

    public Celular(String imei, String marca, String modelo, Bateria bateria) {
        this.imei = validarImei(imei);
        this.marca = Objects.requireNonNull(marca, "marca").strip();
        this.modelo = Objects.requireNonNull(modelo, "modelo").strip();
        if (this.marca.isEmpty()) {
            throw new IllegalArgumentException("marca vacía");
        }
        if (this.modelo.isEmpty()) {
            throw new IllegalArgumentException("modelo vacío");
        }
        this.bateria = Objects.requireNonNull(bateria, "bateria no puede ser null");
    }

    private static String validarImei(String imei) {
        Objects.requireNonNull(imei, "imei");
        String d = imei.strip();
        if (!d.matches("\\d{15}")) {
            throw new IllegalArgumentException("IMEI debe tener 15 dígitos");
        }
        return d;
    }

    public void replaceBateria(Bateria nueva) {
        this.bateria = Objects.requireNonNull(nueva, "bateria no puede ser null");
    }

    public void setUsuario(Usuario nuevo) {
        if (this.usuario == nuevo) {
            return;
        }
        if (this.usuario != null) {
            Usuario anterior = this.usuario;
            this.usuario = null;
            if (anterior.getCelular() == this) {
                anterior.removeCelular();
            }
        }
        this.usuario = nuevo;
        if (nuevo != null && nuevo.getCelular() != this) {
            nuevo.setCelular(this);
        }
    }

    public void removeUsuario() {
        setUsuario(null);
    }

    public String getImei() {
        return imei;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Bateria getBateria() {
        return bateria;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Celular{IMEI=" + imei + ", " + marca + " " + modelo
                + ", bateria=" + bateria + ", usuario=" + (usuario != null ? usuario.getDni() : "-") + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Celular)) {
            return false;
        }
        return imei.equals(((Celular) o).imei);
    }

    @Override
    public int hashCode() {
        return imei.hashCode();
    }
}
