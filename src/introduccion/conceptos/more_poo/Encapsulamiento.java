package introduccion.conceptos.more_poo;

public class Encapsulamiento {
    // Atributos privados para que nadie los modifique directamente
    private String contraseñaSegura = "Admin123";

    public String getContraseña() {
        return contraseñaSegura;
    }

    public void setContraseña(String nueva) {
        this.contraseñaSegura = nueva;
    }
}
