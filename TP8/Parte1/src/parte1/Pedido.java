package parte1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Pedido compuesto por una lista de productos. Calcula el total y notifica al
 * cliente cuando cambia de estado.
 */
public class Pedido implements Pagable {

    private final Notificable cliente;
    private final List<Producto> productos = new ArrayList<>();
    private EstadoPedido estado = EstadoPedido.NUEVO;

    public Pedido(Notificable cliente) {
        this.cliente = Objects.requireNonNull(cliente, "El cliente es obligatorio.");
    }

    public Pedido(Notificable cliente, List<Producto> productosIniciales) {
        this(cliente);
        if (productosIniciales != null) {
            for (Producto p : productosIniciales) {
                agregarProducto(p);
            }
        }
    }

    public void agregarProducto(Producto producto) {
        productos.add(Objects.requireNonNull(producto, "Producto nulo."));
    }

    public boolean eliminarProducto(Producto producto) {
        return productos.remove(Objects.requireNonNull(producto));
    }

    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    /**
     * Cambia el estado y notifica al cliente si realmente hubo cambio.
     */
    public void cambiarEstado(EstadoPedido nuevoEstado) {
        if (nuevoEstado == null) {
            throw new IllegalArgumentException("Estado no puede ser nulo.");
        }
        if (this.estado != nuevoEstado) {
            this.estado = nuevoEstado;
            cliente.notificar("Tu pedido cambio al estado: " + nuevoEstado);
        }
    }

    @Override
    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::calcularTotal).sum();
    }
}
