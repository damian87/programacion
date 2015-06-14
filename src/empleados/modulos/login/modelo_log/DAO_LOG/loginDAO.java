/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.login.modelo_log.DAO_LOG;

import empleados.clases.fecha;
import empleados.clases.Encriptar;
import empleados.librerias.validate;
import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.SingletonsUsu;
import empleados.modulos.Usuarios.gestionusuarios.modelo.clase.Usuario;
import empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF;
import empleados.modulos.login.modelo_log.BLL_LOG.loginBLL;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.SingletonsEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;
import empleados.modulos.login.vista_log.Iniciologin;
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

    public static void PideUsuario() {

        if (Iniciologin.txtusuario.getText().isEmpty()) {
            Iniciologin.txtusuario.setForeground(Color.red);
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

        if (Iniciologin.txtpassword.getText().isEmpty()) {
            Iniciologin.txtpassword.setForeground(Color.red);
            //Iniciologin.txtpassword.setText("Introduzca password");
            //Iniciologin.txtpassword.requestFocus();
            return;
        }

        //Iniciologin.botonenter.requestFocus();
    }

    public static void confirmarlog() {

        String dni = Iniciologin.txtusuario.getText();
        String password = Iniciologin.txtpassword.getText();
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
            Iniciologin.txtpassword.setForeground(Color.red);
            Iniciologin.txtpassword.setText("Contraseña incorrecta");
            Iniciologin.txtusuario.setForeground(Color.red);
            Iniciologin.txtusuario.setText("Usuario incorrecto");
            Iniciologin.txtusuario.requestFocus();
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
