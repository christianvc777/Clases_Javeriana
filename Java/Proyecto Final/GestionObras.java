import java.util.ArrayList;
import java.util.List;

public class GestionObras {
    private List<Obra> obras;

    public GestionObras() {
        obras = new ArrayList<>();
    }

    // Método para agregar una obra a la galería
    public void agregarObra(Obra obra, ControlGaleria controlGaleria) {
        obras.add(obra);
        controlGaleria.agregarObra(obra);
    }

    // Método para eliminar una obra de la galería
    public void eliminarObra(Obra obra, ControlGaleria controlGaleria) {
        obras.remove(obra);
        controlGaleria.eliminarObra(obra);
    }

    // Método para agregar un artista a la galería
    public void agregarArtista(Artista artista, ControlGaleria controlGaleria) {
        controlGaleria.agregarArtista(artista);
    }

    // Método para eliminar un artista de la galería
    public void eliminarArtista(Artista artista, ControlGaleria controlGaleria) {
        controlGaleria.eliminarArtista(artista);
    }

    // Método para listar las obras disponibles
    public List<Obra> listarObras() {
        return obras;
    }
}
