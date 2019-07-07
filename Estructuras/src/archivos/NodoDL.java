/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

/**
 *
 * @author David Sanchez
 */
public class NodoDL<E> {
    private E data;
    private NodoDL<E> next, previous;

    public NodoDL(E data) {
        this.data = data;
        this.next = previous=next;
    }

    public E getData() {
        return data;
    }

    public NodoDL<E> getNext() {
        return next;
    }

    public NodoDL<E> getPrevious() {
        return previous;
    }

    public void setData(E data) {
        this.data = data;
    }

    public void setNext(NodoDL<E> next) {
        this.next = next;
    }

    public void setPrevious(NodoDL<E> previous) {
        this.previous = previous;
    }
    
    

   
}
