/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.librerias;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;

/**
 *
 * @author Damian
 */
public class fondopanelpager extends JPanel{
    
    
    URL imagen1 = fondopanelpager.class.getResource("/imagenes/imagenesproyecto/outlet_fodo.jpg");
         Image imagen=Toolkit.getDefaultToolkit().getImage(imagen1);
   
   
	public void paint(Graphics g) {
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(),  this);  //la imagen se redimensiona
		setOpaque(false);
		super.paint(g);
	}  
}
