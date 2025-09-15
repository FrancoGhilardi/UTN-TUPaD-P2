package ejercicio8;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.LocalDateTime;

public class Ejercicio8 {

    private static String sha256Hex(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] dig = md.digest(s.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : dig) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException("SHA-256 no disponible", e);
        }
    }

    public static void main(String[] args) {
        String hash = sha256Hex("contenido-ejemplo");
        Documento doc = new Documento("DOC-0001", "Contrato de Servicios", hash);

        Usuario u = new Usuario("Carla Méndez", "35111222");
        doc.setUsuario(u);

        byte[] firmaBytes = "firma-binaria".getBytes(StandardCharsets.UTF_8);
        FirmaDigital firma = new FirmaDigital(
                "RSA",
                "SERIE-ABC-001",
                "AC Ejemplo",
                LocalDateTime.now(),
                firmaBytes
        );

        doc.firmar(firma);

        System.out.println("Estado inicial:");
        System.out.println(doc);
        System.out.println(u);

        FirmaDigital firma2 = new FirmaDigital(
                "RSA",
                "SERIE-ABC-002",
                "AC Ejemplo",
                LocalDateTime.now(),
                "firma-nueva".getBytes(StandardCharsets.UTF_8)
        );
        doc.reemplazarFirma(firma2);

        doc.removeUsuario();
        System.out.println("\nLuego de removeUsuario():");
        System.out.println("doc.getUsuario() = " + doc.getUsuario());
        System.out.println("u.getDocumento() = " + u.getDocumento());

        u.setDocumento(doc);
        System.out.println("\nReasignado:");
        System.out.println(doc);
        System.out.println(u);
    }

}
