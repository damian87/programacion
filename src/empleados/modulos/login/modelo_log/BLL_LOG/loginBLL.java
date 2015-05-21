/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.login.modelo_log.BLL_LOG;

import empleados.clases.conexionBBDD;
import empleados.clases.StringEncrypter;
import static empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF.recordar;
import empleados.modulos.gestionempleados.gestionEF.modelo.DAO.DAOBD_EF;
import empleados.modulos.login.modelo_log.DAO_LOG.loginDAO;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author damian
 */
public class loginBLL {

    public static void Usuario() {
        loginDAO.PideUsuario();
    }

    public static void Password() {
        loginDAO.PidePassword();
    }

    public static void confirmar() {
        loginDAO.confirmarlog();
    }

    public boolean loginusu(String dni, String password) {
        Connection _con;
        boolean _resul;
        conexionBBDD _conexion_DB = new conexionBBDD();

        _con = _conexion_DB.AbrirConexion();

        loginDAO _loginDAO = new loginDAO();

        _resul = _loginDAO.loginusu(_con, dni, password);

        _conexion_DB.CerrarConexion(_con);

        return _resul;

    }

    public int resstablecerpass() {
        Connection _con;
        int _resul;
        String usu, pass;
        usu = recordar.txtlogin.getText();
        pass = recordar.txtpassword.getText();
        pass=StringEncrypter.encriptarTokenMD5(pass);
        conexionBBDD _conexion_DB = new conexionBBDD();

        _con = _conexion_DB.AbrirConexion();

        DAOBD_EF _resetpassword = new DAOBD_EF();

        _resul = _resetpassword.restartpass(_con, usu, pass);

        _conexion_DB.CerrarConexion(_con);

        if (_resul == 1) {
            recordar.txtlogin.setBackground(Color.GREEN);
            recordar.txtpassword.setBackground(Color.GREEN);
        } else {
            JOptionPane.showMessageDialog(null, "El usuario es incorrecto");
            recordar.txtlogin.setBackground(Color.RED);
            recordar.txtpassword.setBackground(Color.RED);
        }

        return _resul;

    }

}
