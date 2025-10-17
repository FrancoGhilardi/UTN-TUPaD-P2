package ejerciciodos;

import java.util.List;

public class Main {

    public static void main(String[] args) {
         List<Figura> figuras = List.of(
            new Circulo("Circulo A", 3.0),
            new Rectangulo("Rectangulo B", 4.0, 2.5),
            new Circulo("Circulo C", 1.25)
        );

        for (Figura f : figuras) {
            System.out.printf("%s -> Area: %.4f%n", f.getNombre(), f.calcularArea());
        }
    }
    
}
