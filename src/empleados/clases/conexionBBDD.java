/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.clases;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;



/**
 *
 * @author damian
 */
public class conexionBBDD {
     public Connection AbrirConexion() {
      


         Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //String urlOdbc = "jdbc:mysql://192.168.21.100:3306/EFBBDD";
            //String urlOdbc = "jdbc:mysql://192.168.21.100:3306/efbbdd";
            String urlOdbc = "jdbc:mysql://localhost:3306/EFBBDD";
            con = (java.sql.DriverManager.getConnection(urlOdbc, "root", ""));
            //JOptionPane.showMessageDialog(null, "Si funciona");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha sido imposible establecer la conexion!");
        }
        return con;
    }
    /**
     * cerramos la conexion en la bd
     * @param con
     */
    public void CerrarConexion(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ha sido imposible cerrar la conexion!");
        }
    }
    
    
}
