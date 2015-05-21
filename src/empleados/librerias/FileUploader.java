/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.librerias;

import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.ArraylistEF;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author damian
 */
public class FileUploader {
    
    public static String PATH_auto="";
    
    public static void lista_blanca(JFileChooser buscador) {
        buscador.setAcceptAllFileFilterUsed(false);
        buscador.addChoosableFileFilter(new FileNameExtensionFilter("Imágenes (*.jpg, *.jpeg, *.gif, *.png)", "jpg", "jpeg", "gif", "png"));
    }
    
    public static void pintaravatar(JLabel etiqueta, int ancho, int alto){
        
         ImageIcon icon = new ImageIcon(ArraylistEF.efi.getAvatar());
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                etiqueta.setIcon(newIcon); //pintamos la imagen en jlabel1
        
    }
    
    public static void pintar_guardar_imag(JLabel etiqueta, int ancho, int alto){
        String ruta;
        File imagen;
        BufferedImage image;
        String extension="";
        JFileChooser fileChooser = new JFileChooser();

        lista_blanca(fileChooser);
        fileChooser.setCurrentDirectory(null);
        fileChooser.setSelectedFile(null);

        int seleccion = fileChooser.showOpenDialog(null);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            imagen = fileChooser.getSelectedFile();

            ruta = imagen.getAbsolutePath();
            if (ruta.length() > 500) {
                JOptionPane.showMessageDialog(null, "La ruta de la imagen debe "
                        + "tener como máximo 500 caracteres", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                ImageIcon icon = new ImageIcon(ruta);
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                etiqueta.setIcon(newIcon); //pintamos la imagen en jlabel1
                
                try {
                    //guardamos la imagen
                    image=ImageIO.read(fileChooser.getSelectedFile().toURL());
                    extension=fileChooser.getSelectedFile().toURL().toString().substring(
                        fileChooser.getSelectedFile().toURL().toString().length()-3);
                    String cad=getCadenaAleatoria(5);
                
                    PATH_auto = new java.io.File("")+ "src/imagenes/avatars"+cad+"."+extension;
                    File f = new File(PATH_auto);
                    ImageIO.write(image, extension, f);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error upload imagen","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else { //avatar per defecte
            ruta = "src/imagenes/avatars/default-avatar.jpg";
            ImageIcon icon = new ImageIcon(ruta);
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            etiqueta.setIcon(newIcon); //pintamos la imagen_default en jlabel1
            
            try {
                    //guardamos la imagen
                    PATH_auto = new java.io.File("")+ "src/img/default-avatar.jpg";
                    File f = new File(PATH_auto);
                    image=ImageIO.read(f);
                    ImageIO.write(image, "jpg", f);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error upload imagen","Error", JOptionPane.ERROR_MESSAGE);
                }
        }
        
    }
    
    public static String getCadenaAleatoria(int longitud){
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while ( i < longitud){
			char c = (char)r.nextInt(255);
			if ( (c >= '0' && c <='9') || (c >='A' && c <='Z') ){
				cadenaAleatoria += c;
				i ++;
			}
		}
		return cadenaAleatoria;
    }
    
}
