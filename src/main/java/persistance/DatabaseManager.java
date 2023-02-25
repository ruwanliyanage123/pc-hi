package persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String url= "jdbc:mysql://localhost:3306/device_store";
    private static final String className= "com.mysql.cj.jdbc.Driver";
    private static final String userName= "root";
    private static final String password= "password";
    private Connection connection;

    public DatabaseManager(){
        try{
            Class.forName(className);
            connection = DriverManager.getConnection(url,userName,password);
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection != null){
                    connection.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
