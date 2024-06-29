package inventaris_gudang;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_connection {

    public static Connection mysqlconfig;
    public static Connection configDB() throws SQLException {

        try {

            String url = "jdbc:mysql://localhost:3306/db_inventaris_gudang";
            String username = "root";
            String password = "";

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, username, password);
            
        } catch (Exception e) {

            System.err.println("Your connection is failed!" + e.getMessage());
            
        }
        
        return mysqlconfig;
           
    }

}