/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author AxelAuzaA
 */
public class DoubleLinkedList<E> implements List<E>, Iterable<E> {

    private NodoDL<E> first, last;
    private int efectivo;

    @Override
    public boolean addFirst(E element) {
        NodoDL<E> nodo = new NodoDL<>(element);
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
        NodoDL<E> nodo = new NodoDL<>(element);
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
        return first.getData();
    }

    @Override
    public E getLast() {
        if (isEmpty()) {
            throw new NullPointerException("La lista esta vacía");
        }
        return last.getData();
    }

    @Override
    public boolean contains(E element) {
        if (element == null || isEmpty()) {
            return false;
        }
        if (first == last) {
            if (first.getData().equals(element)) {
                return true;
            }
        }
        for (NodoDL<E> i = first; i != null; i = i.getNext()) {
            if (i.getData().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean insert(int index, E element) {
        NodoDL<E> nodo = new NodoDL<>(element);
        NodoDL<E> temporal, temp;
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
    public boolean isEmpty() {
        return efectivo == 0;
    }

    @Override
    public int size() {
        return efectivo;
    }

    @Override
    public E remove(int index) {
        NodoDL<E> temporal = first, temp;
        if (isEmpty()) {
            throw new NullPointerException("La Lista esta vacia");
        }
        if (index < 0 || index > efectivo - 1) {
            throw new IndexOutOfBoundsException("Fuera de rango");
        }
        if (index == 0) {
            removeFirst();
            return temporal.getData();
        }
        if (index == efectivo - 1) {
            temp = last;
            removeLast();
            return temp.getData();

        }
        for (int i = 1; i < index; i++) {
            temporal = temporal.getNext();
        }
        temp = temporal.getNext();
        temp.getPrevious().setNext(temp.getNext());
        temp.getNext().setPrevious(temp.getPrevious());
        efectivo--;
        return temp.getData();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NodoDL<E> i = first; i != null; i = i.getNext()) {
            sb.append(i.getData());
            if (i != last) {
                sb.append(",");
            }
        }
        return "[" + sb + ']';
    }

    @Override
    public E set(int index, E element) {
        NodoDL<E> tmp = first, tmp2;
        if (element == null) {
            return null;
        } else if (index < 0 || index > efectivo - 1) {
            throw new IndexOutOfBoundsException("El indice está fuera de rango");
        }
        if (index == 0) {
            first.setData(element);
            return first.getData();
        }
        if (index == efectivo - 1) {
            last.setData(element);
            return last.getData();
        }
        for (int i = 1; i < index; i++) {
            tmp = tmp.getNext();
        }
        tmp.getNext().setData(element);
        return tmp.getNext().getData();
    }

    @Override
    public E get(int index) {
        NodoDL<E> nodo = first;
        if (this.isEmpty()) {
            return null;
        } else if (index < 0 || index > efectivo - 1) {
            throw new IndexOutOfBoundsException("El indice está fuera de rango");
        } else {
            for (int i = 0; i < index; i++) {
                nodo = nodo.getNext();
            }
            return nodo.getData();
        }
    }

    @Override
    public int indexOf(E element) {
        NodoDL<E> nodo = first;
        if (element == null || this.isEmpty()) {
            throw new NullPointerException("No existe ese elemento");
        }
        if (first.getData().equals(element)) {
            return 0;
        }
        for (int i = 1; i < efectivo; i++) {
            nodo = nodo.getNext();
            if (nodo.getData().equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof DoubleLinkedList)) {
            return false;
        }
        DoubleLinkedList<E> other = (DoubleLinkedList) o;
        if (this.size() != other.size()) {
            return false;
        }
        NodoDL<E> j = other.first;
        for (NodoDL<E> i = this.first; i != null; i = i.getNext()) {
            if (!i.getData().equals(j.getData())) {
                return false;
            }
            j = j.getNext();
        }
        return true;
    }


    private NodoDL<E> nodeIndex(int index) {
 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ListIterator<E> listIterator(int index) {
        ListIterator<E> it = new ListIterator<E>() {
            private NodoDL<E> p = nodeIndex(index);
            private int current = index;

            @Override
            public boolean hasNext() {
                return p != null;
            }

            @Override
            public E next() {
                E tmp = p.getData();
                p = p.getNext();
                current++;
                return tmp;
            }

            @Override
            public boolean hasPrevious() {
                return p != null;
            }

            @Override
            public E previous() {
                E tmp = p.getData();
                p = p.getPrevious();
                return tmp;
            }

            @Override
            public int nextIndex() {
                return current + 1;
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

        };return it;
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean remove(E element) {
            NodoDL<E> tmp;
        if (element == null) {
            return false;
        } else if (this.isEmpty()) {
            return false;
        }
        if (first.getData().equals(element)) {
            removeFirst();
            return true;
        }
        if (last.getData().equals(element)) {
            removeLast();
            return true;
        } else {
            for (NodoDL<E> i = first; i != null; i = i.getNext()) {
                if (i.getData().equals(element)) {
                    i.getPrevious().setNext(i.getNext());
                    i.getNext().setPrevious(i.getPrevious());
                    efectivo--;
                    return true;
                }
            }
        }
        return false;
    }
}
