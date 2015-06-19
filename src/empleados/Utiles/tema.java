package empleados.Utiles;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class tema {

	public static void temaElegido(int aux){
		
		
		try {
			
			if (aux==0){// Metal
				UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
			
			}
				if (aux==1){// GTK - WINDOWS
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				}

				if (aux==2){// CDE/Motif
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				}

				if (aux==3){// Nimbus
				/*
				 * LookAndFeelInfo[] lafs =
				 * UIManager.getInstalledLookAndFeels();
				 * 
				 * for (LookAndFeelInfo laf : lafs) { if
				 * ("Nimbus".equals(laf.getName()))
				 * UIManager.setLookAndFeel(laf.getClassName()); }
				 */
				UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				}

			
				if (aux==4){//Obtener lista look&feel disponibles en el SO
					//http://www.codigofantasma.com/blog/java-look-feel-parte-1/
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.mac.MacLookAndFeel");
				
				}
		}catch (Exception e){
			JOptionPane.showMessageDialog(null,"No pudo cargarse la apariencia deseada", 
														"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
}
