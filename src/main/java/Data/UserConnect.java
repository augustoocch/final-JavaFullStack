package Data;

import domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserConnect {
    
    private static final String SQL_SELECT = "SELECT id, nombre, apellido, email, genero, password "
            + " FROM finalBackend";

    private static final String SQL_SELECT_LOGIN = "SELECT * FROM finalBackend WHERE email = ? and password = ?";
    
        private static final String SQL_VALIDATE_EMAIL = "SELECT * FROM finalBackend WHERE email = ?";

    private static final String SQL_INSERT = "INSERT INTO finalBackend(nombre, apellido, email, genero, password) "
            + " VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE finalBackend + SET nombre=?, apellido=?, email=?, genero=?, password=?, WHERE id=?";

    private static final String SQL_DELETE = "DELETE FROM finalBackend WHERE id = ?";
    



    public List<User> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        List<User> users = new ArrayList<>();
        try {
            conn = dataBaseConect.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String genero = rs.getString("telefono");
                String password = rs.getString("saldo");

                //user = new User(id, nombre, apellido, email, genero, password);
                //users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            dataBaseConect.close(rs);
            dataBaseConect.close(stmt);
            dataBaseConect.close(conn);
        }
        return users;
    }
    
    
    public int insertar(User user) {
        
        Connection conn1 = null;
        PreparedStatement stmt1 = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean status = false;
        int rows = 0;
        String validate = null;
        
        try {
            conn1 = dataBaseConect.getConnection();
            stmt1 = conn1.prepareStatement(SQL_VALIDATE_EMAIL);
            stmt1.setString(1, user.getEmail());
            rs = stmt1.executeQuery();
            
            status = rs.next();
            
            if (status) {
                System.out.println("Usuario ya existente");
                user.setValid(false);
            } else {
                user.setValid(status);
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
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            dataBaseConect.close(stmt);
            dataBaseConect.close(conn);
        }
        return rows;
    }

    
    
    public boolean login(User user) {

         boolean status = false;
         Connection conn = null;
         PreparedStatement stmt = null;
         ResultSet rs = null;
         int rows = 0;
         try {
             conn = dataBaseConect.getConnection();
             stmt = conn.prepareStatement(SQL_SELECT_LOGIN);
             stmt.setString(1, user.getEmail());
             stmt.setString(2, user.getPassword());
             rs = stmt.executeQuery();
            
             status = rs.next();

             if (status) {
                 user.setValid(status);
                 System.out.println("Exito en el login");
             } else {
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
    
    
    
    
/*
    
    public int actualizar(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = dataBaseConect.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, user.getNombre());
            stmt.setString(2, user.getApellido());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getGenero());
            stmt.setString(5, user.getPassword());
            stmt.setInt(6, user.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            dataBaseConect.close(stmt);
            dataBaseConect.close(conn);
        }
        return rows;
    }

    public int eliminar(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = dataBaseConect.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getId());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            dataBaseConect.close(stmt);
            dataBaseConect.close(conn);
        }
        return rows;
    }
    
    
    
    
    
         
        public User encontrar(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = dataBaseConect.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, user.getId());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String nombre = rs.getString("nombre");
            String apellido = rs.getString("apellido");
            String email = rs.getString("email");
            String genero = rs.getString("genero");
            String passw = rs.getString("password");

            user.setNombre(nombre);
            user.setApellido(apellido);
            user.setEmail(email);
            user.setGenero(genero);
            user.setPassword(passw);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            dataBaseConect.close(rs);
            dataBaseConect.close(stmt);
            dataBaseConect.close(conn);
        }
        return user;
    } 
    
*/
    
    
