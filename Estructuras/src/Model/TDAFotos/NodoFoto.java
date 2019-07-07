/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.TDAFotos;

import java.io.Serializable;

/**
 *
 * @author David Sanchez
 */
public class NodoFoto<E> implements Serializable{
    private E content;
    private NodoFoto<E> next;
    private NodoFoto<E> previous;

    public NodoFoto(E content) {
        this.content = content;
    }
    public NodoFoto() {
    
    }
    public E getContent() {
        return content;
    }

    public NodoFoto<E> getNext() {
        return next;
    }

    public NodoFoto<E> getPrevious() {
        return previous;
    }

    public void setContent(E content) {
        this.content = content;
    }

    public void setNext(NodoFoto<E> next) {
        this.next = next;
    }

    public void setPrevious(NodoFoto<E> previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return "NodoFoto{" + "content=" + content + '}';
    }
    
}
