package ejercicio1;

import java.util.List;

public class Ejercicio1 {

    public static void main(String[] args) {
         Inventario inv = new Inventario();

    
        inv.agregarProducto(new Producto("P-001", "Yerba Mate 1kg", 2500, 40, CategoriaProducto.ALIMENTOS));
        inv.agregarProducto(new Producto("P-002", "Remera básica", 5500, 25, CategoriaProducto.ROPA));
        inv.agregarProducto(new Producto("P-003", "Licuadora X200", 29999, 10, CategoriaProducto.HOGAR));
        inv.agregarProducto(new Producto("P-004", "Auriculares BT", 18999, 15, CategoriaProducto.ELECTRONICA));
        inv.agregarProducto(new Producto("P-005", "Azúcar 1kg", 1200, 60, CategoriaProducto.ALIMENTOS));

       
        System.out.println("\nListar productos:");
        inv.listarProductos();

        
        System.out.println("\nBuscar por ID = P-003:");
        inv.buscarProductoPorId("P-003").ifPresentOrElse(
                p -> p.mostrarInfo(),
                () -> System.out.println("No se encontró el producto")
        );

        
        System.out.println("\nFiltrar por categoría ALIMENTOS:");
        List<Producto> alimentos = inv.filtrarPorCategoria(CategoriaProducto.ALIMENTOS);
        alimentos.forEach(System.out::println);

        
        System.out.println("\nEliminar ID = P-002:");
        boolean eliminado = inv.eliminarProducto("P-002");
        System.out.println("¿Eliminado? " + eliminado);
        System.out.println("Inventario luego de eliminar:");
        inv.listarProductos();

        
        System.out.println("\nActualizar stock de P-004 a 99:");
        boolean actualizado = inv.actualizarStock("P-004", 99);
        System.out.println("¿Actualizado? " + actualizado);
        inv.buscarProductoPorId("P-004").ifPresent(System.out::println);

       
        System.out.println("\nTotal de stock:");
        System.out.println(inv.obtenerTotalStock());

        
        System.out.println("\nProducto con mayor stock:");
        inv.obtenerProductoConMayorStock().ifPresent(System.out::println);

        
        System.out.println("\nProductos con precio entre 1000 y 3000:");
        inv.filtrarProductosPorPrecio(1000, 3000).forEach(System.out::println);

       
        System.out.println("\nCategorías disponibles:");
        inv.mostrarCategoriasDisponibles();
    }

}
