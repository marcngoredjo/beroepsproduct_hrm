package sr.unasat.beroepsproduct.Services;

import java.util.Scanner;

public class Hoofdmenu {

    public void hoofdMenuMethod() throws Exception{

        Scanner myObj = new Scanner(System.in);
        System.out.println("Hoofdmenu");
        System.out.println("Kies 1 voor het personeelsbestand");
        System.out.println("Kies 2 voor afdelingsbeheer");
        System.out.println("Kies 3 voor functiebeheer");
        int menuOptie = myObj.nextInt();
        if(menuOptie == 1){
            Personeelsbestand optie = new Personeelsbestand();
            optie.personeelsBestandMethode();
        }
        if(menuOptie == 2){
            AfdelingsBeheer optie = new AfdelingsBeheer();
            optie.afdelingsBeheerMenu(); }

            if (menuOptie == 3){
                FunctieBeheer optieFunctie = new FunctieBeheer();
                optieFunctie.functieBeheerMenu();

        }
    }
}
