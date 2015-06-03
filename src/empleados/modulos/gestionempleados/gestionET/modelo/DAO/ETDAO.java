package empleados.modulos.gestionempleados.gestionET.modelo.DAO;



import javax.swing.JOptionPane;

//import museo.Funciones;
import empleados.modulos.gestionempleados.gestionET.modelo.ordenaryclases.empleadotemporal;
import empleados.clases.fecha;
import empleados.palmentem.*;
import empleados.librerias.*;

public class ETDAO {

	public static empleadotemporal pidedatostemporal(){
		
		//public empleadotemporal(String nombre, String departamento, fecha fechaNacimiento, 
		//fecha fechaAlta, fecha fechaBaja)
	empleadotemporal et;
	String nombre, departamento, dni;
	fecha fechaNacimiento, fechaAlta, fechaBaja;
	//float sueldo;
	int diferencia=0, valida=0, val=0;
	boolean validar=true;
	
	nombre=pide.pidenombre();
	departamento=pide.pidedepartamento();
	do{//realizamos un control exaustivo de la fecha de nacimiento
	fechaNacimiento=pide.pidefecha("Fecha", "introduzca una fecha de nacimiento");
	valida=fechaNacimiento.compfechassystem();
	if ((valida==0)||(valida==1)){
		JOptionPane.showMessageDialog(null, "La fecha introducida es menor o igual a la actual, no se puede dar de alta");
	}
	}while (valida!=-1);
	
	
	do{//realizamos un control exaustivo de la fecha de contratacion
		fechaAlta=pide.pidefecha("Fecha", "introduzca una fecha de contratacion");
	diferencia=fechaAlta.restafechas(fechaNacimiento);
	if (diferencia<16){
		JOptionPane.showMessageDialog(null, "No tiene la edad para ser contratado");
	}
	}while (diferencia<16);
	
	do{
	fechaBaja=pide.pidefecha("Fecha", "introduzca una fecha de contratacion");
	val=fechaBaja.compfechas(fechaAlta);
	}while (val!=1);
	do{
		dni=Funciones.vstring("DNI", "Dame el DNI de la persona");
		validar=validate.dni(dni);
		if (validar!=true){
			JOptionPane.showMessageDialog(null, "EL DNI no mes correcto");
		}
		}while (validar!=true);
	
	
	
	
	et=new empleadotemporal (nombre, dni, departamento, fechaNacimiento, fechaAlta, fechaBaja, null, null, null, null, null);
	//ef=(nombre, edad, departamento, fechaNacimiento, sueldo, antiguedad, fechaContratacion);
	
	return et;
	
}

public static void cambiadatostemporal(empleadotemporal em){
	int op=0;
	float sueldo=0.0f;
	int edad=0, valida=0, diferencia=0;
	fecha compruebafecha;
	String[] tipo={"Nombre", "Departamento", "Fecha nacimiento", "Fecha de contratacion", "DNI", "Sueldo"};
	
	
		op=JOptionPane.showOptionDialog(null,
				"que desea modificar?","Inicio",0,
				JOptionPane.QUESTION_MESSAGE,null,tipo,tipo[0]);
		
		switch (op){
		case 0: em.setNombre(pide.pidenombre());
		break;
		case 1: em.setDepartamento(pide.pidedepartamento());
		break;
		case 2: 
			do{//realizamos un control exaustivo de la fecha de nacimiento
				em.setFechaNacimiento(pide.pidefecha("Fecha", "introduzca una fecha de nacimiento"));
				valida=em.getFechaNacimiento().compfechassystem();
				if ((valida==0)||(valida==1)){
					JOptionPane.showMessageDialog(null, "La fecha introducida es menor o igual a la actual, no se puede dar de alta");
				}
				}while (valida!=-1);
				
				em.cambiaedad(em.getFechaNacimiento());
		break;
		case 3: //modificar
			
			do{//realizamos un control exaustivo de la fecha de contratacion
				em.setFechaAlta(pide.pideantiguedad("Fecha", "introduzca una fecha de contratacion"));
				diferencia=em.getFechaAlta().restafechas(em.getFechaNacimiento());
				if (diferencia<16){
					JOptionPane.showMessageDialog(null, "No tiene la edad para ser contratado");
				}
				}while (diferencia<16);
			
			
				//edad=em.cambiarSalariotemporal(em.getFechaBaja());
				//em.setAntiguedad(edad);
		break;
		case 4: sueldo=em.calcularsueldotemporal();//recalculo sueldo
				em.setSueldo(sueldo);
		break;
		}
	
}
	
	
	
	
}
