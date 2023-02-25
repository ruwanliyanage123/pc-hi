package database;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseManager {
    private static String url;
    private static String className;
    private static String userName;
    private static String password;
    private Connection connection;

    private DatabaseManager(){
        try{
            readProperties();
            Class.forName(className);
            connection = DriverManager.getConnection(url,userName,password);
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }
    }

    private static final class DatabaseManagerLazyLoader{
        public static final DatabaseManager INSTANCE = new DatabaseManager();
    }

    public static DatabaseManager getInstance(){
        return DatabaseManagerLazyLoader.INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }

    private void readProperties(){
        String path = "src/main/resources/database.properties";
        InputStream inputStream;
        try{
            final Properties properties = new Properties();
            inputStream = Files.newInputStream(Paths.get(path));
            properties.load(inputStream);
            url = properties.getProperty("url");
            userName = properties.getProperty("userName");
            password = properties.getProperty("password");
            className = properties.getProperty("className");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
