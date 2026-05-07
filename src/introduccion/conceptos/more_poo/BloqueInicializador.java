package introduccion.conceptos.more_poo;

public class BloqueInicializador {
    int carga;

    // Se ejecuta ANTES que el constructor
    {
        carga = 100;
        System.out.println("Bloque inicializador ejecutado.");
    }

    public BloqueInicializador() {
        System.out.println("Constructor ejecutado. Carga en: " + carga);
    }
}
