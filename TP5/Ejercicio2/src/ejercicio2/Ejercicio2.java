package ejercicio2;

public class Ejercicio2 {

    public static void main(String[] args) {
        Bateria bat = new Bateria("BL-45", 4000);
        Celular cel = new Celular("490154203237518", "Motorola", "G84", bat);
        Usuario u = new Usuario("Laura Díaz", "30111222");

        cel.setUsuario(u);
        cel.replaceBateria(new Bateria("BL-45-Pro", 5000)); 

        System.out.println(cel);
        System.out.println(u);
    }

}
