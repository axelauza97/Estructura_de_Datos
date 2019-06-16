/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.TDAFotos;

/**
 *
 * @author David Sanchez
 */
public class NodoFoto<E> {
    private E ruta;
    private NodoFoto<E> next;
    private NodoFoto<E> previous;

    public NodoFoto(E ruta) {
        this.ruta = ruta;
    }

    public E getRuta() {
        return ruta;
    }

    public NodoFoto<E> getNext() {
        return next;
    }

    public NodoFoto<E> getPrevious() {
        return previous;
    }

    public void setRuta(E ruta) {
        this.ruta = ruta;
    }

    public void setNext(NodoFoto<E> next) {
        this.next = next;
    }

    public void setPrevious(NodoFoto<E> previous) {
        this.previous = previous;
    }
}
