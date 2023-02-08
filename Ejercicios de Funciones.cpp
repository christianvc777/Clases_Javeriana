/******************************************************************************

Fecha: 08/02/2023
Autor: Cristian Vargas
Tema: Funciones

*******************************************************************************/

#include <iostream>
#include <cmath>

using namespace std;

int main()

{
    double x1=4.0, x2=25.0, x3=81.0, x4=0;
    
    cout<<"Number"<<"   "<<"Square Root"<<endl;
    cout<<"Su numero es "<<x1<<" Su raiz cuadrada es = "<<sqrt(x1)<<endl;
    cout<<"Su numero es "<<x2<<" Su raiz cuadrada es = "<<sqrt(x2)<<endl;
    cout<<"Su numero es "<<x3<<" Su raiz cuadrada es = "<<sqrt(x3)<<endl;

    //Se le solicita al usuario un numero y se calcula su raiz cuadrada

    cout<<"Ingrese un numero: ";
    cin>>x4;
    
    cout<<"Su numero es"<<x4<<" Su raiz cuadrada es = "<<sqrt(x4)<<endl;
    
    
    return 0;
    
}
