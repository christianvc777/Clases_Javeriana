import java.util.ArrayList;
import java.util.List;

public class ControlGaleria {
    private List<Artista> artistas;
    private List<Cliente> clientes;
    private List<Obra> obras;
    private List<Compra> compras;

    public ControlGaleria() {
        artistas = new ArrayList<>();
        clientes = new ArrayList<>();
        obras = new ArrayList<>();
        compras = new ArrayList<>();
    }

    // Métodos para agregar y eliminar artistas
    public void agregarArtista(Artista artista) {
        artistas.add(artista);
    }

    public void eliminarArtista(Artista artista) {
        artistas.remove(artista);
    }

    // Métodos para agregar y eliminar clientes
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    // Métodos para agregar y eliminar obras
    public void agregarObra(Obra obra) {
        obras.add(obra);
    }

    public void eliminarObra(Obra obra) {
        obras.remove(obra);
    }

    // Método para registrar una compra
    public void registrarCompra(Compra compra) {
        compras.add(compra);
    }

    // Métodos para listar artistas, clientes, obras y compras disponibles
    public List<Artista> listarArtistas() {
        return artistas;
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }

    public List<Obra> listarObras() {
        return obras;
    }

    public List<Compra> listarCompras() {
        return compras;
    }
}
