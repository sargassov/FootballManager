package Manager;

import GameMenuInterfaces.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static java.lang.System.out;

public class Tournament {
    String name;
    Team[] teams;
    ArrayList<Player>youthPool;
    ArrayList<ArrayList<DayMatch>>shedule;
    public ArrayList<ArrayList<Day>> calendar;
    ArrayList<GameMenuInterface> UserInterfaces;
    public Team my_team = null;
    public ArrayList<Strategy>strategies;
    public ArrayList<Interface>interfaces;
    public Calendar currentDate;

    public Tournament(String NameOfLeague){
        name = NameOfLeague;
        teams = new Team[16];
        youthPool = null;
        SheduleConstructor();
        strategies = null;
        CalendarConstructor();
        IntefaceConstructor();
        interfaces = null;
        currentDate = new GregorianCalendar(2019, 7,1);
    }

    private void SheduleConstructor(){
        shedule = new ArrayList<ArrayList<DayMatch>>();
        for(short a = 0; a < 30; a++){
            ArrayList<DayMatch> DmOuter = new ArrayList<DayMatch>();
            for(short b = 0; b < 8; b++){
                DayMatch DmInner = new DayMatch();
                DmOuter.add(DmInner);
            }
            shedule.add(DmOuter);
        }
    }

    private void CalendarConstructor(){
        calendar = new ArrayList<ArrayList<Day>>();
        short[] buffshort = {31,30,31,30,31,31,29,31,30,31,30};
        for(short s : buffshort){
            ArrayList<Day> month = new ArrayList<Day>();
            for(short x = 0; x < s; x++){
                Day day = new Day();
                month.add(day);
            }
            out.println(month.size());
            calendar.add(month);
        }
    }

    private void IntefaceConstructor(){
        UserInterfaces = new ArrayList<GameMenuInterface>();
        UserInterfaces.add(new QuitInterface());
        UserInterfaces.add(new NextMatchMenuInterface());
        UserInterfaces.add(new TeamMenuInterface());
        UserInterfaces.add(new TrainingMenuInterface());
        UserInterfaces.add(new TransferMenuInterface());
        UserInterfaces.add(new CalendarMenuInterface());
        UserInterfaces.add(new FinanceMenuInterface());
        UserInterfaces.add(new StadiumMenuInterface());
        UserInterfaces.add(new LeagueMenuInterface());
        UserInterfaces.add(new CheatCodeMenuInterface());
    }

}
