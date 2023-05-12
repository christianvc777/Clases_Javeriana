/*

Taller #1 - 15/Febrero/2023
Autor: Cristian Vargas Cuadros
Clase: Miercoles y Viernes - 7-9 am

Ejercicio #2

*/

#include <iostream>
#include <fstream>

using namespace std;

//Estructura Factura

struct Cliente{

	string nombre; //Nombre cliente
	string apellido; //Apellido cliente
	int edad; //Edad cliente

};

//Funcion Factura

void factura(Cliente *puntero, int n){

	for(int i=0; i<n; i++){
		cout<<endl;
		//Solicitud de Datos Basicos
		cout<<"Ingrese su nombre: ";
		cin>>puntero->nombre;
		cout<<"Ingrese su apellido: ";
		cin>>puntero->apellido;
		cout<<"Ingrese su edad: ";
		cin>>puntero->edad;
		cout<<endl;
		puntero++;
	}
	puntero=puntero-n;

	//Generacion de archivo de facturas
	ofstream archivo("Facturas.txt");
    for (int j=0; j<n; j++)
    {
	    //Impresion de los datos
		archivo<<"Factura del Cliente #"<<j+1<<endl;
		archivo<<"Nombre: "<<puntero->nombre<<endl;
		archivo<<"Apellido: "<<puntero->apellido<<endl;
		archivo<<"Edad: "<<puntero->edad<<endl;
		archivo<<endl;
		puntero++;
    }
    archivo.close();
}

int main(){

	//Programa de Facturas
	int n;
	cout<<"Ingrese la cantidad de clientes: ";
	cin>>n;
	Cliente cliente[n],*puntero; //Arreglos tipo Cliente
	puntero=cliente; //Puntero es igual cliente

	//Llamando a la funcion factura
	factura(puntero,n);

	return 0;
}
