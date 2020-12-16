package GameMenuInterfaces;

import Manager.Corrector;
import Manager.Tournament;

import java.util.ArrayList;

import static java.lang.System.out;

public class TransferMenuInterface implements GameMenuInterface {

    @Override
    public void Do(Tournament rfpl) {
        while (true) {
            toPrintMenu(rfpl.interfaces.get(4).fields);
            int choise = Corrector.InputIntMethod(0, 2);
            rfpl.TransferMenuInterfaces.get(choise).GetOption(rfpl);
        }
    }

    @Override
    public void toPrintMenu(ArrayList<String> fields) {
        for (String string : fields) {
            out.println(string);
        }
    }
}
