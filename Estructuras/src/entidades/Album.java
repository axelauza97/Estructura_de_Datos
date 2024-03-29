/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import Model.TDAFotos.CircularDoublyLinkedList;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 *
 * @author Axel
 */
public class Album implements Serializable{
    private String nombre;
    private String descripcion;
    //CIRCULAR
    private CircularDoublyLinkedList<Foto> fotos;

    public Album(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        fotos=new CircularDoublyLinkedList<>();
    }
    public Album(String nombre, String descripcion, LinkedList fotos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        Iterator it=fotos.iterator();
        while(it.hasNext())
            this.fotos.addLast((Foto) it.next());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public CircularDoublyLinkedList getFotos() {
        return fotos;
    }

    public void setFotos(CircularDoublyLinkedList fotos) {
        this.fotos = fotos;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Album other = (Album) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return true;
    }
    public boolean containsFoto(Foto foto){
        return fotos.contains(foto);
    }
    
}
