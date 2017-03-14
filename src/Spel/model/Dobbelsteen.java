package Spel.model;

import javafx.scene.image.Image;

/**
 * Created by yassinemoumouh on 12/03/17.
 */
public class Dobbelsteen {
    private Image image;
    private int ogen;
    private boolean selected;

    public Dobbelsteen() {
        this.image = new Image("Spel/images/empty.png");
        this.ogen = 1;
        this.selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setOgen(int ogen) {
        this.ogen = ogen;
    }

    public int getOgen() {
        return ogen;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }
}
