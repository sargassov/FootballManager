package GameMenuInterfaces;

import Manager.Corrector;
import Manager.Tournament;

import java.util.ArrayList;

import static java.lang.System.out;

public class TrainingMenuInterface implements GameMenuInterface {

    @Override
    public void Do(Tournament rfpl) {
        while (true) {
            toPrintMenu(rfpl.interfaces.get(3).fields);
            int choise = Corrector.InputIntMethod(0, 2);
            rfpl.TrainingMenuInterfaces.get(choise).GetOption(rfpl);
        }
    }

    @Override
    public void toPrintMenu(ArrayList<String> fields) {
        for (String string : fields) {
            out.println(string);
        }
    }
}
