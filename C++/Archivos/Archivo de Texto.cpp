#include <iostream>
#include <fstream>

void escribirArchivo(const char* nombreArchivo) {
    ofstream archivo(nombreArchivo); // Crear un objeto ofstream para escribir en el archivo

    if (archivo.is_open()) {
        cout << "Escribiendo en el archivo..." << endl;

        const int size = 5;
        int numeros[size] = {1, 2, 3, 4, 5};

        for (int i = 0; i < size; i++) {
            archivo << numeros[i] << " "; // Escribir los números separados por espacios en el archivo
        }

        archivo.close(); // Cerrar el archivo después de escribir
    } else {
        cout << "No se pudo abrir el archivo." << endl;
    }
}

void leerArchivo(const char* nombreArchivo) {
    ifstream archivo(nombreArchivo); // Crear un objeto ifstream para leer el archivo

    if (archivo.is_open()) {
        cout << "Leyendo el archivo..." << endl;

        const int size = 5;
        int numeros[size];

        for (int i = 0; i < size; i++) {
            archivo >> numeros[i]; // Leer los números del archivo y almacenarlos en el arreglo
        }

        archivo.close(); // Cerrar el archivo después de leer

        cout << "Contenido del archivo: ";
        for (int i = 0; i < size; i++) {
            cout << numeros[i] << " "; // Imprimir los números leídos del archivo
        }

        cout << endl;
    } else {
        cout << "No se pudo abrir el archivo." << endl;
    }
}

int main() {
    const char* nombreArchivo = "archivo.txt";

    escribirArchivo(nombreArchivo);
    leerArchivo(nombreArchivo);

    return 0;
}
