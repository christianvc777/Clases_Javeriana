import java.util.ArrayList;
import java.util.List;

public class ControlCliente {
    private List<Cliente> clientes;

    public ControlCliente() {
        clientes = new ArrayList<>();
    }

    // Método para agregar un cliente a la galería
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método para eliminar un cliente de la galería
    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    // Método para listar las compras de un cliente
    public List<Compra> listarComprasCliente(Cliente cliente, ControlGaleria controlGaleria) {
        List<Compra> comprasCliente = new ArrayList<>();
        List<Compra> compras = controlGaleria.listarCompras();

        for (Compra compra : compras) {
            if (compra.getCliente() == cliente) {
                comprasCliente.add(compra);
            }
        }

        return comprasCliente;
    }
}
