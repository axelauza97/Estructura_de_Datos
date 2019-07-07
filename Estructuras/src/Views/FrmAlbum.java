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
import java.awt.ComponentOrientation;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import javax.accessibility.AccessibleRole;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Axel
 */
public class FrmAlbum extends javax.swing.JFrame {

    public Archivo archivo=FrmHome.archivo;
    private static SimpleLinkedList<Album> album;
    private Album albumActual;
    /**
     * Creates new form FrmAlbum
     */
    
    public FrmAlbum() {
        this.archivo = archivo;
        loadFrm();
        album = archivo.readAlbum();
        if(album==null)
            album=new SimpleLinkedList<>();
        loadAlbums();
    }
    public FrmAlbum(Album albumNew) {
        loadFrm();
        if(album.contains(albumNew)){
            int pos=album.indexOf(albumNew);
            album.set(pos, albumNew);
        }else{
            album.addLast(albumNew);
        }
        archivo.saveAlbum(album);
        loadAlbums();
    }
    
    private void loadFrm(){
        initComponents();
        this.lblFecha.setText("");
        this.lblLugar.setText("");
        this.lblComentarios.setText("");
        this.lblCamara.setText("");
        
        //agregue el icono de ventana
//        Image icon = new ImageIcon(getClass().getResource("/Resources/Picasa.png")).getImage();
//        setIconImage(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jProgressBar1 = new javax.swing.JProgressBar();
        scAlbum = new javax.swing.JScrollPane(paneAlbum,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        paneAlbum = new javax.swing.JPanel();
        paneFotos = new javax.swing.JPanel();
        paneNombres = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtLugar = new javax.swing.JLabel();
        txtFecha = new javax.swing.JLabel();
        txtPersonas = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPath = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbPersonas = new javax.swing.JComboBox();
        cbReacciones = new javax.swing.JComboBox();
        cbKeyword = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripAl = new javax.swing.JTextArea();
        lblLugar = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblCamara = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        lblAlbum = new javax.swing.JLabel();
        btnAgregarFoto = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        btnCrear = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout paneFotosLayout = new javax.swing.GroupLayout(paneFotos);
        paneFotos.setLayout(paneFotosLayout);
        paneFotosLayout.setHorizontalGroup(
            paneFotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );
        paneFotosLayout.setVerticalGroup(
            paneFotosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout paneAlbumLayout = new javax.swing.GroupLayout(paneAlbum);
        paneAlbum.setLayout(paneAlbumLayout);
        paneAlbumLayout.setHorizontalGroup(
            paneAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneFotos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        paneAlbumLayout.setVerticalGroup(
            paneAlbumLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneAlbumLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(paneFotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        scAlbum.setViewportView(paneAlbum);

        javax.swing.GroupLayout paneNombresLayout = new javax.swing.GroupLayout(paneNombres);
        paneNombres.setLayout(paneNombresLayout);
        paneNombresLayout.setHorizontalGroup(
            paneNombresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 228, Short.MAX_VALUE)
        );
        paneNombresLayout.setVerticalGroup(
            paneNombresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 461, Short.MAX_VALUE)
        );

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNombre.setText("Foto");

        jLabel3.setText("Descripcion");

        jLabel4.setText("Lugar");

        jLabel5.setText("Fecha");

        jLabel6.setText("Personas");

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(txtDescripcion);

        jLabel2.setText("Direccion");

        txtPath.setEnabled(false);

        jLabel1.setText("Reacciones");

        jLabel7.setText("KeyWords");

        jLabel8.setText("Comentarios");

        jLabel9.setText("Camara");

        jLabel10.setText("Descripcion Album");

        txtDescripAl.setColumns(20);
        txtDescripAl.setRows(5);
        txtDescripAl.setEnabled(false);
        jScrollPane1.setViewportView(txtDescripAl);

        lblLugar.setText("LUGAR");

        lblFecha.setText("jLabel12");

        lblCamara.setText("jLabel14");

        btnEliminar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEliminar.setText("Eliminar Album");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblAlbum.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblAlbum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAlbum.setText("Album");

        btnAgregarFoto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregarFoto.setText("Agregar Foto");
        btnAgregarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblAlbum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.setText("jTextField1");

        btnCrear.setText("Crear Album");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(paneNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnCrear)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnVolver)
                                        .addGap(14, 14, 14)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblNombre)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(btnModificar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPath)
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(lblLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtPersonas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(85, 85, 85)))
                                .addComponent(txtLugar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(89, 89, 89))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCamara)
                                    .addComponent(cbReacciones, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLugar)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFecha)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lblLugar)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblFecha))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPersonas)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(cbPersonas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(cbReacciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(lblCamara))
                .addGap(172, 172, 172))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(scAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paneNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrear)
                            .addComponent(btnVolver))
                        .addGap(97, 97, 97))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFotoActionPerformed
        // TODO add your handling code here:
        if(album.isEmpty()|| lblAlbum.getText().toString()=="Album" || lblAlbum.getText().toString()=="Galeria")
            JOptionPane.showMessageDialog(this, "¡Primero cree un album o seleccione alguno!", "Error", JOptionPane.ERROR_MESSAGE);
        else{
            FrmCrearFoto frm = new FrmCrearFoto(albumActual);
            frm.setLocationRelativeTo(null);
            frm.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnAgregarFotoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        if(lblNombre.getText().toString().equals("Album")){
            lblNombre.setText("Foto");
            txtPath.enable(false);
            btnModificar.setText("Modificar");
        }
        
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        FrmCrearAlbum frm = new FrmCrearAlbum();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.setVisible(false);        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        archivo.saveAlbum(album);
        FrmHome frm = new FrmHome();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
        this.setVisible(false);    
    }//GEN-LAST:event_btnVolverActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        archivo.saveAlbum(album);
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

    private void loadAlbums() {
        paneNombres.setLayout(new GridLayout(0, 2, 5, 10));
        //Numero de Albumnes guardados
        if(album.size()!=0)
        for (int x = 0; x < album.size(); x++) {
            JButton boton = new JButton((album.get(x)).toString());
            
            boton.addActionListener(new AlbumActionListener(album.get(x)));
            paneNombres.add(boton);
        }
        else
            lblAlbum.setText("Galeria");
        paneNombres.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    }
    private class AlbumActionListener implements ActionListener {
        private Album albumA;

        public AlbumActionListener(Album album) {
            this.albumA= album;
        }
        @Override
        public void actionPerformed(ActionEvent evt) {
            //Nombre del album
            albumActual=albumA;
            txtDescripAl.setText(albumA.getDescripcion());
            lblAlbum.setText(albumA.toString());
            paneFotos.removeAll();
            paneFotos.setLayout(new GridLayout(0,2,5,10));
            //Numero de Imagenes guardados
            if(!albumA.getFotos().isEmpty()){
                CircularDoublyLinkedList<Foto> fotos=albumActual.getFotos();
                Iterator<Foto> li= fotos.iterator();
                while(li.hasNext()){
                    Foto foto = (Foto) li.next();
                    JButton boton = new JButton(foto.toString());
                    ImageIcon imageIcon = new ImageIcon(foto.getPath()); // load the image to a imageIcon
                    Image image = imageIcon.getImage(); // transform it 
                    Image newimg = image.getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                    imageIcon = new ImageIcon(newimg);  // transform it back
                    boton.setIcon(imageIcon);
                    boton.setVerticalTextPosition(SwingConstants.BOTTOM);
                    boton.setHorizontalTextPosition(SwingConstants.CENTER);
                    boton.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                            btnFotoActionPerformed(evt, foto);
                        }
                    });
                    paneFotos.add(boton);
                }
            }
            paneFotos.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
            }
    }

    private void btnFotoActionPerformed(java.awt.event.ActionEvent evt, Foto foto) {
        this.txtDescripcion.setText(foto.getDescripcion());
        this.txtPath.setText(foto.getPath());
        this.lblFecha.setText(foto.getFecha());
        this.lblLugar.setText(foto.getLugar());
        cbPersonas.removeAllItems();
        for(Persona persona:foto.getPersonas()){
            this.cbPersonas.addItem(persona);
        }
        cbReacciones.removeAllItems();
        for(String reaccion:foto.getReacciones()){
            this.cbReacciones.addItem(reaccion);
        }
        cbKeyword.removeAllItems();
        for(String keyword:foto.getKeywords()){
            this.cbKeyword.addItem(keyword);
        }
        this.jTextField1.setText(foto.getComentarios());
        this.lblCamara.setText(foto.getCamara().toString());
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFoto;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox cbKeyword;
    private javax.swing.JComboBox cbPersonas;
    private javax.swing.JComboBox cbReacciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAlbum;
    private javax.swing.JLabel lblCamara;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblLugar;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel paneAlbum;
    private javax.swing.JPanel paneFotos;
    private javax.swing.JPanel paneNombres;
    private javax.swing.JScrollPane scAlbum;
    private javax.swing.JTextArea txtDescripAl;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JLabel txtFecha;
    private javax.swing.JLabel txtLugar;
    private javax.swing.JTextField txtPath;
    private javax.swing.JLabel txtPersonas;
    // End of variables declaration//GEN-END:variables
}
