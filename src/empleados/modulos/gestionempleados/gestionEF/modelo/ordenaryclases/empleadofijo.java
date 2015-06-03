package empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases;
import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import empleados.clases.fecha;
import empleados.modulos.gestionempleados.clases.empleado;

@XStreamAlias ("empleadofijo")
public class empleadofijo extends empleado implements Serializable{

	@XStreamAlias ("antiguedad")
	private int antiguedad;
	@XStreamAlias ("fechaContratacion")
	private fecha fechaContratacion;
	
	public empleadofijo(String nombre,  String dni, String departamento, fecha fechaNacimiento,
			fecha fechaContratacion, String login, String password, String email, String tipo, String avatar) {
		//String nombre, String dni, String departamento, fecha fechaNacimiento
                //(String nombre, String dni, String departamento, fecha fechaNacimiento, String login, String password, String email, String avatar, int estado, String tipo) {
		super(nombre, dni, departamento, fechaNacimiento, login, password, email, tipo, avatar);
		this.setAntiguedad(fechaContratacion.calcularedad());
		//this.antiguedad = antiguedad;
		this.fechaContratacion = fechaContratacion;
		super.setSueldo(calcularsueldo());
	}
	public empleadofijo (String dni){
		super(dni);
	}
        
        public empleadofijo (){
		
	}
	
	
	public int cambiarAntiguedad() {
		/*
		 * this.setAntiguedad(fechaContratacion.calcularedad());
		 * 	return this.cambiarAntiguedad();
		 */
            
                 antiguedad=this.getFechaContratacion().calcularedad();
                 return antiguedad;
		//return this.getFechaContratacion().calcularedad();
	}
	
	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	public fecha getFechaContratacion() {
		return fechaContratacion;
	}
	public void setFechaContratacion(fecha fechaContratacion) {
		this.fechaContratacion = fechaContratacion;
	}
	public float calcularsueldo(){
		float sueldo=0.0f;
		sueldo=(float)(12000+178*this.antiguedad);
		return sueldo;
	}
	
	@Override
	public String toString() {
		
		
		
		//return "empleadofijo [antiguedad=" + antiguedad + "\n toString()=" + super.toString() + "]";
		StringBuffer imprimir=new StringBuffer();
		//String s="";
		//s=s+"empleadofijo [antiguedad=" + antiguedad + "\n =" + "" + super.toString() + "]";
		
		//imprimir.append ("Antiguedad: "+antiguedad+"\n"+super.toString());
		imprimir.append (super.toString()+"\n"+"Antiguedad: "+this.cambiarAntiguedad()+"\n"+"Sueldo:"+this.calcularsueldo());
		//imprimir.append(s);
		
		return imprimir.toString();
		
	}
	
	
}
