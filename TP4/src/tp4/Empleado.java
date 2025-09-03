package tp4;

import java.util.Locale;

public class Empleado {

    // Atributos de instancia
    private int id;
    private String nombre;
    private String puesto;
    private double salario;

    // Atributos estáticos 
    private static int totalEmpleados = 0;

    // Soporte interno para ID automático 
    private static int nextId = 1;

    // Salario por defecto (la consigna no fija valor)
    private static final double SALARIO_POR_DEFECTO = 5000000.0;

    // --- Constructores ---
    public Empleado(int id, String nombre, String puesto, double salario) {
        this.id = id;
        this.nombre = validarNoVacio(nombre, "nombre");
        this.puesto = validarNoVacio(puesto, "puesto");
        this.salario = validarNoNegativo(salario, "salario");
        totalEmpleados++;
    }

    /**
     * Constructor simplificado: asigna id automático y salario por defecto.
     * Incrementa el contador global.
     */
    public Empleado(String nombre, String puesto) {
        this.id = nextId++;
        this.nombre = validarNoVacio(nombre, "nombre");
        this.puesto = validarNoVacio(puesto, "puesto");
        this.salario = SALARIO_POR_DEFECTO;
        totalEmpleados++;
    }

    // --- Métodos sobrecargados actualizarSalario ---
    /**
     * Aumenta el salario por porcentaje
     */
    public void actualizarSalario(double porcentaje) {
        if (porcentaje < 0) {
            throw new IllegalArgumentException("El porcentaje no puede ser negativo");
        }
        this.salario = this.salario * (1 + porcentaje / 100.0);
    }

    /**
     * Aumenta el salario por cantidad fija 
     */
    public void actualizarSalario(int cantidadFija) {
        if (cantidadFija < 0) {
            throw new IllegalArgumentException("La cantidad fija no puede ser negativa");
        }
        this.salario = this.salario + cantidadFija;
    }

    // --- Método estático ---
    public static int mostrarTotalEmpleados() {
        return totalEmpleados;
    }

    // --- toString ---
    @Override
    public String toString() {
        // Formateo consistente para salario
        return String.format(Locale.US,
                "Empleado{id=%d, nombre='%s', puesto='%s', salario=%.2f}",
                id, nombre, puesto, salario);
    }

    // --- Getters mínimos ---
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    // --- Validaciones ---
    private static String validarNoVacio(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException("El campo '" + campo + "' es obligatorio");
        }
        return valor.trim();
    }

    private static double validarNoNegativo(double valor, String campo) {
        if (valor < 0) {
            throw new IllegalArgumentException("El campo '" + campo + "' no puede ser negativo");
        }
        return valor;
    }
}
