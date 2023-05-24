public class Cliente {
    private String nombre;
    private String direccion;
    private String correoElectronico;

    // Constructor de Cliente
    public Cliente(String nombre, String direccion, String correoElectronico) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.correoElectronico = correoElectronico;
    }

    // Getters y Setters de Cliente
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    // Método para agregar un cliente a la galería
    public void agregarCliente(ControlCliente controlCliente) {
        controlCliente.agregarCliente(this);
    }

    // Método para eliminar un cliente de la galería
    public void eliminarCliente(ControlCliente controlCliente) {
        controlCliente.eliminarCliente(this);
    }
}
