/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.login.modelo_log.BLL_LOG;

import empleados.clases.conexionBBDD;
import empleados.modulos.login.modelo_log.DAO_LOG.loginDAO_BD;
import java.sql.Connection;

/**
 *
 * @author Usuario
 */
public class loginBLL_BD {
    
    public int nuevoUsu_BD() {

        Connection _con = null;
        //int newefi = 0;
        conexionBBDD conexion_DB = new conexionBBDD();
        _con = conexion_DB.AbrirConexion();
        loginDAO_BD usu_DAO = new loginDAO_BD();

        int rd = usu_DAO.nuevoUsuario(_con);
        conexion_DB.CerrarConexion(_con);
        return rd;

    }
    
}
