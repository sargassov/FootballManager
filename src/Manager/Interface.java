package Manager;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.exit;
import static java.lang.System.out;

public class Interface {

    private static Tournament rfpl;

    public ArrayList<String> fields;

    public Interface(){}

    public Interface(Tournament r){
        rfpl = r;
    }

    public Interface(String fileName) {
        try (FileReader InInteface = new FileReader(fileName)){
            BufferedReader reader = new BufferedReader(InInteface);
            fields = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
               fields.add(line);
               line = reader.readLine();
            }
        } catch (IOException ex) {
            out.println("\n\n\t\t\tLOAD FILE " + fileName + " \n\n");
            exit(0);
        }
    }

    public static void createInterfaces(){
        rfpl.interfaces = new ArrayList<Interface>();
        Interface GameMenuInterface = new Interface("src\\textFiles\\GameMenuInterface.txt");
        rfpl.interfaces.add(GameMenuInterface);
        Interface NextMatchInterface = new Interface();
        rfpl.interfaces.add(NextMatchInterface);
        Interface TeamInterface = new Interface
                ("src\\textFiles\\TeamInterface.txt");
        rfpl.interfaces.add(TeamInterface);
        Interface TrainingInterface = new Interface("src\\textFiles\\TrainingInterface.txt");
        rfpl.interfaces.add(TrainingInterface);
        Interface TransferInterface = new Interface("src\\textFiles\\TransferInterface.txt");
        rfpl.interfaces.add(TransferInterface);
        Interface CalendarInterface = new Interface("src\\textFiles\\CalendarInterface.txt");
        rfpl.interfaces.add(CalendarInterface);
        Interface FinanceInterface = new Interface("src\\textFiles\\financeMenu.txt");
        rfpl.interfaces.add(FinanceInterface);
        Interface StadiumInterface = new Interface();
        rfpl.interfaces.add(StadiumInterface);
        Interface LeagueInterface = new Interface();
        rfpl.interfaces.add(LeagueInterface);
        Interface CheatCodeInterface = new Interface();
        rfpl.interfaces.add(CheatCodeInterface);
    }

    public Interface(Interface other){
        int x = 0;
        this.fields = new ArrayList<>();
        for(String s : other.fields){
            this.fields.add(s);
            x++;
        }
    }

    public static void readCoachInterface() throws IOException {
        try (FileReader coachInt = new FileReader("src\\textFiles\\coach.txt")) {
            rfpl.my_team.coachInterface = new ArrayList<>();
            BufferedReader reader = new BufferedReader(coachInt);
            String line = reader.readLine();
            while (line != null) {
                rfpl.my_team.coachInterface.add(line);
                line = reader.readLine();
            }
        }
    }

}
