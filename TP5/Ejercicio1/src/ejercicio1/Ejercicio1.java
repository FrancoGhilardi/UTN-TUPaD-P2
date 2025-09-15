package ejercicio1;
import java.time.LocalDate;
import java.nio.charset.StandardCharsets;

public class Ejercicio1 {

    public static void main(String[] args) {
        byte[] bytes = "binarioDeEjemplo".getBytes(StandardCharsets.UTF_8);
        Foto foto = new Foto(bytes, "jpg");

        Pasaporte pasaporte = new Pasaporte("AR-12345678", LocalDate.of(2020, 5, 10), foto);
        Titular titular = new Titular("Ana López", "30111222");

        pasaporte.setTitular(titular); // vincula ambos lados

        System.out.println(pasaporte);
        System.out.println(titular);
        pasaporte.removeTitular(); // rompe el vínculo en ambos lados
    }
    
}
