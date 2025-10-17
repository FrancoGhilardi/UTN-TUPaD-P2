package ejerciciouno;

public class Main {

    public static void main(String[] args) {
       Auto auto = new Auto("Toyota", "Corolla", 4);
        System.out.println(auto.mostrarInfo());

        Vehiculo v = new Auto("Ford", "Focus", 5);
        System.out.println(v.mostrarInfo());
    }
    
}
