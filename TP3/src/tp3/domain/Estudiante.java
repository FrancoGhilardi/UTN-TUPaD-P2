/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.domain;

/**
 *
 * @author franc
 */
public class Estudiante {
    
    private String nombre;
    private String apellido;
    private String curso;
    private double calificacion;

    public Estudiante(String nombre, String apellido, String curso, double calificacionInicial) {
        this.nombre = validarNoVacio(nombre, "nombre");
        this.apellido = validarNoVacio(apellido, "apellido");
        this.curso = validarNoVacio(curso, "curso");
        setCalificacion(calificacionInicial);
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCurso() {
        return curso;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void subirCalificacion(double puntos) {
        if (puntos < 0) {
            throw new IllegalArgumentException("puntos no puede ser negativo");
        }
        setCalificacion(this.calificacion + puntos);
    }

    public void bajarCalificacion(double puntos) {
        if (puntos < 0) {
            throw new IllegalArgumentException("puntos no puede ser negativo");
        }
        setCalificacion(this.calificacion - puntos);
    }

    public String mostrarInfo() {
        return String.format("Estudiante: %s %s | Curso: %s | Calificación: %.1f",
                nombre, apellido, curso, calificacion);
    }

    @Override
    public String toString() {
        return mostrarInfo();
    }

    private void setCalificacion(double nueva) {
        if (nueva < 0) {
            nueva = 0;
        }
        if (nueva > 10) {
            nueva = 10;
        }
        this.calificacion = Math.round(nueva * 10.0) / 10.0; // 1 decimal
    }

    private static String validarNoVacio(String v, String campo) {
        if (v == null || v.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " es obligatorio");
        }
        return v.trim();
    }
}
