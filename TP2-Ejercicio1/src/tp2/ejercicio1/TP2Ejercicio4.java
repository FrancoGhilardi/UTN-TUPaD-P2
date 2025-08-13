package tp2.ejercicio1;

import java.util.Scanner;

public class TP2Ejercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese el precio del producto: ");
        double precioOriginal = sc.nextDouble();
        
        System.out.print("Ingrese la categoría del producto (A, B o C): ");
        String categoria = sc.next().toUpperCase();
        
        double descuento = 0;
        
        switch (categoria) {
            case "A":
                descuento = 0.10;
                break;
            case "B":
                descuento = 0.15;
                break;
            case "C":
                descuento = 0.20;
                break;
            default:
                System.out.println("Categoría no válida.");
                return;
        }
        
        double montoDescuento = precioOriginal * descuento;
        double precioFinal = precioOriginal - montoDescuento;
        
        System.out.println("Precio original: " + precioOriginal);
        System.out.println("Descuento aplicado: " + (int)(descuento * 100) + "%");
        System.out.println("Precio final: " + precioFinal);
        
    }
}
