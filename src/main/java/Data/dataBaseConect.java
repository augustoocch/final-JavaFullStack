package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.dbcp2.BasicDataSource;

public class dataBaseConect {
    
        
        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/codo-codo?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        private static final String JDBC_USER = "root";
        private static final String JDBC_PASSWORD = "";
        
        private static BasicDataSource datasource;
        
        public static BasicDataSource getDataSource() {
          
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(dataBaseConect.class.getName()).log(Level.SEVERE, null, ex);
            }
                
            if (datasource == null) {
                datasource = new BasicDataSource();
                datasource.setUrl(JDBC_URL);
                datasource.setUsername(JDBC_USER);
                datasource.setPassword(JDBC_PASSWORD);
                datasource.setInitialSize(50);
            }    
                
                return datasource;
    }
        
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
           ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
