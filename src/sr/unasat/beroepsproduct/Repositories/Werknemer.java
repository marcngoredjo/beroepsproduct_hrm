package sr.unasat.beroepsproduct.Repositories;

import java.sql.*;
import java.util.Scanner;

public class Werknemer {

    public void create() throws Exception{
        Database database = new Database();
        Connection con = database.connect();

        String query = "insert into werknemer (personeelsnr, voornaam, familienaam, geboortedatum, address, telefoonnummer, geslacht, startdatum, functie_id, afdeling_id) values(?,?,?,?,?,?,?,?,?,?)";

        /**
         * Bij het aanmaken van een werknemer, een personeels-
         * nummer door het systeem laten genereren.
         */
        int personeelsnr = this.generatePersoneelsnummer();

        /**
         * Een check doen dat het personeelnummer niet voorkomt
         * in de database.
         */
        while (this.persooneelnummerDoenstExists(personeelsnr) == false) {
            personeelsnr = this.generatePersoneelsnummer();
        }

        System.out.println("PERSONEEL ID " + personeelsnr);

        Scanner myobj1 = new Scanner(System.in);
        System.out.println("typ hieronder de voornaam van de nieuwe medewerker");
        String voornaam = myobj1.nextLine();

        Scanner myObj2 = new Scanner(System.in);
        System.out.println("Typ hieronder de familienaam van de nieuwe medewerker");
        String familienaam = myObj2.nextLine();

        Scanner myObj3 = new Scanner(System.in);
        System.out.println("Typ hieronder de geboortedatum van de nieuwe medewerker");
        String geboortedatum = myObj3.next();

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
        String startdatum = myObj7.next();

        /**
         * Bewijs beschikbare functies in het systeem
         */
        Statement functie_st = con.createStatement();
        ResultSet functie_rs = functie_st.executeQuery("select * from functie");

        System.out.println("Functie ID || Naam || Salaris");
        while(functie_rs.next()) {
            String test = functie_rs.getInt("functie_id")
                        + ":   " + functie_rs.getString("naam")
                        + ":   " + functie_rs.getFloat("salaris");
            System.out.println(test);
        }
        System.out.println();
        /** --- **/

        Scanner myObj8 = new Scanner(System.in);
        System.out.println("Typ hieronder de functie_id van de nieuwe medewerker");
        int functie_id = myObj8.nextInt();

        /**
         * Bewijs beschikbare afdelingen in het systeem
         */
        Statement afdeling_st = con.createStatement();
        ResultSet afdeling_rs = functie_st.executeQuery("select * from afdeling");

        System.out.println("Afdeling ID || Afdeling naam || Afdeling");
        while(afdeling_rs.next()) {
            String test = afdeling_rs.getInt("afdeling_id")
                    + ":   " + afdeling_rs.getString("afdelingnaam")
                    + ":   " + afdeling_rs.getString("locatie");
            System.out.println(test);
        }
        System.out.println();
        /** --- **/

        Scanner myObj9 = new Scanner(System.in);
        System.out.println("Typ hieronder de afdeling_id van de nieuwe medewerker");
        int afdeling_id = myObj9.nextInt();

        PreparedStatement preparedStatement = con.prepareStatement(query);
        preparedStatement.setInt(1,personeelsnr);
        preparedStatement.setString(2, voornaam);
        preparedStatement.setString(3,familienaam);
        preparedStatement.setString(4, geboortedatum);
        preparedStatement.setString(5,address);
        preparedStatement.setInt(6, telefoonnummer);
        preparedStatement.setString(7,geslacht);
        preparedStatement.setString(8, startdatum);
        preparedStatement.setInt(9,functie_id);
        preparedStatement.setInt(10, afdeling_id);

        preparedStatement.executeUpdate();
        System.out.println("Medewerker is in het systeem toegevoegd");
    }

    public void read() throws Exception
    {
        Database database = new Database();
        Connection con = database.connect();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Typ hieronder de personeelsnummer van de persoon wiens record u wilt oproepen");
        int personeelsNummer = myObj.nextInt();

        String query = "select * from werknemer join afdeling on werknemer.afdeling_id = afdeling.afdeling_id join functie on werknemer.functie_id = functie.functie_id where personeelsnr = " + personeelsNummer;

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

    public void update() throws  Exception {
        Database database = new Database();
        Connection con = database.connect();

        Scanner myObj = new Scanner(System.in);
        System.out.println("Typ hieronder de personeelsnummer");
        int personeelsNummer = myObj.nextInt();

/**
 * Bewijs beschikbare afdelingen in het systeem
 */
        Statement afdeling_st = con.createStatement();
        ResultSet afdeling_rs = afdeling_st.executeQuery("select * from afdeling");

        System.out.println("Afdeling ID || Afdeling naam || Afdeling");
        while(afdeling_rs.next()) {
            String test = afdeling_rs.getInt("afdeling_id")
                    + ":   " + afdeling_rs.getString("afdelingnaam")
                    + ":   " + afdeling_rs.getString("locatie");
            System.out.println(test);
        }
        System.out.println();
        /** --- **/


        Scanner myObj1 = new Scanner(System.in);
        System.out.println("Typ hieronder de afdeling_id");
        int afdeling = myObj.nextInt();


        /**
         * Bewijs beschikbare functies in het systeem
         */
        Statement functie_st = con.createStatement();
        ResultSet functie_rs = functie_st.executeQuery("select * from functie");

        System.out.println("Functie ID || Naam || Salaris");
        while(functie_rs.next()) {
            String test = functie_rs.getInt("functie_id")
                    + ":   " + functie_rs.getString("naam")
                    + ":   " + functie_rs.getFloat("salaris");
            System.out.println(test);
        }
        System.out.println();
        /** --- **/

        Scanner myObj2 = new Scanner(System.in);
        System.out.println("Typ hieronder de functie_id");
        int functie = myObj.nextInt();

        String query = "update werknemer set functie_id=" + functie + ", afdeling_id=" + afdeling + " "+"where personeelsnr=" +personeelsNummer;

        Statement st = con.createStatement();
        int count = st.executeUpdate(query);
        System.out.println(count + "" + "rij(en) zijn geupdate");
    }

    public void delete() throws  Exception {
        Database database = new Database();
        Connection con = database.connect();

        /**
         * Bewijs bestaande medewerkers in het systeem
         */
        Statement werknemer_st = con.createStatement();
        ResultSet functie_rs = werknemer_st.executeQuery("select * from werknemer");

        System.out.println("personeelsnr || Voornaam || Familienaam");
        while(functie_rs.next()) {
            String test = functie_rs.getInt("personeelsnr")
                    + ":   " + functie_rs.getString("voornaam")
                    + ":   " + functie_rs.getString("familienaam");
            System.out.println(test);
        }
        System.out.println();
        /** --- **/


        Scanner myObj = new Scanner(System.in);
        System.out.println("Typ hieronder de personeelsnummer van de persoon die uit het systeem moet worden gewist");
        int personeelsNummer = myObj.nextInt();


        String query = "delete from werknemer where personeelsnr=" + personeelsNummer;

        Statement st = con.createStatement();
        int count = st.executeUpdate(query);
        System.out.println(count + " " + "medewerker" + " " + "is uit het systeem gewist");
    }

    protected boolean persooneelnummerDoenstExists(long number) throws SQLException {
        Database database = new Database();
        Connection con = database.connect();

        String query = "SELECT count(werknemer_id) FROM werknemer WHERE personeelsnr = " + number;

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()) {
            int count = rs.getInt(1);
            System.out.println("Result: " + count);
            return (count == 0) ? true: false;
        }
        return false; // Return true as if the personeelnummer exists
    }

    protected int generatePersoneelsnummer() {
        Long generate_number = new Long( Math.round(Math.random() * 1000000000) );
        return generate_number.intValue();
    }

}
