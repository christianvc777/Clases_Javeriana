#include <fstream>
#include <iostream>
#include <string.h>

using namespace std;

void encriptar(char orig[], char encr[], char mensaje[], char* pointer[]) {

    ofstream encript;
    encript.open("encriptado.txt", ios::out);
    if (encript.fail()) {
        cout << "Sorry, it can't be open";
        exit(1);
    }
    else {
        encript<<"The sentence encript " <<endl;
        for (int i = 0; i < strlen(mensaje); i++) {
            for (int j = 0; j < 26; j++) {
                if (*pointer[i] == orig[j]) {
                    encript << encr[j];
                }
            }
        }
        encript << endl;
        encript.close();
    }
}

void desencriptar(char orig[], char encr[], char mensaje[],  char* pointer[]) {
    ofstream desencript;
    desencript.open("desencriptado.txt", ios::out);
    if (desencript.fail()) {
        cout << "Sorry, it can't be open";
        exit(1);
    }
    else {
        desencript<<"The sentence desencript "<<endl;
        for (int i = 0; i < strlen(mensaje); i++) {
            for (int j = 0; j < 26; j++) {
                if (*pointer[i] == encr[j]) {
                  desencript<<encr[j];
                }
            }
        }
        desencript << endl;
        desencript.close();
    }
}

int main() {

    char orig[26] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
                     'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
                     's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    char encr[26] = {'z', 'y', 'x', 'w', 'v', 'u', 't', 's', 'r',
                     'q', 'p', 'o', 'n', 'm', 'l', 'k', 'j', 'i',
                     'h', 'g', 'f', 'e', 'd', 'c', 'b', 'a'};

    char mensaje[100];
    char* pointer[100];
    for (int i = 0; i < 100; i++) {
        pointer[i] = &mensaje[i];
    }

    ofstream mes;
    mes.open("datos.txt", ios::out);
    if (mes.fail()) {
        cout << "Sorry, it can't be open";
        exit(1);
    }
    else {
        cout << "Ingrese el mensaje: ";
        cin.getline(mensaje, 100);
        for(int i = 0; i < strlen(mensaje); i++){
            mes << mensaje[i];
        }
    }
    mes.close();

    encriptar(orig, encr, mensaje, pointer);
    desencriptar(orig, encr, mensaje, pointer);

    return 0;
}
