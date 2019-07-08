/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Model.TDAFotos.CircularDoublyLinkedList;
import archivos.Archivo;
import archivos.SimpleLinkedList;
import entidades.Album;
import entidades.Foto;
import entidades.Persona;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Tonny
 */
public class FrmBusqueda extends javax.swing.JPanel {
    SimpleLinkedList<Foto> fotos = new SimpleLinkedList();
    public Archivo a=FrmHome.archivo;
    HashSet<Foto> pics =new HashSet();
    SimpleLinkedList<Album> albums = new SimpleLinkedList();
    
    /**
     * Creates new form BusquedaCompleja
     */
    public FrmBusqueda() {
        
       
        initComponents();
        CircularDoublyLinkedList f;
        albums = a.readAlbum();
        Iterator it = albums.iterator();
        while(it.hasNext()){
            f=((Album)(it.next())).getFotos();
            Iterator i = f.iterator();
            while(i.hasNext()){
                fotos.addLast((Foto)i.next());
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        personas = new javax.swing.JTextField();
        fecha = new javax.swing.JTextField();
        lugar = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();

        jLabel1.setText("Busqueda Simple");

        jLabel3.setText("Persona(s)");

        jLabel4.setText("Fecha");

        jLabel5.setText("Lugar");

        personas.setText("jTextField1");

        fecha.setText("jTextField2");

        lugar.setText("jTextField3");

        buscar.setText("Buscar");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(personas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(fecha))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(buscar)
                            .addComponent(lugar))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(personas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lugar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(buscar)
                .addContainerGap(56, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        
// TODO add your handling code here:
        Comparator<Persona> cmppersona = new Comparator<Persona>() {
            @Override
            public int compare(Persona o1, Persona o2) {
                if(o1.getNombres().equals(o2.getApellidos())&&o1.getNombres().equals(o2.getNombres())){
                    return 0;
                }
                return -1;
            }
        };
        
        
        if(fecha.getText().equals(" ")&& lugar.getText().equals(" ") && personas.getText().equals(" "))
            JOptionPane.showMessageDialog(this, "¡Ingrese un parametro de busqueda por favor!", "Error", JOptionPane.ERROR_MESSAGE);
        else{
            if(!(personas.getText().length()==0)){
                String [] a = personas.getText().split(" ");
                Persona person = new Persona(a[0],a[1]);

                pics = person.Busqueda(fotos, cmppersona, person);
                }
            else if(!(fecha.getText().length()==0)){
                if(fecha.getText().contains(" entre ")){
                    try {
                        String fechas[] = fecha.getText().split("-");
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
                        
                        Date date1 = sdf.parse(fechas[0]);
                        
                        
                            Date date2 = sdf.parse(fechas[1]);
                            
                        
                        
                        Iterator itd = fotos.iterator();
                        while(itd.hasNext()){
                                Foto fot = ((Foto)itd.next());
                                Date date = sdf.parse(fot.getFecha());
                                if(date.compareTo(date1)==0||date.compareTo(date2)==0||(date.after(date1)&&date.before(date2))){
                                    pics.add(fot);
                                    
                                }
                            
                            
                        }
                        
                        
                    } catch (ParseException ex) {
                        Logger.getLogger(FrmBusqueda.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    
                        String date = fecha.getText();
                        Iterator itd = fotos.iterator();
                        while(itd.hasNext()){
                            Foto fot = ((Foto)itd.next());
                            if(fot.getFecha().equals(date)){
                                pics.add(fot);
                            }
                        }
                        
                    
                }
            }
            else if(lugar.getText().length()!=0){
               String a[] = lugar.getText().split(",");
               if(a.length==1){
                   Iterator itl = fotos.iterator();
                   while(itl.hasNext()){
                       Foto fot = (Foto)itl.next();
                       if(fot.getUbicacion().toString().contains(a[0])){
                           pics.add(fot);
                       }
                   }
               }
               if(a.length==2){
                   Iterator itl = fotos.iterator();
                   while(itl.hasNext()){
                       Foto fot = (Foto)itl.next();
                       if(fot.getUbicacion().toString().contains(a[0])&&fot.getUbicacion().toString().contains(a[1])){
                           pics.add(fot);
                       }
                   }
               }
               if(a.length==3){
                   Iterator itl = fotos.iterator();
                   while(itl.hasNext()){
                       Foto fot = (Foto)itl.next();
                       if(fot.getUbicacion().toString().contains(a[0])&&fot.getUbicacion().toString().contains(a[1])&&fot.getUbicacion().toString().contains(a[2])){
                           pics.add(fot);
                       }
                   }
               }
            }
        }
    }//GEN-LAST:event_buscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscar;
    private javax.swing.JTextField fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField lugar;
    private javax.swing.JTextField personas;
    // End of variables declaration//GEN-END:variables
}
