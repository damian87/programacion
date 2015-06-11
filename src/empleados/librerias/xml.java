package empleados.librerias;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.Annotations;
//import com.thoughtworks.xstream.converters.basic.DateConverter;
//import com.thoughtworks.xstream.io.xml.DomDriver;

import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.SingletonsEF;
import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;

import java.io.ByteArrayOutputStream;
import java.io.File;
//import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class xml {
    private static final String ENCODING = "UTF-8";
    
    public static void generaxmlEF() {
        String PATH=null;
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, empleadofijo.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(SingletonsEF.ef, osw);
            StringBuffer xml = new StringBuffer();
            xml.append(header);
            xml.append(os.toString());
	    
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH+".xml";
                
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();
                JOptionPane.showMessageDialog(null, "Archivo XML guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);

            }
	    }catch (Exception e1){
	    	JOptionPane.showMessageDialog(null, "Error al grabar el XML", "Error", JOptionPane.ERROR_MESSAGE);
	    } 
    }
    
   
   
    
    public static void generaxmlOcultoEF() {
        String PATH=null;
		try {
			OutputStream os = new ByteArrayOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			XStream xstream = new XStream();
			Annotations.configureAliases(xstream, empleadofijo.class);

            String header = "<?xml version=\"1.0\" encoding=\"" + ENCODING + "\"?>\n";
            xstream.toXML(SingletonsEF.ef, osw);
            StringBuffer xml = new StringBuffer();
            xml.append(header);
            xml.append(os.toString());
	    
            PATH = new java.io.File(".").getCanonicalPath()+"/src/empleados/modulos/gestionempleados/gestionEF/modelo/tipofichero/ef.xml";

                
                FileWriter fileXml = new FileWriter(PATH);
                fileXml.write(xml.toString());
                fileXml.close();
                osw.close();
                os.close();

            
	    }catch (Exception e1){
	    } 
    }
    
    
    public static ArrayList<empleadofijo> abrir_xmlEF() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, empleadofijo.class);
 
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
            	File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                SingletonsEF.ef = (ArrayList <empleadofijo>)xstream.fromXML(new FileReader(PATH));
            }
            
        } catch (Exception e1) {
        	JOptionPane.showMessageDialog(null, "Error al leer el XML", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return SingletonsEF.ef;
    }
    
    
    
    
    
    public static ArrayList<empleadofijo> abrir_xmlOcultoEF() {
    	String PATH=null;
    	try {
            XStream xstream = new XStream();
            Annotations.configureAliases(xstream, empleadofijo.class);
 
            PATH = new java.io.File(".").getCanonicalPath()+"/src/empleados/modulos/gestionempleados/gestionEF/modelo/tipofichero/ef.xml";
            SingletonsEF.ef = (ArrayList <empleadofijo>)xstream.fromXML(new FileReader(PATH));
            
        } catch (Exception e1) {
        	
        }
        return SingletonsEF.ef;
    }
    
    
    
    
    

}
