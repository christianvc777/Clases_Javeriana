/******************************************************************************

Fecha: 08/02/2023
Autor: Cristian Vargas
Tema: Clase Vector

*******************************************************************************/

#include <iostream>
#include <vector>
using namespace std;
//Se crea la funcion principal

int main()
{
    //Objeto tipo de vector de enteros;
    vector<int> x;
    int i,j,k;
    //Se declara un vector de tamaño 5 y se inicializa con 1
    x.assign(5,1);
    cout<<"El tamano del vector es: "<<x.size()<<endl;
    cout<<"Proceso #1"<<endl;
    for(i=0;i<x.size();i++)
        cout<<x[i]<<endl;
    cout<<"Proceso #2"<<endl;
    x.push_back(2);
    for(i=0;i<x.size();i++)
        cout<<x[i]<<endl;
    cout<<"El tamano #2 del vector es: "<<x.size()<<endl;
    cout<<"Proceso #3"<<endl;
    x.clear();
    cout<<"El tamano final es: "<<x.size()<<endl;
    
    return 0;
}
