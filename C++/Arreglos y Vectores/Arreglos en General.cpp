#include <iostream>

void imprimirArreglo(int arreglo[], int tamano) {
    for (int i = 0; i < tamano; i++) {
        cout << arreglo[i] << " ";
    }
    cout << endl;
}

int encontrarMaximo(int arreglo[], int tamano) {
    int maximo = arreglo[0];
    for (int i = 1; i < tamano; i++) {
        if (arreglo[i] > maximo) {
            maximo = arreglo[i];
        }
    }
    return maximo;
}

int calcularSuma(int arreglo[], int tamano) {
    int suma = 0;
    for (int i = 0; i < tamano; i++) {
        suma += arreglo[i];
    }
    return suma;
}

void duplicarArreglo(int arreglo[], int tamano) {
    for (int i = 0; i < tamano; i++) {
        arreglo[i] *= 2;
    }
}

int main() {
    const int tamano = 5;
    int arreglo[tamano] = {1, 2, 3, 4, 5};

    cout << "Arreglo original: ";
    imprimirArreglo(arreglo, tamano);

    int maximo = encontrarMaximo(arreglo, tamano);
    cout << "El máximo del arreglo es: " << maximo << endl;

    int suma = calcularSuma(arreglo, tamano);
    cout << "La suma de los elementos del arreglo es: " << suma << endl;

    duplicarArreglo(arreglo, tamano);
    cout << "Arreglo duplicado: ";
    imprimirArreglo(arreglo, tamano);

    return 0;
}
