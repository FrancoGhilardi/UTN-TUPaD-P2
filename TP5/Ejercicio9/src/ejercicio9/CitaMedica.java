package ejercicio9;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class CitaMedica {

    private final LocalDate fecha;
    private final LocalTime hora;
    private final Paciente paciente;
    private final Profesional profesional;

    public CitaMedica(LocalDate fecha, LocalTime hora, Paciente paciente, Profesional profesional) {
        this.fecha = Objects.requireNonNull(fecha, "fecha");
        this.hora = Objects.requireNonNull(hora, "hora");
        this.paciente = Objects.requireNonNull(paciente, "paciente");
        this.profesional = Objects.requireNonNull(profesional, "profesional");

        if (hora.getMinute() % 1 != 0) {
            throw new IllegalArgumentException("minutos inválidos");
        }
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Profesional getProfesional() {
        return profesional;
    }

    @Override
    public String toString() {
        return "CitaMedica{" + fecha + " " + hora
                + ", paciente=" + paciente.getNombre()
                + ", profesional=" + profesional.getNombre() + " (" + profesional.getEspecialidad() + ")}";
    }
}
