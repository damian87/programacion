package empleados.librerias;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.*;
import empleados.modulos.gestionempleados.clases.empleado;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class json {
	
	public static void generajsonEF() {//Guarda Json de empleado fijo
    	String PATH = null;
	      try {
	          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
	          xstreamjson.setMode(XStream.NO_REFERENCES);
	          xstreamjson.alias("Empleadofijo", empleadofijo.class);
	          
	          JFileChooser fileChooser = new JFileChooser();
	          int seleccion = fileChooser.showSaveDialog(null);
	          if (seleccion == JFileChooser.APPROVE_OPTION) {
	                File JFC = fileChooser.getSelectedFile();
	                PATH = JFC.getAbsolutePath();
	                PATH=PATH+ ".json";
	              
	                Gson gson1=new Gson();
	                String json=gson1.toJson(ArraylistEF.ef);
		            FileWriter fileXml=new FileWriter(PATH);
	                fileXml.write(json.toString());
	                fileXml.close();
   
	                JOptionPane.showMessageDialog(null, "Archivo JSON guardado con exito", "Archivo JSON", JOptionPane.INFORMATION_MESSAGE);
	          }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al guardar el JSON", "Error", JOptionPane.ERROR_MESSAGE);
        }
    	
    }
	
	
	 public static void generajsonocultoEF() {//Guarda Json de empleadosfijos de forma silenciosa
	    	String PATH = null;
		      try {
		          XStream xstreamjson = new XStream(new JettisonMappedXmlDriver());
		          xstreamjson.setMode(XStream.NO_REFERENCES);
		          xstreamjson.alias("Empleadofijo", empleadofijo.class);


		                PATH = new java.io.File(".").getCanonicalPath()+"/src/empleados/modulos/gestionempleados/gestionEF/modelo/tipofichero/ef.json";
		           
		              
		                Gson gson = new Gson();
			            String json1 = gson.toJson(ArraylistEF.ef);
			            FileWriter fileXml = new FileWriter(PATH);
		                fileXml.write(json1.toString());
		                fileXml.close();
	   
		          
	        } catch (Exception e) {
	        }
	    	
	    }
	 
	 
	 public static ArrayList<empleadofijo> abrir_jsonEF(){//Abre Json de empleados fijos
	    	String PATH = null;
	    	empleadofijo e1=new empleadofijo("");
	    	
	        try {
	        	  XStream xstream = new XStream(new JettisonMappedXmlDriver());
		          xstream.setMode(XStream.NO_REFERENCES);
				  xstream.alias("Empleadofijo", empleadofijo.class);
				  
				  JFileChooser fileChooser = new JFileChooser();
		          int seleccion = fileChooser.showOpenDialog(null);
		          if (seleccion == JFileChooser.APPROVE_OPTION) {
		                File JFC = fileChooser.getSelectedFile();
		                PATH = JFC.getAbsolutePath();
		               
		                ArraylistEF.ef.clear();
		                JsonReader lector = new JsonReader(new FileReader(PATH));
		                JsonParser parseador = new JsonParser();
		                JsonElement raiz = parseador.parse(lector);
		            		  
		            	Gson json = new Gson();
		            	JsonArray lista = raiz.getAsJsonArray();
		            	for (JsonElement elemento : lista) {
		            		e1 = json.fromJson(elemento, empleadofijo.class);
		            		ArraylistEF.ef.add(e1);
		            	}
		          } 
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Error al abrir el JSON", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	        return ArraylistEF.ef;
	    }
	 
	 public static ArrayList<empleadofijo> abrir_jsonOcultoEF(){//Abre json de empleados fijos de forma silenciosa
	    	String PATH = null;
	    	empleadofijo e1=new empleadofijo("");
	    	
	        try {
	            PATH = new java.io.File(".").getCanonicalPath()+"/src/empleados/modulos/gestionempleados/gestionEF/modelo/tipofichero/ef.json";

		                ArraylistEF.ef.clear();
		                JsonReader lector = new JsonReader(new FileReader(PATH));
		                JsonParser parseador = new JsonParser();
		                JsonElement raiz = parseador.parse(lector);
		            		  
		            	Gson json = new Gson();
		            	JsonArray lista = raiz.getAsJsonArray();
		            	for (JsonElement elemento : lista) {
		            		e1 = json.fromJson(elemento, empleadofijo.class);
		            		ArraylistEF.ef.add(e1);
		            	}
	        } catch (Exception e) {

	        }
	        return ArraylistEF.ef;
	    }
	 

}

