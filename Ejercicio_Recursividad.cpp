/******************************************************************************
Fecha: 22/03/2023
Cristian Vargas Cuadros 
Ejercicio de Recursividad
*******************************************************************************/

#include <stdio.h>
#include <string.h>
#include <iostream>

using namespace std;


int sumarArregloRecursivamente(int arr[], int n) {
    // Caso base
    if (n == 0) {
        return 0;
    }
    // Caso recursivo
    return arr[n-1] + sumarArregloRecursivamente(arr, n-1);
}

int main()
{
    int n,arr[100];
    cout<<"Ingrese el tamaño del arreglo: ";
    cin >> n;
    cin.ignore();
    for(int i=0;i<n;i++){
        cout<<"Ingrese el numero "<<i+1<< ": ";
        cin>>arr[i];
    }
    cout<<"La suma del arreglo es: "<<sumarArregloRecursivamente(arr,n);
}
