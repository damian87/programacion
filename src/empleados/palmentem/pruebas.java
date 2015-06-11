/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.palmentem;

import empleados.clases.conexionBBDD;
import empleados.clases.configuracion;
import static empleados.menuempleados.conf;
import empleados.modulos.gestionempleados.gestionEF.modelo.DAO.DAOBD_EF;
import empleados.modulos.gestionempleados.gestionEF.modelo.DAO.dummiesef;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.SingletonsEF;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author damian
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static configuracion conf=null;
    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        conf=new configuracion();
        
        Connection _con = null;
        conexionBBDD _conBBDD = new conexionBBDD();
        
        _con=_conBBDD.AbrirConexion();
        DAOBD_EF listar = new DAOBD_EF();
        listar.listarEF_BD(_con);
        _conBBDD.CerrarConexion(_con);
                
       //dummiesef.dummies();
        
        JOptionPane.showMessageDialog(null, "imprime"+SingletonsEF.ef.toString());
        
    }
    
}
