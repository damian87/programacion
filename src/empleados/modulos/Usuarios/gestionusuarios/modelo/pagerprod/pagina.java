/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.Usuarios.gestionusuarios.modelo.pagerprod;


import empleados.modulos.Usuarios.gestionusuarios.modelo.Singletonyclases.STMUSU;
import empleados.modulos.Usuarios.gestionusuarios.modelo.pagerprod.LinkViewRadioButtonUI_;
import empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
/**
 *
 * @author damian
 */
public class pagina {
    public static final LinkViewRadioButtonUI_ ui = new LinkViewRadioButtonUI_();
    public static int LR_PAGE_SIZE = 5;
    public static Box box = Box.createHorizontalBox();

    public static int currentPageIndex = 1;
    public static int itemsPerPage = 5;
    public static int maxPageIndex;
 
    public static void inicializa() {
        int rowCount = 0;
       
         
                    //rowCount = ((STMUSU)empleados.modulos.gestionempleados.gestionEF.vista.interfaceUSUgrafica.TABLA.getModel()).getRowCount();
        rowCount = ((STMUSU)empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.TABLA.getModel()).getRowCount();
         
          
           
        
        int v = rowCount%itemsPerPage==0 ? 0 : 1;
        maxPageIndex = rowCount/itemsPerPage + v;
        
        box.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
       
                    interfaceUSUgrafica.jPanel4.setLayout(new BorderLayout());
                    interfaceUSUgrafica.jPanel4.add(pagina.box);
            
    }
    public static void initLinkBox() {
        
                   //empleados.modulos.gestionempleados.gestionEF.vista.interfaceUSUgrafica.sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                   //empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF.sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
                   empleados.modulos.Usuarios.gestionusuarios.controlador.controladorUSU.sorter.setRowFilter(new RowFilter<TableModel, Integer>() {

                        @Override public boolean include(RowFilter.Entry<? extends TableModel, ? extends Integer> entry) {
                            int ti = currentPageIndex - 1;
                            int ei = entry.getIdentifier();
                            return ti*itemsPerPage<=ei && ei<ti*itemsPerPage+itemsPerPage;
                        }
                    });
                   

        int startPageIndex = currentPageIndex-LR_PAGE_SIZE;
        int endPageIndex = 0;
        if(startPageIndex<=0) { startPageIndex = 1; }

        int rowCount = 0;
       
                rowCount = ((STMUSU)empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.TABLA.getModel()).getRowCount();
              

        int v = rowCount%itemsPerPage==0 ? 0 : 1;
        maxPageIndex = rowCount/itemsPerPage + v;
        endPageIndex = currentPageIndex+LR_PAGE_SIZE-1;
        if(endPageIndex>maxPageIndex) {
            endPageIndex = maxPageIndex;
        }

        box.removeAll();
        if(  (rowCount<=itemsPerPage) && (rowCount>0)  ){ //caben todos los datos en la misma página
            
                //actualizar botones y caja: desactivarlos
                empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.primero.setEnabled(false);
                empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.ANTERIOR.setEnabled(false);
                empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.SIGUIENTE.setEnabled(false);
                empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.ultimo.setEnabled(false);
                empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.CAJA.setText("");
             
            //actualizar enlaces: sólo 1 enlace
            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            JRadioButton c = makeRadioButton(1);
            box.add(c);
            bg.add(c);
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();
            
        }else if(rowCount==0) { //no hay rdos
           
                //actualizar botones y caja: desactivarlos
                empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.primero.setEnabled(false);
                empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.ANTERIOR.setEnabled(false);
                empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.SIGUIENTE.setEnabled(false);
                empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.ultimo.setEnabled(false);
                empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.CAJA.setText("");
              
            //actualizar enlaces: no hay enlaces
            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            JRadioButton c = makeRadioButton(0);
            box.add(c);
            bg.add(c);
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();
            
        }else if(rowCount>itemsPerPage) {
            
                    empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.primero.setEnabled(currentPageIndex>1);
                    empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.ANTERIOR.setEnabled(currentPageIndex>1);
                    empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.SIGUIENTE.setEnabled(currentPageIndex<maxPageIndex);
                    empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.ultimo.setEnabled(currentPageIndex<maxPageIndex);
                    empleados.modulos.Usuarios.gestionusuarios.vista.interfaceUSUgrafica.CAJA.setText(Integer.toString(currentPageIndex) + String.format(" / %d", maxPageIndex));
                  

            ButtonGroup bg = new ButtonGroup();
            box.add(Box.createHorizontalGlue());
            for(int i=startPageIndex;i<=endPageIndex;i++) {
                JRadioButton c = makeRadioButton(i);
                box.add(c);
                bg.add(c);
            }
            box.add(Box.createHorizontalGlue());
            box.revalidate();
            box.repaint();
        }
    }
    public static JRadioButton makeRadioButton(final int target) {
        JRadioButton radio = new JRadioButton(String.valueOf(target)) {
            @Override protected void fireStateChanged() {
                ButtonModel model1 = getModel();
                if(!model1.isEnabled()) {
                    setForeground(Color.GRAY);
                }else if(model1.isPressed() && model1.isArmed()) {
                    setForeground(Color.GREEN);
                }else if(model1.isSelected()) {
                    setForeground(Color.RED);
                }
                super.fireStateChanged();
            }
        };
        radio.setForeground(Color.BLUE);
        radio.setUI(ui);
        if(target==currentPageIndex) {
            radio.setSelected(true);
        }
        radio.addActionListener(new ActionListener() {
            @Override public void actionPerformed(ActionEvent e) {
                currentPageIndex=target;
                initLinkBox();
            }
        });
        return radio;
    }
}
