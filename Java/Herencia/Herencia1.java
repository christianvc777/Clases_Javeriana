public class persona{

    private String nombre;
    private String apellidos;
    private int edad;

    public persona(String nombre, String apellidos, int edad){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
    }

    public String getnombre(){
        return nombre;
    }
    public String getapellidos(){
        return apellidos;
    }
    public int getedad(){
        return edad;
    }
}