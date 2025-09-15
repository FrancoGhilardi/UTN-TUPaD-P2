package ejercicio5;

public class Ejercicio5 {

    public static void main(String[] args) {
        PlacaMadre pm1 = new PlacaMadre("ASUS TUF B550M", "AMD B550");
        Computadora pc = new Computadora("Lenovo", "SN-AB12345", pm1);
        Propietario p  = new Propietario("Sofía Gómez", "33123456");

        pc.setPropietario(p);

        System.out.println("Estado inicial:");
        System.out.println(pc);
        System.out.println(p);

        pc.reemplazarPlacaMadre(new PlacaMadre("Gigabyte A520M S2H", "AMD A520"));

        p.removeComputadora();
        System.out.println("\nLuego de removeComputadora():");
        System.out.println("pc.getPropietario() = " + pc.getPropietario());
        System.out.println("p.getComputadora()  = " + p.getComputadora());

        p.setComputadora(pc);
        System.out.println("\nReasignado:");
        System.out.println(pc);
        System.out.println(p);
    }
    
}
