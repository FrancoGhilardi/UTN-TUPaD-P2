package ejercicio4;

import java.time.YearMonth;

public class Ejercicio4 {

    public static void main(String[] args) {
        Banco b1 = new Banco("Banco Río", "30512345678");
        Banco b2 = new Banco("Banco Nación", "30587654321");

        TarjetaDeCredito tc = new TarjetaDeCredito("4509 1234 5678 9010", YearMonth.now().plusMonths(6), b1);
        Cliente c = new Cliente("María Pérez", "32123456");

        tc.setCliente(c);

        System.out.println("Estado inicial:");
        System.out.println(tc);
        System.out.println(c);

        tc.setBanco(b2);

        tc.removeCliente();
        System.out.println("\nLuego de removeCliente():");
        System.out.println("tc.getCliente() = " + tc.getCliente());
        System.out.println("c.getTarjeta()  = " + c.getTarjeta());

        c.setTarjeta(tc);
        System.out.println("\nReasignado:");
        System.out.println(tc);
        System.out.println(c);
    }

}
