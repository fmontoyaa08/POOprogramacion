package com.roadmap.java;

import java.util.Scanner;

/**
 * SEMANA 3: CONDICIONALES, LOOPS Y BASES DE OOP
 * Contiene: if/else, switch, for, while, do-while, y aplicación práctica con OOP
 */
public class Semana3_CondicionalesLoops {

    public static void main(String[] args) {
        System.out.println("=== SEMANA 3: CONDICIONALES, LOOPS Y BASES DE OOP ===\n");
        
        // ===== 1. CONDICIONAL IF-ELSE =====
        System.out.println("--- 1. CONDICIONAL IF-ELSE ---");
        
        int nota = 85;
        
        if (nota >= 90) {
            System.out.println("Calificación: Excelente (A)");
        } else if (nota >= 80) {
            System.out.println("Calificación: Notable (B)");
        } else if (nota >= 70) {
            System.out.println("Calificación: Aprobado (C)");
        } else if (nota >= 60) {
            System.out.println("Calificación: Suficiente (D)");
        } else {
            System.out.println("Calificación: Reprobado (F)");
        }
        
        // Ejemplo con operador ternario (if compacto)
        int edad = 18;
        String mensaje = (edad >= 18) ? "Eres mayor de edad" : "Eres menor de edad";
        System.out.println("Operador ternario: " + mensaje);
        
        // ===== 2. CONDICIONAL SWITCH =====
        System.out.println("\n--- 2. CONDICIONAL SWITCH ---");
        
        int diaSemana = 3;
        String nombreDia;
        
        switch (diaSemana) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Miércoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            case 6:
                nombreDia = "Sábado";
                break;
            case 7:
                nombreDia = "Domingo";
                break;
            default:
                nombreDia = "Día inválido";
                break;
        }
        System.out.println("Día " + diaSemana + " es: " + nombreDia);
        
        // Switch moderno (Java 14+)
        String color = "ROJO";
        switch (color) {
            case "ROJO" -> System.out.println("Alto, no pasar");
            case "AMARILLO" -> System.out.println("Precaución");
            case "VERDE" -> System.out.println("Puede pasar");
            default -> System.out.println("Color no válido");
        }
        
        // ===== 3. LOOP FOR =====
        System.out.println("\n--- 3. LOOP FOR ---");
        
        // For clásico
        System.out.print("Números del 1 al 5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        // For con array
        String[] frutas = {"Manzana", "Banana", "Cereza", "Durazno"};
        System.out.print("Frutas: ");
        for (int i = 0; i < frutas.length; i++) {
            System.out.print(frutas[i] + " ");
        }
        System.out.println();
        
        // For-each (mejor para arrays)
        System.out.print("For-each: ");
        for (String fruta : frutas) {
            System.out.print(fruta + " ");
        }
        System.out.println();
        
        // ===== 4. LOOP WHILE =====
        System.out.println("\n--- 4. LOOP WHILE ---");
        
        int contador = 1;
        while (contador <= 3) {
            System.out.println("While - Iteración: " + contador);
            contador++;
        }
        
        // ===== 5. LOOP DO-WHILE (ejecuta al menos una vez) =====
        System.out.println("\n--- 5. LOOP DO-WHILE ---");
        
        int numero = 1;
        do {
            System.out.println("Do-while - Número: " + numero);
            numero++;
        } while (numero <= 3);
        
        // ===== 6. BREAK Y CONTINUE =====
        System.out.println("\n--- 6. BREAK Y CONTINUE ---");
        
        // Break - sale del loop
        System.out.print("Break al encontrar 3: ");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                break;
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // Continue - salta la iteración
        System.out.print("Continue (saltar el 3): ");
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();
        
        // ===== 7. APLICACIÓN PRÁCTICA CON OOP =====
        System.out.println("\n--- 7. APLICACIÓN PRÁCTICA: Sistema de Estudiantes ---");
        
        // Crear un estudiante usando nuestra clase
        Estudiante estudiante1 = new Estudiante("María López", "2024001", 85);
        Estudiante estudiante2 = new Estudiante("Carlos Ruiz", "2024002", 45);
        Estudiante estudiante3 = new Estudiante("Ana Martínez", "2024003", 92);
        
        estudiante1.mostrarInfo();
        estudiante2.mostrarInfo();
        estudiante3.mostrarInfo();
        
        // Calcular promedio de un grupo
        Estudiante[] grupo = {estudiante1, estudiante2, estudiante3};
        double promedio = CalcularPromedio(grupo);
        System.out.println("\nPromedio del grupo: " + String.format("%.2f", promedio));
        
        // Determinar estado del grupo
        if (promedio >= 70) {
            System.out.println("El grupo APROBÓ la materia");
        } else {
            System.out.println("El grupo REPROBÓ la materia");
        }
        
        System.out.println("\n--- DEMOSTRACIÓN INTERACTIVA  ---");
        menuSimulado();
        
        System.out.println("\n✅ SEMANA 3 COMPLETADA - Todos los conceptos de condicionales y loops cubiertos");
    }
    
    // Método para calcular promedio usando loop
    public static double CalcularPromedio(Estudiante[] estudiantes) {
        double suma = 0;
        for (Estudiante e : estudiantes) {
            suma += e.getNota();
        }
        return suma / estudiantes.length;
    }
    
    public static void menuSimulado() {
        System.out.println("===== MENÚ DE OPCIONES =====");
        System.out.println("1. Ver todos los estudiantes");
        System.out.println("2. Ver aprobados");
        System.out.println("3. Ver reprobados");
        System.out.println("4. Salir");
        System.out.println("(Este es un ejemplo - en un programa real usaríamos Scanner)");
        
        int opcion = 2;
        
        if (opcion == 1) {
            System.out.println("Mostrando todos los estudiantes...");
        } else if (opcion == 2) {
            System.out.println("Mostrando solo aprobados...");
        } else if (opcion == 3) {
            System.out.println("Mostrando solo reprobados...");
        } else {
            System.out.println("Saliendo del sistema...");
        }
    }
}
class Estudiante {
    private String nombre;
    private String carnet;
    private double nota;
    
    public Estudiante(String nombre, String carnet, double nota) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.nota = nota;
    }
    
    public String getNombre() { return nombre; }
    public String getCarnet() { return carnet; }
    public double getNota() { return nota; }
    
    public void setNota(double nota) {
        if (nota >= 0 && nota <= 100) {
            this.nota = nota;
        }
    }
    
    public String obtenerEstado() {
        // Usando condicional para determinar estado
        if (nota >= 70) {
            return "APROBADO";
        } else if (nota >= 60) {
            return "EN RECUPERACIÓN";
        } else {
            return "REPROBADO";
        }
    }
    
    public String obtenerLetraCalificacion() {
        int rango = (int) nota / 10;
        return switch (rango) {
            case 10, 9 -> "A";
            case 8 -> "B";
            case 7 -> "C";
            case 6 -> "D";
            default -> "F";
        };
    }
    
    public void mostrarInfo() {
        System.out.println("📚 " + nombre + " | Carnet: " + carnet + 
                           " | Nota: " + nota + " | " + obtenerEstado() + 
                           " | Calificación: " + obtenerLetraCalificacion());
    }
}