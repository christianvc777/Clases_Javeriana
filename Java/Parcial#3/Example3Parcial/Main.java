/********************************************************
Programación Avanzada
Parcial 3 - Aplicación (Analisis de Datos)
Fecha: 19 de Mayo 2023
Estudiante: Cristian Vargas Cuadros
*********************************************************/

import java.util.ArrayList;

//Clase abstracta ConjuntoDeDatos
abstract class ConjuntoDeDatos {
    protected String nombre;
    protected int tamaño;

    //Constructor de ConjuntoDeDatos
    public ConjuntoDeDatos(String nombre, int tamaño) {
        this.nombre = nombre;
        this.tamaño = tamaño;
    }

    //Getters y Setters de ConjuntoDeDatos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    //Metodo abstracto describir
    public abstract String describir();
}

// Clase ConjuntoDeDatosTabular
class ConjuntoDeDatosTabular extends ConjuntoDeDatos {
    private int numeroDeColumnas;
    private int numeroDeFilas;

    //Constructor de ConjuntoDeDatosTabular
    public ConjuntoDeDatosTabular(String nombre, int tamaño, int numeroDeColumnas, int numeroDeFilas) {
        super(nombre, tamaño);
        this.numeroDeColumnas = numeroDeColumnas;
        this.numeroDeFilas = numeroDeFilas;
    }

    //Getters y Setters de ConjuntoDeDatosTabular
    public int getNumeroDeColumnas() {
        return numeroDeColumnas;
    }

    public void setNumeroDeColumnas(int numeroDeColumnas) {
        this.numeroDeColumnas = numeroDeColumnas;
    }

    public int getNumeroDeFilas() {
        return numeroDeFilas;
    }

    public void setNumeroDeFilas(int numeroDeFilas) {
        this.numeroDeFilas = numeroDeFilas;
    }

    //Sobreescribir el metodo describir para ConjuntoDeDatosTabular
    @Override
    public String describir() {
        return "Nombre: " + getNombre() + "\n" +
                "Tamaño: " + getTamaño() + "\n" +
                "Tipo: Tabular" + "\n" +
                "Filas: " + numeroDeFilas + "\n" +
                "Columnas: " + numeroDeColumnas;
    }
}

// Clase ConjuntoDeDatosImagen
class ConjuntoDeDatosImagen extends ConjuntoDeDatos {
    private int ancho;
    private int alto;

    //Constructor de ConjuntoDeDatosImagen
    public ConjuntoDeDatosImagen(String nombre, int tamaño, int ancho, int alto) {
        super(nombre, tamaño);
        this.ancho = ancho;
        this.alto = alto;
    }

    //Getters y Setters de ConjuntoDeDatosImagen
    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    //Sobreescribir el metodo describir para ConjuntoDeDatosImagen
    @Override
    public String describir() {
        return "Nombre: " + getNombre() + "\n" +
                "Tamaño: " + getTamaño() + "\n" +
                "Tipo: Imagen" + "\n" +
                "Resolucion Horizontal: " + ancho + "\n" +
                "Resolucion Vertical: " + alto;
    }
}

// Clase AnalizadorDeDatos
class AnalizadorDeDatos {
  private ArrayList<ConjuntoDeDatos> conjuntosDeDatos;

  //Constructor de AnalizadorDeDatos
  public AnalizadorDeDatos() {
    conjuntosDeDatos = new ArrayList<>();
  }

  //Metodo añadir de AnalizadorDeDatos
  public void añadirConjuntoDeDatos(ConjuntoDeDatos conjuntoDeDatos) {
    conjuntosDeDatos.add(conjuntoDeDatos);
  }

    //Metodo eliminar de AnalizadorDeDatos
  public void eliminarConjuntoDeDatos(String nombre) {
    for (int i = 0; i < conjuntosDeDatos.size(); i++) {
      ConjuntoDeDatos conjunto = conjuntosDeDatos.get(i);
      if (conjunto.nombre.equals(nombre)) {
        conjuntosDeDatos.remove(i);
        break;
      }
    }
  }

  //Metodo para retornar la lista conjuntosDeDatos
  public ArrayList<String> describirConjuntosDeDatos() {
    ArrayList<String> descripciones = new ArrayList<>();
    for (ConjuntoDeDatos conjunto : conjuntosDeDatos) {
      descripciones.add(conjunto.describir());
    }
    return descripciones;
  }
}

// Clase principal (Main) para validar el funcionamiento
public class Main {
  public static void main(String[] args) {
      
    System.out.println("\nAplicacion - Analisis de Datos\n");
     
    // Crear instancias de conjuntos de datos
    ConjuntoDeDatosTabular conjuntoTabular1 = new ConjuntoDeDatosTabular("Datos de estudiantes", 1000, 5, 200);
    ConjuntoDeDatosImagen conjuntoImagen1 = new ConjuntoDeDatosImagen("Imágenes de satélite", 2000, 1080, 720);
    ConjuntoDeDatosImagen conjuntoImagen2 = new ConjuntoDeDatosImagen("Imágenes de satélite", 2000, 1080, 720);

    // Crear instancia de AnalizadorDeDatos
    AnalizadorDeDatos analizador = new AnalizadorDeDatos();

    // Añadir conjuntos de datos al analizador
    analizador.añadirConjuntoDeDatos(conjuntoTabular1);
    analizador.añadirConjuntoDeDatos(conjuntoImagen1);
    analizador.añadirConjuntoDeDatos(conjuntoImagen2);

    // Describir los conjuntos de datos
    ArrayList<String> descripciones = analizador.describirConjuntosDeDatos();

    // Imprimir las descripciones
    for (String descripcion : descripciones) {
      System.out.println(descripcion);
      System.out.println("------------------------------");
    }
    System.out.println("\nAuthor: Cristian Vargas");
  }
}


