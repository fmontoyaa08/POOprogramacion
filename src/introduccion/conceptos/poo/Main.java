package introduccion.conceptos.poo;

public class Main {
    public static void main(String[] args) {
        // Creamos una instancia (objeto) de la clase Persona
        Persona estudiante = new Persona("Fatima", 25, 1.65);

        // Accedemos a un método
        estudiante.saludar();

        // Usamos un método que devuelve un valor
        double cm = estudiante.obtenerEstaturaEnCentimetros();
        System.out.println("Mi estatura en cm es: " + cm);
    }
}