/******************************************************************************

Fecha/¿:29/03/2023
Tema: POO
Ejercicio #2 - Circulo y Triangulo
Por: Cristian Vargas Cuadros

*******************************************************************************/

#include <iostream>
#include <cmath>
#include <math.h>

using namespace std;

class Circulo {
  private:
    double radio;
    const double PI = 3.14159;

  public:
    // Constructor
    Circulo(double r) {
      radio = r;
    }

    // Método para calcular el área
    double Area() {
      return PI * radio * radio;
    }

    // Método para calcular el perímetro
    double Perimeter() {
      return 2 * PI * radio;
    }

    // Método para calcular el diámetro
    double Diameter() {
      return 2 * radio;
    }
};

class Triangulo{
    
  public:
  
    int altura;
    int base;

    // Constructor del triangulo
    Triangulo(int altura, int base) {
        this->altura=altura;
        this->base=base;
    }

    // Método para calcular el perímetro con teorema de pitagoras
    double Perimeter() {
      return sqrt((pow(altura,2)+pow(base,2)));
    }
    
    
};

int main() {
  // Crea un objeto Circle con un radio
  int rad=0;
  cout<<"Ingrese el radio calcular: ";
  cin>>rad;
  
  Circulo circulo(rad);

  // Imprime los resultados de los cálculos
  cout << "El área del círculo es: " << circulo.Area() << endl;
  cout << "El perímetro del círculo es: " << circulo.Perimeter() << endl;
  cout << "El diámetro del círculo es: " << circulo.Diameter() << endl;
  
  
  int altura=0,base=0;
  cout<<"Ingrese la altura del triangulo: ";
  cin>>altura;
  cout<<"Ingrese la base del triangulo: ";
  cin>>base;

 Triangulo triangulo(altura,base);

  cout << "El perímetro del triangulo es: " << triangulo.Perimeter() << endl;
  
  return 0;
  
}



