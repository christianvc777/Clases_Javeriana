#include <iostream>
#include <fstream>
#include <cstring>

struct Persona {
    char nombre[50];
    int edad;
    float altura;
};

void escribirArchivo(const char* nombreArchivo) {
    ofstream archivo(nombreArchivo, ios::binary); // Crear un objeto ofstream para escribir en el archivo binario

    if (archivo.is_open()) {
        cout << "Escribiendo en el archivo..." << endl;

        int numPersonas;
        cout << "Ingrese el número de personas a agregar al archivo: ";
        cin >> numPersonas;

        for (int i = 0; i < numPersonas; i++) {
            Persona persona;

            cout << "\nDatos de la persona #" << i + 1 << endl;
            cout << "Nombre: ";
            cin.ignore();
            cin.getline(persona.nombre, sizeof(persona.nombre));

            cout << "Edad: ";
            cin >> persona.edad;

            cout << "Altura: ";
            cin >> persona.altura;

            archivo.write(reinterpret_cast<char*>(&persona), sizeof(persona)); // Escribir la estructura Persona en el archivo
        }

        archivo.close(); // Cerrar el archivo después de escribir
    } else {
        cout << "No se pudo abrir el archivo." << endl;
    }
}

void leerArchivo(const char* nombreArchivo) {
    ifstream archivo(nombreArchivo, ios::binary); // Crear un objeto ifstream para leer el archivo binario

    if (archivo.is_open()) {
        cout << "Leyendo el archivo..." << endl;

        archivo.seekg(0, ios::end); // Ir al final del archivo para obtener el tamaño total
        int fileSize = archivo.tellg(); // Obtener el tamaño del archivo
        archivo.seekg(0, ios::beg); // Volver al inicio del archivo

        int numPersonas = fileSize / sizeof(Persona);
        Persona* personas = new Persona[numPersonas]; // Crear un arreglo dinámico para almacenar las personas del archivo

        archivo.read(reinterpret_cast<char*>(personas), fileSize); // Leer todo el contenido del archivo en el arreglo

        archivo.close(); // Cerrar el archivo después de leerlo

        cout << "Contenido del archivo:" << endl;
        for (int i = 0; i < numPersonas; i++) {
            cout << "\nPersona #" << i + 1 << endl;
            cout << "Nombre: " << personas[i].nombre << endl;
            cout << "Edad: " << personas[i].edad << endl;
            cout << "Altura: " << personas[i].altura << endl;
        }

        delete[] personas; // Liberar la memoria del arreglo dinámico
    } else {
        cout << "No se pudo abrir el archivo." << endl;
    }
}

int main() {
    const char* nombreArchivo = "personas.dat";

    escribirArchivo(nombreArchivo);
    leerArchivo(nombreArchivo);

    return 0;
}
