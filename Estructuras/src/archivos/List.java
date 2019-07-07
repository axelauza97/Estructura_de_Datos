/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

/**
 *
 * @author User
 */
public interface List<E> {
   
   boolean addFirst(E n);
   boolean addLast(E n);
   boolean removeFirst();
   boolean removeLast();
   E  getFirst();
   E getLast();
   boolean insert(int index, E n);
   boolean contains(E n);
   E get(int index);
   int indexOf(E n);
   boolean isEmpty();
   E remove(int index);
   boolean remove(E n);
   E set(int index, E n);
   int size();

}
