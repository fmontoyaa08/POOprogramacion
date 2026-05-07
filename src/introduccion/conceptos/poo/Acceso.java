package introduccion.conceptos.poo;

public class Acceso {
    private String datoPrivado = "Secreto";
    public String datoPublico = "Abierto";

    public static void main(String[] args) {
        Acceso a = new Acceso();
        System.out.println("Solo puedo ver lo " + a.datoPublico);
    }
}
