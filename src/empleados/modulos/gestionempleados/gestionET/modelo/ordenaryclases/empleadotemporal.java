package empleados.modulos.gestionempleados.gestionET.modelo.ordenaryclases;

import empleados.modulos.gestionempleados.clases.empleado;
import empleados.clases.fecha;

public class empleadotemporal extends empleado{
	
	private fecha fechaAlta;
	private fecha fechaBaja;
	private int antiguedadtemporal;
	
	public empleadotemporal(String nombre, String dni, String departamento, fecha fechaNacimiento, 
			fecha fechaAlta, fecha fechaBaja, String login, String password, String email) {
		super(nombre, dni, departamento, fechaNacimiento, login, password, email);
		this.setAntiguedadtemporal(fechaAlta.calcularedad());
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		super.setSueldo(calcularsueldotemporal());
	}
	public empleadotemporal (String dni){
		super(dni);
	}
	
	
	public void setAntiguedadtemporal(int antiguedadtemporal) {
		this.antiguedadtemporal = antiguedadtemporal;
	}

	public int cambiarSalariotemporal(int antiguedadtemporal) {
		
		this.setAntiguedadtemporal(fechaAlta.calcularedad());
		return this.cambiarSalariotemporal(antiguedadtemporal);
	}
	public fecha getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(fecha fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	public fecha getFechaBaja() {
		return fechaBaja;
	}
	public void setFechaBaja(fecha fechaBaja) {
		this.fechaBaja = fechaBaja;
	}
	public float calcularsueldotemporal(){
		float sueldo=0.0f;
		sueldo=(float)(12000+75*this.antiguedadtemporal);
		return sueldo;
	}
	@Override
	public String toString() {
		
		return "empleadotemporal [toString()=" + super.toString() + "]";
	
		/*StringBuffer imprimir = new StringBuffer();
		String s="";
	
		s=s+"empleadotemporal [toString()=" + super.toString() + "]";
		
		
		imprimir.append(s);
		
		return imprimir.toString();
		*/
	}
	
	

}
