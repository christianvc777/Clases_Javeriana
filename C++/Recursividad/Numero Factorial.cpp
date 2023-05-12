#include <iostream>

//Calcular un numero factorial

using namespace std;

int factorial(int n) {
    if (n == 0 || n == 1) {
        return 1;
    } else {
        return n * factorial(n - 1);
    }
}

int main() {
    int num;
    cout << "Ingrese un número entero positivo: ";
    cin >> num;

    if (num < 0) {
        cout << "El número debe ser positivo." << endl;
    } else {
        int resultado = factorial(num);
        cout << "El factorial de " << num << " es: " << resultado << endl;
    }

    return 0;
}
