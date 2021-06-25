package FinanceMenuOptions;

import Manager.MenuClass;
import Manager.Tournament;

public class ToPreviousMenu implements FinanceMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        MenuClass.gameMenu();
    }
}
