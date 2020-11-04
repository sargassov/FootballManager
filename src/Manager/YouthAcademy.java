package Manager;

import java.util.ArrayList;

public class YouthAcademy {
    public static void YouthAcademyPlayersAdd(Tournament rfpl) {
        String pos;
        for (Team team : rfpl.teams)
            if (!rfpl.my_team.name.equals(team.name)) {
                for (short x = 0; x < 4; x++) {
                    if (x == 0) pos = "Gk";
                    if (x == 1) pos = "Def";
                    if (x == 2) pos = "Mid";
                    else pos = "Forw";
                    short count = 0;
                    for (Player player : rfpl.youthPool) {
                        if (player.position.equals(pos)) {
                            team.list.add(player);
                            team.list.get(team.list.size() - 1).club = team.name;
                            team.list.get(team.list.size() - 1).number = Player.YouthNumberCorrector(team.list);
                            rfpl.youthPool.remove(count);
                            break;
                        }
                        count++;
                    }

                }
            }
        }

    }
