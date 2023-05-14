/******************************************************************************

Fecha: 08/02/2023
Autor: Cristian Vargas
Tema: Tipos, variables y constantes en C++
Ejercicio sobre los tipos fundamentales de 
datos "PRIMITIVOS" C++

*******************************************************************************/

#include <iostream>

//Se crea el dominio de la biblioteca iostream "Global"

using namespace std;

//Se crea la funcion principal

int main(){
    
 
    cout<<"*** Tipos Fundamentales en C++ ***"<<endl;
    cout<<"Tipo de Datos"<<"     "<<" Numero de Bytes"<<endl;
    cout<<" char: "<<sizeof(char)<<endl;
    cout<<" short: "<<sizeof(short)<<endl;
    cout<<" int: "<<sizeof(int)<<endl;
    cout<<" long: "<<sizeof(long)<<endl;
    cout<<" float: "<<sizeof(float)<<endl;
    cout<<" double: "<<sizeof(double)<<endl;
    cout<<" long double: "<<sizeof(long double)<<endl;
    
    
    return 0;
    
}
