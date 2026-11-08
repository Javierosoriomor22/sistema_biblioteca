package modelo;

public class LibroDigital extends Libro {
    private double tamanoMB;

    public LibroDigital(int codigo, String titulo, String autor, double tamanoMB) {
        super(codigo, titulo, autor);
        this.tamanoMB = tamanoMB;
    }

    public double getTamanoMB() { return tamanoMB; }
    public void setTamanoMB(double tamanoMB) { this.tamanoMB = tamanoMB; }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("   [Formato: Digital | Tamaño: " + tamanoMB + " MB]");
    }
}