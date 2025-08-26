package tp3.domain;

public class NaveEspacial {

    private final String nombre;
    private int combustible;
    private final int capacidadMaxima;
    private boolean enVuelo;

    private static final int CONSUMO_DESPEGUE = 10;
    private static final int CONSUMO_POR_UNIDAD_DISTANCIA = 1;

    public NaveEspacial(String nombre, int combustibleInicial, int capacidadMaxima) {
        this.nombre = validarNoVacio(nombre, "nombre");
        if (capacidadMaxima <= 0) {
            throw new IllegalArgumentException("capacidadMaxima debe ser > 0");
        }
        if (combustibleInicial < 0 || combustibleInicial > capacidadMaxima) {
            throw new IllegalArgumentException("combustibleInicial debe estar entre 0 y capacidadMaxima");
        }
        this.capacidadMaxima = capacidadMaxima;
        this.combustible = combustibleInicial;
        this.enVuelo = false;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCombustible() {
        return combustible;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public boolean isEnVuelo() {
        return enVuelo;
    }

    public boolean despegar() {
        if (combustible < CONSUMO_DESPEGUE) {
            return false;
        }
        combustible -= CONSUMO_DESPEGUE;
        enVuelo = true;
        return true;
    }

    public boolean avanzar(int distancia) {
        if (distancia <= 0) {
            throw new IllegalArgumentException("distancia debe ser > 0");
        }
        int consumo = distancia * CONSUMO_POR_UNIDAD_DISTANCIA;
        if (combustible < consumo) {
            return false;
        }
        combustible -= consumo;
        return true;
    }

    public int recargarCombustible(int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("cantidad debe ser > 0");
        }
        int espacio = capacidadMaxima - combustible;
        int cargado = Math.min(espacio, cantidad);
        combustible += cargado;
        return cargado;
    }

    public String mostrarEstado() {
        return String.format("Nave: %s | Combustible: %d/%d | En vuelo: %s",
                nombre, combustible, capacidadMaxima, enVuelo ? "sí" : "no");
    }

    @Override
    public String toString() {
        return mostrarEstado();
    }

    private static String validarNoVacio(String v, String campo) {
        if (v == null || v.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " es obligatorio");
        }
        return v.trim();
    }
}
