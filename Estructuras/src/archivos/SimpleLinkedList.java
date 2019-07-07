/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author User
 */
public class SimpleLinkedList <E> implements List<E>,Iterable<E> {
    private SimpleNode<E> first, last;
    private int efectivo;
    
    public SimpleLinkedList(){
        first = last = null;
        efectivo = 0;
    }
    
    @Override
    public boolean addFirst(E element) {
        SimpleNode<E> nodo = new SimpleNode<>(element);
        if(element == null)
            return false;
        else if(isEmpty())
            first = last = nodo;
        else{
            nodo.setNextNode(first);
            first = nodo;
        }
        efectivo++;
        return true;
    }

    @Override
    public boolean addLast(E element) {
        SimpleNode<E> nodo = new SimpleNode<>(element);
        if(element == null)
            return false;
        else if(isEmpty())
            first = last = nodo;
        else{
            last.setNextNode(nodo);
            last = nodo;
        }
        
        efectivo ++;
        return true;
    }

    @Override
    public E getFirst() {
        return first.getContent();
    }

    @Override
    public E getLast() {
        return last.getContent();
    }

    @Override
    public boolean removeFirst() {
        if(isEmpty())
            return false;
        else if(first == last)
            first = last = null;
        else{
            SimpleNode<E> tmp = first;
            first = first .getNextNode();
            tmp.setNextNode(null);
        }
        efectivo--;
        return true;
    }
    
    
    @Override
    public boolean removeLast(){
        if(this.isEmpty()) //si está vacío no se saca el nodo
            return false;
        else if(first == last) //si ambos son iguales solo hay un nodo en el arreglo
            first = last= null; //solo ese se remueve
        else{
            
            //Iterar nodos con un while hasta antes del last
            SimpleNode<E> nodo = first;
            while(nodo.getNextNode() != last){
                nodo = nodo.getNextNode();
            }
            
            last = nodo;
            last.setNextNode(null);
            
            /*
            Si se quiere iterar nodos hasta el final sería
            while(nodo.getNext() != null){     Ya que el último nodo no tiene
                nodo = nodo.getNext();         un nodo siguiente
            }
            */
        }
        return true;
    }
    
    private SimpleNode<E> getPrevious(SimpleNode<E> nodo){
        if(nodo == first)
            return null;
        for(SimpleNode<E> i = first; i != null; i = i.getNextNode()){
            if(i.getNextNode() == nodo)
                return i;
        }
        return null;
    }
    
    @Override
    public boolean isEmpty() {
        return (first == null && last == null);
    }

    @Override
    public boolean contains(E element) {
        if(element == null || isEmpty()){
            return false;
        }
        for(SimpleNode<E> i = first; i != null; i = i.getNextNode()){
            if(i.getContent().equals(element))
                return true;
        }
        return false;
    }

    @Override
    public boolean insert(int index, E element) {
        if(element == null || index < 0 || index >= efectivo) {
            return false;
        }else if(index == 0){
            addFirst(element);
            efectivo ++;
            return true;
        }else if( index == efectivo-1){
            addLast(element);
            efectivo ++;
            return true;
        }
        
        int i = 0;
        SimpleNode<E> nodo = new SimpleNode<>(element);
        for(SimpleNode<E> j = first; j != null; j = j.getNextNode()){
            if(index -1  == i){
                nodo.setNextNode(j.getNextNode());
                j.setNextNode(nodo);
                efectivo++;
                return true;
            }
            i++;
        }
        return false;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= efectivo)
            return null;
        int j = 0;
        for(SimpleNode<E> i = first; i != null; i = i.getNextNode()){
            if(j == index)
                return i.getContent();
            j++;
        }
        return null;
    }

    @Override
    public int indexOf(E element) {
        if(element == null)
            return -1;
        
        int j = 0;
        for(SimpleNode<E> i = first; i != null; i = i.getNextNode()){
            if(i.getContent().equals(element))
                return j;
            j++;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= efectivo){
            return null;
        }else if(index == 0){
            E tmp = getFirst();
            removeFirst();
            return tmp;
       }else if( index == efectivo - 1){
           E tmp = getLast();
           removeLast();
           return tmp;
        }
        
        SimpleNode<E> j = first.getNextNode();
        for (int i = 1; i != index-1; i++){
            j = j.getNextNode();
        }
        
        SimpleNode<E> tmp = j.getNextNode();
        j.setNextNode(tmp.getNextNode());
        tmp.setNextNode(null);
        efectivo--;
        return tmp.getContent();
        
        /**
        int j = 0;
        // Se empieza con el segundo porque ya validamos que hacer con el first
        for(Node<E> i = first.getNext(); i != null; i = i.getNext()){
            if(j == index){
                Node<E> previo = getPrevious(i);
                previo.setNext(i.getNext());
                i.setNext(null);
                efectivo--;
                return i.getData();
            }
            j++;
        }
        return null;**/
    }

    @Override
    public boolean remove(E element) {
        if(element == null) {
            return false;
        }else if(first.getContent().equals(element)){
            removeFirst();
            return true;
        }else if(last.getContent().equals(element)){
           removeLast();
           return true;
        }
        
        for(SimpleNode<E> i = first; i != null; i = i.getNextNode()){
            if(i.getContent().equals(element)){
                SimpleNode<E> previo = getPrevious(i);
                previo.setNextNode(i.getNextNode());
                i.setNextNode(null);
                efectivo--;
                return true;
            }
        }
        return false;
    }

    @Override
    public E set(int index, E element) {
        if (element == null || index < 0 || index >= efectivo){
            return null;
        }
        
        int j = 0;
        for(SimpleNode<E> i = first; i != null; i = i.getNextNode()){
            if(j == index){
                E tmp = i.getContent();
                i.setContent(element);
                return tmp;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return efectivo;
    }
    
    @Override
    public boolean equals(Object o){
        if(o == null || ! (o instanceof SimpleLinkedList))
            return false;
        SimpleLinkedList<E> lista = (SimpleLinkedList<E>) o;
        
        if(efectivo != lista.efectivo)
            return false;
        
        SimpleNode<E> nodo = lista.first;
        
        for(SimpleNode<E> i = first; i !=null; i = i.getNextNode()){
            if(!nodo.getContent().equals(i.getContent()))
                return false;
            
            nodo = nodo.getNextNode();
        }
        return true;
    }
    
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        if(isEmpty())
            return "[]";
        s.append("[");
        
        for(SimpleNode<E> i = first; i != null; i = i.getNextNode()){
            if(i != last)
                s.append(i.getContent() + ",");
            else
                s.append(i.getContent() + "]");
        }
        return s.toString();
    }
    
    public SimpleNode getFirstNode () {
        return first;
    }
    
    public SimpleNode getLastNode () {
        return last;
    }

    @Override
    public Iterator<E> iterator() {
            return new MyLinkedListIterator();
    }
    class MyLinkedListIterator implements Iterator<E>{

        SimpleNode<E> n = null;
        @Override
        public boolean hasNext() {
            if(n==null&&first!=null){
                return true;
            }
            else if(n!=null){
                return n.getNextNode()!=null;
            }
                return false;
        }

        @Override
        public E next() {
                if(n==null&&first!=null){
                    n = first;
                    return first.getContent();
                }
                else if(n!=null){
                    
                    n=n.getNextNode();
                    return n.getContent();
                }
            throw new NoSuchElementException();    
        }
        
    }
}