package sr.unasat.beroepsproduct.Repositories;

import java.sql.*;
import java.util.Scanner;

public class Afdeling {
    String query = "insert into afdeling (afdelingnaam, locatie) values(?,?)";

    public void Create () throws Exception{
        String url = "jdbc:mysql://localhost:3306/beroepsproduct";
        String uname = "root";
        String pass = "";

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,uname,pass);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Typ hieronder de naam van de afdeling die u wilt toevoegen");
        String afdeling = myObj.nextLine();

        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Typ hieronder de locatie van de afdeling");
        String locatie = myObj.nextLine();

        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, afdeling);
        preparedStatement.setString(2, locatie);

        System.out.println(query);

        int count = preparedStatement.executeUpdate();

        System.out.println(count + "" + "rij(en) zijn geupdate");
    }

    public void read () throws Exception {
        String url = "jdbc:mysql://localhost:3306/beroepsproduct";
        String uname = "root";
        String pass = "";


        String query = "select * from afdeling";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()) {

            String test = rs.getInt("afdeling_id") + ":   " + rs.getString("afdelingnaam") + ":   " + rs.getString("locatie");
            System.out.println(test);
        }

        st.close();
        con.close();


    }

    public void update () throws Exception {
        String url = "jdbc:mysql://localhost:3306/beroepsproduct";
        String uname = "root";
        String pass = "";

        Scanner myObj = new Scanner(System.in);
        System.out.println("Typ hieronder de afdeling_id");
        int afdelingId = myObj.nextInt();

        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Typ hieronder de gewijzigde locatie");
        String locatie = myObj1.nextLine();

        String query = "update afdeling set locatie = " + "'" + locatie + "'" + " where afdeling_id = " +afdelingId;

        System.out.println(query);

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        int count = st.executeUpdate(query);
        System.out.println(count + "" + "rij(en) zijn geupdate");
    }

    public void delete() throws  Exception{
        String url = "jdbc:mysql://localhost:3306/beroepsproduct";
        String uname = "root";
        String pass = "";
        Scanner myObj = new Scanner(System.in);
        System.out.println("Typ hieronder de afdeling_id van de afdeling dat uit het systeem moet worden gehaald");
        int afdeling_id = myObj.nextInt();

        String query = "delete from afdeling where afdeling_id=" + afdeling_id;

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        int count = st.executeUpdate(query);
        System.out.println(count + "" + "afdeling" + "" + "is uit het systeem gewist");
    }

}
