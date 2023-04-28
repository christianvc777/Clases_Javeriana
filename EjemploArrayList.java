import java.util.ArrayList; //importamos la clase ArrayList

public class EjemploArrayList {
    public static void main(String[] args) {
        
        // Creamos un ArrayList de enteros
        ArrayList<Integer> numeros = new ArrayList<Integer>();
        
        // Agregamos elementos al ArrayList
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);
        numeros.add(40);
        
        // Mostramos los elementos del ArrayList
        System.out.println("Elementos del ArrayList: " + numeros);
        
        // Obtenemos el tamaño del ArrayList
        int tamaño = numeros.size();
        System.out.println("Tamaño del ArrayList: " + tamaño);
        
        // Obtenemos un elemento del ArrayList por su índice
        int elemento = numeros.get(2);
        System.out.println("Elemento en el índice 2: " + elemento);
        
        // Eliminamos un elemento del ArrayList por su índice
        numeros.remove(1);
        
        // Mostramos los elementos del ArrayList después de eliminar un elemento
        System.out.println("Elementos del ArrayList después de eliminar un elemento: " + numeros);
        
        // Verificamos si un elemento está presente en el ArrayList
        boolean presente = numeros.contains(20);
        System.out.println("¿Está presente el número 20 en el ArrayList? " + presente);
        
        // Vaciamos el ArrayList
        numeros.clear();
        
        // Verificamos si el ArrayList está vacío
        boolean vacio = numeros.isEmpty();
        System.out.println("¿Está vacío el ArrayList? " + vacio);
    }
}
