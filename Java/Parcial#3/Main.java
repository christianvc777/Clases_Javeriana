

/******************************************************************************
                    Parcial #3 - Programación Avanzada
                    Objetivo: Modelos de Machine Learning
                    Teoria: Clases Abstractas y Overriding
                    Programador: Cristian Vargas Cuadros
*******************************************************************************/

import java.util.ArrayList;
import java.util.List;

// Clase abstracta Modelo
abstract class Modelo {
    protected String nombre;
    protected int parametros;

    // Constructor de Modelo
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

    // Método abstracto entrenar (polimorfismo)
    public abstract void entrenar();
}

// Clase ModeloLineal que hereda de Modelo
class ModeloLineal extends Modelo {
    public double coeficienteCorrelacion;
    public double errorCuadraticoMedio;

    // Constructor de ModeloLineal
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

    // Sobreescribir el método entrenar en ModeloLineal
    @Override
    public void entrenar() {
        System.out.println("Entrenando modelo lineal: " + nombre);
        System.out.println("Número de parámetros: " + parametros);
        System.out.println("Coeficiente de correlación inicial: " + coeficienteCorrelacion);
        System.out.println("Error cuadrático medio inicial: " + errorCuadraticoMedio);
        System.out.println("Entrenamiento completado.");

        // Validar el modelo lineal
        if (coeficienteCorrelacion > 0.8 && errorCuadraticoMedio < 0.2) {
            System.out.println("El modelo " + nombre + " ha pasado la validación.");
        } else {
            System.out.println("El modelo " + nombre + " no ha pasado la validación.");
        }
    }
}

// Clase ModeloArbolDecision que hereda de Modelo
class ModeloArbolDecision extends Modelo {
    public int profundidadArbol;
    public int nodosHoja;

    // Constructor de ModeloArbolDecision
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

    // Sobreescribir el método entrenar en ModeloArbolDecision
    @Override
    public void entrenar() {
        System.out.println("Entrenando modelo de árbol de decisión: " + nombre);
        System.out.println("Número de parámetros: " + parametros);
        System.out.println("Profundidad del árbol: " + profundidadArbol);
        System.out.println("Número de nodos hoja: " + nodosHoja);
        System.out.println("Entrenamiento completado.");

        // Validar el modelo de árbol de decisión
        if (profundidadArbol < 10 && nodosHoja > 5) {
            System.out.println("El modelo " + nombre + " ha pasado la validación.");
        } else {
            System.out.println("El modelo " + nombre + " no ha pasado la validación.");
        }
    }
}

// Clase Validador
class Validador {
    // Método estático validarModelo
    public static void validarModelo(Modelo modelo) {
        // Mostrar info del método entrenar
        modelo.entrenar();
    }
}

public class Main {
    public static void main(String[] args) {
        
        // Crear instancias de los modelos ModeloLineal y ModeloArbolDecision
        Modelo modeloLineal1 = new ModeloLineal("Modelo Lineal 1", 2, 0.85, 0.1);
        Modelo modeloArbolDecision1 = new ModeloArbolDecision("Modelo Árbol Decisión 1", 3, 9, 8);
        Modelo modeloLineal2 = new ModeloLineal("Modelo Lineal 2", 2, 0.7, 0.3);
        Modelo modeloArbolDecision2 = new ModeloArbolDecision("Modelo Árbol Decisión 2", 3, 11, 4);

        // Crear una lista de Modelos y agregar los modelos a la lista
        List<Modelo> modelos = new ArrayList<>();
        modelos.add(modeloLineal1);
        modelos.add(modeloArbolDecision1);
        modelos.add(modeloLineal2);
        modelos.add(modeloArbolDecision2);

        // Entrenar y validar los modelos usando polimorfismo
        for (Modelo modelo : modelos) {
            Validador.validarModelo(modelo);
        }

        System.out.println("Author: Cristian Vargas Cuadros");
    }
}

