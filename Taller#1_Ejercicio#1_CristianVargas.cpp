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
	long double valor;	// Valor de cada factura
	
};

//Funcion Factura

void factura(Cliente cliente[], int n){
	
	for(int i=0; i<n; i++){	
		cout<<endl;
		//Solicitud de Datos Basicos
		cout<<"Ingrese su nombre: "; 
		cin>>cliente->nombre;
		cout<<"Ingrese su apellido: ";
		cin>>cliente->apellido;		
		cout<<"Ingrese su edad: ";
		cin>>cliente->edad;
		cout<<"Ingrese el valor de la factura: ";
		cin>>cliente->valor;
		cout<<endl;
		//Generacion de Facturas
		cout<<"Factura del Cliente #"<<i+1<<endl; 
		cout<<endl;
		cout<<"Nombre: "<<cliente->nombre<<endl;
		cout<<"Apellido: "<<cliente->apellido<<endl;
		cout<<"Edad: "<<cliente->edad<<endl;
		cout<<"Factura: $"<<cliente->valor<<" euros"<<endl;
		//cout<<endl;
	}
	
}

int main(){
	
	//Generacion de Facturas Electronicas
	int n;
	cout<<"Ingrese la cantidad de clientes: ";
	cin>>n;
	
	Cliente cliente[n]; //El arreglo cliente es tipo Cliente
	Cliente *puntero = cliente; //El puntero es igual al arreglo
	factura(cliente,n); //Llamando a la funcion factura

	return 0;
}