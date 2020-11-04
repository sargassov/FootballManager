package GameMenuInterfaces;
import Manager.Corrector;
import Manager.Tournament;
import TeamMenuOptions.*;
import java.util.ArrayList;
import static java.lang.System.out;


public class TeamMenuInterface implements GameMenuInterface{
    @Override
    public void Do(Tournament rfpl) {
        while (true) {
            toPrintMenu(rfpl.interfaces.get(2).fields);
            int choise = Corrector.InputIntMethod(0, 5);
            ArrayList<TeamMenuOptionsInterface> TeamMenuInterfaces = new ArrayList<TeamMenuOptionsInterface>();
            TeamMenuInterfaces.add(new ToPreviousMenu());
            TeamMenuInterfaces.add(new ListPlayerOption());
            TeamMenuInterfaces.add(new TeamTacticOption());
            TeamMenuInterfaces.add(new CaptainChoosingOption());
            TeamMenuInterfaces.add(new PlayerEditorOption());
            TeamMenuInterfaces.add(new YouthAcademyOption());
            TeamMenuInterfaces.get(choise).GetOption(rfpl);
        }
    }

    @Override
    public void toPrintMenu(ArrayList<String> fields){
        for (String string : fields) {
            out.println(string);
        }
    }
}
