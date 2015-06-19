package empleados.clases;
import empleados.Mainapli;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.thoughtworks.xstream.annotations.XStreamAlias;

import empleados.modulos.gestionempleados.clases.empleado;
import javax.swing.JOptionPane;

@XStreamAlias ("fecha")
public class fecha implements Serializable {

	@XStreamAlias ("dia")
	private int dia;
	@XStreamAlias ("mes")
	private int mes;
	@XStreamAlias ("año")
	private int año;
	@XStreamAlias ("date")
	private String date; 
	
	private Calendar fecha = Calendar.getInstance();
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	public fecha(int dia, int mes, int año) throws ParseException {//contructor1
		this.dia = dia;
		this.mes = mes;
		this.año = año;
		this.fecha.setTime(this.formato.parse(this.dia+"/"+this.mes+"/"+this.año));
	}
	
	/*public fecha(String fecha) throws ParseException {
		this.fecha.setTime(this.formato.parse(fecha));	
		this.dia	=	this.fecha.get(Calendar.DATE);
		this.mes	=	this.fecha.get(Calendar.MONTH)+1;
		this.año	=	this.fecha.get(Calendar.YEAR);
	}*/
	
	public fecha(String data){//constructor2

		String[] SplitArray=null;
		String fechaform=null;
			SplitArray=data.split("/");
			
			//if (menuempleados.conf.getFormatofecha().equals("dd/mm/yyyy")){//dd/mm/yyyy
			dia=Integer.parseInt(SplitArray[0]);
			mes=Integer.parseInt(SplitArray[1]);
			año=Integer.parseInt(SplitArray[2]);
			/*}
			else if (menuempleados.conf.getFormatofecha().equals("mm/dd/yyyy")){//mm/dd/yyyy
				mes=Integer.parseInt(SplitArray[1]);
				dia=Integer.parseInt(SplitArray[0]);
				año=Integer.parseInt(SplitArray[2]);
				}
			else if (menuempleados.conf.getFormatofecha().equals("yyyy/mm/dd")){//yyyy/mm/dd
				año=Integer.parseInt(SplitArray[2]);
				mes=Integer.parseInt(SplitArray[1]);
				dia=Integer.parseInt(SplitArray[0]);
				}*/
			
		fechaform=dia+"/"+mes+"/"+año;	
		this.date=data;
		
	}
	
	public fecha(String data, int i){//constructor 3


		String[] SplitArray=null;
		String fechaform=null;
			SplitArray=data.split("/");

			
			dia=Integer.parseInt(SplitArray[0]);
			mes=Integer.parseInt(SplitArray[1]);
			año=Integer.parseInt(SplitArray[2]);
			
	this.date=data;
	}
	
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getAño() {
		return año;
	}
	public void setAño(int año) {
		this.año = año;
	}
	
	public boolean compDia(){
		GregorianCalendar calendar = new GregorianCalendar();
		int dias[]	=	{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if (calendar.isLeapYear(this.año)){
			dias[2]	= 29;
		}
		
		if((this.dia >= 1) && (this.dia <= dias[this.mes])){
			return true;
		}else{
			return false;
		}
	}
	


	
	public boolean compmes (int mes){
			boolean interruptor=false;
			if ((mes>=1)&&(mes<=12)){
				interruptor=false;
			}
			else {
				interruptor=true;
		}
		
			return interruptor;
		}
		
	public boolean compaño (int año){
			boolean interruptor=false;
			if ((año>=1956)&&(año<=2014)){
			interruptor=false;
			}
			else {
				interruptor=true;
			}
			return interruptor;
	}

	
	
	public int compfechas(fecha f){
		int valor = 0;
		// 1 mayor
		// 0 igual
		//-1 menor
		if(this.año == f.año){
			if(this.mes == f.mes){
				if(this.dia > f.dia){
					valor = 1; //La fecha sera mayor que la que estamos comparando
				}else if(this.dia == f.dia){
					valor = 0; //La fechas son iguales
				}else{
                    valor = -1;//La fecha es menor  
                }
			}else if(this.mes < f.mes){
                            valor = -1;//La fecha es menor
            }else {
            				valor = 1;//La fecha es mayor
            }
		}else if(this.año > f.año){
                    valor = 1; //La fecha sera mayor que la que estamos comparando
                }else{
                    valor = -1;//La fecha es menor
		}
		return valor;
	}
	
	public int restafechas(fecha fe){
		int ano=0, mes=0, dia=0, resultado=0;
		
		dia=this.dia-fe.dia;
		mes= this.mes-fe.mes;
		ano=this.año-fe.año;
		
		resultado=ano;
		if(fe.mes<this.mes){
			resultado = resultado-1;
		}else if(fe.mes==this.mes){
			if(fe.dia<this.dia){
			resultado = resultado-1;
			}	
		}
		return resultado;
	}
	
	public int compfechassystem(){
		
		Calendar c1= Calendar.getInstance();
		

		int Dia=0,Mes=0,Anyo=0;
		
		Dia=c1.get(Calendar.DATE);
		Mes=c1.get(Calendar.MONTH)+1;
		Anyo=c1.get(Calendar.YEAR);
		
		
		int valor = 0;
		// 1 mayor
		// 0 igual
		//-1 menor
		if(this.año == Anyo){
			if(this.mes == Mes){
				if(this.dia > Dia){
					valor = 1; //La fecha sera mayor que la que estamos comparando
				}else if(this.dia == Dia){
					valor = 0; //La fechas son iguales
				}else{
                    valor = -1;//La fecha es menor  
                }
			}else if(this.mes < Mes){
                            valor = -1;//La fecha es menor
            }else {
            				valor = 1;//La fecha es mayor
            }
		}else if(this.año > Anyo){
                    valor = 1; //La fecha sera mayor que la que estamos comparando
                }else{
                    valor = -1;//La fecha es menor
		}
		return valor;
	}
	
public boolean compruebafecha (){
		
		boolean val1, val2, val3;
		
		GregorianCalendar calendar = new GregorianCalendar();
		
		
		int[] dias =	{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		if (calendar.isLeapYear(this.año)){
			dias[2]	= 29;
		}
		
		
		if ((this.dia>=1)&&(this.dia<= dias [this.mes])){
			val1=true;
		}
		else{
			val1=false;
		}
		
		if ((this.mes>=1)&&(this.mes<=12)){
			val2=true;
		}
		else{
			val2=false;
		}
		
		if ((this.año>=1947)&&(this.año<=2015)){
		
			val3=true;
		}
		else{
			val3=false;
		}
		
		if ((val1==true)&&(val2==true)&&(val3==true)){
			return true;
		}
		else{
			return false;
		}
		
	}
	
	
	
	/*public boolean compfechasystem(fecha f){
		
		boolean interruptor=false;
		
		int Dia=0,Mes=0,Anyo=0;
		
		
		
		Calendar c1= Calendar.getInstance();
		
		Dia=c1.get(Calendar.DATE);
		Mes=c1.get(Calendar.MONTH)+1;
		Anyo=c1.get(Calendar.YEAR);
		
		if ((f.getAño() == Anyo)&&(f.getMes() == Mes)&&(f.getDia() == Dia)){
					interruptor=false; //La fecha sera igual al sistema
				}else {
					interruptor=true; //La fechas es diferente al sistema
		
				}
				return interruptor;
	}*/
	
	
	public int antiguedad(){
		int resultado = 0;
		Calendar ahora = Calendar.getInstance();
		int Calcdia = ahora.get(Calendar.DATE); 
		int Calcmes = ahora.get(Calendar.MONTH)+1; 
	   	int Calcaño = ahora.get(Calendar.YEAR); 
	   	resultado = Calcaño-this.año;
	   	
		if(Calcmes<this.mes){
			resultado = resultado-1;
		}else if(Calcmes==this.mes){
			if(Calcdia<this.dia){
			resultado = resultado-1;
			}	
		}
	   	return resultado;   
		
	}
	
	
	public int calcularedad(){
		int resultado = 0;
		Calendar ahora = Calendar.getInstance();
		int Calcdia = ahora.get(Calendar.DATE); 
		int Calcmes = ahora.get(Calendar.MONTH)+1; 
	   	int Calcaño = ahora.get(Calendar.YEAR); 
	   	resultado = Calcaño-this.año;
	   	
		if(Calcmes<this.mes){
			resultado = resultado-1;
		}else if(Calcmes==this.mes){
			if(Calcdia<this.dia){
			resultado = resultado-1;
			}	
		}
	   	return resultado;   
		
	}

	
	

	@Override
	public String toString() {
		/*return "fecha [dia=" + dia + "\n mes=" + mes + "\n año=" + año + "\n date=" + date + "\n fecha=" + fecha
				+ "\n formato=" + formato + "]";
				*/
		String fecha=null;
		
		if (Mainapli.conf==null){
			fecha=this.dia+"/"+this.mes+"/"+this.año;
		}
		
		else if (Mainapli.conf.getFormatofecha().equals("dd/mm/yyyy")){//dd/mm/yyyy
			fecha=this.dia+"/"+this.mes+"/"+this.año;
		}
		else if (Mainapli.conf.getFormatofecha().equals("mm/dd/yyyy")){//mm/dd/yyyy
			fecha=this.mes+"/"+this.dia+"/"+this.año;
		}
		else if (Mainapli.conf.getFormatofecha().equals("yyyy/mm/dd")){//yyyy/mm/dd
			fecha=this.año+"/"+this.mes+"/"+this.dia;
	}
		return fecha;
}
}



	

