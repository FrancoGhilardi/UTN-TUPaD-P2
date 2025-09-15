package ejercicio8;

import java.util.Objects;

public class Documento {

    private final String id;           
    private final String titulo;
    private final String codeHash;    
    private FirmaDigital firma;        
    private Usuario usuario;           

    public Documento(String id, String titulo, String hashSHA256) {
        this.id = Objects.requireNonNull(id, "id").strip();
        this.titulo = Objects.requireNonNull(titulo, "titulo").strip();
        this.codeHash = Objects.requireNonNull(hashSHA256, "codeHash").strip();

        if (this.id.isEmpty()) {
            throw new IllegalArgumentException("id vacío");
        }
        if (this.titulo.isEmpty()) {
            throw new IllegalArgumentException("titulo vacío");
        }
        if (!this.codeHash.matches("[A-Fa-f0-9]{64}")) {
            throw new IllegalArgumentException("codeHash inválido (64 hex)");
        }
    }


    public void firmar(FirmaDigital f) {
        this.firma = Objects.requireNonNull(f, "firma");
    }


    public void reemplazarFirma(FirmaDigital nueva) {
        firmar(nueva);
    }

  
    public void setUsuario(Usuario nuevo) {
        if (this.usuario == nuevo) {
            return;
        }

        if (this.usuario != null) {
            Usuario anterior = this.usuario;
            this.usuario = null;
            if (anterior.getDocumento() == this) {
                anterior.removeDocumento();
            }
        }

        this.usuario = nuevo;
        if (nuevo != null && nuevo.getDocumento() != this) {
            nuevo.setDocumento(this);
        }
    }

    public void removeUsuario() {
        setUsuario(null);
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getHashSHA256() {
        return codeHash;
    }

    public FirmaDigital getFirma() {
        return firma;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public String toString() {
        return "Documento{" + id + " \"" + titulo + "\""
                + ", hash=" + codeHash.substring(0, 8) + "…"
                + ", firmado=" + (firma != null)
                + ", usuario=" + (usuario != null ? usuario.getDni() : "-") + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Documento)) {
            return false;
        }
        return id.equals(((Documento) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
