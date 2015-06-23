/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.login.modelo_log.BLL_LOG;

import empleados.clases.conexionBBDD;
import empleados.librerias.Encriptar;
import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.SingletonsUsu;
import empleados.modulos.Usuarios.gestionusuarios.modelo.clase.Usuario;
import empleados.modulos.login.controlador_log.controlador_login;
import static empleados.modulos.login.controlador_log.controlador_login.creaUSUlog;
//import static empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF.recordar;
import static empleados.modulos.login.controlador_log.controlador_login.recordar;

//import empleados.modulos.gestionempleados.gestionEF.modelo.DAO.DAOBD_EF;
import empleados.modulos.login.modelo_log.DAO_LOG.loginDAO;
import empleados.modulos.login.modelo_log.DAO_LOG.loginDAO_BD;
import empleados.modulos.login.vista_log.Signin;
import java.awt.Color;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author damian
 */
public class loginBLL {
    
    public static int buscar(Usuario prdoc) {//Buscar
        int aux = -1;

        for (int i = 0; i <= (SingletonsUsu.usu.size() - 1); i++) {
            if ((SingletonsUsu.usu.get(i)).equals(prdoc))//buclea hasta que encuentra un dni que sea igual con el comparator de la madre y lo devuelve como aux
            {
                aux = i;
            }
        }
        return aux;//devuelve aux, si lo ha encontrado dara la posicion, si no devolvera -1.
    }
    
    public static void crearUsuarioGrafica() {
        int found = 0;
        int mail=0;
        loginDAO.creaUsuGrafica();

        //dni no repes
        found = buscar(SingletonsUsu.u);
        if (found != -1) {
            JOptionPane.showMessageDialog(null, "El Dni ya existe, el Usuario no ha sido creado, porfavor revise los datos");
        } else {                       
            loginBLL_BD guardar = new loginBLL_BD();               
            SingletonsUsu.password = SingletonsUsu.u.getPassword();
            //StringEncrypter.encriptarTokenMD5(ArraylistEF.efi.getPassword());
            mail= guardar.nuevoUsu_BD();
            if (mail==1){
                loginDAO.Eniviaremail();
            }
            

        }

    }
    
    public static void BorrarcamposUsuarioCreagrafica() {
        
        if (SingletonsUsu.usulogin == null) {
            loginDAO.borrarcamposcrea();
            creaUSUlog.dispose();
            new controlador_login(new Signin(), 5).Iniciar(5);

        } else if ("User".equals(SingletonsUsu.usulogin.getTipo())) {

            loginDAO.borrarcamposcrea();
            creaUSUlog.dispose();
            new controlador_login(new Signin(), 5).Iniciar(5);

        /*} else {
            loginDAO.borrarcamposcrea();
            creaUSUlog.dispose();
            new controladorUSU(new interfaceUSUgrafica(), 1).Iniciar(1);
        */}
    }
    
     public static void nombreUsuariografica() {
        loginDAO.nombreUsugrafica();
    }
    
    public static void PoblacionUsugrafica() {
        loginDAO.PoblacionUsugrafica();
    }

    public static void dniUsugrafica() {
        loginDAO.dniUsu();
    }        

    public static void FechanaciUsuariografica() {
        loginDAO.NaciUsugrafica();
    }
    
    public static void emailUsuariografica() {
        loginDAO.email();
    }
    
    public static void passwordUsuariografica() {
        loginDAO.password();
    }
    
    public static void loginUsuariografica() {
        loginDAO.usuariologin();
    }
    

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

        //_resul = _loginDAO.loginusu(_con, dni, password);
        _resul = _loginDAO.loginusuario(_con, dni, password);

        _conexion_DB.CerrarConexion(_con);

        return _resul;

    }

    public int resstablecerpass() {
        Connection _con;
        int _resul;
        String usu, pass;
        usu = recordar.txtlogin.getText();
        pass = recordar.txtpassword.getText();
        pass=Encriptar.encriptarTokenMD5(pass);
        conexionBBDD _conexion_DB = new conexionBBDD();

        _con = _conexion_DB.AbrirConexion();

        //DAOBD_EF _resetpassword = new DAOBD_EF();
        loginDAO_BD _resetpassword = new loginDAO_BD();

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
