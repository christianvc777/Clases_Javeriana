
//Fecha: 12/04/2023
//Cristian Vargas Cuadros
//Ejercicio: Fechas - Java


import java.util.Calendar;
import java.util.Formatter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatoTiempo{
  public static void main(String args[]){
    //Formate Fecha:
    Formatter fecha= new Formatter();
    Calendar cal= Calendar.getInstance();
    fecha = new Formatter();
    fecha.format("%tB %tb %tm", cal,cal,cal);
    //Formato Hora
    Date hora= new Date();
    String strFormatoHora ="HH:mm:ss a";
    SimpleDateFormat forma = new SimpleDateFormat(strFormatoHora);
    //Se imprime
    System.out.print("Presentacion 1 de Fecha y Hora: ");
    System.out.println(fecha+" "+forma.format(hora)+"\n");
    //Otra forma
    fecha.format("%tc",cal);
    System.out.print("Presentacion 2 de Fecha y Hora: ");
    System.out.println(fecha+"\n");
    //Otra forma
    Date d = new Date();
    System.out.print("Presentacion 3 de Fecha y Hora: ");
    System.out.println(d.toString());
    
  }
}
