package empleados.modulos.gestionempleados.gestionEF.modelo.DAO;


import empleados.modulos.gestionempleados.gestionEF.modelo.ordenaryclases.empleadofijo;
import empleados.clases.fecha;
import java.sql.PreparedStatement;
import empleados.clases.conexionBBDD;
import java.sql.Connection;
import java.sql.SQLException;

public class dummiesef {

	public static void dummies () throws SQLException{
		
                PreparedStatement stmt = null;
                int b=0;
                Connection _con = null;
                conexionBBDD _conBBDD = new conexionBBDD();
            
		empleadofijo f=null;
		//String login, String password, String email
		String nombre [] = {"Damian", "Borja", "Miguel", "Raul", "Jose"};
		String departamento [] = {"Informatica", "Oficina", "Informatica", "Mantenimiento", "Oficina"};
		fecha FechaNacimiento [] = {new fecha("29/8/1987", '1'), new fecha("10/2/1994", '1'), new fecha("15/9/1993", '1'), new fecha("12/3/1989", '1'), new fecha("20/6/1983", '1')};
		String dni [] = {"48600102k", "48102369l", "48502123a", "48520147d", "48963123p"};
		fecha FechaContratacion [] = {new fecha ("25/1/2014", '1'), new fecha ("15/9/2003", '1'), new fecha("12/10/2006", '1'), new fecha ("22/8/2010", '1'), new fecha ("17/4/1998", '1')};
                String login [] = {"", "", "", "", ""};
                String password [] = {"", "", "", "", ""};
                String email [] = {"", "", "", "", ""};
                
		 
			//menuempleados.vef.guardar(f);
		 
                 
                 _con=_conBBDD.AbrirConexion();
                 
                 
                 for(int i=0;i<5;i++){
                    f=new empleadofijo (nombre[i], dni [i], departamento[i], FechaNacimiento[i], FechaContratacion[i], login[i], password[i], email[i]);
				//menuempleados.vef.guardar(f);
		stmt = _con.prepareStatement("INSERT INTO EFBBDD.Empleadofijo"
                    + "(nombre,edad,departamento,fechaNacimiento,suelo,dni,password,email,avatar,tipo,"
                    + "estado,antiguedad,fechaContratacion) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, f.getNombre());
            stmt.setInt(2, f.getEdad());
            stmt.setString(3, f.getDepartamento());
            stmt.setString(4, f.getFechaNacimiento().toString());
            stmt.setFloat(5, f.getSueldo());
            stmt.setString(6, f.getDni());
            stmt.setString(7, f.getPassword());
            stmt.setString(8, f.getEmail());
            stmt.setString(9, f.getAvatar());
            stmt.setString(10, f.getTipo());
            stmt.setInt(11, f.getEstado());
            stmt.setInt(12, f.cambiarAntiguedad());
            stmt.setString(13, f.getFechaContratacion().toString());
            


            b=stmt.executeUpdate();
		
			}
                 _conBBDD.CerrarConexion(_con);
                 
             
           
		
	} 
		
		
          
}
