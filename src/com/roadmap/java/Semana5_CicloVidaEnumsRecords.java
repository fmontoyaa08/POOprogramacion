package com.roadmap.java;

/**
 * SEMANA 5: OBJECT LIFECYCLE, ENUMS, METHOD CHAINING, RECORD, INITIALIZE BLOCK
 * Contiene: Ciclo de vida de objetos, Enumeraciones, Method Chaining,
 *           Records (Java 14+), Bloques de inicialización (static y instance)
 */
public class Semana5_CicloVidaEnumsRecords {

    public static void main(String[] args) {
        System.out.println("=== SEMANA 5: CICLO DE VIDA, ENUMS, RECORDS, METHOD CHAINING ===\n");
        
        // ===== 1. OBJECT LIFECYCLE (Ciclo de vida de objetos) =====
        System.out.println("--- 1. CICLO DE VIDA DE OBJETOS ---");
        
        // Creación del objeto (constructor)
        System.out.println("Creando objeto PersonaVida...");
        PersonaVida persona = new PersonaVida("Lucía", 28);
        
        // Uso del objeto
        persona.saludar();
        
        // Sugerir al garbage collector (no garantiza ejecución inmediata)
        persona = null;
        System.gc(); // Sugiere que JVM ejecute el garbage collector
        
        try {
            Thread.sleep(100); // Pequeña pausa para ver el mensaje
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // ===== 2. ENUMS (Enumeraciones) =====
        System.out.println("\n--- 2. ENUMS ---");
        
        // Usar enum Día
        DiaSemana hoy = DiaSemana.MIERCOLES;
        System.out.println("Hoy es: " + hoy);
        System.out.println("¿Es fin de semana? " + hoy.esFinDeSemana());
        
        // Usar enum con valores personalizados
        NivelUsuario nivel = NivelUsuario.ADMIN;
        System.out.println("Nivel: " + nivel);
        System.out.println("Descripción: " + nivel.getDescripcion());
        System.out.println("Permisos: " + nivel.getPermisos());
        
        // Recorrer todos los valores del enum
        System.out.println("\nTodos los niveles de usuario:");
        for (NivelUsuario n : NivelUsuario.values()) {
            System.out.println("  - " + n + ": " + n.getDescripcion());
        }
        
        // ===== 3. METHOD CHAINING (Encadenamiento de métodos) =====
        System.out.println("\n--- 3. METHOD CHAINING ---");
        
        // Forma tradicional (sin chaining)
        Calculadora calc = new Calculadora();
        calc.sumar(5);
        calc.multiplicar(2);
        calc.restar(3);
        System.out.println("Resultado tradicional: " + calc.getResultado());
        
        // Con method chaining (encadenado)
        int resultado = new CalculadoraChaining()
            .sumar(5)
            .multiplicar(2)
            .restar(3)
            .dividir(2)
            .getResultado();
        System.out.println("Resultado con chaining: " + resultado);
        
        // Ejemplo con StringBuilder (usa method chaining internamente)
        String texto = new StringBuilder()
            .append("Hola ")
            .append("mundo ")
            .append("desde ")
            .append("Java!")
            .toString();
        System.out.println("StringBuilder con chaining: " + texto);
        
        // ===== 4. RECORD (Java 14+ - clases inmutables simplificadas) =====
        System.out.println("\n--- 4. RECORD ---");
        
        // Crear un record (no necesita constructores ni getters manuales)
        Punto punto = new Punto(10, 20);
        PersonaRecord personaRecord = new PersonaRecord("Carlos", "carlos@email.com", 30);
        
        System.out.println("Punto: " + punto);
        System.out.println("Coordenada X: " + punto.x());
        System.out.println("Coordenada Y: " + punto.y());
        
        System.out.println("\nPersonaRecord: " + personaRecord);
        System.out.println("Nombre: " + personaRecord.nombre());
        System.out.println("Email: " + personaRecord.email());
        
        // Los records ya tienen equals, hashCode y toString automáticos
        Punto punto1 = new Punto(5, 5);
        Punto punto2 = new Punto(5, 5);
        System.out.println("\n¿punto1.equals(punto2)? " + punto1.equals(punto2));
        
        // ===== 5. INITIALIZE BLOCKS (Bloques de inicialización) =====
        System.out.println("\n--- 5. INITIALIZE BLOCKS ---");
        
        System.out.println("Creando primera instancia de EjemploBloques:");
        EjemploBloques ejemplo1 = new EjemploBloques();
        
        System.out.println("\nCreando segunda instancia de EjemploBloques:");
        EjemploBloques ejemplo2 = new EjemploBloques(99);
        
        // ===== 6. MÁS SOBRE OOP (repaso integrado) =====
        System.out.println("\n--- 6. APLICACIÓN INTEGRADA ---");
        
        // Usando enum en una aplicación real
        Pedido pedido = new Pedido("Cliente1", EstadoPedido.PAGADO);
        System.out.println("Pedido: " + pedido.getCliente());
        System.out.println("Estado: " + pedido.getEstado());
        
        if (pedido.getEstado() == EstadoPedido.PAGADO) {
            System.out.println(" El pedido puede ser enviado");
        } else if (pedido.getEstado() == EstadoPedido.ENTREGADO) {
            System.out.println(" El pedido ya fue entregado");
        }
        
    }
}

// ==============================================
// 1. OBJECT LIFECYCLE - Demo de ciclo de vida
// ==============================================
class PersonaVida {
    private String nombre;
    private int edad;
    
    // Constructor
    public PersonaVida(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        System.out.println(" Constructor: Se creó el objeto " + nombre);
    }
    
    public void saludar() {
        System.out.println("Hola, soy " + nombre + " y tengo " + edad + " años");
    }
    
    // Finalize (deprecado pero útil para demostrar el ciclo)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize: El objeto " + nombre + " está siendo destruido");
        super.finalize();
    }
}

// ==============================================
// 2. ENUMS - Enumeraciones
// ==============================================
enum DiaSemana {
    LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO;
    
    public boolean esFinDeSemana() {
        return this == SABADO || this == DOMINGO;
    }
}

// Enum con atributos y métodos personalizados
enum NivelUsuario {
    BASICO("Usuario básico", "Leer contenido"),
    MEDIO("Usuario medio", "Leer y comentar"),
    AVANZADO("Usuario avanzado", "Leer, comentar y crear"),
    ADMIN("Administrador", "Todos los permisos");
    
    private String descripcion;
    private String permisos;
    
    NivelUsuario(String descripcion, String permisos) {
        this.descripcion = descripcion;
        this.permisos = permisos;
    }
    
    public String getDescripcion() { return descripcion; }
    public String getPermisos() { return permisos; }
}

// ==============================================
// 3. METHOD CHAINING - Encadenamiento de métodos
// ==============================================
class Calculadora {
    private int resultado = 0;
    
    public void sumar(int valor) { resultado += valor; }
    public void restar(int valor) { resultado -= valor; }
    public void multiplicar(int valor) { resultado *= valor; }
    public int getResultado() { return resultado; }
}

class CalculadoraChaining {
    private int resultado = 0;
    
    public CalculadoraChaining sumar(int valor) {
        resultado += valor;
        return this;  // Devuelve la propia instancia
    }
    
    public CalculadoraChaining restar(int valor) {
        resultado -= valor;
        return this;
    }
    
    public CalculadoraChaining multiplicar(int valor) {
        resultado *= valor;
        return this;
    }
    
    public CalculadoraChaining dividir(int valor) {
        if (valor != 0) resultado /= valor;
        return this;
    }
    
    public int getResultado() {
        return resultado;
    }
}

// ==============================================
// 4. RECORD - Clases inmutables simplificadas
// ==============================================
record Punto(int x, int y) {}

record PersonaRecord(String nombre, String email, int edad) {}

// ==============================================
// 5. INITIALIZE BLOCKS - Bloques de inicialización
// ==============================================
class EjemploBloques {
    private int valor;
    private static int contadorInstancias = 0;
    
    // Bloque de inicialización STATIC (se ejecuta UNA vez cuando se carga la clase)
    static {
        System.out.println("  Bloque static: La clase se ha cargado");
        contadorInstancias = 0;
    }
    
    // Bloque de inicialización de INSTANCIA (se ejecuta CADA vez antes del constructor)
    {
        System.out.println("  Bloque instance: Inicializando nueva instancia");
        this.valor = 10; // valor por defecto
        contadorInstancias++;
        System.out.println("  Instancias creadas: " + contadorInstancias);
    }
    
    // Constructores
    public EjemploBloques() {
        System.out.println("  Constructor sin parámetros: valor = " + valor);
    }
    
    public EjemploBloques(int valor) {
        this.valor = valor;
        System.out.println("  Constructor con parámetros: valor = " + this.valor);
    }
}

// ==============================================
// 6. ENUM para aplicación práctica
// ==============================================
enum EstadoPedido {
    PENDIENTE, PAGADO, ENVIADO, ENTREGADO, CANCELADO
}

class Pedido {
    private String cliente;
    private EstadoPedido estado;
    
    public Pedido(String cliente, EstadoPedido estado) {
        this.cliente = cliente;
        this.estado = estado;
    }
    
    public String getCliente() { return cliente; }
    public EstadoPedido getEstado() { return estado; }
}