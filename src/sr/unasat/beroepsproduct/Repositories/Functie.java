package sr.unasat.beroepsproduct.Repositories;
import java.sql.*;
import java.util.Scanner;

public class Functie {

    String query = "insert into functie (naam, salaris) values(?,?)";

    public void Create () throws Exception{
        String url = "jdbc:mysql://localhost:3306/beroepsproduct";
        String uname = "root";
        String pass = "";

        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(url,uname,pass);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Typ hieronder de naam van de functie die u wilt toevoegen");
        String functienaam = myObj.nextLine();

        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Typ hieronder de salaris van die functie");
        float salaris = myObj.nextFloat();

        PreparedStatement preparedStatement = conn.prepareStatement(query);
        preparedStatement.setString(1, functienaam);
        preparedStatement.setFloat(2, salaris);

        System.out.println(query);

        int count = preparedStatement.executeUpdate();

        System.out.println(count + "" + "afdeling(en) is/zijn bijgevoegd");
    } //goed gewerkt

    public void read () throws Exception {
        String url = "jdbc:mysql://localhost:3306/beroepsproduct";
        String uname = "root";
        String pass = "";


        String query = "select * from functie";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()) {

             String test = rs.getInt("functie_id") + ":   " + rs.getString("naam") + ":   " + rs.getFloat("salaris");
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
        System.out.println("Typ hieronder de functie_id");
        int functieId = myObj.nextInt();

        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Typ hieronder de gewijzigde salaris");
        Float salaris = myObj1.nextFloat();

        String query = "update functie set salaris = " +  salaris  + " where functie_id = " + functieId;


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
        System.out.println("Typ hieronder de functie_id van de functie dat uit het systeem moet worden gehaald");
        int functie_id = myObj.nextInt();

        String query = "delete from functie where functie_id=" + functie_id;

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        int count = st.executeUpdate(query);
        System.out.println(count + "" + "functie" + "" + "is uit het systeem gewist");
    }

}
