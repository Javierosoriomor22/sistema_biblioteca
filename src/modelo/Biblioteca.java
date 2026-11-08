package modelo;

import excepciones.LibroNoEncontradoException;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Libro> libros = new ArrayList<>();

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("--> Libro registrado correctamente.");
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la biblioteca.");
            return;
        }

        System.out.println("\n----- LISTADO DE LIBROS -----");
        int disponibles = 0;
        for (Libro l : libros) {
            l.mostrarInformacion();
            if (l.isDisponible()) {
                disponibles++;
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Total de libros: " + libros.size() + " | Disponibles para préstamo: " + disponibles);
    }

    public Libro buscarPorCodigo(int codigo) throws LibroNoEncontradoException {
        for (Libro l : libros) {
            if (l.getCodigo() == codigo) {
                return l;
            }
        }
        throw new LibroNoEncontradoException("El libro con el código " + codigo + " no fue encontrado.");
    }

    public void prestarLibro(int codigo) throws LibroNoEncontradoException {
        Libro libro = buscarPorCodigo(codigo);
        if (!libro.isDisponible()) {
            System.out.println("El libro '" + libro.getTitulo() + "' ya se encuentra prestado.");
        } else {
            libro.setDisponible(false);
            System.out.println("--> El libro '" + libro.getTitulo() + "' ha sido prestado con éxito.");
        }
    }
}