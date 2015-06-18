package empleados.clases;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import java.security.spec.KeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Random;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEParameterSpec;
import org.apache.commons.codec.digest.DigestUtils;

public class StringEncrypter {
    public static String getCadenaAleatoria(int longitud){
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while ( i < longitud){
                    char c = (char)r.nextInt(255);
                    if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') || (c >='a' && c <='z') || (c == '$') || (c == '_') ){
			cadenaAleatoria += c;
			i ++;
                    }
		}
		return cadenaAleatoria;
	}
	
	public static String encriptarTokenMD5(String name){
            String cadena_encriptada = DigestUtils.md5Hex(name);
            return cadena_encriptada;
	}
	
	public static boolean validarTokenMD5(String cadenaAleatoria, String cadena_encriptada){
		if(encriptarTokenMD5(cadenaAleatoria).equals(cadena_encriptada))
			return true;
		return false;
	}

    
}
