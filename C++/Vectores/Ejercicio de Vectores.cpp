#include <iostream>  // Cristian Vargas Cuadros - Programación Avanzada 7 - 9 am

using namespace std;

int main(){
	
	int n,numeros[10];
	
	cout<<"Digite el numero de elementos del arreglo: ";
	cin>>n;
	
	for(int i=0;i<n;i++){
		cout<<"Digite el elemento #"<<i+1<<" : ";
		cin>>numeros[i];
	}
	
	int i,j,contador=0,contm=0,num=0; // num= Numero mas repetido del arreglo / contm= Su numero de repeticiones
	
	for(i=0;i<n-1;i++){
		contador=1;
		for(j=i+1;j<n;j++){
			if(numeros[i]==numeros[j]){
				contador++;	
			}
			if(contador>contm){
			contm=contador;
			num=numeros[i];
			}
		}
	}
	
	cout<<"El numero mas repetido es: "<<num<<endl;
	cout<<"Se repito "<<contm<<" veces"<<endl;
	
}
