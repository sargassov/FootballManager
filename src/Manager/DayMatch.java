package Manager;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DayMatch extends Day {
    public String home;
    public String away;
    public String stadium;

    public DayMatch(){
        home = null;
        away = null;
        stadium = null;
    }

    @Override
    public String toString(){
        return date.get(Calendar.DAY_OF_MONTH) + " " + date.get(Calendar.MONTH) + " " + date.get(Calendar.YEAR) +
                " (" + home + " " + away + ") " + stadium;
    }

}
