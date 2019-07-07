/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.TDAFotos;

import archivos.List;
import java.io.Serializable;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author Axel
 */
public class CircularDoublyLinkedList<E> implements List<E>, Iterable<E>, Serializable {

    private NodoFoto<E> last, first;
    private int efectivo = 0;

    public CircularDoublyLinkedList() {
        last = new NodoFoto<>();
    }

    public int size() {
        return efectivo;
    }

    public boolean isEmpty() {
        return efectivo == 0;
    }

    public E ﬁrst() { // returns (but does not remove) the ﬁrst element  
        if (isEmpty()) {
            throw new NullPointerException("La lista esta vacía");
        }

        return first.getContent();
    }

    public E last() { // returns (but does not remove) the ﬁrst element  
        if (isEmpty()) {
            throw new NullPointerException("La lista esta vacía");
        };
        return last.getContent(); // the head is *after* the tail  
    }

    /*public void rotate() { // rotate the ﬁrst element to the back of the list 
         if (tail != null) // if empty, do nothing 
             tail = tail.getNext(); // the old head becomes the new tail 
    }*/
    @Override
    public boolean addFirst(E element) {
        NodoFoto nodo = new NodoFoto<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            first = last = nodo;
        } else {
            nodo.setNext(first);
            first.setPrevious(nodo);
            first = nodo;
        }
        efectivo++;
        return true;

    }

    @Override
    public boolean addLast(E element) {
        NodoFoto<E> nodo = new NodoFoto<>(element);
        if (element == null) {
            return false;
        } else if (isEmpty()) {
            first = last = nodo;
        } else {
            nodo.setPrevious(last);
            last.setNext(nodo);
            last = nodo;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean removeFirst() {
        if (this.isEmpty()) {
            return false;
        } else if (first == last) {
            first = last = null;
        } else {
            first = first.getNext();
            first.getPrevious().setNext(null);
            first.setPrevious(null);
        }
        efectivo--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if (this.isEmpty()) {
            return false;
        } else if (first == last) {
            first = last = null;
        } else {
            last = last.getPrevious();
            last.getNext().setPrevious(null);
            last.setNext(null);
        }
        efectivo--;
        return true;
    }

    @Override
    public E getFirst() {
        if (isEmpty()) {
            throw new NullPointerException("La lista esta vacía");
        }
        return first.getContent();
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NullPointerException("La lista esta vacía");
        }
        return last.getContent();
    }

    @Override
    public boolean contains(E element) {
        if (element == null || isEmpty()) {
            return false;
        }
        if (first == last) {
            if (first.getContent().equals(element)) {
                return true;
            }
        }
        for (NodoFoto<E> i = first; i != null; i = i.getNext()) {
            if (i.getContent().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean insert(int index, E element) {
        NodoFoto<E> nodo = new NodoFoto<>(element);
        NodoFoto<E> temporal, temp;
        if (element == null || index < 0 || index > efectivo - 1 || isEmpty()) {
            return false;
        } else if (index == 0) {
            addFirst(element);
        } else if (index == efectivo - 1) {
            last.getPrevious().setNext(nodo);
            nodo.setPrevious(last.getPrevious());
            nodo.setNext(last);
            last.setPrevious(nodo);
        } else {
            temporal = first;
            for (int i = 1; i < index; i++) {
                temporal = temporal.getNext();
            }
            temp = temporal.getNext();
            temporal.setNext(nodo);
            nodo.setPrevious(temporal);
            nodo.setNext(temp);
            temp.setPrevious(nodo);
        }
        this.efectivo++;
        return true;

    }

    @Override
    public E remove(int index) {
        NodoFoto<E> temporal = first, temp;
        if (isEmpty()) {
            throw new NullPointerException("La Lista esta vacia");
        }
        if (index < 0 || index > efectivo - 1) {
            throw new IndexOutOfBoundsException("Fuera de rango");
        }
        if (index == 0) {
            removeFirst();
            return temporal.getContent();
        }
        if (index == efectivo - 1) {
            temp = last;
            removeLast();
            return temp.getContent();

        }
        for (int i = 1; i < index; i++) {
            temporal = temporal.getNext();
        }
        temp = temporal.getNext();
        temp.getPrevious().setNext(temp.getNext());
        temp.getNext().setPrevious(temp.getPrevious());
        efectivo--;
        return temp.getContent();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NodoFoto<E> i = first; i != null; i = i.getNext()) {
            sb.append(i.getContent());
            if (i != last) {
                sb.append(",");
            }
        }
        return "[" + sb + ']';
        
    }

    @Override
    public E set(int index, E element) {
        NodoFoto<E> tmp = first, tmp2;
        if (element == null) {
            return null;
        } else if (index < 0 || index > efectivo - 1) {
            throw new IndexOutOfBoundsException("El indice está fuera de rango");
        }
        if (index == 0) {
            first.setContent(element);
            return first.getContent();
        }
        if (index == efectivo - 1) {
            last.setContent(element);
            return last.getContent();
        }
        for (int i = 1; i < index; i++) {
            tmp = tmp.getNext();
        }
        tmp.getNext().setContent(element);
        return tmp.getNext().getContent();
    }

    @Override
    public E get(int index) {
        NodoFoto<E> nodo = first;
        if (this.isEmpty()) {
            return null;
        } else if (index < 0 || index > efectivo - 1) {
            throw new IndexOutOfBoundsException("El indice está fuera de rango");
        } else {
            for (int i = 0; i < index; i++) {
                nodo = nodo.getNext();
            }
            return nodo.getContent();
        }
    }

    @Override
    public int indexOf(E element) {
        NodoFoto<E> nodo = first;
        if (element == null || this.isEmpty()) {
            throw new NullPointerException("No existe ese elemento");
        }
        if (first.getContent().equals(element)) {
            return 0;
        }
        for (int i = 1; i < efectivo; i++) {
            nodo = nodo.getNext();
            if (nodo.getContent().equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof CircularDoublyLinkedList)) {
            return false;
        }
        CircularDoublyLinkedList<E> other = (CircularDoublyLinkedList) o;
        if (this.size() != other.size()) {
            return false;
        }
        NodoFoto<E> j = other.first;
        for (NodoFoto<E> i = this.first; i != null; i = i.getNext()) {
            if (!i.getContent().equals(j.getContent())) {
                return false;
            }
            j = j.getNext();
        }
        return true;
    }

    private NodoFoto<E> nodeIndex(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(E element) {
        NodoFoto<E> tmp;
        if (element == null) {
            return false;
        } else if (this.isEmpty()) {
            return false;
        }
        if (first.getContent().equals(element)) {
            removeFirst();
            return true;
        }
        if (last.getContent().equals(element)) {
            removeLast();
            return true;
        } else {
            for (NodoFoto<E> i = first; i != null; i = i.getNext()) {
                if (i.getContent().equals(element)) {
                    i.getPrevious().setNext(i.getNext());
                    i.getNext().setPrevious(i.getPrevious());
                    efectivo--;
                    return true;
                }
            }
        }
        return false;
    }

    public ListIterator listIterator() {
        ListIterator<E> it = new ListIterator<E>() {
            private NodoFoto<E> nodoFirst = new NodoFoto<E>(ﬁrst());
            private int control = -1;

            @Override
            public boolean hasNext() {
                return nodoFirst != null;
            }

            @Override
            public E next() {
                if (control == -1) {
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
                if (control == 0) {
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
    
}
