package parte2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    /**
     * Demostración de ejercicios de Excepciones (Parte 2). - 1) División segura
     * (ArithmeticException) - 2) Conversión String->int (NumberFormatException)
     * - 3) Lectura de archivo (FileNotFoundException) + finally - 4) Excepción
     * personalizada EdadInvalidaException - 5) try-with-resources con
     * BufferedReader (IOException)
     */
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8)) {
            System.out.println("== PARTE 2 :: EXCEPCIONES ==\n");

            divisionSegura(sc);                 // 1
            convertirCadenaANumero(sc);         // 2
            lecturaArchivoConFileNotFound(sc);  // 3
            validarEdadConExcepcion(sc);        // 4
            lecturaConTryWithResources(sc);     // 5

            System.out.println("\nFin de la demo de Parte 2.");
        }
    }

    // División segura - manejar ArithmeticException si divisor = 0
    private static void divisionSegura(Scanner sc) {
        System.out.println("\n[1] Division segura (int / int):");
        int a = pedirEntero(sc, "  - Ingresa el dividendo (int): ");
        int b = pedirEntero(sc, "  - Ingresa el divisor (int): ");
        try {
            int r = a / b; // si b == 0 → ArithmeticException
            System.out.printf("  Resultado: %d / %d = %d%n", a, b, r);
        } catch (ArithmeticException ex) {
            System.out.println("  Error: division por cero no permitida.");
        }
    }

    // Conversión de cadena a número - manejar NumberFormatException
    private static void convertirCadenaANumero(Scanner sc) {
        System.out.println("\n[2] Conversion de cadena a numero (int):");
        System.out.print("  - Ingresa un texto para parsear a int: ");
        String texto = sc.nextLine().trim();
        try {
            int n = Integer.parseInt(texto);
            System.out.printf("  OK: '%s' → %d%n", texto, n);
        } catch (NumberFormatException ex) {
            System.out.printf("  Error: '%s' no es un entero valido.%n", texto);
        }
    }

    // Lectura de archivo - manejar FileNotFoundException (y cerrar en finally)
    private static void lecturaArchivoConFileNotFound(Scanner sc) {
        System.out.println("\n[3] Lectura de archivo con manejo de FileNotFoundException:");
        System.out.print("  - Ruta del archivo a leer (modo simple): ");
        String ruta = sc.nextLine().trim();

        FileReader fr = null;
        try {
            fr = new FileReader(ruta, StandardCharsets.UTF_8);
            int c;
            System.out.println("  Contenido (primer metodo):");
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
            System.out.println();
        } catch (FileNotFoundException e) {
            System.out.printf("  Error: archivo no encontrado: %s%n", ruta);
        } catch (IOException e) {
            System.out.printf("  Error de E/S leyendo el archivo: %s%n", e.getMessage());
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException ignore) {
                }
            }
        }
    }

    // Excepción personalizada EdadInvalidaException
    private static void validarEdadConExcepcion(Scanner sc) {
        System.out.println("\n[4] Validacion de edad con excepcion personalizada (0..120):");
        int edad = pedirEntero(sc, "  - Ingresa una edad entera: ");
        try {
            validarEdad(edad);
            System.out.println("  Edad valida. 👍");
        } catch (EdadInvalidaException e) {
            System.out.printf("  Error de validacion: %s%n", e.getMessage());
        }
    }

    private static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad debe estar entre 0 y 120.");
        }
    }

    // try-with-resources con BufferedReader
    private static void lecturaConTryWithResources(Scanner sc) {
        System.out.println("\n[5] Lectura con try-with-resources (BufferedReader):");
        System.out.print("  - Ruta del archivo a leer (BufferedReader): ");
        String ruta = sc.nextLine().trim();

        try (BufferedReader br = Files.newBufferedReader(Path.of(ruta), StandardCharsets.UTF_8)) {
            System.out.println("  Contenido (segundo método):");
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            System.out.printf("  Error de E/S con try-with-resources: %s%n", e.getMessage());
        }
    }

    // Utilidad robusta para pedir enteros
    private static int pedirEntero(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String linea = sc.nextLine().trim();
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException ex) {
                System.out.println("  Valor invalido. Proba nuevamente con un entero.");
            }
        }
    }
}
