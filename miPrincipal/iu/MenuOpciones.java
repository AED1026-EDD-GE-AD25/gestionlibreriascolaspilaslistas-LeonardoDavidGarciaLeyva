package miPrincipal.iu;
import miPrincipal.servicio.ServicioDatos;
import miPrincipal.modelo.Libro;
import miPrincipal.modelo.Pedido;
import miPrincipal.modelo.Libreria;
import java.util.Scanner;
import utilerias.Fecha;
import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import cola.Cola;
import pila.Pila;

public class MenuOpciones {
    static Scanner scanner = new Scanner(System.in);
    static private Libreria libreria = new Libreria();

    public static void agregarLibro() {
        System.out.print("Ingrese el titulo del libro: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro: ");
        String isbn = scanner.nextLine();

        Libro libro = libreria.crearLibro(titulo, autor, isbn);
        libreria.agregarLibro(libro);
        System.out.println("Libro agregado exitosamente.");
    }
    
    public static void mostrarLibros() throws PosicionIlegalException {
        System.out.println("\nLibros en la libreria:");
        System.out.println("----------------------");
        libreria.mostrarLibrosLista();
    }

    public static void agregarLibroCola() {
        System.out.print("Ingrese el titulo del libro para reserva: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el autor del libro para reserva: ");
        String autor = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro para reserva: ");
        String isbn = scanner.nextLine();

        Libro libro = libreria.crearLibro(titulo, autor, isbn);
        if (libreria.agregarLibroCola(libro)) {
            System.out.println("Libro agregado a la cola de reservas exitosamente.");
        } else {
            System.out.println("No se pudo agregar el libro a la cola de reservas.");
        }
    }

    public static Libro obtenerLibroCola() {
        Libro libro = libreria.obtenerLibroCola();
        if (libro != null) {
            System.out.println("Libro en frente de la cola: " + libro.getTitulo());
        } else {
            System.out.println("No hay libros en la cola de reservas.");
        }
        return libro;
    }

    public static void mostrarReservaLibros() {
        Cola<Libro> cola = libreria.mostrarReservaLibros();
        if (cola != null) {
            System.out.println("\nLibros en cola de reserva:");
            System.out.println("-------------------------");
            Libro libro;
            while ((libro = libreria.obtenerLibroCola()) != null) {
                System.out.println(libro.getTitulo() + " - " + libro.getAutor());
            }
        } else {
            System.out.println("No hay libros en reserva.");
        }
    }

    public static void crearPedido() {
        System.out.print("Ingrese el titulo del libro para el pedido: ");
        String tituloPedido = scanner.nextLine();
        System.out.print("Ingrese el autor del libro para el pedido: ");
        String autorPedido = scanner.nextLine();
        System.out.print("Ingrese el ISBN del libro para el pedido: ");
        String isbnPedido = scanner.nextLine();
        
        Libro libroPedido = libreria.crearLibro(tituloPedido, autorPedido, isbnPedido);
        Pedido pedido = null;
        
        if (libroPedido != null) {
            pedido = libreria.crearPedido(libroPedido, new Fecha());
            if (pedido != null) {
                System.out.println("Pedido creado exitosamente: " + pedido);
            } else {
                System.out.println("No fue posible crear el pedido");
            }
        } else {
            System.out.println("Error: no fue posible crear el Libro");
        }
    }

    public static void devolverLibro() throws PosicionIlegalException {
        System.out.print("Ingrese el ISBN del libro a devolver: ");
        String isbn = scanner.nextLine();
        
        Libro libro = libreria.buscarLibro(isbn);
        if (libro != null) {
            if (libreria.devolverLibro(libro)) {
                System.out.println("Libro devuelto exitosamente.");
            } else {
                System.out.println("No se pudo devolver el libro.");
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    public static Libro eliminarUltimoLibro() throws PosicionIlegalException {
        Libro libroEliminado = libreria.eliminarUltimoLibro();
        if (libroEliminado != null) {
            System.out.println("Libro eliminado: " + libroEliminado.getTitulo());
        } else {
            System.out.println("No hay libros para eliminar.");
        }
        return libroEliminado;
    }

    public static void deshacerEliminarLibro() {
        Libro libroRecuperado = libreria.deshacerEliminarLibro();
        if (libroRecuperado != null) {
            System.out.println("Se recuperó el libro: " + libroRecuperado.getTitulo());
        } else {
            System.out.println("No hay libros eliminados para recuperar.");
        }
    }
}
