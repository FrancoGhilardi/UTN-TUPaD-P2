package tp2.ejercicio1;

import java.util.Scanner;

public class TP2Ejercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1,num2,num3,mayor;
        
        System.out.print("Ingrese el primer numero: ");
        num1 = sc.nextInt();
        
        System.out.print("Ingrese el segundo numero: ");
        num2 = sc.nextInt();
        
        System.out.println("Ingrese el tercer numero: ");
        num3 = sc.nextInt();
        
        if (num1 >= num2 && num1 >= num3) {
            mayor = num1;
        } else if (num2 >= num1 && num2 >= num3) {
            mayor = num2;
        } else {
            mayor = num3;
        }
        
        System.out.println("El mayor es: " + mayor);
    }
}
