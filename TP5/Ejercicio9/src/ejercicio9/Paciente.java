package ejercicio9;

import java.util.Objects;

public class Paciente {

    private final String nombre;
    private final String obraSocial;

    public Paciente(String nombre, String obraSocial) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.obraSocial = Objects.requireNonNull(obraSocial, "obraSocial").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (this.obraSocial.isEmpty()) {
            throw new IllegalArgumentException("obraSocial vacía");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    @Override
    public String toString() {
        return "Paciente{" + nombre + ", OS=" + obraSocial + "}";
    }
}
