package tp4;

public class TP4 {

    public static void main(String[] args) {
        // Instanciar usando el constructor simplificado (id auto, salario por defecto)
        Empleado e1 = new Empleado("Ana López", "Desarrolladora");
        Empleado e2 = new Empleado("Bruno Díaz", "QA Analyst");

        // Instanciar usando el constructor completo
        Empleado e3 = new Empleado(1001, "Carla Pérez", "Líder Técnico", 850000.00);

        // Aplicar aumentos: porcentaje y cantidad fija
        e1.actualizarSalario(15.0);     // +15%
        e2.actualizarSalario(25000);    // +$25.000
        e3.actualizarSalario(10.0);     // +10%

        // Imprimir cada empleado con toString()
        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        // Mostrar total de empleados creados
        System.out.println("Total de empleados: " + Empleado.mostrarTotalEmpleados());
    }
    
}
