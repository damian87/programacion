/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.Usuarios.gestionusuarios.modelo.BLL;

import empleados.clases.conexionBBDD;
import empleados.modulos.Usuarios.gestionusuarios.modelo.DAO.DAOBD_USU;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class BLLBD_USU {

    //Nuevo Producto
    public int nuevoUsu_BD() {

        Connection _con = null;
        //int newefi = 0;
        conexionBBDD conexion_DB = new conexionBBDD();
        _con = conexion_DB.AbrirConexion();
        DAOBD_USU usu_DAO = new DAOBD_USU();

        int rd = usu_DAO.nuevoUsuario(_con);
        conexion_DB.CerrarConexion(_con);
        return rd;

    }

    //Listar Productos
    public void listarUsus_BD() {
        Connection _con = null;
        //ArrayList<empleadofijo> listar = new ArrayList();
        conexionBBDD conexion_DB = new conexionBBDD();
        _con = conexion_DB.AbrirConexion();
        DAOBD_USU usu_DAO = new DAOBD_USU();
        try {
            usu_DAO.listarUsuarios(_con);//Recuperamos los usuarios       
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");

        }
        conexion_DB.CerrarConexion(_con);

    }

    //Modificar Producto
    public int modificarUsu_BD() {

        Connection _con;
        //producto ProductoModificado = null;
        conexionBBDD conexion_DB = new conexionBBDD();
        _con = conexion_DB.AbrirConexion();

        //JOptionPane.showMessageDialog(null, ArraylistEF.efi.toString());
        DAOBD_USU usu_DAO = new DAOBD_USU();

        int rd = usu_DAO.modificarUsuario(_con);

        conexion_DB.CerrarConexion(_con);
        return rd;

    }

    //Eliminar Producto
    public int eliminarUsu() {

        Connection _con;
        //producto ProductoBorrado = null;
        conexionBBDD conexion_DB = new conexionBBDD();
        _con = conexion_DB.AbrirConexion();

        DAOBD_USU usu_DAO = new DAOBD_USU();

        int rd = usu_DAO.borrarUsuario(_con);

        conexion_DB.CerrarConexion(_con);
        return rd;
    }

    //Prducto Mayor Menor
    public void Usuario_MenorMayorBLL() {

        Connection _con = null;
        conexionBBDD _conexion_DB = new conexionBBDD();
        _con = _conexion_DB.AbrirConexion();

        DAOBD_USU usu_DAO = new DAOBD_USU();
        usu_DAO.UsuarioMenorMayorDAO(_con);
        _conexion_DB.CerrarConexion(_con);

    }

    //obtener la edad media de todos los clientes
    public void EdadMediaBLL() {

        Connection _con = null;
        conexionBBDD _conexion_DB = new conexionBBDD();
        _con = _conexion_DB.AbrirConexion();
        DAOBD_USU usu_DAO = new DAOBD_USU();
        usu_DAO.edadMediaUsuDAO(_con);
        _conexion_DB.CerrarConexion(_con);
    }

}
