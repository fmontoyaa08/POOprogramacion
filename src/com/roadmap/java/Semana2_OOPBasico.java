package com.roadmap.java;

/**
 * SEMANA 2: OBJECT ORIENTED PROGRAMMING (PARTE 1)
 * Contiene: Classes, Objects, Attributes, Methods, Access Specifiers,
 *           Static, Final, Nested Classes, Packages
 */
public class Semana2_OOPBasico {

    public static void main(String[] args) {
        System.out.println("=== SEMANA 2: PROGRAMACIÓN ORIENTADA A OBJETOS ===\n");
        
        // ===== 1. CLASES Y OBJETOS =====
        System.out.println("--- 1. CLASES Y OBJETOS ---");
        
        // Crear objetos (instancias de la clase Persona)
        Persona persona1 = new Persona("Ana", 25);
        Persona persona2 = new Persona("Carlos", 30);
        
        persona1.mostrarInfo();
        persona2.mostrarInfo();
        
        // ===== 2. ATRIBUTOS Y MÉTODOS =====
        System.out.println("\n--- 2. ATRIBUTOS Y MÉTODOS ---");
        
        persona1.setEdad(26);  // Usando método setter
        System.out.println("Nueva edad de " + persona1.getNombre() + ": " + persona1.getEdad());
        
        // ===== 3. ACCESS SPECIFIERS (public, private, protected) =====
        System.out.println("\n--- 3. ACCESS SPECIFIERS ---");
        
        EjemploAcceso ejemplo = new EjemploAcceso();
        ejemplo.probarAccesos();
        
        // ===== 4. STATIC KEYWORD =====
        System.out.println("\n--- 4. STATIC KEYWORD ---");
        
        // Los miembros static pertenecen a la CLASE, no a los objetos
        System.out.println("Contador de personas: " + Persona.getContadorPersonas());
        System.out.println("Valor de PI (static final): " + Constantes.PI);
        
        // ===== 5. FINAL KEYWORD =====
        System.out.println("\n--- 5. FINAL KEYWORD ---");
        
        final int DIAS_SEMANA = 7;  // No se puede modificar
        System.out.println("Días de la semana (final): " + DIAS_SEMANA);
        // DIAS_SEMANA = 8; // ❌ ERROR! No se puede reasignar
        
        // ===== 6. NESTED CLASSES (Clases anidadas) =====
        System.out.println("\n--- 6. NESTED CLASSES ---");
        
        // Static nested class
        Computadora.Procesador cpu = new Computadora.Procesador("Intel i7", 3.4);
        cpu.mostrarInfo();
        
        // Inner class (no estática) - necesita una instancia de la clase externa
        Computadora compu = new Computadora("Dell");
        Computadora.RAM memoria = compu.new RAM(16);
        memoria.mostrarInfo();
        
        // ===== 7. PACKAGES =====
        System.out.println("\n--- 7. PACKAGES ---");
        System.out.println("Este archivo está en el package: com.roadmap.java");
        System.out.println("Los packages organizan el código en carpetas jerárquicas");
        
        System.out.println("\n✅ SEMANA 2 COMPLETADA - Todos los conceptos OOP básicos cubiertos");
    }
}

// ==============================================
// CLASE PERSONA (demuestra atributos, métodos, encapsulamiento)
// ==============================================
class Persona {
    // Atributos (privados = encapsulados)
    private String nombre;
    private int edad;
    private static int contadorPersonas = 0;  // Static - compartido por todos los objetos
    
    // Constructor
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        contadorPersonas++;  // Incrementa cada vez que se crea una persona
    }
    
    // Métodos públicos (getters y setters)
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        if (edad > 0 && edad < 150) {  // Validación
            this.edad = edad;
        }
    }
    
    // Método static
    public static int getContadorPersonas() {
        return contadorPersonas;
    }
    
    // Método de instancia
    public void mostrarInfo() {
        System.out.println("Persona: " + nombre + ", Edad: " + edad);
    }
}

// ==============================================
// CLASE PARA DEMOSTRAR ACCESS SPECIFIERS
// ==============================================
class EjemploAcceso {
    public String publico = "Visible para todos";
    private String privado = "Visible solo dentro de esta clase";
    protected String protegido = "Visible en el mismo package y subclases";
    String defaultPackage = "Visible solo en el mismo package";
    
    public void probarAccesos() {
        System.out.println("Dentro de la misma clase:");
        System.out.println("  - Publico: " + publico);
        System.out.println("  - Privado: " + privado);      // ✅ Accesible
        System.out.println("  - Protegido: " + protegido);   // ✅ Accesible
        System.out.println("  - Default: " + defaultPackage); // ✅ Accesible
    }
}

// ==============================================
// CLASE CON MIEMBROS FINAL Y STATIC
// ==============================================
class Constantes {
    public static final double PI = 3.14159265359;
    public static final String MENSAJE_BIENVENIDA = "Bienvenido a Java OOP";
}

// ==============================================
// CLASE CON NESTED CLASSES (Clases anidadas)
// ==============================================
class Computadora {
    private String marca;
    
    public Computadora(String marca) {
        this.marca = marca;
    }
    
    // Static Nested Class (puede instanciarse sin la clase externa)
    static class Procesador {
        private String modelo;
        private double ghz;
        
        public Procesador(String modelo, double ghz) {
            this.modelo = modelo;
            this.ghz = ghz;
        }
        
        public void mostrarInfo() {
            System.out.println("Procesador: " + modelo + " @ " + ghz + "GHz");
        }
    }
    
    // Inner Class (no estática) - necesita una instancia de Computadora
    class RAM {
        private int capacidadGB;
        
        public RAM(int capacidadGB) {
            this.capacidadGB = capacidadGB;
        }
        
        public void mostrarInfo() {
            System.out.println("RAM: " + capacidadGB + "GB (Marca de la compu: " + marca + ")");
        }
    }
}