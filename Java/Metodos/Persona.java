public class Persona {
    private String nombre;
    
    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre);
    }
  
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
  
    public static void main(String[] args) {
        Persona persona1 = new Persona();
        persona1.setNombre("Carlos");
        persona1.saludar(); // imprime "Hola, mi nombre es Carlos"
        
        Persona persona2 = new Persona();
        persona2.setNombre("Sara");
        persona2.saludar(); // imprime "Hola, mi nombre es Sara"
    }
}

