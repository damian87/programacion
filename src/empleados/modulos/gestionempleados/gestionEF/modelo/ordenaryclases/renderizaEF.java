/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;
/**
 *
 * @author lluis
 */
public class renderizaEF {
    
     //@Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel etiqueta = new JLabel();
        etiqueta.setOpaque(true);
        
        if (row % 2 == 0) {
            etiqueta.setBackground(new Color(255, 255, 200));
        } else {
            etiqueta.setBackground(Color.white);
        }
        
        if (column == 1) {
            String nombre = (String) value;
            etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            etiqueta.setIcon(new javax.swing.ImageIcon(nombre));
        } else {
            etiqueta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            etiqueta.setText(value.toString());
        }
        
        if (isSelected) {
            etiqueta.setBackground(new Color(151, 193, 215));
        }
        return etiqueta;
    }
   
    
}
