package tp3.domain;

import java.util.Objects;

public class Gallina {

    private final long idGallina;
    private int edad; 
    private int huevosPuestos;

    public Gallina(long idGallina, int edadInicial) {
        if (idGallina <= 0) {
            throw new IllegalArgumentException("idGallina debe ser > 0");
        }
        if (edadInicial < 0) {
            throw new IllegalArgumentException("edad no puede ser negativa");
        }
        this.idGallina = idGallina;
        this.edad = edadInicial;
        this.huevosPuestos = 0;
    }

    public long getIdGallina() {
        return idGallina;
    }

    public int getEdad() {
        return edad;
    }

    public int getHuevosPuestos() {
        return huevosPuestos;
    }

 
    public void ponerHuevo() {
        this.huevosPuestos += 1;
    }


    public void envejecer() {
        this.edad += 1;
    }

    public String mostrarEstado() {
        return String.format("Gallina #%d | Edad: %d | Huevos: %d",
                idGallina, edad, huevosPuestos);
    }

    @Override
    public String toString() {
        return mostrarEstado();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Gallina)) {
            return false;
        }
        Gallina g = (Gallina) o;
        return idGallina == g.idGallina;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idGallina);
    }
}
