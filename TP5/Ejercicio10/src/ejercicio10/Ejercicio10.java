package ejercicio10;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Ejercicio10 {

    public static void main(String[] args) {
        ClaveSeguridad clave = new ClaveSeguridad("1234", LocalDateTime.now().minusDays(1));
        CuentaBancaria cta = new CuentaBancaria("2850590940090418135201", clave);

        Titular t = new Titular("Daniel Mansilla", "33111222");
        cta.setTitular(t);

        cta.depositar(new BigDecimal("150000.50"));
        cta.extraer(new BigDecimal("10000.25"));

        System.out.println("Estado inicial:");
        System.out.println(cta);
        System.out.println(t);

        cta.cambiarClaveConCodigo("987654");

        cta.removeTitular();
        System.out.println("\nLuego de removeTitular():");
        System.out.println("cta.getTitular() = " + cta.getTitular());
        System.out.println("t.getCuenta()    = " + t.getCuenta());

        t.setCuenta(cta);
        System.out.println("\nReasignado:");
        System.out.println(cta);
        System.out.println(t);
    }
    
}
