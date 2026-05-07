package introduccion.conceptos.more_poo;

public class Enums {
    // Para valores que no cambian, como los días o estados
    public enum Dias { LUNES, MARTES, MIERCOLES, JUEVES, VIERNES }

    public void hoyEs() {
        Dias diaActual = Dias.VIERNES;
        System.out.println("Hoy toca estudiar: " + diaActual);
    }
}