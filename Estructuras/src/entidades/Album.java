/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.LinkedList;

/**
 *
 * @author Axel
 */
public class Album {
    private String nombre;
    private String descripcion;
    //CIRCULAR
    private LinkedList fotos;

    public Album(String nombre, String descripcion, LinkedList fotos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fotos = fotos;
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

    public LinkedList getFotos() {
        return fotos;
    }

    public void setFotos(LinkedList fotos) {
        this.fotos = fotos;
    }
    
    
}
