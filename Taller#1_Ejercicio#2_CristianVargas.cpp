/*

Taller #1 - 15/Febrero/2023
Autor: Cristian Vargas Cuadros
Clase: Miercoles y Viernes - 7-9 am

Ejercicio #2
	
*/

#include <iostream> 

using namespace std;

//Estructura Factura

struct Cliente{
	
	string nombre; //Nombre cliente
	string apellido; //Apellido cliente
	int edad; //Edad cliente
	long double valor; //Valor de cada factura
	
}cliente,*puntero=&cliente; //Puntero es igual cliente


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
		cout<<"Ingrese el valor de la factura: ";
		cin>>puntero->valor;
		cout<<endl;
		//Generacion de Facturas
		cout<<"Factura del Cliente #"<<i+1<<endl; 
		cout<<endl;
		cout<<"Nombre: "<<puntero->nombre<<endl;
		cout<<"Apellido: "<<puntero->apellido<<endl;
		cout<<"Edad: "<<puntero->edad<<endl;
		cout<<"Factura: $"<<puntero->valor<<" euros"<<endl;

	}	
}

//Funcion Principal 

int main(){
	
	int n;
	cout<<"Ingrese la cantidad de clientes: ";
	cin>>n;
	
	//Generacion de Facturas Electronicas
	
	factura(puntero,n); //Llamando a la funcion factura

	return 0;
}