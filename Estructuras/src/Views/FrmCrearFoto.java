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
import entidades.Camara;
import entidades.Foto;
import entidades.Persona;
import entidades.Ubicacion;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.LinkedList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;



/**
 *
 * @author Axel
 */
public class FrmCrearFoto extends javax.swing.JFrame {

    private Archivo archivo=FrmHome.archivo;
    private Album album;
    private DefaultListModel modeloKeyword=new DefaultListModel();
    private DefaultListModel modeloPersonas=new DefaultListModel();
    private DefaultListModel modeloReaccion=new DefaultListModel();
    private SimpleLinkedList<Persona> personas=new SimpleLinkedList<>();
    private SimpleLinkedList<Camara> camaras=new SimpleLinkedList<>();
    private SimpleLinkedList<String> reaccion=new SimpleLinkedList<>();
    private SimpleLinkedList<String> keywords=new SimpleLinkedList<>();
    /**
     * Creates new form FrmCrearFoto
     */
    public FrmCrearFoto(Album album) {
        initComponents();
        this.album=album;
        lblFoto.setText("FOTO");
        personas = archivo.read("src\\Resources\\personas.txt");
        camaras = archivo.read("src\\Resources\\camaras.txt");
        
        if(personas==null || camaras==null){
            JOptionPane.showMessageDialog(this, "¡Crear Personas y Camaras Primero!", "Info", JOptionPane.INFORMATION_MESSAGE);
            FrmHome frm = new FrmHome();
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
            this.setVisible(false);
        }
        String[] strings = { "Like", "Love", "Haha", "Wow", "Sad", "Angry" };
        for(String re:strings){
            modeloReaccion.addElement(re);
        }
        ltReaccion.setModel(modeloReaccion);
        ltPersonas.setModel(modeloPersonas);
        ltKeyWord.setModel(modeloKeyword);
        if(personas==null){
            personas=new SimpleLinkedList<>();
        }
        else{
            for(Persona persona:personas){
                modeloPersonas.addElement(persona);
            }
        }
        
        
        if(camaras==null){
            camaras=new SimpleLinkedList<>();
        }
        else{
            for(Camara camara:camaras){
                cbCamara.addItem(camara);
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

        lblFoto = new javax.swing.JLabel();
        lblPath = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ltPersonas = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        ltKeyWord = new javax.swing.JList();
        txtFecha = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        cbCamara = new javax.swing.JComboBox();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtKeyword = new javax.swing.JTextField();
        btnQuitar = new javax.swing.JButton();
        btnAnadir = new javax.swing.JButton();
        btnPath = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtLugar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ltReaccion = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setViewportView(ltPersonas);

        jScrollPane3.setViewportView(ltKeyWord);

        txtComentario.setColumns(20);
        txtComentario.setRows(5);
        jScrollPane4.setViewportView(txtComentario);

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane5.setViewportView(txtDescripcion);

        jLabel1.setText("Path");

        jLabel2.setText("Descripcion");

        jLabel3.setText("Lugar");

        btnQuitar.setText("Quitar");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        btnAnadir.setText("Añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        btnPath.setText("...");
        btnPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPathActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha");

        jLabel5.setText("Personas");

        jLabel6.setText("Reacciones");

        jLabel7.setText("KeyWords");

        jLabel8.setText("Comentarios");

        jLabel9.setText("Camara");

        ltReaccion.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Like", "Love", "Haha", "Wow", "Sad", "Angry" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ltReaccion);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(88, 88, 88)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLugar)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addComponent(btnPath))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(103, 103, 103)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(txtKeyword))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnQuitar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAnadir))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2)
                    .addComponent(jLabel9))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(cbCamara, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVolver))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(btnPath))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel8)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnQuitar)
                            .addComponent(btnAnadir))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(btnCrear)
                                            .addGap(30, 30, 30)))
                                    .addComponent(btnVolver))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addComponent(lblPath, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1011, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPath)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPathActionPerformed
        // TODO add your handling code here:
        JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        if (file != null) {
            String fileName = file.getAbsolutePath();
            lblPath.setText(fileName);
            lblFoto.setText("");
            ImageIcon imageIcon = new ImageIcon(fileName); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it 
            Dimension d=lblFoto.getSize();
            Image newimg = image.getScaledInstance(Math.round((float) d.getWidth()), (int) Math.round(d.getHeight()), java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg);  // transform it back
            lblFoto.setIcon(imageIcon);
        }
    }//GEN-LAST:event_btnPathActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        personas=new SimpleLinkedList<>();
        for(int x: ltPersonas.getSelectedIndices()){
            personas.addLast((Persona) modeloPersonas.get(x));
        }
        for(int x: ltReaccion.getSelectedIndices()){
            reaccion.addLast((String) modeloReaccion.get(x));
        }
        Foto foto=new Foto(lblPath.getText().toString(),txtDescripcion.getText().toString(),
                txtLugar.getText(),txtFecha.getText().toString(),personas,reaccion,keywords,txtComentario.getText().toString(), (Camara) cbCamara.getSelectedItem());
        CircularDoublyLinkedList ltCircular;
        if(album.getFotos().isEmpty()){
            ltCircular=new CircularDoublyLinkedList();
        }
        else{
            ltCircular=album.getFotos();
        }
        ltCircular.addFirst(foto);
        System.out.println(ltCircular);
        album.setFotos(ltCircular);
        FrmAlbum frm = new FrmAlbum(album);
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        FrmAlbum frm = new FrmAlbum();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        // TODO add your handling code here:
        if(txtKeyword.getText().toString().trim()!=""){
            modeloKeyword.addElement(txtKeyword.getText().toString());
            keywords.addLast(txtKeyword.getText().toString());
        }
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        // TODO add your handling code here:
        if(modeloKeyword.getSize()!=0){
            int pos=ltKeyWord.getSelectedIndex();
            keywords.remove((String) modeloKeyword.get(pos));
            modeloKeyword.remove(pos);
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnPath;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox cbCamara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblPath;
    private javax.swing.JList ltKeyWord;
    private javax.swing.JList ltPersonas;
    private javax.swing.JList ltReaccion;
    private javax.swing.JTextArea txtComentario;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtKeyword;
    private javax.swing.JTextField txtLugar;
    // End of variables declaration//GEN-END:variables
}
