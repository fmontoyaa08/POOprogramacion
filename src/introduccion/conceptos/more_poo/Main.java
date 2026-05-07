package introduccion.conceptos.more_poo;

public class Main {
    public static void main(String[] args) {
        
        // Probando Herencia
        System.out.println("--- Prueba Herencia ---");
        Herencia miHeredero = new Herencia();
        miHeredero.mostrarEjemplo();

        // Probando Abstracción
        System.out.println("\n--- Prueba Abstracción ---");
        Abstraccion miPerro = new Abstraccion();
        miPerro.hacerSonido();

        // Probando Bloque Inicializador
        System.out.println("\n--- Prueba Bloque Inicializador ---");
        BloqueInicializador objeto = new BloqueInicializador();
        
        // Probando Enums
        System.out.println("\n--- Prueba Enums ---");
        Enums misDias = new Enums();
        misDias.hoyEs();
    }
}