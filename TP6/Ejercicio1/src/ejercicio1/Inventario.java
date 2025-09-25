package ejercicio1;

import java.util.*;
import java.util.stream.Collectors;

public class Inventario {

    private final List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        if (p == null) {
            throw new IllegalArgumentException("Producto inválido");
        }
        buscarProductoPorId(p.getId()).ifPresent(pp -> {
            throw new IllegalArgumentException("Ya existe un producto con id=" + pp.getId());
        });
        productos.add(p);
    }

    public void listarProductos() {
        if (productos.isEmpty()) {
            System.out.println("Inventario vacío");
            return;
        }
        productos.forEach(Producto::mostrarInfo);
    }

    public Optional<Producto> buscarProductoPorId(String id) {
        if (id == null || id.isBlank()) {
            return Optional.empty();
        }
        return productos.stream()
                .filter(p -> p.getId().equalsIgnoreCase(id.trim()))
                .findFirst();
    }

    public boolean eliminarProducto(String id) {
        return buscarProductoPorId(id).map(productos::remove).orElse(false);
    }

    public boolean actualizarStock(String id, int nuevaCantidad) {
        if (nuevaCantidad < 0) {
            throw new IllegalArgumentException("Stock negativo no permitido");
        }
        return buscarProductoPorId(id).map(p -> {
            p.setCantidad(nuevaCantidad);
            return true;
        }).orElse(false);
    }

    public List<Producto> filtrarPorCategoria(CategoriaProducto categoria) {
        if (categoria == null) {
            return List.of();
        }
        return productos.stream()
                .filter(p -> p.getCategoria() == categoria)
                .collect(Collectors.toUnmodifiableList());
    }

    public int obtenerTotalStock() {
        return productos.stream().mapToInt(Producto::getCantidad).sum();
    }

    public Optional<Producto> obtenerProductoConMayorStock() {
        return productos.stream().max(Comparator.comparingInt(Producto::getCantidad));
    }

    public List<Producto> filtrarProductosPorPrecio(double min, double max) {
        if (min > max) {
            double tmp = min;
            min = max;
            max = tmp;
        }
        final double from = min, to = max;
        return productos.stream()
                .filter(p -> p.getPrecio() >= from && p.getPrecio() <= to)
                .collect(Collectors.toUnmodifiableList());
    }

    public void mostrarCategoriasDisponibles() {
        for (CategoriaProducto c : CategoriaProducto.values()) {
            System.out.printf("- %s: %s%n", c.name(), c.getDescripcion());
        }
    }

    public List<Producto> getProductos() {
        return Collections.unmodifiableList(productos);
    }
}
