package Spel.view.menu;

import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


/**
 * Created by Geoff on 9/02/2017.
 */
public class MenuView extends VBox {
    private static final Image LOGO = new Image("spel/images/Yahtzee.png");

    private ImageView logo;
    private Button playButton;
    private Button optionsButton;
    private Button ExitButton;

    public MenuView() {
        initialiseNodes();
        layoutNodes();
    }

    private void initialiseNodes() {
        logo = new ImageView("spel/images/Yahtzee.png");
        playButton = new Button("Play");
        optionsButton = new Button("Options");
        ExitButton = new Button("Exit");
    }

    private void layoutNodes() {
        this.setSpacing(10.2);
        this.setPadding(new Insets(10.0));
        this.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();

        playButton.setPrefSize(100.0, 20.0);
        optionsButton.setPrefSize(100.0, 20.0);
        ExitButton.setPrefSize(100.0, 20.0);
        this.getChildren().addAll(logo, playButton, optionsButton, ExitButton);

    }

    Button getPlayButton() {
        return playButton;
    }

    Button getOptionsButton() {
        return optionsButton;
    }

    Button getExitButton() {
        return ExitButton;
    }
}
