package tp2.ejercicio1;

import java.util.Scanner;

public class TP2Ejercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero, sumaPares=0;
        
        while (true) {
            System.out.print("Ingrese un número (0 para terminar): ");
            numero = sc.nextInt();

            if (numero == 0) {
                break; 
            }

            if (numero % 2 == 0) {
                sumaPares += numero;
            }
        }
        
        System.out.println("La suma de los números pares es: " + sumaPares);
    }
}
