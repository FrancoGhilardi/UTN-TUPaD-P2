package ejercicio7;

import java.util.Objects;

public class Vehiculo {

    private final String patente;
    private final String modelo;
    private Motor motor;
    private Conductor conductor;

    public Vehiculo(String patente, String modelo, Motor motor) {
        this.patente = validarPatente(patente);
        this.modelo = Objects.requireNonNull(modelo, "modelo").strip();
        if (this.modelo.isEmpty()) {
            throw new IllegalArgumentException("modelo vacío");
        }
        this.motor = Objects.requireNonNull(motor, "motor");
    }

    private static String validarPatente(String p) {
        Objects.requireNonNull(p, "patente");
        String v = p.strip().toUpperCase();
        if (!v.matches("([A-Z]{3}\\d{3})|([A-Z]{2}\\d{3}[A-Z]{2})")) {
            throw new IllegalArgumentException("patente inválida (AAA123 o AA123BB)");
        }
        return v;
    }

    public void setMotor(Motor nuevo) {
        this.motor = Objects.requireNonNull(nuevo, "motor");
    }

    public void setConductor(Conductor nuevo) {
        if (this.conductor == nuevo) {
            return;
        }

        if (this.conductor != null) {
            Conductor anterior = this.conductor;
            this.conductor = null;
            if (anterior.getVehiculo() == this) {
                anterior.removeVehiculo();
            }
        }

        this.conductor = nuevo;
        if (nuevo != null && nuevo.getVehiculo() != this) {
            nuevo.setVehiculo(this);
        }
    }

    public void removeConductor() {
        setConductor(null);
    }

    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    public Conductor getConductor() {
        return conductor;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + patente + ", modelo=" + modelo
                + ", motor=" + motor
                + ", conductor=" + (conductor != null ? conductor.getLicencia() : "-") + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Vehiculo)) {
            return false;
        }
        return patente.equals(((Vehiculo) o).patente);
    }

    @Override
    public int hashCode() {
        return patente.hashCode();
    }
}
