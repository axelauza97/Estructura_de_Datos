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
public class Foto {
    private String path;
    private String descripcion;
    private String lugar;
    private String fecha;
    private LinkedList personas;
    private LinkedList reacciones;
    private LinkedList keywords;
    private LinkedList comentarios;
    private Camara camara;
            
    public Foto(String descripcion, String lugar, String fecha) {
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    
    public Foto(String descripcion, String lugar, String fecha, LinkedList personas) {
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
        this.personas = personas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public LinkedList getPersonas() {
        return personas;
    }

    public void setPersonas(LinkedList personas) {
        this.personas = personas;
    }

    public LinkedList getReacciones() {
        return reacciones;
    }

    public void setReacciones(LinkedList reacciones) {
        this.reacciones = reacciones;
    }

    public LinkedList getKeywords() {
        return keywords;
    }

    public void setKeywords(LinkedList keywords) {
        this.keywords = keywords;
    }

    public LinkedList getComentarios() {
        return comentarios;
    }

    public void setComentarios(LinkedList comentarios) {
        this.comentarios = comentarios;
    }

    public Camara getCamara() {
        return camara;
    }

    public void setCamara(Camara camara) {
        this.camara = camara;
    }

    
}
