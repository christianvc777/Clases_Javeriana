/********************************************************
    Nombre: Cristian Vargas Cuadros
    Taller - Clases Abstractas y Polimorfismo
    Programación Avanzada
*********************************************************/

import java.util.ArrayList;
import java.util.Scanner;

// Clase abstracta que representa un producto electrónico
abstract class ProductoElectronico {
  protected String nombre;
  protected double precio;
  protected int garantia;

  // Constructor de la clase ProductoElectronico
  public ProductoElectronico(String nombre, double precio, int garantia) {
    this.nombre = nombre;
    this.precio = precio;
    this.garantia = garantia;
  }

  // Método para obtener el nombre del producto
  public String getNombre() {
    return nombre;
  }

  // Método para obtener el precio del producto
  public double getPrecio() {
    return precio;
  }

  // Método para obtener la garantía del producto
  public int getGarantia() {
    return garantia;
  }

  // Método abstracto que debe ser implementado por las subclases
  public abstract void cargar();
}

// Clase que representa un celular, subclase de ProductoElectronico
class Celular extends ProductoElectronico {
  private String marca;

  // Constructor de la clase Celular
  public Celular(String nombre, double precio, int garantia, String marca) {
    super(nombre, precio, garantia);
    this.marca = marca;
  }

  // Método para obtener la marca del celular
  public String getMarca() {
    return marca;
  }

  // Implementación del método abstracto cargar() de ProductoElectronico
  @Override
  public void cargar() {
    System.out.println("Cargando el celular " + nombre + " de la marca " + marca);
    // Lógica para cargar el celular
  }

  // Método específico de Celular para enviar mensajes
  public void enviarMensaje() {
    System.out.println("Enviando mensaje desde el celular " + nombre + " de la marca " + marca);
    // Lógica para enviar mensaje
  }

  // Método específico de Celular para hacer llamadas
  public void hacerLlamada() {
    System.out.println("Realizando llamada desde el celular " + nombre + " de la marca " + marca);
    // Lógica para hacer llamada
  }
}

// Clase que representa una computadora, subclase de ProductoElectronico
class Computadora extends ProductoElectronico {
  private String sistemaOperativo;

  // Constructor de la clase Computadora
  public Computadora(String nombre, double precio, int garantia, String sistemaOperativo) {
    super(nombre, precio, garantia);
    this.sistemaOperativo = sistemaOperativo;
  }

  // Método para obtener el sistema operativo de la computadora
  public String getSistemaOperativo() {
    return sistemaOperativo;
  }

  // Implementación del método abstracto cargar() de ProductoElectronico
  @Override
  public void cargar() {
    System.out.println("Cargando la computadora " + nombre + " con sistema operativo " + sistemaOperativo);
    // Lógica para cargar la computadora
  }

  // Método específico de Computadora para iniciar sesión
  public void iniciarSesion() {
    System.out.println("Iniciando sesión en la computadora " + nombre + " con sistema operativo " + sistemaOperativo);
    // Lógica para iniciar sesión
  }


  // Método específico de Computadora para apagar la computadora
public void apagar() {
System.out.println("Apagando la computadora " + nombre + " con sistema operativo " + sistemaOperativo);
// Lógica para apagar la computadora
}
}

// Clase principal TiendaElectronica que contiene el método main
public class TiendaElectronica {
  public static void main(String[] args) {

    //Crear un arraylist tipo ProductoElectronico
    ArrayList<ProductoElectronico> productos = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    //Menu Principal
    int opcion = 0;
    while (opcion != 3) {
      System.out.println("---- Tienda Electronica ----");
      System.out.println("1. Agregar producto");
      System.out.println("2. Recorrer lista de productos");
      System.out.println("3. Salir");
      System.out.print("Ingrese una opcion: ");
      opcion = scanner.nextInt();

      switch (opcion) {
    case 1:
        System.out.println("--- Agregar producto ---");
        System.out.print("Ingrese el nombre del producto: ");
        scanner.nextLine(); // Consumir el carácter de nueva línea
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la garantia del producto: ");
        int garantia = scanner.nextInt();

        System.out.println("Tipo de productos:");
        System.out.println("1. Celular");
        System.out.println("2. Computadora");
        System.out.print("Seleccione el tipo de producto: ");
        int tipoProducto = scanner.nextInt();

        scanner.nextLine(); // Consumir el carácter de nueva línea

        //Switch case dependiendo de tipoProducto
        switch (tipoProducto) {
            //Agregar propiedades de cada tipoProducto
            case 1:
                System.out.print("Ingrese la marca del celular: ");
                String marcaCelular = scanner.nextLine();
                Celular celular = new Celular(nombre, precio, garantia, marcaCelular);
                productos.add(celular);
                break;
            case 2:
                System.out.print("Ingrese el sistema operativo de la computadora: ");
                String sistemaOperativo = scanner.nextLine();
                Computadora computadora = new Computadora(nombre, precio, garantia, sistemaOperativo);
                productos.add(computadora);
                break;
            default:
                System.out.println("Opcion invalida");
                break;
          }
          break;
        case 2:
            //Imprimir la lista productos
          System.out.println("--- Recorrer lista de productos ---");
          for (ProductoElectronico producto : productos) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: $" + producto.getPrecio());
            System.out.println("Garantia: " + producto.getGarantia() + " meses");
            producto.cargar();
            
            //Metodo de cada tipoProducto 
            if (producto instanceof Celular) {
              Celular celular = (Celular) producto;
              celular.enviarMensaje();
              celular.hacerLlamada();
            } else if (producto instanceof Computadora) {
              Computadora computadora = (Computadora) producto;
              computadora.iniciarSesion();
              computadora.apagar();
            }

            System.out.println("--------------------");
          }
          break;
        case 3:
          System.out.println("\n¡Esperamos que vuelvas pronto!");
          System.out.println("Saliendo del programa...");
          System.out.println("\nAuthor: Cristian Vargas");
          break;
        default:
          System.out.println("Opcion invalida");
          break;
      }
    }
  }
}

 
