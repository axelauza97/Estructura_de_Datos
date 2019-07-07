/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import entidades.Camara;
import entidades.Persona;
import entidades.Usuario;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author Axel
 */
public class Archivo<T> {
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
    public SimpleLinkedList<Persona> readPersonas() {
        SimpleLinkedList<Persona> personas = new SimpleLinkedList();
        String fileName="src\\Resources\\personas.txt";
        try{
        File f = new File(fileName);
        if(f.exists()){
            FileReader fl=new FileReader(f);
            BufferedReader br = new BufferedReader(fl);
            String linea;
            while((linea=br.readLine())!=null){
                String[] per = linea.split("%");
                Persona p = new Persona(per[0],per[1]);
                
                personas.addLast(p);
            }
        }
        }catch(Exception e){
            System.out.println(e);
        }
        return personas;
    }
    public SimpleLinkedList<Camara> readCamaras() {
        SimpleLinkedList<Camara> camaras = new SimpleLinkedList();
        String fileName="src\\Resources\\camara.txt";
        try{
        File f = new File(fileName);
        if(f.exists()){
            FileReader fl=new FileReader(f);
            BufferedReader br = new BufferedReader(fl);
            String linea;
            while((linea=br.readLine())!=null){
                String[] per = linea.split("%");
                Camara p = new Camara(per[0],per[1]);
                
                camaras.addLast(p);
            }
        }
        }catch(Exception e){
            System.out.println(e);
        }
        return camaras;
    }
    
    public SimpleLinkedList<T> readAlbum(){        
        String fileName=RUTA_BASE+"\\"+USUARIO+"\\"+ALBUMS+"\\"+ALBUMS+".txt";
        return this.read(fileName);
    }
    public boolean saveAlbum(SimpleLinkedList<T> object){        
        String fileName=RUTA_BASE+"\\"+USUARIO+"\\"+ALBUMS+"\\"+ALBUMS+".txt";
        return this.save(object,fileName);
    }
    public SimpleLinkedList<T> read(String fileName){
        // Deserialization 
        SimpleLinkedList objects = null;
        try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(fileName); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            objects = (SimpleLinkedList) in.readObject();               
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
    public boolean save(SimpleLinkedList<T> object,String fileName){
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
