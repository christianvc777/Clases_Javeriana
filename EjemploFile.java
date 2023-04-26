import java.io.File;
import java.io.IOException;

public class EjemploFile {
    public static void main(String[] args) {
        // Crear un objeto File que representa el archivo que vamos a crear
        File archivo = new File("miArchivo.txt");
        
        try {
            // Crear el archivo utilizando el método createNewFile()
            boolean creado = archivo.createNewFile();
            
            if (creado) {
                System.out.println("El archivo ha sido creado.");
            } else {
                System.out.println("El archivo ya existe.");
            }
            
            // Obtener información del archivo
            System.out.println("Nombre del archivo: " + archivo.getName());
            System.out.println("Ruta del archivo: " + archivo.getAbsolutePath());
            System.out.println("Tamaño del archivo: " + archivo.length() + " bytes");
            System.out.println("Última modificación: " + new Date(archivo.lastModified()));
            
            // Renombrar el archivo utilizando el método renameTo()
            File archivoRenombrado = new File("miArchivoRenombrado.txt");
            boolean renombrado = archivo.renameTo(archivoRenombrado);
            
            if (renombrado) {
                System.out.println("El archivo ha sido renombrado.");
            } else {
                System.out.println("El archivo no ha sido renombrado.");
            }
            
            // Borrar el archivo utilizando el método delete()
            boolean borrado = archivoRenombrado.delete();
            
            if (borrado) {
                System.out.println("El archivo ha sido borrado.");
            } else {
                System.out.println("El archivo no ha sido borrado.");
            }
            
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error: " + e.getMessage());
        }
    }
}
