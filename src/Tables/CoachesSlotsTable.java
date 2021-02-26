package Tables;

import Manager.Coach;
import Manager.Corrector;
import Manager.Tournament;
import java.util.ArrayList;
import static java.lang.System.out;

public class CoachesSlotsTable extends Table implements Data{
    @Override
    public void toPrint(Tournament rfpl) {
        ArrayList<String> temporary = new ArrayList<>(rfpl.my_team.coachInterface);
        for(int x = 0, y = 0; x < 26; x++){
            if(x == 4){
                if(rfpl.my_team.coaches.size() > 0){
                    String tech = rfpl.my_team.coaches.get(y).name;
                    tech = Corrector.wordToCenter(tech, del.length());
                    temporary.set(x, temporary.get(x).replaceAll(del, tech));
                    y++;
                }
            }
            else if(x % 4 == 3 && x != 3){
                if(rfpl.my_team.coaches.size() > y){
                    String tech = rfpl.my_team.coaches.get(y).name;
                    tech = (y + 1) + " " + tech;
                    tech = Corrector.wordToCenter(tech, del.length());
                    temporary.set(x, temporary.get(x).replaceAll(del, tech));
                }
            }
            else if(x % 4 == 0 && x != 0){
                if(rfpl.my_team.coaches.size() > y){
                    if(rfpl.my_team.coaches.get(y).playerOnTrain != null){
                        String tech = rfpl.my_team.coaches.get(y).playerOnTrain.name;
                        tech += getIntensity(rfpl.my_team.coaches.get(y));
                        tech = Corrector.wordToCenter(tech, del.length());
                        temporary.set(x, temporary.get(x).replaceAll(del, tech));
                    }
                    y++;
                }
            }
            out.println(temporary.get(x));
        }
    }

    private static String getIntensity(Coach c){
        if(c.currentCoachProgram == Coach.CoachProgram.STANDART) return " S";
        else if(c.currentCoachProgram == Coach.CoachProgram.HARD) return " H";
        else return " I";
    }
}
