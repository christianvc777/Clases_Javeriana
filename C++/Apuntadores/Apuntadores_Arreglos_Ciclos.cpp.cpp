#include <iostream>

int main() {
    const int size = 5;
    int arr[size] = {1, 2, 3, 4, 5}; // Declaración de un arreglo de enteros

    int* ptr = arr; // Declaración de un puntero que apunta al primer elemento del arreglo

    cout << "Elementos del arreglo: ";
    for (int i = 0; i < size; i++) {
        cout << *(ptr + i) << " "; // Acceder a los elementos del arreglo a través del puntero
    }

    cout << endl;

    // Duplicar el valor de cada elemento del arreglo usando el puntero
    for (int i = 0; i < size; i++) {
        *(ptr + i) *= 2; // Multiplicar cada elemento por 2
    }

    cout << "Elementos del arreglo duplicados: ";
    for (int i = 0; i < size; i++) {
        cout << *(ptr + i) << " "; // Imprimir los elementos modificados del arreglo
    }

    cout << endl;

    return 0;
}
