package ejercicio9;

import java.time.LocalDate;
import java.time.LocalTime;

public class Ejercicio9 {

    public static void main(String[] args) {
        Paciente pac = new Paciente("Lucía Torres", "OSDE");
        Profesional prof = new Profesional("Dr. Hugo Pérez", "Clínica Médica");

        CitaMedica cita = new CitaMedica(
                LocalDate.now().plusDays(2),
                LocalTime.of(10, 30),
                pac,
                prof
        );

        System.out.println("Cita creada:");
        System.out.println(cita);

        System.out.println("\nPaciente: " + cita.getPaciente().getNombre()
                + " (" + cita.getPaciente().getObraSocial() + ")");
        System.out.println("Profesional: " + cita.getProfesional().getNombre()
                + " - " + cita.getProfesional().getEspecialidad());
    }

}
