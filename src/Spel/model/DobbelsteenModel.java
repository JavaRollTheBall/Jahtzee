package Spel.model;

import java.util.Random;

/**
 * Created by yassinemoumouh on 7/03/17.
 */
public class DobbelsteenModel {
    public final int MAX_AANTAL_OGEN = 6;

    private Random random;
    private static Dobbelsteen[] dobbelstenen;
    private int werpCounter;
    private static int score;
    public static int count;

    public DobbelsteenModel() {
        dobbelstenen = new Dobbelsteen[5];
        for(int i = 0; i < 5; i++) {
            dobbelstenen[i] = new Dobbelsteen();
        }
        this.random = new Random();
        werpCounter = 1;
        count = 0;
        werp(true);
    }

    public static Dobbelsteen[] getDobbelstenen() {
        return dobbelstenen;
    }

    public void werp(boolean reset) {
        int[][] worpen = new int[20][5];
        worpen[0] = new int[]{1,3,2,6,6};
        worpen[1] = new int[]{2,4,2,4,4};
        worpen[2] = new int[]{5,4,3,2,1};
        worpen[2] = new int[]{5,5,5,5,5};
        worpen[3] = new int[]{3,3,3,6,6};
        worpen[4] = new int[]{4,6,2,6,6};
        worpen[5] = new int[]{1,2,2,5,6};
        worpen[6] = new int[]{1,6,2,6,6};
        worpen[7] = new int[]{1,6,2,6,6};
        worpen[8] = new int[]{1,6,2,6,6};
        worpen[9] = new int[]{1,6,2,6,6};
        worpen[10] = new int[]{1,6,2,6,6};
        worpen[11] = new int[]{1,6,2,6,6};
        worpen[12] = new int[]{1,6,2,6,6};
        worpen[13] = new int[]{1,6,2,6,6};
        worpen[14] = new int[]{1,6,2,6,6};
        worpen[15] = new int[]{1,6,2,6,6};
        worpen[16] = new int[]{1,6,2,6,6};
        worpen[17] = new int[]{1,6,2,6,6};
        worpen[18] = new int[]{1,6,2,6,6};
        worpen[19] = new int[]{1,6,2,6,6};

        if(reset || werpCounter++ >= 3) {
            for(int i = 0; i < 5; i++) {
                dobbelstenen[i].setSelected(false);
                dobbelstenen[i].setOgen(worpen[count][i]);
            }
            count++;
            werpCounter = 1;
        }else{
            for(int i = 0; i < 5; i++) {
                if(!dobbelstenen[i].isSelected()) {
                    dobbelstenen[i].setOgen(worpen[count][i]);
                }
            }
            count++;
        }
    }

    public int getWerpCounter() {
        return werpCounter;
    }

    public boolean allSelected() {
        boolean allSelected = true;
        for(int n = 0; n < 5; n++) {
            if(!dobbelstenen[n].isSelected()) {
                allSelected = false;
            }
        }
        return allSelected;
    }

    public static int[] dobbelStenenToIntArray() {
        int[] ogen = new int[5];
        for(int i = 0; i < 5; i++) {
            ogen[i] = dobbelstenen[i].getOgen();
        }
        return ogen;
    }


    public static int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
