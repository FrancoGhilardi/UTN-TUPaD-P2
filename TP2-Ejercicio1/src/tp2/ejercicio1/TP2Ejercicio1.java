package tp2.ejercicio1;

import java.util.Scanner;

public class TP2Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Ingrese un año: ");
        int anio = sc.nextInt();
        
        if((anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0)){
            System.out.println("El año " + anio + " es bisiesto");
        }else{
            System.out.println("El año " + anio + " no es bisiesto");
        }
    }
    
}
