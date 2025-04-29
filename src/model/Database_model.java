package model;
import com.microsoft.sqlserver.jdbc.SQLServerConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;

/**
 *
 * @author hq151
 */
public class Database_model {
    private Connection conn;
        // ket noi database
    public Connection getConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=DACN_QLTV;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String password = "123";
        conn = null;
        
        try {
        conn = DriverManager.getConnection(url, user, password);
            System.out.println("Kết nối thành công!");
             return conn;
        } catch (SQLException e) {
            return getConnection();
        }
       
    } 
     // dong ket nối
         public void closeConnect() throws SQLException{
             conn.close();
         }
}
