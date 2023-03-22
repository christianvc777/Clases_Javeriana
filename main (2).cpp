
//Cirstian Vargas Cuadros
//POO

#include <iostream>

using namespace std;

class Suma{
    
    public: 
    int funcion(int n1, int n2){
        return n1+n2;
    }
    int funcion(int n1, int n2,int n3){
        return n1-n2-n3;
    }
    
};


int main()
{
    
    Suma objeto;
    cout<<"La suma de dos numeros es: "<<objeto.funcion(3,5)<<endl;
    cout<<"La resta de tres numeros es: "<<objeto.funcion(20,10,3);
    
    return 0;
}