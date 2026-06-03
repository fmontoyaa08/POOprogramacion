package com.roadmap.java;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * SEMANA 4: EXCEPTION HANDLING, LAMBDA EXPRESSIONS, ANNOTATIONS, OPTIONALS
 * Contiene: try/catch/finally/throw/throws, Lambdas, Annotations, Optionals
 */
public class Semana4_ExcepcionesLambdaOpcionales {

    public static void main(String[] args) {
        System.out.println("=== SEMANA 4: EXCEPCIONES, LAMBDA, ANOTACIONES, OPTIONALES ===\n");
        
        // ===== 1. EXCEPTION HANDLING =====
        System.out.println("--- 1. MANEJO DE EXCEPCIONES ---");
        
        // Try-catch básico
        try {
            int[] numeros = {1, 2, 3};
            System.out.println("Accediendo a posición 5: " + numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(" Error: Índice fuera del arreglo!");
        }
        
        // Try-catch con finally
        try {
            int resultado = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println(" Error: División entre cero!");
        } finally {
            System.out.println(" El bloque finally SIEMPRE se ejecuta");
        }
        
        // Throw - lanzar excepción manualmente
        try {
            validarEdad(15);
        } catch (IllegalArgumentException e) {
            System.out.println(" " + e.getMessage());
        }
        
        // Throws en método
        try {
            double division = dividir(10, 0);
        } catch (ArithmeticException e) {
            System.out.println(" Error en división: " + e.getMessage());
        }
        
        // ===== 2. LAMBDA EXPRESSIONS =====
        System.out.println("\n--- 2. LAMBDA EXPRESSIONS ---");
        
        // Lambda expression
        OperacionMatematica suma = (a, b) -> a + b;
        OperacionMatematica resta = (a, b) -> a - b;
        OperacionMatematica multiplicacion = (a, b) -> a * b;
        
        System.out.println("Lambda suma 5 + 3 = " + suma.operar(5, 3));
        System.out.println("Lambda resta 10 - 4 = " + resta.operar(10, 4));
        System.out.println("Lambda multiplicación 6 * 7 = " + multiplicacion.operar(6, 7));
        
        // Lambda con colecciones
        List<String> nombres = Arrays.asList("Ana", "Carlos", "Beatriz", "David", "Elena");
        
        System.out.print("Nombres: ");
        nombres.forEach(nombre -> System.out.print(nombre + " "));
        System.out.println();
        
        // Filtrar con lambda
        List<String> nombresLargos = nombres.stream()
            .filter(n -> n.length() > 4)
            .collect(Collectors.toList());
        System.out.println("Nombres con más de 4 letras: " + nombresLargos);
        
        // Predicate con lambda
        Predicate<String> empiezaConA = n -> n.startsWith("A");
        System.out.print("Nombres que empiezan con A: ");
        nombres.stream().filter(empiezaConA).forEach(n -> System.out.print(n + " "));
        System.out.println();
        
        // ===== 3. ANNOTATIONS =====
        System.out.println("\n--- 3. ANNOTATIONS ---");
        
        Perro miPerro = new Perro();
        miPerro.hacerSonido();
        
        MetodosObsoletos metodo = new MetodosObsoletos();
        metodo.metodoAntiguo();
        
        // ===== 4. OPTIONALS =====
        System.out.println("\n--- 4. OPTIONALS ---");
        
        // Optional vacío
        Optional<String> optionalVacio = Optional.empty();
        System.out.println("Optional vacío: " + optionalVacio);
        
        // Optional con valor
        Optional<String> optionalConValor = Optional.of("Hola Java");
        System.out.println("Optional con valor: " + optionalConValor.get());
        
        // Optional nullable
        Optional<String> optionalNull = Optional.ofNullable(puedeSerNull(false));
        System.out.println("Optional nullable (null): " + optionalNull);
        
        // Métodos útiles
        String valorPorDefecto = optionalNull.orElse("Valor por defecto");
        System.out.println("orElse: " + valorPorDefecto);
        
        optionalConValor.ifPresent(v -> System.out.println("ifPresent: " + v));
        
    }
    
    public static double dividir(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero");
        }
        return (double) a / b;
    }
    
    public static void validarEdad(int edad) {
        if (edad < 18) {
            throw new IllegalArgumentException("La edad debe ser mayor o igual a 18");
        }
        System.out.println("Edad válida: " + edad);
    }
    
    public static String puedeSerNull(boolean darValor) {
        if (darValor) {
            return "Tengo un valor";
        }
        return null;
    }
}

// ==============================================
// INTERFAZ FUNCIONAL
// ==============================================
@FunctionalInterface
interface OperacionMatematica {
    int operar(int a, int b);
}

// ==============================================
// CLASE CON @Override
// ==============================================
class Animal {
    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}

class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println(" El perro ladra: Guau guau!");
    }
}

// ==============================================
// CLASE CON @Deprecated
// ==============================================
class MetodosObsoletos {
    @Deprecated
    public void metodoAntiguo() {
        System.out.println(" Este método está obsoleto");
    }
}