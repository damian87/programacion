/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.Usuarios.gestionusuarios.modelo.DAO;

import com.toedter.calendar.JTextFieldDateEditor;
import empleados.clases.Encriptar;
import empleados.clases.fecha;
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

        //fechaNacimiento = ((JTextFieldDateEditor) creaEFgrafica.DatePikerFNacEF.getDateEditor()).getText();
        fechaAlta = ((JTextFieldDateEditor) CreaUsu.DatePikerEFNacEF.getDateEditor()).getText();
        nac = new fecha(fechaAlta);
        return nac;
    }
    
    public static String email() {
        String email = "";
        boolean valida;

        email = CreaUsu.txtemail.getText();

        if (email.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del email esta vacio, porfavor introduzca un DNI");
            CreaUsu.txtemail.setBackground(Color.red);
            CreaUsu.txtemail.requestFocus();

        } else {
            //dni=CreaUsu.txtDNIEF.getText();
            //valida=validate.validateNombre(dni);
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
            //JOptionPane.showMessageDialog(null, "El campo del Login/Usuario esta vacio, porfavor introduzca un Login/Usuario");
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
            //JOptionPane.showMessageDialog(null, "El campo del Password esta vacio, porfavor introduzca un Password");
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
            //JOptionPane.showMessageDialog(null, "El campo del Nombre esta vacio, porfavor introduzca un Nombre");
            PerfilUsu.txtNombre.setBackground(Color.red);
            PerfilUsu.txtNombre.requestFocus();

        } else {

            //nom=PerfilUsu.txtNombre.getText();
            valida = validate.validateNombre(nom);
            if (valida == false) {
                //JOptionPane.showMessageDialog(null, "Introduzca un Nombre valido");
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
            //JOptionPane.showMessageDialog(null, "El campo del Departamento esta vacio, porfavor introduzca un Departamento");
            PerfilUsu.txtDepartamento.setBackground(Color.red);
            PerfilUsu.txtDepartamento.requestFocus();

        } else {

            //deprt=PerfilUsu.txtDepartamento.getText();
            PerfilUsu.txtDepartamento.setBackground(Color.green);
        }
        return deprt;
    }
    
    public static String modificaemail() {
        String email = "";
        boolean valida;

        email = PerfilUsu.txtemail.getText();
        if (email.isEmpty()) {
            //JOptionPane.showMessageDialog(null, "El campo del email esta vacio, porfavor introduzca un email");
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
            //JOptionPane.showMessageDialog(null, "El campo del Login/Usuario esta vacio, porfavor introduzca un Login/Usuario");
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
            //JOptionPane.showMessageDialog(null, "El campo del Password esta vacio, porfavor introduzca un Password");
            PerfilUsu.txtpassword.setBackground(Color.red);
            PerfilUsu.txtpassword.requestFocus();

        } else {

            PerfilUsu.txtpassword.setBackground(Color.green);
            pass=Encriptar.encriptarTokenMD5(pass);
        }
        return pass;
    }
    
    public static fecha fnacUsumodificagrafica() {
        String fechaNacimiento = "";
        fecha nac = null;
        boolean valida;

        //fechaNacimiento = ((JTextFieldDateEditor) creaEFgrafica.DatePikerFNacEF.getDateEditor()).getText();
        fechaNacimiento = ((JTextFieldDateEditor) PerfilUsu.DatePiketEFnac.getDateEditor()).getText();
        nac = new fecha(fechaNacimiento);
        return nac;
    }
    
    /*public static fecha fcontEFmodificagrafica() {
        String fechaContratacion = "";

        fecha cont = null;
        //fechaContratacion = ((JTextFieldDateEditor) creaEFgrafica.DatePikerFContEF.getDateEditor()).getText();
        fechaContratacion = ((JTextFieldDateEditor) PerfilUsu.DatePikerEFCont.getDateEditor()).getText();
        cont = new fecha(fechaContratacion);
        return cont;
    }*/
    
    public static void borrarcamposModifica() {
        PerfilUsu.txtNombre.setText("");
        PerfilUsu.txtDepartamento.setText("");
        PerfilUsu.DatePiketEFnac.setDate(null);
        PerfilUsu.DatePikerEFCont.setDate(null);
        PerfilUsu.txtemail.setText("");
        PerfilUsu.txtlogin.setText("");
        PerfilUsu.txtpassword.setText("");
        PerfilUsu.txtNombre.requestFocus();
    }
    
    public static void borrarcamposcreaUsu() {
        CreaUsu.txtNombreEF.setText("");
        CreaUsu.txtDepartamentoEF.setText("");
        CreaUsu.DatePikerEFNacEF.setDate(null);
        //CreaUsu.DatePikerEFContEF.setDate(null);
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

        //String nombre, departamento;
        //int pos = 0;
        //fecha fnac = null, fcont = null;
        PerfilUsu.txtNombre.setText(SingletonsUsu.u.getNombre());
        PerfilUsu.txtDepartamento.setText(SingletonsUsu.u.getDepartamento());
        PerfilUsu.txtantiguedad.setText(Integer.toString(SingletonsUsu.u.AntiguedadAltaUsu()));
        PerfilUsu.txtedad.setText(Integer.toString(SingletonsUsu.u.getEdad()));
        //PerfilUsu.txtsueldo.setText(Float.toString(SingletonsUsu.u.calcularsueldo()));
        ((JTextFieldDateEditor) PerfilUsu.DatePiketEFnac.getDateEditor()).setText(SingletonsUsu.u.getFechaNacimiento().toString());
        ((JTextFieldDateEditor) PerfilUsu.DatePikerEFCont.getDateEditor()).setText(SingletonsUsu.u.getfechaAlta().toString());
        PerfilUsu.txtemail.setText(SingletonsUsu.u.getEmail());
        PerfilUsu.txtlogin.setText(SingletonsUsu.u.getLogin());
        PerfilUsu.txtpassword.setText("");

    }
    
    public static Usuario creaUsuGrafica() {
        Usuario ef1 = null;
        //nombre
        String nom;
        String tipo="";
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
        avatar=CreaUsu.labelavatar.getText();

        //usuariologin
        String usuario;
        usuario = usuariologin();

        //password
        String Password;
        Password = password();

        //validar fnac
        fecha naci = null;
        naci = NaciUsugrafica();

                
        if(nom.isEmpty() || dni.isEmpty() || pobl.isEmpty() || usuario.isEmpty() || Password.isEmpty() || email.isEmpty() || naci==null){
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
        }else{
        
        //miramos la diferencia entre la fecha de nacimiento y la actual
        valida = naci.calcularedad();

        if (valida < 16) {
            CreaUsu.DatePikerEFNacEF.setBackground(Color.RED);            
            CreaUsu.DatePikerEFNacEF.requestFocus();
            JOptionPane.showMessageDialog(null, "No puede registrar a un menor de 16 años");
        }else{
            
             

        //validamos
        //ef1 = new empleadofijo(nom, dni, deprt, naci, contr, "", "", "");
        
        SingletonsUsu.u = new Usuario(nom, dni, pobl, naci, usuario, Password, email, tipo, avatar);
        //String nombre,  String dni, String departamento, fecha fechaNacimiento, fecha fechaContratacion, String login, String password, String email

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
        
        //return ef1;
    }


    public static void modificaUsugrafica() {
        //empleadofijo ef2=null;
        //ef1 = new empleadofijo(nom, dni, deprt, naci, contr, "", "", "");
        //nombre=?,edad=?,departamento=?,fechaNacimiento=?,suelo=?,password=?,email=?,avatar=?,tipo=?,"
        //          + "estado=?,antiguedad=?,fechaContratacion=?
        fecha mnac, mcont;
        String mnom, mdeprt, mlog, mpass, mmail;
        mnac=fnacUsumodificagrafica();
        //mcont=fcontEFmodificagrafica();
        mnom=modificanombreUSUgrafica();
        mdeprt=modificapoblacionUSUgrafica();
        mlog=modificausuariologin();
        mpass=modificapassword();
        mmail=modificaemail();
        if(mnac==null || mnom.isEmpty() || mdeprt.isEmpty() || mlog.isEmpty() || mpass.isEmpty() || mmail.isEmpty()){
            JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");
            
        }else{
        SingletonsUsu.u.setNombre(modificanombreUSUgrafica());
        SingletonsUsu.u.setDepartamento(modificapoblacionUSUgrafica());
        SingletonsUsu.u.setFechaNacimiento(fnacUsumodificagrafica());
        //SingletonsUsu.u.setfechaAlta(fcontEFmodificagrafica());
        //ArraylistEF.efi.setSueldo(ArraylistEF.efi.calcularsueldo());
        SingletonsUsu.u.setLogin(modificausuariologin());
        SingletonsUsu.u.setPassword(modificapassword());
        SingletonsUsu.u.setEmail(modificaemail());

        JOptionPane.showMessageDialog(null, "El Empleado ha sido modificado satisfactoriamente");

        borrarcamposModifica();
        PerfilUsu.txtNombre.setBackground(Color.WHITE);
        PerfilUsu.txtDepartamento.setBackground(Color.WHITE);
        PerfilUsu.txtantiguedad.setBackground(Color.WHITE);
        PerfilUsu.txtedad.setBackground(Color.WHITE);
        PerfilUsu.DatePiketEFnac.setBackground(Color.WHITE);
        //PerfilUsu.DatePikerEFCont.setBackground(Color.WHITE);
        PerfilUsu.txtemail.setBackground(Color.WHITE);
        PerfilUsu.txtlogin.setBackground(Color.WHITE);
        PerfilUsu.txtpassword.setBackground(Color.WHITE);
    }
    }
    /*   
    
    

    public static void borrarcamposcrea() {
        crearProducto.txtNombreprod.setText("");
        crearProducto.txtDescripcionProd.setText("");
        crearProducto.DatePikeraltaProd.setDate(null);
        crearProducto.txtidProd.setText("");
        crearProducto.txtNombreprod.requestFocus();

    }

    public static producto creaProductoGrafica() {
        producto pr = null;
        //nombre
        String nom;
        int validar, valida;

        nom = nombreProductografica();

        //descripcion
        String dscrp;
        dscrp = descripcionProductografica();

        //idproducto
        String idprod;
        idprod = idProductografica();
             

        //validar fnac
        fecha alta = null;
        alta = AltaProductografica();

        if (nom.isEmpty() || idprod.isEmpty() || dscrp.isEmpty() || alta == null) {
            JOptionPane.showMessageDialog(null, "Por favor rellene todos los campos");
        } else {
            //comparamos fechas
            validar = alta.compfechassystem();

            if (validar == 0) {
                crearProducto.DatePikeraltaProd.setBackground(Color.GREEN);
                crearProducto.CrearProd.requestFocus();
            } else if (validar == 1) {
                crearProducto.DatePikeraltaProd.setBackground(Color.RED);
                crearProducto.DatePikeraltaProd.requestFocus();
                JOptionPane.showMessageDialog(null, "La fecha de alta debe ser inferior a la actual");
            } else if (validar == -1) {
                crearProducto.DatePikeraltaProd.setBackground(Color.RED);
                crearProducto.DatePikeraltaProd.requestFocus();
                JOptionPane.showMessageDialog(null, "La fecha de alta debe ser superior a la actual");
            }

            singletonsprod.prd = new producto(nom, idprod, alta, dscrp);

            crearProducto.txtNombreprod.setText("");
            crearProducto.txtDescripcionProd.setText("");
            crearProducto.DatePikeraltaProd.setDate(null);
            crearProducto.txtidProd.setText("");
            crearProducto.txtNombreprod.requestFocus();

            crearProducto.txtNombreprod.setBackground(Color.WHITE);
            crearProducto.txtDescripcionProd.setBackground(Color.WHITE);
            crearProducto.txtidProd.setBackground(Color.WHITE);
            crearProducto.DatePikeraltaProd.setBackground(Color.WHITE);

        }
        return singletonsprod.prd;

    }

    public static producto obtenerEF(String dni) {

        int pos = 0;
        producto ef1 = null;

        ef1 = new producto(dni);
        pos = BLLPRODgrafica.buscar(ef1);
        ef1 = singletonsprod.prod.get(pos);
        return ef1;
    }

    public static String modificanombreproducto() {
        String nom = "";
        boolean valida;

        nom = modificaprod.txtNombre.getText();

        if (nom.isEmpty()) {

            modificaprod.txtNombre.setBackground(Color.red);
            modificaprod.txtNombre.requestFocus();
        } else {
            valida = validate.validateNombre(nom);
            if (valida == false) {
                modificaprod.txtNombre.setBackground(Color.red);
                modificaprod.txtNombre.requestFocus();
            } else {
                modificaprod.txtNombre.setBackground(Color.green);
            }

        }
        return nom;

    }

    public static String modificaDescripcionProducto() {
        String deprt = "";

        deprt = modificaprod.txtDescricion.getText();
        if (deprt.isEmpty()) {
            modificaprod.txtDescricion.setBackground(Color.red);
            modificaprod.txtDescricion.requestFocus();

        } else {
            modificaprod.txtDescricion.setBackground(Color.green);
        }
        return deprt;
    }

    public static String modificaIdProducto() {
        String idprod = "";

        idprod = modificaprod.txtidprod.getText();

        if (idprod.isEmpty()) {

            modificaprod.txtidprod.setBackground(Color.red);
            modificaprod.txtidprod.requestFocus();

        } else {
            modificaprod.txtidprod.setBackground(Color.red);
            modificaprod.txtidprod.requestFocus();
            modificaprod.txtidprod.setBackground(Color.green);
        }
        return idprod;
    }

    public static fecha ModificaAltaProducto() {
        String Altaprod = "";
        fecha alta = null;
        boolean valida;

        Altaprod = ((JTextFieldDateEditor) modificaprod.DatePiketProdAlta.getDateEditor()).getText();
        alta = new fecha(Altaprod);
        return alta;
    }

    public static void borrarcamposModifica() {
        modificaprod.txtNombre.setText("");
        modificaprod.txtDescricion.setText("");
        modificaprod.DatePiketProdAlta.setDate(null);
        modificaprod.txtantiguedad.setText("");
        modificaprod.txtidprod.setText("");
        modificaprod.txtprecio.setText("");
        modificaprod.txtNombre.requestFocus();
    }

    public static void modificaprodllenadodatos() {

        modificaprod.txtNombre.setText(singletonsprod.prd.getNombre());
        modificaprod.txtDescricion.setText(singletonsprod.prd.getDescripcion());
        modificaprod.txtantiguedad.setText(Integer.toString(singletonsprod.prd.getAntiguedad()));
        modificaprod.txtprecio.setText(Float.toString(singletonsprod.prd.getPrecio()));
        ((JTextFieldDateEditor) modificaprod.DatePiketProdAlta.getDateEditor()).setText(singletonsprod.prd.getFechaentrada().toString());
        modificaprod.labelavatar.setText(singletonsprod.prd.getAvatar());
    }

    public static void modificaProductografica() {
   
        fecha entrada;
        String mnom, dscrp, idprod;
        entrada = ModificaAltaProducto();
        mnom = modificanombreproducto();
        dscrp = modificaDescripcionProducto();
        idprod = modificaIdProducto();
        if (entrada == null || mnom.isEmpty() || dscrp.isEmpty() || idprod.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Porfavor rellene todos los campos");

        } else {
            singletonsprod.prd.setNombre(mnom);
            singletonsprod.prd.setDescripcion(dscrp);
            singletonsprod.prd.setFechaentrada(entrada);                                   
            singletonsprod.prd.setIdprod(idprod);
            

            JOptionPane.showMessageDialog(null, "El Empleado ha sido modificado satisfactoriamente");
            
            borrarcamposModifica();
            modificaprod.txtNombre.setBackground(Color.WHITE);
            modificaprod.txtDescricion.setBackground(Color.WHITE);
            modificaprod.txtantiguedad.setBackground(Color.WHITE);
            modificaprod.txtprecio.setBackground(Color.WHITE);
            modificaprod.DatePiketProdAlta.setBackground(Color.WHITE);            
            modificaprod.labelavatar.setBackground(Color.WHITE);                       
        }
    }*/
             
}
