/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Ubicacion implements Serializable{
    String pais, ciudad, lugar;
    
    public Ubicacion(String pais){
        this.pais = pais;
    }
    public Ubicacion(String pais, String ciudad){
        this.ciudad = ciudad;
        this.pais=pais;
    }
    public Ubicacion(String pais, String ciudad, String lugar){
        this.ciudad=ciudad;
        this.pais=pais;
        this.lugar=lugar;
    }
    
    public void setPais(String pais){
        this.pais=pais;
    }
    public void setCiudad(String ciudad){
        this.ciudad=ciudad;
    }
    public void setLugar(String lugar){
        this.lugar=lugar;
    }
    public String getPais( ){
        return this.pais;
    }
    public String getLugar(){
        return this.lugar;
    }
    public String getCiudad(){
        return this.ciudad;
    }
    @Override
    public String toString(){
        return "País: " + pais + "Ciudad: " + ciudad + "Lugar: " + lugar; 
    }
    }
