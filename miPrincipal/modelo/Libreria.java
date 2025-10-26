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

    public void obtenerLibros(){
       

    }

    public void agregarLibroCola(){

        

    }

    public void obtenerLibroCola(){

       
        

    }
    public voic obtenerLibroPila(){
        


    }

    public void crearLibro(){
        
    }

    public void crearPedido(){
        

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