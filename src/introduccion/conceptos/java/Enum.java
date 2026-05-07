package introduccion.conceptos.java;

enum Dias { LUNES, MARTES, MIERCOLES }

public class Enum {
    public static void main(String[] args) {
        Dias hoy = Dias.LUNES;
        System.out.println("Hoy es: " + hoy);
    }
}
