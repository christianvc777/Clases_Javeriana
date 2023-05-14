#include <iostream>

using namespace std;

void fibonacci(int n) {
    int t1 = 0, t2 = 1, siguiente;

    cout << "Serie de Fibonacci con " << n << " términos: ";

    for (int i = 1; i <= n; ++i) {
        cout << t1 << " ";

        siguiente = t1 + t2;
        t1 = t2;
        t2 = siguiente;
    }

    cout << endl;
}

int main() {
    int cantidadTerminos;

    cout << "Ingrese la cantidad de términos para la serie de Fibonacci: ";
    cin >> cantidadTerminos;

    fibonacci(cantidadTerminos);

    return 0;
}
