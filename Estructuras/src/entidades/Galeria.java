/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Axel
 */
public class Galeria {
    
    private ArrayList<Object> albumFoto;

    public Galeria() {
        albumFoto=new ArrayList<>();
    }
    
    public boolean llenarGaleria(Queue fotos,Queue album){
        //Fotos sin Album
        albumFoto.add(fotos);
        albumFoto.add(album);
        return true;
    }
    public Queue getAlbum(){
        return (Queue) albumFoto.get(0);
    }
    public Queue getFotos(){
        return (Queue) albumFoto.get(1);
    }
    
}
