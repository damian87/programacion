/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.gestionempleados.gestionEF.modelo.DAO;

import empleados.librerias.Encriptar;
import empleados.clases.fecha;
import static empleados.modulos.gestionempleados.gestionEF.modelo.DAO.dummiesef.dummies;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.SingletonsEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author damian
 */
public class DAOBD_EF {

    //public int nuevoEF(Connection con, empleadofijo empf) throws SQLException{
    public int nuevoEF(Connection con) {
        //JOptionPane.showMessageDialog(null, "linea 28 DAOBD_EF"+ArraylistEF.efi.toString());

        PreparedStatement stmt = null;
        int b = 0;
        try {

            stmt = con.prepareStatement("INSERT INTO EFBBDD.Empleadofijo"
                    //stmt = con.prepareStatement("INSERT INTO efbbdd.empleadofijo"
                    + "(nombre,edad,departamento,fechaNacimiento,suelo,dni,login,password,email,avatar,tipo,"
                    + "estado,antiguedad,fechaContratacion) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, SingletonsEF.efi.getNombre());
            stmt.setInt(2, SingletonsEF.efi.getEdad());
            stmt.setString(3, SingletonsEF.efi.getDepartamento());
            stmt.setString(4, SingletonsEF.efi.getFechaNacimiento().toString());
            stmt.setFloat(5, SingletonsEF.efi.getSueldo());
            stmt.setString(6, SingletonsEF.efi.getDni());
            stmt.setString(7, SingletonsEF.efi.getLogin());
            //stmt.setString(8, ArraylistEF.efi.getPassword());
            stmt.setString(8, Encriptar.encriptarTokenMD5(SingletonsEF.efi.getPassword()));
            stmt.setString(9, SingletonsEF.efi.getEmail());
            stmt.setString(10, SingletonsEF.efi.getAvatar());
            stmt.setString(11, SingletonsEF.efi.getTipo());
            stmt.setInt(12, SingletonsEF.efi.getEstado());
            stmt.setInt(13, SingletonsEF.efi.cambiarAntiguedad());
            stmt.setString(14, SingletonsEF.efi.getFechaContratacion().toString());

            b = stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "El usuario ha sido dado de alta y guardado en la base de datos correctamente!");

        } catch (SQLException ex) {
            //throw new Exception("Ha habido un problema al insertar la factura "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ha habido un problema al insertar un nuevo usuario!");
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

    public void listarEF_BD(Connection con) throws SQLException {

        //ArrayList<usuario> _listaUsuarios = new ArrayList();
        SingletonsEF.ef.clear();
        ResultSet rs = null;
        PreparedStatement stmt = null;
        fecha naci, contr;

        try {
            stmt = con.prepareStatement("SELECT * FROM EFBBDD.Empleadofijo");
            //stmt = con.prepareStatement("SELECT * FROM efbbdd.empleadofijo");
            rs = stmt.executeQuery();
            empleadofijo emplfijo = null;
            while (rs.next()) {
                emplfijo = new empleadofijo();
                emplfijo.setNombre(rs.getString("nombre"));
                emplfijo.setDepartamento(rs.getString("departamento"));
                naci = new fecha(rs.getString("fechaNacimiento"));
                //JOptionPane.showMessageDialog(null, naci);
                emplfijo.setFechaNacimiento(naci);
                emplfijo.setDni(rs.getString("dni"));
                emplfijo.setLogin(rs.getString("login"));
                emplfijo.setPassword(rs.getString("password"));
                emplfijo.setEmail(rs.getString("email"));
                emplfijo.setAvatar(rs.getString("avatar"));
                emplfijo.setTipo(rs.getString("tipo"));
                //emplfijo.setEstado(rs.getInt(0));
                contr = new fecha(rs.getString("fechaContratacion"));
                emplfijo.setFechaContratacion(contr);

                SingletonsEF.ef.add(emplfijo);

            }

        } catch (SQLException ex) {

            //throw new Exception("Ha habido un problema al buscar los articulos "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ha habido un problema al obtener los usuarios!");
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

    public int modificarEFDAO(Connection con) {
//boolean
        //JOptionPane.showMessageDialog(null, ArraylistEF.efi.toString());
        //JOptionPane.showMessageDialog(null, efijo.toString());
        PreparedStatement stmt = null;
        int b = 0;
        try {

            stmt = con.prepareStatement("UPDATE EFBBDD.Empleadofijo SET nombre=?,edad=?,departamento=?,"
                    //stmt = con.prepareStatement("UPDATE efbbdd.empleadofijo SET nombre=?,edad=?,departamento=?,"
                    + "fechaNacimiento=?,suelo=?,dni=?,login=?,password=?,email=?,avatar=?,tipo=?,estado=?,"
                    + "antiguedad=?,fechaContratacion=? WHERE dni=? ");
            //VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)

            //stmt = con.prepareStatement("UPDATE usuarios SET usuario=?, password=?, nombre=?, apellido=?, fecha_Nacimiento=?, edad=?,"
            //      + "fecha_alta=?, telefono=?, ciudad=?, codigo_postal=?, email=?, tipo=? WHERE dni=?");
            stmt.setString(1, SingletonsEF.efi.getNombre());
            stmt.setInt(2, SingletonsEF.efi.getEdad());
            stmt.setString(3, SingletonsEF.efi.getDepartamento());
            stmt.setString(4, SingletonsEF.efi.getFechaNacimiento().toString());
            stmt.setFloat(5, SingletonsEF.efi.getSueldo());
            stmt.setString(6, SingletonsEF.efi.getDni());
            stmt.setString(7, SingletonsEF.efi.getLogin());
            stmt.setString(8, SingletonsEF.efi.getPassword());
            stmt.setString(9, SingletonsEF.efi.getEmail());
            stmt.setString(10, SingletonsEF.efi.getAvatar());
            stmt.setString(11, SingletonsEF.efi.getTipo());
            stmt.setInt(12, SingletonsEF.efi.getEstado());
            stmt.setInt(13, SingletonsEF.efi.cambiarAntiguedad());
            stmt.setString(14, SingletonsEF.efi.getFechaContratacion().toString());
            stmt.setString(15, SingletonsEF.efi.getDni());

            //stmt.executeUpdate();
            b = stmt.executeUpdate();
            //JOptionPane.showMessageDialog(null, "El usuario ha sido modificado correctamente!");

        } catch (SQLException ex) {
            //throw new Exception("Ha habido un problema al insertar la factura "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el usuario!");
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
    
    public int modificarEFDAOlogin(Connection con) {
//boolean
        //JOptionPane.showMessageDialog(null, ArraylistEF.efi.toString());
        //JOptionPane.showMessageDialog(null, efijo.toString());
        PreparedStatement stmt = null;
        int b = 0;
        try {

            stmt = con.prepareStatement("UPDATE EFBBDD.Empleadofijo SET nombre=?,edad=?,departamento=?,"
                    //stmt = con.prepareStatement("UPDATE efbbdd.empleadofijo SET nombre=?,edad=?,departamento=?,"
                    + "fechaNacimiento=?,suelo=?,dni=?,login=?,password=?,email=?,avatar=?,tipo=?,estado=?,"
                    + "antiguedad=?,fechaContratacion=? WHERE dni=? ");
            //VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)

            //stmt = con.prepareStatement("UPDATE usuarios SET usuario=?, password=?, nombre=?, apellido=?, fecha_Nacimiento=?, edad=?,"
            //      + "fecha_alta=?, telefono=?, ciudad=?, codigo_postal=?, email=?, tipo=? WHERE dni=?");
            stmt.setString(1, SingletonsEF.efilogin.getNombre());
            stmt.setInt(2, SingletonsEF.efilogin.getEdad());
            stmt.setString(3, SingletonsEF.efilogin.getDepartamento());
            stmt.setString(4, SingletonsEF.efilogin.getFechaNacimiento().toString());
            stmt.setFloat(5, SingletonsEF.efilogin.getSueldo());
            stmt.setString(6, SingletonsEF.efilogin.getDni());
            stmt.setString(7, SingletonsEF.efilogin.getLogin());
            stmt.setString(8, SingletonsEF.efilogin.getPassword());
            stmt.setString(9, SingletonsEF.efilogin.getEmail());
            stmt.setString(10, SingletonsEF.efilogin.getAvatar());
            stmt.setString(11, SingletonsEF.efilogin.getTipo());
            stmt.setInt(12, SingletonsEF.efilogin.getEstado());
            stmt.setInt(13, SingletonsEF.efilogin.cambiarAntiguedad());
            stmt.setString(14, SingletonsEF.efilogin.getFechaContratacion().toString());
            stmt.setString(15, SingletonsEF.efilogin.getDni());

            //stmt.executeUpdate();
            b = stmt.executeUpdate();
            //JOptionPane.showMessageDialog(null, "El usuario ha sido modificado correctamente!");

        } catch (SQLException ex) {
            //throw new Exception("Ha habido un problema al insertar la factura "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el usuario!");
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

    public int borrarEFDAO(Connection con) {

        PreparedStatement stmt = null;
        int b = 0;
        try {
            stmt = con.prepareStatement("DELETE FROM EFBBDD.Empleadofijo WHERE dni=?");
            //stmt = con.prepareStatement("DELETE FROM efbbdd.empleadofijo WHERE dni=?");
            stmt.setString(1, SingletonsEF.efi.getDni());
            b = stmt.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un error al eliminar el usuario!");
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

    /*
     public static void cargardummiesEF() throws SQLException{
     dummiesef.dummies();
     }
     */
    public void EFMenorMayorDAO(Connection conexion) {

        CallableStatement cstmt = null;
        String cadena = "";
        try {
            cstmt = (CallableStatement) conexion.prepareCall("{call mayormenor(?,?)}");
            cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
            cstmt.registerOutParameter(2, java.sql.Types.INTEGER);
            cstmt.execute();
            cadena = cadena + "empleadoEFjoven: " + cstmt.getInt(1) + " años" + "\n";
            cadena = cadena + "EmpleadoEFmayor: " + cstmt.getInt(2) + " años";
            JOptionPane.showMessageDialog(null, cadena, "Cliente menor/mayor", 1);
        } catch (SQLException ex) {
            //Logger.getLogger(alumnoPresencialDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }

    }

    public void EdadMediaDAO(Connection conexion) {

        CallableStatement cstmt = null;
        String cadena = "";
        try {
            cstmt = (CallableStatement) conexion.prepareCall("{call mediaedad(?)}");
            cstmt.registerOutParameter(1, java.sql.Types.DOUBLE);
            cstmt.execute();
            cadena = cadena + "Edad media: " + (int) cstmt.getDouble(1) + " años";
            JOptionPane.showMessageDialog(null, cadena, "Edad media", 1);
        } catch (SQLException ex) {
            //Logger.getLogger(alumnoPresencialDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error Logger!");
        }

    }

    public int restartpass(Connection con, String usu, String pass) {
//boolean

        //JOptionPane.showMessageDialog(null, efijo.toString());
        PreparedStatement stmt = null;
        int b = 0;
        try {

            stmt = con.prepareStatement("UPDATE EFBBDD.Empleadofijo SET password=? WHERE login=? ");
            //stmt = con.prepareStatement("UPDATE efbbdd.empleadofijo SET password=? WHERE login=? ");
            //VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)

            //stmt = con.prepareStatement("UPDATE usuarios SET usuario=?, password=?, nombre=?, apellido=?, fecha_Nacimiento=?, edad=?,"
            //      + "fecha_alta=?, telefono=?, ciudad=?, codigo_postal=?, email=?, tipo=? WHERE dni=?");
            stmt.setString(1, pass);
            stmt.setString(2, usu);

            //stmt.executeUpdate();
            b = stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "La contraseña ha sido modificada correctamente!");

        } catch (SQLException ex) {
            //throw new Exception("Ha habido un problema al insertar la factura "+ex.getMessage());
            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar el password!");
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
}
