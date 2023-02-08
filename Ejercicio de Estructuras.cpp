/**************************

Fecha: 01/02/2023
Autor: Cristian Vargas
Tema: Primer Ejercicio sobre Estructuras de Datos (EDA)

Problema: Se tiene un gym, el cual solicita hacer el registro de usuarios.
La cantidad de registros deben ser indicadas al principio. Los datos
solicitados deberian ser exhaustivos. Finalmente, se deben presentar o
imprimir los nombres de los usuarios con registo satisfactorio.

Pistas de solucion:
    
    - Datos a solicitar
        - Nombre
        - Edad
        - Genero
        - Fecha inscripcion
        - Hijos
        - Masa muscular
        - Plan
        - Horario
        - Lesiones
        - Altura
        
        - Para la captura de los datos se recomienda un EDA
    
***************************/

#include <iostream>

using namespace std;

// Declaracion de una estructura de datos que captura los datos iniciales solicitados

struct DatosPersonas{
    
    
    string nombre;
    string apellido;
    int edad;
    char genero;
    string fecha;
    int hijos;
    float masa;
    string plan;
    string franjah;
    string lesiones;
    float altura;
  
    
};

int main(){

    // Se crea variables contadoras y auxiliares necesarias
    int i;
    int cantidad_personas;
    cout<<"** Bienvenido al Gym ***"<<endl;
    //Se pide cantidad de personas a registrar
    cout<<"Cuantas personas se van a registrar: ";
    cin>> cantidad_personas;
    //Se crea objeto estructura DatosPersonas
    //Se crea el vector de personas con cantidad de presonas
    DatosPersonas persona[cantidad_personas];
    // Se hace un bucle para capturar lso datos de las personas
    cout<<"Ingreso de Datos"<<endl;
    for(i=0;i<cantidad_personas;i++){
        //Se presenta la pregunta y la captura por cada dato
        cout<<"Ingrese su nombre persona "<<i+1<<": ";
        cin>>persona[i].nombre;
        cout<<"Ingrese su apellido persona "<<i+1<<": ";
        cin>>persona[i].apellido;
        cout<<"Ingrese su edad: "<<i+1<<": ";
        cin>>persona[i].edad;
        cout<<"Ingrese su fecha: "<<i+1<<": ";
        cin>>persona[i].fecha;
        cout<<"Ingrese su genero persona "<<i+1<<": ";
        cin>>persona[i].genero;
    }
    cout<<"Los Usuarios"<<endl;
    //Presentar Nombres usuarios registrados
    for(i=0;i<cantidad_personas;i++){
        //Se presenta la pregunta y la captura por cada dato
        cout<<persona[i].nombre<<endl;
        cout<<persona[i].apellido<<endl;
        cout<<persona[i].edad<<endl;
        cout<<persona[i].fecha<<endl;
        cout<<persona[i].genero<<endl;
    }
}
