package Tables;

import Manager.Tournament;

public class RevenueTable extends Table implements Data {

    private static int HEIGHT = 23;
    private static int WIDTH = 109;

    @Override
    public void toPrint(Tournament rfpl) {
        for(int x = 0; x < HEIGHT; x++){
            for(int y = 0; y < WIDTH; y++){
                if(y == 0 || y == WIDTH - 1) verSlash();
                else dash();
            }
            System.out.println();
        }
    }


}
