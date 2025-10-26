package miPrincipal.modelo;

import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import pila.Pila;
import cola.Cola;
import utilerias.Fecha;
import miPrincipal.servicio.ServicioDatos;
import java.util.Scanner;

public class Libreria{
    ServicioDatos dataService;
    ListaDoble<Libro> listaLibros;
    Cola<Libro> colaLibros;
    Pila<Libro> pilaLibrosEliminados;
    Scanner scanner; 

    public Libreria(){
        dataService = new ServicioDatos();
        scanner = new Scanner(System.in);
        listaLibros = new ListaDoble<>();
        colaLibros = new Cola<>();
        pilaLibrosEliminados = new Pila<>();

    }  
    
    public void agregarLibro(Libro libro){
        listaLibros.insertarFinal(libro);
    }

    public Lista obtenerLibros(){
        return listaLibros;
    }

    public boolean agregarLibroCola(Libro libro){
        colaLibros.encolar(libro);
        return true;
    }

    public Libro obtenerLibroCola(){
        return colaLibros.obtenerFrente();
    }
    public Libro obtenerLibroPila(){
        return pilaLibrosEliminados.obtenerTope();
    }

    public Cola mostrarReservaLibros(){
        return colaLibros;
    }

    public Libro crearLibro(String titulo, String autor, String isbn){
        Libro libro = new Libro(titulo, autor, isbn);
        return libro;
    }

    public Pedido crearPedido(Libro libro, Fecha fecha){
        Pedido pedido = new Pedido(libro, fecha);
        return pedido;
    }

    public Boolean devolverLibro(Libro libro){
        if (libro == null) {
            return false;
        }
        try {
            listaLibros.insertarFinal(libro);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Libro eliminarUltimoLibro(){
        try {
            Libro libroEliminado = listaLibros.obtenerUltimo();
            listaLibros.eliminarUltimo();
            pilaLibrosEliminados.apilar(libroEliminado);
            return libroEliminado;
        } catch (PosicionIlegalException e) {
            return null;
        }
    }

    public void mostrarLibrosLista(){
        try {
            for (int i = 1; i <= listaLibros.getTamanio(); i++) {
                Libro libro = listaLibros.obtenerElemento(i);
                System.out.println("Libro " + i + ": " + libro.getTitulo() + " - " + libro.getAutor() + " - " + libro.getIsbn());
            }
        } catch (PosicionIlegalException e) {
            System.out.println("Error al mostrar los libros: " + e.getMessage());
        }
    }

    public Libro deshacerEliminarLibro(){
        if (!pilaLibrosEliminados.estaVacia()) {
            Libro libro = pilaLibrosEliminados.obtenerTope();
            pilaLibrosEliminados.desapilar();
            listaLibros.insertarFinal(libro);
            return libro;
        }
        return null;
    }

    public Libro buscarLibro(String isbn) {
        if (isbn == null) {
            return null;
        }
        try {
            for (int i = 1; i <= listaLibros.getTamanio(); i++) {
                Libro libro = listaLibros.obtenerElemento(i);
                if (libro != null && isbn.equals(libro.getIsbn())) {
                    return libro;
                }
            }
        } catch (PosicionIlegalException e) {
            System.out.println("Error al buscar el libro: " + e.getMessage());
        }
        return null;
    }


}