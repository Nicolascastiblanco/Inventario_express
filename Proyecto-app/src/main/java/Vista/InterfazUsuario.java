package Vista;

import Modelo.Usuario;
import controlador.ControlLogin;

import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author ni-va
 */
public class InterfazUsuario extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(InterfazUsuario.class.getName());

    /**
     * Creates new form InterfazUsuario
     */
    public InterfazUsuario() {
        initComponents();
        this.setLocationRelativeTo(null);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1_IngresarUsuario = new javax.swing.JButton();
        jButton3_mensaje_administrador = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1_Contraseña = new javax.swing.JPasswordField();
        jTextField1_Usuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(115, 158, 201));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel1.setText("Usuario");

        jLabel2.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel2.setText("Contrasena");

        jButton1_IngresarUsuario.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jButton1_IngresarUsuario.setText("Ingresar");
        jButton1_IngresarUsuario.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(115, 158, 201), null));
        jButton1_IngresarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_IngresarUsuarioActionPerformed(evt);
            }
        });

        jButton3_mensaje_administrador.setFont(new java.awt.Font("Bookman Old Style", 1, 14)); // NOI18N
        jButton3_mensaje_administrador.setText("Enviar mensaje");
        jButton3_mensaje_administrador.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(115, 158, 201), null));
        jButton3_mensaje_administrador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3_mensaje_administradorMouseClicked(evt);
            }
        });
        jButton3_mensaje_administrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3_mensaje_administradorActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel3.setText("Se te olvido la contrasena envia un mensaje al daministrador");

        jPasswordField1_Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField1_ContraseñaActionPerformed(evt);
            }
        });

        jTextField1_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1_UsuarioActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jLabel4.setText("Ingresa Tus Datos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(124, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1_Usuario)
                    .addComponent(jPasswordField1_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jButton1_IngresarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(225, 225, 225))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jButton3_mensaje_administrador)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel4)
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1_Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1_IngresarUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(64, 64, 64)
                .addComponent(jButton3_mensaje_administrador)
                .addContainerGap(220, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1_IngresarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_IngresarUsuarioActionPerformed

        String nombre = jTextField1_Usuario.getText();
        String pass = jPasswordField1_Contraseña.getText();

        ControlLogin control = new ControlLogin();
        Usuario usuarioLogueado = control.iniciarSesion(nombre, pass);

        if (usuarioLogueado != null) {

            // Abrir ventana principal enviando usuario
            Interfazprincipal ventana = new Interfazprincipal(usuarioLogueado);
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);

            this.dispose(); // cerramos login

        } else {
            JOptionPane.showMessageDialog(this, "❌ Usuario o contraseña incorrectos");
        }


    }//GEN-LAST:event_jButton1_IngresarUsuarioActionPerformed

    private void jTextField1_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1_UsuarioActionPerformed
        if (!this.jTextField1_Usuario.getText().trim().isEmpty()) {
            //si es verdadero

        } else {
            JOptionPane.showMessageDialog(this, "El usuario o Contraseña estan mal", "InterfazUsuario", JOptionPane.ERROR_MESSAGE);
            //falso sino

        }


    }//GEN-LAST:event_jTextField1_UsuarioActionPerformed

    private void jButton3_mensaje_administradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3_mensaje_administradorActionPerformed
        contraseña ventana = new contraseña();

        // Mostrar la nueva ventana
        ventana.setVisible(true);
        // Cerrar (u ocultar) la ventana actual
        ventana.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton3_mensaje_administradorActionPerformed

    private void jButton3_mensaje_administradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3_mensaje_administradorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3_mensaje_administradorMouseClicked

    private void jPasswordField1_ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField1_ContraseñaActionPerformed
        if (!this.jTextField1_Usuario.getText().trim().isEmpty()) {
            //si es verdadero

        } else {
            //recuerda cambiar el nombre de la calse ya se no es Interfaz usuario es donde tengas la clase principal para que se ejecute las cosas
            JOptionPane.showMessageDialog(this, "El usuario o Contraseña estan mal", "InterfazUsuario", JOptionPane.ERROR_MESSAGE);
            //falso sino

        }
    }//GEN-LAST:event_jPasswordField1_ContraseñaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_IngresarUsuario;
    private javax.swing.JButton jButton3_mensaje_administrador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1_Contraseña;
    private javax.swing.JTextField jTextField1_Usuario;
    // End of variables declaration//GEN-END:variables
}
