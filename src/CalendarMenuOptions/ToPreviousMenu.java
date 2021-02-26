package CalendarMenuOptions;

import Manager.MenuClass;
import Manager.Tournament;

public class ToPreviousMenu implements CalendarMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        MenuClass.GameMenu(rfpl);
    }
}
