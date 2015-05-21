package empleados.modulos.gestionempleados.gestionEH.modelo.DAO;


import empleados.modulos.gestionempleados.gestionEH.modelo.ordenaryclases.*;

import empleados.clases.*;
import empleados.palmentem.*;

public class dummieseh {
	
	//empleado por horas
		private static String nom [] = {"Carlos", "Ximo", "Vicente", "Lluis", "Victor"};
		private static String Depart [] = {"Informatica", "Oficina", "Informatica", "Mantenimiento", "Oficina"};
		private static fecha FecNac [] = {new fecha("27/5/1975", '1'), new fecha("10/2/1993", '1'), new fecha("15/9/1984", '1'), new fecha("12/3/1989", '1'), new fecha("20/6/1982", '1')};
		private static String DNI [] = {"00000000g", "00000000b", "00000000c", "00000000e", "00000000f"};
		//private static fecha FechCont [] = {new fecha ("25/1/2014"), new fecha ("15/9/2003"), new fecha("12/10/2006"), new fecha ("22/8/2010"), new fecha ("17/4/1998")};
		private static int horastrabajadas [] = {50, 120, 75, 80, 110};
		
		public static void cargarDatos(){
			//ppal.vCli = new vector(20);
			//menuempleados.veh=new vector (10);
			
			Object h=null;
			
			for(int i=0;i<5;i++){
				
				h=new empleadohoras (nom[i], DNI [i], Depart[i], FecNac[i], horastrabajadas[i], null, null, null);
				//menuempleados.veh.guardar(h);
				
				
			}
			
		
		}

}
