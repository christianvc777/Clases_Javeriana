
/*

Fecha: 14/04/2023
Quiz #1: Jugadores: ArrayList-Comparator-Collections
Por: Cristian Vargas Cuadros

Nota: Cambie los nombres del quiz al español, 
para que sea mas facil de leer y demostrar que 
el codigo funciona perfecto. 

*/

// Importamos las clases necesarias

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

// Clase Principal

public class Ajedrez {
    public static void main(String[] args) {
        // Creamos una lista de jugadores de ajedrez
        List<Jugador> jugadores = new ArrayList<>();
        //Agregamos jugadores a la lista
        jugadores.add(new Jugador("David", 2200, 29, 1500));
        jugadores.add(new Jugador("Laura", 2500, 26, 5000));
        jugadores.add(new Jugador("Santiago", 2300, 32, 2000));
        jugadores.add(new Jugador("Lucas", 2600, 27, 7000));
        jugadores.add(new Jugador("Carolina", 2400, 23, 3000));
        jugadores.add(new Jugador("Gabriel", 2550, 30, 6000));
        jugadores.add(new Jugador("Mónica", 2350, 28, 2500));

      /*En este caso como todos los niveles de Elo son diferentes,
      Ese seria el único criterio ejecutable, y ya todo el arreglo             de jugadores de ajedrez estaria ordenado
      */
      
        // Ordenar jugadores por ELO
        Collections.sort(jugadores, Comparator.comparing(Jugador::getElo).reversed());
        System.out.println("Jugadores ordenados por ELO:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
      
        // Se ordenan los jugadores por edad (Solo como ejemplo)
      
        Collections.sort(jugadores, Comparator.comparing(Jugador::getEdad));
        System.out.println("\nJugadores ordenados por edad:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }

// Se ordenan los jugadores por valor del premio (Solo como ejemplo)
      
        Collections.sort(jugadores, Comparator.comparing(Jugador::getValorPremio).reversed());
        System.out.println("\nJugadores ordenados por valor del premio:");
        for (Jugador jugador : jugadores) {
            System.out.println(jugador);
        }
    }
}

class Jugador {
    private String nombre;
    private int elo;
    private int edad;
    private int valorPremio;

    public Jugador(String nombre, int elo, int edad, int valorPremio) {
        this.nombre = nombre;
        this.elo = elo;
        this.edad = edad;
        this.valorPremio = valorPremio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getElo() {
        return elo;
    }

    public int getEdad() {
        return edad;
    }

    public int getValorPremio() {
        return valorPremio;
    }
   
  // Sobreescribimos el método toString() para que se muestren los valores de los atributos de manera legible
  
    public String toString() {
        return nombre + ", ELO: " + elo + ", Edad: " + edad + ", Valor del premio: " + valorPremio;
    }
}

