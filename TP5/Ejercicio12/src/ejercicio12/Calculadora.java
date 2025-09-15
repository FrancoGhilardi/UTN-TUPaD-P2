package ejercicio12;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculadora {

    public void calcular(Impuesto impuesto) {
        BigDecimal base = impuesto.getMonto();
        BigDecimal tasa = new BigDecimal("0.21");
        BigDecimal total = base.multiply(tasa).setScale(2, RoundingMode.HALF_UP);

        System.out.println("== Liquidación ==");
        System.out.println("Contribuyente: " + impuesto.getContribuyente().getNombre()
                + " (CUIL " + impuesto.getContribuyente().getCuil() + ")");
        System.out.println("Base imponible: $" + base);
        System.out.println("Tasa aplicada : 21%");
        System.out.println("Impuesto a pagar: $" + total);
    }
}
