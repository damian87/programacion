package empleados;

import empleados.clases.*;
import empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF;
import empleados.modulos.login.vista_log.Signin;
import empleados.modulos.login.controlador_log.controlador_login;

public class Mainapli {

	public static configuracion conf=null;

	public static void main(String[] args) {

            conf=new configuracion();

            //new subprincipal().setVisible(true);
            //new controladorEF(new Iniciologin(), 5).Iniciar(5);
            new controlador_login(new Signin(), 5).Iniciar(5);

	}
}

	



