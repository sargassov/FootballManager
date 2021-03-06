package Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class OpenSource {

    Tournament rfpl;

    public OpenSource(Tournament rfpl){
        this.rfpl = rfpl;
    }

    public void unpack() throws IOException {
        ReaderTeams();
        ReaderPlayers();
        ReaderYoungers();
    }



    private void ReaderPlayers () throws IOException {
        try (FileReader InPlayers = new FileReader("src\\Sources\\players.txt")) {
            BufferedReader reader = new BufferedReader(InPlayers);
            String line = reader.readLine();
            while (line != null) {
                Player player = new Player(line);
                // System.out.println(player.name + " " + player.club);
                for(short x = 0; x < rfpl.teams.length; x++){
                    if(rfpl.teams[x].name.equals(player.club)){
                        rfpl.teams[x].list.add(player);
                        break;
                    }
                }
                line = reader.readLine();
            }
        }
        catch (IOException ex) {
            System.out.println("FILE WITH PLAYERS NOT FOUND");
            System.exit(0);
        }

    }

    private void ReaderTeams () throws IOException {
        String name = "", town = "", stadium = "", coach = "";
        int capacity_stad = 0;
        double wealth = 0.0;
        try (FileReader InTeams = new FileReader("src\\Sources\\clubs.txt")) {
            BufferedReader reader = new BufferedReader(InTeams);
            String line = reader.readLine();
            int x = 0;
            while (line != null) {
                Team temp = new Team(line);
                rfpl.teams[x] = temp;
                line = reader.readLine();
                ++x;
            }
        } catch (IOException ex) {
            System.out.println("FILE WITH TEAMS NOT FOUND");
            System.exit(0);
        }
    }

    private void ReaderYoungers() throws IOException {
        rfpl.youthPool = new ArrayList<Player>();
        try (FileReader InYoungers = new FileReader("src\\Sources\\youthacademy.txt")) {
            BufferedReader reader = new BufferedReader(InYoungers);
            String line = reader.readLine();
            while (line != null) {
                Player player = new Player(line, 0);
                rfpl.youthPool.add(player);
                line = reader.readLine();
            }
        }
        catch(IOException ex){
            System.out.println("FILE WITH YOUNGERS NOT FOUND");
            System.exit(0);
        }
    }
}
