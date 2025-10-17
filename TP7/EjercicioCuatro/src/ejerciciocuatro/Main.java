package ejerciciocuatro;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Animal> granja = List.of(
                new Perro("Firulais"),
                new Gato("Mishi"),
                new Vaca("Lola")
        );

        for (Animal a : granja) {
            System.out.printf("%s -> Sonido: %s%n", a.describirAnimal(), a.hacerSonido());
        }
    }

}
