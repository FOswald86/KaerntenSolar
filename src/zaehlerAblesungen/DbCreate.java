package zaehlerAblesungen;

import java.sql.*;

public class DbCreate {

    static void createDatabase() {

        try (Connection conn = DriverManager.getConnection( DbConnection.url )) {
            if ( conn != null ) {
                DatabaseMetaData meta = conn.getMetaData();
            }
            System.out.println( "Datenbank erstellt." );
        } catch (SQLException e) {
            System.out.println( "DbCreate.createDatabaseException " + e.getMessage() );
        }
    }

    static void createNewTable() {

        String sql = "CREATE TABLE IF NOT EXISTS card ("
                + "id integer PRIMARY KEY AUTOINCREMENT,"
                + "number text NOT NULL,"
                + "pin text NOT NULL,"
                + "balance int DEFAULT 0"
                + ");";
        System.out.println( "create tabele" );
        try (Connection con = DriverManager.getConnection( DbConnection.url );
            Statement stmt = con.createStatement()) {
            stmt.execute( sql );
            System.out.println( "Tabelle erstellt" );
        } catch (SQLException e) {
            System.out.println( "DbCreate.createNewTableException " + e.getMessage() );
        }
    }
}
