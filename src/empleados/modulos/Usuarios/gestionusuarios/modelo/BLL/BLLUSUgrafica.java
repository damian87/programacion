/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.Usuarios.gestionusuarios.modelo.BLL;

import empleados.clases.Encriptar;
import empleados.librerias.FileUploader;
import empleados.modulos.Usuarios.gestionusuarios.controlador.controladorUSU;
import static empleados.modulos.Usuarios.gestionusuarios.controlador.controladorUSU.creaUSU;
import static empleados.modulos.Usuarios.gestionusuarios.controlador.controladorUSU.modiUSU;
import empleados.modulos.Usuarios.gestionusuarios.modelo.clase.Usuario;
import empleados.modulos.Usuarios.gestionusuarios.modelo.DAO.DAOUSUgrafica;
import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.STMUSU;
import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.SingletonsUsu;
import empleados.modulos.Usuarios.gestionusuarios.modelo.pagerprod.pagina;
import empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica;
import static empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.TABLA;
import empleados.modulos.login.controlador_log.controlador_login;
import empleados.modulos.login.vista_log.Iniciologin;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class BLLUSUgrafica {
    
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
        DAOUSUgrafica.creaUsuGrafica();

        //dni no repes
        found = buscar(SingletonsUsu.u);
        if (found != -1) {
            JOptionPane.showMessageDialog(null, "El Dni ya existe, el Usuario no ha sido creado, porfavor revise los datos");
        } else {                       
            BLLBD_USU guardar = new BLLBD_USU();               
            SingletonsUsu.password = SingletonsUsu.u.getPassword();
            //StringEncrypter.encriptarTokenMD5(ArraylistEF.efi.getPassword());
            mail= guardar.nuevoUsu_BD();
            if (mail==1){
                DAOUSUgrafica.Eniviaremail();
            }
            

        }

    }
     
     public static void nombreUsuariografica() {
        DAOUSUgrafica.nombreUsugrafica();
    }
    
    public static void PoblacionUsugrafica() {
        DAOUSUgrafica.PoblacionUsugrafica();
    }

    public static void dniUsugrafica() {
        DAOUSUgrafica.dniUsu();
    }        

    public static void FechanaciUsuariografica() {
        DAOUSUgrafica.NaciUsugrafica();
    }
    
    public static void emailUsuariografica() {
        DAOUSUgrafica.email();
    }
    
    public static void passwordUsuariografica() {
        DAOUSUgrafica.password();
    }
    
    public static void loginUsuariografica() {
        DAOUSUgrafica.usuariologin();
    }
    
    public static void ModificaloginUsuariografica() {
        DAOUSUgrafica.modificaUsugrafica();
    }
    
    public static void ModificanombreUsuariografica() {
        DAOUSUgrafica.modificanombreUSUgrafica();
    }
    
    public static void ModificaPoblacionUsugrafica() {
        DAOUSUgrafica.modificapoblacionUSUgrafica();
    }
    
    public static void ModificaFechanaciUsuariografica() {
        DAOUSUgrafica.fnacUsumodificagrafica();
    }
    
    public static void ModificaemailUsuariografica() {
        DAOUSUgrafica.modificaemail();
    }
    
    public static void ModificapasswordUsuariografica() {
        DAOUSUgrafica.modificapassword();
    }    
    
   
    public static void BorrarcamposUsuarioCreagrafica() {
        
        if (SingletonsUsu.usulogin == null) {
            DAOUSUgrafica.borrarcamposcrea();
            creaUSU.dispose();
            new controlador_login(new Iniciologin(), 5).Iniciar(5);

        } else if ("User".equals(SingletonsUsu.usulogin.getTipo())) {

            DAOUSUgrafica.borrarcamposcrea();
            creaUSU.dispose();
            new controlador_login(new Iniciologin(), 5).Iniciar(5);

        } else {
            DAOUSUgrafica.borrarcamposcrea();
            creaUSU.dispose();
            new controladorUSU(new interfaceUSUgrafica(), 1).Iniciar(1);
        }
    }
        
    

    public static void borrarcamporUsuarioModifica() {
        
        if ("User".equals(SingletonsUsu.usulogin.getTipo())) {
            DAOUSUgrafica.borrarcamposModifica();
            modiUSU.dispose();
            new controlador_login(new Iniciologin(), 5).Iniciar(5);
        } else {

            DAOUSUgrafica.borrarcamposModifica();
            modiUSU.dispose();

            new controladorUSU(new interfaceUSUgrafica(), 1).Iniciar(1);
        }
    }
    
    public static void eliminaUsuariograficatabla() {
        Usuario usr = null;
        int inicio,
                selec1;
        if (TABLA.getModel().getRowCount() != 0) {
            int selec = TABLA.getSelectedRow();
            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selec1 = inicio + selec;
            if (selec1 == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione primero un Usuario");
            } else {
                String dniUsu = (String) TABLA.getModel().getValueAt(selec1, 0);
                SingletonsUsu.u = new Usuario(dniUsu);

                usr = DAOUSUgrafica.obtenerUsu(SingletonsUsu.u.getDni());

                //remove
                SingletonsUsu.usu.remove(SingletonsUsu.u);
                BLLBD_USU elimina = new BLLBD_USU();
                elimina.eliminarUsu();
                JOptionPane.showMessageDialog(null, "El Usuario a sido eliminado satisfactoriamente");

                //EFBLLgrafica.GuardarSinEnterarse(); 
                ((STMUSU) interfaceUSUgrafica.TABLA.getModel()).cargar();

            }
        }
    }
   
    
    
    public static void modificaUsuariograficallenacampos() {

        int inicio1, selec2;

        if (TABLA.getModel().getRowCount() != 0) {
            int selec = TABLA.getSelectedRow();
            inicio1 = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selec2 = inicio1 + selec;
            if (selec2 == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione primero un Empleado Fijo");
            } else {
                String dniusu = (String) TABLA.getModel().getValueAt(selec2, 0);                
                SingletonsUsu.usulog = new Usuario(dniusu);
                SingletonsUsu.u = DAOUSUgrafica.obtenerUsu(SingletonsUsu.usulog.getDni());
                DAOUSUgrafica.modificaUsugraficallenadodatos();
                FileUploader.pintaravatar(modiUSU.labelavatar, 90, 90);
            }
        }        
        //SingletonsUsu.u = DAOUSUgrafica.obtenerUsu(SingletonsUsu.usulog.getDni());

    }
   
    
    public static void masinfo() {

        int inicio1,
                selec2;

        if (TABLA.getModel().getRowCount() != 0) {
            int selec = TABLA.getSelectedRow();
            inicio1 = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selec2 = inicio1 + selec;
            if (selec2 == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione primero un Usuario");
            } else {
               String dni = (String) TABLA.getModel().getValueAt(selec2, 0); 
                //ArraylistEF.efi = new empleadofijo(dni);
                //SingletonsUsu.u = new Usuario(dni);                                                
                SingletonsUsu.usulogin = new Usuario(dni);
                SingletonsUsu.u = DAOUSUgrafica.obtenerUsu(SingletonsUsu.usulogin.getDni());
                JOptionPane.showMessageDialog(null, "La informacion completa del trabajador es" + SingletonsUsu.u.toString());
            }
        }
        
        //SingletonsUsu.u = DAOUSUgrafica.obtenerUsu(SingletonsUsu.u.getDni());
        //poner para imprimir la misma pantalla de modifica pero la llamaremos imprimir y le pondremos al controlador
        //que no muestre los botones de modifica ni modificar avata, solo el cancelar, asi podremos ver solo los datos
        //JOptionPane.showMessageDialog(null, "La informacion completa del trabajador es" + SingletonsUsu.u.toString());

    }
    
    
    
    public static void modificaUsugrafica() {               
        DAOUSUgrafica.modificaUsugrafica();        

        BLLBD_USU modi = new BLLBD_USU();        
        modi.modificarUsu_BD();
        ((STMUSU) interfaceUSUgrafica.TABLA.getModel()).cargar();

    }  
    
    
    
}
