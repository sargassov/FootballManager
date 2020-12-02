package TeamMenuOptions;
import Manager.*;
import java.util.*;
import static Manager.Corrector.GetSpace;
import static java.lang.System.out;

public class TeamTacticOption implements TeamMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        out.print("\n\n" + GetSpace(40) + "U S E F U L   S T R A T E G Y  ");
        Corrector.wordUpperCase(rfpl.my_team.name);
        out.println("\n\n\n\n");
        short coef = 0;
        for (ConcretStrategy concretStrategy : rfpl.my_team.strategy.ConcretStrategyList) {
            Player targetPlayer = GetTargetPlayer(rfpl, coef);
            if (coef < 11) {
                if (concretStrategy.position.equals("Gk")) out.println(GetSpace(40) + "Goalkeeper: " +
                        targetPlayer.name + " (" + targetPlayer.gk_able + ") " + isCaptain(targetPlayer));
                else if (concretStrategy.position.equals("Def")) out.println(GetSpace(40) + "Defender: " +
                        targetPlayer.name + " (" + targetPlayer.def_able + ") " + isCaptain(targetPlayer));
                else if (concretStrategy.position.equals("Mid")) out.println(GetSpace(40) + "Midfielder: " +
                        targetPlayer.name + " (" + targetPlayer.mid_able + ") " + isCaptain(targetPlayer));
                else out.println(GetSpace(40) + "Forward: " +
                        targetPlayer.name + " (" + targetPlayer.forw_able + ") " + isCaptain(targetPlayer));
            }
            else if (coef == 11) out.println("\n\n");
            if(coef > 10) out.println(GetSpace(48) + "Substitution: " + targetPlayer.name);
            coef++;
        }
        out.println("\n\n\t\tTeam Power: " + rfpl.my_team.team_power / 11 + "\n");
        //system("pause");
        out.println("\n\n" + GetSpace(32) +"If you choose a new strategy this placement will be lost\n\n\n\n\n"
                + GetSpace(44) + "==> 1. (4 - 4 - 2)" +
        "\n\n\n\n" + GetSpace(44) + "==> 2. (3 - 5 - 2)\n\n\n\n" + GetSpace(44) +"==> 3. (3 - 4 - 3)" +
        "\n\n\n\n" + GetSpace(44) + "==> 4. (4 - 5 - 1)\n\n\n\n" + GetSpace(44) + "==> 5. (5 - 4 - 1)" +
                "\n\n\n\n" + GetSpace(44) + "==> 0. Back to previos menu\n");
        Scanner scanner = new Scanner(System.in);
        int choise = Corrector.InputIntMethod(0, 5);
        choise--;
        if(choise < 0) return;
        else rfpl.my_team.strategy = rfpl.strategies.get(choise);
        rfpl.my_team.team_power = 0;
        for (Player player : rfpl.my_team.list) {
            player.strategy_place = -100;
            if(player.is_capitan){
                player.is_capitan = false;
            }
        }
        printPlayers(rfpl);
    }

    private void printPlayers(Tournament rfpl) {
        int currentPosition = 0;
        out.println("\n\n" + GetSpace(40) + "C H O O S I N G   A   P L A C E M E N T\n");
        for(ConcretStrategy allReplacement : rfpl.my_team.strategy.ConcretStrategyList){
            int currentPositionToPrint = 0;
            for(ConcretStrategy closedReplacement : rfpl.my_team.strategy.ConcretStrategyList){
                if(currentPositionToPrint < 11) out.print(GetSpace(40) + closedReplacement.position + " ");
                else out.print(GetSpace(40) + "Sub " + closedReplacement.position + " ");
                Player targetPlayer = GetTargetPlayer(rfpl, (short)currentPositionToPrint);
                if(targetPlayer != null){
                    out.println(targetPlayer.name);
                }
                else out.println();
                if(currentPositionToPrint == 10 || currentPositionToPrint == 17) out.println("\n");
                currentPositionToPrint++;
            }
            out.println("Team power = " + rfpl.my_team.team_power / 11 + "\n\n" + GetSpace(44) +"OTHER PLAYERS IN TEAM:\nCount\tName                       " +
                    "Natio\tNum\tPos\t\tGk\tDef\tMid\tForw\tCap\tYear\tPrice\n");
            int currentPlayerInTeam = 0;
            ArrayList<Short>numbersToChoose = new ArrayList<Short>();
            for(Player player : rfpl.my_team.list){
                if(player.strategy_place < 0){
                    if(player.position.equals(allReplacement.position)){
                        numbersToChoose.add((short)currentPlayerInTeam);
                        out.println(currentPlayerInTeam + 1 + "\t\t" + Corrector.Inspacer(player.name) + player.natio + "\t\t" + player.number +
                                "\t" + player.position + "\t\t" + player.gk_able + "\t" + player.def_able + "\t" +
                                player.mid_able + "\t" + player.forw_able + "\t\t" + player.captain_able + "\t" +
                                player.year_birth + "\t" + player.price);
                    }
                }
                currentPlayerInTeam++;
            }
            out.println("\nEnter a count number to edit a " + allReplacement.position + ": ");
            int count = Corrector.InputNumberFromTheList(numbersToChoose);
            rfpl.my_team.list.get(count).strategy_place = (short)currentPosition;
            if (currentPosition < 11) {
                rfpl.my_team.team_power += rfpl.my_team.list.get(count).power;
            }
            currentPosition++;
        }
    }

    private Player GetTargetPlayer(Tournament rfpl, short coef){
        for(Player player : rfpl.my_team.list){
            if(player.strategy_place == coef){
                return player;
            }
        }
        return null;
    }
    private String isCaptain(Player player){
        if(player.is_capitan)
            return "CAPTAIN";
        return "";
    }
}

