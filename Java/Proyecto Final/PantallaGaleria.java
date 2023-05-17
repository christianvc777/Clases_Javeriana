import java.util.List;
import java.util.Scanner;

public class PantallaGaleria {
    private ControlGaleria controlGaleria;
    private ControlCliente controlCliente;
    private GestionObras gestionObras;

    public PantallaGaleria() {
        controlGaleria = new ControlGaleria();
        controlCliente = new ControlCliente();
        gestionObras = new GestionObras();
    }

    public void mostrarMenuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- MENÚ PRINCIPAL -----");
            System.out.println("1. Agregar artista");
            System.out.println("2. Agregar obra");
            System.out.println("3. Agregar cliente");
            System.out.println("4. Registrar compra");
            System.out.println("5. Listar artistas");
            System.out.println("6. Listar obras");
            System.out.println("7. Listar clientes");
            System.out.println("8. Listar compras de un cliente");
            System.out.println("9. Salir");
            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarArtista();
                    break;
                case 2:
                    agregarObra();
                    break;
                case 3:
                    agregarCliente();
                    break;
                case 4:
                    registrarCompra();
                    break;
                case 5:
                    listarArtistas();
                    break;
                case 6:
                    listarObras();
                    break;
                case 7:
                    listarClientes();
                    break;
                case 8:
                    listarComprasCliente();
                    break;
                case 9:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                    break;
            }

            System.out.println();
        } while (opcion != 9);
    }

    private void agregarArtista() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- AGREGAR ARTISTA -----");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        // Leer otros datos relevantes del artista, como fecha de nacimiento, nacionalidad, biografía, etc.

        Artista artista = new Artista(nombre, "", "", "");
        controlGaleria.agregarArtista(artista);
    }

    private void agregarObra() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- AGREGAR OBRA -----");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        // Leer otros datos relevantes de la obra, como técnica, año de creación, precio, etc.

        // Obtener la lista de artistas disponibles
        List<Artista> artistas = controlGaleria.listarArtistas();
        if (artistas.isEmpty()) {
            System.out.println("No hay artistas disponibles. Debes agregar al menos un artista antes de agregar una obra.");
            return;
        }

        System.out.println("Artistas disponibles:");
        for (int i = 0; i < artistas.size(); i++) {
            System.out.println((i + 1) + ". " + artistas.get(i).getNombre());
        }

        System.out.print("Selecciona el número del artista: ");
        int opcionArtista = scanner.nextInt();
        scanner.nextLine();

        if (opcionArtista >= 1 && opcionArtista <= artistas.size()) {
            Artista artistaSeleccionado = artistas.get(opcionArtista - 1);

            // Crear la instancia de Obra con los datos proporcionados
            Obra obra = new Obra(titulo, "", 0, 0.0, artistaSeleccionado);
            gestionObras.agregarObra(obra, controlGaleria);

            System.out.println("La obra se ha agregado exitosamente.");
        } else {
            System.out.println("Opción inválida. No se ha seleccionado un artista válido.");
        }
    }

    private void agregarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- AGREGAR CLIENTE -----");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        // Leer otros datos relevantes del cliente, como dirección, correo electrónico, etc.

        Cliente cliente = new Cliente(nombre, "", "");
        controlCliente.agregarCliente(cliente);
        controlGaleria.agregarCliente(cliente);

        System.out.println("El cliente se ha agregado exitosamente.");
    }

    private void registrarCompra() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- REGISTRAR COMPRA -----");
        // Obtener la lista de clientes disponibles
        List<Cliente> clientes = controlGaleria.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes disponibles. Debes agregar al menos un cliente antes de registrar una compra.");
            return;
        }

        System.out.println("Clientes disponibles:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNombre());
        }

        System.out.print("Selecciona el número del cliente: ");
        int opcionCliente = scanner.nextInt();
        scanner.nextLine();

        if (opcionCliente >= 1 && opcionCliente <= clientes.size()) {
            Cliente clienteSeleccionado = clientes.get(opcionCliente - 1);

            // Obtener la lista de obras disponibles
            List<Obra> obras = gestionObras.listarObras();
            if (obras.isEmpty()) {
                System.out.println("No hay obras disponibles. Debes agregar al menos una obra antes de registrar una compra.");
                return;
            }

            System.out.println("Obras disponibles:");
            for (int i = 0; i < obras.size(); i++) {
                System.out.println((i + 1) + ". " + obras.get(i).getTitulo());
            }

            System.out.print("Selecciona el número de la obra: ");
            int opcionObra = scanner.nextInt();
            scanner.nextLine();

            if (opcionObra >= 1 && opcionObra <= obras.size()) {
                Obra obraSeleccionada = obras.get(opcionObra - 1);

                System.out.print("Precio de la compra: ");
                double precioCompra = scanner.nextDouble();
                scanner.nextLine();

                Compra compra = new Compra(clienteSeleccionado, obraSeleccionada, precioCompra);
                controlGaleria.registrarCompra(compra);

                System.out.println("La compra se ha registrado exitosamente.");
            } else {
                System.out.println("Opción inválida. No se ha seleccionado una obra válida.");
            }
        } else {
            System.out.println("Opción inválida. No se ha seleccionado un cliente válido.");
        }
    }

    private void listarArtistas() {
        System.out.println("----- ARTISTAS DISPONIBLES -----");
        List<Artista> artistas = controlGaleria.listarArtistas();
        for (Artista artista : artistas) {
            System.out.println("- " + artista.getNombre());
        }
    }

    private void listarObras() {
        System.out.println("----- OBRAS DISPONIBLES -----");
        List<Obra> obras = gestionObras.listarObras();
        for (Obra obra : obras) {
            System.out.println( "- " + obra.getTitulo());
        }
    }

    private void listarClientes() {
        System.out.println("----- CLIENTES DISPONIBLES -----");
        List<Cliente> clientes = controlGaleria.listarClientes();
        for (Cliente cliente : clientes) {
            System.out.println("- " + cliente.getNombre());
        }
    }

    private void listarComprasCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("----- LISTAR COMPRAS DE UN CLIENTE -----");
        // Obtener la lista de clientes disponibles
        List<Cliente> clientes = controlGaleria.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes disponibles. No se puede listar compras.");
            return;
        }

        System.out.println("Clientes disponibles:");
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNombre());
        }

        System.out.print("Selecciona el número del cliente: ");
        int opcionCliente = scanner.nextInt();
        scanner.nextLine();

        if (opcionCliente >= 1 && opcionCliente <= clientes.size()) {
            Cliente clienteSeleccionado = clientes.get(opcionCliente - 1);

            List<Compra> comprasCliente = controlCliente.listarComprasCliente(clienteSeleccionado, controlGaleria);
            if (comprasCliente.isEmpty()) {
                System.out.println("El cliente no tiene compras registradas.");
                return;
            }

            System.out.println("Compras del cliente: " + clienteSeleccionado.getNombre());
            System.out.println();
            for (Compra compra : comprasCliente) {
                System.out.println("Fecha: " + compra.getFechaCompra().toString());
                System.out.println("Obra: " + compra.getObra().getTitulo());
                System.out.println("Precio: " + compra.getPrecio());
                System.out.println();
            }
        } else {
            System.out.println("Opción inválida. No se ha seleccionado un cliente válido.");
        }
    }

    public static void main(String[] args) {
        PantallaGaleria pantallaGaleria = new PantallaGaleria();
        pantallaGaleria.mostrarMenuPrincipal();
    }

          }