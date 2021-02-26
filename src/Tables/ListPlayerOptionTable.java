package Tables;

import Manager.ConcretStrategy;
import Manager.Corrector;
import Manager.Player;
import Manager.Tournament;

import java.util.ArrayList;
import static java.lang.System.out;

public class ListPlayerOptionTable extends Table implements Data {
    @Override
    public void toPrint(Tournament rfpl) {
        ArrayList<Player> temp = rfpl.my_team.list;
        int playerCount = 0;
        int tableLong = rfpl.my_team.list.size() + 6;
        String tech = Corrector.GetSpace(48);
        for(int x = 0; x < tableLong; x++) {
            for (int y = 0; y < 120; y++) {
                if (y == 0 || y == 119) upBorderElement();
                if ((x == 0 || x == 2 || x == tableLong - 1 || x == 4) && (y > 0 && y < 119)) borderElement();
                if (x == 1 && y == 1) titleInChars(rfpl.my_team.name);
                if ((x > 2 && x < tableLong - 1 && x != 4) && (y == 6 || y == 34 || y == 38 || y == 44 || y == 49 ||
                        y == 54 || y == 59 || y == 64 || y == 69 || y == 74 || y == 79 || y == 84 || y == 91 || y == 96 ||
                        y == 102 || y == 107 || y == 112)) upBorderElement();
                if (x == 3 && y == 1) out.print("Count");
                if (x == 3 && y == 7) out.print(toCenter("Name", 27));
                if (x == 3 && y == 35) out.print("Num");
                if (x == 3 && y == 39) out.print("Natio");
                if (x == 3 && y == 45) out.print("Pos ");
                if (x == 3 && y == 50) out.print(" Gk ");
                if (x == 3 && y == 55) out.print(" Def");
                if (x == 3 && y == 60) out.print(" Mid");
                if (x == 3 && y == 65) out.print("Forw");
                if (x == 3 && y == 70) out.print(" Cap");
                if (x == 3 && y == 75) out.print(" Inj");
                if (x == 3 && y == 80) out.print(" Trn");
                if (x == 3 && y == 85) out.print(" Year ");
                if (x == 3 && y == 92) out.print(" Pos");
                if (x == 3 && y == 97) out.print("Power");
                if (x == 3 && y == 103) out.print("Tire");
                if (x == 3 && y == 108) out.print(" TBT");
                if (x == 3 && y == 113) out.print(" Price");
                if ((x > 4 && x < tableLong - 1) && y == 1) enterSign(playerCount + 1, 5);
                if ((x > 4 && x < tableLong - 1) && y == 7) enterLeftSign(temp.get(playerCount).name, 27);
                if ((x > 4 && x < tableLong - 1) && y == 35) enterSign(temp.get(playerCount).number, 3);
                if ((x > 4 && x < tableLong - 1) && y == 39) enterLeftSign(temp.get(playerCount).natio, 5);
                if ((x > 4 && x < tableLong - 1) && y == 45) enterLeftSign(temp.get(playerCount).position, 4);
                if ((x > 4 && x < tableLong - 1) && y == 50) enterSign(temp.get(playerCount).gk_able, 4);
                if ((x > 4 && x < tableLong - 1) && y == 55) enterSign(temp.get(playerCount).def_able, 4);
                if ((x > 4 && x < tableLong - 1) && y == 60) enterSign(temp.get(playerCount).mid_able, 4);
                if ((x > 4 && x < tableLong - 1) && y == 65) enterSign(temp.get(playerCount).forw_able, 4);
                if ((x > 4 && x < tableLong - 1) && y == 70) enterSign(temp.get(playerCount).captain_able, 4);
                if ((x > 4 && x < tableLong - 1) && y == 75) booleanToString(temp.get(playerCount).is_injury, 4);
                if ((x > 4 && x < tableLong - 1) && y == 80) enterSign(temp.get(playerCount).training_able, 4);
                if ((x > 4 && x < tableLong - 1) && y == 85) enterSign(temp.get(playerCount).year_birth, 6);
                if ((x > 4 && x < tableLong - 1) && y == 92) {
                    enterLeftSign(printReplacement(temp.get(playerCount).strategy_place,
                            rfpl.my_team.strategy.ConcretStrategyList), 4);
                }
                if ((x > 4 && x < tableLong - 1) && y == 97) enterSign(temp.get(playerCount).power, 5);
                if ((x > 4 && x < tableLong - 1) && y == 103) enterSign(temp.get(playerCount).tire, 4);
                if ((x > 4 && x < tableLong - 1) && y == 108) enterSign(temp.get(playerCount).time_before_treat, 4);
                if ((x > 4 && x < tableLong - 1) && y == 113) enterSign(temp.get(playerCount).price, 6);
                if (y == 119) out.println();
                if (x > 4 && y == 119) playerCount++;
            }
        }
        out.println("COMMANDS:\nMenu - \"1\"\nQuit to back menu - \"0\": ");
    }

    private static void upBorderElement(){
        out.print("|");
    }

    private static void borderElement(){
        out.print("-");
    }

    private static void titleInChars(String name){
        String nameFormat = "Players of  " + name;
        String result = "";
        for(char c : nameFormat.toCharArray()){
            result += (Character.toUpperCase(c) + " ");
        }
        int len = result.length();
        for(int x = len; x < 118; x++){
            if(x%2 == 0) result += " ";
            else result = " " + result;
        }
        out.print(result);
    }

    private static void enterSign(int count, int border){
        String str = String.valueOf(count);
        int len = str.length();
        for(int x = len; x < border; x ++){
            if(x%2 == 0) str += " ";
            else str = " " + str;
        }
        out.print(str);
    }

    private static void enterSign(double count, int border){
        String str = String.valueOf(count);
        int len = str.length();
        for(int x = len; x < border; x ++){
            if(x%2 == 0) str += " ";
            else str = " " + str;
        }
        out.print(str);
    }

    private static void enterLeftSign(String word, int longer){
        String copyWord = new String(word);
        int len = copyWord.length();
        for(int x = len; x < longer; x++){
            if(x%2 == 0) copyWord = " " + copyWord;
            else copyWord += " ";
        }
        out.print(copyWord);
    }

    private static void booleanToString(boolean bool, int longer){
        String str;
        if(bool) str = "Yes";
        else str = "No";
        int len = str.length();
        for(int x = len; x < longer; x++){
            if(x%2 == 0) str = " " + str;
            else str += " ";
        }
        out.print(str);
    }

    private static String printReplacement(short value, ConcretStrategy[] posArray){
        if(value > -1 && value < 11){
            return posArray[value].position;
        }
        else if (value > 10){
            return "Sub";
        }
        else{
            return "--";
        }
    }

    private static String toCenter(String word, int longer){
        int len = word.length();
        for(int x = len; x < longer; x++){
            if(x%2 == 0) word = " " + word;
            else word += " ";
        }
        return word;
    }
}
