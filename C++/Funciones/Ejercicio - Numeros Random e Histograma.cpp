/**************************

Fecha: 16/02/2023
Autor: Cristian Vargas Cuadros
Tema: Generacion de numeros aleatorios y su histograma

***************************/

#include <iostream>
#include <cstdlib>

using namespace std;


//Funcion - Encontrar el valor maximo


void max(int fre[], int n){
	
	int max=0;
	for(int i=0; i<n; i++)
	{
		if(fre[i]>max){
			max=fre[i];
		}	
	}
	cout<<"El valor maximo es: "<<max;
}

//Funcion - Generando el Histograma

void hist(int fre[], int n)

{
	int aux[n];
        for(int i=0; i<n; i++){
           int acum=0;
           {
               for(int j=0;j<n;j++)
               {
                   if(fre[j]==fre[i]){
                    acum++;
                   }
               }
           cout<<"Numero es: "<<fre[i]<<"\t"<<"Repeticiones: "<<acum<<"      "<<"Histograma: ";
           for(int i=0;i<acum;i++){    	
           	cout<<"*";
		   }
           cout<<endl;
		   }
        }
}
	
//Funcion Menu

int menu()

{	
	int op;
	cout<<"Bienvenido al Programa de Histogramas"<<endl;
	cout<<"Selecciona tu opcion"<<endl;
	cout<<"	"<<endl;
	cout<<"Opcion #1"<<"\t"<<"-> Generar Numeros Aleatorios"<<endl;
	cout<<"Opcion #2"<<"\t"<<"-> Generar Histograma"<<endl;
	cout<<"Opcion #3"<<"\t"<<"-> Retornar Valor Maximo"<<endl;
	cout<<"Opcion #0"<<"\t"<<"-> Salir"<<endl;
	cout<<"	"<<endl;
	cout<<"Digite su opcion: ";
	cin>>op;
	cout<<endl;
	return op;
}

//Funcion Principal	

int main()
{	
	int opc;
	opc=menu();
	if(opc==0){
		exit(1);
	}
	int a,n=10,fre[100];
	while(opc!=0){	
	switch(opc)
	{	
	case 1:
			//Generando Numeros Aleatorios
			cout<<"Generando Numeros Aleatorios"<<endl;
    		for (int i=0; i<10; i++){
        		a=1+rand()%10;
        		fre[i]=a;
       			cout<<"El numero ["<<i<<"] es: "<<a<<endl;
    		}
    		break;
    		
    case 2: 
			//Llamando a la Funcion de Histogramas
			hist(fre,n);
			break;			
	
	case 3:
		    //Imprimiendo el valor maximo
		    max(fre,n);
		    cout<<endl;
		    break;
	
	}
	cout<<endl;
	//Se repite el bucle hasta que opcion = 0
	opc=menu();
	}
}


