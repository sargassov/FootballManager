package Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static java.lang.System.exit;
import static java.lang.System.out;
import java.lang.Cloneable;

public class FootballCalendar implements Cloneable {

    public static void SheduleCreator(Tournament rfpl) throws IOException {
        String result = "";
        GregorianCalendar startdate = new GregorianCalendar(2019, 7, 3);
        GregorianCalendar currentdate = startdate;
        out.println(startdate.toString());
        Draw[] DrawList = new Draw[16];
        List<Integer> num = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));
        for (short x = 0; x < rfpl.teams.length; x++) {
            Draw draw = new Draw();
            int count = (int) (Math.random() * num.size());
            //out.println(count);
            draw.PlaceOfLot = num.get(count) + 1;
            num.remove(count);
            draw.NameOfTeam = rfpl.teams[x].name;
            DrawList[x] = draw;
        }
        try (FileReader InCalendar = new FileReader("C:\\Users\\Сергей\\IdeaProjects\\Football Manager" +
                "\\src\\Manager\\calendar.txt")) {
            BufferedReader reader = new BufferedReader(InCalendar);
            String line = reader.readLine();
            for (short x = 0; x < 30; x++) {
                String[] StringMass = line.split("/");
                int y = 0;
                for (String string : StringMass) {
                    DayMatch daymatch = new DayMatch();
                    String[] match = string.split("-");
                    int home, away;
                    home = Integer.parseInt(match[0]);
                    away = Integer.parseInt(match[1]);
                    for (Draw draw : DrawList) {
                        if (draw.PlaceOfLot == home) {
                            daymatch.home = draw.NameOfTeam;
                            daymatch.stadium = GetStadium(draw.NameOfTeam, rfpl);
                        }
                        if (draw.PlaceOfLot == away) {
                            daymatch.away = draw.NameOfTeam;
                        }

                    }
                    rfpl.shedule.get(x).set(y, daymatch);
                    rfpl.shedule.get(x).get(y).date = (GregorianCalendar) currentdate.clone();
                    y++;
                }
                line = reader.readLine();
                if (x % 2 == 1) {
                    currentdate.add(Calendar.DAY_OF_MONTH, 7);
                } else {
                    currentdate.add(Calendar.DAY_OF_MONTH, 14);
                }
            }
        } catch (IOException ex) {
            out.println("\n\n\t\t\tLOAD FILE WITH THE CALENDAR\n\n");
            exit(0);
        }

    }

    public static void EditCalendar(Tournament rfpl) {
        for (ArrayList<DayMatch> DM : rfpl.shedule) {
            for (DayMatch dm : DM) {
                out.println(dm.toString());
            }
        }
        rfpl.calendar = new ArrayList<ArrayList<Day>>();
        GregorianCalendar startdate = new GregorianCalendar(2019, 7, 1);
        short[] buffshort = {31, 30, 31, 30, 31, 31, 29, 31, 30, 31, 6};
        Integer count = new Integer(0);
        for (short s : buffshort) {
            ArrayList<Day> month = new ArrayList<Day>();
            for (short x = 0; x < s; x++) {
                Day day;
                if(rfpl.shedule.get(count).get(0).date.get(Calendar.DAY_OF_MONTH) ==
                        startdate.get(Calendar.DAY_OF_MONTH) && rfpl.shedule.get(count).get(0).date.get(Calendar.MONTH) ==
                        startdate.get(Calendar.MONTH) ){
                    day = GetDayMatchFromShedule(rfpl.shedule.get(count), rfpl.my_team.name);
                    count++;
                    //if(count > 29) count = 29;
                }
                else {
                    day = new DayTrain();
                    day.date = (GregorianCalendar) startdate.clone();
                    //SheduleComparer(rfpl, day);
                }
                month.add(day);
                startdate.add(Calendar.DAY_OF_MONTH, 1);
            }
            out.println(month.size());
            rfpl.calendar.add(month);
        }

        out.println("calendar size = " + rfpl.calendar.size());
        for (ArrayList<Day> month : rfpl.calendar) {
            for (Day day : month) {
                //out.print(day.toString());
                if (day instanceof DayMatch) {
                    DayMatch dm = (DayMatch) day;
                    out.println(dm.toString());
                } else {
                    DayTrain dt = (DayTrain) day;
                    out.println(dt.toString());
                }
                //for(Day day : month){
                //
                //}
            }
        }
    }

    private static DayMatch GetDayMatchFromShedule(ArrayList<DayMatch>shedule, String TeamName){
        for(DayMatch dayMatch : shedule){
            if(dayMatch.home.equals(TeamName) || dayMatch.away.equals(TeamName)){
                return dayMatch;
            }
        }
        return new DayMatch();
    }

    private static void SheduleComparer(Tournament rfpl, Day day) {
        for (ArrayList<DayMatch> tour : rfpl.shedule) {
            if (day.date.get(Calendar.DAY_OF_MONTH) == tour.get(0).date.get(Calendar.DAY_OF_MONTH) &&
                    day.date.get(Calendar.MONTH) == tour.get(0).date.get(Calendar.MONTH)) {
                for (DayMatch match : tour) {
                    if (match.home.equals(rfpl.my_team.name) || match.away.equals(rfpl.my_team.name)) {
                        day = match;
                        day.MatchParameter = true;
                    }
                }
            } else {
                DayTrain train = new DayTrain();
                day = train;
            }
        }
    }

    public static String GetStadium(String name, Tournament rfpl) {
        for (Team team : rfpl.teams) {
            if (name.equals(team.name)) {
                return team.stadium;
            }
        }
        return "";
    }

}
