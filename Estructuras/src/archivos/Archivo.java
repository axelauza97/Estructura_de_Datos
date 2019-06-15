/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

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
    private String USUARIO;
    private String ALBUMS = "ALBUMS";
    private String GALERIA = "GALERIA";
    private String FOTO = "FOTO"; 

    public Archivo(String USUARIO) {
        this.USUARIO = USUARIO;
    }
    
    
    public LinkedList read(){
         // Deserialization 
        String fileName=RUTA_BASE+ALBUMS+USUARIO;
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
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
        return objects;
    }
    public boolean save(LinkedList object){
        // Serialization  
        String fileName=RUTA_BASE+ALBUMS+USUARIO;
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
}
