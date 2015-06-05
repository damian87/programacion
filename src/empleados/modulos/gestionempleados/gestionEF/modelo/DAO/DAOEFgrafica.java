/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.gestionempleados.gestionEF.modelo.DAO;

//import com.toedter.calendar.JTextFieldDateEditor;
import com.toedter.calendar.JTextFieldDateEditor;
import empleados.clases.fecha;
import empleados.clases.Mail;
import empleados.clases.StringEncrypter;
import static empleados.librerias.FileUploader.PATH_auto;
import empleados.librerias.validate;
import empleados.modulos.gestionempleados.gestionEF.modelo.BLL.EFBLLgrafica;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.ArraylistEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;
import empleados.modulos.gestionempleados.gestionEF.vista.creaEFgrafica;
import empleados.modulos.gestionempleados.gestionEF.vista.modificaEFgrafica;
import empleados.menuempleados;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.STMEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.pager.pagina1;
import static empleados.modulos.gestionempleados.gestionEF.vista.creaEFgrafica.txtDNIEF;
import static empleados.modulos.gestionempleados.gestionEF.vista.creaEFgrafica.txtNombreEF;
//import empleados.modulos.gestionempleados.gestionEF.vista.eliminaEFgrafica;
import empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica;
import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.TABLA;
import java.awt.Color;
import java.util.Collections;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author lluis
 */
public class DAOEFgrafica {

    public static String nombreEFgrafica() {

        String nom = "";
        boolean valida;

        nom = creaEFgrafica.txtNombreEF.getText();

        if (nom.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del Nombre esta vacio, porfavor introduzca un Nombre");
            creaEFgrafica.txtNombreEF.setBackground(Color.red);
            creaEFgrafica.txtNombreEF.requestFocus();

        } else {

            //nom=creaEFgrafica.txtNombreEF.getText();
            valida = validate.validateNombre(nom);
            if (valida = false) {
                //JOptionPane.showMessageDialog(null, "Introduzca un Nombre valido");
                creaEFgrafica.txtNombreEF.setBackground(Color.red);
                creaEFgrafica.txtNombreEF.requestFocus();

            } else {
                creaEFgrafica.txtNombreEF.setBackground(Color.green);
            }

        }
        return nom;

    }

    public static String modificanombreEFgrafica() {
        String nom = "";
        boolean valida;

        nom = modificaEFgrafica.txtNombre.getText();

        if (nom.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del Nombre esta vacio, porfavor introduzca un Nombre");
            modificaEFgrafica.txtNombre.setBackground(Color.red);
            modificaEFgrafica.txtNombre.requestFocus();

        } else {

            //nom=modificaEFgrafica.txtNombre.getText();
            valida = validate.validateNombre(nom);
            if (valida == false) {
                //JOptionPane.showMessageDialog(null, "Introduzca un Nombre valido");
                modificaEFgrafica.txtNombre.setBackground(Color.red);
                modificaEFgrafica.txtNombre.requestFocus();

            } else {
                modificaEFgrafica.txtNombre.setBackground(Color.green);
            }

        }
        return nom;

    }

    public static String departamentoEFgrafica() {
        String deprt = "";
        boolean valida;

        deprt = creaEFgrafica.txtDepartamentoEF.getText();
        if (deprt.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del Departamento esta vacio, porfavor introduzca un Departamento");
            creaEFgrafica.txtDepartamentoEF.setBackground(Color.red);
            creaEFgrafica.txtDepartamentoEF.requestFocus();

        } else {

            //deprt=creaEFgrafica.txtDepartamentoEF.getText();
            creaEFgrafica.txtDepartamentoEF.setBackground(Color.green);
        }
        return deprt;
    }

    public static String modificadepartamentoEFgrafica() {
        String deprt = "";
        boolean valida;

        deprt = modificaEFgrafica.txtDepartamento.getText();
        if (deprt.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del Departamento esta vacio, porfavor introduzca un Departamento");
            modificaEFgrafica.txtDepartamento.setBackground(Color.red);
            modificaEFgrafica.txtDepartamento.requestFocus();

        } else {

            //deprt=modificaEFgrafica.txtDepartamento.getText();
            modificaEFgrafica.txtDepartamento.setBackground(Color.green);
        }
        return deprt;
    }

    public static String dniEFgrafica() {
        String dni = "";
        boolean valida;

        dni = creaEFgrafica.txtDNIEF.getText();

        if (dni.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del DNI esta vacio, porfavor introduzca un DNI");
            creaEFgrafica.txtDNIEF.setBackground(Color.red);
            creaEFgrafica.txtDNIEF.requestFocus();

        } else {
            //dni=creaEFgrafica.txtDNIEF.getText();
            //valida=validate.validateNombre(dni);
            //valida = validate.validaDNI(dni);
            //if (valida = false) {
                //JOptionPane.showMessageDialog(null, "Introduzca un DNI valido");
                creaEFgrafica.txtDNIEF.setBackground(Color.red);
                creaEFgrafica.txtDNIEF.requestFocus();

            //}

            creaEFgrafica.txtDNIEF.setBackground(Color.green);
        }
        return dni;
    }

    public static String email() {
        String email = "";
        boolean valida;

        email = creaEFgrafica.txtemail.getText();

        if (email.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del email esta vacio, porfavor introduzca un DNI");
            creaEFgrafica.txtemail.setBackground(Color.red);
            creaEFgrafica.txtemail.requestFocus();

        } else {
            //dni=creaEFgrafica.txtDNIEF.getText();
            //valida=validate.validateNombre(dni);
            valida = validate.email(email);
            if (valida = false) {

                creaEFgrafica.txtemail.setBackground(Color.red);
                creaEFgrafica.txtlogin.requestFocus();

            }else{
                creaEFgrafica.txtemail.setBackground(Color.green);
            }

            
        }
        return email;
    }

    public static String modificaemail() {
        String email = "";
        boolean valida;

        email = modificaEFgrafica.txtemail.getText();
        if (email.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del email esta vacio, porfavor introduzca un email");
            modificaEFgrafica.txtemail.setBackground(Color.red);
            modificaEFgrafica.txtemail.requestFocus();

        } else {

            valida = validate.email(email);
            if (valida == false) {

                modificaEFgrafica.txtemail.setBackground(Color.red);
                modificaEFgrafica.txtemail.requestFocus();

            } else {
                modificaEFgrafica.txtemail.setBackground(Color.green);
            }
        }
        return email;
    }

    //usuario
    public static String usuariologin() {
        String usu = "";
        boolean valida;

        usu = creaEFgrafica.txtlogin.getText();
        if (usu.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del Login/Usuario esta vacio, porfavor introduzca un Login/Usuario");
            creaEFgrafica.txtlogin.setBackground(Color.red);
            creaEFgrafica.txtlogin.requestFocus();

        } else {

            creaEFgrafica.txtlogin.setBackground(Color.green);
        }
        return usu;
    }

    public static String modificausuariologin() {
        String usu = "";
        boolean valida;

        usu = modificaEFgrafica.txtlogin.getText();
        if (usu.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del Login/Usuario esta vacio, porfavor introduzca un Login/Usuario");
            modificaEFgrafica.txtlogin.setBackground(Color.red);
            modificaEFgrafica.txtlogin.requestFocus();

        } else {

            modificaEFgrafica.txtlogin.setBackground(Color.green);
        }
        return usu;
    }

    //password
    public static String password() {
        String pass = "";
        boolean valida;

        pass = creaEFgrafica.txtpassword.getText();
        if (pass.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del Password esta vacio, porfavor introduzca un Password");
            creaEFgrafica.txtpassword.setBackground(Color.red);
            creaEFgrafica.txtpassword.requestFocus();

        } else {

            creaEFgrafica.txtpassword.setBackground(Color.green);
        }
        return pass;
    }

    public static String modificapassword() {
        String pass = "";
        boolean valida;

        pass = modificaEFgrafica.txtpassword.getText();
        if (pass.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del Password esta vacio, porfavor introduzca un Password");
            modificaEFgrafica.txtpassword.setBackground(Color.red);
            modificaEFgrafica.txtpassword.requestFocus();

        } else {

            modificaEFgrafica.txtpassword.setBackground(Color.green);
            pass = StringEncrypter.encriptarTokenMD5(pass);
        }
        return pass;
    }

    public static fecha fnacEFgrafica() {
        String fechaNacimiento = "";
        fecha nac = null;
        boolean valida;

        //fechaNacimiento = ((JTextFieldDateEditor) creaEFgrafica.DatePikerFNacEF.getDateEditor()).getText();
        fechaNacimiento = ((JTextFieldDateEditor) creaEFgrafica.DatePikerEFNacEF.getDateEditor()).getText();
        nac = new fecha(fechaNacimiento);
        return nac;
    }

    public static fecha fnacEFmodificagrafica() {
        String fechaNacimiento = "";
        fecha nac = null;
        boolean valida;

        //fechaNacimiento = ((JTextFieldDateEditor) creaEFgrafica.DatePikerFNacEF.getDateEditor()).getText();
        fechaNacimiento = ((JTextFieldDateEditor) modificaEFgrafica.DatePiketEFnac.getDateEditor()).getText();
        nac = new fecha(fechaNacimiento);
        return nac;
    }

    public static fecha fcontEFgrafica() {
        String fechaContratacion = "";

        fecha cont = null;
        //fechaContratacion = ((JTextFieldDateEditor) creaEFgrafica.DatePikerFContEF.getDateEditor()).getText();
        fechaContratacion = ((JTextFieldDateEditor) creaEFgrafica.DatePikerEFContEF.getDateEditor()).getText();
        cont = new fecha(fechaContratacion);
        return cont;
    }

    public static fecha fcontEFmodificagrafica() {
        String fechaContratacion = "";

        fecha cont = null;
        //fechaContratacion = ((JTextFieldDateEditor) creaEFgrafica.DatePikerFContEF.getDateEditor()).getText();
        fechaContratacion = ((JTextFieldDateEditor) modificaEFgrafica.DatePikerEFCont.getDateEditor()).getText();
        cont = new fecha(fechaContratacion);
        return cont;
    }

    public static void borrarcamposcrea() {
        creaEFgrafica.txtNombreEF.setText("");
        creaEFgrafica.txtDepartamentoEF.setText("");
        creaEFgrafica.DatePikerEFNacEF.setDate(null);
        creaEFgrafica.DatePikerEFContEF.setDate(null);
        creaEFgrafica.txtDNIEF.setText("");
        creaEFgrafica.txtemail.setText("");
        creaEFgrafica.txtlogin.setText("");
        creaEFgrafica.txtpassword.setText("");
        creaEFgrafica.txtNombreEF.requestFocus();

    }

    public static void borrarcamposModifica() {
        modificaEFgrafica.txtNombre.setText("");
        modificaEFgrafica.txtDepartamento.setText("");
        modificaEFgrafica.DatePiketEFnac.setDate(null);
        modificaEFgrafica.DatePikerEFCont.setDate(null);
        modificaEFgrafica.txtemail.setText("");
        modificaEFgrafica.txtlogin.setText("");
        modificaEFgrafica.txtpassword.setText("");
        modificaEFgrafica.txtNombre.requestFocus();
    }

    public static empleadofijo creaEFGrafica() {
        empleadofijo ef1 = null;
        //nombre
        String nom;
        String tipo = "";
        int validar, valida;

        nom = nombreEFgrafica();

        //departamento
        String deprt;
        deprt = departamentoEFgrafica();

        //DNI
        String dni;
        dni = dniEFgrafica();

        //eamil
        String email;
        email = email();

        //avatar
        String avatar;
        avatar = PATH_auto;

        //usuariologin
        String usuario;
        usuario = usuariologin();

        //password
        String Password;
        Password = password();

        //validar fnac
        fecha naci = null;
        naci = fnacEFgrafica();

        //validar fcont
        fecha contr = null;

        contr = fcontEFgrafica();
        if (nom.isEmpty() || dni.isEmpty() || deprt.isEmpty() || usuario.isEmpty() || Password.isEmpty() || email.isEmpty() || naci == null || contr == null) {
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
        } else {
            //comparamos fechas
            validar = contr.compfechas(naci);

            if (validar == 1) {
                creaEFgrafica.DatePikerEFNacEF.setBackground(Color.GREEN);
                creaEFgrafica.DatePikerEFContEF.setBackground(Color.GREEN);
                creaEFgrafica.CrearEF.requestFocus();
            } else if (validar == 0) {
                creaEFgrafica.DatePikerEFNacEF.setBackground(Color.RED);
                creaEFgrafica.DatePikerEFContEF.setBackground(Color.RED);
                creaEFgrafica.DatePikerEFNacEF.requestFocus();
                JOptionPane.showMessageDialog(null, "La fecha de contratacion debe ser superior a la de nacimiento");
            } else if (validar == -1) {
                creaEFgrafica.DatePikerEFNacEF.setBackground(Color.RED);
                creaEFgrafica.DatePikerEFContEF.setBackground(Color.RED);
                creaEFgrafica.DatePikerEFNacEF.requestFocus();
                JOptionPane.showMessageDialog(null, "La fecha de contratacion debe ser superior a la de nacimiento");
            }

            //miramos la diferencia entre la fecha de nacimiento y la actual
            valida = naci.calcularedad();

            if (valida < 16) {
                creaEFgrafica.DatePikerEFNacEF.setBackground(Color.RED);
                creaEFgrafica.DatePikerEFContEF.setBackground(Color.RED);
                creaEFgrafica.DatePikerEFNacEF.requestFocus();
                JOptionPane.showMessageDialog(null, "No puede contratar a un menor de 16 años");
            }

            if (creaEFgrafica.Usuario.isSelected()) {
                tipo = "User";
            } else if (creaEFgrafica.Admin.isSelected()) {
                tipo = "admin";
            }
            //JOptionPane.showMessageDialog(null, "DAOEFgrafica linea 427, avatar: " + avatar + " tipo: " + tipo);
        //validamos
            //ef1 = new empleadofijo(nom, dni, deprt, naci, contr, "", "", "");

            ArraylistEF.efi = new empleadofijo(nom, dni, deprt, naci, contr, usuario, Password, email, tipo, avatar);
            //String nombre,  String dni, String departamento, fecha fechaNacimiento, fecha fechaContratacion, String login, String password, String email

            creaEFgrafica.txtNombreEF.setText("");
            creaEFgrafica.txtDepartamentoEF.setText("");
            creaEFgrafica.DatePikerEFNacEF.setDate(null);
            creaEFgrafica.DatePikerEFContEF.setDate(null);
            creaEFgrafica.txtDNIEF.setText("");
            creaEFgrafica.txtemail.setText("");
            creaEFgrafica.txtlogin.setText("");
            creaEFgrafica.txtpassword.setText("");
            creaEFgrafica.txtNombreEF.requestFocus();

            creaEFgrafica.txtNombreEF.setBackground(Color.WHITE);
            creaEFgrafica.txtDepartamentoEF.setBackground(Color.WHITE);
            creaEFgrafica.txtDNIEF.setBackground(Color.WHITE);
            creaEFgrafica.DatePikerEFNacEF.setBackground(Color.WHITE);
            creaEFgrafica.DatePikerEFContEF.setBackground(Color.WHITE);
            creaEFgrafica.txtemail.setBackground(Color.WHITE);
            creaEFgrafica.txtlogin.setBackground(Color.WHITE);
            creaEFgrafica.txtpassword.setBackground(Color.WHITE);

        }
        return ArraylistEF.efi;

        //return ef1;
    }

    public static empleadofijo obtenerEF(String dni) {

        int pos = 0;
        empleadofijo ef1 = null;

        ef1 = new empleadofijo(dni);
        pos = EFBLLgrafica.buscar(ef1);
        ef1 = ArraylistEF.ef.get(pos);
        return ef1;
    }

    public static void modificaEFgraficallenadodatos() {

        //String nombre, departamento;
        //int pos = 0;
        //fecha fnac = null, fcont = null;
        modificaEFgrafica.txtNombre.setText(ArraylistEF.efi.getNombre());
        modificaEFgrafica.txtDepartamento.setText(ArraylistEF.efi.getDepartamento());
        modificaEFgrafica.txtantiguedad.setText(Integer.toString(ArraylistEF.efi.cambiarAntiguedad()));
        modificaEFgrafica.txtedad.setText(Integer.toString(ArraylistEF.efi.getEdad()));
        modificaEFgrafica.txtsueldo.setText(Float.toString(ArraylistEF.efi.calcularsueldo()));
        ((JTextFieldDateEditor) modificaEFgrafica.DatePiketEFnac.getDateEditor()).setText(ArraylistEF.efi.getFechaNacimiento().toString());
        ((JTextFieldDateEditor) modificaEFgrafica.DatePikerEFCont.getDateEditor()).setText(ArraylistEF.efi.getFechaContratacion().toString());
        modificaEFgrafica.txtemail.setText(ArraylistEF.efi.getEmail());
        modificaEFgrafica.txtlogin.setText(ArraylistEF.efi.getLogin());
        modificaEFgrafica.txtpassword.setText("");

    }

    public static void modificaEFgraficallenadodatosPerfil() {

        //String nombre, departamento;
        //int pos = 0;
        //fecha fnac = null, fcont = null;
        modificaEFgrafica.txtNombre.setText(ArraylistEF.efilogin.getNombre());
        modificaEFgrafica.txtDepartamento.setText(ArraylistEF.efilogin.getDepartamento());
        modificaEFgrafica.txtantiguedad.setText(Integer.toString(ArraylistEF.efilogin.cambiarAntiguedad()));
        modificaEFgrafica.txtedad.setText(Integer.toString(ArraylistEF.efilogin.getEdad()));
        modificaEFgrafica.txtsueldo.setText(Float.toString(ArraylistEF.efilogin.calcularsueldo()));
        ((JTextFieldDateEditor) modificaEFgrafica.DatePiketEFnac.getDateEditor()).setText(ArraylistEF.efilogin.getFechaNacimiento().toString());
        ((JTextFieldDateEditor) modificaEFgrafica.DatePikerEFCont.getDateEditor()).setText(ArraylistEF.efilogin.getFechaContratacion().toString());
        modificaEFgrafica.txtemail.setText(ArraylistEF.efilogin.getEmail());
        modificaEFgrafica.txtlogin.setText(ArraylistEF.efilogin.getLogin());
        modificaEFgrafica.txtpassword.setText("");

    }

    public static void modificaEFgrafica() {
        //empleadofijo ef2=null;
        //ef1 = new empleadofijo(nom, dni, deprt, naci, contr, "", "", "");
        //nombre=?,edad=?,departamento=?,fechaNacimiento=?,suelo=?,password=?,email=?,avatar=?,tipo=?,"
        //          + "estado=?,antiguedad=?,fechaContratacion=?
        fecha mnac, mcont;
        String mnom, mdeprt, mlog, mpass, mmail;
        mnac = fnacEFmodificagrafica();
        mcont = fcontEFmodificagrafica();
        mnom = modificanombreEFgrafica();
        mdeprt = modificadepartamentoEFgrafica();
        mlog = modificausuariologin();
        mpass = modificapassword();
        mmail = modificaemail();
        if (mnac == null || mcont == null || mnom.isEmpty() || mdeprt.isEmpty() || mlog.isEmpty() || mpass.isEmpty() || mmail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");

        } else {
            ArraylistEF.efi.setNombre(modificanombreEFgrafica());
            ArraylistEF.efi.setDepartamento(modificadepartamentoEFgrafica());
            ArraylistEF.efi.setFechaNacimiento(fnacEFmodificagrafica());
            ArraylistEF.efi.setFechaContratacion(fcontEFmodificagrafica());
            //ArraylistEF.efi.setSueldo(ArraylistEF.efi.calcularsueldo());
            ArraylistEF.efi.setLogin(modificausuariologin());
            ArraylistEF.efi.setPassword(modificapassword());
            ArraylistEF.efi.setEmail(modificaemail());
            ArraylistEF.efilogin.setAvatar(PATH_auto);

            JOptionPane.showMessageDialog(null, "El Empleado ha sido modificado satisfactoriamente");

            borrarcamposModifica();
            modificaEFgrafica.txtNombre.setBackground(Color.WHITE);
            modificaEFgrafica.txtDepartamento.setBackground(Color.WHITE);
            modificaEFgrafica.txtantiguedad.setBackground(Color.WHITE);
            modificaEFgrafica.txtedad.setBackground(Color.WHITE);
            modificaEFgrafica.DatePiketEFnac.setBackground(Color.WHITE);
            modificaEFgrafica.DatePikerEFCont.setBackground(Color.WHITE);
            modificaEFgrafica.txtemail.setBackground(Color.WHITE);
            modificaEFgrafica.txtlogin.setBackground(Color.WHITE);
            modificaEFgrafica.txtpassword.setBackground(Color.WHITE);
        }
    }

    public static void modificaEFlogin() {
        //empleadofijo ef2=null;
        //ef1 = new empleadofijo(nom, dni, deprt, naci, contr, "", "", "");
        //nombre=?,edad=?,departamento=?,fechaNacimiento=?,suelo=?,password=?,email=?,avatar=?,tipo=?,"
        //          + "estado=?,antiguedad=?,fechaContratacion=?
        fecha mnac, mcont;
        String mnom, mdeprt, mlog, mpass, mmail;
        mnac = fnacEFmodificagrafica();
        mcont = fcontEFmodificagrafica();
        mnom = modificanombreEFgrafica();
        mdeprt = modificadepartamentoEFgrafica();
        mlog = modificausuariologin();
        mpass = modificapassword();
        mmail = modificaemail();
        if (mnac == null || mcont == null || mnom.isEmpty() || mdeprt.isEmpty() || mlog.isEmpty() || mpass.isEmpty() || mmail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");

        } else {
            ArraylistEF.efilogin.setNombre(modificanombreEFgrafica());
            ArraylistEF.efilogin.setDepartamento(modificadepartamentoEFgrafica());
            ArraylistEF.efilogin.setFechaNacimiento(fnacEFmodificagrafica());
            ArraylistEF.efilogin.setFechaContratacion(fcontEFmodificagrafica());
            //ArraylistEF.efilogin.setSueldo(ArraylistEF.efilogin.calcularsueldo());
            ArraylistEF.efilogin.setLogin(modificausuariologin());
            ArraylistEF.efilogin.setPassword(modificapassword());
            ArraylistEF.efilogin.setEmail(modificaemail());
            ArraylistEF.efilogin.setAvatar(PATH_auto);

            JOptionPane.showMessageDialog(null, "El Empleado ha sido modificado satisfactoriamente");

            borrarcamposModifica();
            modificaEFgrafica.txtNombre.setBackground(Color.WHITE);
            modificaEFgrafica.txtDepartamento.setBackground(Color.WHITE);
            modificaEFgrafica.txtantiguedad.setBackground(Color.WHITE);
            modificaEFgrafica.txtedad.setBackground(Color.WHITE);
            modificaEFgrafica.DatePiketEFnac.setBackground(Color.WHITE);
            modificaEFgrafica.DatePikerEFCont.setBackground(Color.WHITE);
            modificaEFgrafica.txtemail.setBackground(Color.WHITE);
            modificaEFgrafica.txtlogin.setBackground(Color.WHITE);
            modificaEFgrafica.txtpassword.setBackground(Color.WHITE);
        }
    }

    public static void Eniviaremail() {

        JOptionPane.showMessageDialog(null, "Envio Correcto, sus datos son: " + "Email: " + ArraylistEF.efi.getEmail() + "Password: " + ArraylistEF.password.toString(), "Correcto", JOptionPane.INFORMATION_MESSAGE);
        //creamos el objeto Mail
        /*Mail mail = new Mail(ArraylistEF.efi.getEmail(), ArraylistEF.password.toString());

         //enviamos el mensaje
         String error = mail.send();

         if (error.equals("")) {
         JOptionPane.showMessageDialog(null, "Envio Correcto", "Correcto", JOptionPane.INFORMATION_MESSAGE);
         } else {
         JOptionPane.showMessageDialog(null, "Error de envio:\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
         }*/
    }
}
