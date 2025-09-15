package ejercicio12;
import java.math.BigDecimal;

public class Ejercicio12 {

    public static void main(String[] args) {
        Contribuyente c = new Contribuyente("Mariana Suárez", "27-30111222-3");
        Impuesto imp = new Impuesto(new BigDecimal("150000.00"), c);

        Calculadora calc = new Calculadora();
        calc.calcular(imp);
    }
    
}
