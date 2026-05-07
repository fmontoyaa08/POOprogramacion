package introduccion.conceptos.basicos;

public class VariablesScope {
    static int variableGlobal = 10; // Scope de clase

    public static void main(String[] args) {
        int variableLocal = 5; // Scope local
        System.out.println("Suma: " + (variableGlobal + variableLocal));
    }
}