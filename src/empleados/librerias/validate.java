package empleados.librerias;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class validate {

	    // validate email
	    public static boolean validateEmail(String email) {
	        return email
	                .matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	    }

	    // validate name
	    public static boolean validateNombre(String nombre) {
	        return nombre.matches("[a-zA-z]+([ ][a-zA-Z]+)*");
	    }

	    // validate surname
	    public static boolean validateApellidos(String apellidos) {
	        return apellidos.matches("[a-zA-z]+([ '-][a-zA-Z]+)*");
	    }

	    // validate postal code
	    public static boolean validateCodigoPostal(String codigopostal) {
	        return codigopostal.matches("^([1-9]{2}|[0-9][1-9]|[1-9][0-9])[0-9]{3}$");
	    }

	    // validate postal code
	    public static boolean validateNumeroTelefono(String numtelf) {
	        return numtelf.matches("[0-9]{9}");
	    }
	    
	    // validate pass
	    public static boolean validatePassWord(String password) {
	        return password.matches("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
	    }
	    
	    public static boolean email(String email){ //Valida una eMail
			return email.matches("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		}
	    
	    public static boolean direccion(String direc){ //Valida una direccion
			return direc.matches("[a-zA-Z1-9À-ÖØ-öø-ÿ]+\\.?(( |\\-)[a-zA-Z1-9À-ÖØ-öø-ÿ]+\\.?)*");
		}
	    
	    public static boolean fecha(String fecha){
			return fecha.matches("(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.](19|20)\\d\\d");
		}	
	    
	    public static boolean numCuenta (String nCuenta){
			return nCuenta.matches("[0-9]{10}");
		}
	    public static boolean dni (String dni){
	    	return dni.matches("([0-9]{8})([A-Z])");
	    }
	    
	    
	    public static boolean validaDNI(String dNi){
	    	boolean val = true;
			String dni2 = "", caracteres="TRWAGMYFPDXBNJZSQVHLCKET";
			int dni = 0, modulo = 0;
			try{	
			for(int i=0; i<8; i++)
					dni2 += dNi.charAt(i);			
				char letra = dNi.charAt(8);			
					dni = Integer.parseInt(dni2);
				    	modulo= dni % 23;
				    		char let = caracteres.charAt(modulo);
						    	if(let == letra)
						    		val = true;
						    	else
						    		val = false;
			}catch (Exception e){
				JOptionPane.showMessageDialog(null, "El dni no es correcto");
				val=false;
			}
		    return val; 
		  }
	    
	}

