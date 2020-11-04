package Manager;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        MessageClass.WelcomeMessage();
        Scanner in =  new Scanner(System.in);

        int command;// = in.nextInt();
        command = 1;///////////////////&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
        GameCommander.NewGameCommander(command);

        if (command == 0) System.exit(0);
        else if (command == 1) { NewGameCreator.CreateGame();


        }
        //else if(command == 2)

    }
}
