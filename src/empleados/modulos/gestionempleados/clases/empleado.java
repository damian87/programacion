package empleados.modulos.gestionempleados.clases;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import empleados.clases.fecha;
import empleados.librerias.formato;
import empleados.menuempleados;

@XStreamAlias ("empleado")
public class empleado implements Comparable<empleado>, Serializable{
	@XStreamAlias ("nombre")
	private String nombre;
	@XStreamAlias ("edad")
	private int edad;
	@XStreamAlias ("departamento")
	private String departamento;
	@XStreamAlias ("fechaNacimiento")
	private fecha fechaNacimiento;
	@XStreamAlias ("sueldo")
	private float sueldo;
	@XStreamAlias ("dni")
	private String dni;
        @XStreamAlias("login")
        private String login;
        @XStreamAlias("password")
        private String password;
        @XStreamAlias("email")
        private String email;
        @XStreamAlias("avatar")
        private String avatar="";
        @XStreamAlias("tipo")
        private String tipo="User";
        private int estado=0;
        
	
	public empleado(String nombre, String dni, String departamento, fecha fechaNacimiento, String login, String password, String email) {
            
		//super();
		this.nombre = nombre;
		//this.edad = edad;
		this.setEdad(fechaNacimiento.calcularedad());
		this.departamento = departamento;
		this.fechaNacimiento = fechaNacimiento;
		this.dni=dni;
                this.login=login;
                this.password=password;
                this.email=email;
                
                
		
	}
	
	public empleado (String dni){
		this.dni=dni;
	}
        
        public empleado (){
		
	}
	
	public int cambiaedad(fecha fechaNacimiento) {
		this.setEdad(fechaNacimiento.calcularedad());
		return this.getEdad();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
            edad=fechaNacimiento.calcularedad();
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public fecha getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(fecha fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public float getSueldo() {
            
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getTipo() {
        return tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
        
        
	
	public int compareTo(empleado emp) {//para ordenar los empleados
		if(this.getDni().compareTo(emp.getDni())>0)
			return 1;
		if(this.getDni().compareTo(emp.getDni())<0)
			return -1;
		return 0;
		 }
	public boolean equals(Object c){//para comprara dni
		return getDni().equals(((empleado)c).getDni());
}


	@Override
	public String toString() {
		//return "empleado [nombre=" + nombre + "\n edad=" + edad + "\n departamento=" + departamento + "\n sueldo="
				//+ sueldo + "]";
			
		
		StringBuffer imprimir=new StringBuffer();
		String s="";
		String s1="";
		
		if (menuempleados.conf==null){
			s=formato.UnDecimale(sueldo);
			//imprimir.append ("sueldo: "+formato.UnDecimale(sueldo)+"\n");
		}
		
		
		else if (menuempleados.conf.getDecimales()==1){
			s=formato.UnDecimale(sueldo);
			//imprimir.append ("sueldo: "+formato.UnDecimale(sueldo)+"\n");
		}
		else if (menuempleados.conf.getDecimales()==2){
			s=formato.dosDecimales(sueldo);
			//imprimir.append ("sueldo: "+formato.dosDecimales(sueldo)+"\n");
		}
		
		imprimir.append ("Nombre: "+getNombre()+"\n");
		imprimir.append ("edad: "+getEdad()+"\n");
		imprimir.append ("departamento: "+getDepartamento()+"\n");
		//imprimir.append ("sueldo: "+s+"\n");
		imprimir.append ("sueldo: "+getSueldo()+"\n");
                imprimir.append ("login: "+getLogin()+"\n");
                imprimir.append ("password: "+getPassword()+"\n");
                imprimir.append ("email: "+getEmail()+"\n");
                 imprimir.append ("tipo: "+getTipo()+"\n");
                
		
		//s1=s1+"empleado [nombre=" + nombre + "\n edad=" + edad + "\n departamento=" + departamento + "\n sueldo="
			//	+ s + "]";
		
		//imprimir.append(s1);
		
		return imprimir.toString();
		
	}

	
	
}
