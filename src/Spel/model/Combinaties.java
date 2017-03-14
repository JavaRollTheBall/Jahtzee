package Spel.model;

import org.omg.CORBA.CODESET_INCOMPATIBLE;

import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by yassinemoumouh on 7/03/17.
 */
public class Combinaties {
    public enum CombinatieNaam {
        THREE_OF_A_KIND,
        FOUR_OF_A_KIND,
        FULL_HOUSE,
        SMALL_STRAIGHT,
        BIG_STRAIGHT,
        CHANCHE,
        YAHTZEE,
        NULL
    }

    public static CombinatieNaam find(Dobbelsteen[] dobbelstenen) {
        String[] ogen = new String[5];
        for(int i = 0; i < 5; i++) {
            ogen[i] = String.valueOf(dobbelstenen[i].getOgen());
        }

        Arrays.sort(ogen);
        String r = String.join("",ogen);
        if(Pattern.compile("(.)\\1{4}").matcher(r).find()) {
            return CombinatieNaam.YAHTZEE;
        }else if(Pattern.compile("(.)\\1{3}").matcher(r).find()) {
            return CombinatieNaam.FOUR_OF_A_KIND;
        }else if(Pattern.compile("(.)\\1{2}(.)\\2|(.)\\3(.)\\4{2}").matcher(r).find()) {
            return CombinatieNaam.FULL_HOUSE;
        }else if(Pattern.compile("(.)\\1{2}").matcher(r).find()) {
            return CombinatieNaam.THREE_OF_A_KIND;
        }else if(Pattern.compile("1234|2345|3456").matcher(r.replace("(.)\\1","$1")).find()) {
            return CombinatieNaam.BIG_STRAIGHT;
        }else {
            return CombinatieNaam.NULL;
        }
    }

    public static int[] aantallen(int[] ogen) {
        int[] voorkomen = new int[10];
        for(int a : ogen) {
            voorkomen[a]++;
        }
        return voorkomen;
    }
}
