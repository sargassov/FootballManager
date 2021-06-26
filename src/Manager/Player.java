package Manager;



import java.util.ArrayList;


public class Player {
    public String name;
    public String natio;
    public String club;
    public String position;
    public short number;
    public short gk_able;
    public short def_able;
    public short mid_able;
    public short forw_able;
    public short power;
    public short captain_able;
    public short tire = 0;
    public short time_before_treat = 0;
    public short year_birth;
    public short training_able;
    public short training_balance = 0;
    public boolean is_injury = false;
    public boolean is_11th = false;
    public boolean is_capitan = false;
    public double price;
    public short strategy_place = -100;

    public Player(){}
    public Player(String Info) {
        String[] StringMass = Info.split("/");
        for(short x = 0; x < StringMass.length; x++){
            ToComposite(StringMass[x], x);
        }
        training_able = (short) (Math.random() * 10 + 10);
        price = PriceToSell();
        if (position.equals("Gk")) power = gk_able;
        if (position.equals("Def")) power = def_able;
        if (position.equals("Mid")) power = mid_able;
        if (position.equals("Forw")) power = forw_able;
    }

    public Player(String name, int zero) {
        this.name = name;
        natio = "Rus";
        club = "";
        position = RandomPosition();
        number = 0;
        youthabilities();
        boolean is_injury = false;
        boolean is_11th = false;
        boolean is_capitan = false;
        price = PriceToSell();

    }

    private void youthabilities() {
        gk_able = 0;
        def_able = 0;
        mid_able = 0;
        forw_able = 0;
        power = 0;
        captain_able = 1;
        if (position.equals("Gk")) {
            gk_able =  60;
            double temp = Math.random() * 5;
            gk_able += (short)temp;
            power = gk_able;
        }

        if (position.equals("Def")) {
            def_able =  60;
            double temp = Math.random() * 5;
            def_able += (short)temp;
            power = def_able;
        }
        if (position.equals("Mid")) {
            mid_able =  60;
            double temp = Math.random() * 5;
            mid_able += (short)temp;
            power = mid_able;
        }
        if (position.equals("Forw")) {
            forw_able =  60;
            double temp = Math.random() * 5;
            forw_able += (short)temp;
            power = forw_able;
        }


        if (gk_able == 0) {double temporary = Math.random() * 9; gk_able = (short)temporary;}
        if (def_able == 0) {double temporary = Math.random() * 15; def_able = (short)temporary;}
        if (mid_able == 0) {double temporary = Math.random() * 15; mid_able = (short)temporary;}
        if (forw_able == 0) {double temporary = Math.random() * 15; forw_able = (short)temporary;}

        tire = 0;
        time_before_treat = 0;
        year_birth = 2004;
        training_able += 10;
        double temp = Math.random() * 10;
        training_able += (short)temp;
    }

    private String RandomPosition() {
        int random = (int)(Math.random() * 4);
        if (random == 0) {return "Gk";}
        if (random == 1) {return "Def";}
        if (random == 2) {return "Mid";}
        if (random == 3) {return "Forw";}
        return "";
    }

    private void ToComposite(String temp, int count) {
        if (count == 0) name = temp;
        if (count == 1) year_birth = Short.parseShort(temp);
        if (count == 2) natio = temp;
        if (count == 3) club = temp;
        if (count == 4) position = temp;
        if (count == 5) gk_able = Short.parseShort(temp);
        if (count == 6) def_able = Short.parseShort(temp);
        if (count == 7) mid_able = Short.parseShort(temp);
        if (count == 8) forw_able = Short.parseShort(temp);
        if (count == 9) price = Double.parseDouble(temp);
        if (count == 10) captain_able = Short.parseShort(temp);
        if (count == 11) number = Short.parseShort(temp);
    }

    private double PriceToSell() {
        int able;
        price = 0.0;
        for (short x = 0; x < 4; x++) {
            if (x == 0) able = gk_able;
            else if (x == 1) able = def_able;
            else if (x == 2) able = mid_able;
            else able = forw_able;

            if (able < 60) price += (0.01 + able * 0.01);
            else if (able >= 60 && able < 70) price += (1.0 + (able - 60) * 0.15);
            else if (able >= 70 && able < 80) price += (2.5 + (able - 70) * 0.45);
            else if (able >= 80 && able < 90) price += (7.0 + (able - 80) * 2.7);
            else if (able >= 90 && able < 100) price += (34.0 + (able - 90) * 6.5);
        }

        if (captain_able > 20 && captain_able < 31) price *= 1.1;
        if (captain_able > 30 && captain_able < 41) price *= 1.15;
        if (captain_able > 40 && captain_able < 51) price *= 1.2;
        if (captain_able > 50 && captain_able < 61) price *= 1.25;
        if (captain_able > 60 && captain_able < 71) price *= 1.3;
        if (captain_able > 70) price *= 1.35;

        if (is_injury) price *= 0.8;
        if (year_birth < 1988) price *= 0.8;
        RoundPrice();

        return price;
    }

    private void RoundPrice() {
        double NewPrice = price * 100;
        int temp = (int)NewPrice;
        price = (double)temp / 100;
    }

    public static short YouthNumberCorrector(ArrayList<Player>list){
        ArrayList<Short> numbers = new ArrayList<Short>();
        short x = 1;
        while(x < 100){
            boolean marker = false;
            for(Player player : list){
                if(player.number == x){
                    marker = true;
                    break;
                }
            }
            if(!marker){
                numbers.add(x);
            }
             x++;
        }
        short num = (short)(Math.random() * numbers.size() - 1);
        num++;
        return numbers.get(num);
    }
}











