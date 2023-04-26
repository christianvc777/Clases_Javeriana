

/*

  Programación Avanzada - Java
  Ejercicio - Parcial #2
  Cristian Vargas Cuadros

*/

//Primer Fichero Carro.java

//Nota: Se compila solo la clase principal (Carro) en el Shell de Replit

public class Carro {
    public static void main(String[] args) {
        Vehiculo vehiculo1 = new Vehiculo("ABC123", "Toyota", 1400, 240, 4, "Diesel");
        Vehiculo vehiculo2 = new Vehiculo("DEF456", "Honda", 1600, 250, 5, "Gasolina");

        vehiculo1.imprimir();
        vehiculo2.imprimir();

        Vehiculo.compararMotores(vehiculo1, vehiculo2);
    }
}

//Segundo Fichero Motor.java

public class Motor {
    private int cilindrada;
    private double velocidadMax;
    private int caballosFuerza;
    private String tipoCombustible;
    
    public Motor(int cilindrada, double velocidadMax, int caballosFuerza, String tipoCombustible) {
        this.cilindrada = cilindrada;
        this.velocidadMax = velocidadMax;
        this.caballosFuerza = caballosFuerza;
        this.tipoCombustible = tipoCombustible;
    }
    
    public void imprimir() {
        System.out.println("Cilindrada: " + cilindrada);
        System.out.println("Velocidad Maxima: " + velocidadMax);
        System.out.println("Caballos de Fuerza: " + caballosFuerza);
        System.out.println("Tipo de Combustible: " + tipoCombustible);
    }
    
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    public void setVelocidadMax(double velocidadMax) {
        this.velocidadMax = velocidadMax;
    }
    
    public void setCaballosFuerza(int caballosFuerza) {
        this.caballosFuerza = caballosFuerza;
    }
    
    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }
    
    public int getCilindrada() {
        return cilindrada;
    }
    
    public double getVelocidadMax() {
        return velocidadMax;
    }
    
    public int getCaballosFuerza() {
        return caballosFuerza;
    }
    
    public String getTipoCombustible() {
        return tipoCombustible;
    }
}

//Tercer Fichero Vehiculo.java 


public class Vehiculo {
    private String placa;
    private String marca;
    private Motor motor;
    
    public Vehiculo(String placa, String marca) {
        this.placa = placa;
        this.marca = marca;
        this.motor = new Motor(0, 0.0, 0, "");
    }
    
    public Vehiculo(String placa, String marca, int cilindrada, double velocidadMax, int caballosFuerza, String tipoCombustible) {
        this.placa = placa;
        this.marca = marca;
        this.motor = new Motor(cilindrada, velocidadMax, caballosFuerza, tipoCombustible);
    }
    
    public void imprimir() {
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        motor.imprimir();
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getPlaca() {
        return placa;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public Motor getMotor() {
        return motor;
    }
    
// Método estático para comparar los motores de dos vehículos

    public static void compararMotores(Vehiculo vehiculo1, Vehiculo vehiculo2) {
        if (vehiculo1.getMotor().getCilindrada() > vehiculo2.getMotor().getCilindrada()) {
            System.out.println("El vehículo con placa " + vehiculo1.getPlaca() + " tiene un motor mejor que el vehículo con placa " + vehiculo2.getPlaca());
        } else if (vehiculo2.getMotor().getCilindrada() > vehiculo1.getMotor().getCilindrada()) {
            System.out.println("El vehículo con placa " + vehiculo2.getPlaca() + " tiene un motor mejor que el vehículo con placa " + vehiculo1.getPlaca());
        } else {
            System.out.println("Los vehículos con placas " + vehiculo1.getPlaca() + " y " + vehiculo2.getPlaca() + " tienen motores iguales");
        }
    }
}

//Author: Cristian Vargas Cuadros


