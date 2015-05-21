package empleados.palmentem;

import empleados.menuempleados;
import java.util.Collections;

import javax.swing.JOptionPane;


//import empleados.modulos.gestionempleados.gestionEF.modelo.DAO.EFDAO;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.ArraylistEF;
/*import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.OrdenaEdad;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.OrdenaNombre;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.OrdenarAntiguedad;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.OrdenarFechaContrata;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.OrdenarFechaNac;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.OrdenarSueldo;
*/

public class menus {
	
	// combo box
	public static String cbox(String[] operaciones) {

		String op = "";

		Object seleccion = JOptionPane.showInputDialog(null, "Seleccione una opcion", "Selector de opciones",
				JOptionPane.QUESTION_MESSAGE, null, // null para icono defecto
				operaciones, operaciones[0]);
		if (seleccion == null) {
			// JOptionPane.showMessageDialog(null,"Saliendo de la aplicaci�n","Saliendo ...",JOptionPane.INFORMATION_MESSAGE);
			op = null;
		} else
			op = seleccion.toString();

		return op;
	}
	
	//Botones
	public static int botones (String[] operaciones){
		
		int op=0;
		String[] tipo={"","",""};
		String[] tipo1={"","",""};
		
		switch (op){
		
		case 0:
			break;
		case 1:
			break;
		default: op=3;
		}
		
		return op;
	}
	
	public static int menu(){//principal opciones
		int resp1;
		String[] tipo = { "empleado fijo", "empleado temporal", "Empleado por horas", "Configuracion", "Salir" };
		resp1 = JOptionPane.showOptionDialog(null,
		"Que tipo de empleado desea?","Inicio",0,
		JOptionPane.QUESTION_MESSAGE,null,tipo,tipo[0]);
		return resp1;
		}
	
	public static int menuprincipal(){//principal opciones
		int resp1;
		String[] tipo = { "empleado fijo", "Salir" };
		resp1 = JOptionPane.showOptionDialog(null,
		"Que opcion desea?","Inicio",0,
		JOptionPane.QUESTION_MESSAGE,null,tipo,tipo[0]);
		return resp1;
		}
	
	
	
	public static int menubusprincipal(){//secuandario para crear
		int resp1;
		String[] tipo1 = { "crear", "modificar", "Eliminar", "Buscar", "Ordenar", "Imprimir", "MAxMin", "Guardar", "Abrir", "Configuracion", "SueldoMedio", "Salir"};
		resp1 = JOptionPane.showOptionDialog(null,
		"Que operacion desea realizar?","Inicio",0,
		JOptionPane.QUESTION_MESSAGE,null,tipo1,tipo1[0]);
		return resp1;
		}
	
	
	
	public static int menuconfiguracion(){//para cambiar la configuracion
		int resp1;
		String[] tipo1 = { "Moneda", "Fecha", "Decimales", "Tema", "Fichero", "volver"};
		resp1 = JOptionPane.showOptionDialog(null,
		"Que operacion desea realizar?","Configuracion",0,
		JOptionPane.QUESTION_MESSAGE,null,tipo1,tipo1[0]);
		return resp1;
		}
	
	public static void menumoneda(){//para cambiar la moneda
		int resp1;
		String[] tipo1 = { "Euros", "Libras", "dolares"};
		resp1 = JOptionPane.showOptionDialog(null,
		"Que operacion desea realizar?","Moneda",0,
		JOptionPane.QUESTION_MESSAGE,null,tipo1,tipo1[0]);
		
		if(resp1 == 0)
			menuempleados.conf.setMoneda('€');
		else if(resp1 == 1)
			menuempleados.conf.setMoneda('£');
		else if(resp1 == 2)
			menuempleados.conf.setMoneda('$');
		
		}
	
	public static void menufecha(){//para cambiar la fecha
		int resp1;
		String[] tipo1 = { "dd/mm/yyyy", "mm/dd/yyyy", "yyyy/mm/dd"};
		resp1 = JOptionPane.showOptionDialog(null,
		"Que operacion desea realizar?","Fecha",0,
		JOptionPane.QUESTION_MESSAGE,null,tipo1,tipo1[0]);
		
		if(resp1 == 0)
			menuempleados.conf.setFormatofecha("dd/mm/yyyy");
		else if(resp1 == 1)
			menuempleados.conf.setFormatofecha("mm/dd/yyyy");
		else if(resp1 == 2)
			menuempleados.conf.setFormatofecha("yyyy/mm/dd");
		
		}
		
		
	
	public static int menutema(){//para cambiar el tema
		int resp1;
		String[] tipo1 = { "Metal", "WINDOWS", "Motif", "look&feel"};
		resp1 = JOptionPane.showOptionDialog(null,
		"Que operacion desea realizar?","Tema",0,
		JOptionPane.QUESTION_MESSAGE,null,tipo1,tipo1[0]);
		
		if(resp1 == 0){// Metal
			tema.temaElegido(0);
		}
		else if(resp1 == 1){// GTK - WINDOWS
			tema.temaElegido(1);
		}
		else if(resp1 == 2){// CDE/Motif
			tema.temaElegido(2);
		
		}
		else if(resp1 == 3){// Nimbus
			tema.temaElegido(3);
		
		}
		else if(resp1 == 4){//Obtener lista look&feel disponibles en el SO
			tema.temaElegido(4);
		
		}
		return resp1;
		}
	
	public static void menudecimales(){//para cambiar los decimales
		int resp1;
		String[] tipo1 = { "Un decima", "Dos decimales"};
		resp1 = JOptionPane.showOptionDialog(null,
		"Que operacion desea realizar?","Decimales",0,
		JOptionPane.QUESTION_MESSAGE,null,tipo1,tipo1[0]);
		
		if(resp1 == 0)
			menuempleados.conf.setDecimales(1);
		else if(resp1 == 1)
			menuempleados.conf.setDecimales(2);
		
		}
	
	public static String menubuscar(Object vMenu[], String mensaje){
		//Menú de opciones con combo-box
		String op = "";
		Object seleccion = JOptionPane.showInputDialog(null,mensaje,"Menú",JOptionPane.QUESTION_MESSAGE,null,  // null para icono defecto
		vMenu,"vMenu[0]");
		
			if(seleccion==null)			
				op = (String)"Salir";			
			else
				op = (String)seleccion;
			
		return op;
	}
	
	public static int imprimir(){//principal opciones
		int resp1;
		String[] tipo = { "empleado fijo", "empleado temporal", "Empleado por horas"};
		resp1 = JOptionPane.showOptionDialog(null,
		"Que tipo de empleado desea?","Imprimir",0,
		JOptionPane.QUESTION_MESSAGE,null,tipo,tipo[0]);
		return resp1;
		}
	
	public static int ordenarempleados(){
		int resp;
		String [] tipo= {"DNI", "Edad", "Nombre", "Antiguedad", "Contratacion", "Fecha Nacimiento", "Sueldo", "volver"};
		
		resp = JOptionPane.showOptionDialog(null,
				"Que desea ordenar?","Ordenar",0,
				JOptionPane.QUESTION_MESSAGE,null,tipo,tipo[0]);
				return resp;
	}
	
	public static int MaxMinEmpleados(){
		int resp;
		String [] tipo={"DNI", "Edad", "Nombre", "Antiguedad", "Contratacion", "Fecha Nacimiento", "Sueldo", "Volver"};
		resp = JOptionPane.showOptionDialog(null,
				"Que desea ordenar?","MaxMin",0,
				JOptionPane.QUESTION_MESSAGE,null,tipo,tipo[0]);
				return resp;
	}
	
	public static int GuardarAtesSalir(){
		int resp;
		String [] tipo={"Si", "No"};
		resp = JOptionPane.showOptionDialog(null,
				"Desea Guardar antes de Salir?","Guardar",0,
				JOptionPane.QUESTION_MESSAGE,null,tipo,tipo[0]);
				return resp;
	}
	
	public static void ElegirFichero(){
		int resp;
		String [] tipo={"JSON", "TXT", "XML"};
		resp = JOptionPane.showOptionDialog(null,
				"En que tipo de fichero desea trabajar?","Fichero",0,
				JOptionPane.QUESTION_MESSAGE,null,tipo,tipo[0]);
		
		if(resp == 0){
			menuempleados.conf.setFichero(1);
		}else if(resp == 1){
			menuempleados.conf.setFichero(2);
		}else if(resp == 2){
			menuempleados.conf.setFichero(3);
		}	
	}
	
	
	
}


