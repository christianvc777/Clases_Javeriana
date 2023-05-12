#include <fstream>
#include <iostream>
#include <string.h>

using namespace std;

struct stud {
    int id;
    char nom[30];
    int exa; //Ini = 1, Supl = 2
    float nota;
};

void test(stud* est, int n) {
    fstream notas;
    notas.open("datos.dat", ios::in | ios::binary);
    ofstream ini("inicial.txt", ios::out);
    ofstream sup("supletorio.txt", ios::out);

    if (!ini || !sup) {
        cout << "Can't create files" << endl;
        exit(1);
    }
    
    float sum_ini = 0.0, sum_sup = 0.0; //Acumulador = nota prom
    int count_ini = 0, count_sup = 0; //Contador = # est

    while (notas.read((char *)&est->id, sizeof(stud))) {
        if (est->exa == 1) {
            ini << "Id: " << est->id << endl; //ini<<est->id<<endl;
            ini << "Nombre: " << est->nom << endl;
            ini << "Examen: " << est->exa << endl;
            ini << "Nota: " << est->nota << endl << endl;
            sum_ini += est->nota; //sumini=sumini+est->nota; 3.7 = 0 + 3.7 -> 8.0 = 3.7 +4.3
            count_ini++; // 1 -> 2
        }
        else if (est->exa == 2) {
            sup << "Id: " << est->id << endl;
            sup << "Nombre: " << est->nom << endl;
            sup << "Examen: " << est->exa << endl;
            sup << "Nota: " << est->nota << endl << endl;
            sum_sup += est->nota;
            count_sup++;
        }
        est++; //Pasar a la siguiente estructura
    }

    if (count_ini != 0) {
        float prom_ini = sum_ini / count_ini; // 4 = 8 / 2
        ini << "Número de exámenes presentados: " << count_ini << endl; // 2
        ini << "Nota promedio: " << prom_ini << endl; // 4
    }

    if (count_sup != 0) {
        float prom_sup = sum_sup / count_sup;
        sup << "Número de exámenes presentados: " << count_sup << endl;
        sup << "Nota promedio: " << prom_sup << endl;
    }

    notas.close();
    ini.close();
    sup.close();
}

int main() {
    int n;
    cout << "Ingrese el # de estudiantes: ";
    cin >> n;
    stud* est = new stud[n];

    fstream notas;
    notas.open("datos.dat", ios::out | ios::binary);

    for (int i = 0; i < n; i++) {
        cout << "Id " << i + 1 << ": ";
        cin >> est->id;
        cout << "Nombre " << i + 1 << ": ";
        cin >> est->nom;
        cout << "Examen " << i + 1 << ": ";
        cin >> est->exa;
        cout << "Nota " << i + 1 <<": ";
        cin>>est->nota;
        notas.write((char *)&est->id, sizeof(stud));
        est++;
    }
    est -= n;
    notas.close();
    test(est, n);
    delete[] est;
}