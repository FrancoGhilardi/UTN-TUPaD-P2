package tp2.ejercicio1;

import java.util.Scanner;

public class TP2Ejercicio7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nota;
        
        do {
            nota = sc.nextInt();

            if (nota < 0 || nota > 10) {
                System.out.println("Error: Nota inválida. Ingrese una nota entre 0 y 10.");
            }
        } while (nota < 0 || nota > 10);
        
        System.out.println("Nota guardada correctamente.");
    }
}
