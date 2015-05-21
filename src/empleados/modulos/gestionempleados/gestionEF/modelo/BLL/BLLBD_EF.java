/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.gestionempleados.gestionEF.modelo.BLL;

import empleados.clases.conexionBBDD;
import empleados.modulos.gestionempleados.gestionEF.modelo.DAO.DAOBD_EF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.ArraylistEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author damian
 */
public class BLLBD_EF {

    public int nuevoEF_BD() {

        Connection _con = null;
        //empleadofijo newefi = null;
        int newefi = 0;
        conexionBBDD conexion_DB = new conexionBBDD();
        _con = conexion_DB.AbrirConexion();
        DAOBD_EF usu_DAO = new DAOBD_EF();

        int rd = usu_DAO.nuevoEF(_con);
        conexion_DB.CerrarConexion(_con);
        return rd;

    }

    //public ArrayList<empleadofijo> listarEF_BD() {
    public void listarEF_BD() {
        Connection _con = null;
        //ArrayList<empleadofijo> listar = new ArrayList();
        conexionBBDD conexion_DB = new conexionBBDD();
        _con = conexion_DB.AbrirConexion();
        DAOBD_EF usu_DAO = new DAOBD_EF();
        try {
            usu_DAO.listarEF_BD(_con);//Recuperamos los usuarios       
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");

        }
        conexion_DB.CerrarConexion(_con);

        //return listar;
    }

    public int modificarEF_BD() {

        Connection _con;
        empleadofijo EFModificado = null;
        conexionBBDD conexion_DB = new conexionBBDD();
        _con = conexion_DB.AbrirConexion();

        //JOptionPane.showMessageDialog(null, ArraylistEF.efi.toString());
        DAOBD_EF usu_DAO = new DAOBD_EF();

        int rd = usu_DAO.modificarEFDAO(_con);

        conexion_DB.CerrarConexion(_con);
        return rd;

    }

    public int eliminarEF() {

        Connection _con;
        empleadofijo EFborrado = null;
        conexionBBDD conexion_DB = new conexionBBDD();
        _con = conexion_DB.AbrirConexion();

        DAOBD_EF usu_DAO = new DAOBD_EF();

        int rd = usu_DAO.borrarEFDAO(_con);

        conexion_DB.CerrarConexion(_con);
        return rd;
    }

    public void EF_MenorMayorBLL() {

        Connection _con = null;
        conexionBBDD _conexion_DB = new conexionBBDD();
        _con = _conexion_DB.AbrirConexion();

        DAOBD_EF _usuario = new DAOBD_EF();
        _usuario.EFMenorMayorDAO(_con);
        _conexion_DB.CerrarConexion(_con);

    }

    /**
     * obtener la edad media de todos los clientes
     */
    public void EdadMediaBLL() {

        Connection _con = null;
        conexionBBDD _conexion_DB = new conexionBBDD();
        _con = _conexion_DB.AbrirConexion();
        DAOBD_EF _usuario = new DAOBD_EF();
        _usuario.EdadMediaDAO(_con);
        _conexion_DB.CerrarConexion(_con);
    }

}
