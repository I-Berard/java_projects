package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbUtil {
    public static final String URL = "jdbc:postgresql://localhost:5432/java_db";
    public static final String USERNAME = "javauser";
    public static final String PASSWORD = "java@123";

    public static Connection getConnection() throws SQLException{
        // try{
        //     Class.forName("org.postgresql.Driver");
        // } catch (ClassNotFoundException ex) {
        //     System.getLogger(dbUtil.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        // }
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
