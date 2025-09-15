package ejercicio14;

public class Ejercicio14 {

    public static void main(String[] args) {
        Proyecto p = new Proyecto("Trailer TUP", 120);
        EditorVideo editor = new EditorVideo();

        editor.exportar("mp4", p);

        Render r = editor.exportarRetornando("mov", p);
        System.out.println("Render devuelto: " + r);
        System.out.println("Proyecto asociado al render: " + r.getProyecto().getNombre());
    }
    
}
