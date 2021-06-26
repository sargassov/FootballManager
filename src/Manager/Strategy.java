package Manager;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.lang.System.exit;

public class Strategy {
    private static Tournament rfpl;
    String name;
    public ConcretStrategy[] ConcretStrategyList;
    ArrayList<String>visualizer;

    public Strategy(){}

    public Strategy(Tournament rfpl){
        this.rfpl = rfpl;
    }

    public Strategy(String description) {
        String coordinat = "src\\Manager\\";
        visualizer = new ArrayList<String>();
        ConcretStrategyList = new ConcretStrategy[18];
        name = description;
        description += ".txt";
        coordinat += description;
        try(FileReader InStrategy = new FileReader(coordinat)){
            BufferedReader reader = new BufferedReader(InStrategy);
            String line = reader.readLine();
            short x = 0;
            while(line != null){
                if (x < ConcretStrategyList.length) {
                    //Player temp = new Player();
                    ConcretStrategyList[x] = new ConcretStrategy();
                    ConcretStrategyList[x].position = line;
                    //cs.player = temp;

                }
                else {
                    visualizer.add(line);
                }
                x++;
                line = reader.readLine();
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("\n\n\t\t\tLOAD FILE " + description + "\n\n");
            exit(0);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void strategyСreator() {
        rfpl.strategies = new ArrayList<Strategy>();
        Strategy strategyOne = new Strategy("4 - 4 - 2");
        rfpl.strategies.add(strategyOne);
        Strategy strategyTwo = new Strategy("3 - 5 - 2");
        rfpl.strategies.add(strategyTwo);
        Strategy strategyThree = new Strategy("3 - 4 - 3");
        rfpl.strategies.add(strategyThree);
        Strategy strategyFour = new Strategy("4 - 5 - 1");
        rfpl.strategies.add(strategyFour);
        Strategy strategyFive = new Strategy("5 - 4 - 1");
        rfpl.strategies.add(strategyFive);

        //autoStrategyCreator(rfpl);
    }

    public static void autoStrategyCreator(){
        Player currentPlayer, selectionPlayer;
        for (Team team : rfpl.teams) {//для каждой из 16 команд
            short ran = (short) (Math.random() * 5);//выбирается случайная из 5 стартегий
            team.strategy = rfpl.strategies.get(ran);//и устаналвливается как базовая
            short y = 0;
            for (ConcretStrategy concretStrategy : team.strategy.ConcretStrategyList) {//перебирается каждая из позиций стратегии
                short maxVal = 0, currentVal = 0;
                selectionPlayer = null;
                for (Player player : team.list) {//перебираются все игроки команды
                    if (concretStrategy.position.equals(player.position)
                            && !player.is_injury && !player.is_11th && player.strategy_place < 0) {
                        if (concretStrategy.position.equals("Gk"))
                            currentVal = player.gk_able;
                        else if (concretStrategy.position.equals("Def"))
                            currentVal = player.def_able;
                        else if (concretStrategy.position.equals("Mid"))
                            currentVal = player.mid_able;
                        else if (concretStrategy.position.equals("Forw"))
                            currentVal = player.forw_able;

                        if (currentVal > maxVal) {
                            selectionPlayer = player;
                            maxVal = currentVal;
                        }
                    }
                }
                if (selectionPlayer != null && !FindEqualStrategyPlace(y, team.list)) {
                    selectionPlayer.is_11th = true;
                    selectionPlayer.strategy_place = y;

                }

                selectionPlayer = null;
                y++;
            }
        }
    }

    private static boolean FindEqualStrategyPlace(short y, ArrayList<Player> list){
        boolean ReturnSign = false;
        for(Player player : list){
            if(player.strategy_place == y)
                return ReturnSign = true;
        }
        return ReturnSign;
    }

    public static void сaptainDeterminer() {
        short captainVal;
        Player capitan = null;
        for(Team team : rfpl.teams){
            captainVal = 0;
            for (Player player : team.list) {
                if(player.captain_able > captainVal){
                    captainVal = player.captain_able;
                    capitan = player;
                }
            }
            capitan.is_capitan = true;
        }
    }

    public static void powerTeamCounter() {
        for(Team team : rfpl.teams){
            for(Player player : team.list){
                if(player.strategy_place > -1 && player.strategy_place < 11){
                    team.team_power += player.power;
                    if(player.is_capitan)
                        team.team_power += player.captain_able;
                }
            }
        }
    }
}
