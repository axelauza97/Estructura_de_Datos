/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author User
 */
public enum Reaccion{
        
    me_gusta ("Me gusta", 0), 

    me_encanta ("Me encanta", 1),

    me_entristece("Me entristece", 2),

    me_asombra ("Me asombra", 3),

    me_divierte ("Me divierte", 4),  

    me_enoja ("Me enoja",5);

    //Campos tipo constante   

    private final String nombre; //Color de la madera

    private final int identificador; //Peso específico de la madera

 

    /**

     * Constructor. Al asignarle uno de los valores posibles a una variable del tipo enumerado el constructor asigna 

        automáticamente valores de los campos

     */ 

    Reaccion (String nombre, int id) { 

        this.nombre = nombre;

        this.identificador = id;

    }

 

    //Métodos de la clase tipo Enum

    public String getNombre() { 
        return nombre; 
    }

    public int getId() {
        return identificador;
    }
}
