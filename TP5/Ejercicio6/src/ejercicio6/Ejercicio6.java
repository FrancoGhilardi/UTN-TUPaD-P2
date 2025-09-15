package ejercicio6;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ejercicio6 {

    public static void main(String[] args) {
        Mesa m1 = new Mesa("M-12", 4);
        Mesa m2 = new Mesa("M-07", 2);

        Reserva r = new Reserva(
                "RES-2025-0001",
                LocalDateTime.now().plusDays(1).withHour(20).withMinute(30),
                Duration.ofMinutes(90),
                m1
        );

        Cliente c = new Cliente("Tomás Ruiz", "34123456");

        r.setCliente(c);

        System.out.println("Estado inicial:");
        System.out.println(r);
        System.out.println(c);

        r.setMesa(m2);

        r.removeCliente();
        System.out.println("\nLuego de removeCliente():");
        System.out.println("r.getCliente() = " + r.getCliente());
        System.out.println("c.getReserva() = " + c.getReserva());

        c.setReserva(r);
        System.out.println("\nReasignado:");
        System.out.println(r);
        System.out.println(c);
    }

}
