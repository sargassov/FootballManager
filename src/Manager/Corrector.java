package Manager;
import Exception.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.out;

public class Corrector {
    public static int InputIntMethod(int minimal, int maximal){
        int choise = 1000;
        try{
            Scanner scanner = new Scanner(System.in);
            choise = scanner.nextInt();
            if(choise < minimal) {
                throw new ChoiseOutOfLowerRangeException("\n\n\t\t\t\tThe choise is less than " + minimal + ". Try again!\n\n", 0);
            }
            if(choise > maximal){
                throw new ChoiseOutOfUpperRangeException("\n\n\t\t\t\tThe choise is more than " + maximal + ". Try again!\n\n", 0);
            }
            return choise;
        }

        catch(InputMismatchException ex){
            out.println("\n\n\t\t\t\tYou weren't entered a number! Try again!\n\n");
            InputIntMethod(minimal, maximal);
        }

        catch(ChoiseOutOfLowerRangeException ex){
            out.println(ex.getMessage());
            InputIntMethod(minimal, maximal);
        }

        catch(ChoiseOutOfUpperRangeException ex){
            out.println(ex.getMessage());
            InputIntMethod(minimal, maximal);
        }
        return choise;
    }

    public static short InputNumberFromTheList(ArrayList<Short>list){
        short choise = 1000;
        try{
            Scanner scanner = new Scanner(System.in);
            choise = scanner.nextShort();
            choise--;
            for(Short num : list){
                if(num == choise)
                    return choise;
            }
            choise++;
            throw new WrongChoiseFromListException("\n\n\t\t\t\tYou were choosed incorrect number. Try again!\n\n");
        }
        catch(InputMismatchException ex){
            out.println("\n\n\t\t\t\tYou weren't entered a number! Try again!\n\n");
            InputNumberFromTheList(list);
        }
        catch(WrongChoiseFromListException ex){
            out.println(ex.getMessage());
            InputNumberFromTheList(list);
        }
        return choise;
    }

    public static String GetSpace(int value){
        String string = new String();
        for(short x = 0; x < value; x++){
            string += " ";
        }
        return string;
    }

    public static void wordUpperCase(String word){
        for (char c : word.toCharArray()) {
            out.print(Character.toUpperCase(c) +  " ");
        }
    }

    public static String Inspacer(String word){
        int len = 27 - word.length();
        String newWord = new String(word.toCharArray());
        for(int count = 0; count < len; count++){
            newWord += " ";
        }
        return newWord;
    }

    /*numberCorrector(string& temp, vector<Player>list, short par) {
        short number = 0;
        if (isNumber(temp)) {
            number = atoi(temp.c_str());
            for (short x = 0; x < list.size(); x++) {
                if (list[x].number == number || number < 1 || number > 99) {
                    if (par) {
                        cout << "\n\n\t\t\tNot correct number. Choose from: ";
                        for (short z = 1; z < 100; z++) {
                            short count = 0;
                            short y = 0;
                            for (; y < list.size(); y++) {
                                if (z == list[y].number) {
                                    count++;
                                    break;
                                }
                            }
                            if (!count && par) cout << z << " ";
                        }
                        cout << "... : ";
                        cin >> temp;
                        number = numberCorrector(temp, list, 1);
                    }
                    else {
                        short x = 1 + rand() % 99;
                        temp = to_string(x);
                        number = numberCorrector(temp, list, 0);
                    }

                }
            }
        }
        else {
            cout << "\n\n\t\t\tYou weren't wrote number. Write again: ";
            cin >> temp;
            if(!par) number = numberCorrector(temp, list, 0);
            else number = numberCorrector(temp, list, 1);
        }


        return number;
    }*/
}
