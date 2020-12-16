package TransferMenuOptions;

import Manager.Corrector;
import Manager.Interface;
import Manager.Player;
import Manager.Tournament;
import Tables.Table;

import java.io.IOException;

public class BuyingPlayerOption implements TransferMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        int alterTeam = 0, yourClubList = 0, alterClubList = 0;
        while(true){
            System.out.println("\n");
            System.out.print(Corrector.GetSpace(38));
            Corrector.wordUpperCase("transfer list menu");
            System.out.println("\n\n");
            Table.transferTable(rfpl, alterTeam, yourClubList, alterClubList);
            System.out.println("\nTO BUY PLAYER - \"7\"\nNext team - \"1\" Prevoius team - \"2\"\n" +
                    "Next your player - \"3\" Prevois your player - \"4\"\n" +
                    "Next alter player - \"5\" Prevoius alter player - \"6\"\n" +
                    "To quit - \"0\": ");
            int choise = Corrector.InputIntMethod(0, 7);
            if(choise == 0) break;
            else if(choise == 1) {
                alterTeam++;
                if(alterTeam == rfpl.teams.length) alterTeam = 0;
                yourClubList = 0;
                alterClubList = 0;
            }
            else if(choise == 2){
                alterTeam--;
                if(alterTeam < 0)  alterTeam = rfpl.teams.length - 1;
                yourClubList = 0;
                alterClubList = 0;
            }
            else if(choise == 3) {yourClubList++; if(yourClubList == rfpl.my_team.list.size()) yourClubList = 0;}
            else if(choise == 4) {yourClubList--; if(yourClubList < 0) yourClubList = rfpl.my_team.list.size() - 1;}
            else if(choise == 5) {alterClubList++; if(alterClubList == rfpl.teams[alterTeam].list.size()) alterClubList = 0;}
            else if (choise == 6) { alterClubList--; if(alterClubList < 0) alterClubList = rfpl.teams[alterTeam].list.size() - 1;}
            else toByuPlayer(rfpl, alterTeam, yourClubList, alterClubList);
        }
    }

    private void toByuPlayer(Tournament rfpl, int alterTeam, int yourClubList, int alterClubList){
        System.out.println("\nEnter a number of alter player to byu him, or press \"0\" to quit: ");
        int choise = Corrector.InputIntMethod(0, 13);
        if(choise == 0) return;
        --choise;
        int tableChoise = alterClubList + choise;
        if(tableChoise > rfpl.teams[alterTeam].list.size() - 1) tableChoise -= rfpl.teams[alterTeam].list.size();
        if(rfpl.my_team.wealth >= rfpl.teams[alterTeam].list.get(tableChoise).price){
            System.out.println("Do you want yo byu " + rfpl.teams[alterTeam].list.get(tableChoise).name +
                    " for " + rfpl.teams[alterTeam].list.get(tableChoise).price + " ?" +
                    "\n\"1\" - Yes\n\"0\" - No: ");
            int yesOrNoChoise = Corrector.InputIntMethod(0, 1);
            if(yesOrNoChoise == 0) return;
            else{
                Player player = rfpl.teams[alterTeam].list.get(tableChoise);
                rfpl.my_team.wealth -= player.price;
                rfpl.teams[alterTeam].wealth += player.price;
                rfpl.teams[alterTeam].list.remove(player);
                player.club = rfpl.my_team.name;
                System.out.println(player.name + " has just join in " + rfpl.my_team.name + " from " +
                        rfpl.teams[alterTeam].name + " for " + player.price + " mln. EURO!\n" +
                        "Choose a player number: ");
                player.number = Corrector.getNumber(rfpl);
                rfpl.my_team.list.add(player);

            }
        }
        else System.out.println("\n\n" + rfpl.my_team.name + " can't buy " + rfpl.teams[alterTeam].list.get(alterClubList + choise)
        .name + ". Your club hasn't enough money!");
    }

}
