package TeamMenuOptions;
import Manager.*;
import java.util.ArrayList;
import static java.lang.System.out;

public class YouthAcademyOption implements TeamMenuOptionsInterface {
    @Override
    public void GetOption(Tournament rfpl) {
        out.print(Corrector.GetSpace(55));
        Corrector.wordUpperCase("youth academy");
        if(rfpl.wasAtTheYouthAcademy){
            out.println("\n\n");
            out.println(Corrector.GetSpace(48) + "You have arleady were here at this playing day!\n\n\n\n");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                return;
            }
            return;
        }
        out.println("\n\n" + Corrector.GetSpace(35) + "Welcome to youth academy pool. You can buy young players here\n");
        out.println(Corrector.GetSpace(40) + "Now you can add a one of five players in your team:\n\n");
        ArrayList<Player> youthPlace = new ArrayList<>();
        int[] places = new int[5];
        for(int x = 0; x < 5; x++){
            int rand = (int)(Math.random() * rfpl.youthPool.size());
            Player player = new Player(rfpl.youthPool.get(rand).name, 0);
            String tech = player.name;
            String tech2 = player.position;
            tech = Corrector.Inspacer(tech);
            tech2 = Corrector.Inspacer4Sym(tech2);
            places[x] = rand;
            youthPlace.add(player);
            out.println(Corrector.GetSpace(41) + (x+1) + ".\t" + tech + "\t" + tech2 + "\t(" +
                    player.power + ")\t" + player.price + "\n");
        }
        out.println(Corrector.GetSpace(50) +
                "Choose a player to add in your club.\n" +
                Corrector.GetSpace(38) + "Warning! You can buy player only if you have enough credits!");
        int choose = Corrector.InputIntMethod(0, 5);
        choose--;
        if(choose == -1) return;
        else{
            if(rfpl.my_team.wealth >= youthPlace.get(choose).price){
                out.println(Corrector.GetSpace(50) + "Do you want to buy " + youthPlace.get(choose).name +
                        "?\n" + Corrector.GetSpace(62) + "1 - \"Yes\"" +
                        "\n" + Corrector.GetSpace(62) + "0 - \"No\": ");
                int anotherChoose = Corrector.InputIntMethod(0, 1);
                if(anotherChoose == 1){
                    rfpl.my_team.list.add(youthPlace.get(choose));
                    out.println(Corrector.GetSpace(46) + "Choose a player number to new young player: ");
                    rfpl.my_team.list.get(rfpl.my_team.list.size() - 1).number =
                            Short.parseShort(new PlayerEditorOption().guessNumber(rfpl));
                    rfpl.my_team.wealth -= youthPlace.get(choose).price;
                    rfpl.youthPool.remove(places[choose]);
                    rfpl.wasAtTheYouthAcademy = true;

                    new ListPlayerOption().GetOption(rfpl);
                }
            }
            else out.println("\n\n\t\t\tYour club hasn't enough credits to buy this player\n");
        }

    }
}
