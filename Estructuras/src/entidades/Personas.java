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
public class Personas implements Serializable {
        private String nombres;
        private String apellidos;
        
        
        public Personas(String nombres,String apellidos){
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
}
