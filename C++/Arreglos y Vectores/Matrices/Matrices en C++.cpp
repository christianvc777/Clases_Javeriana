#include <iostream>

#define MAX_FILAS 3
#define MAX_COLUMNAS 3

typedef int Matriz[MAX_FILAS][MAX_COLUMNAS];

void ingresarMatriz(Matriz matriz) {
    cout << "Ingrese los elementos de la matriz:" << endl;
    for (int i = 0; i < MAX_FILAS; i++) {
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            cout << "Elemento [" << i << "][" << j << "]: ";
            cin >> matriz[i][j];
        }
    }
}

void imprimirMatriz(const Matriz matriz) {
    cout << "Matriz:" << endl;
    for (int i = 0; i < MAX_FILAS; i++) {
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            cout << matriz[i][j] << " ";
        }
        cout << endl;
    }
}

void sumarMatrices(const Matriz matrizA, const Matriz matrizB, Matriz matrizResultado) {
    for (int i = 0; i < MAX_FILAS; i++) {
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            matrizResultado[i][j] = matrizA[i][j] + matrizB[i][j];
        }
    }
}

void multiplicarMatrices(const Matriz matrizA, const Matriz matrizB, Matriz matrizResultado) {
    for (int i = 0; i < MAX_FILAS; i++) {
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            matrizResultado[i][j] = 0;
            for (int k = 0; k < MAX_COLUMNAS; k++) {
                matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
            }
        }
    }
}

void transponerMatriz(const Matriz matriz, Matriz matrizTranspuesta) {
    for (int i = 0; i < MAX_FILAS; i++) {
        for (int j = 0; j < MAX_COLUMNAS; j++) {
            matrizTranspuesta[j][i] = matriz[i][j];
        }
    }
}

int main() {
    Matriz matrizA, matrizB, matrizSuma, matrizProducto, matrizTranspuesta;

    cout << "Ingrese los elementos de la matriz A:" << endl;
    ingresarMatriz(matrizA);

    cout << "\nIngrese los elementos de la matriz B:" << endl;
    ingresarMatriz(matrizB);

    cout << "\nMatriz A:" << endl;
    imprimirMatriz(matrizA);

    cout << "\nMatriz B:" << endl;
    imprimirMatriz(matrizB);

    sumarMatrices(matrizA, matrizB, matrizSuma);
    cout << "\nSuma de las matrices A y B:" << endl;
    imprimirMatriz(matrizSuma);

    multiplicarMatrices(matrizA, matrizB, matrizProducto);
    cout << "\nProducto de las matrices A y B:" << endl;
    imprimirMatriz(matrizProducto);

    return 0;
}
