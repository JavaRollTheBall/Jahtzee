package Spel;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Spel.view.options.*;
import Spel.view.menu.*;
import Spel.model.*;


/**
 * Created by yassinemoumouh on 7/03/17.
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        MenuView view = new MenuView();
        DobbelsteenModel model = new DobbelsteenModel();
        OptionsView view1 = new OptionsView();
        new MenuPresenter(model, view);
        Scene scene = new Scene(view, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Yahtzee");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}