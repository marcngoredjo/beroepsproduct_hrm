package sr.unasat.beroepsproduct.Services;

import sr.unasat.beroepsproduct.Repositories.Afdeling;
import sr.unasat.beroepsproduct.Repositories.Functie;

import java.util.Scanner;

public class FunctieBeheer {

    public void functieBeheerMenu()throws Exception{
        System.out.println("Menu Functiebeheer");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Kies 1 voor het toevoegen van een nieuwe functie");
        System.out.println("Kies 2 voor het oproepen van de bestaande functies");
        System.out.println("Kies 3 voor het wijzigen van gegevens van een functie");
        System.out.println("Kies 4 voor het verwijderen van functies");
        int menuOptie = myObj.nextInt();

        if(menuOptie == 1){
            Functie create = new Functie();
            create.Create();
        }

        if(menuOptie == 2){
            Functie read = new Functie();
            read.read();

        }
        if(menuOptie == 3){
            Functie update = new Functie();
            update.update();
        }

        if(menuOptie == 4){
            Functie delete = new Functie();
            delete.delete();
        }


    }
}
