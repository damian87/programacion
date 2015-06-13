/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.Usuarios.gestionusuarios.modelo.clase;


import com.thoughtworks.xstream.annotations.XStreamAlias;
import empleados.clases.fecha;
import empleados.modulos.gestionempleados.clases.empleado;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *
 * @author damian
 */
public class Usuario extends empleado implements Serializable{
    
        @XStreamAlias ("antiguedad")
	private int antiguedad;
	@XStreamAlias ("fechaAlta")
	private fecha fechaAlta;
	
	public Usuario(String nombre,  String dni, String departamento, fecha fechaNacimiento,
			 String login, String password, String email, String tipo, String avatar) {
		//String nombre, String dni, String departamento, fecha fechaNacimiento
                //(String nombre, String dni, String departamento, fecha fechaNacimiento, String login, String password, String email, String avatar, int estado, String tipo) {
		super(nombre, dni, departamento, fechaNacimiento, login, password, email, tipo, avatar);
		//this.antiguedad = antiguedad;
		this.fechaAlta = fechaAlta;
	}
        
        public Usuario (String dni){
		super(dni);
	}
        
        public Usuario (){
		
	}
        
        public int AntiguedadAltaUsu() {
		/*
		 * this.setAntiguedad(fechaContratacion.calcularedad());
		 * 	return this.cambiarAntiguedad();
		 */               
                antiguedad=this.getfechaAlta().calcularedad();               
		return antiguedad;
	}
        

    public fecha getfechaAlta() {
        return fechaAlta;
    }
    
    public void setfechaAlta(fecha fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

    /*public void setFechaContratacion(fecha fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }*/

    @Override
    public String toString() {
        //return "Ususario{" + "fechaContratacion=" + fechaContratacion + '}';
        
		StringBuffer imprimir=new StringBuffer();			
		//imprimir.append ("Antiguedad: "+fechaAlta+"\n"+super.toString());	
                imprimir.append (super.toString());	
		return imprimir.toString();
    }
        
        
    
}
