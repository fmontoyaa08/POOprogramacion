package com.roadmap.java;

/**
 * INHERITANCE, ENCAPSULATION, METHOD OVERLOADING/OVERRIDING, STATIC VS DYNAMIC BINDING,
 * ABSTRACTION, INTERFACES, PASS BY VALUE VS PASS BY REFERENCE
 */
public class Inheritance_Encapsulation_Overloading_Overriding_Abstraction_Interfaces {

    public static void main(String[] args) {
        System.out.println("=== INHERITANCE, ENCAPSULATION, OVERLOADING/OVERRIDING, STATIC VS DYNAMIC BINDING, ABSTRACTION, INTERFACES, PASS BY VALUE ===\n");
        
        // ===== 1. ENCAPSULATION (Encapsulamiento) =====
        System.out.println("--- ENCAPSULATION ---");
        
        CuentaBancaria cuenta = new CuentaBancaria("123456", 1000);
        System.out.println("Saldo actual: Q" + cuenta.getSaldo());
        cuenta.depositar(500);
        System.out.println("Después de depositar: Q" + cuenta.getSaldo());
        cuenta.retirar(200);
        System.out.println("Después de retirar: Q" + cuenta.getSaldo());
        
        // ===== 2. INHERITANCE (Herencia) =====
        System.out.println("\n--- INHERITANCE ---");
        
        Vehiculo miCarro = new Coche("Toyota", "Corolla", 4);
        miCarro.mostrarInfo();
        
        Coche coche = new Coche("Honda", "Civic", 4);
        coche.mostrarInfo();
        coche.conducir();
        
        Moto moto = new Moto("Yamaha", "MT-07", true);
        moto.mostrarInfo();
        moto.hacerCaballito();
        
        // ===== 3. METHOD OVERLOADING (Sobrecarga) =====
        System.out.println("\n--- METHOD OVERLOADING ---");
        
        CalculadoraCalculos calc = new CalculadoraCalculos();
        System.out.println("Sumar 2 enteros: " + calc.sumar(5, 3));
        System.out.println("Sumar 3 enteros: " + calc.sumar(5, 3, 2));
        System.out.println("Sumar 2 double: " + calc.sumar(5.5, 3.2));
        System.out.println("Sumar int y double: " + calc.sumar(5, 3.5));
        
        // ===== 4. METHOD OVERRIDING (Sobrescritura) =====
        System.out.println("\n--- METHOD OVERRIDING ---");
        
        AnimalOverride animal = new AnimalOverride();
        PerroOverride perro = new PerroOverride();
        GatoOverride gato = new GatoOverride();
        
        animal.hacerSonido();
        perro.hacerSonido();
        gato.hacerSonido();
        
        AnimalOverride miMascota = new PerroOverride();
        miMascota.hacerSonido();
        
        // ===== 5. STATIC VS DYNAMIC BINDING =====
        System.out.println("\n--- STATIC VS DYNAMIC BINDING ---");
        
        System.out.println("Static binding - Método static: " + StaticDemo.saludarStatic());
        
        Figura fig1 = new Circulo();
        Figura fig2 = new Cuadrado();
        
        fig1.dibujar();
        fig2.dibujar();
        
        // ===== 6. ABSTRACTION (Clases abstractas) =====
        System.out.println("\n--- ABSTRACTION ---");
        
        Empleado ingeniero = new Ingeniero("Ana López", 5000, "Java");
        Empleado gerente = new Gerente("Carlos Ruiz", 8000, 10);
        
        ingeniero.trabajar();
        ingeniero.calcularBonificacion();
        gerente.trabajar();
        gerente.calcularBonificacion();
        
        // ===== 7. INTERFACES =====
        System.out.println("\n--- INTERFACES ---");
        
        Volador pajaro = new Pajaro();
        Volador avion = new Avion();
        Nadador pez = new Pez();
        
        pajaro.volar();
        avion.volar();
        pez.nadar();
        
        Ornitorrinco ornitorrinco = new Ornitorrinco();
        ornitorrinco.volar();
        ornitorrinco.nadar();
        ornitorrinco.caminar();
        
        Operacion operacion = (a, b) -> a + b;
        System.out.println("Lambda con interfaz funcional: 10 + 20 = " + operacion.calcular(10, 20));
        
        // ===== 8. PASS BY VALUE VS PASS BY REFERENCE =====
        System.out.println("\n--- PASS BY VALUE VS PASS BY REFERENCE ---");
        
        // Tipos primitivos
        System.out.println("\n1. Tipos primitivos (Pass by Value):");
        int numeroOriginal = 10;
        System.out.println("Antes: numeroOriginal = " + numeroOriginal);
        modificarPrimitivo(numeroOriginal);
        System.out.println("Después: numeroOriginal = " + numeroOriginal + " (NO cambió)");
        
        // Objetos
        System.out.println("\n2. Objetos (Pass by Value de la referencia):");
        PersonaRef persona = new PersonaRef("Ana", 25);
        System.out.println("Antes: " + persona);
        modificarObjeto(persona);
        System.out.println("Después: " + persona + " (SÍ cambió)");
        
        // Reasignar objeto
        System.out.println("\n3. Reasignar objeto (NO afecta al original):");
        PersonaRef otraPersona = new PersonaRef("Carlos", 30);
        System.out.println("Antes: " + otraPersona);
        reasignarObjeto(otraPersona);
        System.out.println("Después: " + otraPersona + " (NO cambió la referencia)");
        
        // Strings (inmutables)
        System.out.println("\n4. Strings (inmutables):");
        String textoOriginal = "Hola";
        System.out.println("Antes: " + textoOriginal);
        modificarString(textoOriginal);
        System.out.println("Después: " + textoOriginal + " (NO cambió)");
        
        // StringBuilder (mutable)
        System.out.println("\n5. StringBuilder (mutable):");
        StringBuilder sb = new StringBuilder("Java");
        System.out.println("Antes: " + sb);
        modificarStringBuilder(sb);
        System.out.println("Después: " + sb + " (SÍ cambió)");
        
        System.out.println("\n PROGRAMA COMPLETADO - Todos los conceptos cubiertos");
    }
    
    // Métodos para Pass by Value
    public static void modificarPrimitivo(int numero) {
        numero = 100;
        System.out.println("  Dentro del método: numero = " + numero);
    }
    
    public static void modificarObjeto(PersonaRef p) {
        p.setNombre("Laura");
        p.setEdad(30);
        System.out.println("  Dentro del método: " + p);
    }
    
    public static void reasignarObjeto(PersonaRef p) {
        p = new PersonaRef("Nuevo", 99);
        System.out.println("  Dentro del método (reasignado): " + p);
    }
    
    public static void modificarString(String texto) {
        texto = texto + " Mundo";
        System.out.println("  Dentro del método: " + texto);
    }
    
    public static void modificarStringBuilder(StringBuilder sb) {
        sb.append(" es genial!");
        System.out.println("  Dentro del método: " + sb);
    }
}

// ==============================================
// 1. ENCAPSULATION
// ==============================================
class CuentaBancaria {
    private String numeroCuenta;
    private double saldo;
    
    public CuentaBancaria(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }
    
    public double getSaldo() {
        return saldo;
    }
    
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso: +$" + monto);
        }
    }
    
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso: -$" + monto);
        } else {
            System.out.println("Saldo insuficiente");
        }
    }
}

// ==============================================
// 2. INHERITANCE
// ==============================================
class Vehiculo {
    protected String marca;
    protected String modelo;
    
    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    
    public void mostrarInfo() {
        System.out.println("Vehículo: " + marca + " " + modelo);
    }
}

class Coche extends Vehiculo {
    private int numPuertas;
    
    public Coche(String marca, String modelo, int numPuertas) {
        super(marca, modelo);
        this.numPuertas = numPuertas;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("Coche: " + marca + " " + modelo + ", Puertas: " + numPuertas);
    }
    
    public void conducir() {
        System.out.println("Conduciendo el coche...");
    }
}

class Moto extends Vehiculo {
    private boolean tieneCasco;
    
    public Moto(String marca, String modelo, boolean tieneCasco) {
        super(marca, modelo);
        this.tieneCasco = tieneCasco;
    }
    
    @Override
    public void mostrarInfo() {
        System.out.println("Moto: " + marca + " " + modelo + ", Casco: " + (tieneCasco ? "Sí" : "No"));
    }
    
    public void hacerCaballito() {
        System.out.println("Haciendo caballito con la moto!");
    }
}

// ==============================================
// 3. METHOD OVERLOADING
// ==============================================
class CalculadoraCalculos {
    public int sumar(int a, int b) {
        return a + b;
    }
    
    public int sumar(int a, int b, int c) {
        return a + b + c;
    }
    
    public double sumar(double a, double b) {
        return a + b;
    }
    
    public double sumar(int a, double b) {
        return a + b;
    }
}

// ==============================================
// 4. METHOD OVERRIDING
// ==============================================
class AnimalOverride {
    public void hacerSonido() {
        System.out.println("Animal hace un sonido genérico");
    }
}

class PerroOverride extends AnimalOverride {
    @Override
    public void hacerSonido() {
        System.out.println(" Perro: Guau guau!");
    }
}

class GatoOverride extends AnimalOverride {
    @Override
    public void hacerSonido() {
        System.out.println("Gato: Miau miau!");
    }
}

// ==============================================
// 5. STATIC VS DYNAMIC BINDING
// ==============================================
class StaticDemo {
    static String saludarStatic() {
        return "Hola desde método static (static binding)";
    }
}

abstract class Figura {
    abstract void dibujar();
}

class Circulo extends Figura {
    void dibujar() {
        System.out.println("Dibujando un círculo (dynamic binding)");
    }
}

class Cuadrado extends Figura {
    void dibujar() {
        System.out.println("Dibujando un cuadrado (dynamic binding)");
    }
}

// ==============================================
// 6. ABSTRACTION
// ==============================================
abstract class Empleado {
    protected String nombre;
    protected double salarioBase;
    
    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }
    
    public abstract void calcularBonificacion();
    
    public void trabajar() {
        System.out.println(nombre + " está trabajando");
    }
}

class Ingeniero extends Empleado {
    private String lenguaje;
    
    public Ingeniero(String nombre, double salarioBase, String lenguaje) {
        super(nombre, salarioBase);
        this.lenguaje = lenguaje;
    }
    
    @Override
    public void calcularBonificacion() {
        double bonificacion = salarioBase * 0.15;
        System.out.println(nombre + " (Ingeniero) bonificación: $" + bonificacion);
    }
}

class Gerente extends Empleado {
    private int numEmpleadosACargo;
    
    public Gerente(String nombre, double salarioBase, int numEmpleadosACargo) {
        super(nombre, salarioBase);
        this.numEmpleadosACargo = numEmpleadosACargo;
    }
    
    @Override
    public void calcularBonificacion() {
        double bonificacion = salarioBase * 0.25;
        System.out.println(nombre + " (Gerente) bonificación: $" + bonificacion);
    }
}

// ==============================================
// 7. INTERFACES
// ==============================================
interface Volador {
    void volar();
}

interface Nadador {
    void nadar();
}

class Pajaro implements Volador {
    @Override
    public void volar() {
        System.out.println("🐦 El pájaro vuela en el cielo");
    }
}

class Avion implements Volador {
    @Override
    public void volar() {
        System.out.println(" El avión vuela a 10,000 metros");
    }
}

class Pez implements Nadador {
    @Override
    public void nadar() {
        System.out.println(" El pez nada en el agua");
    }
}

class Ornitorrinco implements Volador, Nadador {
    @Override
    public void volar() {
        System.out.println(" El ornitorrinco no vuela realmente");
    }
    
    @Override
    public void nadar() {
        System.out.println(" El ornitorrinco nada muy bien");
    }
    
    public void caminar() {
        System.out.println(" El ornitorrinco camina en tierra");
    }
}

@FunctionalInterface
interface Operacion {
    int calcular(int a, int b);
}

// ==============================================
// 8. CLASE PARA PASS BY VALUE
// ==============================================
class PersonaRef {
    private String nombre;
    private int edad;
    
    public PersonaRef(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    
    @Override
    public String toString() {
        return nombre + " (" + edad + " años)";
    }
}