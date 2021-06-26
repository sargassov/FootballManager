package Manager;


import java.io.*;



public class NewGameCreator {

    private Tournament rfpl;

    public NewGameCreator(){
        rfpl = null;
    }

    public void CreateGame() throws IOException, InterruptedException {


        Tournament rfpl = new Tournament("Premier League");

        OpenSource openSource = new OpenSource(rfpl);
        openSource.unpack();

        Strategy strategy = new Strategy(rfpl);
        Strategy.strategyСreator();
        Strategy.autoStrategyCreator();
        Strategy.сaptainDeterminer();
        Strategy.powerTeamCounter();

        MenuClass menuClass = new MenuClass(rfpl);
        menuClass.newGameMenu();

        YouthAcademy youthAcademy = new YouthAcademy(rfpl);
        youthAcademy.youthAcademyPlayersAdd();

        FootballCalendar footballCalendar = new FootballCalendar(rfpl);
        footballCalendar.sheduleCreator();
        footballCalendar.editCalendar();

        Interface in = new Interface(rfpl);
        Interface.createInterfaces();
        Interface.readCoachInterface();

        MenuClass.gameMenu();
    }
}

