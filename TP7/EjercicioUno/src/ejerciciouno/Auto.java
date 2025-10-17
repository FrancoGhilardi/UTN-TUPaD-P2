package ejerciciouno;

public class Auto extends Vehiculo {

    private final int cantidadPuertas;

    public Auto(String marca, String modelo, int cantidadPuertas) {
        super(marca, modelo);
        if (cantidadPuertas <= 0) {
            throw new IllegalArgumentException("La cantidad de puertas debe ser positiva");
        }
        this.cantidadPuertas = cantidadPuertas;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    @Override
    public String mostrarInfo() {
        return String.format("Auto %s %s - %d puertas", getMarca(), getModelo(), cantidadPuertas);
    }
}
