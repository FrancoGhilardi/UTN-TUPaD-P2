package tp2.ejercicio1;

import java.util.Scanner;

public class TP2Ejercicio9 {

    public static double calcularCostoEnvio(double peso, String zona) {
        if (zona.equalsIgnoreCase("Nacional")) {
            return peso * 5;
        } else if (zona.equalsIgnoreCase("Internacional")) {
            return peso * 10;
        } else {
            System.out.println("Zona inválida. Use 'Nacional' o 'Internacional'.");
            return 0;
        }
    }

    public static double calcularTotalCompra(double precioProducto, double costoEnvio) {
        return precioProducto + costoEnvio;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double precioProducto, peso, costoEnvio, total;

        System.out.print("Ingrese el precio del producto: ");
        precioProducto = sc.nextDouble();

        System.out.print("Ingrese el peso del paquete en kg: ");
        peso = sc.nextDouble();

        sc.nextLine();
        System.out.print("Ingrese la zona de envío (Nacional/Internacional): ");
        String zona = sc.nextLine();

        costoEnvio = calcularCostoEnvio(peso, zona);
        total = calcularTotalCompra(precioProducto, costoEnvio);

        System.out.println("El costo de envío es: " + costoEnvio);
        System.out.println("El total a pagar es: " + total);
    }
}
