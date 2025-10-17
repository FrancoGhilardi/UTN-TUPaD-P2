package ejerciciocuatro;

public class Vaca extends Animal {

    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public String hacerSonido() {
        return "Muuu";
    }
}
