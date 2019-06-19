package sr.unasat.beroepsproduct.Services;

import sr.unasat.beroepsproduct.Repositories.Afdeling;

import java.util.Scanner;

public class AfdelingsBeheer {
    public void afdelingsBeheerMenu()throws Exception{
        System.out.println("Menu Afdelingsbeheer");
            Scanner myObj = new Scanner(System.in);
            System.out.println("Kies 1 voor het toevoegen van een nieuwe afdeling");
            System.out.println("Kies 2 voor het oproepen van de bestaande afdelingen");
            System.out.println("Kies 3 voor het wijzigen van gegevens van afdelingen");
            System.out.println("Kies 4 voor het verwijderen van afdelingen");
        int menuOptie = myObj.nextInt();

        if(menuOptie == 1){
            Afdeling create = new Afdeling();
            create.create();
        }

        if(menuOptie == 2) {
            Afdeling read = new Afdeling();
            read.read();
        }

        if(menuOptie == 3) {
            Afdeling update = new Afdeling();
            update.update();
        }

}}
