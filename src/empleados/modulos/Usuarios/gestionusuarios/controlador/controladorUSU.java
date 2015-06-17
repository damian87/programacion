/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.Usuarios.gestionusuarios.controlador;

import empleados.modulos.gestionempleados.gestionEF.controlador.*;
import empleados.librerias.FileUploader;
import empleados.librerias.fondopanelconfig;
import empleados.librerias.fondopanelcrear;
import empleados.librerias.fondopanellogin;
import empleados.librerias.fondopanelpager;
import empleados.menuempleados;
import empleados.modulos.Usuarios.gestionusuarios.modelo.clase.Usuario;
import empleados.modulos.Usuarios.gestionusuarios.modelo.BLL.BLLBD_USU;
import empleados.modulos.Usuarios.gestionusuarios.modelo.BLL.BLLUSUgrafica;
import empleados.modulos.Usuarios.gestionusuarios.modelo.DAO.DAOUSUgrafica;
import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.STMUSU;
import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.SingletonsUsu;
import empleados.modulos.Usuarios.gestionusuarios.modelo.pagerprod.pagina;
import empleados.modulos.Usuarios.gestionusuarios.autocomplete.AutocompleteJComboBox;
import empleados.modulos.Usuarios.gestionusuarios.vista.CreaUsu;
import empleados.modulos.Usuarios.gestionusuarios.vista.PerfilUsu;
import empleados.modulos.Usuarios.gestionusuarios.autocomplete.StringSearchable;
import empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica;
import static empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.TABLA;
import static empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.guardarjson;
import static empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.guardartxt;
import static empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.guardarxml;
import static empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.jComboBox1;
import empleados.modulos.Usuarios.gestionusuarios.vista.menupager;
import empleados.modulos.config.configuracion;
import empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica;
//import empleados.modulos.gestionempleados.gestionEF.modelo.BLL.BLLBD_EF;
//import empleados.modulos.gestionempleados.gestionEF.modelo.BLL.EFBLLgrafica;
import empleados.modulos.login.modelo_log.BLL_LOG.loginBLL;
//import empleados.modulos.gestionempleados.gestionEF.modelo.DAO.DAOEFgrafica;
//import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.ArraylistEF;
//import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.STMEF;
//import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
//import empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.TABLA;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
//import empleados.modulos.gestionempleados.gestionEF.modelo.pager.pagina1;
//import empleados.modulos.gestionempleados.gestionEF.vista.AutocompleteJComboBox;
//import empleados.modulos.gestionempleados.gestionEF.vista.StringSearchable;
//import empleados.modulos.gestionempleados.gestionEF.vista.creaEFgrafica;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.TABLA;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.combo;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.comboActionPerformed;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.guardarjson;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.guardartxt;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.guardarxml;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.jComboBox1;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.sorter;
//import empleados.modulos.gestionempleados.gestionEF.vista.modificaEFgrafica;
//import static empleados.modulos.gestionempleados.gestionEF.vista.modificaEFgrafica.ModificarEF;
//import static empleados.modulos.gestionempleados.gestionEF.vista.modificaEFgrafica.txtDepartamento;
import empleados.modulos.login.vista_log.recordarcontraseña;
import empleados.modulos.login.vista_log.Iniciologin;
import empleados.modulos.login.controlador_log.controlador_login;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author damian
 */
public class controladorUSU implements ActionListener, KeyListener, MouseListener {

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new STMUSU());
    public static AutocompleteJComboBox combo = null;
    public static interfaceUSUgrafica usugraf = new interfaceUSUgrafica();
    //public static subprincipal subpri = new subprincipal();
    public static CreaUsu creaUSU = new CreaUsu();
    public static PerfilUsu modiUSU = new PerfilUsu();
    public static configuracion configu = new configuracion();
    public static Iniciologin inilog = new Iniciologin();
    public static recordarcontraseña recordar = new recordarcontraseña();
    public static menupager menpa = new menupager();

    public controladorUSU(JFrame inicio, int i) {
        /*if (i == 0) {
         this.subpri = (subprincipal) inicio;
         }*/

        if (i == 1) {
            this.usugraf = (interfaceUSUgrafica) inicio;
        }

        if (i == 2) {
            this.creaUSU = (CreaUsu) inicio;
        }

        if (i == 3) {
            this.modiUSU = (PerfilUsu) inicio;
        }

        if (i == 4) {
            this.configu = (configuracion) inicio;
        }

        if (i == 5) {
            this.menpa = (menupager) inicio;
        }
        /*if (i == 5) {
         this.inilog = (Iniciologin) inicio;
         }
        
         if (i == 6) {
         this.recordar = (recordarcontraseña) inicio;
         }*/

    }

    public enum Accion {

        //BOTONES PAGER
        _BTN_ANTERIOR,
        _BTN_SIGUIENTE,
        _BTN_ULTIMO,
        _BTN_PRIMERO,
        _BUSCAR,
        _COMBOX,
        _TABLAEF,
        _GUARDAR,
        _ELIMINAR,
        _NCREAR,
        _MODIFICAR,
        _VOLVER,
        _BTNMEDIA,
        _BTNMAYMEN,
        _INFO,
        _FILTRARUSU,
        //BOTONES CREA
        _CREAREF,
        _BORRAR_CAMPOSEF,
        _CANCELAR_CREAEF,
        _NOMBREEF,
        _DEPARTAMENTOEF,
        _DNIEF,
        _Email,
        _Password,
        _Usuario,
        _CargaAvatar,
        _PintaAvatar,
        //BOTONES MODIFICA
        _SUELDO,
        _EDAD,
        _ANTIGUEDAD,
        _MNOMBRE,
        _MDEPARTAMENTO,
        _MMODIFICA,
        _MCANCELAR,
        _MEmail,
        _MPassword,
        _MUsuario,
        _MAvatar,
        //BOTONES SUBPRINCIPAL
        _CONFIGURACION,
        _GESTIONEF,
        //CONFIGURACION
        _CVOLVER,
        _CEUROS,
        _CLIBRAS,
        _CDOLARES,
        _CUNDECI,
        _CDOSDECI,
        _CJSON,
        _CXML,
        _CTXT,
        //inicio
        _usuario,
        _password,
        _enter,
        _olvidarpass,
        _newusu,
        _configurador,
        //reestablecer contraseña
        _RUSU,
        _RPASS,
        _RRESSTABLECER,
        _RCANCELAR,
        //menu pager
        _MENUEMPLEADOS,
        _MENUUSUARIOS
    }

    //en el new controladorEF (new interfaceUSUgrafica(), 0).Iniciar(0);
    //el primer 0 es para entrar al if del controladorEF, y el segundo 0 es para la funion iniciar k 
    public void Iniciar(int i) {
        /*//SUBPRINCIPAL
         if (i == 0) {
         this.subpri.setVisible(true);

         this.subpri.setTitle("Bienvenidos a la Gestion de Empleados");
         this.subpri.setLocationRelativeTo(null);
         this.subpri.setSize(525, 425);//ancho x alto
         this.subpri.setResizable(false);
         Image icono = Toolkit.getDefaultToolkit().getImage("imagenes/new.png");
         this.subpri.setIconImage(icono);

         this.subpri.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada

         this.subpri.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
         subpri.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
         JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
         subpri.dispose();
         System.exit(0);
         }
         });

         this.subpri.configEF.setActionCommand("_CONFIGURACION");
         this.subpri.configEF.setName("_CONFIGURACION");
         this.subpri.configEF.addActionListener(this);

         this.subpri.imprimirEF.setActionCommand("_GESTIONEF");
         this.subpri.imprimirEF.setName("_GESTIONEF");
         this.subpri.imprimirEF.addActionListener(this);

         }*/

        if (i == 1) {

            //interfazUSUgrafica
            this.usugraf.setVisible(true);

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            //initComponents();    
            this.usugraf.setLocationRelativeTo(null);
            this.usugraf.setTitle("GestionEmpleados Fijos");
            this.usugraf.setResizable(true);
            fondopanelpager c = new fondopanelpager();
            this.usugraf.setContentPane(c);
            this.usugraf.jPanel6.setOpaque(false);
            c.add(this.usugraf.jPanel6);
            //this.usugraf.setSize(525, 425);//ancho x alto
            this.usugraf.jPanel1.setOpaque(false);
            this.usugraf.jPanel2.setOpaque(false);
            this.usugraf.jPanel3.setOpaque(false);
            this.usugraf.jPanel4.setOpaque(false);
            this.usugraf.jPanel5.setOpaque(false);

            TABLA.setModel(new STMUSU());
            ((STMUSU) interfaceUSUgrafica.TABLA.getModel()).cargar();
            TABLA.setFillsViewportHeight(true);
            TABLA.setRowSorter(sorter);

            pagina.inicializa();
            pagina.initLinkBox();

            this.usugraf.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.usugraf.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    usugraf.dispose();
                    //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                    new controlador_login(new Iniciologin(), 5).Iniciar(5);

                }
            });

            List<String> myWords = new ArrayList<String>();
            for (int e = 0; e <= SingletonsUsu.usu.size() - 1; e++) {
                myWords.add(SingletonsUsu.usu.get(e).getNombre());
            }

            StringSearchable searchable = new StringSearchable(myWords);
            combo = new AutocompleteJComboBox(searchable);
            this.usugraf.jPanel3.setLayout(new java.awt.BorderLayout());
            this.usugraf.jPanel3.add(combo);

            combo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }
            });

            this.usugraf.guardartxt.doClick();

            FileUploader.pintaravatar(this.usugraf.labelavatar, 90, 90);

            this.usugraf.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
            this.usugraf.ANTERIOR.setName("_BTN_ANTERIOR");
            this.usugraf.ANTERIOR.addActionListener(this);

            this.usugraf.SIGUIENTE.setActionCommand("_BTN_SIGUIENTE");
            this.usugraf.SIGUIENTE.setName("_BTN_SIGUIENTE");
            this.usugraf.SIGUIENTE.addActionListener(this);

            this.usugraf.ultimo.setActionCommand("_BTN_ULTIMO");
            this.usugraf.ultimo.setName("_BTN_ULTIMO");
            this.usugraf.ultimo.addActionListener(this);

            this.usugraf.primero.setActionCommand("_BTN_PRIMERO");
            this.usugraf.primero.setName("_BTN_PRIMERO");
            this.usugraf.primero.addActionListener(this);

            this.usugraf.jTextField1.setActionCommand("_FILTRARUSU");
            this.usugraf.jTextField1.setName("_FILTRARUSU");
            this.usugraf.jTextField1.addActionListener(this);

            this.usugraf.jComboBox1.setActionCommand("_COMBOX");
            this.usugraf.jComboBox1.setName("_COMBOX");
            this.usugraf.jComboBox1.addActionListener(this);

            this.usugraf.botonarchivoEF.setActionCommand("_GUARDAR");
            this.usugraf.botonarchivoEF.setName("_GUARDAR");
            this.usugraf.botonarchivoEF.addActionListener(this);

            this.usugraf.jButton1.setActionCommand("_VOLVER");
            this.usugraf.jButton1.setName("_VOLVER");
            this.usugraf.jButton1.addActionListener(this);

            this.usugraf.botonedadmedia.setActionCommand("_BTNMEDIA");
            this.usugraf.botonedadmedia.setName("_BTNMEDIA");
            this.usugraf.botonedadmedia.addActionListener(this);

            this.usugraf.botonmayormenor.setActionCommand("_BTNMAYMEN");
            this.usugraf.botonmayormenor.setName("_BTNMAYMEN");
            this.usugraf.botonmayormenor.addActionListener(this);

            this.usugraf.info.setActionCommand("_INFO");
            this.usugraf.info.setName("_INFO");
            this.usugraf.info.addActionListener(this);

            if ("User".equals(SingletonsUsu.usulogin.getTipo())) {

                this.usugraf.botonnuevoEF.setVisible(false);
                this.usugraf.botonmodificarEF.setVisible(false);
                this.usugraf.botoneliminarEF.setVisible(false);
            } else {
                this.usugraf.botonnuevoEF.setActionCommand("_NCREAR");
                this.usugraf.botonnuevoEF.setName("_NCREAR");
                this.usugraf.botonnuevoEF.addActionListener(this);

                this.usugraf.botoneliminarEF.setActionCommand("_ELIMINAR");
                this.usugraf.botoneliminarEF.setName("_ELIMINAR");
                this.usugraf.botoneliminarEF.addActionListener(this);

                this.usugraf.botonmodificarEF.setActionCommand("_MODIFICAR");
                this.usugraf.botonmodificarEF.setName("_MODIFICAR");
                this.usugraf.botonmodificarEF.addActionListener(this);

            }

        }

        if (i == 2) {
            //CreaUsu

            this.creaUSU.setVisible(true);
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }
            this.creaUSU.setTitle("Alta Empleado Fijo");
            this.creaUSU.setLocationRelativeTo(null);

            this.creaUSU.setResizable(false);
            //Image icono=Toolkit.getDefaultToolkit().getImage("imagenes/new.png");
            //this.creaUSU.setIconImage(icono);
            this.creaUSU.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada
            fondopanelcrear c = new fondopanelcrear();
            this.creaUSU.setContentPane(c);
            this.creaUSU.jPanel1.setOpaque(false);
            c.add(this.creaUSU.jPanel1);

            this.creaUSU.Usuario.doClick();
            this.creaUSU.txtdniEF.setVisible(false);
            //this.creaUSU.setSize(525, 425);//ancho x alto

            this.creaUSU.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            creaUSU.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    creaUSU.dispose();
                    //EFBLLgrafica.GuardarSinEnterarse();
                    //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                    new controlador_login(new Iniciologin(), 5).Iniciar(5);
                }
            });

            this.creaUSU.CrearEF.setActionCommand("_CREAREF");
            this.creaUSU.CrearEF.setName("_CREAREF");
            this.creaUSU.CrearEF.addActionListener(this);

            this.creaUSU.BorrarEF.setActionCommand("_BORRAR_CAMPOSEF");
            this.creaUSU.BorrarEF.setName("_BORRAR_CAMPOSEF");
            this.creaUSU.BorrarEF.addActionListener(this);

            this.creaUSU.CancelarEF.setActionCommand("_CANCELAR_CREAEF");
            this.creaUSU.CancelarEF.setName("_CANCELAR_CREAEF");
            this.creaUSU.CancelarEF.addActionListener(this);

            this.creaUSU.txtNombreEF.setActionCommand("_NOMBREEF");
            this.creaUSU.txtNombreEF.setName("_NOMBREEF");
            this.creaUSU.txtNombreEF.addKeyListener(this);

            this.creaUSU.txtDepartamentoEF.setActionCommand("_DEPARTAMENTOEF");
            this.creaUSU.txtDepartamentoEF.setName("_DEPARTAMENTOEF");
            this.creaUSU.txtDepartamentoEF.addKeyListener(this);

            this.creaUSU.txtDNIEF.setActionCommand("_DNIEF");
            this.creaUSU.txtDNIEF.setName("_DNIEF");
            this.creaUSU.txtDNIEF.addKeyListener(this);

            this.creaUSU.txtemail.setActionCommand("_Email");
            this.creaUSU.txtemail.setName("_Email");
            this.creaUSU.txtemail.addKeyListener(this);

            this.creaUSU.txtpassword.setActionCommand("_Password");
            this.creaUSU.txtpassword.setName("_Password");
            this.creaUSU.txtpassword.addKeyListener(this);

            this.creaUSU.txtlogin.setActionCommand("_Usuario");
            this.creaUSU.txtlogin.setName("_Usuario");
            this.creaUSU.txtlogin.addKeyListener(this);

            this.creaUSU.cargarimgavatar.setActionCommand("_CargaAvatar");
            this.creaUSU.cargarimgavatar.setName("_CargaAvatar");
            this.creaUSU.cargarimgavatar.addKeyListener(this);

            if (SingletonsUsu.usulogin == null) {
                this.creaUSU.jPanel2.setVisible(false);
            } else if ("admin".equals(SingletonsUsu.usulogin.getTipo())) {
                this.creaUSU.jPanel2.setVisible(true);
            }

            //FALTAN COLOCAR LOS KEYPRESSET Y KEYRELEASSED
        }

        if (i == 3) {
            //PerfilUsu

            this.modiUSU.setVisible(true);

            this.modiUSU.setTitle("Modifcar Empleado Fijo");
            this.modiUSU.setLocationRelativeTo(null);
            this.modiUSU.setSize(525, 425);//ancho x alto
            this.modiUSU.setResizable(false);
            java.awt.Image icono = java.awt.Toolkit.getDefaultToolkit().getImage("imagenes/modificar.png");
            this.modiUSU.setIconImage(icono);
            this.modiUSU.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada
            fondopanelcrear c = new fondopanelcrear();
            this.modiUSU.setContentPane(c);
            this.modiUSU.jPanel1.setOpaque(false);
            c.add(this.modiUSU.jPanel1);

            if ("User".equals(SingletonsUsu.usulogin.getTipo())) {
                DAOUSUgrafica.modificaUsugraficallenadodatos();
                FileUploader.pintaravatar(this.modiUSU.labelavatar, 90, 90);
            } else {

                BLLUSUgrafica.modificaUsuariograficallenacampos();
                FileUploader.pintaravataref(this.modiUSU.labelavatar, 90, 90);
            }

            FileUploader.pintaravatar(this.modiUSU.labelavatar, 90, 90);

            this.modiUSU.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            modiUSU.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    modiUSU.dispose();

                    //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                    new controlador_login(new Iniciologin(), 5).Iniciar(5);
                }
            });

            this.modiUSU.txtedad.setEditable(false);

            this.modiUSU.ModificarEF.setActionCommand("_MMODIFICA");
            this.modiUSU.ModificarEF.setName("_MMODIFICA");
            this.modiUSU.ModificarEF.addActionListener(this);

            this.modiUSU.CancelarEF.setActionCommand("_MCANCELAR");
            this.modiUSU.CancelarEF.setName("_MCANCELAR");
            this.modiUSU.CancelarEF.addActionListener(this);

            this.modiUSU.txtNombre.setActionCommand("_MNOMBRE");
            this.modiUSU.txtNombre.setName("_MNOMBRE");
            this.modiUSU.txtNombre.addActionListener(this);
            this.modiUSU.txtNombre.setActionCommand("_MNOMBRE");
            this.modiUSU.txtNombre.addKeyListener(this);

            this.modiUSU.txtDepartamento.setActionCommand("_MDEPARTAMENTO");
            this.modiUSU.txtDepartamento.setName("_MDEPARTAMENTO");
            this.modiUSU.txtDepartamento.addActionListener(this);
            this.modiUSU.txtDepartamento.setActionCommand("_MDEPARTAMENTO");
            this.modiUSU.txtDepartamento.addKeyListener(this);

            this.modiUSU.txtemail.setActionCommand("_MEmail");
            this.modiUSU.txtemail.setName("_MEmail");
            this.modiUSU.txtemail.addActionListener(this);
            this.modiUSU.txtemail.addKeyListener(this);

            this.modiUSU.txtpassword.setActionCommand("_MPassword");
            this.modiUSU.txtpassword.setName("_MPassword");
            this.modiUSU.txtpassword.addActionListener(this);
            this.modiUSU.txtpassword.addKeyListener(this);

            this.modiUSU.txtlogin.setActionCommand("_MUsuario");
            this.modiUSU.txtlogin.setName("_MUsuario");
            this.modiUSU.txtlogin.addActionListener(this);
            this.modiUSU.txtlogin.addKeyListener(this);

            this.modiUSU.cargarimgavatar.setActionCommand("_MAvatar");
            this.modiUSU.cargarimgavatar.setName("_MAvatar");
            this.modiUSU.cargarimgavatar.addActionListener(this);

        }

        if (i == 4) {
            //configuracion

            this.configu.setVisible(true);

            this.configu.setTitle("Configuracion");
            this.configu.setLocationRelativeTo(null);
            this.configu.setSize(525, 425);//ancho x alto
            this.configu.setResizable(false);
            Image icono = Toolkit.getDefaultToolkit().getImage("imprimir/new.png");
            this.configu.setIconImage(icono);
            this.configu.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada

            fondopanelconfig c = new fondopanelconfig();
            this.configu.setContentPane(c);
            this.configu.FondoConfig.setOpaque(false);
            c.add(this.configu.FondoConfig);

            this.configu.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            configu.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    configu.dispose();

                    //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                    new controlador_login(new Iniciologin(), 5).Iniciar(5);
                }
            });

            this.configu.Volver.setActionCommand("_CVOLVER");
            this.configu.Volver.setName("_CVOLVER");
            this.configu.Volver.addActionListener(this);

            this.configu.Euros.setActionCommand("_CEUROS");
            this.configu.Euros.setName("_CEUROS");
            this.configu.Euros.addActionListener(this);

            this.configu.Libras.setActionCommand("_CLIBRAS");
            this.configu.Libras.setName("_CLIBRAS");
            this.configu.Libras.addActionListener(this);

            this.configu.Dolares.setActionCommand("_CDOLARES");
            this.configu.Dolares.setName("_CDOLARES");
            this.configu.Dolares.addActionListener(this);

            this.configu.UnDecimal.setActionCommand("_CUNDECI");
            this.configu.UnDecimal.setName("_CUNDECI");
            this.configu.UnDecimal.addActionListener(this);

            this.configu.DosDecimales.setActionCommand("_CDOSDECI");
            this.configu.DosDecimales.setName("_CDOSDECI");
            this.configu.DosDecimales.addActionListener(this);

            this.configu.JSON.setActionCommand("_CJSON");
            this.configu.JSON.setName("_CJSON");
            this.configu.JSON.addActionListener(this);

            this.configu.XML.setActionCommand("_CXML");
            this.configu.XML.setName("_CXML");
            this.configu.XML.addActionListener(this);

            this.configu.TXT.setActionCommand("_CTXT");
            this.configu.TXT.setName("_CTXT");
            this.configu.TXT.addActionListener(this);

        }

        if (i == 5) {
            //menu opcionaes pager

            this.menpa.setVisible(true);

            this.menpa.setTitle("Configuracion");
            this.menpa.setLocationRelativeTo(null);
            this.menpa.setSize(525, 425);//ancho x alto
            this.menpa.setResizable(false);
            Image icono = Toolkit.getDefaultToolkit().getImage("imprimir/new.png");
            this.menpa.setIconImage(icono);
            this.menpa.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada

            fondopanellogin c = new fondopanellogin();
            this.menpa.setContentPane(c);
            this.menpa.jPanel1.setOpaque(false);
            c.add(this.menpa.jPanel1);

            this.menpa.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            menpa.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    menpa.dispose();

                    //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                    new controlador_login(new Iniciologin(), 5).Iniciar(5);
                }
            });

            this.menpa.btnempleados.setActionCommand("_MENUEMPLEADOS");
            this.menpa.btnempleados.setName("_MENUEMPLEADOS");
            this.menpa.btnempleados.addActionListener(this);

            this.menpa.btnusuarios.setActionCommand("_MENUUSUARIOS");
            this.menpa.btnusuarios.setName("_MENUUSUARIOS");
            this.menpa.btnusuarios.addActionListener(this);

        }

    }
    /*//modulo de inicio login
     if (i == 5) {

     this.inilog.setVisible(true);

     this.inilog.setTitle("Bienvenidos a la Gestion de Empleados");
     this.inilog.setLocationRelativeTo(null);
     this.inilog.setSize(525, 425);//ancho x alto
     this.inilog.setResizable(false);
     Image icono = Toolkit.getDefaultToolkit().getImage("imagenes/new.png");
     this.inilog.setIconImage(icono);

     this.inilog.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada

     this.inilog.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     inilog.addWindowListener(new WindowAdapter() {
     @Override
     public void windowClosing(WindowEvent e) {
     JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
     inilog.dispose();
     System.exit(0);
     }
     });

     this.inilog.txtusuario.setActionCommand("_usuario");
     this.inilog.txtusuario.setName("_usuario");
     this.inilog.txtusuario.addActionListener(this);
     this.inilog.txtusuario.addKeyListener(this);

     this.inilog.txtpassword.setActionCommand("_password");
     this.inilog.txtpassword.setName("_password");
     this.inilog.txtpassword.addActionListener(this);
     this.inilog.txtpassword.addKeyListener(this);

     this.inilog.botonenter.setActionCommand("_enter");
     this.inilog.botonenter.setName("_enter");
     this.inilog.botonenter.addActionListener(this);

     this.inilog.botonolvidarpass.setActionCommand("_olvidarpass");
     this.inilog.botonolvidarpass.setName("_olvidarpass");
     this.inilog.botonolvidarpass.addActionListener(this);

     this.inilog.newusu.setActionCommand("_newusu");
     this.inilog.newusu.setName("_newusu");
     this.inilog.newusu.addActionListener(this);

     this.inilog.configEF.setActionCommand("_configurador");
     this.inilog.configEF.setName("_configurador");
     this.inilog.configEF.addActionListener(this);

     }
     //Reestablecer password
     if (i == 6) {

     this.recordar.setVisible(true);

     this.recordar.setTitle("Restablecer Password");
     this.recordar.setLocationRelativeTo(null);
     this.recordar.setSize(525, 425);//ancho x alto
     this.recordar.setResizable(false);
     Image icono = Toolkit.getDefaultToolkit().getImage("imagenes/new.png");
     this.recordar.setIconImage(icono);
     this.recordar.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada

     this.recordar.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
     recordar.addWindowListener(new WindowAdapter() {
     @Override
     public void windowClosing(WindowEvent e) {
     JOptionPane.showMessageDialog(null, "Ha cancelado la operacion");
     recordar.dispose();
     //new controladorEF(new Iniciologin(), 5).Iniciar(5);
     new controlador_login(new Iniciologin(), 5).Iniciar(5);

     }
     });

     this.recordar.txtlogin.setActionCommand("_RUSU");
     this.recordar.txtlogin.setName("_RUSU");
     this.recordar.txtlogin.addActionListener(this);
     this.recordar.txtlogin.addKeyListener(this);

     this.recordar.txtpassword.setActionCommand("_RPASS");
     this.recordar.txtpassword.setName("_RPASS");
     this.recordar.txtpassword.addActionListener(this);
     this.recordar.txtpassword.addKeyListener(this);

     this.recordar.botonreestablecer.setActionCommand("_RRESSTABLECER");
     this.recordar.botonreestablecer.setName("_RRESSTABLECER");
     this.recordar.botonreestablecer.addActionListener(this);

     this.recordar.botoncancelar.setActionCommand("_RCANCELAR");
     this.recordar.botoncancelar.setName("_RCANCELAR");
     this.recordar.botoncancelar.addActionListener(this);

     }

     }*/

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (Accion.valueOf(e.getActionCommand())) {

            //modulo login
            case _newusu:
                inilog.dispose();
                new controladorUSU(new CreaUsu(), 2).Iniciar(2);

                break;
            case _configurador:
                inilog.dispose();
                new controladorUSU(new configuracion(), 4).Iniciar(4);

                break;

            case _enter:
                boolean result;
                String dni,
                 password;
                dni = this.inilog.txtusuario.getText();
                password = this.inilog.txtpassword.getText();
                //String dni, String password
                loginBLL log = new loginBLL();
                result = log.loginusu(dni, password);
                if (result == true) {
                    inilog.dispose();
                    new controladorUSU(new interfaceUSUgrafica(), 1).Iniciar(1);
                } else {
                    JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos");
                }

                break;

            case _olvidarpass:
                inilog.dispose();
                //new controladorEF(new recordarcontraseña(), 6).Iniciar(6);
                new controlador_login(new Iniciologin(), 6).Iniciar(6);

                break;
            //resstablecer
            case _RCANCELAR:
                inilog.dispose();
                //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                new controlador_login(new Iniciologin(), 5).Iniciar(5);
                break;

            case _RRESSTABLECER:

                loginBLL rest = new loginBLL();
                rest.resstablecerpass();

                break;

            /*//subprincipal
             case _GESTIONEF:
             subpri.dispose();
             new controladorUSU(new interfaceUSUgrafica(), 1).Iniciar(1);
             break;

             case _CONFIGURACION:
             subpri.dispose();
             new controladorUSU(new configuracion(), 4).Iniciar(4);

             break;*/
            //interfaz
            case _BTN_ANTERIOR:
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox();
                break;
            case _BTN_SIGUIENTE:
                pagina.currentPageIndex += 1;
                pagina.initLinkBox();
                break;

            case _BTN_ULTIMO:
                pagina.currentPageIndex = pagina.maxPageIndex;
                pagina.initLinkBox();
                break;

            case _BTN_PRIMERO:
                pagina.currentPageIndex -= 1;
                pagina.initLinkBox();
                break;

            case _COMBOX:
                pagina.itemsPerPage = Integer.parseInt(jComboBox1.getSelectedItem().toString());
                pagina.currentPageIndex = 1;
                pagina.initLinkBox();
                break;

            case _GUARDAR:
                if (guardarjson.isSelected()) {
                    ((STMUSU) interfaceUSUgrafica.TABLA.getModel()).cargar();
                    empleados.librerias.json.generajsonEF();

                } else if (guardartxt.isSelected()) {
                    ((STMUSU) interfaceUSUgrafica.TABLA.getModel()).cargar();
                    empleados.librerias.txt.generatxtEF();

                } else if (guardarxml.isSelected()) {
                    ((STMUSU) interfaceUSUgrafica.TABLA.getModel()).cargar();
                    empleados.librerias.xml.generaxmlEF();

                }
                break;

            case _ELIMINAR:
                //Usuario pos = null;

                BLLUSUgrafica.eliminaUsuariograficatabla();

                break;

            case _NCREAR:
                usugraf.dispose();

                new controladorUSU(new CreaUsu(), 2).Iniciar(2);

                break;

            case _MODIFICAR:

                usugraf.dispose();
                new controladorUSU(new PerfilUsu(), 3).Iniciar(3);

                break;

            case _VOLVER:
                usugraf.dispose();
                JOptionPane.showMessageDialog(null, "Cerrando sesion, hasta pronto");
                //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                new controlador_login(new Iniciologin(), 5).Iniciar(5);
                //new subprincipal().setVisible(true);
                break;

            case _FILTRARUSU:
                STMUSU filtra = new STMUSU();
                filtra.filtrar();
                break;

            case _BTNMEDIA:
                BLLBD_USU usuario = new BLLBD_USU();

                usuario.EdadMediaBLL();

                break;

            case _BTNMAYMEN:
                BLLBD_USU usuariomedia = new BLLBD_USU();

                usuariomedia.Usuario_MenorMayorBLL();
                break;
            case _INFO:
                //((STMUSU) interfaceUSUgrafica.TABLA.getModel()).cargar();
                BLLUSUgrafica.masinfo();

                break;

            //menupager
            case _MENUEMPLEADOS:

                menpa.dispose();
                new controladorEF(new interfaceEFgrafica(), 1).Iniciar(1);

                break;
            case _MENUUSUARIOS:

                menpa.dispose();
                new controladorUSU(new interfaceUSUgrafica(), 1).Iniciar(1);

                break;
            //crea
            case _CREAREF:

                BLLUSUgrafica.crearUsuarioGrafica();
                break;

            case _BORRAR_CAMPOSEF:
                BLLUSUgrafica.BorrarcamposUsuarioCreagrafica();
                break;

            case _CANCELAR_CREAEF:
                /*BLLUSUgrafica.borrarcamporUsuarioModifica();
                 creaUSU.dispose();
                 //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                 new controlador_login(new Iniciologin(), 5).Iniciar(5);*/
                BLLUSUgrafica.BorrarcamposUsuarioCreagrafica();
                break;

            case _CargaAvatar:

                FileUploader.pintar_guardar_imag(this.creaUSU.labelavatar, 90, 90);

                break;

            //modifica
            case _MMODIFICA:

                BLLUSUgrafica.modificaUsugrafica();

                break;

            case _MCANCELAR:
                BLLUSUgrafica.borrarcamporUsuarioModifica();
                modiUSU.dispose();

                //new controladorUSU(new interfaceUSUgrafica(), 1).Iniciar(1);
                break;

            case _TABLAEF:
                pagina.currentPageIndex = 1;

                ((STMUSU) TABLA.getModel()).filtrar();
                break;

            case _NOMBREEF:
                BLLUSUgrafica.nombreUsuariografica();
                break;

            case _DEPARTAMENTOEF:
                BLLUSUgrafica.PoblacionUsugrafica();
                break;

            case _DNIEF:
                BLLUSUgrafica.dniUsugrafica();
                break;

            case _MNOMBRE:
                BLLUSUgrafica.ModificanombreUsuariografica();

                break;

            case _MDEPARTAMENTO:
                BLLUSUgrafica.ModificaPoblacionUsugrafica();

                break;

            case _MAvatar:
                FileUploader.pintar_guardar_imag(this.modiUSU.labelavatar, 90, 90);

                break;

            //config
            case _CVOLVER:
                configu.dispose();
                //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                new controlador_login(new Iniciologin(), 5).Iniciar(5);
                break;

            case _CEUROS:
                menuempleados.conf.setMoneda('€');
                break;

            case _CLIBRAS:
                menuempleados.conf.setMoneda('£');
                break;

            case _CDOLARES:
                menuempleados.conf.setMoneda('$');
                break;

            case _CUNDECI:
                menuempleados.conf.setDecimales(1);
                break;

            case _CDOSDECI:
                menuempleados.conf.setDecimales(2);
                break;

            case _CJSON:
                menuempleados.conf.setFichero(1);
                break;

            case _CXML:
                menuempleados.conf.setFichero(2);
                break;

            case _CTXT:
                menuempleados.conf.setFichero(3);
                break;

        }
    }

    @Override
    public void keyTyped(KeyEvent et) {
        switch (Accion.valueOf(et.getComponent().getName())) {

        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent em) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //_MNOMBRE,
        //_MDEPARTAMENTO,
        switch (Accion.valueOf(em.getComponent().getName())) {
            //modulo login
            case _usuario:
                loginBLL.Usuario();
                break;

            case _password:
                loginBLL.Password();
                break;

            case _TABLAEF:
                pagina.currentPageIndex = 1;

                ((STMUSU) TABLA.getModel()).filtrar();
                break;

            //crea
            case _NOMBREEF:
                BLLUSUgrafica.nombreUsuariografica();
                break;

            case _DEPARTAMENTOEF:
                BLLUSUgrafica.PoblacionUsugrafica();
                break;

            case _DNIEF:
                BLLUSUgrafica.dniUsugrafica();
                break;

            case _Email:
                BLLUSUgrafica.emailUsuariografica();
                break;

            case _Password:
                BLLUSUgrafica.passwordUsuariografica();
                break;

            case _Usuario:
                BLLUSUgrafica.loginUsuariografica();
                break;

            case _CargaAvatar:

                FileUploader.pintar_guardar_imag(this.creaUSU.labelavatar, 90, 90);

                break;
            //modifica
            case _MNOMBRE:
                BLLUSUgrafica.ModificanombreUsuariografica();

                break;

            case _MDEPARTAMENTO:
                BLLUSUgrafica.ModificaPoblacionUsugrafica();

                break;

            case _MEmail:
                BLLUSUgrafica.ModificaemailUsuariografica();
                break;

            case _MPassword:
                BLLUSUgrafica.ModificapasswordUsuariografica();
                break;

            case _MUsuario:
                BLLUSUgrafica.ModificaloginUsuariografica();
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent eh) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch (Accion.valueOf(eh.getComponent().getName())) {
            //modulo login
            case _usuario:
                if (eh.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginBLL.Usuario();
                }

                break;

            case _password:
                if (eh.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginBLL.Password();
                }

                break;
            //interfazEFgrafica
            case _TABLAEF:
                pagina.currentPageIndex = 1;

                ((STMUSU) TABLA.getModel()).filtrar();
                break;

            case _NOMBREEF:
                BLLUSUgrafica.nombreUsuariografica();
                break;

            case _DEPARTAMENTOEF:
                BLLUSUgrafica.PoblacionUsugrafica();
                break;

            case _DNIEF:
                BLLUSUgrafica.dniUsugrafica();
                break;

            case _MNOMBRE:
                BLLUSUgrafica.ModificanombreUsuariografica();
                //txtDepartamento.requestFocus();
                break;

            case _MDEPARTAMENTO:
                BLLUSUgrafica.ModificaPoblacionUsugrafica();
                //ModificarEF.requestFocus();
                break;

            case _CargaAvatar:

                FileUploader.pintar_guardar_imag(this.creaUSU.labelavatar, 90, 90);

                break;

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void comboActionPerformed(java.awt.event.ActionEvent evt) {
        System.out.println("word selected: " + ((JComboBox) combo).getSelectedItem());
    }

}
