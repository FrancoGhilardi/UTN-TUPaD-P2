/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp3.domain;

/**
 *
 * @author franc
 */
public class Mascota {
    private String nombre;
    private String especie;
    private int edad;

    public Mascota(String nombre, String especie, int edadInicial) {
        this.nombre = validarNoVacio(nombre, "nombre");
        this.especie = validarNoVacio(especie, "especie");
        if (edadInicial < 0) {
            throw new IllegalArgumentException("edad no puede ser negativa");
        }
        this.edad = edadInicial;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    public void cumplirAnios() {
        this.edad += 1;
    }

    public String mostrarInfo() {
        return String.format("Mascota: %s (%s) | Edad: %d", nombre, especie, edad);
    }

    @Override
    public String toString() {
        return mostrarInfo();
    }

    private static String validarNoVacio(String v, String campo) {
        if (v == null || v.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " es obligatorio");
        }
        return v.trim();
    }
}
