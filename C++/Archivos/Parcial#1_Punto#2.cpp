#include <fstream>
#include <iostream>
#include <string.h>
#include <vector>

using namespace std;

struct stud{
  int id;
  char nom[30];
  int exa; //Ini = 1, Supl = 2
  float nota;
};

void test(vector<stud>& est){

  vector<stud> ini, sup;

  for(int i=0; i<est.size(); i++){
    if(est[i].exa == 1){
      ini.push_back(est[i]);
    }
    if(est[i].exa == 2){
      sup.push_back(est[i]);
    }  
  }

  // Calcular el número de exámenes presentados y la nota promedio de cada archivo
  float ini_promedio = 0, sup_promedio = 0;
  int ini_presentados = 0, sup_presentados = 0;
  
  for(int i=0; i<ini.size(); i++){
    ini_presentados++;
    ini_promedio += ini[i].nota;
  }
  if(ini_presentados > 0){
    ini_promedio /= ini_presentados;
  }

  for(int i=0; i<sup.size(); i++){
    sup_presentados++;
    sup_promedio += sup[i].nota;
  }
  if(sup_presentados > 0){
    sup_promedio /= sup_presentados;
  }

  // Guardar la información en los archivos de texto
  ofstream ini_file("inicial.txt");
  if(!ini_file){
    cout<<"Error: no se puede crear el archivo inicial.txt"<<endl;
    exit(1);
  }
  ini_file<<"Numero de examenes presentados: "<<ini_presentados<<endl;
  ini_file<<"Nota promedio: "<<ini_promedio<<endl;
  for(int i=0; i<ini.size(); i++){
    ini_file<<ini[i].nom<<"\t"<<ini[i].nota<<endl;
  }
  ini_file.close();

  ofstream sup_file("supletorio.txt");
  if(!sup_file){
    cout<<"Error: no se puede crear el archivo supletorio.txt"<<endl;
    exit(1);
  }
  sup_file<<"Numero de examenes presentados: "<<sup_presentados<<endl;
  sup_file<<"Nota promedio: "<<sup_promedio<<endl;
  for(int i=0; i<sup.size(); i++){
    sup_file<<sup[i].nom<<"\t"<<sup[i].nota<<endl;
  }
  sup_file.close();
}

int main(){
  
  int n;
  cout<<"Ingrese el # de estudiantes: ";
  cin>>n;

  vector<stud> est;
  //est.reserve(n);

  ofstream notas("datos.dat",ios::out|ios::binary); 
  
  for(int i=0; i<n; i++){
    stud s;
    cout<<"Id "<<i+1<<": ";
    cin>>s.id;
    cout<<"Nombre "<<i+1<<": ";
    cin>>s.nom;
    cout<<"Examen "<<i+1<<": ";
    cin>>s.exa;
    cout<<"Nota "<<i+1<<": ";
    cin>>s.nota;
   
    est.push_back(s);
    notas.write((char *)&s,sizeof(stud));
  }

  notas.close();
  
  test(est);
  
  return 0;
}
