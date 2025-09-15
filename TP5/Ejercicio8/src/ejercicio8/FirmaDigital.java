package ejercicio8;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public final class FirmaDigital {

    private final String algoritmo;
    private final String numeroSerie;   
    private final String emisor;        
    private final LocalDateTime fecha;  
    private final byte[] bytesFirma;    

    public FirmaDigital(String algoritmo, String numeroSerie, String emisor,
            LocalDateTime fecha, byte[] bytesFirma) {
        this.algoritmo = Objects.requireNonNull(algoritmo, "algoritmo").strip();
        this.numeroSerie = Objects.requireNonNull(numeroSerie, "numeroSerie").strip();
        this.emisor = Objects.requireNonNull(emisor, "emisor").strip();
        this.fecha = Objects.requireNonNull(fecha, "fecha");
        Objects.requireNonNull(bytesFirma, "bytesFirma");
        if (this.algoritmo.isEmpty()) {
            throw new IllegalArgumentException("algoritmo vacío");
        }
        if (!this.algoritmo.matches("(RSA|ECDSA|Ed25519)")) {
            throw new IllegalArgumentException("algoritmo no soportado (RSA|ECDSA|Ed25519)");
        }
        if (this.numeroSerie.isEmpty()) {
            throw new IllegalArgumentException("numeroSerie vacío");
        }
        if (this.emisor.isEmpty()) {
            throw new IllegalArgumentException("emisor vacío");
        }
        if (fecha.isAfter(LocalDateTime.now())) {
            throw new IllegalArgumentException("fecha futura inválida");
        }
        this.bytesFirma = Arrays.copyOf(bytesFirma, bytesFirma.length); // copia defensiva
    }

    public String getAlgoritmo() {
        return algoritmo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getEmisor() {
        return emisor;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public byte[] getBytesFirma() {
        return Arrays.copyOf(bytesFirma, bytesFirma.length);
    }

    @Override
    public String toString() {
        return "FirmaDigital{" + algoritmo + ", serie=" + numeroSerie + ", emisor=" + emisor + ", fecha=" + fecha + "}";
    }
}
