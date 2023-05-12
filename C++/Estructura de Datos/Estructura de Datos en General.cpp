#include <iostream>

using namespace std;

struct Nodo {
    int dato;
    Nodo* siguiente;
};

void insertarElemento(Nodo** cabeza, int dato) {
    Nodo* nuevoNodo = new Nodo;
    nuevoNodo->dato = dato;
    nuevoNodo->siguiente = nullptr;

    if (*cabeza == nullptr) {
        *cabeza = nuevoNodo;
    } else {
        Nodo* temp = *cabeza;
        while (temp->siguiente != nullptr) {
            temp = temp->siguiente;
        }
        temp->siguiente = nuevoNodo;
    }
}

void eliminarElemento(Nodo** cabeza, int dato) {
    Nodo* actual = *cabeza;
    Nodo* previo = nullptr;

    while (actual != nullptr) {
        if (actual->dato == dato) {
            if (previo == nullptr) {
                *cabeza = actual->siguiente;
            } else {
                previo->siguiente = actual->siguiente;
            }
            delete actual;
            return;
        }
        previo = actual;
        actual = actual->siguiente;
    }
}

void mostrarLista(Nodo* cabeza) {
    
if (cabeza == nullptr) {
cout << "La lista está vacía." << endl;
} else {
cout << "Elementos de la lista:" << endl;
Nodo* temp = cabeza;
while (temp != nullptr) {
cout << temp->dato << " ";
temp = temp->siguiente;
}
cout << endl;
}
}

int main() {
Nodo* lista = nullptr;
// Insertar elementos en la lista
insertarElemento(&lista, 10);
insertarElemento(&lista, 20);
insertarElemento(&lista, 30);

// Mostrar la lista
cout << "Lista después de la inserción:" << endl;
mostrarLista(lista);

// Eliminar un elemento de la lista
eliminarElemento(&lista, 20);

// Mostrar la lista después de la eliminación
cout << "\nLista después de la eliminación:" << endl;
mostrarLista(lista);

return 0;
}
