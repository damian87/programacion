/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.login.vista_log;

/**
 *
 * @author damian
 */
public class Iniciologin extends javax.swing.JFrame {

    /**
     * Creates new form inicio
     */
    public Iniciologin() {
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
        usuario = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        txtusuario = new javax.swing.JTextField();
        botonolvidarpass = new javax.swing.JButton();
        botonenter = new javax.swing.JButton();
        txtpassword = new javax.swing.JPasswordField();
        newusu = new javax.swing.JButton();
        configEF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usuario.setText("Usuario:");
        jPanel1.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 57, -1, -1));

        password.setText("Contraseña:");
        jPanel1.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 109, -1, -1));
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(189, 54, 175, -1));

        botonolvidarpass.setText("¿olvidaste la contraseña?");
        jPanel1.add(botonolvidarpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(177, 184, -1, -1));

        botonenter.setText("Entrar");
        jPanel1.add(botonenter, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 155, -1, -1));
        jPanel1.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 106, 147, -1));

        newusu.setText("Nuevo Usuario");
        jPanel1.add(newusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 249, -1, -1));

        configEF.setText("Configuracion");
        jPanel1.add(configEF, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 249, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton botonenter;
    public static javax.swing.JButton botonolvidarpass;
    public static javax.swing.JButton configEF;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JButton newusu;
    private javax.swing.JLabel password;
    public static javax.swing.JPasswordField txtpassword;
    public static javax.swing.JTextField txtusuario;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
