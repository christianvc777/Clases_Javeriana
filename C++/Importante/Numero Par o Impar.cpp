#include <iostream>

int main() {
    long numero;

    std::cout << "Ingrese un número entero: ";
    std::cin >> numero;

    if (numero % 2 == 0) {
        std::cout << "El número ingresado es par." << std::endl;
    } else {
        std::cout << "El número ingresado es impar." << std::endl;
    }

    return 0;
}
