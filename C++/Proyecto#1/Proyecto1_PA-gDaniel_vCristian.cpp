// Pontificia Universidad Javeriana
// Departamento de Ingeniería de Sistemas - Programación Avanzada
// Proyecto Final - 2023-10

// Integrantes del Grupo: Daniel Fernando Gonzalez Cortes y Cristian Eduardo Vargas Cuadros

#include <cstring> //Libreria funciones de strings
#include <fstream> //Libreria de archivos
#include <iostream>

using namespace std;

// Estructura empleado con variables tipo entero y char

struct empleado
{
  int codigo_numerico; // Identificacion
  char p_nombre[20];   // Primer Nombre
  char s_nombre[20];   // Segundo Nombre
  char p_apellido[20]; // Primer Apellido
  char s_apellido[20]; // Segundo Apellido
  int celular;         // Telefono
};

// Funciones que el main va a necesitar en cada switch case

int registrar_empleados(empleado empleados[], int contador);                                                      // Case #1
int agregar_nuevo_empleado(empleado empleados[], int contador);                                                   // Case #2
void mostrar_empleado(empleado empleados[], int contador);                                                        // Case #3
void cambio_numero_empleado(empleado empleados[], int contador);                                                  // Case #4
int despedirEmpleado(int codigo, empleado *empleados, int &numNoDespedidos, empleado despedidos[], int *posdesp); // Case #5
void mostrar_despedidos(empleado despedidos[], int cantdesp);                                                     // Case #6

// Funcion Principal

int main()

{
  int codigo = 0, opcion = -1;                                     // Variables para inicializar
  int contador = 0, cont1 = 0, cont2 = 0;                          // Contadores Dinamicos
  int numNoDespedidos = 0, n = 0, cantdesp = 0, despido, *posdesp; // Variables para despedir (posicion y cantidad)
  posdesp = &n;
  empleado empleados[100];  // Variable tipo empleado (guardar empleados)
  empleado despedidos[100]; // Variable tipo empleado (guardar desempleados)

  while (opcion != 0) // Ejecutar las funciones infinitamente, mientras no ingrese salir (0)

// Menu Principal

  {
    cout << endl;
    cout << "     ******Bienvenido***** " << endl;
    cout << "     Ingrese una de las siguientes opciones   " << endl;
    cout << " --------------------------------------------------" << endl;
    cout << " |              0) Salir de programa              |" << endl;
    cout << " |            1) Registrar empleados              |" << endl;
    cout << " |          2) Agregar nuevos empleados           |" << endl;
    cout << " |      3) Mostrar los empleados registrados      |" << endl;
    cout << " |  4) Cambiar el numero celular de un empleado   |" << endl;
    cout << " |           5) Despedir a un empleado            |" << endl;
    cout << " |6) Mostrar los empleados que han sido despedidos|" << endl;
    cout << " --------------------------------------------------" << endl;
    cout << "Opcion: ";
    cin >> opcion; // Se guarda la solicitud del usuario

    // Se evalua la solicitud en el switch dependiendo del caso (opcion)

    switch (opcion) // NOTA: Solo se realiza un caso por solicitud
    {
    case 1:
      // Llamar a la funcion para registrar los empleados
      cont1 = registrar_empleados(empleados, contador); // Cont1 es igual a lo que retorna la funcion (la cantidad de empleados registados)
      contador = cont1;                                 // Contador principal es igual a la cantidad de empleados registados
      break;                                            // Break para salir del switch y volver a pedir una nueva opcion en el while

    case 2:
      // Llamar a la funcion para agregar un nuevo empleado
      cont2 = agregar_nuevo_empleado(empleados, contador); // Cont2 es igual a la nueva cantidad de empleados
      contador = cont2;                                    // Contador principal es igual a la nueva cantidad de empleados
      break;

    case 3:
      // Imprimir la cantidad de empleados activos en la empresa
      mostrar_empleado(empleados, contador);
      break;

    case 4:
      // Llamar a la funcion para el cambio de numero de un empleado
      cambio_numero_empleado(empleados, contador);
      break;

    case 5:
      // Llamar a la funcion para generar la carta de despido del empleado
      cout << "Ingrese el codigo numerico del empleado que desea despedir: "; // Solicitud del codigo a despedir
      cin >> codigo;
      despido = despedirEmpleado(codigo, empleados, numNoDespedidos, despedidos, posdesp); // Despido es igual al empleado despedido (+1 o 0)
      if (despido == 1)                                                                    // Si esa cantidad retornada es igual a uno, es que si se despidio un empleado
        cantdesp++;                                                                        // La cantidad de despedidos aumenta cada vez que se despide algun empleado
      if (*posdesp > cantdesp)                                                             // Si la posicion es mayor a esa cantidad
      {
        posdesp = posdesp + 1; // Empieza a guardarse el despedido desde la siguiente posicion (Sino solo se guardaria el ultimo despedido)
      }
      break;

    case 6:
      // Llamar a la funcion para imprimir los empleados despedidos de la empresa
      if (cantdesp >= 0) // Si la cantidad de despedidos aumento se imprime, sino pues no mostraria ningun desempleado
      {
        cout << "Estos son los empleados despedidos \n";
        mostrar_despedidos(despedidos, cantdesp);
      }
      break;
    }
  }

  // Final del Programa = Opcion (0)
}

// Funcion - Registro de Empleados

int registrar_empleados(empleado empleados[], int contador)
{
  int cant = 0; // Cantidad de empleados
  cout << endl;
  cout << "Ingrese la cantidad de empleados que desea registrar: ";
  cin >> cant;

  // Crear y escribir los datos dentro del archivo empleados.bin

  ofstream archivo;                           // Modo escritura  - Se crea el archivo
  archivo.open("empleados.bin", ios::binary); // Se abre el archivo - Tipo binario

  // Ciclo for para guardar los datos en la variable empleados por cada empleado

  for (int i = contador; i < cant; i++)
  {
    cout << "Ingrese el codigo numerico del empleado " << i + 1 << ": "; // Ejemplo: Se pide el codigo del primer empleado
    cin >> empleados[i].codigo_numerico;                                 // Se guarda el codigo en esa variable con la posicion del empleado
    cout << "Ingrese el primer nombre del empleado " << i + 1 << ": ";   // i+1 = Posicion real
    cin >> empleados[i].p_nombre;
    cout << "Ingrese el segundo nombre del empleado " << i + 1 << ": ";
    cin >> empleados[i].s_nombre;
    cout << "Ingrese el primer apellido del empleado " << i + 1 << ": ";
    cin >> empleados[i].p_apellido;
    cout << "Ingrese el segundo apellido del empleado: " << i + 1 << ": ";
    cin >> empleados[i].s_apellido;
    cout << "Ingrese el numero celular del empleado: " << i + 1 << ": ";
    cin >> empleados[i].celular;
    archivo.write((char *)&empleados[i], sizeof(empleado)); // Escribir empleados[i] en el archivo
    contador++;                                             // Contador aumenta para ingresar el siguiente empleado
  }
  archivo.close(); // Cierre del archivo
  return contador; // Contador va a devolver la cantidad de empleados registrados
}

// Funcion -  Agrega un Nuevo Empleado

int agregar_nuevo_empleado(empleado empleados[], int contador)
{
  cout << endl;
  int verificar = 0, hasta = 1; // Banderas de verificacion
  int num;
  cout << "Ingrese el codigo numerico del empleado a agregar: ";
  cin >> num;

  // Abrir el archivo en modo lectura y escritura

  ifstream archivo2;
  archivo2.open("empleados.bin", ios::binary);
  int i = 0;

  // Se crea un bucle para encontrar el codigo si existe en el archivo empleados.bin

  while (archivo2.read((char *)&empleados[i], sizeof(empleado))) // Archivo - Modo lectura - Va a leer la cadena de caracteres de empleados
  {                                                              // En el tamaño de la estructura empleado
    if (num == empleados[i].codigo_numerico)                     // Si el numero solicitado coincide con un empleado ya existente
    {
      cout << "El codigo numerico ya existe" << endl;
      verificar = 1; // Bandera cambia de estado a existe
      break;         // Sale de la funcion porque ya existe (No pueden haber empleados repetidos)
    }
    i++; // Busqueda iterativa de alguna coincidencia
  }
  archivo2.close(); // Cierre archivo de lectura

  if (verificar == 0) // No encontro ninguno existente (Nuevo Empleado)
  {
    ofstream archivo;                                      // Archivo - Modo de Escritura
    archivo.open("empleados.bin", ios::binary | ios::app); // app para agregar al final del archivo al nuevo empleado

    // Bucle while para ingresar los datos del nuevo empleado

    while (hasta != 0)
    {
      empleados[i].codigo_numerico = num;
      cout << "Ingrese el primer nombre del empleado: ";
      cin >> empleados[i].p_nombre;
      cout << "Ingrese el segundo nombre del empleado: ";
      cin >> empleados[i].s_nombre;
      cout << "Ingrese el primer apellido del empleado: ";
      cin >> empleados[i].p_apellido;
      cout << "Ingrese el segundo apellido del empleado: ";
      cin >> empleados[i].s_apellido;
      cout << "Ingrese el numero celular del empleado: ";
      cin >> empleados[i].celular;
      archivo.write((char *)&empleados[i], sizeof(empleado));
      i++;
      hasta = 0;  // Bandera cambia de estado para no guardar mas empleados (solo uno)
      contador++; // Aumenta solo un empleado, la cantidad antigua de empleados va ser contador+1
    }
    archivo.close();
  }
  return contador; // La funcion va a retornar la cantidad nueva del contador (nueva cantidad empleados)
}

// Funcion - Mostrar los empleados activos de la empresa

void mostrar_empleado(empleado empleados[], int contador)
{
  cout << endl;
  cout << "Estos son los nombres de los empleados:\n";
  ifstream archivoA;

  // Se va leer el archivo de empleados.bin para ser impreso en pantalla

  archivoA.open("empleados.bin", ios::binary);
  empleado empleadoAux;
  int i = 0;
  archivoA.read((char *)&empleadoAux, sizeof(empleado));
  while (!archivoA.eof()) // Mientras no este cerrado el archivo
  {
    cout << "-------------------------------------" << endl;
    cout << empleadoAux.codigo_numerico << " " << empleadoAux.p_nombre << " "
         << empleadoAux.s_nombre << " " << empleadoAux.p_apellido << " "
         << empleadoAux.s_apellido << " " << empleadoAux.celular << endl;
    cout << "-------------------------------------" << endl;
    archivoA.read((char *)&empleadoAux, sizeof(empleado));
    i++;
  }
  archivoA.close();
}

// Funcion - Cambiar el numero de celular de un empleado

void cambio_numero_empleado(empleado empleados[], int contador)
{
  cout << endl;
  int codigoBuscado = 0; // Bandera para un estado nulo
  cout << "Ingrese el codigo numerico del empleado: ";
  cin >> codigoBuscado;

  // Se abre el archivo empleados.bin para modificar el numero del empleado

  fstream archivo("empleados.bin", ios::in | ios::out | ios::binary); // Archivo - Modo Lectura y Escritura
  if (!archivo)                                                       // Si no se pudo abrir el archivo
  {
    cout << "No se pudo abrir el archivo" << endl;
    return; // Retorna al main y no ejecuta el codigo de la funcion
  }

  empleado emp;            // emp es tipo empleado
  bool encontrado = false; // encontrado empieza siendo falso

  while (!archivo.eof()) // Mientras el archivo no este cerrado
  {
    streampos pos = archivo.tellg();                                // Pos va ser la posicion del carácter en el flujo de entrada
    archivo.read(reinterpret_cast<char *>(&emp), sizeof(empleado)); // Modo de lectura del archivo
    if (emp.codigo_numerico == codigoBuscado)                       // Si encontro codigo solicitado
    {
      encontrado = true; // Cambio de estado a encontrado
      cout << "Ingrese el nuevo numero de telefono del empleado: ";
      cin >> emp.celular;                                              // Se guarda solo el numero en la variable (No modifica los otros datos)
      archivo.seekp(pos);                                              // Posicion en la que se insertara el siguiente caracter en el flujo de salida.
      archivo.write(reinterpret_cast<char *>(&emp), sizeof(empleado)); // Se guarda en el archivo (Se actualiza el dato)
      break;
    }
  }

  if (!encontrado) // Si no encontro el codigo en dentro de los empleados
  {
    std::cout << "No se encontro un empleado con ese codigo" << std::endl; // No se realiza el cambio del numero
  }

  archivo.close();
}

// Funcion - Despedir un empleado + Carta de Despido

int despedirEmpleado(int codigo, empleado empleados[], int &numNoDespedidos, empleado despedidos[], int *posdesp)
// empleados se devuelve como puntero y numNoDespedidos por referencia | Por temas de precision en las busquedas e inserciones
{
  cout << endl;
  ifstream archivo("empleados.bin", ios::binary); // Se crea el archivo empleados.bin en modo de lectura
  ofstream carta;                                 // Se crea otro archivo para la carta en modo de escritura
  empleado emp;
  bool encontrado = false;
  numNoDespedidos = 0; // La cantidad de personas que no fueron despedidas (numNoDespedidos)
  int i = 0, f = 0, aux, candes = 0;

  // Se va crear la carta tipo texto del despedido

  while (archivo.read(reinterpret_cast<char *>(&emp), sizeof(empleado))) // Bucle para encontrarlo en el archivo empleados.bin
  {
    if (emp.codigo_numerico == codigo)
    {
      encontrado = true;                                                 // Cambio de estado a encontrado
      carta.open("Carta_Despido_" + std::string(emp.p_nombre) + ".txt"); // Se crea un archivo txt (la carta) con el nombre del empleado a despedir
      // Generacion de Carta de Despido por empleado de la empresa

      carta<<"Estimado " << emp.p_nombre<<endl
            << "Me comunico con usted respetuosamente para hacerle saber que a partir del dia de hoy la empresa" << endl
            << "ha decidido prescindir de sus servicios, porque consideramos que su rendimiento hasta el dia de "
            << endl
            << "hoy no ha sido el mejor, por lo tanto solicitamos que entre el dia de hoy o manana haga entrega de "
            << endl
            << "su puesto de trabajo y las herramientas otorgadas por esta entidad a su jefe lo mas pronto posible."
            << endl
            << endl
            << "De igual manera queremos agradecerle por los servicios prestados hasta el dia de hoy en la "
            << endl
            << "empresa y por hacer parte activa de nuestro equipo de trabajo, manifestamos de igual forma que "
            << endl
            << "todas sus prestaciones laborales y salariales seran liquidadas en el tiempo establecido para esto."
            << endl
            << endl
            << "Atentamente," << endl
            << endl
            << "Minosaurios Tech, Presidente." << endl
            << endl;

      // Se guardan los datos del desempleado en la variable despedidos[posicion correspondiente]
      despedidos[*posdesp].codigo_numerico = emp.codigo_numerico;

      // strcpy se usa para guardar la cadena de caracteres del empleado
      strcpy(despedidos[*posdesp].p_nombre, emp.p_nombre);
      strcpy(despedidos[*posdesp].s_nombre, emp.s_nombre);
      strcpy(despedidos[*posdesp].p_apellido, emp.p_apellido);
      strcpy(despedidos[*posdesp].s_apellido, emp.s_apellido);
      despedidos[*posdesp].celular = emp.celular;
      (*posdesp)++;  // Se aumenta la posicion de para que no se guarde el siguiente empleado en la misma posicion
      candes++;      // Aumenta la cantidad de despedidos cada vez que se genera una carta
      carta.close(); // Cierra del archivo de escritura (carta.txt)
    }
    else // Si no se encontro el empleado con el codigo a despedir
    {
      empleados[numNoDespedidos++] = emp; // Pasa al siguiente empleado para ver si se solicita despedir
    }                                     // Generando una carta de despido solo por cada empleado (Cartas individuales)
  }

  archivo.close(); // Cierre del archivo de lectura (empleado.bin)

  if (!encontrado)
  {
    cout << "No se encontrado un empleado con el codigo " << codigo << endl;
    return 0; // No encontro el codigo, entonces retorna al main
  }

  ofstream nuevoArchivo("empleados.bin", ios::binary); // Crea un archivo donde va reescbir todo el contenido de empleados.bin

  // Ciclo for para llenar el archivo con los datos de los empleados vigentes

  for (i = 0; i < numNoDespedidos; i++)
  {
    nuevoArchivo.write(reinterpret_cast<char *>(&empleados[i]),
                       sizeof(empleado));
  }

  return candes; // Retorna la cantidad de despedidos (Solo seria un 1 pero candes es un acumulador en el main)
}

// Funcion - Mostrar registro de los empleados despedidos

void mostrar_despedidos(empleado despedidos[], int cantdesp)
{
  cout << endl;
  int i = 0;

  // Se imprimen los empleados despedidos en un bucle, con todos los datos de un empleado

  while (i < cantdesp) // Mientras se menor o igual a la cantidad de empleados despedidos
  {
    cout << "-------------------------------------------------------------" << endl;
    cout << despedidos[i].codigo_numerico << " " << despedidos[i].p_nombre
         << " " << despedidos[i].s_nombre << " " << despedidos[i].p_apellido
         << " " << despedidos[i].s_apellido << " " << despedidos[i].celular
         << endl;
    cout << "-------------------------------------------------------------" << endl;
    i++;
  }
}
