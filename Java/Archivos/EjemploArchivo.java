
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjemploArchivo {

    public static void main(String[] args) {
        File archivo = new File("archivo.txt"); // Crea el objeto de archivo
        Scanner scanner = new Scanner(System.in); // Crea el objeto Scanner para recibir entrada del usuario

        try {
            FileWriter escritor = new FileWriter(archivo); // Crea el objeto FileWriter para escribir en el archivo
            System.out.println("Escribe lo que quieras: ");
            String entrada = scanner.nextLine(); // Lee la entrada del usuario
            escritor.write(entrada); // Escribe la entrada en el archivo
            escritor.close(); // Cierra el escritor de archivo
            
            Scanner lector = new Scanner(archivo); // Crea el objeto Scanner para leer el archivo
            while (lector.hasNextLine()) { // Mientras haya una línea para leer
                String linea = lector.nextLine(); // Lee la siguiente línea del archivo
                
                if (linea.contains("18")) { // Verifica si la línea contiene la edad de Cristian
                    throw new IOException("Se ha encontrado al sujeto"); // Lanza una excepción
                }
            }

            lector = new Scanner(archivo); // Reinicia el objeto Scanner para leer el archivo desde el inicio
            System.out.println("Contenido del archivo:");
            while (lector.hasNextLine()) { // Mientras haya una línea para leer
                String linea = lector.nextLine(); // Lee la siguiente línea del archivo
                System.out.println(linea); // Imprime la línea en la consola
            }
            lector.close(); // Cierra el lector de archivo
        } catch (IOException e) { // Manejo de excepciones de entrada/salida
            System.out.println(e.getMessage()); // Imprime el mensaje de error en la consola
        }
    }
}

//Author: Cristian Vargas

