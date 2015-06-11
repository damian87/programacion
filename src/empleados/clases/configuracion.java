package empleados.clases;

import empleados.modulos.gestionempleados.gestionEF.modelo.BLL.EFBLLgrafica;
import javax.swing.JOptionPane;




import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.SingletonsEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;
import empleados.modulos.gestionempleados.gestionEF.modelo.DAO.DAOEFgrafica;
import java.util.ArrayList;

public class configuracion {

	private char moneda;
	private int decimales;
	private String Formatofecha;
	private int tema;
	private int fichero;
	
	



	public configuracion(){
            
                SingletonsEF.ef = new ArrayList <empleadofijo> ();
		moneda ='€';
		decimales = '2';
		Formatofecha = "dd/mm/yyyy";
		tema = '0';
		fichero = '2';
		
		//JOptionPane.showMessageDialog(null, "Bienvenidos a Gestion Empleados de Outlet Products");
		
		//DAOEFgrafica.cargarDatos();
                //EFBLLgrafica.GuardarSinEnterarse();
		//EFBLLgrafica.AbrirSinEnterarse();
		
		
		
		
		
	
		
		
	}
	
	
	public int getFichero() {
		return fichero;
	}


	public void setFichero(int fichero) {
		this.fichero = fichero;
	}


	public int getTema() {
		return tema;
	}


	public void setTema(int tema) {
		this.tema = tema;
	}

	public char getMoneda() {
		return moneda;
	}

	public void setMoneda(char moneda) {
		this.moneda = moneda;
	}

	public int getDecimales() {
		return decimales;
	}

	public void setDecimales(int decimales) {
		this.decimales = decimales;
	}

	public String getFormatofecha() {
		return Formatofecha;
	}

	public void setFormatofecha(String formatofecha) {
		Formatofecha = formatofecha;
	}

	@Override
	public String toString() {
		return "configuracion [moneda=" + moneda + ", decimales=" + decimales + ", Formatofecha=" + Formatofecha + "]";
	}
	
	
	
	
	
	
}
