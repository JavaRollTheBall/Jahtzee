package Spel.view.options;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;


/**
 * Created by Geoff on 9/02/2017.
 */
public class OptionsView extends VBox {

    private Button geluidsButton;
    private Button helderheidsButton;



    public OptionsView() {
        InitialiseNodes();
        Layoutnodes();

    }

    private void InitialiseNodes() {
        geluidsButton = new Button("Geluid");
        helderheidsButton = new Button("Helderheid");


    }

    private void Layoutnodes() {
        this.setSpacing(10.2);
        this.setPadding(new Insets(10.0));
        this.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();

        geluidsButton.setPrefSize(100.0, 20.0);
        helderheidsButton.setPrefSize(100.0, 20.0);


        this.getChildren().addAll(geluidsButton, helderheidsButton);
    }


}