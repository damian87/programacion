/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.gestionempleados.gestionEF.controlador;

import empleados.librerias.FileUploader;
import empleados.librerias.fondopanelconfig;
import empleados.librerias.fondopanelcrear;
import empleados.librerias.fondopanelpager;
import empleados.menuempleados;
import empleados.modulos.config.configuracion;
import empleados.modulos.gestionempleados.gestionEF.modelo.BLL.BLLBD_EF;
import empleados.modulos.gestionempleados.gestionEF.modelo.BLL.EFBLLgrafica;
import empleados.modulos.login.modelo_log.BLL_LOG.loginBLL;
import empleados.modulos.gestionempleados.gestionEF.modelo.DAO.DAOEFgrafica;
import static empleados.modulos.gestionempleados.gestionEF.modelo.DAO.DAOEFgrafica.modificaEFgraficallenadodatosPerfil;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.SingletonsEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.STMEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica;
import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.TABLA;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import empleados.modulos.gestionempleados.gestionEF.modelo.pager.pagina1;
import empleados.modulos.gestionempleados.gestionEF.vista.AutocompleteJComboBox;
import empleados.modulos.gestionempleados.gestionEF.vista.StringSearchable;
import empleados.modulos.gestionempleados.gestionEF.vista.creaEFgrafica;
import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.TABLA;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.combo;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.comboActionPerformed;
import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.guardarjson;
import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.guardartxt;
import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.guardarxml;
import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.jComboBox1;
import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.jTextField1;
//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.sorter;
import empleados.modulos.gestionempleados.gestionEF.vista.modificaEFgrafica;
import static empleados.modulos.gestionempleados.gestionEF.vista.modificaEFgrafica.ModificarEF;
import static empleados.modulos.gestionempleados.gestionEF.vista.modificaEFgrafica.txtDepartamento;
import empleados.modulos.gestionempleados.gestionEF.vista.recordarcontraseña;
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
public class controladorEF implements ActionListener, KeyListener, MouseListener {

    public static TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(new STMEF());
    public static AutocompleteJComboBox combo = null;
    public static interfaceEFgrafica efgraf = new interfaceEFgrafica();
    //public static subprincipal subpri = new subprincipal();
    public static creaEFgrafica creaEF = new creaEFgrafica();
    public static modificaEFgrafica modief = new modificaEFgrafica();
    public static configuracion configu = new configuracion();
    public static Iniciologin inilog = new Iniciologin();
    public static recordarcontraseña recordar = new recordarcontraseña();

    public controladorEF(JFrame inicio, int i) {
        /*if (i == 0) {
            this.subpri = (subprincipal) inicio;
        }*/

        if (i == 1) {
            this.efgraf = (interfaceEFgrafica) inicio;
        }

        if (i == 2) {
            this.creaEF = (creaEFgrafica) inicio;
        }

        if (i == 3) {
            this.modief = (modificaEFgrafica) inicio;
        }

        if (i == 4) {
            this.configu = (configuracion) inicio;
        }

        if (i == 5) {
            this.inilog = (Iniciologin) inicio;
        }
        if (i == 6) {
            this.recordar = (recordarcontraseña) inicio;
        }

    }

    public enum Accion {

        //BOTONES PAGER
        _BTN_ANTERIOR,
        _BTN_SIGUIENTE,
        _BTN_ULTIMO,
        _BTN_PRIMERO,
        _BUSCAR,
        _COMBOX,
        _FILTRAREF,
        _TABLAEF,
        _GUARDAR,
        _ELIMINAR,
        _NCREAR,
        _MODIFICAR,
        _VOLVER,
        _BTNMEDIA,
        _BTNMAYMEN,
        _INFO,
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
        _RCANCELAR
    }

    //en el new controladorEF (new interfaceEFgrafica(), 0).Iniciar(0);
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

            //interfazEFgrafica
            this.efgraf.setVisible(true);

            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }

            //initComponents();    
            this.efgraf.setLocationRelativeTo(null);
            this.efgraf.setTitle("GestionEmpleados Fijos");
            this.efgraf.setResizable(true);
            fondopanelpager c = new fondopanelpager();
            this.efgraf.setContentPane(c);
            this.efgraf.jPanel6.setOpaque(false);
            c.add(this.efgraf.jPanel6);
            //this.efgraf.setSize(525, 425);//ancho x alto
            this.efgraf.jPanel1.setOpaque(false);
            this.efgraf.jPanel2.setOpaque(false);
            this.efgraf.jPanel3.setOpaque(false);
            this.efgraf.jPanel4.setOpaque(false);
            this.efgraf.jPanel5.setOpaque(false);

            TABLA.setModel(new STMEF());
            ((STMEF) interfaceEFgrafica.TABLA.getModel()).cargar();
            TABLA.setFillsViewportHeight(true);
            TABLA.setRowSorter(sorter);

            pagina1.inicializa();
            pagina1.initLinkBox();

            this.efgraf.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            this.efgraf.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    efgraf.dispose();
                    //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                    new controlador_login(new Iniciologin(), 5).Iniciar(5);

                }
            });

            List<String> myWords = new ArrayList<String>();
            for (int e = 0; e <= SingletonsEF.ef.size() - 1; e++) {
                myWords.add(SingletonsEF.ef.get(e).getNombre());
            }

            StringSearchable searchable = new StringSearchable(myWords);
            combo = new AutocompleteJComboBox(searchable);
            this.efgraf.jPanel3.setLayout(new java.awt.BorderLayout());
            this.efgraf.jPanel3.add(combo);
            this.efgraf.jPanel3.setVisible(false);

            combo.addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    comboActionPerformed(evt);
                }
            });

            this.efgraf.guardartxt.doClick();

            FileUploader.pintaravatar(this.efgraf.labelavatar, 90, 90);

            this.efgraf.ANTERIOR.setActionCommand("_BTN_ANTERIOR");
            this.efgraf.ANTERIOR.setName("_BTN_ANTERIOR");
            this.efgraf.ANTERIOR.addActionListener(this);

            this.efgraf.SIGUIENTE.setActionCommand("_BTN_SIGUIENTE");
            this.efgraf.SIGUIENTE.setName("_BTN_SIGUIENTE");
            this.efgraf.SIGUIENTE.addActionListener(this);

            this.efgraf.ultimo.setActionCommand("_BTN_ULTIMO");
            this.efgraf.ultimo.setName("_BTN_ULTIMO");
            this.efgraf.ultimo.addActionListener(this);

            this.efgraf.primero.setActionCommand("_BTN_PRIMERO");
            this.efgraf.primero.setName("_BTN_PRIMERO");
            this.efgraf.primero.addActionListener(this);

            this.efgraf.jTextField1.setActionCommand("_FILTRAREF");
            this.efgraf.jTextField1.setName("_FILTRAREF");
            this.efgraf.jTextField1.addActionListener(this);

            this.efgraf.jComboBox1.setActionCommand("_COMBOX");
            this.efgraf.jComboBox1.setName("_COMBOX");
            this.efgraf.jComboBox1.addActionListener(this);

            this.efgraf.botonarchivoEF.setActionCommand("_GUARDAR");
            this.efgraf.botonarchivoEF.setName("_GUARDAR");
            this.efgraf.botonarchivoEF.addActionListener(this);

            this.efgraf.jButton1.setActionCommand("_VOLVER");
            this.efgraf.jButton1.setName("_VOLVER");
            this.efgraf.jButton1.addActionListener(this);

            this.efgraf.botonedadmedia.setActionCommand("_BTNMEDIA");
            this.efgraf.botonedadmedia.setName("_BTNMEDIA");
            this.efgraf.botonedadmedia.addActionListener(this);

            this.efgraf.botonmayormenor.setActionCommand("_BTNMAYMEN");
            this.efgraf.botonmayormenor.setName("_BTNMAYMEN");
            this.efgraf.botonmayormenor.addActionListener(this);

            this.efgraf.info.setActionCommand("_INFO");
            this.efgraf.info.setName("_INFO");
            this.efgraf.info.addActionListener(this);

            if ("User".equals(SingletonsEF.efilogin.getTipo())) {

                this.efgraf.botonnuevoEF.setVisible(false);
                this.efgraf.botonmodificarEF.setVisible(false);
                this.efgraf.botoneliminarEF.setVisible(false);
            } else {
                this.efgraf.botonnuevoEF.setActionCommand("_NCREAR");
                this.efgraf.botonnuevoEF.setName("_NCREAR");
                this.efgraf.botonnuevoEF.addActionListener(this);

                this.efgraf.botoneliminarEF.setActionCommand("_ELIMINAR");
                this.efgraf.botoneliminarEF.setName("_ELIMINAR");
                this.efgraf.botoneliminarEF.addActionListener(this);

                this.efgraf.botonmodificarEF.setActionCommand("_MODIFICAR");
                this.efgraf.botonmodificarEF.setName("_MODIFICAR");
                this.efgraf.botonmodificarEF.addActionListener(this);

            }

        }

        if (i == 2) {
            //creaEFgrafica

            this.creaEF.setVisible(true);
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
            }
            this.creaEF.setTitle("Alta Empleado Fijo");
            this.creaEF.setLocationRelativeTo(null);

            this.creaEF.setResizable(false);
            //Image icono=Toolkit.getDefaultToolkit().getImage("imagenes/new.png");
            //this.creaEF.setIconImage(icono);
            this.creaEF.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada
            fondopanelcrear c = new fondopanelcrear();
            this.creaEF.setContentPane(c);
            this.creaEF.jPanel1.setOpaque(false);
            this.creaEF.jPanel2.setOpaque(false);
            c.add(this.creaEF.jPanel1);
            //this.creaEF.setSize(525, 425);//ancho x alto
            
            this.creaEF.txtdniEF.setVisible(false);

            this.creaEF.Usuario.doClick();
            this.creaEF.jPanel2.setVisible(false);
            this.creaEF.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            creaEF.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    creaEF.dispose();
                    //EFBLLgrafica.GuardarSinEnterarse();
                    //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                    new controlador_login(new Iniciologin(), 5).Iniciar(5);
                }
            });

            this.creaEF.CrearEF.setActionCommand("_CREAREF");
            this.creaEF.CrearEF.setName("_CREAREF");
            this.creaEF.CrearEF.addActionListener(this);

            this.creaEF.BorrarEF.setActionCommand("_BORRAR_CAMPOSEF");
            this.creaEF.BorrarEF.setName("_BORRAR_CAMPOSEF");
            this.creaEF.BorrarEF.addActionListener(this);

            this.creaEF.CancelarEF.setActionCommand("_CANCELAR_CREAEF");
            this.creaEF.CancelarEF.setName("_CANCELAR_CREAEF");
            this.creaEF.CancelarEF.addActionListener(this);

            this.creaEF.txtNombreEF.setActionCommand("_NOMBREEF");
            this.creaEF.txtNombreEF.setName("_NOMBREEF");
            this.creaEF.txtNombreEF.addKeyListener(this);

            this.creaEF.txtDepartamentoEF.setActionCommand("_DEPARTAMENTOEF");
            this.creaEF.txtDepartamentoEF.setName("_DEPARTAMENTOEF");
            this.creaEF.txtDepartamentoEF.addKeyListener(this);

            /*this.creaEF.txtdniEF.setActionCommand("_DNIEF");
            this.creaEF.txtdniEF.setName("_DNIEF");
            this.creaEF.txtdniEF.addKeyListener(this);*/
            
            this.creaEF.txtDNIEF.setActionCommand("_DNIEF");
            this.creaEF.txtDNIEF.setName("_DNIEF");
            this.creaEF.txtDNIEF.addKeyListener(this);                        

            this.creaEF.txtemail.setActionCommand("_Email");
            this.creaEF.txtemail.setName("_Email");
            this.creaEF.txtemail.addKeyListener(this);

            this.creaEF.txtpassword.setActionCommand("_Password");
            this.creaEF.txtpassword.setName("_Password");
            this.creaEF.txtpassword.addKeyListener(this);

            this.creaEF.txtlogin.setActionCommand("_Usuario");
            this.creaEF.txtlogin.setName("_Usuario");
            this.creaEF.txtlogin.addKeyListener(this);

            this.creaEF.cargarimgavatar.setActionCommand("_CargaAvatar");
            this.creaEF.cargarimgavatar.setName("_CargaAvatar");
            this.creaEF.cargarimgavatar.addKeyListener(this);

            if (SingletonsEF.efilogin == null) {
                this.creaEF.jPanel2.setVisible(false);
            } else if ("admin".equals(SingletonsEF.efilogin.getTipo())) {
                this.creaEF.jPanel2.setVisible(true);
            }

            //FALTAN COLOCAR LOS KEYPRESSET Y KEYRELEASSED
        }

        if (i == 3) {
            //modificaEFgrafica

            this.modief.setVisible(true);

            this.modief.setTitle("Modifcar Empleado Fijo");
            this.modief.setLocationRelativeTo(null);
            this.modief.setSize(525, 425);//ancho x alto
            this.modief.setResizable(false);
            java.awt.Image icono = java.awt.Toolkit.getDefaultToolkit().getImage("imagenes/modificar.png");
            this.modief.setIconImage(icono);
            this.modief.setExtendedState(JFrame.MAXIMIZED_BOTH); //la aplicación se abre maximizada
            fondopanelcrear c = new fondopanelcrear();
            this.modief.setContentPane(c);
            this.modief.jPanel1.setOpaque(false);
            c.add(this.modief.jPanel1);

            if ("User".equals(SingletonsEF.efilogin.getTipo())) {
                DAOEFgrafica.modificaEFgraficallenadodatosPerfil();
                FileUploader.pintaravatar(this.modief.labelavatar, 90, 90);
            } else {

                EFBLLgrafica.modificaEFgraficallenacampos();
                FileUploader.pintaravataref(this.modief.labelavatar, 90, 90);
            }
            this.modief.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            modief.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    modief.dispose();

                    //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                    new controlador_login(new Iniciologin(), 5).Iniciar(5);
                }
            });

            this.modief.txtedad.setEditable(false);
            this.modief.txtantiguedad.setEditable(false);
            this.modief.txtsueldo.setEditable(false);

            this.modief.ModificarEF.setActionCommand("_MMODIFICA");
            this.modief.ModificarEF.setName("_MMODIFICA");
            this.modief.ModificarEF.addActionListener(this);

            this.modief.CancelarEF.setActionCommand("_MCANCELAR");
            this.modief.CancelarEF.setName("_MCANCELAR");
            this.modief.CancelarEF.addActionListener(this);

            this.modief.txtNombre.setActionCommand("_MNOMBRE");
            this.modief.txtNombre.setName("_MNOMBRE");
            this.modief.txtNombre.addActionListener(this);
            this.modief.txtNombre.setActionCommand("_MNOMBRE");
            this.modief.txtNombre.addKeyListener(this);

            this.modief.txtDepartamento.setActionCommand("_MDEPARTAMENTO");
            this.modief.txtDepartamento.setName("_MDEPARTAMENTO");
            this.modief.txtDepartamento.addActionListener(this);
            this.modief.txtDepartamento.setActionCommand("_MDEPARTAMENTO");
            this.modief.txtDepartamento.addKeyListener(this);

            this.modief.txtemail.setActionCommand("_MEmail");
            this.modief.txtemail.setName("_MEmail");
            this.modief.txtemail.addActionListener(this);
            this.modief.txtemail.addKeyListener(this);

            this.modief.txtpassword.setActionCommand("_MPassword");
            this.modief.txtpassword.setName("_MPassword");
            this.modief.txtpassword.addActionListener(this);
            this.modief.txtpassword.addKeyListener(this);

            this.modief.txtlogin.setActionCommand("_MUsuario");
            this.modief.txtlogin.setName("_MUsuario");
            this.modief.txtlogin.addActionListener(this);
            this.modief.txtlogin.addKeyListener(this);

            this.modief.cargarimgavatar.setActionCommand("_MAvatar");
            this.modief.cargarimgavatar.setName("_MAvatar");
            this.modief.cargarimgavatar.addActionListener(this);

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

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (Accion.valueOf(e.getActionCommand())) {

            //subprincipal
            /*case _GESTIONEF:
                subpri.dispose();
                new controladorEF(new interfaceEFgrafica(), 1).Iniciar(1);
                break;

            case _CONFIGURACION:
                subpri.dispose();
                new controladorEF(new configuracion(), 4).Iniciar(4);

                break;*/
            //interfaz
            case _BTN_ANTERIOR:
                pagina1.currentPageIndex -= 1;
                pagina1.initLinkBox();
                break;
            case _BTN_SIGUIENTE:
                pagina1.currentPageIndex += 1;
                pagina1.initLinkBox();
                break;

            case _BTN_ULTIMO:
                pagina1.currentPageIndex = pagina1.maxPageIndex;
                pagina1.initLinkBox();
                break;

            case _BTN_PRIMERO:
                //pagina1.currentPageIndex -= 1;
                pagina1.currentPageIndex -= pagina1.maxPageIndex - 1;
                pagina1.initLinkBox();
                break;

            case _FILTRAREF:
                STMEF filtra = new STMEF();
                filtra.filtrar();
                break;
            case _COMBOX:
                pagina1.itemsPerPage = Integer.parseInt(jComboBox1.getSelectedItem().toString());
                pagina1.currentPageIndex = 1;
                pagina1.initLinkBox();
                break;

            case _GUARDAR:
                if (guardarjson.isSelected()) {
                    ((STMEF) interfaceEFgrafica.TABLA.getModel()).cargar();
                    empleados.librerias.json.generajsonEF();

                } else if (guardartxt.isSelected()) {
                    ((STMEF) interfaceEFgrafica.TABLA.getModel()).cargar();
                    empleados.librerias.txt.generatxtEF();

                } else if (guardarxml.isSelected()) {
                    ((STMEF) interfaceEFgrafica.TABLA.getModel()).cargar();
                    empleados.librerias.xml.generaxmlEF();

                }
                break;

            case _ELIMINAR:
                empleadofijo pos = null;

                EFBLLgrafica.eliminaEFgraficatabla();

                break;

            case _NCREAR:
                efgraf.dispose();

                new controladorEF(new creaEFgrafica(), 2).Iniciar(2);

                break;

            case _MODIFICAR:

                efgraf.dispose();
                new controladorEF(new modificaEFgrafica(), 3).Iniciar(3);

                break;

            case _VOLVER:
                efgraf.dispose();
                JOptionPane.showMessageDialog(null, "Cerrando sesion, hasta pronto");
                //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                new controlador_login(new Iniciologin(), 5).Iniciar(5);
                //new subprincipal().setVisible(true);
                break;

            case _BTNMEDIA:
                BLLBD_EF empleado = new BLLBD_EF();

                empleado.EdadMediaBLL();

                break;

            case _BTNMAYMEN:
                BLLBD_EF empleadomedia = new BLLBD_EF();

                empleadomedia.EF_MenorMayorBLL();
                break;
            case _INFO:
                //((STMEF) interfaceEFgrafica.TABLA.getModel()).cargar();
                EFBLLgrafica.masinfo();

                break;

            //crea
            case _CREAREF:

                EFBLLgrafica.crearEFgrafica();
                break;

            case _BORRAR_CAMPOSEF:
                EFBLLgrafica.borrarcamporEFgrafica();
                break;

            case _CANCELAR_CREAEF:
                EFBLLgrafica.borrarcamporEFgrafica();

                break;

            case _CargaAvatar:

                FileUploader.pintar_guardar_imag(this.creaEF.labelavatar, 90, 90);

                break;

            //modifica
            case _MMODIFICA:

                EFBLLgrafica.modificaEFgrafica();

                break;

            case _MCANCELAR:
                EFBLLgrafica.borrarcamporEFModifica();

                break;

            case _TABLAEF:
                pagina1.currentPageIndex = 1;

                ((STMEF) TABLA.getModel()).filtrar();
                break;

            case _NOMBREEF:
                EFBLLgrafica.nombreEFgrafica();
                break;

            case _DEPARTAMENTOEF:
                EFBLLgrafica.departamentoEFgrafica();
                break;

            case _DNIEF:
                EFBLLgrafica.dniEFgrafica();
                break;

            case _MNOMBRE:
                DAOEFgrafica.modificanombreEFgrafica();

                break;

            case _MDEPARTAMENTO:
                DAOEFgrafica.modificadepartamentoEFgrafica();

                break;

            case _MAvatar:
                FileUploader.pintar_guardar_imag(this.modief.labelavatar, 90, 90);

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
                pagina1.currentPageIndex = 1;

                ((STMEF) TABLA.getModel()).filtrar();
                break;

            //interfazEF
            case _FILTRAREF:
                STMEF filtra = new STMEF();
                filtra.filtrar();
                break;

            //crea
            case _NOMBREEF:
                EFBLLgrafica.nombreEFgrafica();
                break;

            case _DEPARTAMENTOEF:
                EFBLLgrafica.departamentoEFgrafica();
                break;

            case _DNIEF:
                EFBLLgrafica.dniEFgrafica();
                break;

            case _Email:
                EFBLLgrafica.emailEFgrafica();
                break;

            case _Password:
                EFBLLgrafica.passwordEFgrafica();
                break;

            case _Usuario:
                EFBLLgrafica.UsuarioEFgrafica();
                break;

            case _CargaAvatar:

                FileUploader.pintar_guardar_imag(this.creaEF.labelavatar, 90, 90);

                break;
            //modifica
            case _MNOMBRE:
                DAOEFgrafica.modificanombreEFgrafica();

                break;

            case _MDEPARTAMENTO:
                DAOEFgrafica.modificadepartamentoEFgrafica();

                break;

            case _MEmail:
                DAOEFgrafica.modificaemail();
                break;

            case _MPassword:
                DAOEFgrafica.modificapassword();
                break;

            case _MUsuario:
                DAOEFgrafica.modificausuariologin();
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
                pagina1.currentPageIndex = 1;

                ((STMEF) TABLA.getModel()).filtrar();
                break;

            case _NOMBREEF:
                EFBLLgrafica.nombreEFgrafica();
                break;

            case _DEPARTAMENTOEF:
                EFBLLgrafica.departamentoEFgrafica();
                break;

            case _DNIEF:
                EFBLLgrafica.dniEFgrafica();
                break;

            case _MNOMBRE:
                DAOEFgrafica.modificanombreEFgrafica();
                //txtDepartamento.requestFocus();
                break;

            case _MDEPARTAMENTO:
                DAOEFgrafica.modificadepartamentoEFgrafica();
                //ModificarEF.requestFocus();
                break;

            case _CargaAvatar:

                FileUploader.pintar_guardar_imag(this.creaEF.labelavatar, 90, 90);

                break;
            
            case _FILTRAREF:
                STMEF filtra = new STMEF();
                filtra.filtrar();
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
