package TeamMenuOptions;
import Manager.Corrector;
import Manager.Player;
import Manager.Tournament;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class CaptainChoosingOption implements TeamMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        out.print("\n\n" + Corrector.GetSpace(40)); // тeкущего капитана добавать
        Corrector.wordUpperCase("captain choosing menu");
        out.println("\n");
        Player captain = getCaptain(rfpl.my_team.list);
        if(captain == null){
            out.print(Corrector.GetSpace(35) + "There is no captain in " + rfpl.my_team.name +
                    ". Choose it?\n" + Corrector.GetSpace(48) + "1 - \"Yes\"\n" +
                    Corrector.GetSpace(48) + "0 - \"No\": ");
        }
        else{
            out.print(Corrector.GetSpace(32) + "A captain of " + rfpl.my_team.name + " is  ");
            Corrector.wordUpperCase(captain.name);
            out.println("(" + captain.captain_able + ")\n\n" + Corrector.GetSpace(40) +
                    "    Do you want to change ?\n\n" + Corrector.GetSpace(50) + "1 -\"Yes\"\n" +
                    Corrector.GetSpace(50) + "0 - \"No\": ");
        }
        int choise = Corrector.InputIntMethod(0, 1);

        if(choise == 0) return;
        else {
            out.println(rfpl.my_team.team_power);
            if(captain.strategy_place > -1) rfpl.my_team.team_power -= captain.captain_able;
            captain.is_capitan = false;
            out.println(rfpl.my_team.team_power);
            choosingForNewCaptain(rfpl);
        };
    }

    private void choosingForNewCaptain(Tournament rfpl) {

        out.println("Other players:\n");
        List <Player> compareCaps =  rfpl.my_team.list.stream()
                .sorted((player1, player2) -> player2.captain_able - player1.captain_able)
                .collect(Collectors.toList());
        out.println("Number\t Name\t\t\tCaptain abilities\n\n");
        int count = 1;
        for(Player player : compareCaps){
            out.println(count + "\t" + Corrector.Inspacer(player.name) + "\t" + player.captain_able);
            count++;
        }
        out.print("\n\nChoose a captain: ");
        int choise = Corrector.InputIntMethod(1, rfpl.my_team.list.size());
        choise--;
        compareCaps.get(choise).is_capitan = true;
        out.println(rfpl.my_team.team_power);
        if(compareCaps.get(choise).strategy_place > -1)
            rfpl.my_team.team_power += compareCaps.get(choise).captain_able;
        out.println(rfpl.my_team.team_power);
        out.print("\n" + Corrector.GetSpace(40));
        Corrector.wordUpperCase(compareCaps.get(choise).name);
        out.println(" is new captain of " + rfpl.my_team.name);
    }

    private Player getCaptain (ArrayList < Player > list) {
        Optional<Player> opt = list.stream()
                .filter(player -> player.is_capitan)
                .findAny();
        if (opt.isPresent())
            return opt.get();
        return null;
    }
}




