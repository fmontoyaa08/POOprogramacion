package introduccion.conceptos.more_poo;

class Dispositivo {
    String marca = "Genérica";
    void encender() {
        System.out.println("El dispositivo se está encendiendo...");
    }
}

// 'extends' es la clave de la Herencia
public class Herencia extends Dispositivo {
    public void mostrarEjemplo() {
        System.out.println("Marca heredada: " + marca);
        encender();
    }
}
