package zaehlerAblesungen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    static String url = "jdbc:sqlite:C:\\Users\\frank\\Desktop";

    static void addFileNameToUrl(String fileName) {
        url = url + fileName;
    }

    public static Connection connect() {
        Connection conn = null;
        try {
            System.out.println(url);
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url); // connecting to our database
        } catch (ClassNotFoundException | SQLException e ) {
            System.out.println("DbConnectionException" + e + "");
        }
        return conn;
    }
}
