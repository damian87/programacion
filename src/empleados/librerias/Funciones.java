package empleados.librerias;

import java.text.ParseException;
import java.util.Calendar;

import javax.swing.JOptionPane;




public class Funciones {

	public static int vint(String titulo, String mensaje) {
		boolean correcto = false;
		String s = "";
		int a = 0;
		do {
			try {
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				a = Integer.parseInt(s);
				correcto = true;

			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(null, "No has introducido un num int", "Error", JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return a;
	}

	public static int vintneg() {
		boolean correcto = false;
		String s = "";
		int a = 0;
		do {
			try {
				s = JOptionPane.showInputDialog(null, "Escribe un numero", "Num int", JOptionPane.QUESTION_MESSAGE);
				a = Integer.parseInt(s);
				correcto = true;

			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(null, "No has introducido un num int", "Error", JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while ((correcto == false) || (a > 0));
		return a;
	}

	public static float vfloat(String titulo, String mensaje) {
		float a = 0.0f;
		String s;
		boolean correcto = true;

		do {
			try {
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);

				a = Float.parseFloat(s);
				correcto = true;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido un num float", "Error",
						JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return a;
	}

	public static float vfloatneg() {

		float a = 0.0f;
		String s;
		boolean correcto = true;

		do {
			try {
				s = JOptionPane.showInputDialog(null, "Escribe un numero, recuerde que no debe ser menor o igual a 0", "Num float", JOptionPane.QUESTION_MESSAGE);

				a = Float.parseFloat(s);
				correcto = true;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido un num float", "Error",
						JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while ((correcto == false) || (a <= 0));
		return a;
	}

	public static String vstring (String titulo, String mensaje) {
		String s = "";
		boolean correcto = true;

		do {
			try {
				s = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
				correcto = true;
				if (s == null) {
					JOptionPane.showMessageDialog(null, "Saliendo de la aplicaci�n", "Saliendo",
							JOptionPane.INFORMATION_MESSAGE);
					System.exit(0);// al usuario pulsar cancelar o cerrar la
									// vtna del showinputdialog, acaba la
									// ejecuci�n
				}
				if (s.equals("")) {
					JOptionPane.showMessageDialog(null, "Error de introducci�n de datos", "Error",
							JOptionPane.ERROR_MESSAGE);
					correcto = false;
				}
			} catch (Exception e) {
				JOptionPane
						.showMessageDialog(null, "No has introducido una cadena", "Error", JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return s;
	}

	public static char vchar() {
		char c = 0;
		String s;
		boolean correcto = true;

		do {
			try {
				s = JOptionPane.showInputDialog(null, "Escribe una letra", "letra", JOptionPane.QUESTION_MESSAGE);

				c = s.charAt(0);
				correcto = true;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "No has introducido una letra", "Error", JOptionPane.ERROR_MESSAGE);
				correcto = false;
			}
		} while (correcto == false);
		return c;
	}

	public static int scdialog() {
		int confirmado = JOptionPane.showConfirmDialog(null, "�Lo confirmas?");
		return confirmado;

	}

	public static boolean boo() {

		boolean interruptor = false;
		return interruptor;

	}

	public static char sn() {
		char seguir = 's';
		String s;
		boolean correcto = true;
		do {
			do {
				try {
					s = JOptionPane.showInputDialog(null, "Deseas continuar (S/N)", "Continuar?",
							JOptionPane.QUESTION_MESSAGE);
					seguir = s.charAt(0);
					seguir = Character.toUpperCase(seguir);
					correcto = true;

				} catch (Exception e) {
					JOptionPane
							.showMessageDialog(null, "Error al introducir datos", "Error", JOptionPane.ERROR_MESSAGE);
					correcto = false;
				}
			} while (correcto == false);
			if ((seguir != 'S') && (seguir != 'N'))
				JOptionPane.showMessageDialog(null, "No has introducido S o N", "Error", JOptionPane.ERROR_MESSAGE);
		} while ((seguir != 'S') && (seguir != 'N'));

		return seguir;
	}

	
	
	
	/*public static fecha vfecha(){
		
		String data, dat;
		boolean val1, val2;
		fecha c2=null;
		fecha c1=null;
		
		
		do{
			do{
				
		data=Funciones.vstring("Inicio", "Dame la fecha de inicio de contratacion (--/--/----)");
		dat=Funciones.vstring("Finalizacion", "Dame la fecha de final de contratacion (--/--/----)");
		val1=validate.fecha(data);
		val2=validate.fecha(dat);
		
			}while ((val1 !=false)&&(val2 !=false));
			
		c2=new fecha(data);
		c1=new fecha (dat);
		
		
		
		}while (c2.antiguedad(c1) !=false);
		
			
		
		//objecte f
		//probar que ix be amb un .toString
		//f.validafecha
		
		return c2;
	
	}
	
	/*public static fecha vfecha(){
		
		String data;
		boolean val1;
		fecha c2=null;
		//int val2;
		
		do{
			do{
				
		data=Funciones.vstring("Fecha", "Dame la fecha de nacimiento (--/--/----)");
		val1=validate.fecha(data);
		
			}while (val1 !=false);
			
		c2=new fecha(data);
		
		
		
		}while (c2.compfechasystem(c2) !=false);
		
			
		
		//objecte f
		//probar que ix be amb un .toString
		//f.validafecha
		
		return c2;
	
	}*/
	
}
