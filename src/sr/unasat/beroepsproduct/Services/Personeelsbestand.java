package sr.unasat.beroepsproduct.Services;

import sr.unasat.beroepsproduct.Repositories.Werknemer;

import java.util.Scanner;

public class Personeelsbestand {

    public void personeelsBestandMethode() throws Exception{
        Scanner myObj = new Scanner(System.in);
        System.out.println("Menu Personeelsbestand");
        System.out.println("Kies 1 voor het toevoegen van een nieuwe medewerker");
        System.out.println("Kies 2 voor het oproepen van medewerkers");
        System.out.println("Kies 3 voor het muteren van medewerkers van afdeling en/of functie");
        System.out.println("Kies 4 voor het verwijderen van medewerkers uit het bestand");
        int menuOptie = myObj.nextInt();

        if (menuOptie == 2){
            Werknemer read = new Werknemer();
            read.read();
        }

        if (menuOptie == 1){
            Werknemer create = new Werknemer();
            create.create();
        }

        if (menuOptie == 4){
            Werknemer delete = new Werknemer();
            delete.delete();
        }

        if (menuOptie == 3){
            Werknemer update = new Werknemer();
            update.update();

        }
    }
}
