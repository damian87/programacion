package empleados.palmentem;
import empleados.clases.fecha;
import empleados.librerias.Funciones;
import empleados.librerias.validate;

import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

public class pide {

	public static String pidenombre(){
		
		String nombre;
		boolean valida;
		
		do{
		nombre=Funciones.vstring("Nombre", "Dame el nombre de la persona");
		valida=validate.validateNombre(nombre);
		}while (valida!=true);
		
		return nombre;
		
	}
	
	public static String pideapellidos(){
		
		String apellidos;
		boolean valida;
		
		do{
		apellidos=Funciones.vstring("Apellidos", "Dame los apellidos de la persona");
		valida=validate.validateApellidos(apellidos);
		}while (valida!=true);
		
		return apellidos;
		
	}
	
	public static String pidedireccion(){
	
	String direccion;
	boolean valida;
	
	do{
	direccion=Funciones.vstring("Direccion", "Dame la direccion de la persona");
	valida=validate.direccion(direccion);
	}while (valida!=true);
	
	return direccion;
	
}



	public static String pidedni(){
		
		String dni;
		boolean valida;
		do{
			dni=Funciones.vstring("DNI", "Dame el dni del titular");
			valida=validate.validaDNI(dni);
			if (valida!=true){
				JOptionPane.showMessageDialog(null, "EL DNI no mes correcto");
			}
		}while (valida!=true);
		return dni;
	}
	
	public static String pidepoblacion(){
		
		String poblacion;
		
		poblacion=Funciones.vstring("Poblacion", "Dame la pobacion donde reside la persona");
		
		return poblacion;
		
	}

	public static String pidecodigopostal(){
		
		String cp;
		boolean valida;
		
		do{
		cp=Funciones.vstring("Codigo Postal", "Dame el Codigo Postal de la poblacion de la persona");
		valida=validate.validateCodigoPostal(cp);
		}while (valida!=true);
		
		return cp;
		
	}


	public static fecha pidefecha(String titulo, String mensaje){
		
		String data;
		boolean val1, valida;
		fecha c2=null;
		do{
			data="";
			do{
		data=Funciones.vstring(titulo, mensaje);
		val1=validate.fecha(data);
			}while (val1 !=false);
			
		c2=new fecha(data);
		
		valida=c2.compruebafecha();
		
		if (valida==false){
			JOptionPane.showMessageDialog(null, "introduzca una fecha correcta");
		}
		}while (valida!=true);
		return c2;
	
	}
	
	public static String pidedepartamento(){
		
		String dp;
		
		dp=Funciones.vstring("Departamento", "Dame el departamento donde trabaja el empleado");
		
		return dp;
		
	}
	
	
	public static fecha pideantiguedad(String titulo, String mensaje){
		
		String data;
		boolean val1, valida, val=false;
		int resta=0;
		fecha c2=null;
		
		do{
		do{
			data="";
			do{
				
		data=Funciones.vstring("Inicio", "Dame la fecha de inicio de contratacion (--/--/----)");
		val1=validate.fecha(data);

			}while ((val1 !=false));

			c2=new fecha(data);
			valida=c2.compruebafecha();
			if (valida==false){
				JOptionPane.showMessageDialog(null, "introduzca una fecha correcta");
			}
			}while (valida!=true);
			
		resta=c2.calcularedad();
		
		if (resta<=65){
			val=true;
		}
		else{
		val=false;
		}
		}while (val!=true);
	
		return c2;
		
	}
	
	public static Float pidesueldofijo(){
		
		float sueldo;
		
		sueldo=Funciones.vfloat("Sueldo", "Dame el sueldo anual del trabajador");
		
		return sueldo;
		
	}
	
	public static Float pidesueldotemporal(){
		
		float sueldo;
		
		sueldo=Funciones.vfloat("Sueldo", "Dame el sueldo anual del trabajador");
		
		return sueldo;
		
	}

	public static Float pidesueldohoras(){
		
		float sueldo;
		
		sueldo=Funciones.vfloat("Sueldo", "Dame el sueldo por hora del trabajador");
		
		return sueldo;
		
	}
	public static boolean dni(String titulo, String mensaje){
		String Dni;
		boolean valida;
		
		do{
		Dni=Funciones.vstring("DNI", "dAME EL DNI de la persona");
		valida=validate.dni(Dni);
		if (valida!=true){
			JOptionPane.showMessageDialog(null, "EL DNI no mes correcto");
		}
		}while (valida!=true);
		return valida;
	}
	
	
	
	/*public static boolean compruebafecha (fecha a){
		
		boolean val1, val2, val3;
		
		GregorianCalendar calendar = new GregorianCalendar();
		
		
		int[] dias =	{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if (calendar.isLeapYear(a.getAño())){
			dias[2]	= 29;
		}
		
		
		if ((a.getDia()>=1)&&(a.getDia()<= dias [a.getMes()])){
			val1=true;
		}
		else{
			val1=false;
		}
		
		if ((a.getMes()>=1)&&(a.getMes()<=12)){
			val2=true;
		}
		else{
			val2=false;
		}
		
		if ((a.getAño()>=1947)&&(a.getAño()<=2015)){
		
			val3=true;
		}
		else{
			val3=false;
		}
		
		if ((val1==true)&&(val2==true)&&(val3==true)){
			return true;
		}
		else{
			return false;
		}
		
	}*/
	
	
	
}
