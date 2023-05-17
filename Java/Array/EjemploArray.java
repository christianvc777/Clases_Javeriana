

public class EjemploArray {
    public static void main(String[] args) {
        // Crear un arreglo de enteros con una longitud de 5
        int[] numeros = new int[5];
        
        // Asignar valores al arreglo
        numeros[0] = 10;
        numeros[1] = 20;
        numeros[2] = 30;
        numeros[3] = 40;
        numeros[4] = 50;
        
        
        // Imprimir el valor de un elemento del arreglo
        System.out.println("El valor del elemento en la posición 2 es: " + numeros[2]);
        
        // Obtener la longitud del arreglo
        int longitud = numeros.length;
        System.out.println("La longitud del arreglo es: " + longitud);
        
        // Iterar sobre el arreglo y mostrar todos los elementos
        System.out.println("Los elementos del arreglo son:");
        for (int i = 0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        
        // Buscar un elemento en el arreglo
        double elementoBuscado = 20.0;
        boolean encontrado = false;
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == elementoBuscado) {
                encontrado = true;
                break;
            }
        }
        if (encontrado) {
            System.out.println("El elemento " + elementoBuscado + " está en el arreglo.");
        } else {
            System.out.println("El elemento " + elementoBuscado + " no está en el arreglo.");
        }
    }
}
