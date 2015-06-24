/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.Usuarios.gestionusuarios.modelo.DAO;

import com.toedter.calendar.JTextFieldDateEditor;
import empleados.clases.Mail;
import empleados.librerias.Encriptar;
import empleados.clases.fecha;
import static empleados.librerias.FileUploader.PATH_auto;
import empleados.librerias.validate;
import empleados.modulos.Usuarios.gestionusuarios.modelo.clase.Usuario;
import empleados.modulos.Usuarios.gestionusuarios.modelo.BLL.BLLUSUgrafica;
import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.SingletonsUsu;
import empleados.modulos.Usuarios.gestionusuarios.vista.CreaUsu;
import empleados.modulos.Usuarios.gestionusuarios.vista.PerfilUsu;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class DAOUSUgrafica {

    public static String nombreUsugrafica() {

        String nom = "";
        boolean valida;
        nom = CreaUsu.txtNombreEF.getText();

        if (nom.isEmpty()) {

            CreaUsu.txtNombreEF.setBackground(Color.red);
            CreaUsu.txtNombreEF.requestFocus();

        } else {

            valida = validate.validateNombre(nom);
            if (valida = false) {

                CreaUsu.txtNombreEF.setBackground(Color.red);
                CreaUsu.txtNombreEF.requestFocus();

            } else {
                CreaUsu.txtNombreEF.setBackground(Color.green);
            }

        }
        return nom;

    }

    public static String PoblacionUsugrafica() {
        String descrip = "";
        boolean valida;

        descrip = CreaUsu.txtDepartamentoEF.getText();
        if (descrip.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del Departamento esta vacio, porfavor introduzca un Departamento");
            CreaUsu.txtDepartamentoEF.setBackground(Color.red);
            CreaUsu.txtDepartamentoEF.requestFocus();

        } else {

            //deprt=CreaUsu.txtDescripcionProd.getText();
            CreaUsu.txtDepartamentoEF.setBackground(Color.green);
        }
        return descrip;
    }

    public static String dniUsu() {
        String id = "";
        boolean valida;

        id = CreaUsu.txtDNIEF.getText();

        if (id.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del DNI esta vacio, porfavor introduzca un DNI");
            CreaUsu.txtDNIEF.setBackground(Color.red);
            CreaUsu.txtDNIEF.requestFocus();

        } else {

            CreaUsu.txtDNIEF.setBackground(Color.red);
            CreaUsu.txtDNIEF.requestFocus();
            CreaUsu.txtDNIEF.setBackground(Color.green);
        }
        return id;
    }

    public static fecha NaciUsugrafica() {
        String fechaAlta = "";
        fecha nac = null;
        boolean valida;

        
        fechaAlta = ((JTextFieldDateEditor) CreaUsu.DatePikerEFNacEF.getDateEditor()).getText();
        nac = new fecha(fechaAlta);
        return nac;
    }

    public static String email() {
        String email = "";
        boolean valida;

        email = CreaUsu.txtemail.getText();

        if (email.isEmpty()) {
            
            CreaUsu.txtemail.setBackground(Color.red);
            CreaUsu.txtemail.requestFocus();

        } else {
            
            valida = validate.email(email);
            if (valida = false) {

                CreaUsu.txtemail.setBackground(Color.red);
                CreaUsu.txtlogin.requestFocus();

            }

            CreaUsu.txtemail.setBackground(Color.green);
        }
        return email;
    }

    public static String usuariologin() {
        String usu = "";
        boolean valida;

        usu = CreaUsu.txtlogin.getText();
        if (usu.isEmpty()) {
            
            CreaUsu.txtlogin.setBackground(Color.red);
            CreaUsu.txtlogin.requestFocus();

        } else {

            CreaUsu.txtlogin.setBackground(Color.green);
        }
        return usu;
    }

    public static String password() {
        String pass = "";
        boolean valida;

        pass = CreaUsu.txtpassword.getText();
        if (pass.isEmpty()) {
            
            CreaUsu.txtpassword.setBackground(Color.red);
            CreaUsu.txtpassword.requestFocus();

        } else {

            CreaUsu.txtpassword.setBackground(Color.green);
        }
        return pass;
    }

    public static void borrarcamposcrea() {
        CreaUsu.txtNombreEF.setText("");
        CreaUsu.txtDepartamentoEF.setText("");
        CreaUsu.DatePikerEFNacEF.setDate(null);
        CreaUsu.txtDNIEF.setText("");
        CreaUsu.txtemail.setText("");
        CreaUsu.txtlogin.setText("");
        CreaUsu.txtpassword.setText("");

        CreaUsu.txtNombreEF.requestFocus();

    }

    public static String modificanombreUSUgrafica() {
        String nom = "";
        boolean valida;

        nom = PerfilUsu.txtNombre.getText();

        if (nom.isEmpty()) {
            
            PerfilUsu.txtNombre.setBackground(Color.red);
            PerfilUsu.txtNombre.requestFocus();

        } else {

            
            valida = validate.validateNombre(nom);
            if (valida == false) {
                
                PerfilUsu.txtNombre.setBackground(Color.red);
                PerfilUsu.txtNombre.requestFocus();

            } else {
                PerfilUsu.txtNombre.setBackground(Color.green);
            }

        }
        return nom;

    }

    public static String modificapoblacionUSUgrafica() {
        String deprt = "";
        boolean valida;

        deprt = PerfilUsu.txtDepartamento.getText();
        if (deprt.isEmpty()) {
            
            PerfilUsu.txtDepartamento.setBackground(Color.red);
            PerfilUsu.txtDepartamento.requestFocus();

        } else {

            
            PerfilUsu.txtDepartamento.setBackground(Color.green);
        }
        return deprt;
    }

    public static String modificaemail() {
        String email = "";
        boolean valida;

        email = PerfilUsu.txtemail.getText();
        if (email.isEmpty()) {
            
            PerfilUsu.txtemail.setBackground(Color.red);
            PerfilUsu.txtemail.requestFocus();

        } else {

            valida = validate.email(email);
            if (valida == false) {

                PerfilUsu.txtemail.setBackground(Color.red);
                PerfilUsu.txtemail.requestFocus();

            } else {
                PerfilUsu.txtemail.setBackground(Color.green);
            }
        }
        return email;
    }

    public static String modificausuariologin() {
        String usu = "";
        boolean valida;

        usu = PerfilUsu.txtlogin.getText();
        if (usu.isEmpty()) {
            
            PerfilUsu.txtlogin.setBackground(Color.red);
            PerfilUsu.txtlogin.requestFocus();

        } else {

            PerfilUsu.txtlogin.setBackground(Color.green);
        }
        return usu;
    }

    public static String modificapassword() {
        String pass = "";
        boolean valida;

        pass = PerfilUsu.txtpassword.getText();
        if (pass.isEmpty()) {
            
            PerfilUsu.txtpassword.setBackground(Color.red);
            PerfilUsu.txtpassword.requestFocus();

        } else {

            PerfilUsu.txtpassword.setBackground(Color.green);
            pass = Encriptar.encriptarTokenMD5(pass);
        }
        return pass;
    }

    public static fecha fnacUsumodificagrafica() {
        String fechaNacimiento = "";
        fecha nac = null;
        boolean valida;

        
        fechaNacimiento = ((JTextFieldDateEditor) PerfilUsu.DatePiketEFnac.getDateEditor()).getText();
        nac = new fecha(fechaNacimiento);
        return nac;
    }

    
    public static void borrarcamposModifica() {
        PerfilUsu.txtNombre.setText("");
        PerfilUsu.txtDepartamento.setText("");
        PerfilUsu.DatePiketEFnac.setDate(null);
        //PerfilUsu.DatePikerEFCont.setDate(null);
        PerfilUsu.txtemail.setText("");
        PerfilUsu.txtlogin.setText("");
        PerfilUsu.txtpassword.setText("");
        PerfilUsu.txtNombre.requestFocus();
    }

    public static void borrarcamposcreaUsu() {
        CreaUsu.txtNombreEF.setText("");
        CreaUsu.txtDepartamentoEF.setText("");
        CreaUsu.DatePikerEFNacEF.setDate(null);        
        CreaUsu.txtDNIEF.setText("");
        CreaUsu.txtemail.setText("");
        CreaUsu.txtlogin.setText("");
        CreaUsu.txtpassword.setText("");
        CreaUsu.txtNombreEF.requestFocus();

    }

    public static Usuario obtenerUsu(String dni) {

        int pos = 0;
        Usuario ef1 = null;

        ef1 = new Usuario(dni);
        pos = BLLUSUgrafica.buscar(ef1);
        ef1 = SingletonsUsu.usu.get(pos);
        return ef1;
    }

    public static void modificaUsugraficallenadodatos() {

        
        PerfilUsu.txtNombre.setText(SingletonsUsu.u.getNombre());
        PerfilUsu.txtDepartamento.setText(SingletonsUsu.u.getDepartamento());        
        PerfilUsu.txtedad.setText(Integer.toString(SingletonsUsu.u.getEdad()));        
        ((JTextFieldDateEditor) PerfilUsu.DatePiketEFnac.getDateEditor()).setText(SingletonsUsu.u.getFechaNacimiento().toString());        
        PerfilUsu.txtemail.setText(SingletonsUsu.u.getEmail());
        PerfilUsu.txtlogin.setText(SingletonsUsu.u.getLogin());
        PerfilUsu.txtpassword.setText("");

    }
    
    public static void modificaUsugraficallenadodatosPerfil() {

        
        PerfilUsu.txtNombre.setText(SingletonsUsu.usulogin.getNombre());
        PerfilUsu.txtDepartamento.setText(SingletonsUsu.usulogin.getDepartamento());        
        PerfilUsu.txtedad.setText(Integer.toString(SingletonsUsu.usulogin.getEdad()));        
        ((JTextFieldDateEditor) PerfilUsu.DatePiketEFnac.getDateEditor()).setText(SingletonsUsu.usulogin.getFechaNacimiento().toString());        
        PerfilUsu.txtemail.setText(SingletonsUsu.usulogin.getEmail());
        PerfilUsu.txtlogin.setText(SingletonsUsu.usulogin.getLogin());
        PerfilUsu.txtpassword.setText("");

    }

    public static Usuario creaUsuGrafica() {
        Usuario ef1 = null;
        //nombre
        String nom;
        String tipo = "";
        int validar, valida;

        nom = nombreUsugrafica();

        //departamento
        String pobl;
        pobl = PoblacionUsugrafica();

        //DNI
        String dni;
        dni = dniUsu();

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
        naci = NaciUsugrafica();

        if (nom.isEmpty() || dni.isEmpty() || pobl.isEmpty() || usuario.isEmpty() || Password.isEmpty() || email.isEmpty() || naci == null) {
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
        } else {

            //miramos la diferencia entre la fecha de nacimiento y la actual
            valida = naci.calcularedad();

            if (valida < 16) {
                CreaUsu.DatePikerEFNacEF.setBackground(Color.RED);
                CreaUsu.DatePikerEFNacEF.requestFocus();
                JOptionPane.showMessageDialog(null, "No puede registrar a un menor de 16 años");
            } else {

                if (CreaUsu.Usuario.isSelected()) {
                    tipo = "User";
                } else if (CreaUsu.Admin.isSelected()) {
                    tipo = "admin";
                }

        //validamos
                
                SingletonsUsu.u = new Usuario(nom, dni, pobl, naci, usuario, Password, email, tipo, avatar);

                
                JOptionPane.showMessageDialog(null, "Se ha creado correctamente");

                CreaUsu.txtNombreEF.setText("");
                CreaUsu.txtDepartamentoEF.setText("");
                CreaUsu.DatePikerEFNacEF.setDate(null);
                CreaUsu.txtDNIEF.setText("");
                CreaUsu.txtemail.setText("");
                CreaUsu.txtlogin.setText("");
                CreaUsu.txtpassword.setText("");
                CreaUsu.txtNombreEF.requestFocus();

                CreaUsu.txtNombreEF.setBackground(Color.WHITE);
                CreaUsu.txtNombreEF.setBackground(Color.WHITE);
                CreaUsu.txtDNIEF.setBackground(Color.WHITE);
                CreaUsu.DatePikerEFNacEF.setBackground(Color.WHITE);
                CreaUsu.txtemail.setBackground(Color.WHITE);
                CreaUsu.txtlogin.setBackground(Color.WHITE);
                CreaUsu.txtpassword.setBackground(Color.WHITE);
            }

        }
        return SingletonsUsu.u;

        
    }

    public static void modificaUsugrafica() {
        
        fecha mnac, mcont;
        String mnom, mdeprt, mlog, mpass, mmail;
        mnac = fnacUsumodificagrafica();
        //mcont=fcontEFmodificagrafica();
        mnom = modificanombreUSUgrafica();
        mdeprt = modificapoblacionUSUgrafica();
        mlog = modificausuariologin();
        mpass = modificapassword();
        mmail = modificaemail();
        if (mnac == null || mnom.isEmpty() || mdeprt.isEmpty() || mlog.isEmpty() || mpass.isEmpty() || mmail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");

        } else {
            SingletonsUsu.usulogin.setNombre(modificanombreUSUgrafica());
            SingletonsUsu.usulogin.setDepartamento(modificapoblacionUSUgrafica());
            SingletonsUsu.usulogin.setFechaNacimiento(fnacUsumodificagrafica());
        
            SingletonsUsu.usulogin.setLogin(modificausuariologin());
            SingletonsUsu.usulogin.setPassword(modificapassword());
            SingletonsUsu.usulogin.setEmail(modificaemail());

            JOptionPane.showMessageDialog(null, "El Empleado ha sido modificado satisfactoriamente");

            borrarcamposModifica();
            PerfilUsu.txtNombre.setBackground(Color.WHITE);
            PerfilUsu.txtDepartamento.setBackground(Color.WHITE);            
            PerfilUsu.txtedad.setBackground(Color.WHITE);
            PerfilUsu.DatePiketEFnac.setBackground(Color.WHITE);            
            PerfilUsu.txtemail.setBackground(Color.WHITE);
            PerfilUsu.txtlogin.setBackground(Color.WHITE);
            PerfilUsu.txtpassword.setBackground(Color.WHITE);
        }
    }
    
    public static void modificaUsugraficalogin() {
        
        fecha mnac, mcont;
        String mnom, mdeprt, mlog, mpass, mmail;
        mnac = fnacUsumodificagrafica();
        //mcont=fcontEFmodificagrafica();
        mnom = modificanombreUSUgrafica();
        mdeprt = modificapoblacionUSUgrafica();
        mlog = modificausuariologin();
        mpass = modificapassword();
        mmail = modificaemail();
        if (mnac == null || mnom.isEmpty() || mdeprt.isEmpty() || mlog.isEmpty() || mpass.isEmpty() || mmail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");

        } else {
            SingletonsUsu.u.setNombre(modificanombreUSUgrafica());
            SingletonsUsu.u.setDepartamento(modificapoblacionUSUgrafica());
            SingletonsUsu.u.setFechaNacimiento(fnacUsumodificagrafica());
        
            SingletonsUsu.u.setLogin(modificausuariologin());
            SingletonsUsu.u.setPassword(modificapassword());
            SingletonsUsu.u.setEmail(modificaemail());

            JOptionPane.showMessageDialog(null, "El Empleado ha sido modificado satisfactoriamente");

            borrarcamposModifica();
            PerfilUsu.txtNombre.setBackground(Color.WHITE);
            PerfilUsu.txtDepartamento.setBackground(Color.WHITE);            
            PerfilUsu.txtedad.setBackground(Color.WHITE);
            PerfilUsu.DatePiketEFnac.setBackground(Color.WHITE);            
            PerfilUsu.txtemail.setBackground(Color.WHITE);
            PerfilUsu.txtlogin.setBackground(Color.WHITE);
            PerfilUsu.txtpassword.setBackground(Color.WHITE);
        }
    }
    
    

    public static void Eniviaremail() {

        //JOptionPane.showMessageDialog(null, "Envio Correcto, sus datos son: " + "Email: " + SingletonsUsu.u.getEmail() + "Password: " + SingletonsUsu.password.toString(), "Correcto", JOptionPane.INFORMATION_MESSAGE);
        //creamos el objeto Mail
        Mail mail = new Mail(SingletonsUsu.u.getEmail(), SingletonsUsu.password.toString());

         //enviamos el mensaje
         String error = mail.send();

         if (error.equals("")) {
         JOptionPane.showMessageDialog(null, "Envio Correcto", "Correcto", JOptionPane.INFORMATION_MESSAGE);
         } else {
         JOptionPane.showMessageDialog(null, "Error de envio:\n" + error, "Error", JOptionPane.ERROR_MESSAGE);
         }
    }
    

}
