package ejerciciouno;

public class Vehiculo {

    private final String marca;
    private final String modelo;

    public Vehiculo(String marca, String modelo) {
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("La marca es obligatoria");
        }
        if (modelo == null || modelo.isBlank()) {
            throw new IllegalArgumentException("El modelo es obligatorio");
        }
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String mostrarInfo() {
        return String.format("Vehículo %s %s", marca, modelo);
    }
}
