package empleados.modulos.gestionempleados.gestionET.modelo.DAO;



import empleados.modulos.gestionempleados.gestionET.modelo.ordenaryclases.empleadotemporal;
import empleados.clases.fecha;
import empleados.palmentem.*;

public class dummieset {

	
	//empleado temporal
		private static String Nombre [] = {"Javi", "Tomas", "Jaume", "Vicent", "Laura"};
		private static String Departamento [] = {"Informatica", "Oficina", "Informatica", "Mantenimiento", "Oficina"};
		private static fecha FechaNac [] = {new fecha("27/5/1975", '1'), new fecha("10/2/1993", '1'), new fecha("15/9/1984", '1'), new fecha("12/3/1989", '1'), new fecha("20/6/1982", '1')};
		private static String Dni [] = {"00000000k", "00000000l", "00000000a", "00000000d", "00000000p"};
		private static fecha FechaCont [] = {new fecha ("25/1/2014", '1'), new fecha ("15/9/2003", '1'), new fecha("12/10/2006", '1'), new fecha ("22/8/2010", '1'), new fecha ("17/4/1998", '1')};
		private static fecha FechaBaja [] = {new fecha ("15/9/2014", '1'), new fecha ("15/9/2004", '1'), new fecha("12/4/2007", '1'), new fecha ("22/10/2012", '1'), new fecha ("17/4/1999", '1')};

		
		
		public static void cargarDatos(){
			//ppal.vCli = new vector(20);
			
			//menuempleados.vet=new vector (10);
			
			Object t=null;
			
			for(int i=0;i<5;i++){
				
				//t=new empleadotemporal (Nombre[i], Dni [i], Departamento[i], FechaNac[i], FechaCont[i], FechaBaja[i]);
				//menuempleados.vet.guardar(t);
				
			}

}
}
