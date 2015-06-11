package empleados.librerias;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.*;

public class txt {
    public static void generatxtEF() {
        String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH=PATH+ ".txt";
                f = new File(PATH);
                
                FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(SingletonsEF.ef);
				o.close();
                JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    
    
    public static void generatxtOcultoEF() {
        String PATH = null;
        try {
            File f;
            PATH = new java.io.File(".").getCanonicalPath()+"/src/empleados/modulos/gestionempleados/gestionEF/modelo/tipofichero/ef.txt";

                f = new File(PATH);
                
                FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(SingletonsEF.ef);
				o.close();
            
        } catch (Exception e) {
        }
    }
    
  
    
   
    
    public static ArrayList<empleadofijo> abrir_txtEF() {
    	String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                f = new File(PATH);
                
                FileInputStream fi=new FileInputStream(f);
    			ObjectInputStream oi=new ObjectInputStream(fi);
    			SingletonsEF.ef = (ArrayList<empleadofijo>)oi.readObject();
    			oi.close();
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    	return SingletonsEF.ef;
    }
    
   
    
    
    
    public static ArrayList<empleadofijo> abrir_txtOcultoEF() {
    	String PATH = null;
        try {
            File f;
            PATH = new java.io.File(".").getCanonicalPath()+"/src/empleados/modulos/gestionempleados/gestionEF/modelo/tipofichero/ef.txt";

                f = new File(PATH);
                
                FileInputStream fi=new FileInputStream(f);
    			ObjectInputStream oi=new ObjectInputStream(fi);
    			SingletonsEF.ef = (ArrayList<empleadofijo>)oi.readObject();
    			oi.close();
            
        } catch (Exception e) {
        	
        }
    	return SingletonsEF.ef;
    }
    
   

}
