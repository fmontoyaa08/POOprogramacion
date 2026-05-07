package introduccion.conceptos.more_poo;

abstract class Animal {
    // Es solo una idea, cada animal lo hace distinto
    abstract void hacerSonido(); 
}

public class Abstraccion extends Animal {
    @Override
    void hacerSonido() {
        System.out.println("El perro ladra: ¡Guau!");
    }
}
