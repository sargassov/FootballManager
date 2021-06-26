package Manager;

import java.util.*;

public class Team {
    public String name;
    public String town;
    public String stadium;
    public short games = 0;
    public short wons = 0;
    public short draws = 0;
    public short loses = 0;
    public short goal_sc = 0;
    public short goal_lo = 0;
    public short team_power = 0;
    public int capacity_stad;
    public ArrayList<Coach>coaches = new ArrayList<Coach>();
    public double wealth;
    public ArrayList<Player> list = new ArrayList<Player>();
    public Strategy strategy = new Strategy();
    public ArrayList<String> coachInterface;

    public Team(String Info) {
        String[] StringMass = Info.split("/");
        for(short count = 0; count < StringMass.length; count++){
            if (count == 0) name = new String(StringMass[count]);
            if (count == 1) town = StringMass[count];
            if (count == 2) stadium = StringMass[count];
            if (count == 3) {
                Manager manager = new Manager(StringMass[count]);
                if(coaches.size() == 0) {coaches.add(manager);}
            }
            if (count == 4) capacity_stad = Integer.parseInt(StringMass[count]);
            if (count == 5) wealth = Double.parseDouble(StringMass[count]);
        }

    }

}
