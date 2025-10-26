package cola;
import listaDoble.Nodo;

public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tamanio;

    public Cola() {
        frente = null;
        fin = null;
        tamanio = 0;
    }

    public int getTamanio() {
        return tamanio;
    }

    public boolean esVacia() {
        return (frente == null);
    }

    public void encolar(T valor) {
        Nodo<T> nuevo = new Nodo<T>();
        nuevo.setValor(valor);
        if (esVacia()) {
            frente = nuevo;
            fin = nuevo;
        } else {
            fin.setSiguiente(nuevo);
            fin = nuevo;
        }
        tamanio++;
    }

    public void desencolar() {
        if (!esVacia()) {
            frente = frente.getSiguiente();
            tamanio--;
            if (esVacia()) {
                fin = null;
            }
        }
    }

    public T obtenerFrente() {
        if (!esVacia())
            return frente.getValor();
        else
            return null;
    }
}