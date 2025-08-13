package tp2.ejercicio1;

import java.util.Scanner;

public class TP2Ejercicio11 {

    static double DESCUENTO_ESPECIAL = 0.10;

    public static void calcularDescuentoEspecial(double precio) {
        double descuentoAplicado, precioFinal;
        descuentoAplicado = precio * DESCUENTO_ESPECIAL;
        precioFinal = precio - descuentoAplicado;

        System.out.println("El descuento especial aplicado es: " + descuentoAplicado);
        System.out.println("El precio final con descuento es: " + precioFinal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el precio del producto: ");
        double precio = sc.nextDouble();

        calcularDescuentoEspecial(precio);

    }

}
