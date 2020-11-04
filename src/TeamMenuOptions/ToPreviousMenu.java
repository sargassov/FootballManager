package TeamMenuOptions;

import Manager.MenuClass;
import Manager.Tournament;

public class ToPreviousMenu implements TeamMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        MenuClass.GameMenu(rfpl);
    }
}
