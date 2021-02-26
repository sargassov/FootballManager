package FinanceMenuOptions;

import Manager.*;
import Tables.Table;

public class RevenueOption implements FinanceMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        System.out.print(Corrector.GetSpace(50));
        Corrector.wordUpperCase("Revenue mode\n\n\n");
        //Table.revenueTable();
    }
}
