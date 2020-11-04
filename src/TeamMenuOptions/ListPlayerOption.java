package TeamMenuOptions;

import Manager.Corrector;
import Manager.Player;
import Manager.Tournament;
import Tables.Table;

import java.util.ArrayList;

import static java.lang.System.out;

public class ListPlayerOption implements TeamMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        Table.ListPlayerOptionTable(rfpl);
        char choise;
        //cin >> choise;
        //commands_choise(choise, rfpl, temp);
    }

    /*void commands_choise(char& choise, Tournament& rfpl, vector<Player>temp) {
        if (choise != 'M' && choise != 'm' && choise != 'Ь' && choise != 'ь' && choise != '0') {
            cout << "\n\n\t\t\tIncorrect choise. Choose again: ";
            cin >> choise;
            commands_choise(choise, rfpl, temp);
        }
        else if (choise == 'M' || choise == 'm' || choise == 'Ь' || choise == 'ь')
            players_menu(rfpl, temp);
    }

    void players_menu(Tournament& rfpl, vector<Player>temp) {
        short choise = 0;
        cout << "\n\nM E N U:\n\n==> 0. Quit\n\nSORTING:\n\n==> 1. Sort by name\n==> 2. Sort by number\n==> 3. Sort by nationality\n"
        "==> 4. Sort by position\n==> 5. Sort by goalkeeper ability\n==> 6. Sort by defender ability\n==> "
        "7. Sort by midfielder ability\n==> 8. Sort by forward ability\n==> 9. Sort by captain ability\n"
        "==> 10. Sort by injuries\n==> 11. Sort by time before treatment\n==> 12. Sort by training ability\n"
        "==> 13. Sort by year of birth\n==> 14. Sort by price\n==> 15. Sort by power\n\nPLAYER:\n\n==> 16. Player menu: ";
        string str;
        cin >> str;
        choise = choiseCorrector(str, choise);
        check_choise(choise, 16);
        do_command(rfpl, temp, choise, 0);
    }

    void do_command(Tournament&rfpl, vector<Player>&temp, short choise, short back) {
        Player* playerA, * playerB;
        if (choise == 16) playerViewMenu(rfpl, temp);
        for (short x = 0; x < temp.size() - 1; x++) {
            for (short y = 0; y < temp.size() - 1 - x; y++) {
                playerA = &temp[y];
                playerB = &temp[y + 1];
                if (choise == 1 && playerA->name > playerB->name) swap(*playerA, *playerB);
                if (choise == 2 && playerA->number > playerB->number) swap(*playerA, *playerB);
                if (choise == 3 && playerA->natio > playerB->natio) swap(*playerA, *playerB);
                if (choise == 4 && playerA->position > playerB->position) swap(*playerA, *playerB);
                if (choise == 5 && playerA->gk_able < playerB->gk_able) swap(*playerA, *playerB);
                if (choise == 6 && playerA->def_able < playerB->def_able) swap(*playerA, *playerB);
                if (choise == 7 && playerA->mid_able < playerB->mid_able) swap(*playerA, *playerB);
                if (choise == 8 && playerA->forw_able < playerB->forw_able) swap(*playerA, *playerB);
                if (choise == 9 && playerA->captain_able < playerB->captain_able) swap(*playerA, *playerB);
                if (choise == 10 && playerA->is_injury > playerB->is_injury) swap(*playerA, *playerB);
                if (choise == 11 && playerA->time_before_treat > playerB->time_before_treat) swap(*playerA, *playerB);
                if (choise == 12 && playerA->training_able < playerB->training_able) swap(*playerA, *playerB);
                if (choise == 13 && playerA->year_birth > playerB->year_birth) swap(*playerA, *playerB);
                if (choise == 14 && playerA->price < playerB->price) swap(*playerA, *playerB);
                if (choise == 15 && playerA->power < playerB->power) swap(*playerA, *playerB);

            }
        }
        if(!back)listPlayers(rfpl, temp);
    }*/
}
