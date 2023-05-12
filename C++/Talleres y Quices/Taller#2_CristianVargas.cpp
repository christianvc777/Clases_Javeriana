/****

Fecha: 16/02/2023
Autor: Cristian Vargas Cuadros
Taller #2: 

***/

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <string>
#include <vector>

using namespace std;

struct Valor{
int max;
int tam;
} valor;

//Funcion - Generar Numeros Aleatorios

void random(int fre[], int a, int n){
	
            srand(time(NULL));
			cout<<"Generando Numeros Aleatorios"<<endl;
    		for (int i=0; i<n; i++){
        		a=1+rand()%10;
        		fre[i]=a;
       			cout<<"El numero ["<<i+1<<"] es: "<<a<<endl;
    		}
    	cout<<endl;
	    int max=0;
	    for(int i=0; i<n; i++)
	    {
		    if(fre[i]>max){
			    max=fre[i];
		    }	
	    }
	    valor.max=max;
	    valor.tam=n;
	    cout<<"El valor maximo es: "<<valor.max<<endl;
	    cout<<"El tamaño de numeros aleatorios es: "<<valor.tam<<endl;
	      	
}

//Funcion - Ordenar

void ord(int fre[], int n){
    
    int i,j,aux;
    for(i=0;i<n-1;i++){
        for(j=i+1;j<n;j++){
            if(fre[i]>fre[j]){
                aux=fre[i];
                fre[i]=fre[j];
                fre[j]=aux;
            }
        }
    }
    for(i=0;i<n;i++){
        cout<<fre[i]<<"  ";
    }
    cout<<endl;
}

//Funcion - Repeticiones
/*
void veces(int fre[], int rep[], int n){
    
    int i,num=1,cont, len=0;
    cout<<"Bandera 1"<<endl;
    /*while(num<=10){
        for(i=0;i<n;i++){
            cont=0;
            if(fre[i]==num){
                cont++;
            }
        }
        if(num<=10)
        rep[i]=cont;
        num++;
    }
    while(num<=10){
        cont=0;
        for(i=0;i<n;i++){
            if(fre[i]==num){
                cont++;
            }
        }
        rep[i]=cont;
        num++;
    }
    
    len=num-1;
    cout<<"Bandera 2"<<endl;
    for(i=0;i<len;i++){
        cout<<rep[i]<<"  ";
    }
    cout<<endl;
}
*/

//Funcion - Generando el Histograma

void hist(int fre[], int rep[], int n)
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
	cout<<"Opcion #0"<<"\t"<<"-> Salir"<<endl;
	cout<<"Digite su opcion: ";
	cin>>op;
	cout<<endl;
	return op;
}

//Funcion Principal	

int main()
{	 
    int n;
    cout<<"Ingrese la cantidad de numeros random: ";
    cin>>n;
	int opc;
	opc=menu();
	if(opc==0){
	    cout<<"Hasta luego usuario :)";
		exit(1);
	}
	int a,fre[100],rep[100];
	while(opc!=0){	
	switch(opc)
	{	
	case 1:
			//Generando Numeros Aleatorios
			random(fre,a,n);
    		break;
    		
    case 2: 
			//Llamando a la Funcion de Histogramas
		    //veces(fre,rep,n);
			ord(fre,n);
			hist(fre,rep,n);
			break;		
			
	}
	cout<<endl;
	//Se repite el bucle hasta que opcion = 0
	opc=menu();
	}
}