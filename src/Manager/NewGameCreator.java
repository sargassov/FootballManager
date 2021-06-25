package Manager;

import netscape.security.UserTarget;
import sun.java2d.pipe.BufferedRenderPipe;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.System.out;
import static java.lang.System.exit;
import static java.util.concurrent.Executors.newFixedThreadPool;
import static java.util.concurrent.Executors.privilegedCallable;

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

