package Manager;

import sun.java2d.pipe.BufferedRenderPipe;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.lang.System.out;
import static java.lang.System.exit;

public class NewGameCreator {
    public static void CreateGame() throws IOException {
        Tournament rfpl = new Tournament("Premier League");
        OpenSource.Interface(rfpl);
        Strategy.strategy_creator(rfpl);
        Strategy.autoStrategyCreator(rfpl);
        Strategy.CaptainDeterminer(rfpl);
        Strategy.PowerTeamCounter(rfpl);
        MenuClass.NewGameMenu(rfpl);
        YouthAcademy.YouthAcademyPlayersAdd(rfpl);
        FootballCalendar.SheduleCreator(rfpl);
        FootballCalendar.EditCalendar(rfpl);
        Interface.CreateInterfaces(rfpl);
        MenuClass.GameMenu(rfpl);









        //game_menu(rfpl, interfaces);
    }


}

