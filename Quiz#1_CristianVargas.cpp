//Quiz #1 - Cristian Vargas Cuadros

#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

//Funcion - Ejercicio #3

void problema3(int arr4[][2], int n){
    
    cout<<endl;
    srand(time(NULL));
    cout<<"La Matriz Cuadrada Aleatoria"<<endl;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            arr4[i][j]=0+rand()%10;
            cout<<arr4[i][j];
        }
        cout<<"\n";
    }
}

//Funcio Principal

int main(){
	
	//Ejercicio #1
	
	cout<<"Ejercicio #1"<<endl;
	int	arr1[5]={10,20,30,45,55};
	int* puntero;
	for(int i=0;i<5;i++){
	    puntero=&arr1[i];
	    cout<<"El numero del arreglo es: "<<*(puntero)<<endl;
	}
	
	//Ejercicio #2
	
	cout<<endl;
	cout<<"Ejercicio #2"<<endl;
	char arr2[5]={'a','e','i','o','u'};
	char arr3[5]={'a','i','u','e','a'};
	char *punt2;
	char *punt3;

	punt2=arr2;
    punt3=arr3;

	for(int i=0;i<5;i++){
	    cout<<"La letra del arr2 son: "<<*punt2++<<endl;
	}cout<<endl;
	for(int i=0;i<5;i++){
	    cout<<"La letra del arr3 son: "<<*punt3++<<endl;
	}
	cout<<endl;
	for(int i=0;i<5;i++){
	    int cont=1;
	    for(int j=0; j<5; j++){
	        if(arr2[i]==arr3[j])
	        cont++;
	    }
	    cout<<"La letra "<<arr2[i]<<" se repitio: "<<cont<<endl;
	}
	
	cout<<endl;
	
	//Ejercicio #3
	
	int n;
	
    cout<<"Ejercicio #3"<<endl;
	cout<<"Digite las dimensiones de la matriz "<<endl;
	cout<<"Digite 2 si es una matriz cuadrada: ";
	cin>>n;
	
	int arr4[2][2];
	
	//Matriz Cuadrada
	
	problema3(arr4,n);
	
}
