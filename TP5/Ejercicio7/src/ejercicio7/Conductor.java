package ejercicio7;

import java.util.Objects;

public class Conductor {

    private final String nombre;
    private final String licencia;
    private Vehiculo vehiculo;

    public Conductor(String nombre, String licencia) {
        this.nombre = Objects.requireNonNull(nombre, "nombre").strip();
        this.licencia = Objects.requireNonNull(licencia, "licencia").strip();
        if (this.nombre.isEmpty()) {
            throw new IllegalArgumentException("nombre vacío");
        }
        if (!this.licencia.matches("[A-Za-z0-9-]{5,15}")) {
            throw new IllegalArgumentException("licencia inválida (5–15 alfanumérico)");
        }
    }

    public void setVehiculo(Vehiculo nuevo) {
        if (this.vehiculo == nuevo) {
            return;
        }

        if (this.vehiculo != null) {
            Vehiculo anterior = this.vehiculo;
            this.vehiculo = null;
            if (anterior.getConductor() == this) {
                anterior.removeConductor();
            }
        }

        this.vehiculo = nuevo;
        if (nuevo != null && nuevo.getConductor() != this) {
            nuevo.setConductor(this);
        }
    }

    public void removeVehiculo() {
        setVehiculo(null);
    }

    public String getNombre() {
        return nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    @Override
    public String toString() {
        return "Conductor{" + nombre + ", lic=" + licencia
                + ", vehiculo=" + (vehiculo != null ? vehiculo.getPatente() : "-") + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Conductor)) {
            return false;
        }
        return licencia.equals(((Conductor) o).licencia);
    }

    @Override
    public int hashCode() {
        return licencia.hashCode();
    }
}
