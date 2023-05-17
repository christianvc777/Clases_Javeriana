import java.util.Date;

public class Compra {
    private Date fechaCompra;
    private Cliente cliente;
    private Obra obra;
    private double precio;

    // Constructor
    public Compra(Cliente cliente, Obra obra, double precio) {
        this.fechaCompra = new Date(); // Fecha actual
        this.cliente = cliente;
        this.obra = obra;
        this.precio = precio;
    }

    // Getters y Setters
    public Date getFechaCompra() {
        return fechaCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Obra getObra() {
        return obra;
    }

    public double getPrecio() {
        return precio;
    }

    // Método para registrar una compra en la galería
    public void registrarCompra(ControlGaleria controlGaleria) {
        controlGaleria.registrarCompra(this);
    }
}
