package com.roadmap.java;

public class Semana1_VariablesCasting {
    
    public static void main(String[] args) {
        System.out.println("=== SEMANA 1: VARIABLES Y TYPE CASTING ===\n");
        
        // ===== 1. VARIABLES =====
        System.out.println("--- VARIABLES ---");
        
        int edad = 25;
        double altura = 1.65;
        String nombre = "Fatima";
        boolean esActivo = true;
        
        System.out.println("int (entero): " + edad);
        System.out.println("double (decimal): " + altura);
        System.out.println("String (texto): " + nombre);
        System.out.println("boolean (verdadero/falso): " + esActivo);
        
        // ===== 2. SCOPE (ámbito de variables) =====
        System.out.println("\n--- SCOPE ---");
        
        // Variable local (solo existe dentro del main)
        int numeroLocal = 10;
        System.out.println("Variable local: " + numeroLocal);
        
        // Bloque de código con su propio scope
        {
            int variableDeBloque = 20;
            System.out.println("Variable dentro del bloque: " + variableDeBloque);
        }
        // System.out.println(variableDeBloque); // Esto daría error porque ya no existe
        
        // ===== 3. TYPE CASTING =====
        System.out.println("\n--- TYPE CASTING ---");
        
        int entero = 100;
        double decimal = entero;  // int → double automático
        System.out.println("Casting implícito (int→double): " + decimal);
        
        // Casting explícito (manual) - de grande a pequeño
        double precio = 99.99;
        int precioEntero = (int) precio;  // (int) fuerza la conversión
        System.out.println("Casting explícito (double→int): " + precioEntero + " (pierde los .99)");
        
        // Otro ejemplo de casting explícito
        char letra = 'A';
        int codigoAscii = (int) letra;
        System.out.println("Char 'A' → int: " + codigoAscii);
        
        System.out.println("\n✅ PROGRAMA FUNCIONANDO CORRECTAMENTE");
    }
}