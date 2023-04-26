public class EjemploString {
    public static void main(String[] args) {
        String cadena1 = "Hola";
        String cadena2 = "Mundo";
        
        // Concatenación de dos cadenas
        String cadena3 = cadena1 + " " + cadena2;
        System.out.println(cadena3); // Imprime "Hola Mundo"
        
        // Longitud de una cadena
        int longitud = cadena3.length();
        System.out.println("La longitud de la cadena es: " + longitud); // Imprime "La longitud de la cadena es: 10"
        
        // Obtener un carácter de una cadena
        char caracter = cadena3.charAt(2);
        System.out.println("El carácter en la posición 2 es: " + caracter); // Imprime "El carácter en la posición 2 es: l"
        
        // Comparar dos cadenas
        String cadena4 = "hola mundo";
        boolean iguales = cadena3.equalsIgnoreCase(cadena4);
        System.out.println("Las cadenas son iguales: " + iguales); // Imprime "Las cadenas son iguales: true"
    }
}
