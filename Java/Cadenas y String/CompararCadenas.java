
//Fecha: 12/04/2023
//Cristian Vargas Cuadros
//Ejercicio: Comparar Cadenas - Java

class CompararCadenas {
  public static void main(String[] args) {
    String cadena1="Los Amigos";
    String cadena2="los amigos";
    //Instancia objeto tipo String
    Object objCadena=cadena1;
    //Determinar si ambas cadenas son iguales
    System.out.println(cadena1.compareTo(cadena2)); //Forma #1  
    System.out.println(cadena1.compareToIgnoreCase(cadena2)); //Forma #2 / 0 = True
    System.out.println(cadena1.equals(cadena2)); //Forma #3
    System.out.println(cadena1==cadena2); //Forma #4
  }
}

