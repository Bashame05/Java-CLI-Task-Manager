package taskmanagerdb;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final Dotenv dotenv = Dotenv.load();
    private  static final String url= requireEnv("DB_URL");
    private  static final String username=requireEnv("DB_USER");
    private  static final String password=requireEnv("DB_PASSWORD");

    private DBConnection () {}
    private static String requireEnv(String key){
        String value = dotenv.get(key);
        if(value == null || value.isBlank()){
            throw new RuntimeException("Missing environment variable: "+key);
        }
        return value;
    }
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }
}
