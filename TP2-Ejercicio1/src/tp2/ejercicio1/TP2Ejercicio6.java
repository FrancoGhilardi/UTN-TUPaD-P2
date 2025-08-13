package tp2.ejercicio1;

import java.util.Scanner;

public class TP2Ejercicio6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int positivos = 0,negativos = 0,ceros = 0;
        
        for (int i = 1; i <= 10; i++) {
            System.out.print("Ingrese el número " + i + ": ");
            int num = sc.nextInt();

            if (num > 0) {
                positivos++;
            } else if (num < 0) {
                negativos++;
            } else {
                ceros++;
            }
        }
        
        System.out.println("Resultados:");
        System.out.println("Positivos: " + positivos);
        System.out.println("Negativos: " + negativos);
        System.out.println("Ceros: " + ceros);
    }
}
