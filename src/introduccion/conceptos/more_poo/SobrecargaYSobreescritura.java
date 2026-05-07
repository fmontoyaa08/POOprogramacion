package introduccion.conceptos.more_poo;

public class SobrecargaYSobreescritura {
    // SOBRECARGA: Mismo nombre, distintos datos
    void saludar(String nombre) { System.out.println("Hola " + nombre); }
    void saludar(String nombre, String titulo) { System.out.println("Hola " + titulo + " " + nombre); }

    // SOBRESCRITURA: Cuando usas @Override (como vimos en Abstracción)
}