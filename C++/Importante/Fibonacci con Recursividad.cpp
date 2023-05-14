#include <iostream>

//Serie Fibonacci con Recursividad

using namespace std;

void fibonacciRecursivo(int n, int t1, int t2, int contador) {
    if (contador <= n) {
        cout << t1 << " ";

        int siguiente = t1 + t2;
        t1 = t2;
        t2 = siguiente;

        fibonacciRecursivo(n, t1, t2, contador + 1);
    }
}

void fibonacci(int n) {
    cout << "Serie de Fibonacci con " << n << " términos: ";

    fibonacciRecursivo(n, 0, 1, 1);

    cout << endl;
}

int main() {
    int cantidadTerminos;

    cout << "Ingrese la cantidad de términos para la serie de Fibonacci: ";
    cin >> cantidadTerminos;

    fibonacci(cantidadTerminos);

    return 0;
}
