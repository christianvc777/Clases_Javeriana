/************************************************

Fecha:29/03/2023
Ejercicio #2 - Circulo, Triangulo y Colegio
Por: Cristian Vargas Cuadros

*************************************************/

#include <iostream>
#include <string>
#include <cmath>

using namespace std;


//Parte #1 - Calculo de Circulos y Triangulos

// Clase Circulo
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
    double Perimetro() {
      return 2 * PI * radio;
    }

    // Método para calcular el diámetro
    double Diameter() {
      return 2 * radio;
    }
};

//Clase Triangulo
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
    double Perimetro() {
      return sqrt((pow(altura,2)+pow(base,2)));
    }

};

//Parte #2 - Miembros del Colegio

// Clase base Persona
class Persona {

  public:
    
    string name;
    int age;
   //Constructor Persona
    Persona(string n, int a) {
      name = n;
      age = a;
    }
    //Poliformismo de introduce para cada persona
    virtual void introduce() {
      cout << "Mi nombre es " << name << " y tengo " << age << " años." << endl;
    }
};

// Clase Teacher, hereda de Persona
class Teacher : public Persona {
  private:
    string materia;

  public:
    //Constructor Teacher
    Teacher(string n, int a, string m) : Persona(n, a) {
      materia = m;
    }

    void introduce() {
      cout << "Hola, soy el profesor " << name << " y tengo " << age << " años." << endl;
      cout << "Enseño " << materia << " en el colegio." << endl;
    }
};

// Clase Student, hereda de Persona
class Student : public Persona {
  private:
    int grade;

  public:
   //Constructor Student
    Student(string n, int a, int g) : Persona(n, a) {
      grade = g;
    }

    void introduce() {
      cout << "Hola, soy el estudiante " << name << " y tengo " << age << " años." << endl;
      cout << "Estudio en el colegio y mi grado actual es " << grade << "." << endl;
    }
    // Verificador de edad para curso de C++
    bool cursoC() {
      if (grade >= 9) {
        return true;
      } 
      else{
        return false;
      }
    }
};

//Funcion Principal

int main() {

  cout<<endl<<"Ejercicio #2 - POO"<<endl;
  cout<<endl<<"Parte #1 - Calculo de Circulos"<<endl<<endl;

  double rad=0.0;
  cout<<"Ingrese el radio de un circulo: ";
  cin>>rad;
  
  // Crea un objeto Circulo con un radio  
  Circulo circulo(rad);

  // Imprime los resultados de los cálculos
  cout << "El diámetro del círculo es: " << circulo.Diameter() << endl;
  cout << "El perímetro del círculo es: " << circulo.Perimetro() << endl;
  cout << "El área del círculo es: " << circulo.Area() << endl;

  cout<<endl<<"Parte #1 - Calculo de Triangulos Rectangulos"<<endl;
  
  cout<<endl;
  double altura=0.0,base=0.0;
  cout<<"Ingrese la altura del triangulo: ";
  cin>>altura;
  cout<<"Ingrese la base del triangulo: ";
  cin>>base;

 // Crea un objeto Triangulo con altura y base
  Triangulo triangulo(altura,base);
  
  // Imprime los resultados de los cálculos
  cout << "El perímetro del triangulo es: " << triangulo.Perimetro() << endl;
  
  cout<<endl<<"Parte #2 - Miembros del Colegio"<<endl;
  cout<<endl;
  
  // Crea objetos de las tres clases
  Persona persona("Mateo Camargo", 30);
  Teacher teacher("Victor Ruiz", 45, "programacion");
  Student student1("Andres Cardona", 14, 8);
  Student student2("Luisa Pedraza", 16, 9);

  // Llama al método introduce() de cada objeto
  persona.introduce();
  teacher.introduce();
  student1.introduce();
  student2.introduce();
  cout<<endl;
  cout<<"Lista de Admisiones - Curso de Programacion C++"<<endl<<endl;
  
  // Revisa si el estudiante puede inscribirse en el curso de programación

  if (student1.cursoC()) {
    cout << "El estudiante " << student1.name << " puede inscribirse en el curso de programación." << endl;
  } else {
    cout << "El estudiante " << student1.name << " no puede inscribirse en el curso de programación." << endl;
  }
  
  //Caso estudiante #2
  if (student2.cursoC()) {
    cout << "El estudiante " << student2.name << " puede inscribirse en el curso de programación." << endl;
  } else {
    cout << "El estudiante " << student2.name << " no puede inscribirse en el curso de programación." << endl;
  }
  cout<<endl;

  //Firma del Programador
  cout<<"Made by: Cristian Vargas"<<endl;
  
  return 0;
  
}
