/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

/**
 *
 * @author Axel
 */
public class Archivo {
    private String RUTA_BASE = "D:\\Estructuras\\";
    private String USUARIO="DEFAULT";
    private String ALBUMS = "ALBUMS";
    private String FOTO = "FOTO"; 

    public Archivo(String USUARIO) {
        this.USUARIO = USUARIO;
        this.crearCarpetas();
    }
    public Archivo(){
        this.crearCarpetas();
    }
    
    public LinkedList readAlbum(){        
        String fileName=RUTA_BASE+"\\"+USUARIO+"\\"+ALBUMS+"\\"+ALBUMS+".txt";
        return this.read(fileName);
    }
    public boolean saveAlbum(LinkedList object){        
        String fileName=RUTA_BASE+"\\"+USUARIO+"\\"+ALBUMS+"\\"+ALBUMS+".txt";
        return this.save(object,fileName);
    }
    private LinkedList read(String fileName){
        // Deserialization 
        LinkedList objects = null;
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(fileName); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            objects = (LinkedList) in.readObject();               
            in.close(); 
            file.close();               
            System.out.println("Object has been deserialized ");
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("Nothing to read"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
        return objects;
        
    }
    private boolean save(LinkedList object,String fileName){
        // Serialization  
        try
        {    
            //Saving of object in a file 
            FileOutputStream file = new FileOutputStream(fileName); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(object); 
              
            out.close(); 
            file.close(); 
              
            System.out.println("Object has been serialized"); 
            return true;
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
            return false;
        } 
  
    
    }
    private void crearCarpetas(){
        File principal = new File(RUTA_BASE);
        principal.mkdirs();
        File usuario = new File(principal,USUARIO);
        usuario.mkdirs();
        File album = new File(usuario,ALBUMS);
        album.mkdirs();
        
    }
}
