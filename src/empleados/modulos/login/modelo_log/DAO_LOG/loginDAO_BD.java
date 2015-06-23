/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.login.modelo_log.DAO_LOG;

import empleados.librerias.Encriptar;
import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.SingletonsUsu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class loginDAO_BD {
    public int nuevoUsuario(Connection con) {

        PreparedStatement stmt = null;
        int b = 0;
        try {

            //recordar de cambiar la columna poblacion en BBDD por localidad
            stmt = con.prepareStatement("INSERT INTO EFBBDD.usuarios"
                    + "(nombre,edad,dni,poblacion,fechaNacimiento,"
                    + "login,password,email,avatar,tipo)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, SingletonsUsu.u.getNombre());
            stmt.setInt(2, SingletonsUsu.u.getEdad());
            stmt.setString(3, SingletonsUsu.u.getDni());
            stmt.setString(4, SingletonsUsu.u.getDepartamento());//localidad
            stmt.setString(5, SingletonsUsu.u.getFechaNacimiento().toString());
            stmt.setString(6, SingletonsUsu.u.getLogin());
            stmt.setString(7, Encriptar.encriptarTokenMD5(SingletonsUsu.u.getPassword()));
            stmt.setString(8, SingletonsUsu.u.getEmail());
            stmt.setString(9, SingletonsUsu.u.getAvatar());
            stmt.setString(10, SingletonsUsu.u.getTipo());            
            b = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "El Usuario ha sido introducido y guardado en la base de datos correctamente!");

        } catch (SQLException ex) {
            //throw new Exception("Ha habido un problema al insertar la factura "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo Usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    //Logger.getLogger(alumnoPresencialDAO.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        return b;
    }
    
    
     public int restartpass(Connection con, String usu, String pass) {

        PreparedStatement stmt = null;
        int b = 0;
        try {

            stmt = con.prepareStatement("UPDATE EFBBDD.usuarios SET password=? WHERE login=? ");
            
            stmt.setString(1, pass);
            stmt.setString(2, usu);
            
            b = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "La contraseña ha sido modificada correctamente!");

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el password!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    
                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }
        return b;

    }
    
}
