package ejercicio13;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public final class CodigoQR {

    private final String id;
    private final String payload;
    private final EccLevel ecc;
    private final int version;
    private final LocalDateTime creado;
    private final byte[] pngBytes;
    private final UsuarioQR owner;

    public CodigoQR(String id, String payload, EccLevel ecc, int version,
            LocalDateTime creado, byte[] pngBytes, UsuarioQR owner) {
        this.id = Objects.requireNonNull(id, "id");
        this.payload = Objects.requireNonNull(payload, "payload").strip();
        this.ecc = Objects.requireNonNull(ecc, "ecc");
        this.version = version;
        this.creado = Objects.requireNonNull(creado, "creado");
        this.owner = Objects.requireNonNull(owner, "owner");
        Objects.requireNonNull(pngBytes, "pngBytes");

        if (this.payload.isEmpty()) {
            throw new IllegalArgumentException("payload vacío");
        }
        if (version < 1 || version > 40) {
            throw new IllegalArgumentException("version QR inválida (1..40)");
        }

        this.pngBytes = Arrays.copyOf(pngBytes, pngBytes.length);
    }

    public static CodigoQR create(String payload, EccLevel ecc, int version, UsuarioQR owner, byte[] pngBytes) {
        return new CodigoQR(UUID.randomUUID().toString(), payload, ecc, version, LocalDateTime.now(), pngBytes, owner);
    }

    public String getId() {
        return id;
    }

    public String getPayload() {
        return payload;
    }

    public EccLevel getEcc() {
        return ecc;
    }

    public int getVersion() {
        return version;
    }

    public LocalDateTime getCreado() {
        return creado;
    }

    public byte[] getPngBytes() {
        return Arrays.copyOf(pngBytes, pngBytes.length);
    }

    public UsuarioQR getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "CodigoQR{id=" + id
                + ", ecc=" + ecc
                + ", version=" + version
                + ", bytes=" + pngBytes.length
                + ", owner=" + owner.getDni() + "}";
    }
}
