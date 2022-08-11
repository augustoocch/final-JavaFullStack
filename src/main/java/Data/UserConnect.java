package Data;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserConnect {
    
    private static final String SQL_SELECT = "SELECT id, nombre, apellido, email, genero, password "
            + " FROM usuarios";

    private static final String SQL_SELECT_LOGIN = "SELECT * FROM usuarios WHERE email = ? and password = ?";
    
        private static final String SQL_VALIDATE_EMAIL = "SELECT * FROM usuarios WHERE email = ?";

    private static final String SQL_INSERT = "INSERT INTO usuarios(nombre, apellido, email, genero, password) "
            + " VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE usuarios + SET nombre=?, apellido=?, email=?, genero=?, password=?, WHERE id=?";

    private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id = ?";
    
    
    
    public boolean insertar(User user) {
        
        //metodo para insertar datos en la base de datos. 
        
        Connection conn1 = null;
        PreparedStatement stmt1 = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean status = false;
        int rows = 0;
        String validate = null;
        
        try {
            
            //primero se corrobora que el mail no este registrado
            
            conn1 = dataBaseConect.getConnection();
            stmt1 = conn1.prepareStatement(SQL_VALIDATE_EMAIL);
            stmt1.setString(1, user.getEmail());
            rs = stmt1.executeQuery();
            
            status = rs.next();
            
            //si existe se manda al Servlet a la parte de error en el registro
            
            if (status == true) {
                user.setValid(false);
                System.out.println("Usuario ya existente");
            } else {
            
            //de lo contrario se al servlet a la parte de registro exitoso
                
                user.setValid(true);
                conn = dataBaseConect.getConnection();
                stmt = conn.prepareStatement(SQL_INSERT);
                stmt.setString(1, user.getNombre());
                stmt.setString(2, user.getApellido());
                stmt.setString(3, user.getEmail());
                stmt.setString(4, user.getGenero());
                stmt.setString(5, user.getPassword());

                rows = stmt.executeUpdate();
                System.out.println("Exito en el Registro");
            }
            
        } catch (SQLException e) {
            printSQLException(e);
        } //finally {
            //dataBaseConect.close(stmt);
            //dataBaseConect.close(conn);
        
        return status;
    }

    
    
    public boolean login(User user) {

        //metodo para hacer login y validar 
        
         boolean status = false;
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         int rows = 0;
         try {
             
             //se corrobora en la base de datos que exista el mail y password
             
             conn = dataBaseConect.getConnection();
             stmt = conn.prepareStatement(SQL_SELECT_LOGIN);
             stmt.setString(1, user.getEmail());
             stmt.setString(2, user.getPassword());
             rs = stmt.executeQuery();
            
             status = rs.next();

             //si existe, se manda al Servlet a la parte de exito en el login
             
             if (status) {
                 user.setValid(status);
                 System.out.println("Exito en el login");
             } else {
                 
            // de lo contrario se manda al Servlet a la parte de error en el login     
                 user.setValid(false);
                 System.out.println("Error al loggear");
             }
             
         } catch (SQLException e) {
             // process sql exception
             printSQLException(e);
         }
		return status;
	}
    

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}
 }
    