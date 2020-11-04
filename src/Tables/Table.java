package Tables;
import Manager.Corrector;
import Manager.Player;
import Manager.Tournament;

import java.util.ArrayList;

import static java.lang.System.out;

public class Table {
    public static void ListPlayerOptionTable(Tournament rfpl){
        ArrayList<Player>temp = rfpl.my_team.list;
        int playerCount = 0;
        int tableLong = rfpl.my_team.list.size() + 6;
        String tech = Corrector.GetSpace(48);
        for(int x = 0; x < tableLong; x++){
            for(int y = 0; y < 120; y++){
                if(y == 0 || y == 119) upBorderElement();
                if((x == 0 || x == 2 || x == tableLong - 1 || x == 4) && (y > 0 && y < 119)) borderElement();
                if(x == 1 && y == 1) titleInChars(rfpl.my_team.name);
                if((x > 2 && x < tableLong - 1 && x != 4) && (y == 6 || y == 34 || y == 38 || y == 44 || y == 49||
                      y == 54 || y == 59 || y == 64 || y == 69 || y == 74 || y == 79)) upBorderElement();
                if(x == 3 && y == 1) out.print("Count");
                if(x == 3 && y == 7) out.print(toCenter("Name", 27));
                if(x == 3 && y == 35) out.print("Num");
                if(x == 3 && y == 39) out.print("Natio");
                if(x == 3 && y == 45) out.print("Pos ");
                if(x == 3 && y == 50) out.print(" Gk ");
                if(x == 3 && y == 55) out.print(" Def");
                if(x == 3 && y == 60) out.print(" Mid");
                if(x == 3 && y == 65) out.print("Forw");
                if(x == 3 && y == 70) out.print(" Cap");
                if(x == 3 && y == 75) out.print(" Inj");
                if((x > 4 && x < tableLong - 1) && y == 1) enterSign(playerCount + 1, 5);
                if((x > 4 && x < tableLong - 1) && y == 7) enterLeftSign(temp.get(playerCount).name, 27);
                if((x > 4 && x < tableLong - 1) && y == 35) enterSign(temp.get(playerCount).number, 3);
                if((x > 4 && x < tableLong - 1) && y == 39) enterLeftSign(temp.get(playerCount).natio, 5);
                if((x > 4 && x < tableLong - 1) && y == 45) enterLeftSign(temp.get(playerCount).position, 4);
                if((x > 4 && x < tableLong - 1) && y == 50) enterSign(temp.get(playerCount).gk_able, 4);
                if((x > 4 && x < tableLong - 1) && y == 55) enterSign(temp.get(playerCount).def_able, 4);
                if((x > 4 && x < tableLong - 1) && y == 60) enterSign(temp.get(playerCount).mid_able, 4);
                if((x > 4 && x < tableLong - 1) && y == 65) enterSign(temp.get(playerCount).forw_able, 4);
                if((x > 4 && x < tableLong - 1) && y == 70) enterSign(temp.get(playerCount).captain_able, 4);
                if((x > 4 && x < tableLong - 1) && y == 75) booleanToString(temp.get(playerCount).is_injury, 4);
                //if(x == 3 && y == 1)  out.print("Count   Name   Num   Natio   Pos       Gk      Def     Mid     Forw    Cap     Inj Tr  Year   Price");

                //if((y == 1 && x > 2) && (y == 1 && x != tableLong - 1)) out.print(tech);





                if(y == 119) out.println();
                if(x > 4 && y == 119) playerCount++;
            }

        }
//        out.print(Corrector.GetSpace(40));
//        Corrector.wordUpperCase("Players of  " + rfpl.my_team.name);
//        out.println("\n\nCount   Name                       Num   Natio   Pos       Gk      Def     Mid     Forw " +
//                "   Cap     Inj Tr  Year   Price\n");
//        int count = 1;
//        for (Player player : rfpl.my_team.list) {
//            out.println(count + "\t\t" + Corrector.Inspacer(player.name) + player.number + "\t\b\b" + player.natio + "\t\b\b" +
//                    player.position + "\t" + player.gk_able + "\t" + player.def_able + "\t" + player.mid_able + "\t" +
//                    player.forw_able + "\t" + player.captain_able + "\t" + player.is_injury +  "   " +
//                    player.training_able + "\t" + player.year_birth + "   " + player.price);
//            count++;
//        }
//
//        out.println("\n\nCOMMANDS:\n\nMenu - \"M\"\nQuit to back menu - \"0\"");
    }
    private static void borderElement(){
        out.print("-");
    }

    private static void upBorderElement(){
        out.print("|");
    }

    private static void titleInChars(String name){
        String nameFormat = "Players of  " + name;
        String result = "";
        for(char c : nameFormat.toCharArray()){
            result += (Character.toUpperCase(c) + " ");
        }
        int len = result.length();
        for(int x = len; x < 120; x++){
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

    private static void enterLeftSign(String word, int longer){
        String copyWord = new String(word);
        int len = copyWord.length();
        for(int x = len; x < longer; x++){
            if(x%2 == 0) copyWord = " " + copyWord;
            else copyWord += " ";
        }
        out.print(copyWord);
    }

    private static String toCenter(String word, int longer){
        int len = word.length();
        for(int x = len; x < longer; x++){
            if(x%2 == 0) word = " " + word;
            else word += " ";
        }
        return word;
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
}
