/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * modificaEFgrafica.java
 *
 * Created on 09-mar-2015, 10:45:56
 */
package empleados.modulos.gestionempleados.gestionEF.vista;

//import com.sun.javafx.tk.Toolkit;
import javax.swing.JTable;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.SingletonsEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.BLL.EFBLLgrafica;
import empleados.modulos.gestionempleados.gestionEF.modelo.DAO.DAOEFgrafica;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//import javafx.scene.image.Image;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author damian
 */
public class modificaEFgrafica extends javax.swing.JFrame {

    
    public modificaEFgrafica() {
        initComponents();
        
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        etisueldo = new javax.swing.JLabel();
        txtsueldo = new javax.swing.JTextField();
        etiEdad = new javax.swing.JLabel();
        txtedad = new javax.swing.JTextField();
        etiAntiguedadEF = new javax.swing.JLabel();
        txtantiguedad = new javax.swing.JTextField();
        ModificarEF = new javax.swing.JButton();
        CancelarEF = new javax.swing.JButton();
        labelavatar = new javax.swing.JLabel();
        cargarimgavatar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        etiNombre = new javax.swing.JLabel();
        etiDepartamento = new javax.swing.JLabel();
        txtDepartamento = new javax.swing.JTextField();
        DatePiketEFnac = new com.toedter.calendar.JDateChooser();
        etiFnac = new javax.swing.JLabel();
        etiFcont = new javax.swing.JLabel();
        DatePikerEFCont = new com.toedter.calendar.JDateChooser();
        txtemail = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        Login = new javax.swing.JLabel();
        txtlogin = new javax.swing.JTextField();
        txtpassword = new javax.swing.JTextField();
        password = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        etisueldo.setText("Sueldo");

        etiEdad.setText("Edad");

        etiAntiguedadEF.setText("Antigüedad");

        ModificarEF.setText("Modificar");

        CancelarEF.setText("Cancelar");

        labelavatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cargarimgavatar.setText("Modificar Avatar");

        txtNombre.setText("\n");

        etiNombre.setText("Nombre:");

        etiDepartamento.setText("Departamento:");

        DatePiketEFnac.setDateFormatString("dd/MM/yyyy");

        etiFnac.setText("Fecha Nacimiento:");

        etiFcont.setText("Fecha contratacion:");

        DatePikerEFCont.setDateFormatString("dd/MM/yyyy");

        Email.setText("E-mail:");

        Login.setText("Login:");

        password.setText("Password:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(570, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cargarimgavatar)
                    .addComponent(labelavatar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(Login)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtlogin))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Email)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(password)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(etisueldo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(etiEdad)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(etiFcont)
                                    .addGap(18, 18, 18)
                                    .addComponent(DatePikerEFCont, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(etiFnac)
                                    .addGap(18, 18, 18)
                                    .addComponent(DatePiketEFnac, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(etiDepartamento)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtDepartamento))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(etiNombre)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(etiAntiguedadEF)
                                    .addGap(71, 71, 71)
                                    .addComponent(txtantiguedad, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(74, 74, 74)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CancelarEF)
                                        .addComponent(ModificarEF))))))
                    .addContainerGap(240, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(labelavatar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cargarimgavatar)
                .addContainerGap(215, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(etiEdad)
                        .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etiAntiguedadEF)
                        .addComponent(txtantiguedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(etisueldo)
                        .addComponent(txtsueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(23, 23, 23)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(etiNombre)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(12, 12, 12)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(etiDepartamento)
                                .addComponent(txtDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(ModificarEF)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(CancelarEF)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(etiFnac)
                        .addComponent(DatePiketEFnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(etiFcont)
                        .addComponent(DatePikerEFCont, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Email)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Login)
                        .addComponent(txtlogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(password)
                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton CancelarEF;
    public static com.toedter.calendar.JDateChooser DatePikerEFCont;
    public static com.toedter.calendar.JDateChooser DatePiketEFnac;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Login;
    public static javax.swing.JButton ModificarEF;
    public static javax.swing.JButton cargarimgavatar;
    private javax.swing.JLabel etiAntiguedadEF;
    private javax.swing.JLabel etiDepartamento;
    private javax.swing.JLabel etiEdad;
    private javax.swing.JLabel etiFcont;
    private javax.swing.JLabel etiFnac;
    private javax.swing.JLabel etiNombre;
    private javax.swing.JLabel etisueldo;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel labelavatar;
    private javax.swing.JLabel password;
    public static javax.swing.JTextField txtDepartamento;
    public static javax.swing.JTextField txtNombre;
    public static javax.swing.JTextField txtantiguedad;
    public static javax.swing.JTextField txtedad;
    public static javax.swing.JTextField txtemail;
    public static javax.swing.JTextField txtlogin;
    public static javax.swing.JTextField txtpassword;
    public static javax.swing.JTextField txtsueldo;
    // End of variables declaration//GEN-END:variables
}
