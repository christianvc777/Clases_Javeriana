/******************************************************************************
Fecha: 22/03/2023
Tema: Programacion Orientada a Objetos (Poo)
Nombre: Cristian Vargas Cuadros 
Ejercicio: Sumador Basico 
*******************************************************************************/

#include <iostream>

using namespace std;

class Sumador{    

    public: 
    //Funcion - Suma 2 Variables
    int funcion(int n1, int n2){
        return n1+n2;
    }
    //Funcion - Resta 3 Variables
    int funcion(int n1, int n2,int n3){
        return n1-n2-n3;
    }

};

int main()
{
    Sumador objeto;
    cout<<endl<<"Sumador POO - Programacion Orientada a Objetos"<<endl<<endl;
    
    //Caso #1 - Valores Fijos en la Funcion
    cout<<"Caso #1"<<endl;
    cout<<"La suma de dos numeros es: "<<objeto.funcion(20,10)<<endl;
    cout<<"La resta de tres numeros es: "<<objeto.funcion(20,10,3)<<endl<<endl; 
    
    //Caso #2 - Valores Inicializados en la Funcion    
    cout<<"Caso #2"<<endl;
    int a1=20,a2=10,a3=3;  
    cout<<"Los numeros son: "<<a1<<" "<<a2<<" "<<a3<<endl;
    cout<<"La suma de dos numeros es: "<<objeto.funcion(a1,a2)<<endl; 
    cout<<"La resta de tres numeros es: "<<objeto.funcion(a1,a2,a3)<<endl<<endl;

    //Caso #3 - Valores de un Arreglo en la Funcion
    cout<<"Caso #3"<<endl;
    int n=3,arr[n];
    for(int i=0;i<n;i++){
      cout<<"Ingrese el numero "<<i+1<<": ";
      cin>>arr[i];      
    }
    cout<<endl;
    cout<<"Los numeros del arreglo son: ";
    for(int i=0;i<n;i++){
      cout<<arr[i]<<" ";      
    }    
    cout<<endl<<endl;
    for(int i=0; i<1; i++){
      cout<<"La suma de dos numeros es: "<<objeto.funcion(arr[i],arr[i+1])<<endl; 
      cout<<"La resta de tres numeros es: "<<objeto.funcion(arr[n-n],arr[n-2],arr[n-1])<<endl; 
    }
    cout<<endl<<"Made by: Cristian Vargas";
    return 0;
}
