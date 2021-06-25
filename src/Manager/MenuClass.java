package Manager;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

public class MenuClass {

    private static Tournament rfpl;
    private String name;
    private String lastname;
    private String club;

    public MenuClass(Tournament rfpl){
        this.rfpl = rfpl;
    }

    public void newGameMenu(){
        out.print("\n\nEnter your name: ");
        Scanner scanner = new Scanner(System.in);
        //name = scanner.nextLine();
        name = "Mark";////////////////////////////////////////////////////////////////////////////
        out.print("\n\nEnter your lastname: ");
        //lastname = scanner.nextLine();
        lastname = "Giovanni";////////////////////////////////////////////////////////////////////////
        lastname += " ";
        lastname += name;
        out.println("\n\n");
        for (Team team : rfpl.teams) {
            out.print("\t\t||" + team.name + "||\n");
        }
        out.print("\n\nEnter a manage team: ");
        //cin >> club;///////////////////////////////////////////////////////////////////////////
        //club = scanner.nextLine();
        club = "Rostov";
        isClub();

        //compareArrayLists();
    }

//    private static void compareArrayLists(){
//
//    }

    private void isClub() {
        short count = 0;
        for (Team team : rfpl.teams) {
            if (club.equals(team.name)) {
                count++;
                rfpl.my_team = team;
                Manager manager = new Manager(lastname);
                rfpl.my_team.coaches.set(0, manager);
                break;
            }
        }
        if (count == 0) {
            MessageClass.IncorrectName();
            Scanner scanner = new Scanner(System.in);
            club = scanner.nextLine();
            isClub();
        }
    }

    public static void gameMenu(){
        toPrintMenu(rfpl.interfaces.get(0).fields);
        int choise = Corrector.InputIntMethod(0, 9);
        rfpl.userInterfaces.get(choise).Do(rfpl);
    }

    private static void toPrintMenu(ArrayList<String> fields) {
        for (String string : fields) {
            out.println(string);
        }
    }
}
