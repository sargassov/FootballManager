package Manager;

import GameMenuInterfaces.GameMenuInterface;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.exit;
import static java.lang.System.out;

public class Interface {
    public ArrayList<String> fields;
    Interface(){}
    Interface(String fileName) {
        try (FileReader InInteface = new FileReader(fileName)){
            BufferedReader reader = new BufferedReader(InInteface);
            fields = new ArrayList<String>();
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

    public static void CreateInterfaces(Tournament rfpl){
        rfpl.interfaces = new ArrayList<Interface>();
        Interface GameMenuInterface = new Interface("C:\\Users\\Сергей\\IdeaProjects\\Football " +
                "Manager\\src\\Manager\\GameMenuInterface.txt");
        rfpl.interfaces.add(GameMenuInterface);
        Interface NextMatchInterface = new Interface();
        rfpl.interfaces.add(NextMatchInterface);
        Interface TeamInterface = new Interface("C:\\Users\\Сергей\\IdeaProjects\\Football " +
                "Manager\\src\\Manager\\TeamInterface.txt");
        rfpl.interfaces.add(TeamInterface);
        Interface TrainingInterface = new Interface("C:\\Users\\Сергей\\IdeaProjects\\" +
                "Football Manager\\src\\Manager\\TrainingInterface.txt");
        rfpl.interfaces.add(TrainingInterface);
        Interface TransferInterface = new Interface("C:\\Users\\Сергей\\IdeaProjects\\Football Manager" +
                "\\src\\Manager\\TransferInterface.txt");
        rfpl.interfaces.add(TransferInterface);
        Interface CalendarInterface = new Interface("C:\\Users\\Сергей\\IdeaProjects\\Football " +
                "Manager\\src\\Manager\\CalendarInterface.txt");
        rfpl.interfaces.add(CalendarInterface);
        Interface FinanceInterface = new Interface();
        rfpl.interfaces.add(FinanceInterface);
        Interface StadiumInterface = new Interface();
        rfpl.interfaces.add(StadiumInterface);
        Interface LeagueInterface = new Interface();
        rfpl.interfaces.add(LeagueInterface);
        Interface CheatCodeInterface = new Interface();
        rfpl.interfaces.add(CheatCodeInterface);
    }
}
