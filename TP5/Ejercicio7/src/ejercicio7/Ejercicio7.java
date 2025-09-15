package ejercicio7;

public class Ejercicio7 {

    public static void main(String[] args) {
        Motor m1 = new Motor("Nafta", "ENG-AB123");
        Vehiculo v = new Vehiculo("AB123CD", "Fiat Cronos", m1);
        Conductor c = new Conductor("Nicolás Varela", "B-904321");

        v.setConductor(c);

        System.out.println("Estado inicial:");
        System.out.println(v);
        System.out.println(c);

        v.setMotor(new Motor("Nafta", "ENG-XY999"));

        v.removeConductor();
        System.out.println("\nDespués de removeConductor():");
        System.out.println("v.getConductor() = " + v.getConductor());
        System.out.println("c.getVehiculo()  = " + c.getVehiculo());

        c.setVehiculo(v);
        System.out.println("\nReasignado:");
        System.out.println(v);
        System.out.println(c);
    }
    
}
