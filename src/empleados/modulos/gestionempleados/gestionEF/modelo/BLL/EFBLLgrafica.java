/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.gestionempleados.gestionEF.modelo.BLL;

import empleados.clases.StringEncrypter;
import empleados.librerias.FileUploader;
import empleados.modulos.gestionempleados.clases.empleado;
import empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF;
import static empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF.creaEF;
import static empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF.modief;
import empleados.modulos.gestionempleados.gestionEF.modelo.DAO.DAOEFgrafica;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.ArraylistEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.STMEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;
import empleados.modulos.gestionempleados.gestionEF.modelo.pager.pagina1;
import empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica;
import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.TABLA;
import empleados.modulos.gestionempleados.gestionEF.vista.modificaEFgrafica;
import empleados.modulos.login.controlador_log.controlador_login;
import empleados.modulos.login.vista_log.Iniciologin;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author lluis
 */
public class EFBLLgrafica {

    public static void crearEFgrafica() {
        int found = 0;
        //empleadofijo efi=null;
        DAOEFgrafica.creaEFGrafica();

        //dni no repes
        found = buscar(ArraylistEF.efi);
        if (found != -1) {
            JOptionPane.showMessageDialog(null, "El DNI ya existe, el empleado no ha sido creado, porfavor revise los datos");
        } else {
            //ArraylistEF.ef.add(efi);

            BLLBD_EF guardar = new BLLBD_EF();
            ArraylistEF.password = ArraylistEF.efi.getPassword();
            //StringEncrypter.encriptarTokenMD5(ArraylistEF.efi.getPassword());
            guardar.nuevoEF_BD();
            DAOEFgrafica.Eniviaremail();
            ((STMEF) interfaceEFgrafica.TABLA.getModel()).cargar();
            //stm.cargar
            //EFBLLgrafica.GuardarSinEnterarse();

        }

    }

    public static int buscar(empleado ef) {//Buscar
        int aux = -1;

        for (int i = 0; i <= (ArraylistEF.ef.size() - 1); i++) {
            if ((ArraylistEF.ef.get(i)).equals(ef))//buclea hasta que encuentra un dni que sea igual con el comparator de la madre y lo devuelve como aux
            {
                aux = i;
            }
        }
        return aux;//devuelve aux, si lo ha encontrado dara la posicion, si no devolvera -1.
    }

    public static void nombreEFgrafica() {
        DAOEFgrafica.nombreEFgrafica();
    }

    public static void departamentoEFgrafica() {
        DAOEFgrafica.departamentoEFgrafica();
    }

    public static void dniEFgrafica() {
        DAOEFgrafica.dniEFgrafica();
    }

    public static void emailEFgrafica() {
        DAOEFgrafica.email();
    }

    public static void passwordEFgrafica() {
        DAOEFgrafica.password();
    }

    public static void UsuarioEFgrafica() {
        DAOEFgrafica.usuariologin();
    }

    public static void fnacEFgrafica() {
        DAOEFgrafica.fnacEFgrafica();
    }

    public static void fcontEfgrafica() {
        DAOEFgrafica.fcontEFgrafica();
    }

    public static void borrarcamporEFgrafica() {
        if (ArraylistEF.efilogin == null) {
            DAOEFgrafica.borrarcamposcrea();
            creaEF.dispose();
            new controlador_login(new Iniciologin(), 5).Iniciar(5);

        } else if ("User".equals(ArraylistEF.efilogin.getTipo())) {

            DAOEFgrafica.borrarcamposcrea();
            creaEF.dispose();
            new controlador_login(new Iniciologin(), 5).Iniciar(5);

        } else {
            DAOEFgrafica.borrarcamposcrea();
            creaEF.dispose();
            new controladorEF(new interfaceEFgrafica(), 1).Iniciar(1);
        }
    }

    public static void borrarcamporEFModifica() {
        if ("User".equals(ArraylistEF.efilogin.getTipo())) {
            DAOEFgrafica.borrarcamposModifica();
            modief.dispose();
            new controlador_login(new Iniciologin(), 5).Iniciar(5);
        } else {

            DAOEFgrafica.borrarcamposModifica();
            modief.dispose();

            new controladorEF(new interfaceEFgrafica(), 1).Iniciar(1);
        }
    }

    public static void eliminaEFgraficatabla() {
        empleadofijo ef1 = null;
        int inicio,
                selec1;
        if (TABLA.getModel().getRowCount() != 0) {
            int selec = TABLA.getSelectedRow();
            inicio = (pagina1.currentPageIndex - 1) * pagina1.itemsPerPage;
            selec1 = inicio + selec;
            if (selec1 == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione primero un Empleado Fijo");
            } else {
                String dni = (String) TABLA.getModel().getValueAt(selec1, 0);
                ArraylistEF.efi = new empleadofijo(dni);

                ef1 = DAOEFgrafica.obtenerEF(ArraylistEF.efi.getDni());

                //remove
                ArraylistEF.ef.remove(ef1);
                BLLBD_EF elimina = new BLLBD_EF();
                elimina.eliminarEF();
                JOptionPane.showMessageDialog(null, "El empleado a sido eliminado satisfactoriamente");

                //EFBLLgrafica.GuardarSinEnterarse(); 
                ((STMEF) interfaceEFgrafica.TABLA.getModel()).cargar();

            }
        }
    }

    public static void modificaEFgraficallenacampos() {

        int inicio1,
                selec2;

        if (TABLA.getModel().getRowCount() != 0) {
            int selec = TABLA.getSelectedRow();
            inicio1 = (pagina1.currentPageIndex - 1) * pagina1.itemsPerPage;
            selec2 = inicio1 + selec;
            if (selec2 == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione primero un Empleado Fijo");
            } else {
                String dni = (String) TABLA.getModel().getValueAt(selec2, 0);
                //ArraylistEF.efi = new empleadofijo(dni);
                ArraylistEF.efilog = new empleadofijo(dni);
                ArraylistEF.efi = DAOEFgrafica.obtenerEF(ArraylistEF.efilog.getDni());
                DAOEFgrafica.modificaEFgraficallenadodatos();
                FileUploader.pintaravatar(modief.labelavatar, 90, 90);
            }
        }
        //ArraylistEF.efi = DAOEFgrafica.obtenerEF(ArraylistEF.efi.getDni());

    }

    public static void masinfo() {

        int inicio1,
                selec2;

        if (TABLA.getModel().getRowCount() != 0) {
            int selec = TABLA.getSelectedRow();
            inicio1 = (pagina1.currentPageIndex - 1) * pagina1.itemsPerPage;
            selec2 = inicio1 + selec;
            if (selec2 == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione primero un Empleado Fijo");
            } else {
                String dni = (String) TABLA.getModel().getValueAt(selec2, 0);
                //ArraylistEF.efi = new empleadofijo(dni);
                ArraylistEF.efilogin = new empleadofijo(dni);
                ArraylistEF.efi = DAOEFgrafica.obtenerEF(ArraylistEF.efilogin.getDni());
                JOptionPane.showMessageDialog(null, "La informacion completa del trabajador es" + ArraylistEF.efi.toString());
            }
        }
        //ArraylistEF.efi = DAOEFgrafica.obtenerEF(ArraylistEF.efi.getDni());

    }

    public static void modificaEFgrafica() {

        //empleadofijo modificado = new empleadofijo();
        //modificado=DAOEFgrafica.obtenerEF(ArraylistEF.efi.getDni());
        if ("User".equals(ArraylistEF.efilogin.getTipo())) {
            DAOEFgrafica.modificaEFlogin();

        } else {
            DAOEFgrafica.modificaEFgrafica();

        }

        //JOptionPane.showMessageDialog(null, ArraylistEF.efi.toString());
        BLLBD_EF modi = new BLLBD_EF();
        //modificado=ArraylistEF.efi;
        modi.modificarEF_BD();

        //((STMEF) interfaceEFgrafica.TABLA.getModel()).cargar();

    }

    public static void AbrirSinEnterarse() {
        //ArraylistEF.ef=empleados.librerias.json.abrir_jsonOcultoEF();
        ArraylistEF.ef = empleados.librerias.txt.abrir_txtOcultoEF();
        ArraylistEF.ef = empleados.librerias.xml.abrir_xmlOcultoEF();
    }

}
