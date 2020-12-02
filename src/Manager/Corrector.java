package Manager;
import Exception.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.out;

public class Corrector {
    public static int InputIntMethod(int minimal, int maximal){
        Scanner sc = new Scanner(System.in);
        int number;
        do {
            while (!sc.hasNextInt()) {
                out.println("\n\n\t\t\t\tYou weren't entered a number! Try again!\n\n");
                sc.next();
            }
            number = sc.nextInt();
            if(number < minimal || number > maximal){
                out.println("\n\n\t\t\t\tThe choise is out of the range between " + minimal + " and " + maximal + ". Try again!");
                continue;
            }
        } while (number < minimal || number > maximal);
        return number;
    }


    public static String InputStringMethod() {
        Scanner sc = new Scanner(System.in);
        String line, temp;
        temp = sc.nextLine();
        while(!isTheString(temp) || temp.equals("")) {
            out.println("\n\n\t\t\t\tYou were written an incorrect line. Try again!\n\n");
            temp = sc.next();
        }
        line = temp;
        return line;
    }

    public static int InputNumberFromTheList(ArrayList<Short> list){
        Scanner sc = new Scanner(System.in);
        boolean isFound = false;
        int number;
        do {
            while (!sc.hasNextInt()) {
                out.println("\n\n\t\t\t\tYou weren't entered a number! Try again!\n\n");
                sc.next();
            }
            number = sc.nextInt();
            number--;
            for(short s: list){
                out.print(s + " ");
                if(number == s) {
                    isFound = true;
                    break;
                }
            }
            if(!isFound) out.println("\n\n\t\t\t\tYou choosed an incorrect player! Try again!\n\n");
        } while (!isFound);
        return number;
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

    public static String Inspacer4Sym(String word){
        int len = 4 - word.length();
        String newWord = new String(word.toCharArray());
        for(int count = 0; count < len; count++){
            newWord += " ";
        }
        return newWord;
    }

    public static boolean isTheString(String tech){
        //int interval;
        for(int x = 0; x < tech.length(); x++){
            int interval = (int)(tech.toCharArray()[x]);
            if ((interval != 32 && interval < 65) || (interval > 90 && interval < 97) || (interval > 122)){
                return false;
            }
        }
        return true;
    }

    public static String wordToCenter(String tech, int longWord){
        int longCurrentWord = tech.length();
        for(int x = 0; x < longWord - longCurrentWord; x++){
            if(x % 2 == 0) tech = " " + tech;
            else tech += " ";
        }
        return tech;
    }



}
