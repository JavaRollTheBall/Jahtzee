package Spel.model;

import java.util.Random;

/**
 * Created by yassinemoumouh on 7/03/17.
 */
public class DobbelsteenModel {
    public final int MAX_AANTAL_OGEN = 6;

    private Random random;
    private Dobbelsteen[] dobbelstenen;
    private int werpCounter;
    private int score;

    public DobbelsteenModel() {
        dobbelstenen = new Dobbelsteen[5];
        for(int i = 0; i < 5; i++) {
            dobbelstenen[i] = new Dobbelsteen();
        }
        this.random = new Random();
        werpCounter = 1;
        werp(true);
    }

    public Dobbelsteen[] getDobbelstenen() {
        return dobbelstenen;
    }

    public void werp(boolean reset) {
        if(reset || werpCounter++ >= 3) {
            for(int i = 0; i < 5; i++) {
                dobbelstenen[i].setSelected(false);
                dobbelstenen[i].setOgen(random.nextInt(MAX_AANTAL_OGEN) + 1);
            }
            werpCounter = 1;
        }else{
            for(int i = 0; i < 5; i++) {
                if(!dobbelstenen[i].isSelected()) {
                    dobbelstenen[i].setOgen(random.nextInt(MAX_AANTAL_OGEN) + 1);
                }
            }
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

    public int[] dobbelStenenToIntArray() {
        int[] ogen = new int[5];
        for(int i = 0; i < 5; i++) {
            ogen[i] = dobbelstenen[i].getOgen();
        }
        return ogen;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
