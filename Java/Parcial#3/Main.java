
/******************************************************************************
                    Parcial #3 - Programación Avanzada
                    Objetivo: Modelos de Machine Learning
                    Teoria: Clases Abstractas y Overriding
                    Programador: Cristian Vargas Cuadros
*******************************************************************************/

// Clase abstracta Modelo
abstract class Modelo {
    protected String nombre;
    protected int parametros;
    
//Constructor de Modelo
    public Modelo(String nombre, int parametros) {
        this.nombre = nombre;
        this.parametros = parametros;
    }

// Getters para nombre y parametros
    public String getNombre() {
        return nombre;
    }

    public int getParametros() {
        return parametros;
    }
    
//Metodo abstracto entrenar (poliformismo)
    public abstract void entrenar();
}

// Clase ModeloLineal que hereda de Modelo
class ModeloLineal extends Modelo {
    public double coeficienteCorrelacion;
    public double errorCuadraticoMedio;
    
//Constructor de Modelo
    public ModeloLineal(String nombre, int parametros, double coeficienteCorrelacion, double errorCuadraticoMedio) {
        super(nombre, parametros);
        this.coeficienteCorrelacion = coeficienteCorrelacion;
        this.errorCuadraticoMedio = errorCuadraticoMedio;
    }

// Getters para coeficienteCorrelacion y errorCuadraticoMedio
    public double getCoeficienteCorrelacion() {
        return coeficienteCorrelacion;
    }

    public double getErrorCuadraticoMedio() {
        return errorCuadraticoMedio;
    }

//Sobreescribir el metodo entrenar en ModeloLineal
    @Override
    public void entrenar() {
        System.out.println("Entrenando modelo lineal: " + nombre);
        System.out.println("Número de parámetros: " + parametros);
        System.out.println("Coeficiente de correlación inicial: " + coeficienteCorrelacion);
        System.out.println("Error cuadrático medio inicial: " + errorCuadraticoMedio);
        System.out.println("Entrenamiento completado.");
    }
}

// Clase ModeloArbolDecision que hereda de Modelo
class ModeloArbolDecision extends Modelo {
    public int profundidadArbol;
    public int nodosHoja;

//Constructor de ModeloArbolDecision
    public ModeloArbolDecision(String nombre, int parametros, int profundidadArbol, int nodosHoja) {
        super(nombre, parametros);
        this.profundidadArbol = profundidadArbol;
        this.nodosHoja = nodosHoja;
    }

// Getters para profundidadArbol y nodosHoja
    public int getProfundidadArbol() {
        return profundidadArbol;
    }

    public int getNodosHoja() {
        return nodosHoja;
    }

//Sobreescribir el metodo entrenar ModeloArbolDecision 
    @Override
    public void entrenar() {
        System.out.println("Entrenando modelo de árbol de decisión: " + nombre);
        System.out.println("Número de parámetros: " + parametros);
        System.out.println("Profundidad del árbol: " + profundidadArbol);
        System.out.println("Número de nodos hoja: " + nodosHoja);
        System.out.println("Entrenamiento completado.");
    }
}

// Clase Validador
class Validador {
    
//Metodo estaticos validarModelo
    public static void validarModelo(Modelo modelo) {
        
//Mostrar info del metodo entrenar
        modelo.entrenar();

//Validacion de modelo si es una instancia ModeloLineal
        if (modelo instanceof ModeloLineal) {
            ModeloLineal modeloLineal = (ModeloLineal) modelo;
            if (modeloLineal.coeficienteCorrelacion > 0.8 && modeloLineal.errorCuadraticoMedio < 0.2) {
                System.out.println("El modelo " + modelo.nombre + " ha pasado la validación.");
            } else {
                System.out.println("El modelo " + modelo.nombre + " no ha pasado la validación.");
            }
            
//Validacion de modelo si es una instancia ModeloArbolDecision
        } else if (modelo instanceof ModeloArbolDecision) {
            ModeloArbolDecision modeloArbolDecision = (ModeloArbolDecision) modelo;
            if (modeloArbolDecision.profundidadArbol < 10 && modeloArbolDecision.nodosHoja > 5) {
                System.out.println("El modelo " + modelo.nombre + " ha pasado la validación.");
            } else {
                System.out.println("El modelo " + modelo.nombre + " no ha pasado la validación.");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        
//Crear instancias de los modelos ModeloLineal y ModeloArbolDecision
        ModeloLineal modeloLineal1 = new ModeloLineal("Modelo Lineal 1", 2, 0.85, 0.1);
        ModeloArbolDecision modeloArbolDecision1 = new ModeloArbolDecision("Modelo Árbol Decisión 1", 3, 9, 8);
        ModeloLineal modeloLineal2 = new ModeloLineal("Modelo Lineal 2", 2, 0.7, 0.3);
        ModeloArbolDecision modeloArbolDecision2 = new ModeloArbolDecision("Modelo Árbol Decisión 2", 3, 11, 4);

//Validacion de los modelos con el metodo validarModelo
        Validador.validarModelo(modeloLineal1);
        Validador.validarModelo(modeloArbolDecision1);
        Validador.validarModelo(modeloLineal2);
        Validador.validarModelo(modeloArbolDecision2);
        System.out.println("Author: Cristian Vargas Cuadros");

    }
   
}




