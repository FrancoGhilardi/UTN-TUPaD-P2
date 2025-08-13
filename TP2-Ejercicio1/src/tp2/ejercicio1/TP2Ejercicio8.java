package tp2.ejercicio1;

import java.util.Scanner;

public class TP2Ejercicio8 {
    
    public static double calcularPrecioFinal(double precioBase, double impuesto, double descuento) {
        return precioBase + (precioBase * impuesto) - (precioBase * descuento);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double precioBase, impuestoPorc, descuentoPorc, impuestoDecimal, descuentoDecimal, precioFinal;
        
        System.out.print("Ingrese el precio base del producto: ");
        precioBase = sc.nextDouble();
        
        System.out.print("Ingrese el impuesto en porcentaje (Ejemplo: 10 para 10%): ");
        impuestoPorc = sc.nextDouble();
        
        System.out.print("Ingrese el descuento en porcentaje (Ejemplo: 5 para 5%): ");
        descuentoPorc = sc.nextDouble();
        
        impuestoDecimal = impuestoPorc / 100;
        descuentoDecimal = descuentoPorc / 100;
        
        precioFinal = calcularPrecioFinal(precioBase, impuestoDecimal, descuentoDecimal);
        
        System.out.println("El precio final del producto es: " + precioFinal);
    }
}
