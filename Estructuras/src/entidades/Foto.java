/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import archivos.SimpleLinkedList;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Axel
 */
public class Foto implements Serializable{
    private String path;
    private String descripcion;
    private Ubicacion ubicacion;
   
    private String fecha;
    private SimpleLinkedList<Persona> personas;
    private SimpleLinkedList<String> reacciones;
    private SimpleLinkedList<String> keywords;
    private String comentarios;
    private Camara camara;

    public Foto(String path, String descripcion, String ubicacion, String fecha, SimpleLinkedList<Persona> personas, SimpleLinkedList<String> reacciones, SimpleLinkedList<String> keywords, String comentarios, Camara camara) {
        this.path = path;
        this.descripcion = descripcion;
        this.ubicacion.lugar =ubicacion;
        this.fecha = fecha;
        this.personas = personas;
        this.reacciones = reacciones;
        this.keywords = keywords;
        this.comentarios = comentarios;
        this.camara = camara;
    }

    public Foto(String descripcion, Ubicacion ubicacion, String fecha) {
        this.descripcion = descripcion;
        this.ubicacion =ubicacion ;
        this.fecha = fecha;
    }
    

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public SimpleLinkedList<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(SimpleLinkedList<Persona> personas) {
        this.personas = personas;
    }

    public SimpleLinkedList<String> getReacciones() {
        return reacciones;
    }

    public void setReacciones(SimpleLinkedList<String> reacciones) {
        this.reacciones = reacciones;
    }

    public SimpleLinkedList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(SimpleLinkedList<String> keywords) {
        this.keywords = keywords;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Camara getCamara() {
        return camara;
    }

    public void setCamara(Camara camara) {
        this.camara = camara;
    }

    @Override
    public String toString() {
        return ubicacion.lugar + "{" + fecha + "}["+ camara+ "]";
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    
    
}
