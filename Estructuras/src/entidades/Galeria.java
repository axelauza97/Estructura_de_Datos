/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Axel
 */
public class Galeria implements Serializable{
    
    private ArrayList<Object> albumFoto;

    public Galeria() {
        albumFoto=new ArrayList<>();
    }
    
    public boolean llenarGaleria(LinkedList fotos,LinkedList album){
        //Fotos sin Album
        albumFoto.add(fotos);
        albumFoto.add(album);
        return true;
    }
    public LinkedList getAlbum(){
        return (LinkedList) albumFoto.get(0);
    }
    //sin album
    public LinkedList getFotos(){
        return (LinkedList) albumFoto.get(1);
    }
    
}
