package Spel.view.menu;

import Spel.model.DobbelsteenModel;
import Spel.view.jathzee.GamePresenter;
import Spel.view.jathzee.GameView;
import Spel.view.options.*;
import javafx.application.Platform;


/**
 * Created by Geoff on 9/02/2017.
 */
public class MenuPresenter {

    private final DobbelsteenModel model;
    private final MenuView view;

    public MenuPresenter(DobbelsteenModel model, MenuView view) {
        this.model = model;
        this.view = view;

        addEventhandlers();
        updatView();
    }

    private void addEventhandlers() {
        view.getOptionsButton().setOnAction(event -> {
            OptionsView optionsView = new OptionsView();
            new OptionsPresenter(model, optionsView);
            view.getScene().setRoot(optionsView);
            optionsView.getScene().getWindow().sizeToScene();
        });

        view.getPlayButton().setOnAction(event -> {
            GameView gameView = new GameView();
            new GamePresenter(model, gameView);
            this.view.getScene().setRoot(gameView);
            gameView.getScene().getWindow().sizeToScene();
        });


        this.view.getExitButton().setOnAction(event -> Platform.exit());

    }

    private void updatView() {

    }
}
