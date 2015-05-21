package empleados.modulos.gestionempleados.gestionEH.modelo.ordenaryclases;
import empleados.modulos.gestionempleados.clases.empleado;
import empleados.clases.*;

public class empleadohoras extends empleado{

	private float precioHora=(float) 9.20f;
	private int cantHorasTrabajadas;
	public empleadohoras(String nombre, String dni, String departamento, fecha fechaNacimiento, int cantHorasTrabajadas, String login, String password, String email) {
		super(nombre, dni, departamento, fechaNacimiento, login, password, email);
		this.precioHora = precioHora;
		this.cantHorasTrabajadas = cantHorasTrabajadas;
		super.setSueldo(nominahoras());
	}

	public empleadohoras (String dni){
		super(dni);
	}
	
	
	public float getPrecioHora() {
		return precioHora;
	}
	public void setPrecioHora(float precioHora) {
		this.precioHora = precioHora;
	}
	public int getCantHorasTrabajadas() {
		return cantHorasTrabajadas;
	}
	public void setCantHorasTrabajadas(int cantHorasTrabajadas) {
		this.cantHorasTrabajadas = cantHorasTrabajadas;
	}
	
	public float nominahoras (){
		//float cantidad=0.0f;
		//cantidad=(float) (9.20*valor);
		//return cantidad;
		return (getPrecioHora()*getCantHorasTrabajadas());
	}
	@Override
	public String toString() {
		return "empleadohoras [precioHora=" + precioHora + "\n cantHorasTrabajadas=" + cantHorasTrabajadas
				+ "\n toString()=" + super.toString() + "]";
				
		/*StringBuffer imprimir = new StringBuffer();
		String s="";
		
		s=s+"empleadohoras [precioHora=" + precioHora + "\n cantHorasTrabajadas=" + cantHorasTrabajadas
				+ "\n toString()=" + super.toString() + "]";
		
		imprimir.append(s);
		
		return imprimir.toString();
		*/
	}
	
}
