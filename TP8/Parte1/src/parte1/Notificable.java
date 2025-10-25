package parte1;

/**
 * Contrato para recibir notificaciones de eventos/estados.
 */
public interface Notificable {

    void notificar(String mensaje);
}
