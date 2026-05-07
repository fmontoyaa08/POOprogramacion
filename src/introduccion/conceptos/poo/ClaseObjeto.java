package introduccion.conceptos.poo;

class Carro { String marca; }

public class ClaseObjeto {
    public static void main(String[] args) {
        Carro miCarro = new Carro();
        miCarro.marca = "Toyota";
        System.out.println("Marca: " + miCarro.marca);
    }
}
