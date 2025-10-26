package miPrincipal.servicio;
import listaDoble.ListaDoble;
import listaDoble.PosicionIlegalException;
import pila.Pila;
import cola.Cola;

import miPrincipal.modelo.Libro;

public class ServicioDatos{
    
    private ListaDoble<Libro> lista;
    private Cola<Libro> cola;
    private Pila<Libro> pila;

    public ServicioDatos() {
        lista = new ListaDoble<>();
        cola = new Cola<>();
        pila = new Pila<>();
    }
  
    public void agregarALista(Libro valor) {
        lista.agregar(valor);
    }

    public Libro obtenerDeLista(int indice) throws PosicionIlegalException {
        return lista.getValor(indice);
    }

    public void agregarACola(Libro valor) {
        cola.encolar(valor);
    }

    public Libro obtenerDeCola() {
        return cola.obtenerFrente();
    }

    public void removerDeCola() {
        cola.desencolar();
    }

    public void agregarAPila(Libro valor) {
        pila.apilar(valor);
    }

    public Libro obtenerDePila() {
        return pila.cima();
    }

    public void removerDePila() {
        pila.retirar();
    }
}
