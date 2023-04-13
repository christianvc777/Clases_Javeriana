
//Fecha: 12/04/2023
//Cristian Vargas Cuadros
//Ejercicio: Ordenar Arreglos - Java

import java.util.Arrays;

class OrdenarArreglos {
    public static void imprimirArreglo(String mensaje, int arreglo[]) {
        System.out.println(mensaje+": [longitud: "+arreglo.length+"]");
        for(int i=0; i<arreglo.length; i++) {
            System.out.println(" -> "+arreglo[i]);
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int ejemplo_arreglo[] = {3,-5,-2,0,-10};
        float miflotante = 1.0f;
        double[][] matriz = new double[3][3];
        Arrays.sort(ejemplo_arreglo);
        imprimirArreglo("Arreglo Ordenado", ejemplo_arreglo);
        int indice = Arrays.binarySearch(ejemplo_arreglo, -2);
        System.out.println("Se encontro el -2 en "+indice);
    }
}