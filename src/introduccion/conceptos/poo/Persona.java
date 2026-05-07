package introduccion.conceptos.poo;
public class Persona {

    // 2. ATRIBUTOS (Attributes / Instance Variables)
    // Usamos 'private' para seguir la buena práctica de encapsulamiento
    private String nombre;
    private int edad;
    private double estatura;

    // 3. CONSTRUCTOR (Método especial para crear el objeto)
    public Persona(String nombre, int edad, double estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }

    // 4. MÉTODOS (Methods / Behaviors)
    
    // Método que no retorna nada (void) y realiza una acción
    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años.");
    }

    // Método que retorna un valor (double)
    public double obtenerEstaturaEnCentimetros() {
        return estatura * 100;
    }

    // Métodos Getter y Setter (son métodos para acceder a los atributos privados)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
