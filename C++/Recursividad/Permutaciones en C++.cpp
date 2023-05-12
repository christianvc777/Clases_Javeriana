#include <iostream>

const int MAX_ELEMENTOS = 5;

void intercambiar(int& a, int& b) {
    int temp = a;
    a = b;
    b = temp;
}

void imprimirArreglo(int arr[], int size) {
    for (int i = 0; i < size; i++) {
        std::cout << arr[i] << " ";
    }
    std::cout << std::endl;
}

void generarPermutaciones(int arr[], int inicio, int fin) {
    if (inicio == fin) {
        imprimirArreglo(arr, fin + 1);
    } else {
        for (int i = inicio; i <= fin; i++) {
            intercambiar(arr[inicio], arr[i]);
            generarPermutaciones(arr, inicio + 1, fin);
            intercambiar(arr[inicio], arr[i]); // Restaurar el arreglo original
        }
    }
}

int main() {
    int elementos[MAX_ELEMENTOS];

    std::cout << "Ingrese " << MAX_ELEMENTOS << " elementos:" << std::endl;
    for (int i = 0; i < MAX_ELEMENTOS; i++) {
        std::cin >> elementos[i];
    }

    std::cout << "\nPermutaciones:" << std::endl;
    generarPermutaciones(elementos, 0, MAX_ELEMENTOS - 1);

    return 0;
}
