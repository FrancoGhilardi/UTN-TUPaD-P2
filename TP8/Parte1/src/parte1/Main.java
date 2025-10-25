package parte1;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Cliente (Notificable) y armado del Pedido con productos
        Cliente cliente = new Cliente("Franco", "frano@example.com");
        Pedido pedido = new Pedido(cliente, List.of(
                new Producto("Mouse inalambrico", 14999.90),
                new Producto("Teclado mecanico", 32999.00),
                new Producto("Mouse pad XL", 5999.50)
        ));

        System.out.printf("Productos en el pedido: %d%n", pedido.getProductos().size());
        double total = pedido.calcularTotal();
        System.out.printf("Total bruto del pedido: $%.2f%n", total);

        // Cambio de estado inicial (dispara notificación al cliente)
        pedido.cambiarEstado(EstadoPedido.PREPARANDO);

        // Selección de medio de pago por argumento: "tarjeta" (default) o "paypal"
        String metodo = (args.length > 0) ? args[0].trim().toLowerCase() : "tarjeta";
        boolean pagoAprobado;

        switch (metodo) {
            case "paypal" -> {
                Pago paypal = new PayPal("pagos@cliente.com");
                pagoAprobado = paypal.procesarPago(total);
            }
            case "tarjeta" -> {
                // Tarjeta con DESCUENTO
                TarjetaCredito tarjeta = new TarjetaCredito("Banco Rio", "**** **** **** 4242", 15.0);
                double totalConDescuento = tarjeta.aplicarDescuento(total);
                System.out.printf("Aplicando 15%% de descuento → Total con descuento: $%.2f%n", totalConDescuento);
                pagoAprobado = tarjeta.procesarPago(totalConDescuento);
            }
            default -> {
                System.out.println("Método no reconocido. Use 'tarjeta' o 'paypal'.");
                return;
            }
        }

        // Cambio de estado según resultado del pago (dispara notificación)
        if (pagoAprobado) {
            pedido.cambiarEstado(EstadoPedido.ENVIADO);
            pedido.cambiarEstado(EstadoPedido.ENTREGADO);
        } else {
            pedido.cambiarEstado(EstadoPedido.CANCELADO);
        }

    }

}
