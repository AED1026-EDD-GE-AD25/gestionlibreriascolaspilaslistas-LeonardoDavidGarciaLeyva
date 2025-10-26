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

    public Libro crearLibro(String titulo, String autor, String isbn){
        Libro libro = new Libro(titulo, autor, isbn);
        return libro;
    }

    public Pedido crearPedido(Libro libro, Fecha fecha){
        Pedido pedido = new Pedido(libro, fecha);
        return pedido;
    }

    public void devolverLibro() {
       

    }

    public void eliminarUltimoLibro(){
        

    }

    public void deshacerEliminarLibro(){
        

    }

    public void buscarLibro(String isbn) {

        

    }


}