/*

Taller #1 - 15/Febrero/2023
Autor: Cristian Vargas Cuadros
Clase: Miercoles y Viernes - 7-9 am

Ejercicio 01:
	1.- Crear un array con 10 elementos
	2.- Crear una función para generar números aleatorios entre 0 y 25
	3.- Llenar el array con 10 números aleatorios
	4.- Crear un puntero
	5.- Imprimir el contenido del array usando el puntero
	6.- Imprimir las direcciones del contenido del array usando el puntero

*/

#include <iostream>
#include <cstdlib>
#include <ctime> 

using namespace std;

//Funcion - Generar Numeros Aleatorios

void random(int array[]){
	
	srand(time(NULL)); //Reiniciar los numeros desde el semillero
	int *puntero; //Crear puntero
	for(int i=0;i<10;i++){
		array[i]=0+rand()%25; //Generar numeros aleatorios
		//cout<<"El numero ["<<i<<"] es: "<<array[i]<<endl;
		puntero=&array[i]; //Puntero guarda todo del array[i]
		//Imprimir los valores
		cout<<"El valor ["<<i<<"] es: "<<*puntero<<endl;
		//Imprimir las direcciones
		cout<<"La direccion del "<<*puntero<<" es: "<<puntero<<endl;
		cout<<endl;
   	}
	      	
}

//Funcion - Principal

int main() {
	
	int array[10]; //Creando arreglo entero
	
	random(array); //Lamando a la funcion random
	
	return 0;

}