package CalendarMenuOptions;

import Manager.Corrector;
import Manager.DayMatch;
import Manager.Tournament;

import java.util.ArrayList;
import java.util.Calendar;

public class PlayingCalendar implements CalendarMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        int tour = 0;
        while(true){
            System.out.print(Corrector.GetSpace(40));
            Corrector.wordUpperCase("playing calendar " + rfpl.my_team.name + "\n\n");
            System.out.println((tour + 1) + " tour:\n\n");
                for(DayMatch dayMatch : rfpl.shedule.get(tour)){
                    System.out.println(isUserTeam(dayMatch.home, rfpl) + " - " +
                            isUserTeam(dayMatch.away, rfpl) + " at " +
                            dayMatch.stadium + " in " + dayMatch.date.get(Calendar.DAY_OF_MONTH) +
                            "." + dayMatch.date.get(Calendar.MONTH) + "." +
                            dayMatch.date.get(Calendar.YEAR) + "\n\n");
                }

            System.out.println("\"2\" - To look a new game day\n" +
                    "\"1\" - To look a previous game day\n\n" +
                    "\"0\" - To qiut a previous menu: ");
            int choise = Corrector.InputIntMethod(0, 2);
            if(choise == 0) break;
            else if(choise == 2){
                tour++;
                if(tour == rfpl.shedule.size())
                    tour = 0;
            }
            else{
                tour--;
                if(tour == -1)
                    tour = rfpl.shedule.size() - 1;
            }
        }


    }

    private String isUserTeam(String team, Tournament rfpl){
        if(team.equals(rfpl.my_team.name))
            return team.toUpperCase();
        return team;
    }
}
