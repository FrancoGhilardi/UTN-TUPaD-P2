package ejerciciotres;

public class EmpleadoTemporal extends Empleado {

    private final double tarifaHora;
    private final int horas;

    public EmpleadoTemporal(String nombre, double tarifaHora, int horas) {
        super(nombre);
        if (tarifaHora < 0 || horas < 0) {
            throw new IllegalArgumentException("Valores no pueden ser negativos");
        }
        this.tarifaHora = tarifaHora;
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }

    @Override
    public double calcularSueldo() {
        return tarifaHora * horas;
    }
}
