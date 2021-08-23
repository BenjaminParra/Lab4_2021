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
import javax.swing.JRadioButton;
import modelo.Post;
import modelo.SocialNetwork;

/**
 *
 * @author Benjamin Parra
 */
public class PanelDeSesionIniciada extends javax.swing.JFrame {
    SocialNetwork snOn;
    private ImageIcon imagen;
    private Icon icono;
    
    /**
     * Creates new form PanelDeSesionIniciada
     * @param sn
     */
    public PanelDeSesionIniciada(SocialNetwork sn) {
        initComponents();
        this.snOn = sn;
        textNombreUsuario.setText(snOn.getUserOnline().getNombreUsuario());
        mostrar();
        mostrarAmigos();
       // pintarImagen(lblNombreUsuario.getIcon(), "src/main/java/vista/addFriend.png");

    }
    /**
     * Metodo que muestra los usuarios agregados a la lista del usuario onlie
     */
    public void mostrarAmigos(){
        String matriz[][] = new String[snOn.getUserOnline().getAmigos().size()][1];
        
        for (int i = 0; i < snOn.getUserOnline().getAmigos().size(); i++) {
            matriz[i][0] = snOn.getUserOnline().getAmigos().get(i).getNombreUsuario();
            
        }
        
        tableAmigos.setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            new String [] {
                "Amigos"
            }
        ));
        tableAmigos.getTableHeader().setReorderingAllowed(false);
        tableAmigos.getColumnModel().getColumn(0).setResizable(false);
    }
    
    /**
     * Metodo obtenido de videoTutoriales que para montar imagenes
     * en Jlabel
     * @param lbl
     * @param ruta 
     */
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
      * Metodo creado para mostrar una tabla con las publicaciones hechas en el perfil del usuario Online
      */
    public void mostrar(){
        
        String matriz[][] = new String[snOn.getUserOnline().getPosts().size()][5];
        
        for (int i = 0; i < snOn.getUserOnline().getPosts().size(); i++) {
            
            matriz[i][0] = snOn.getUserOnline().getPosts().get(i).getID()+"";
                matriz[i][1] = snOn.getUserOnline().getPosts().get(i).getUser().getNombreUsuario();
                matriz[i][2] = snOn.getUserOnline().getPosts().get(i).getContenido();
                if (snOn.getUserOnline().getPosts().get(i).getReceptores().isEmpty()) {
                matriz[i][3] = "vacio";
                }else{
                    matriz[i][3] = snOn.getUserOnline().getPosts().get(i).getReceptor(snOn.getUserOnline().getPosts().get(i).getReceptores()).getNombreUsuario();
                }
                
                matriz[i][4] = snOn.getUserOnline().getPosts().get(i).getFechaDePublicacion();
           
            
        }
        
        tablaPosts.setModel(new javax.swing.table.DefaultTableModel(
                
            matriz,
            new String [] {
                "ID", "Usuario remitente", "Contenido", "Usuario receptor", "Fecha de creación"
            }
        ));
        
       // tablaPosts.getColumnModel().getColumn(0).setPreferredWidth(20);
        tablaPosts.getColumnModel().getColumn(0).setResizable(false);
        tablaPosts.getColumnModel().getColumn(1).setResizable(false);
        tablaPosts.getColumnModel().getColumn(2).setResizable(false);
        tablaPosts.getColumnModel().getColumn(3).setResizable(false);
        tablaPosts.getColumnModel().getColumn(4).setResizable(false);
        tablaPosts.getColumnModel().getColumn(0).setMaxWidth(30);
        tablaPosts.getColumnModel().getColumn(0).setMinWidth(30);
        tablaPosts.getColumnModel().getColumn(1).setMaxWidth(125);
        tablaPosts.getColumnModel().getColumn(1).setMinWidth(125);
        tablaPosts.getColumnModel().getColumn(2).setMaxWidth(700);
        tablaPosts.getColumnModel().getColumn(2).setMinWidth(700);
        tablaPosts.getColumnModel().getColumn(3).setMaxWidth(175);
        tablaPosts.getColumnModel().getColumn(3).setMinWidth(175);
        tablaPosts.getColumnModel().getColumn(4).setMaxWidth(125);
        tablaPosts.getColumnModel().getColumn(4).setMinWidth(125);
        tablaPosts.getTableHeader().setReorderingAllowed(false);
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblSesionIniciada = new javax.swing.JLabel();
        textNombreUsuario = new javax.swing.JLabel();
        lblMenuOpciones = new javax.swing.JLabel();
        radioButtonPost = new javax.swing.JRadioButton();
        radioButtonFollow = new javax.swing.JRadioButton();
        radioButtonShare = new javax.swing.JRadioButton();
        radioButtonVisualize = new javax.swing.JRadioButton();
        btnOK = new javax.swing.JButton();
        radioButtonLogout = new javax.swing.JRadioButton();
        lblNombreUsuario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPosts = new javax.swing.JTable();
        lblPosts = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAmigos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblSesionIniciada.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        lblSesionIniciada.setText("Sesión Iniciada");

        textNombreUsuario.setBackground(new java.awt.Color(255, 0, 102));
        textNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        lblMenuOpciones.setText("Menú de opciones:");

        buttonGroup1.add(radioButtonPost);
        radioButtonPost.setText("Realizar publicación");

        buttonGroup1.add(radioButtonFollow);
        radioButtonFollow.setText("Seguir Usuario");

        buttonGroup1.add(radioButtonShare);
        radioButtonShare.setText("Compartir publicación");

        buttonGroup1.add(radioButtonVisualize);
        radioButtonVisualize.setText("Visualizar RedSocial");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        buttonGroup1.add(radioButtonLogout);
        radioButtonLogout.setText("Cerrar sesión");

        lblNombreUsuario.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N

        tablaPosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Usuario remitente", "Contenido", "Usuario receptor", "Fecha de creación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaPosts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaPosts.setRowHeight(30);
        tablaPosts.setRowMargin(1);
        tablaPosts.setShowGrid(true);
        jScrollPane1.setViewportView(tablaPosts);
        if (tablaPosts.getColumnModel().getColumnCount() > 0) {
            tablaPosts.getColumnModel().getColumn(0).setResizable(false);
            tablaPosts.getColumnModel().getColumn(0).setPreferredWidth(30);
            tablaPosts.getColumnModel().getColumn(1).setResizable(false);
            tablaPosts.getColumnModel().getColumn(2).setResizable(false);
            tablaPosts.getColumnModel().getColumn(2).setPreferredWidth(400);
            tablaPosts.getColumnModel().getColumn(3).setResizable(false);
            tablaPosts.getColumnModel().getColumn(4).setResizable(false);
        }

        lblPosts.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        lblPosts.setText("Publicaciones en el perfil");

        tableAmigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Amigos"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableAmigos);
        if (tableAmigos.getColumnModel().getColumnCount() > 0) {
            tableAmigos.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPosts, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblSesionIniciada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblMenuOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioButtonFollow)
                                    .addComponent(radioButtonPost)
                                    .addComponent(radioButtonShare)
                                    .addComponent(radioButtonVisualize)
                                    .addComponent(radioButtonLogout))
                                .addGap(129, 129, 129)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSesionIniciada, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textNombreUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(radioButtonPost)
                            .addComponent(lblMenuOpciones, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButtonFollow)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButtonShare)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButtonVisualize)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioButtonLogout))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(lblPosts, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        //SocialNetwork sn = new SocialNetwork("Facebook","27/12/2021");
        
        if (radioButtonFollow.isSelected()) {
            
            PanelSeguir pS = new PanelSeguir(snOn);
            pS.setLocationRelativeTo(null);
            pS.setVisible(true);
            this.dispose();
        }
        if (radioButtonPost.isSelected()) {
            //post
            PanelPost pP = new PanelPost(snOn);
            pP.setLocationRelativeTo(null);
            pP.setVisible(true);
            this.dispose();
        }
        if (radioButtonShare.isSelected()){
            if (snOn.getUserOnline().getPosts().isEmpty()) {
                Mensajes mensaje = new Mensajes("No existen publicaciones en tu perfil para compartir",this,true,snOn);
                mensaje.setLocationRelativeTo(null);
                mensaje.setVisible(true);
            }else{
                PanelShare pSh = new PanelShare(snOn);
                pSh.setLocationRelativeTo(null);
                pSh.setVisible(true);
                this.dispose();
            }
            
            
        }
        if (radioButtonVisualize.isSelected()) {
            //se abre ventana visualizar
            VisualizeSN vSN = new VisualizeSN(snOn);
            vSN.setLocationRelativeTo(null);
            vSN.setVisible(true);
            this.dispose();
        }
        if (radioButtonLogout.isSelected()) {
            snOn.turnOffUser();
            Mensajes mensaje = new Mensajes("Se ha cerrado sesión",this,true,snOn);
            mensaje.setLocationRelativeTo(null);
            mensaje.setVisible(true);
            this.dispose();
            Menu_Bienvenida mB = new Menu_Bienvenida(snOn);
            mB.setLocationRelativeTo(null);
            mB.setVisible(true);
            
        }else{
            if (!radioButtonFollow.isSelected()&& !radioButtonPost.isSelected()&&!radioButtonShare.isSelected()&&
                    !radioButtonVisualize.isSelected()&&!radioButtonLogout.isSelected()) {
                Mensajes mensaje = new Mensajes("ERROR: Seleccione alguna de las opciones",this,true,snOn);
                mensaje.setLocationRelativeTo(null);
                mensaje.setVisible(true);
                
            }
            
        }
    }//GEN-LAST:event_btnOKActionPerformed

    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelDeSesionIniciada().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMenuOpciones;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JLabel lblPosts;
    private javax.swing.JLabel lblSesionIniciada;
    private javax.swing.JRadioButton radioButtonFollow;
    private javax.swing.JRadioButton radioButtonLogout;
    private javax.swing.JRadioButton radioButtonPost;
    private javax.swing.JRadioButton radioButtonShare;
    private javax.swing.JRadioButton radioButtonVisualize;
    private javax.swing.JTable tablaPosts;
    private javax.swing.JTable tableAmigos;
    private javax.swing.JLabel textNombreUsuario;
    // End of variables declaration//GEN-END:variables
}
