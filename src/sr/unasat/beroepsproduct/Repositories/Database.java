package sr.unasat.beroepsproduct.Repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/beroepsproduct";
        String uname = "root";
        String pass = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection con = DriverManager.getConnection(url,uname,pass);
        return con;
    }
}
