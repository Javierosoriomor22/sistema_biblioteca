import excepciones.LibroNoEncontradoException;
import java.util.Scanner;
import modelo.Biblioteca;
import modelo.Libro;
import modelo.LibroDigital;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        String[] categoriasDisponibles = {"Ficción", "Ciencia", "Historia", "Tecnología"};
        System.out.print("Categorías soportadas: ");
        for (int i = 0; i < categoriasDisponibles.length; i++) {
            System.out.print("[" + categoriasDisponibles[i] + "] ");
        }
        System.out.println("\n");

        int opcion = 0;
        do {
            System.out.println("=================================");
            System.out.println("      SISTEMA DE BIBLIOTECA      ");
            System.out.println("=================================");
            System.out.println("1. Registrar libro");
            System.out.println("2. Mostrar libros");
            System.out.println("3. Prestar libro");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.\n");
                continue;
            }

            switch (opcion) {
                case 1:
                    try {
                        System.out.print("Ingrese código del libro: ");
                        int codigo = Integer.parseInt(scanner.nextLine());

                        System.out.print("Ingrese título: ");
                        String titulo = scanner.nextLine();

                        System.out.print("Ingrese autor: ");
                        String autor = scanner.nextLine();

                        System.out.print("¿Es libro digital? (s/n): ");
                        String esDigital = scanner.nextLine();

                        if (esDigital.equalsIgnoreCase("s")) {
                            System.out.print("Ingrese tamaño en MB: ");
                            double tamanoMB = Double.parseDouble(scanner.nextLine());
                            biblioteca.agregarLibro(new LibroDigital(codigo, titulo, autor, tamanoMB));
                        } else {
                            biblioteca.agregarLibro(new Libro(codigo, titulo, autor));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error de entrada: Ingrese valores numéricos válidos en código o tamaño.");
                    }
                    break;

                case 2:
                    biblioteca.mostrarLibros();
                    break;

                case 3:
                    try {
                        System.out.print("Ingrese el código del libro a prestar: ");
                        int codigoPrestar = Integer.parseInt(scanner.nextLine());
                        biblioteca.prestarLibro(codigoPrestar);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Debe ingresar un código numérico.");
                    } catch (LibroNoEncontradoException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Gracias por usar el Sistema de Biblioteca.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (opcion != 4);

        scanner.close();
    }
}