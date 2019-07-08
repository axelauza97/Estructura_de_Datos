/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import archivos.SimpleLinkedList;
import archivos.SimpleNode;
import java.io.Serializable;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

/**
 *
 * @author User
 */
public class Persona implements Serializable,Comparable {
        private String nombres;
        private String apellidos;
        
        
        public Persona(String nombres,String apellidos){
            this.nombres = nombres;
            this.apellidos=apellidos;
        }
        
        public String getNombres(){
            return this.nombres;
        }
        public String getApellidos(){
            return this.apellidos;
        }
        public void setNombres(String nombres){
            this.nombres=nombres;
        }
        public void setApellidos(String apellidos){
            this.apellidos=apellidos;
        }
        @Override
        public String toString(){
            return nombres + " "+ apellidos;
        }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Object o) {
            if(this.apellidos.equals(((Persona)o).apellidos)&&this.nombres.equals(((Persona)o).nombres)){
                return 0;
            }
            return -1;
    }
       
    
    /*Comparator<Persona> cmppersona = new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                if(o1.getNombres().equals(o2.getApellidos())&&o1.getNombres().equals(o2.getNombres())){
                    return 0;
                }
                return -1;
            }
        };*/
    
    public HashSet<Foto> Busqueda(SimpleLinkedList<Foto> fo, Comparator cmp, Persona p){
        HashSet<Foto> f=new HashSet();
        Iterator it = fo.iterator();
        SimpleNode<Foto> n; 
        for(n=fo.getFirstNode();n!=null;n.getNextNode()){
            Iterator i = n.getContent().getPersonas().iterator();
            while(i.hasNext()){
                if(cmp.compare((Persona)i.next(), p)==1){
                    f.add(n.getContent());
                }
            }
            
            
        }
        return f;
        
    }
}
