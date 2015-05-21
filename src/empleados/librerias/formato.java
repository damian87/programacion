package empleados.librerias;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class formato {

	
	public static String UnDecimale(float num){//45.456
		DecimalFormat formato = new DecimalFormat(".0");
		return formato.format(num);//45.4
	}
	
	public static String dosDecimales(float num){//45.456
		DecimalFormat format1 = new DecimalFormat(".00");
		return format1.format(num);//45.46
	}
	
	public static String dosDecimalesRedondea(float num){//2.315f
		DecimalFormat format2 = new DecimalFormat("00.00");
		float f = (float)num;
		return(format2.format(f));//02,32
	}
	
	public static String saldoCuenta(float num){
		DecimalFormat df = new DecimalFormat("#.###.##0,00");
		return df.format(num);	//364.565,14
	}
		
	public static String porcentajeInt(int i){
		String s = "";
			s = Integer.toString(i) + "%";
		return s;
	}
	
	public static String formatoUnidades(int i){
		String s = "";
			s = Integer.toString(i) + " unid.";
		return s;
	}
	
	public static String porcentajeDouble(float per){//0.47
		NumberFormat percentFormatter = NumberFormat.getPercentInstance(Locale.US);
		String percentOut = percentFormatter.format(per);
		return percentOut;//47%
	}
}
