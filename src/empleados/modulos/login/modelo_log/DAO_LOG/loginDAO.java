/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.login.modelo_log.DAO_LOG;

import com.toedter.calendar.JTextFieldDateEditor;
import empleados.clases.fecha;
import empleados.librerias.Encriptar;
import static empleados.librerias.FileUploader.PATH_auto;
import empleados.librerias.validate;
import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.SingletonsUsu;
import empleados.modulos.Usuarios.gestionusuarios.modelo.clase.Usuario;
import empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF;
import empleados.modulos.login.modelo_log.BLL_LOG.loginBLL;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.SingletonsEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;
import static empleados.modulos.login.controlador_log.controlador_login.creaUSUlog;
import empleados.modulos.login.vista_log.Signin;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author damian
 */
public class loginDAO {
    
    public static String nombreUsugrafica() {

        String nom = "";
        boolean valida;
        nom = creaUSUlog.txtNombreEF.getText();        

        if (nom.isEmpty()) {

            creaUSUlog.txtNombreEF.setBackground(Color.red);
            creaUSUlog.txtNombreEF.requestFocus();

        } else {

            valida = validate.validateNombre(nom);
            if (valida = false) {

                creaUSUlog.txtNombreEF.setBackground(Color.red);
                creaUSUlog.txtNombreEF.requestFocus();

            } else {
                creaUSUlog.txtNombreEF.setBackground(Color.green);
            }

        }
        return nom;

    }

    public static String PoblacionUsugrafica() {
        String descrip = "";
        boolean valida;

        descrip = creaUSUlog.txtDepartamentoEF.getText();
        if (descrip.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del Departamento esta vacio, porfavor introduzca un Departamento");
            creaUSUlog.txtDepartamentoEF.setBackground(Color.red);
            creaUSUlog.txtDepartamentoEF.requestFocus();

        } else {

            //deprt=creaUSUlog.txtDescripcionProd.getText();
            creaUSUlog.txtDepartamentoEF.setBackground(Color.green);
        }
        return descrip;
    }

    public static String dniUsu() {
        String id = "";
        boolean valida;

        id = creaUSUlog.txtDNIEF.getText();

        if (id.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del DNI esta vacio, porfavor introduzca un DNI");
            creaUSUlog.txtDNIEF.setBackground(Color.red);
            creaUSUlog.txtDNIEF.requestFocus();

        } else {

            creaUSUlog.txtDNIEF.setBackground(Color.red);
            creaUSUlog.txtDNIEF.requestFocus();
            creaUSUlog.txtDNIEF.setBackground(Color.green);
        }
        return id;
    }

    public static fecha NaciUsugrafica() {
        String fechaAlta = "";
        fecha nac = null;
        boolean valida;

        
        fechaAlta = ((JTextFieldDateEditor) creaUSUlog.DatePikerEFNacEF.getDateEditor()).getText();
        nac = new fecha(fechaAlta);
        return nac;
    }

    public static String email() {
        String email = "";
        boolean valida;

        email = creaUSUlog.txtemail.getText();

        if (email.isEmpty()) {
            
            creaUSUlog.txtemail.setBackground(Color.red);
            creaUSUlog.txtemail.requestFocus();

        } else {
            
            valida = validate.email(email);
            if (valida = false) {

                creaUSUlog.txtemail.setBackground(Color.red);
                creaUSUlog.txtlogin.requestFocus();

            }

            creaUSUlog.txtemail.setBackground(Color.green);
        }
        return email;
    }

    public static String usuariologin() {
        String usu = "";
        boolean valida;

        usu = creaUSUlog.txtlogin.getText();
        if (usu.isEmpty()) {
            
            creaUSUlog.txtlogin.setBackground(Color.red);
            creaUSUlog.txtlogin.requestFocus();

        } else {

            creaUSUlog.txtlogin.setBackground(Color.green);
        }
        return usu;
    }

    public static String password() {
        String pass = "";
        boolean valida;

        pass = creaUSUlog.txtpassword.getText();
        if (pass.isEmpty()) {
            
            creaUSUlog.txtpassword.setBackground(Color.red);
            creaUSUlog.txtpassword.requestFocus();

        } else {

            creaUSUlog.txtpassword.setBackground(Color.green);
        }
        return pass;
    }
    
    
    public static Usuario creaUsuGrafica() {
        Usuario ef1 = null;
        //nombre
        String nom;
        String tipo = "";
        int validar, valida;

        nom = nombreUsugrafica();

        //departamento
        String pobl;
        pobl = PoblacionUsugrafica();

        //DNI
        String dni;
        dni = dniUsu();

        //eamil
        String email;
        email = email();

        //avatar
        String avatar;
        avatar = PATH_auto;

        //usuariologin
        String usuario;
        usuario = usuariologin();

        //password
        String Password;
        Password = password();

        //validar fnac
        fecha naci = null;
        naci = NaciUsugrafica();

        if (nom.isEmpty() || dni.isEmpty() || pobl.isEmpty() || usuario.isEmpty() || Password.isEmpty() || email.isEmpty() || naci == null) {
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
        } else {

            //miramos la diferencia entre la fecha de nacimiento y la actual
            valida = naci.calcularedad();

            if (valida < 16) {
                creaUSUlog.DatePikerEFNacEF.setBackground(Color.RED);
                creaUSUlog.DatePikerEFNacEF.requestFocus();
                JOptionPane.showMessageDialog(null, "No puede registrar a un menor de 16 años");
            } else {

                if (creaUSUlog.Usuario.isSelected()) {
                    tipo = "User";
                } else if (creaUSUlog.Admin.isSelected()) {
                    tipo = "admin";
                }

        //validamos
                
                SingletonsUsu.u = new Usuario(nom, dni, pobl, naci, usuario, Password, email, tipo, avatar);

                
                JOptionPane.showMessageDialog(null, "Se ha creado correctamente");

                creaUSUlog.txtNombreEF.setText("");
                creaUSUlog.txtDepartamentoEF.setText("");
                creaUSUlog.DatePikerEFNacEF.setDate(null);
                creaUSUlog.txtDNIEF.setText("");
                creaUSUlog.txtemail.setText("");
                creaUSUlog.txtlogin.setText("");
                creaUSUlog.txtpassword.setText("");
                creaUSUlog.txtNombreEF.requestFocus();

                creaUSUlog.txtNombreEF.setBackground(Color.WHITE);
                creaUSUlog.txtNombreEF.setBackground(Color.WHITE);
                creaUSUlog.txtDNIEF.setBackground(Color.WHITE);
                creaUSUlog.DatePikerEFNacEF.setBackground(Color.WHITE);
                creaUSUlog.txtemail.setBackground(Color.WHITE);
                creaUSUlog.txtlogin.setBackground(Color.WHITE);
                creaUSUlog.txtpassword.setBackground(Color.WHITE);
            }

        }
        return SingletonsUsu.u;

        
    }
    
    public static void Eniviaremail() {

        JOptionPane.showMessageDialog(null, "Envio Correcto, sus datos son: " + "Email: " + SingletonsUsu.u.getEmail() + "Password: " + SingletonsUsu.password.toString(), "Correcto", JOptionPane.INFORMATION_MESSAGE);
        //creamos el objeto Mail
        /*Mail mail = new Mail(SingletonsUsu.u.getEmail(), SingletonsUsu.password.toString());

         //enviamos el mensaje
         String error = mail.send();

         if (error.equals("")) {
         JOptionPane.showMessageDialog(null, "Envio Correcto", "Correcto", JOptionPane.INFORMATION_MESSAGE);
         } else {
         JOptionPane.showMessageDialog(null, "Error de envio:\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
         }*/
    }
    
    public static void borrarcamposcrea() {
        creaUSUlog.txtNombreEF.setText("");
        creaUSUlog.txtDepartamentoEF.setText("");
        creaUSUlog.DatePikerEFNacEF.setDate(null);
        creaUSUlog.txtDNIEF.setText("");
        creaUSUlog.txtemail.setText("");
        creaUSUlog.txtlogin.setText("");
        creaUSUlog.txtpassword.setText("");

        creaUSUlog.txtNombreEF.requestFocus();

    }
    

    public static void PideUsuario() {

        if (Signin.txtusuario.getText().isEmpty()) {
            Signin.txtusuario.setForeground(Color.red);
            //Iniciologin.txtusuario.setText("Introduzca usuario");
            //Iniciologin.txtusuario.requestFocus();
            return;
        }

        /*if (validate.validaDNI(Iniciologin.txtusuario.getText()) == false) {
         Iniciologin.txtusuario.setForeground(Color.red);
         Iniciologin.txtusuario.setText("Usuario inválido");
         Iniciologin.txtusuario.requestFocus();
         return;
         }*/
        //Iniciologin.txtpassword.requestFocus();
    }

    public static void PidePassword() {

        if (Signin.txtpassword.getText().isEmpty()) {
            Signin.txtpassword.setForeground(Color.red);
            //Iniciologin.txtpassword.setText("Introduzca password");
            //Iniciologin.txtpassword.requestFocus();
            return;
        }

        //Iniciologin.botonenter.requestFocus();
    }

    public static void confirmarlog() {

        String dni = Signin.txtusuario.getText();
        String password = Signin.txtpassword.getText();
        boolean login;
        String conectado = "no";

        loginBLL _login = new loginBLL();
        login = _login.loginusu(dni, password);
        if (/*LoginBLL.matchLoginPass()*/login == true) {
            conectado = "si";

            //new controladorEF(new subprincipal(), 0).Iniciar(0);
            //JPanel p4 = new JPanel();
            //p4.add(this.Logeado.jPanel1);
            //this.Inicio.jInternalFrame1.setContentPane(p4);
            /*new ControladorInicio(new VentanaInformacion(),2).Iniciar(2);
             JPanel p =  new JPanel();
             p.add(this.Informacion.jPanel1);
             this.Inicio.jInternalFrame1.setContentPane(p);
             this.Inicio.labelAvatarInicio.setBorder(BorderFactory.createLineBorder(Color.black));*/
        } else {
            Signin.txtpassword.setForeground(Color.red);
            Signin.txtpassword.setText("Contraseña incorrecta");
            Signin.txtusuario.setForeground(Color.red);
            Signin.txtusuario.setText("Usuario incorrecto");
            Signin.txtusuario.requestFocus();
            return;
        }

    }

    public boolean loginusu(Connection con, String dni, String password) {

        boolean resultado = false;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        fecha naci, contr;

        //Encriptar encriptador = new Encriptar(passPhrase);
        try {
            //stmt = con.prepareStatement("SELECT * FROM EFBBDD.Empleadofijo WHERE login=? AND Password=?");
            stmt = con.prepareStatement("SELECT * FROM efbbdd.empleadofijo WHERE login=? AND Password=?");

            stmt.setString(1, dni);
            stmt.setString(2, password);//encriptador.encrypt(password));
            stmt.setString(2, Encriptar.encriptarTokenMD5(password));
            rs = stmt.executeQuery();
            //null
            while (rs.next()) {
                empleadofijo e = new empleadofijo();
                e.setNombre(rs.getString("nombre"));
                e.setDepartamento(rs.getString("departamento"));
                naci = new fecha(rs.getString("fechaNacimiento"));
                e.setFechaNacimiento(naci);
                e.setSueldo(rs.getFloat("suelo"));
                e.setDni(rs.getString("dni"));
                e.setLogin(rs.getString("login"));
                e.setPassword(rs.getString("password"));
                e.setEmail(rs.getString("email"));
                e.setAvatar(rs.getString("avatar"));
                e.setTipo(rs.getString("tipo"));
                e.setEstado(rs.getInt("estado"));
                e.setAntiguedad(rs.getInt("antiguedad"));
                contr = new fecha(rs.getString("fechaContratacion"));
                e.setFechaContratacion(contr);

                dni = rs.getString("login");
                password = rs.getString("Password");
                SingletonsEF.efilogin = e;

                resultado = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger");
                }
            }
        }
        return resultado;

    }

    public boolean loginusuario(Connection con, String dni, String password) {

        boolean resultado = false;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        fecha naci, contr;

        //Encriptar encriptador = new Encriptar(passPhrase);
        try {
            //stmt = con.prepareStatement("SELECT * FROM EFBBDD.Empleadofijo WHERE login=? AND Password=?");
            stmt = con.prepareStatement("SELECT * FROM EFBBDD.usuarios WHERE login=? AND Password=?");

            stmt.setString(1, dni);
            stmt.setString(2, password);//encriptador.encrypt(password));
            stmt.setString(2, Encriptar.encriptarTokenMD5(password));
            rs = stmt.executeQuery();
            //null
            while (rs.next()) {
                Usuario usr = new Usuario();
                usr.setNombre(rs.getString("nombre"));
                usr.setDni(rs.getString("dni"));
                usr.setDepartamento(rs.getString("poblacion"));                
                naci = new fecha(rs.getString("fechaNacimiento"));
                usr.setFechaNacimiento(naci);
                usr.setLogin(rs.getString("login"));
                usr.setPassword(rs.getString("password"));
                usr.setEmail(rs.getString("email"));
                usr.setAvatar(rs.getString("avatar"));
                usr.setTipo(rs.getString("tipo"));
               

                dni = rs.getString("login");
                password = rs.getString("Password");
                SingletonsUsu.usulogin = usr;

                resultado = true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error Logger");
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger");
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error Logger");
                }
            }
        }
        return resultado;

    }
}
