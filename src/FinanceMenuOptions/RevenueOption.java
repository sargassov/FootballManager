package FinanceMenuOptions;

import Manager.*;
import Tables.*;

public class RevenueOption implements FinanceMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        System.out.print("\n" + Corrector.GetSpace(50));
        Corrector.wordUpperCase("Revenue mode " + rfpl.my_team.name);
        System.out.println("\n");
        new RevenueTable().toPrint(rfpl);
    }
}
