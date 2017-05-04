/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofincurso;

import Modelo.*;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import javax.swing.JOptionPane;

import java.awt.event.KeyEvent;

/**
 *
 * @author 7fbd12
 */
public class InicioSesion extends javax.swing.JFrame {

    /**
     * @return the trabajador
     */
    public Trabajador getTrabajador() {
        return trabajador;
    }

    /**
     * @param trabajador the trabajador to set
     */
    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    /**
     * @return the claveTrabajador
     */
    public Clave getClaveTrabajador() {
        return claveTrabajador;
    }

    /**
     * @param claveTrabajador the claveTrabajador to set
     */
    public void setClaveTrabajador(Clave claveTrabajador) {
        this.claveTrabajador = claveTrabajador;
    }

    public PantLogistica2 getPantallaLogistica2() {
        return pantallaLogistica2;
    }

    public void setPantallaLogistica2(PantLogistica2 pantallaLogistica2) {
        this.pantallaLogistica2 = pantallaLogistica2;
    }

    public JF_Administrador getPantallaAdministrador() {
        return pantallaAdministrador;
    }

    /**
     * @param pantallaAdministrador the pantallaAdministrador to set
     */
    public void setPantallaAdministrador(JF_Administrador pantallaAdministrador) {
        this.pantallaAdministrador = pantallaAdministrador;
    }
    /**
     * @return the inisesion
     */
    private JF_Administrador pantallaAdministrador;
    //private PantLogistica1 pantallaLogistica1;
    private PantLogistica2 pantallaLogistica2;
    public static InicioSesion inisesion;

    //La conexion global para todo el programa
    public static Connection conexion;

    public void limpiarInicio() {
        nombreText.setText("");
        passwordText.setText("");
    }
    private Trabajador trabajador;
    private Clave claveTrabajador;
  
        
    /**
     * Creates new form InicioSesion
     */
    public InicioSesion() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nombreText = new javax.swing.JTextField();
        passwordText = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        entrar = new javax.swing.JButton();
        salir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        nombreText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreTextKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nombreTextKeyTyped(evt);
            }
        });

        passwordText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTextKeyPressed(evt);
            }
        });

        jLabel2.setText("Contraseña");

        entrar.setText("Entrar");
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        entrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                entrarKeyPressed(evt);
            }
        });

        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(passwordText, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                            .addComponent(nombreText)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(entrar)
                        .addGap(26, 26, 26)
                        .addComponent(salir, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(entrar)
                    .addComponent(salir)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed

        //Cuando meta los datos de usuario compruebe el usuario en la tabla de BD y la clave de ese usuario
        String nombre = nombreText.getText();
        String password = passwordText.getText();

        //comprobar usuario y clave en tabla Clve
        try {
            Class.forName("java.sql.DriverManager");
            conexion = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.9:1521:db12102", "system", "oracle");
            Statement sentencia = conexion.createStatement();
            CallableStatement comprobar = conexion.prepareCall("{call LOGIN(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            //Los datos del usuario para iniciar sesion
            comprobar.setString(1, String.format(nombre));
            comprobar.setString(2, String.format(password));
            comprobar.registerOutParameter(3, Types.NUMERIC);
            comprobar.registerOutParameter(4, Types.VARCHAR);
            comprobar.registerOutParameter(5, Types.VARCHAR);
            comprobar.registerOutParameter(6, Types.DATE);
            comprobar.registerOutParameter(7, Types.NUMERIC);
            comprobar.registerOutParameter(8, Types.NUMERIC);
            comprobar.registerOutParameter(9, Types.VARCHAR);
            comprobar.registerOutParameter(10, Types.VARCHAR);
            comprobar.registerOutParameter(11, Types.VARCHAR);
            comprobar.registerOutParameter(12, Types.VARCHAR);
            comprobar.registerOutParameter(13, Types.VARCHAR);
            comprobar.registerOutParameter(14, Types.VARCHAR);
            comprobar.registerOutParameter(15, Types.VARCHAR);
            comprobar.registerOutParameter(16, Types.VARCHAR);
            comprobar.registerOutParameter(17, Types.VARCHAR);
            comprobar.registerOutParameter(18, Types.VARCHAR);
            comprobar.registerOutParameter(19, Types.NUMERIC);
            comprobar.registerOutParameter(20, Types.DATE);
            comprobar.registerOutParameter(21, Types.VARCHAR);
            comprobar.registerOutParameter(22, Types.NUMERIC);
            comprobar.registerOutParameter(23, Types.NUMERIC);

            // Traer y guardar el registro de clave y el trabajador
            comprobar.executeUpdate();
            if (comprobar.getInt(23) == 1) {

                setClaveTrabajador(new Clave(comprobar.getInt(3), comprobar.getString(4), comprobar.getString(5), comprobar.getDate(6), comprobar.getInt(7)));
                setTrabajador(new Trabajador(comprobar.getInt(8), comprobar.getString(9), comprobar.getString(10), comprobar.getString(11), comprobar.getString(12), comprobar.getString(13), comprobar.getString(14), comprobar.getString(15), comprobar.getString(16), comprobar.getString(17), comprobar.getString(18), comprobar.getInt(19), comprobar.getDate(20), comprobar.getString(21), comprobar.getInt(22)));
                JOptionPane.showMessageDialog(this, "Correcto");
                //cerrar conexion del sistema y damos paso al trabajador con su usuario
                comprobar.close();
                conexion.close();
                sentencia.close();
                Class.forName("java.sql.DriverManager");
                //Aqui pondria el usuario y contraseña del trabajador
                conexion = DriverManager.getConnection("jdbc:oracle:thin:@10.10.10.9:1521:db12102", getClaveTrabajador().getUsuario(), getClaveTrabajador().getContrasenya());
                sentencia = conexion.createStatement();

                long seguir = getClaveTrabajador().comprobarFecha(getClaveTrabajador().getFecha());

                //obtener la categoria del trabajador
                String adm = "ADMINISTRADOR";
                String logis = "LOGISTICA";
                String trab = getTrabajador().getCategoria();
                if (seguir < 30 || claveTrabajador.getContrasenya().equals("Himevico12345")) {

                    if (trab.equals(adm)) {
                        //Abrir pantalla Administrador
                        if (pantallaAdministrador == null) {
                            pantallaAdministrador = new JF_Administrador();
                            pantallaAdministrador.setInicioSesion(this);
                        }
                        pantallaAdministrador.setVisible(true);
                        limpiarInicio();

                    } else {
                        //Abrir pantalla Logistica
                        if (getPantallaLogistica2() == null) {
                            setPantallaLogistica2(new PantLogistica2());
                            getPantallaLogistica2().setInicioSesion(this);
                            getPantallaLogistica2().setVisible(true);
                        }
                        getPantallaLogistica2().setVisible(true);
                        limpiarInicio();
                    }
                    //esconder ventana
                    this.setVisible(false);

                } else {
                    JOptionPane.showConfirmDialog(null, "Tienes que cambiar la contraseña. Han pasado mas de 30 dias desde el último cambio \n O tienes la contraseña por defecto.");

                    //crear la nueva contra
                    ModificarContrasenya crear_contra = new ModificarContrasenya();
                    crear_contra.setInicioSesion(this);
                    crear_contra.setVisible(true);

                    //  cambiar_contra.Modificar_contra(getClaveTrabajador().getId_clave(), getClaveTrabajador().getContrasenya(), sqlDateHoy, getClaveTrabajador().getUsuario());
                }
            } else {
                JOptionPane.showMessageDialog(this, "ERROR USUARIO O CONTRASEÑA ERRONEOS", "Resultado", JOptionPane.ERROR_MESSAGE);
            }

            sentencia.close();

            //sentencia.close();
            //conexion.close();
        } catch (ClassNotFoundException | SQLException cn) {
            cn.printStackTrace();
        }

    }//GEN-LAST:event_entrarActionPerformed

    public void hacerClick() {
        entrar.doClick();
    }
    private void entrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_entrarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            hacerClick();
        }
    }//GEN-LAST:event_entrarKeyPressed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void nombreTextKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreTextKeyTyped
    }//GEN-LAST:event_nombreTextKeyTyped

    private void nombreTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreTextKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            hacerClick();
        }
    }//GEN-LAST:event_nombreTextKeyPressed

    private void passwordTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            hacerClick();
        }
    }//GEN-LAST:event_passwordTextKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
        //Crear conexion con el servidor oracle 12c

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreText;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables

}
