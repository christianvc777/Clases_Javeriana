public class Obra {
    private String titulo;
    private String tecnica;
    private int anioCreacion;
    private double precio;
    private Artista artista;

    // Constructor de Obra
    public Obra(String titulo, String tecnica, int anioCreacion, double precio, Artista artista) {
        this.titulo = titulo;
        this.tecnica = tecnica;
        this.anioCreacion = anioCreacion;
        this.precio = precio;
        this.artista = artista;
    }

    // Getters y Setters de Obra
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }

    public int getAnioCreacion() {
        return anioCreacion;
    }

    public void setAnioCreacion(int anioCreacion) {
        this.anioCreacion = anioCreacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    // Método para agregar una obra a la galería
    public void agregarObra(ControlGaleria controlGaleria) {
        controlGaleria.agregarObra(this);
    }

    // Método para eliminar una obra de la galería
    public void eliminarObra(ControlGaleria controlGaleria) {
        controlGaleria.eliminarObra(this);
    }
}
