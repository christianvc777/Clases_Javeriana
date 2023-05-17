import java.util.Date;  // importar la clase Date

public class EjemploDate {
    public static void main(String[] args) {
        // crear una nueva instancia de Date, que representa la fecha y hora actual
        Date fechaActual = new Date();
        System.out.println("Fecha actual: " + fechaActual); // imprime la fecha actual
        
        // crear una instancia de Date para una fecha específica
        Date miCumple = new Date(96, 11, 28); // año 96, diciembre (11), día 28
        System.out.println("Mi cumpleaños: " + miCumple); // imprime mi cumpleaños
        
        // obtener la fecha y hora en milisegundos
        long tiempoActual = fechaActual.getTime();
        System.out.println("Tiempo actual en milisegundos: " + tiempoActual);
        
        // crear una instancia de Date a partir de milisegundos
        long milisegundos = 1619123239000L;
        Date fecha = new Date(milisegundos);
        System.out.println("Fecha a partir de milisegundos: " + fecha); // imprime la fecha correspondiente
        
        // comparar dos fechas
        if (miCumple.before(fechaActual)) {
            System.out.println("Mi cumpleaños ya pasó este año");
        } else {
            System.out.println("Aún no ha pasado mi cumpleaños este año");
        }
    }
}
