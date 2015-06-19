/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.login.controlador_log;

import empleados.librerias.fondopanellogin;
import empleados.modulos.Usuarios.gestionusuarios.controlador.controladorUSU;
import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.SingletonsUsu;
import empleados.modulos.Usuarios.gestionusuarios.vista.CreaUsu;
import empleados.modulos.Usuarios.gestionusuarios.vista.PerfilUsu;
import empleados.modulos.config.configuracion;
import empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.SingletonsEF;
//import static empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF.inilog;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.STMEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.pager.pagina1;
//import static empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF.inilog;
//import static empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF.recordar;
import static empleados.modulos.login.controlador_log.controlador_login.inilog;
import static empleados.modulos.login.controlador_log.controlador_login.recordar;
import empleados.modulos.gestionempleados.gestionEF.vista.creaEFgrafica;
import empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica;
import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.TABLA;
import empleados.modulos.Usuarios.gestionusuarios.vista.menupager;
import empleados.modulos.gestionempleados.gestionEF.vista.modificaEFgrafica;
import empleados.modulos.login.vista_log.recordarcontraseña;
import empleados.modulos.login.modelo_log.BLL_LOG.loginBLL;
import empleados.modulos.login.vista_log.Signin;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
 *
 * @author Usuario
 */
public class controlador_login implements ActionListener, KeyListener, MouseListener {

    public static Signin inilog = new Signin();
    public static recordarcontraseña recordar = new recordarcontraseña();

    public controlador_login(JFrame inicio, int i) {
        if (i == 5) {
            this.inilog = (Signin) inicio;
        }
        if (i == 6) {
            this.recordar = (recordarcontraseña) inicio;
        }

    }

    public enum Accion {

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

    public void Iniciar(int i) {
        //modulo de inicio login

        if (i == 5) {

            this.inilog.setVisible(true);

            this.inilog.setTitle("Bienvenidos a la Gestion de Empleados");
            this.inilog.setLocationRelativeTo(null);
            Image icono = Toolkit.getDefaultToolkit().getImage("imagenes/new.png");
            this.inilog.setIconImage(icono);
            fondopanellogin c = new fondopanellogin();
            this.inilog.setContentPane(c);
            this.inilog.jPanel1.setOpaque(false);
            c.add(this.inilog.jPanel1);
            this.inilog.setSize(525, 425);//ancho x alto
            this.inilog.setResizable(false);

            SingletonsEF.efilogin = null; //vaciamos el objeto
            SingletonsUsu.usulogin = null; //vaciamos el objeto

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
            fondopanellogin c = new fondopanellogin();
            this.recordar.setContentPane(c);
            this.recordar.jPanel1.setOpaque(false);
            c.add(this.recordar.jPanel1);

            this.recordar.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            recordar.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Ha cancelado la operacion");
                    recordar.dispose();
                    new controladorEF(new Signin(), 5).Iniciar(5);

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
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        switch (Accion.valueOf(ae.getActionCommand())) {

            //modulo login
            case _newusu:
                inilog.dispose();
                //new controladorEF(new creaEFgrafica(), 2).Iniciar(2);
                new controladorUSU(new CreaUsu(), 2).Iniciar(2);

                break;
            case _configurador:
                inilog.dispose();
                new controladorEF(new configuracion(), 4).Iniciar(4);

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
                    //if ("User".equals(SingletonsEF.efilogin.getTipo())) {
                    if ("User".equals(SingletonsUsu.usulogin.getTipo())) {  
                     
                        //new controladorEF(new modificaEFgrafica(), 3).Iniciar(3);
                        new controladorUSU(new PerfilUsu(), 3).Iniciar(3);
                    } else {
                    //new controladorEF(new interfaceEFgrafica(), 1).Iniciar(1);  
                        //new controladorEF(new menupager(), 5).Iniciar(5); 
                        new controladorUSU(new menupager(), 5).Iniciar(5);
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El usuario o contraseña son incorrectos");
                }

                break;

            case _olvidarpass:
                inilog.dispose();
                //new controladorEF(new recordarcontraseña(), 6).Iniciar(6);
                new controlador_login(new recordarcontraseña(), 6).Iniciar(6);

                break;
            //resstablecer
            case _RCANCELAR:
                recordar.dispose();
                //new controladorEF(new Iniciologin(), 5).Iniciar(5);
                new controlador_login(new Signin(), 5).Iniciar(5);
                break;

            case _RRESSTABLECER:

                loginBLL rest = new loginBLL();
                rest.resstablecerpass();

                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch (Accion.valueOf(ke.getComponent().getName())) {

        }
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        switch (Accion.valueOf(ke.getComponent().getName())) {
            //modulo login
            case _usuario:
                loginBLL.Usuario();
                break;

            case _password:
                loginBLL.Password();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        //switch (Accion.valueOf(ke.getComponent().getName())){
        switch (Accion.valueOf(ke.getComponent().getName())) {
            //modulo login
            case _usuario:
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginBLL.Usuario();
                }

                break;

            case _password:
                if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
                    loginBLL.Password();
                }

                break;
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
