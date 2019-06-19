package sr.unasat.beroepsproduct.Repositories;

import java.sql.*;
import java.util.Scanner;

public class Werknemer {

    public void Create () throws Exception{
        String url = "jdbc:mysql://localhost:3306/beroepsproduct";
        String uname = "root";
        String pass = "";
        String query = "insert into werknemer (personeelsnr, voornaam, familienaam, geboortedatum, address, telefoonnummer, geslacht, startdatum, functie_id, afdeling_id) values(?,?,?,?,?,?,?,?,?,?)";

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);

        Scanner myObj = new Scanner(System.in);
        System.out.println("Typ hieronder de personeelsnummer van de nieuwe medewerker");
        int personeelsnr = myObj.nextInt();

        Scanner myobj1 = new Scanner(System.in);
        System.out.println("typ hieronder de voornaam van de nieuwe medewerker");
        String voornaam = myobj1.nextLine();

        Scanner myObj2 = new Scanner(System.in);
        System.out.println("Typ hieronder de familienaam van de nieuwe medewerker");
        String familienaam = myObj2.nextLine();

        Scanner myObj3 = new Scanner(System.in);
        System.out.println("Typ hieronder de geboortedatum van de nieuwe medewerker");
        int geboortedatum = myObj3.nextInt();

        Scanner myObj4 = new Scanner(System.in);
        System.out.println("Typ hieronder het address van de nieuwe medewerker");
        String address = myObj4.nextLine();

        Scanner myObj5 = new Scanner(System.in);
        System.out.println("Typ hieronder de telefoonnummer van de nieuwe medewerker");
        int telefoonnummer = myObj5.nextInt();

        Scanner myObj6 = new Scanner(System.in);
        System.out.println("Typ hieronder het geslacht van de nieuwe medewerker");
        String geslacht = myObj6.nextLine();

        Scanner myObj7 = new Scanner(System.in);
        System.out.println("Typ hieronder de startdatum van de nieuwe medewerker");
        int startdatum = myObj7.nextInt();

        Scanner myObj8 = new Scanner(System.in);
        System.out.println("Typ hieronder de functie_id van de nieuwe medewerker");
        int functie_id = myObj8.nextInt();

        Scanner myObj9 = new Scanner(System.in);
        System.out.println("Typ hieronder de afdeling_id van de nieuwe medewerker");
        int afdeling_id = myObj9.nextInt();



        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1,personeelsnr);
        preparedStatement.setString(2, voornaam);
        preparedStatement.setString(3,familienaam);
        preparedStatement.setInt(4, geboortedatum);
        preparedStatement.setString(5,address);
        preparedStatement.setInt(6, telefoonnummer);
        preparedStatement.setString(7,geslacht);
        preparedStatement.setInt(8, startdatum);
        preparedStatement.setInt(9,functie_id);
        preparedStatement.setInt(10, afdeling_id);

        int count = preparedStatement.executeUpdate();
        System.out.println(count + "" + "medewerker is in het systeem toegevoegd");
    }

    public void Read() throws Exception
    {
        String url = "jdbc:mysql://localhost:3306/beroepsproduct";
        String uname = "root";
        String pass = "";

        Scanner myObj = new Scanner(System.in);
        System.out.println("Typ hieronder de personeelsnummer van de persoon wiens record u wilt oproepen");
        int personeelsNummer = myObj.nextInt();


        String query = "select * from werknemer join afdeling on werknemer.afdeling_id = afdeling.afdeling_id join functie on werknemer.functie_id = functie.functie_id where werknemer_id = " + personeelsNummer;
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()) {

            int werknemer_id = rs.getInt("werknemer_id");
            int personeelsnummer = rs.getInt("personeelsnr");
            String naam = rs.getString("voornaam") + " " + rs.getString("familienaam");
            String address = rs.getString("address");
            int telefoonnummer = rs.getInt("telefoonnummer");
            String geslacht = rs.getString("geslacht");
            Date startdatum = rs.getDate("startdatum");
            String functie = rs.getString("naam");
            String afdeling = rs.getString("afdelingnaam");


            System.out.println("werknemer_id :" + werknemer_id);
            System.out.println("personeelsnummer : " + personeelsnummer);
            System.out.println("naam : " + naam);
            System.out.println("address : " + address);
            System.out.println("telefoonnummer : " + telefoonnummer);
            System.out.println("geslacht : " + geslacht);
            System.out.println("startdatum : " + startdatum);
            System.out.println("functie : " + functie);
            System.out.println("afdeling : " + afdeling);
        }

        st.close();
        con.close();


    }

    public void Update() throws  Exception{
        String url = "jdbc:mysql://localhost:3306/beroepsproduct";
        String uname = "root";
        String pass = "";

        Scanner myObj = new Scanner(System.in);
        System.out.println("Typ hieronder de personeelsnummer");
        int personeelsNummer = myObj.nextInt();

        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Typ hieronder de afdeling_id");
        int afdeling = myObj.nextInt();

        Scanner myObj2 = new Scanner(System.in);
        System.out.println("Typ hieronder de functie_id");
        int functie = myObj.nextInt();

        String query = "update werknemer set functie_id=" + functie + ", afdeling_id=" + afdeling + " "+"where werknemer_id=" +personeelsNummer;
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
        System.out.println("Typ hieronder de werknemer_id van de persoon die uit het systeem moet worden gewist");
        int personeelsNummer = myObj.nextInt();

        String query = "delete from werknemer where werknemer_id=" + personeelsNummer;

        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection(url,uname,pass);
        Statement st = con.createStatement();
        int count = st.executeUpdate(query);
        System.out.println(count + " " + "medewerker" + " " + "is uit het systeem gewist");
    }

}
