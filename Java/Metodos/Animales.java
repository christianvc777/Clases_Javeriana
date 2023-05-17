public class Animal {
    public final void emitirSonido() {
        System.out.println("El animal emitió un sonido.");
    }
}

class Perro extends Animal {
    // No se puede sobrescribir el método emitirSonido() de la clase Animal
}

/*class Gato extends Animal {
    public void emitirSonido() {
        System.out.println("El gato maulló.");
    }
}*/


//El codigo principal tiene que crear otro fichero para compilar

public class Animales {
    public static void main(String[] args) {
        Animal perro = new Perro();
        perro.emitirSonido(); // Imprime "El animal emitió un sonido."
        
        /*Animal gato = new Gato();
        gato.emitirSonido(); // Imprime "El gato maulló."*/
    }
}



