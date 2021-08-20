/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import modelo.SocialNetwork;
import modelo.ValidationResponse;
import modelo.Validator;

/**
 *
 * @author Benjamin Parra
 */
public class PanelShare extends javax.swing.JFrame {
    SocialNetwork snShare;
    private ImageIcon imagen;
    private Icon icono;
    /**
     * Creates new form PanelShare
     */
    public PanelShare(SocialNetwork sn) {
        initComponents();
        this.snShare = sn;
        mostrar();
        mostrarAmigos();
        pintarImagen(lblLogoShare, "src/main/java/vista/logoShare.png");
    }
    public void mostrarAmigos(){
        DefaultTableModel modelo = (DefaultTableModel)tableAmigos.getModel();
        for (int i = 0; i < snShare.getUserOnline().getAmigos().size(); i++) {
            modelo.addRow(new Object[]{snShare.getUserOnline().getAmigos().get(i).getNombreUsuario(),false});
        }
    }
    public void mostrar(){
        String matriz[][] = new String[snShare.getUserOnline().getPosts().size()][5];
        for (int i = 0; i < snShare.getUserOnline().getPosts().size(); i++) {
            matriz[i][0] = snShare.getUserOnline().getPosts().get(i).getID()+"";
            matriz[i][1] = snShare.getUserOnline().getPosts().get(i).getUser().getNombreUsuario();
            matriz[i][2] = snShare.getUserOnline().getPosts().get(i).stringTablas();
            if (snShare.getUserOnline().getPosts().get(i).getReceptores().isEmpty()) {
                matriz[i][3] = "vacio";
            }else{
                matriz[i][3] = snShare.getUserOnline().getPosts().get(i).getReceptor(snShare.getUserOnline().getPosts().get(i).getReceptores()).getNombreUsuario();
            }
            matriz[i][4] = snShare.getUserOnline().getPosts().get(i).getFechaDePublicacion();
        }
        tablePosts.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String [] {
                    "ID", "Usuario remitente", "Contenido", "Usuario receptor", "Fecha de creaci�n"
                }
        ));
        
       // tablaPosts.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablePosts.getColumnModel().getColumn(0).setResizable(false);
        tablePosts.getColumnModel().getColumn(1).setResizable(false);
        tablePosts.getColumnModel().getColumn(2).setResizable(false);
        tablePosts.getColumnModel().getColumn(3).setResizable(false);
        tablePosts.getColumnModel().getColumn(4).setResizable(false);
        tablePosts.getColumnModel().getColumn(0).setMaxWidth(30);
        tablePosts.getColumnModel().getColumn(0).setMinWidth(30);
        tablePosts.getColumnModel().getColumn(1).setMaxWidth(125);
        tablePosts.getColumnModel().getColumn(1).setMinWidth(125);
        tablePosts.getColumnModel().getColumn(2).setMaxWidth(1000);
        tablePosts.getColumnModel().getColumn(2).setMinWidth(1000);
        tablePosts.getColumnModel().getColumn(3).setMaxWidth(175);
        tablePosts.getColumnModel().getColumn(3).setMinWidth(175);
        tablePosts.getColumnModel().getColumn(4).setMaxWidth(125);
        tablePosts.getColumnModel().getColumn(4).setMinWidth(125);
        tablePosts.getTableHeader().setReorderingAllowed(false);
        
        
        
    }
    private void pintarImagen(JLabel lbl, String ruta){
        this.imagen = new ImageIcon(ruta);
        this.icono = new ImageIcon(
                this.imagen.getImage().getScaledInstance(
                        lbl.getWidth(), 
                        lbl.getHeight(), 
                        Image.SCALE_DEFAULT
                )
        );
        lbl.setIcon(this.icono);
        this.repaint();
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableAmigos = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePosts = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        textNumeroPost = new javax.swing.JTextField();
        btnShare = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblLogoShare = new javax.swing.JLabel();
        btnAyuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel1.setText("Compartir Publicaci�n");

        tableAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NombreUsuario", "Selecci�n"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableAmigos);
        if (tableAmigos.getColumnModel().getColumnCount() > 0) {
            tableAmigos.getColumnModel().getColumn(1).setMinWidth(30);
            tableAmigos.getColumnModel().getColumn(1).setMaxWidth(100);
        }

        tablePosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Usuario Remitente", "Contenido", "Usuario Receptor", "Fecha Creacion"
            }
        ));
        jScrollPane2.setViewportView(tablePosts);

        jLabel2.setText("Ingrese n�mero del ID del post a compartir");

        textNumeroPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNumeroPostActionPerformed(evt);
            }
        });
        textNumeroPost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textNumeroPostKeyTyped(evt);
            }
        });

        btnShare.setText("Compartir");
        btnShare.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShareActionPerformed(evt);
            }
        });

        btnBack.setText("Volver atr�s");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnAyuda.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        btnAyuda.setText("Ayuda");
        btnAyuda.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1459, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(116, 116, 116)
                .addComponent(lblLogoShare, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(textNumeroPost, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnShare, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(btnAyuda)))
                .addGap(237, 237, 237))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNumeroPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnShare)
                            .addComponent(btnBack))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAyuda))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLogoShare, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textNumeroPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNumeroPostActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_textNumeroPostActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        PanelDeSesionIniciada psi = new PanelDeSesionIniciada(snShare);
        psi.setLocationRelativeTo(this);
        this.dispose();
        psi.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnShareActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShareActionPerformed
        String numeroPost = textNumeroPost.getText();
        
        DefaultTableModel modelo = (DefaultTableModel)tableAmigos.getModel();
        ArrayList<String> amigosSeleccionados = new ArrayList();
        Validator validator = new Validator();
        String amigosComo = "";
        ValidationResponse validationResponse = new ValidationResponse();
        if (numeroPost.isEmpty()) {
            Mensajes mensaje = new Mensajes("ERROR: Ingrese un n�mero de ID post",this,true,snShare);
            mensaje.setLocationRelativeTo(null);
            mensaje.setVisible(true);
            
        }else{
            for (int i = 0; i < snShare.getUserOnline().getAmigos().size(); i++) {
                if ("true".equalsIgnoreCase(""+modelo.getValueAt(i, 1))) {
                    amigosSeleccionados.add(snShare.getUserOnline().getAmigos().get(i).getNombreUsuario());
                }
            }
            String[] nuevoString = new String[amigosSeleccionados.size()];
            for (int i = 0; i < amigosSeleccionados.size(); i++) {
                nuevoString[i] = amigosSeleccionados.get(i);
            }
            for (int i = 0; i < amigosSeleccionados.size(); i++) {
                amigosComo = amigosSeleccionados.get(i)+",";
        }
            if (amigosSeleccionados.isEmpty()) {
                validationResponse = validator.validadorShareSolo(numeroPost, snShare);
                if (!validationResponse.isEsValido()) {
                    Mensajes mensaje = new Mensajes(validationResponse.getMensaje(),this,true,snShare);
                    mensaje.setLocationRelativeTo(null);
                    mensaje.setVisible(true);
                }else{
                    snShare.getUserOnline().share(numeroPost, snShare);
                    Mensajes mensaje = new Mensajes("El usuario "+snShare.getUserOnline().getNombreUsuario()+" comparti� la publicacion en su muro",this,true,snShare);
                    mensaje.setLocationRelativeTo(null);
                    mensaje.setVisible(true);
                    mostrar();
                    
                }
            }else if (!amigosSeleccionados.isEmpty()) {
                //se debe incluir amigo1,amigo2
                String[] contenidoShare = {numeroPost,amigosComo};
                validationResponse = validator.validadorShareAmigos(contenidoShare, snShare);
                if (!validationResponse.isEsValido()) {
                    Mensajes mensaje = new Mensajes(validationResponse.getMensaje(),this,true,snShare);
                    mensaje.setLocationRelativeTo(null);
                    mensaje.setVisible(true);
                }else{
                    snShare.getUserOnline().share(numeroPost, nuevoString, snShare);
                    Mensajes mensaje = new Mensajes(snShare.mensajePostAmigos(nuevoString),this,true,snShare);
                    mensaje.setLocationRelativeTo(null);
                    mensaje.setVisible(true);
                    mostrar();
                }
            }
        }
        
        
    }//GEN-LAST:event_btnShareActionPerformed

    private void textNumeroPostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNumeroPostKeyTyped
        char c = evt.getKeyChar();
        if(c< '0' || c > '9') evt.consume();
    }//GEN-LAST:event_textNumeroPostKeyTyped

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed
        // TODO add your handling code here:
        Mensajes nm = new Mensajes("Para compartir una publicaci�n en tu perfil no debes seleccionar a ning�n usuario, debes ingresar el ID que sale al costado de la publicaci�n. \n\n Para compartir una publicaci�n a otro/os usuario/usuarios debes seleccionarlo/os e ingresar el ID que sale al costado de la publicaci�n.",this,true,snShare);
        nm.setLocationRelativeTo(null);
        nm.setVisible(true);
    }//GEN-LAST:event_btnAyudaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnShare;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblLogoShare;
    private javax.swing.JTable tableAmigos;
    private javax.swing.JTable tablePosts;
    private javax.swing.JTextField textNumeroPost;
    // End of variables declaration//GEN-END:variables
}
