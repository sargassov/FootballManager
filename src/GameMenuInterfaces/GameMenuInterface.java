package GameMenuInterfaces;
import Manager.Tournament;

import java.util.ArrayList;
import static java.lang.System.out;
public interface GameMenuInterface {
    public void Do(Tournament rfpl);
    public void toPrintMenu(ArrayList<String>fields);

}
