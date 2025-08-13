package tp2.ejercicio1;

import java.util.Scanner;

public class TP2Ejercicio10 {

    public static int actualizarStock(int stockActual, int cantidadVendida, int cantidadRecibida) {
        return stockActual - cantidadVendida + cantidadRecibida;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stockActual, cantidadVendida, cantidadRecibida, nuevoStock;

        System.out.print("Ingrese el stock actual del producto: ");
        stockActual = sc.nextInt();

        System.out.print("Ingrese la cantidad vendida: ");
        cantidadVendida = sc.nextInt();

        System.out.print("Ingrese la cantidad recibida: ");
        cantidadRecibida = sc.nextInt();

        nuevoStock = actualizarStock(stockActual, cantidadVendida, cantidadRecibida);

        System.out.println("El nuevo stock del producto es: " + nuevoStock);

        sc.close();
    }

}
