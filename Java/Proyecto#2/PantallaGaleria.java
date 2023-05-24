
/********************************************************
            Pontificia Universidad Javeriana
            Proyecto #2 - Programación Avanzada 
            Estudiante: Cristian Vargas Cuadros
*********************************************************/

//Librerias List y Scanner
import java.util.List;
import java.util.Scanner;

//Atributos de PantallaGaleria
public class PantallaGaleria {
  private ControlGaleria controlGaleria;
  private ControlCliente controlCliente;
  private GestionObras gestionObras;

  //Constructor de PantallaGaleria
  public PantallaGaleria() {
    controlGaleria = new ControlGaleria();
    controlCliente = new ControlCliente();
    gestionObras = new GestionObras();
  }
  
    //Menu Principal (Interfaz)
    public void mostrarMenuPrincipal() {
    Scanner scanner = new Scanner(System.in);
    int opcion;
    System.out.println("\n" + "GALERIA DE ARTE: Museo de la Javeriana" + "\n" + "Propietario: Cristian Vargas Cuadros" + "\n"
        + "Fecha de Inauguración: 21 de Mayo de 2023");

    //Metodos de la clase PantallaGaleria
    do {
      System.out.println("\n");
      System.out.println("----- MENÚ PRINCIPAL -----");
      System.out.println("1. Agregar artista");
      System.out.println("2. Agregar obra");
      System.out.println("3. Agregar cliente");
      System.out.println("4. Registrar compra");
      System.out.println("5. Listar artistas");
      System.out.println("6. Listar obras");
      System.out.println("7. Listar clientes");
      System.out.println("8. Listar compras de un cliente");
      System.out.println("9. Eliminar artista");
      System.out.println("10.Eliminar obra");
      System.out.println("11.Eliminar cliente");
      System.out.println("12.Salir");
      System.out.print("Selecciona una opción: ");
      opcion = scanner.nextInt();
      System.out.println("\n");
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
          eliminarArtista();
          break;
        case 10:
          eliminarObra();
          break;
        case 11:
          eliminarCliente();
          break;
        case 12:
          System.out.println("¡Esperamos que vuelvas pronto!");
          break;  
        default:
          System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
          break;
      }

      System.out.println();
    } while (opcion != 12);
  }

  //Metodo agregarArtista
  
  private void agregarArtista() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("----- AGREGAR ARTISTA -----");
    System.out.print("Nombre Completo: ");
    String nombre = scanner.nextLine();
    System.out.print("Fecha Nacimiento: ");
    String fechaNacimiento = scanner.nextLine();
    System.out.print("Nacionalidad: ");
    String nacionalidad = scanner.nextLine();
    System.out.print("Biografia: ");
    String biografia = scanner.nextLine();

    // Leer Datos relevantes del artista: Nombre,
    // fecha de nacimiento, nacionalidad y biografía

    Artista artista = new Artista(nombre, fechaNacimiento, nacionalidad, biografia);
    controlGaleria.agregarArtista(artista);
  }

  private void agregarObra() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("----- AGREGAR OBRA -----");
    System.out.print("Título: ");
    String titulo = scanner.nextLine();
    System.out.print("Tecnica: ");
    String tecnica = scanner.nextLine();
    System.out.print("Año de creación: ");
    int anioCreacion = scanner.nextInt();
    System.out.print("Precio: ");
    double precio = scanner.nextDouble();

    // Datos relevantes de la obra: Técnica, año de creación, precio.

    // Obtener la lista de artistas disponibles
    List<Artista> artistas = controlGaleria.listarArtistas();
    if (artistas.isEmpty()) {
      System.out.println("No hay artistas disponibles. Debes agregar al menos un artista antes de agregar una obra.");
      return;
    }

    System.out.println("\n" + "Artistas disponibles:");
    System.out.println("\n");
    for (int i = 0; i < artistas.size(); i++) {
      System.out.println("Artista #" + (i + 1) + "\n" + "Nombre: " + artistas.get(i).getNombre() + "\n"
          + "FechaNacimiento: " + artistas.get(i).getFechaNacimiento() + "\n" + "Nacionalidad: "
          + artistas.get(i).getNacionalidad() + "\n" + "Biografia: " + artistas.get(i).getBiografia() + "\n");
    }

    System.out.print("Selecciona el número del artista: ");
    int opcionArtista = scanner.nextInt();
    scanner.nextLine();

    if (opcionArtista >= 1 && opcionArtista <= artistas.size()) {
      Artista artistaSeleccionado = artistas.get(opcionArtista - 1);

      // Crear la instancia de Obra con los datos proporcionados
      Obra obra = new Obra(titulo, tecnica, anioCreacion, precio, artistaSeleccionado);
      gestionObras.agregarObra(obra, controlGaleria);

      System.out.println("La obra se ha agregado exitosamente.");
    } else {
      System.out.println("Opción inválida. No se ha seleccionado un artista válido.");
    }
  }

  //Metodo agregarCliente

  private void agregarCliente() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("----- AGREGAR CLIENTE -----");
    System.out.print("Nombre: ");
    String nombre = scanner.nextLine();
    System.out.print("Direccion: ");
    String direccion = scanner.nextLine();
    System.out.print("Correo Electronico: ");
    String correoElectronico = scanner.nextLine();
    
    // Leer datos relevantes del cliente: Nombre, dirección y correo electrónico.

    Cliente cliente = new Cliente(nombre, direccion, correoElectronico);
    controlCliente.agregarCliente(cliente);
    controlGaleria.agregarCliente(cliente);

    System.out.println("El cliente se ha agregado exitosamente.");
  }

  //Metodo eliminarArtista
  
private void eliminarArtista() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("----- ELIMINAR ARTISTA -----");
    listarArtistas();
    System.out.print("Selecciona el número del artista a eliminar: ");
    int opcionArtista = scanner.nextInt();
    scanner.nextLine();

    if (opcionArtista >= 1 && opcionArtista <= controlGaleria.listarArtistas().size()) {
        Artista artistaSeleccionado = controlGaleria.listarArtistas().get(opcionArtista - 1);
        controlGaleria.eliminarArtista(artistaSeleccionado);
        System.out.println("El artista ha sido eliminado exitosamente.");
    } else {
        System.out.println("Opción inválida. No se ha seleccionado un artista válido.");
    }
}

//Metodo eliminarObra
  
private void eliminarObra() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("----- ELIMINAR OBRA -----");
    listarObras();
    System.out.print("Selecciona el número de la obra a eliminar: ");
    int opcionObra = scanner.nextInt();
    scanner.nextLine();

    if (opcionObra >= 1 && opcionObra <= gestionObras.listarObras().size()) {
        Obra obraSeleccionada = gestionObras.listarObras().get(opcionObra - 1);
        gestionObras.eliminarObra(obraSeleccionada, controlGaleria);
        System.out.println("La obra ha sido eliminada exitosamente.");
    } else {
        System.out.println("Opción inválida. No se ha seleccionado una obra válida.");
    }
}

//Metodo eliminarCliente
  
private void eliminarCliente() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("----- ELIMINAR CLIENTE -----");
    listarClientes();
    System.out.print("Selecciona el número del cliente a eliminar: ");
    int opcionCliente = scanner.nextInt();
    scanner.nextLine();

    if (opcionCliente >= 1 && opcionCliente <= controlGaleria.listarClientes().size()) {
        Cliente clienteSeleccionado = controlGaleria.listarClientes().get(opcionCliente - 1);
        controlGaleria.eliminarCliente(clienteSeleccionado);
        System.out.println("El cliente ha sido eliminado exitosamente.");
    } else {
        System.out.println("Opción inválida. No se ha seleccionado un cliente válido.");
    }
}

//Metodo registrarCompra
  
private void registrarCompra() {
  Scanner scanner = new Scanner(System.in);
  System.out.println("\n");
  System.out.println("----- REGISTRAR COMPRA -----");

  List<Cliente> clientes = controlGaleria.listarClientes();
  if (clientes.isEmpty()) {
    System.out.println("No hay clientes disponibles. Debes agregar al menos un cliente antes de registrar una compra.");
    return;
  }

  System.out.println("Clientes disponibles:");
  for (int i = 0; i < clientes.size(); i++) {
    System.out.println("Cliente #" + (i + 1) + "\n" + "Nombre: " + clientes.get(i).getNombre() + "\n" + "Direccion: "
        + clientes.get(i).getDireccion() + "\n" + "Correo Electronico: " +
        clientes.get(i).getCorreoElectronico() + "\n");
  }

  System.out.print("Selecciona el número del cliente: ");
  int opcionCliente = scanner.nextInt();
  scanner.nextLine();

  if (opcionCliente >= 1 && opcionCliente <= clientes.size()) {
    Cliente clienteSeleccionado = clientes.get(opcionCliente - 1);

    List<Obra> obras = gestionObras.listarObras();
    if (obras.isEmpty()) {
      System.out.println("No hay obras disponibles. Debes agregar al menos una obra antes de registrar una compra.");
      return;
    }

    System.out.println("\n" + "Obras disponibles:");
    for (int i = 0; i < obras.size(); i++) {
      System.out.println("Obra #" + (i + 1) + "\n" + "Titulo: " + obras.get(i).getTitulo() + "\n" + "Tecnica: "
          + obras.get(i).getTecnica() + "\n" + "Año de Creación: "+obras.get(i).getAnioCreacion() + "\n" + "Precio: " + obras.get(i).getPrecio() + "\n" + "Artista: " + obras.get(i).getArtista().getNombre() + "\n");
    }

    System.out.print("Selecciona el número de la obra: ");
    int opcionObra = scanner.nextInt();
    scanner.nextLine();

    if (opcionObra >= 1 && opcionObra <= obras.size()) {
      Obra obraSeleccionada = obras.get(opcionObra - 1);

      double precioCompra = obras.get(opcionObra - 1).getPrecio();

      Compra compra = new Compra(clienteSeleccionado, obraSeleccionada, precioCompra);
      controlGaleria.registrarCompra(compra);

      // Mostrar un mensaje de confirmación
      System.out.println("¡Compra realizada con éxito!");

      // Imprimir los detalles de la compra
      System.out.println("Detalles de la compra:");
      System.out.println("Cliente: " + clienteSeleccionado.getNombre());
      System.out.println("Obra: " + obraSeleccionada.getTitulo());
      System.out.println("Precio de compra: " + precioCompra);
    } else {
      System.out.println("Opción de obra inválida. Vuelve a intentarlo.");
    }
  } else {
    System.out.println("Opción de cliente inválida. Vuelve a intentarlo.");
  }
}

//Metodo listarArtistas
  
  private void listarArtistas() {
    System.out.println("\n");
    System.out.println("----- ARTISTAS DISPONIBLES -----");
    List<Artista> artistas = controlGaleria.listarArtistas();
    int i = 0;
    for (Artista artista : artistas) {
      System.out.println("Artista #" + (i + 1) + "\n" + "Nombre: " + artista.getNombre() + "\n" + "Fecha Nacimiento: "
          + artista.getFechaNacimiento() + "\n" + "Nacionalidad: " + artista.getNacionalidad() + "\n" + "Biografia: "
          + artista.getBiografia() + "\n");
      i++;
    }
  }

  //Metodo listarObras

  private void listarObras() {
    System.out.println("\n");
    System.out.println("----- OBRAS DISPONIBLES -----");
    int i = 0;
    List<Obra> obras = gestionObras.listarObras();
    for (Obra obra : obras) {
      Artista artista = obra.getArtista();
      System.out.println(
          "Obra #" + (i + 1) + "\n" +
              "Obra: " + obra.getTitulo() + "\n" +
              "Técnica: " + obra.getTecnica() + "\n" +
              "Año de Creación: " + obra.getAnioCreacion() + "\n" +
              "Precio: $" + obra.getPrecio() + "\n" +
              "Artista: " + artista.getNombre() + "\n");
      i++;
    }
  }

  //Metodo listarClientes
  
  private void listarClientes() {
    System.out.println("\n");
    System.out.println("----- CLIENTES DISPONIBLES -----");
    List<Cliente> clientes = controlGaleria.listarClientes();
    int i = 0;
    for (Cliente cliente : clientes) {
      System.out.println("Cliente #" + (i + 1) + "\n" + "Nombre: " + cliente.getNombre() + "\n" + "Direccion: "
          + cliente.getDireccion() + "\n" + "Correo Electronico: " + cliente.getCorreoElectronico() + "\n");
      i++;
    }
  }

  //Metodo listarComprasCliente
  
  private void listarComprasCliente() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("\n");
    System.out.println("----- LISTAR COMPRAS DE UN CLIENTE -----");
    // Obtener la lista de clientes disponibles
    List<Cliente> clientes = controlGaleria.listarClientes();
    if (clientes.isEmpty()) {
      System.out.println("No hay clientes disponibles. No se puede listar compras.");
      return;
    }

    System.out.println("Clientes disponibles:");
    for (int i = 0; i < clientes.size(); i++) {
      System.out.println("Cliente #" + (i + 1) + "\n" + "Nombre: " + clientes.get(i).getNombre() + "\n" + "Direccion: "
          + clientes.get(i).getDireccion() + "\n" + "Correo Electronico: " + clientes.get(i).getCorreoElectronico()
          + "\n");
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

  //Metodo Main
  
  public static void main(String[] args) {
    PantallaGaleria pantallaGaleria = new PantallaGaleria();
    pantallaGaleria.mostrarMenuPrincipal();
    
   //Author: Cristian Vargas Cuadros 
  
  }
}