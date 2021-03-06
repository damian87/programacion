/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.Usuarios.gestionusuarios.modelo.DAO;

import empleados.librerias.Encriptar;
import empleados.clases.fecha;
import empleados.modulos.Usuarios.gestionusuarios.modelo.clase.Usuario;
import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.SingletonsUsu;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class DAOBD_USU {

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

    public void listarUsuarios(Connection con) throws SQLException {

        //ArrayList<usuario> _listaUsuarios = new ArrayList();
        SingletonsUsu.usu.clear();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        fecha alta, naci;

        try {
            stmt = con.prepareStatement("SELECT * FROM EFBBDD.usuarios");
            rs = stmt.executeQuery();
            Usuario usr = null;
            while (rs.next()) {
                usr = new Usuario();                                
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

                SingletonsUsu.usu.add(usr);
                
            }

        } catch (SQLException ex) {

            //throw new Exception("Ha habido un problema al buscar los articulos "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los Usuarios!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {

                    JOptionPane.showMessageDialog(null, "Ha habido un error Logger!");
                }
            }
        }

    }

    public int modificarUsuario(Connection con) {

        PreparedStatement stmt = null;
        int b = 0;
        try {
            /*
            "INSERT INTO EFBBDD.usuarios"
                    + "(nombre,edad,dni,poblacion,fechaNacimiento,"
                    + "login,password,email,avatar,tipo)"
            */
            stmt = con.prepareStatement("UPDATE EFBBDD.usuarios SET nombre=?,edad=?,dni=?,"
                    + "poblacion=?,fechaNacimiento=?,"
                    + "login=?, password=?, email=?, avatar=?, tipo=? WHERE dni=? ");

            stmt.setString(1, SingletonsUsu.u.getNombre());
            stmt.setInt(2, SingletonsUsu.u.getEdad());
            stmt.setString(3, SingletonsUsu.u.getDni());
            stmt.setString(4, SingletonsUsu.u.getDepartamento());//localidad
            stmt.setString(5, SingletonsUsu.u.getFechaNacimiento().toString());            
            stmt.setString(6, SingletonsUsu.u.getLogin());
            stmt.setString(7, SingletonsUsu.u.getPassword());
            stmt.setString(8, SingletonsUsu.u.getEmail());
            stmt.setString(9, SingletonsUsu.u.getAvatar());
            stmt.setString(10, SingletonsUsu.u.getTipo());
            stmt.setString(11, SingletonsUsu.u.getDni());
            

            b = stmt.executeUpdate();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el Usuario!");
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
    
    public int modificarUsuariologin(Connection con) {

        PreparedStatement stmt = null;
        int b = 0;
        try {
            /*
            "INSERT INTO EFBBDD.usuarios"
                    + "(nombre,edad,dni,poblacion,fechaNacimiento,"
                    + "login,password,email,avatar,tipo)"
            */
            stmt = con.prepareStatement("UPDATE EFBBDD.usuarios SET nombre=?,edad=?,dni=?,"
                    + "poblacion=?,fechaNacimiento=?,"
                    + "login=?, password=?, email=?, avatar=?, tipo=? WHERE dni=? ");

            stmt.setString(1, SingletonsUsu.usulogin.getNombre());
            stmt.setInt(2, SingletonsUsu.usulogin.getEdad());
            stmt.setString(3, SingletonsUsu.usulogin.getDni());
            stmt.setString(4, SingletonsUsu.usulogin.getDepartamento());//localidad
            stmt.setString(5, SingletonsUsu.usulogin.getFechaNacimiento().toString());            
            stmt.setString(6, SingletonsUsu.usulogin.getLogin());
            stmt.setString(7, SingletonsUsu.usulogin.getPassword());
            stmt.setString(8, SingletonsUsu.usulogin.getEmail());
            stmt.setString(9, SingletonsUsu.usulogin.getAvatar());
            stmt.setString(10, SingletonsUsu.usulogin.getTipo());
            stmt.setString(11, SingletonsUsu.usulogin.getDni());
            

            b = stmt.executeUpdate();

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el Usuario!");
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

    public int borrarUsuario(Connection con) {

        PreparedStatement stmt = null;
        int b = 0;
        try {
            stmt = con.prepareStatement("DELETE FROM EFBBDD.usuarios WHERE dni=?");
            stmt.setString(1, SingletonsUsu.u.getDni());
            b = stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el Usuario!");
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en el Logger!");
                }
            }
        }
        return b;
    }

    public void UsuarioMenorMayorDAO(Connection conexion) {

        CallableStatement cstmt = null;
        String cadena = "";
        try {
            cstmt = (CallableStatement) conexion.prepareCall("{call mayor_menor(?,?)}");
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            cstmt.execute();
            cadena = cadena + "Usuarios mas joven: " + cstmt.getInt(1) + " años" + "\n";
            cadena = cadena + "Usuarios mas Mayor: " + cstmt.getInt(2) + " años";
            JOptionPane.showMessageDialog(null, cadena, "Producto menor/mayor", 1);
        } catch (SQLException ex) {
            //Logger.getLogger(alumnoPresencialDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }

    }

    public void edadMediaUsuDAO(Connection conexion) {

        CallableStatement cstmt = null;
        String cadena = "";
        try {
            cstmt = (CallableStatement) conexion.prepareCall("{call media_edad(?)}");
            cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);
            cstmt.execute();
            cadena = cadena + "Edad media: " + (int) cstmt.getDouble(1) + " años";
            JOptionPane.showMessageDialog(null, cadena, "Edad media", 1);
        } catch (SQLException ex) {
            //Logger.getLogger(alumnoPresencialDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }

    }

}
