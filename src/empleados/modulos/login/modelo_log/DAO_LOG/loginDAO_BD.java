/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.login.modelo_log.DAO_LOG;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class loginDAO_BD {
    
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
