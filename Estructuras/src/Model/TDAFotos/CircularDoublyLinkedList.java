/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.TDAFotos;

import java.util.ListIterator;

/**
 *
 * @author David Sanchez
 */
public class CircularDoublyLinkedList<E> {
    //Como son listas circulares doblemente enlazadas solo se necesitara un nodo foto first y un efectivo
    private NodoFoto first;
    private int efectivo;

    public CircularDoublyLinkedList() {
        this.first = null;
        this.efectivo = 0;
    }
    
    public boolean addLast(E element) {
        NodoFoto<E> nodo = new NodoFoto(element);
        if(element == null)
            return false;
        else if(isEmpty()){
            this.first = nodo;
            this.first.setNext(this.first);
            this.first.setPrevious(this.first);
        }
        else {
            nodo.setNext(this.first);
            NodoFoto<E> tmp = this.first.getPrevious();
            this.first.setPrevious(nodo);
            tmp.setNext(nodo);
            nodo.setPrevious(tmp);
            this.first=nodo;
        }
        efectivo++;
        return true;
    }
    
    public boolean isEmpty(){
        return this.first == null;
    }
    
    public boolean removeLast(){
        if(isEmpty())
            return false;
        else if(efectivo == 1){
            this.first.setNext(null);
            this.first.setPrevious(null);
            this.first.setContent(null);
            this.first = null;
        }
        else {
            NodoFoto<E> tmp = this.first.getPrevious();
            this.first.setPrevious(tmp.getPrevious());
            tmp.setPrevious(null);
            tmp.setNext(null);
            tmp.setContent(null);
            this.first.getPrevious().setNext(this.first);
        }
        efectivo--;
        return true;        
    }

    @Override
    public String toString() {
        StringBuilder salida = new StringBuilder();
        salida.append("[ ");
        NodoFoto<String> nodo = this.first;
        for(int i =0; i < efectivo; i++){
            salida.append(nodo.getContent());
            if(i+1 != efectivo)
                salida.append(", ");
        }
        salida.append(" ]");
        return salida.toString();
    }
    
    public NodoFoto getFirts(){
        return this.first;
    }
    
    public ListIterator<E> listIterator(){
    ListIterator<E>  it = new ListIterator<E>(){
        private NodoFoto<E> nodoF = getFirts();
        private int control = -1;
        @Override
        public boolean hasNext() {
            return nodoF != null;
        }

        @Override
        public E next() {
            if(control == -1){
                nodoF = getFirts();
                control = 0;
            }
            E tmp = nodoF.getContent();
            nodoF = nodoF.getNext();
            return tmp;
        }

        @Override
        public boolean hasPrevious() {
            return nodoF != null;
        }

        @Override
        public E previous() {
            if(control == 0){
                nodoF = getFirts().getPrevious();
                control = -1;
            }
            E tmp = nodoF.getContent();
            nodoF = nodoF.getPrevious();
            return tmp;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void set(E e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void add(E e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    };
    return it;
    }
}
