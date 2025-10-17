package ejerciciotres;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Empleado> nomina = List.of(
                new EmpleadoPlanta("Ana", 500_000, 50_000),
                new EmpleadoTemporal("Luis", 3_500, 120),
                new EmpleadoPlanta("Mara", 620_000, 0),
                new EmpleadoTemporal("Juan", 4_000, 90)
        );

        for (Empleado e : nomina) {
            String tipo = (e instanceof EmpleadoPlanta) ? "Planta"
                    : (e instanceof EmpleadoTemporal) ? "Temporal"
                            : "Otro";
            System.out.printf("%-5s | %-10s | Sueldo: $%,.2f%n",
                    tipo, e.getNombre(), e.calcularSueldo());

            if (e instanceof EmpleadoTemporal temp) {
                System.out.printf("   (Horas trabajadas: %d)%n", temp.getHoras());
            }
        }
    }

}
