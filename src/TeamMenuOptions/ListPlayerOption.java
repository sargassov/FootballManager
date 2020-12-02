package TeamMenuOptions;
import Manager.Corrector;
import Manager.Player;
import Manager.Tournament;
import Tables.Table;
import java.util.ArrayList;

import static java.lang.System.out;

public class ListPlayerOption implements TeamMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        Table.ListPlayerOptionTable(rfpl);
        int choise = Corrector.InputIntMethod(0, 1);
        if(choise == 0) return;
        else{
            out.println("\n\nM E N U:\n\n==> 0. Quit\n\nSORTING:\n\n==> 1. Sort by name\n==> 2. Sort by nationality\n==> " +
                    "3. Sort by number\n==> 4. Sort by player position\n==> 5. Sort by goalkeeper ability\n==> 6." +
                    " Sort by defender ability\n==> 7. Sort by midfielder ability\n==> 8. Sort by forward ability\n==> " +
                    " 9. Sort by captain ability\n==> 10. Sort by injuries\n==> 11. Sort by time training abilities\n==> 12." +
                    " Sort by year of birth\n==> 13. Sort by position in the team\n==> 14. Sort by power\n==> 15. Sort by " +
                    "tire\n==> 16. Sort by time before treatment\n==> 17. Sort by price\n\nPLAYER:\n\n==> 18. Player menu: ");
        }

        final int finalInt = Corrector.InputIntMethod(0, 18);
        if(finalInt == 0) return;
        else if(finalInt == 1 || finalInt == 2 || finalInt == 4) ListPlayerOptionSorts.sort(rfpl, finalInt);
        else if(finalInt == 3 || finalInt == 5 || finalInt == 6 || finalInt == 7 || finalInt == 8 ||
                finalInt == 9 || finalInt == 11 || finalInt == 12 || finalInt == 14 || finalInt == 15 || finalInt == 16)
            ListPlayerOptionSorts.sort(rfpl, finalInt, 0);
            //ListPlayerOptionSorts.sort(rfpl, choise, 0);
        else if(finalInt == 10) ListPlayerOptionSorts.sort(rfpl, true);
        else if(finalInt == 13) ListPlayerOptionSorts.sort(rfpl);
        else if(finalInt == 17)  ListPlayerOptionSorts.sort(rfpl, 0.0);
        else playerViewMenu(rfpl, rfpl.my_team.list);

        GetOption(rfpl);

    }


    private void playerViewMenu(Tournament rfpl, ArrayList<Player>temp) {
        out.print("\n\n" + Corrector.GetSpace(24));
        Corrector.wordUpperCase("\t\t\tplayer view menu");
        out.println("\n\n" + Corrector.GetSpace(38) + "Counter \tName\n\n");
        int x = 0;
        for(Player player : rfpl.my_team.list){
            Corrector.GetSpace(40);
            out.println(Corrector.GetSpace(40) + (x + 1) + "\t\t" + player.name);
            x++;
        }
        out.println("\nCounter number to enter a concrete player menu\nPress \"0\" to quit\n\n");
        int choise = Corrector.InputIntMethod(0, rfpl.my_team.list.size());
        concretePlayerViewMenu(choise, rfpl.my_team.list);
    }

    private static void concretePlayerViewMenu(int choise, ArrayList<Player> list){
        choise--;
        out.print("\n\n" + Corrector.GetSpace(40));
        Player choosen = list.get(choise);
        Corrector.wordUpperCase(list.get(choise).name);
        out.print("\n\n" + Corrector.GetSpace(40) + "Playing in club: " + choosen.club +
                "\n" + Corrector.GetSpace(43) + " Nationality: " + choosen.natio +
                "\n" + Corrector.GetSpace(47) + "Position: " + choosen.position +
                "\n" + Corrector.GetSpace(41) + "Number in team: " + choosen.number +
                "\n\n" + Corrector.GetSpace(41) + "Player's POWER: " + choosen.power +
                "\n" + Corrector.GetSpace(33) + "Goalkeeper's abilities: " + choosen.gk_able +
                "\n" + Corrector.GetSpace(37) + "Defender abilities: " + choosen.def_able +
                "\n" + Corrector.GetSpace(35) + "Midfielder abilities: " + choosen.mid_able +
                "\n" + Corrector.GetSpace(38) + "Forward abilities: " + choosen.forw_able +
                "\n" + Corrector.GetSpace(32) + "      Captain abilities: " + choosen.captain_able +
                "\n\n" + Corrector.GetSpace(45) + "Is injured: " + boolToS(choosen.is_injury) +
                "\n" + Corrector.GetSpace(47) + "Training: " + choosen.training_able +
                "\n" + Corrector.GetSpace(25) + "Does player a captain function: " + boolToS(choosen.is_capitan) +
                "\n" + Corrector.GetSpace(32) + "Is player in first-team: " + boolToS(choosen.is_11th) +
                "\n" + Corrector.GetSpace(41) + "Player's price: " + choosen.price + " million Euro\n");

        out.println("\n\n" + Corrector.GetSpace(50) + "\"1\" to previous\n" +
                Corrector.GetSpace(50) + "\"2\"" + " to next\n" +
                Corrector.GetSpace(50) + "\"0\" to quit: ");
        int anotherChoise = Corrector.InputIntMethod(0, 2);
        if (anotherChoise == 0) {
            return;
        }
        else if(anotherChoise == 1) {
            choise --;
            if (choise == -1) { choise = list.size();}
            concretePlayerViewMenu(choise, list);
        }
        else {
            choise += 2;
            if (choise == list.size() + 1) { choise = 1; }
            concretePlayerViewMenu(choise, list);
        }
    }

    private static String boolToS(boolean bool){
        if(bool)
            return "Yes";
        else
            return "No";
    }
}