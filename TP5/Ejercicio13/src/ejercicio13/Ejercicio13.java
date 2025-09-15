
package ejercicio13;

public class Ejercicio13 {

    public static void main(String[] args) {
        UsuarioQR user = new UsuarioQR("Valentina Prado", "35123456");
        GeneradorQR gen = new GeneradorQR();

        CodigoQR qr1 = gen.crearCodigoSimple("https://miapp.com/invite?code=ABC123", user);

        CodigoQR qr2 = gen.crearCodigo("USR:" + user.getDni(), user, EccLevel.Q, 7);

        System.out.println("QR 1: " + qr1);
        System.out.println("QR 2: " + qr2);

        System.out.println("Owner QR1: " + qr1.getOwner().getNombre());
        System.out.println("Payload QR2: " + qr2.getPayload());
    }
    
}
