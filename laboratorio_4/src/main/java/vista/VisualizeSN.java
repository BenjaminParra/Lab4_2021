/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import modelo.SocialNetwork;

/**
 *
 * @author Benjamin Parra
 */
public class VisualizeSN extends javax.swing.JFrame {
    SocialNetwork snVisualize;
    private ImageIcon imagen;
    private Icon icono;
    /**
     * Creates new form VisualizeSN
     */
    public VisualizeSN(SocialNetwork sn) {
        initComponents();
        this.snVisualize = sn;
        lblNombreSN.setText(snVisualize.getNombreSocialNetwork());
        mostrar();
        mostrarUsuarios();
        this.pintarImagen(lblImagen, "src/main/java/vista/logoFacebook.png");
    }
    public void mostrarUsuarios(){
        String matriz[][] = new String[snVisualize.getUsuarios().size()][3];
        for (int i = 0; i < snVisualize.getUsuarios().size(); i++) {
            matriz[i][0] = snVisualize.getUsuarios().get(i).getNombreUsuario()+"";
            if (snVisualize.getUsuarios().get(i).getListaAmigosString(snVisualize.getUsuarios().get(i).getAmigos()).isEmpty()) {
                matriz[i][1] = "No tiene amigos";
            }else{
            matriz[i][1] = snVisualize.getUsuarios().get(i).getListaAmigosString(snVisualize.getUsuarios().get(i).getAmigos());
            }
            if (snVisualize.getSeguidores(snVisualize.getUsuarios().get(i)).isEmpty()) {
                matriz[i][2] = "No tiene seguidores";
            }else{
                matriz[i][2] = snVisualize.seguidoresString(snVisualize.getUsuarios().get(i));
            }
        }
        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            matriz,
            new String [] {
                "Nombre Usuario", "Amigos", "Seguidores"
            }
        ));
        tableUsuarios.getTableHeader().setReorderingAllowed(false);
        
    }
    public  void mostrar(){
        String matriz[][] = new String[snVisualize.getPublicaciones().size()][5];
        for (int i = 0; i < snVisualize.getPublicaciones().size(); i++) {
            matriz[i][0] = snVisualize.getPublicaciones().get(i).getID()+"";
            matriz[i][1] = snVisualize.getPublicaciones().get(i).getUser().getNombreUsuario();
            matriz[i][2] = snVisualize.getPublicaciones().get(i).stringTablas();
            if (snVisualize.getPublicaciones().get(i).getReceptores().isEmpty()) {
                matriz[i][3] = "vacio";
            }else{
                matriz[i][3] = snVisualize.getPublicaciones().get(i).getReceptor(snVisualize.getPublicaciones().get(i).getReceptores()).getNombreUsuario();
            }
            matriz[i][4] = snVisualize.getPublicaciones().get(i).getFechaDePublicacion();
        }
        tablePosts.setModel(new javax.swing.table.DefaultTableModel(
                matriz,
                new String [] {
                    "ID", "Usuario remitente", "Contenido", "Usuario receptor", "Fecha de creación"
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

        lblNombreSN = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePosts = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableUsuarios = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNombreSN.setFont(new java.awt.Font("Impact", 0, 48)); // NOI18N
        lblNombreSN.setText("j");

        tablePosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Usuario remitente", "Contenido", "Usuario receptor", "Fecha de creación"
            }
        ));
        jScrollPane1.setViewportView(tablePosts);

        jLabel1.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel1.setText("Publicaciones en la RedSocial");

        tableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nombre Usuario", "Amigos", "Seguidores"
            }
        ));
        jScrollPane2.setViewportView(tableUsuarios);

        btnBack.setText("Volver atrás");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel2.setText("Usuarios Registrados");

        lblImagen.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreSN, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(477, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(lblNombreSN, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBack))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        PanelDeSesionIniciada psi = new PanelDeSesionIniciada(snVisualize);
        psi.setLocationRelativeTo(this);
        this.dispose();
        psi.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblNombreSN;
    private javax.swing.JTable tablePosts;
    private javax.swing.JTable tableUsuarios;
    // End of variables declaration//GEN-END:variables
}
