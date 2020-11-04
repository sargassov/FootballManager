package GameMenuInterfaces;
import Manager.Tournament;

import java.util.ArrayList;

import static java.lang.System.out;
public class QuitInterface implements GameMenuInterface {



    @Override
    public void Do(Tournament rfpl) {
            out.println("QUIT");

    }

    @Override
    public void toPrintMenu(ArrayList<String> fields) {

    }
}
