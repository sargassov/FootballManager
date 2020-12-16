package Manager;
import GameMenuInterfaces.*;
import TeamMenuOptions.*;
import TrainingMenuOptions.CoachesMenu;
import TrainingMenuOptions.TrainingMenuOptionsInterface;
import TrainingMenuOptions.TrainingProgramsMenu;
import TransferMenuOptions.BuyingPlayerOption;
import TransferMenuOptions.SellPlayerOption;
import TransferMenuOptions.TransferMenuOptionsInterface;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import static java.lang.System.out;

public class Tournament {
    String name;
    public Team[] teams;
    public ArrayList<Player>youthPool;
    ArrayList<ArrayList<DayMatch>>shedule;
    public ArrayList<ArrayList<Day>> calendar;
    public ArrayList<GameMenuInterface> userInterfaces;
    public ArrayList<TeamMenuOptionsInterface> TeamMenuInterfaces;
    public ArrayList<TrainingMenuOptionsInterface> TrainingMenuInterfaces;
    public ArrayList<TransferMenuOptionsInterface> TransferMenuInterfaces;
    //public ArrayList<TransferMenuOptionsInterface> TransferMenuInterfaces;
    public Team my_team = null;
    public ArrayList<Strategy>strategies;
    public ArrayList<Interface>interfaces;
    public Calendar currentDate;
    public Interface transferPrintInterface;
    public boolean wasAtTheYouthAcademy = false;

    public Tournament(String NameOfLeague){
        name = NameOfLeague;
        teams = new Team[16];
        youthPool = null;
        SheduleConstructor();
        strategies = null;
        CalendarConstructor();
        IntefaceConstructor();
        TeamMenuInterfacesConstructor();
        TrainingMenuInterfaceConstructor();
        TransferMenuInterfaceConstructor();
        interfaces = null;
        currentDate = new GregorianCalendar(2019, 7,1);
        transferPrintInterface = new Interface("C:\\Users\\Сергей\\IdeaProjects\\" +
                "Football Manager\\src\\Manager\\transfer_interface.txt");
    }

    private void TransferMenuInterfaceConstructor(){
        TransferMenuInterfaces = new ArrayList<>();
        TransferMenuInterfaces.add(new TransferMenuOptions.ToPreviousMenu());
        TransferMenuInterfaces.add(new BuyingPlayerOption());
        TransferMenuInterfaces.add(new SellPlayerOption());
    }

    private void TrainingMenuInterfaceConstructor(){
        TrainingMenuInterfaces = new ArrayList<>();
        TrainingMenuInterfaces.add(new TrainingMenuOptions.ToPreviousMenu());
        TrainingMenuInterfaces.add(new CoachesMenu());
        TrainingMenuInterfaces.add(new TrainingProgramsMenu());
    }
    private void TeamMenuInterfacesConstructor(){
        TeamMenuInterfaces = new ArrayList<>();
        TeamMenuInterfaces.add(new ToPreviousMenu());
        TeamMenuInterfaces.add(new ListPlayerOption());
        TeamMenuInterfaces.add(new TeamTacticOption());
        TeamMenuInterfaces.add(new CaptainChoosingOption());
        TeamMenuInterfaces.add(new PlayerEditorOption());
        TeamMenuInterfaces.add(new YouthAcademyOption());
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
        userInterfaces = new ArrayList<GameMenuInterface>();
        userInterfaces.add(new QuitInterface());
        userInterfaces.add(new NextMatchMenuInterface());
        userInterfaces.add(new TeamMenuInterface());
        userInterfaces.add(new TrainingMenuInterface());
        userInterfaces.add(new TransferMenuInterface());
        userInterfaces.add(new CalendarMenuInterface());
        userInterfaces.add(new FinanceMenuInterface());
        userInterfaces.add(new StadiumMenuInterface());
        userInterfaces.add(new LeagueMenuInterface());
        userInterfaces.add(new CheatCodeMenuInterface());
    }

}
