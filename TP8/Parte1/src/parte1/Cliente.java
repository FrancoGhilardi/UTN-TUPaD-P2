package parte1;

/**
 * Cliente que puede ser notificado ante cambios de estado del pedido.
 */
public class Cliente implements Notificable {

    private final String nombre;
    private final String email;

    public Cliente(String nombre, String email) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio.");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El email es obligatorio.");
        }
        this.nombre = nombre;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public void notificar(String mensaje) {
        System.out.printf("Notificacion a %s <%s>: %s%n", nombre, email, mensaje);
    }
}
