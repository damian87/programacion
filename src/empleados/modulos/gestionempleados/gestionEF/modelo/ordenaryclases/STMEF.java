/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases;

//import java.sql.Timestamp;
//import java.util.ArrayList;
//import javax.swing.JOptionPane;
//import javax.swing.table.AbstractTableModel;
import empleados.clases.fecha;
import static empleados.modulos.gestionempleados.gestionEF.controlador.controladorEF.combo;
import empleados.modulos.gestionempleados.gestionEF.modelo.BLL.BLLBD_EF;
import empleados.modulos.gestionempleados.gestionEF.modelo.pager.pagina1;
import empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica;
//import empleados.modulos.gestionempleados.gestionEF.modelo.BLL.EFBLLgrafica;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
//import empleados.modulos.gestionempleados.gestionEF.modelo.pager.pagina;

//import static empleados.modulos.gestionempleados.gestionEF.vista.interfaceEFgrafica.combo;
//import empleados.modulos.gestionempleados.gestionEF.vista.interfazEF;
import java.util.ArrayList;
import javax.swing.JComboBox;
/**
 *
 * @author damian
 */
public class STMEF extends AbstractTableModel{
    public static ArrayList<empleadofijo> datos = new ArrayList<empleadofijo>();
    public static ArrayList<empleadofijo> datosaux = new ArrayList<empleadofijo>();
    String[] columnas = {"DNI", "Nombre", "Departamento", "Edad", "Antigüedad", "Fecha Nac.", "Fecha Cont."};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columnas[col].toString();
    }

    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return datos.size();
    }

    //Devuelve el numero de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {

        Object dev = null;
        empleadofijo fila = (empleadofijo) datos.get(row);

         switch (col) {
           
            case 0:
                dev = fila.getDni();
                //dev = fila.getNombre();
                break;

            case 1:
                dev = fila.getNombre();
                //dev = fila.getDni();
                break;

            case 2:
                dev = fila.getDepartamento();
                break;

            case 3:
                dev = fila.getEdad();
                break;
                
            case 4:
                dev = fila.cambiarAntiguedad();
                break;
                
            case 5:
                dev = fila.getFechaNacimiento();
                break;
                
            case 6:
                dev = fila.getFechaContratacion();
                break;

        }
        return dev;
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    @Override
    public void setValueAt(Object value, int row, int col) {
        empleadofijo fila = (empleadofijo) datos.get(row);

       switch (col) {
            case 0:
                //fila.setActor_id(Integer.parseInt(value.toString()));
                //fila.setNombre(value.toString());
                fila.setDni(value.toString());
                break;

            case 1:
                //fila.setFirst_name(value.toString());
                 fila.setNombre(value.toString());
                //fila.setDni(value.toString());
                break;

            case 2:
                //fila.setLast_name(value.toString());
                fila.setDepartamento(value.toString());
                break;
            
            case 3:
                //fila.setLast_update((Timestamp) value);
                fila.setEdad(Integer.parseInt(value.toString()));
                break;
            case 4:
                fila.setAntiguedad(Integer.parseInt(value.toString()));
                break;
            case 5:
                fila.setFechaNacimiento(new fecha (value.toString()));
                break;
            case 6:
                fila.setFechaContratacion(new fecha (value.toString()));
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(empleadofijo usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        
        // empleadofijo Empfi = null;
        //java.util.Date date= new java.util.Date();
        //
        //alist
        
        BLLBD_EF filtra = new BLLBD_EF();
        filtra.listarEF_BD();
        
        for(int i=1;i<=SingletonsEF.ef.size()-1;i++) {
            //_actor = new actor(i, getCadenaAleatoria1(4), getCadenaAleatoria2(8), new Timestamp(date.getTime()));
            //ef
            addRow(SingletonsEF.ef.get(i));
            datosaux.add(SingletonsEF.ef.get(i));
            try {
                Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
              System.out.println(e);
            }
        }
    }

    public void filtrar() {
        datos.clear();
        int cont = 0;
        String nom = interfaceEFgrafica.jTextField1.getText();
        for (int i = 0; i < datosaux.size(); i++) {
            if (datosaux.get(i).getNombre().contains(nom)) {
                addRow(datosaux.get(i));
                cont++;
            }
        }
        //FrmPagerUsuari.lblContador.setText("" + cont);
        JOptionPane.showMessageDialog(null, cont+" conincidencias");
        pagina1.initLinkBox();
        
        /*int cont=0;
        //String nom=interfazEF.jTextField1.getText();
        String nom=(String) ((JComboBox)combo).getSelectedItem(); 
        for(int i=0;i<datosaux.size();i++) {
            //if(datosaux.get(i).getNombre().contains(nom)){
            if(datosaux.get(i).getNombre().toLowerCase().startsWith(nom.toLowerCase())){
                addRow(datosaux.get(i));
                cont++;
            }
        }
        JOptionPane.showMessageDialog(null, cont+" conincidencias");
        pagina1.initLinkBox();*/
        
    }
    
    

    public empleadofijo buscar(String u) {
        datos.clear();
        cargar();

        String res;
        for (int i = 0; i < datos.size(); i++) {
            res = datos.get(i).toString();
            if (res.contains(u)) {
                return datos.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(empleadofijo u) {
        datos.clear();
        cargar();

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        datos.remove(fila);
        fireTableDataChanged();
    }
    
}
