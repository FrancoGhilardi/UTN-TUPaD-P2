package ejercicio13;

import java.nio.charset.StandardCharsets;

public class GeneradorQR {

    public CodigoQR crearCodigo(String payload, UsuarioQR owner, EccLevel ecc, int version) {
        byte[] pseudoPng = ("PNG(" + ecc + ";v" + version + "):" + payload).getBytes(StandardCharsets.UTF_8);
        return CodigoQR.create(payload, ecc, version, owner, pseudoPng);
    }

    public CodigoQR crearCodigoSimple(String payload, UsuarioQR owner) {
        return crearCodigo(payload, owner, EccLevel.M, 5);
    }
}
