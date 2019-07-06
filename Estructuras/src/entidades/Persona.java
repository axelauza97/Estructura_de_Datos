/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author User
 */
public class Persona implements Serializable {
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
        
}
