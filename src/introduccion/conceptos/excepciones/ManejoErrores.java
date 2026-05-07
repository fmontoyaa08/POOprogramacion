package introduccion.conceptos.excepciones;

import java.util.Scanner;

public class ManejoErrores {

    // 1. Aquí pones el método con la lógica de los errores
    public void probarManejo() {
        Scanner entrada = new Scanner(System.in);
        
        try {
            System.out.println("--- PRUEBA INDEPENDIENTE DE EXCEPCIONES ---");
            System.out.print("Escribe un número para dividir 100: ");
            int n = entrada.nextInt();
            System.out.println("Resultado: " + (100 / n));
            
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        } finally {
            System.out.println("Cerrando escáner y finalizando prueba.");
        }
    }

   
    public static void main(String[] args) {
        ManejoErrores ejecutor = new ManejoErrores();
        ejecutor.probarManejo();
    }
}