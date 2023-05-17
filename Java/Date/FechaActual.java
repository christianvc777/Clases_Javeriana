import java.util.Calendar;
import java.text.SimpleDateFormat;

public class FechaActual {
    public static void main(String[] args) {
        // Crear objeto Calendar con la fecha y hora actual
        Calendar calendario = Calendar.getInstance();
        
        // Crear objeto SimpleDateFormat para dar formato a la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        
        // Obtener la fecha y hora actual en el formato deseado
        String fechaActual = formatoFecha.format(calendario.getTime());
        
        // Imprimir la fecha y hora actual
        System.out.println("La fecha y hora actual es: " + fechaActual);
    }
}
