/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.TDAFotos;

import entidades.Foto;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author Axel
 */
public class CircularDoublyLinkedList<E> implements Serializable{
    private NodoFoto<E> tail=null;
    private int size=0;
    
    public CircularDoublyLinkedList(){
        tail=new NodoFoto<>();
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
         return size == 0;
    }
    public E ﬁrst() { // returns (but does not remove) the ﬁrst element  
        if (isEmpty()) return null; 
        return tail.getNext().getContent(); // the head is *after* the tail  
    }
    public E last() { // returns (but does not remove) the ﬁrst element  
        if (isEmpty()) return null; 
        return tail.getContent(); // the head is *after* the tail  
    }
    
    /*public void rotate() { // rotate the ﬁrst element to the back of the list 
         if (tail != null) // if empty, do nothing 
             tail = tail.getNext(); // the old head becomes the new tail 
    }*/
    public void addFirst(E e) { // adds element e to the front of the list 
        if (size == 0) { 
            tail.setContent(e);
            tail.setNext(tail); // link to itself circularly
        } else{
            NodoFoto firstOld=(NodoFoto) tail.getNext().getContent();
            NodoFoto firstNew=new NodoFoto<Foto>((Foto) e);
            firstNew.setNext(firstOld);
            firstOld.setPrevious(firstNew);
            tail.setNext(firstNew);
            firstNew.setPrevious(tail);
        }
        size++;
    }
    public void addLast(E e) { // adds element e to the front of the list 
        NodoFoto tailNew=new NodoFoto<Foto>((Foto) e);
        tailNew.setPrevious(tail);
        tailNew.setNext(tail.getNext());
        tail=tailNew;
        size++;
    }
    public E removeFirst() { // return element e to the front of the list 
        if(size==0)
            return null;
        if(size>1) {
            NodoFoto firstOld=tail.getNext();
            NodoFoto firstNew=firstOld.getNext();
            firstNew.setPrevious(tail);
            tail.setNext(firstNew);
            size--;
            return (E) firstOld.getContent();
        }else{ //size <1
            return removeLast();
        }
        
    }
    public E removeLast() { // return element e to the end of the list 
        if(size==0)
            return null;
        if(size>1){
            NodoFoto tailNew=tail.getPrevious();
            NodoFoto tailOld=new NodoFoto<Foto>((Foto) tail.getContent());
            NodoFoto first=tail.getNext();
            first.setPrevious(tailNew);
            tailNew.setNext(first);
            tail=tailNew;
            size--;
            return (E) tailOld.getContent();
        }else{
            NodoFoto old=new NodoFoto<Foto>((Foto) tail.getContent());
            tail.setContent(null);
            size--;
            return (E) old.getContent();
        }
    }
    
    public Iterator iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void add(E e) {
        addLast(e);
    }

    public E remove(E e) {
        return removeLast();
    }

    public void clear() {
        tail= new NodoFoto<E>();
    }
   
    public ListIterator<E> listIterator(){
    ListIterator<E>  it = new ListIterator<E>(){
        private NodoFoto<E> nodoFirst = new NodoFoto<E>(ﬁrst());
        private int control = -1;
        @Override
        public boolean hasNext() {
            return nodoFirst != null;
        }

        @Override
        public E next() {
            if(control == -1){
                nodoFirst = new NodoFoto<E>(ﬁrst());
                control = 0;
            }
            E tmp = nodoFirst.getContent();
            nodoFirst = nodoFirst.getNext();
            return tmp;
        }

        @Override
        public boolean hasPrevious() {
            return nodoFirst != null;
        }

        @Override
        public E previous() {
            if(control == 0){
                nodoFirst = new NodoFoto<E>(ﬁrst());
                nodoFirst = nodoFirst.getPrevious();
                control = -1;
            }
            E tmp = nodoFirst.getContent();
            nodoFirst = nodoFirst.getPrevious();
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
    
    @Override
    public String toString() {
        StringBuilder salida = new StringBuilder();
        salida.append("[ ");
        NodoFoto<String> nodo = (NodoFoto<String>) this.tail.getNext();
        for(int i =0; i < size; i++){
            salida.append(nodo.getContent());
            if(i+1 != size)
                salida.append(", ");
        }
        salida.append(" ]");
        return salida.toString();
    }
    
}
