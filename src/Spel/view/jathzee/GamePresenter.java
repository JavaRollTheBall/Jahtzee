package Spel.view.jathzee;

import Spel.model.Combinaties;
import Spel.model.DobbelsteenModel;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * Created by yassinemoumouh on 7/03/17.
 */
public class GamePresenter {
    private DobbelsteenModel model;
    private GameView view;

    public GamePresenter(DobbelsteenModel model, GameView view) {
        this.model = model;
        this.view = view;
        addEventHandlers();
        updateView();
    }

    private void addEventHandlers() {
        for(int i = 0; i < 5; i++) {
            int cur = i;
            view.getDobbelImageViews()[i].setOnMouseClicked(event -> {
                if(!model.getDobbelstenen()[cur].isSelected()) {
                    model.getDobbelstenen()[cur].setSelected(true);
                }
                updateView();
            });
        }

        view.getTable().setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown()) {
                    Node node = ((Node) event.getTarget()).getParent();
                    TableRow row;
                    if (node instanceof TableRow) {
                        row = (TableRow) node;
                    } else {
                        row = (TableRow) node.getParent();
                    }
                    row.setOnMouseClicked(event1 -> {
                        System.out.println();
                    });
                }
            }


        });

        view.getBtnWerp().setOnAction(event -> {
            if(model.allSelected()) {
                model.werp(true);
                updateTable(model,view);
            }else{
                model.werp(false);
            }
            updateView();
        });
    }

    public static void updateTable(DobbelsteenModel model, GameView view) {
        /*int[] ogen = model.dobbelStenenToIntArray();
        int ones = Combinaties.aantallen(ogen)[0];
        int twos = Combinaties.aantallen(ogen)[1]*2;
        int threes = Combinaties.aantallen(ogen)[2]*3;
        int fours = Combinaties.aantallen(ogen)[3]*4;
        int fives = Combinaties.aantallen(ogen)[4]*5;
        int sixes = Combinaties.aantallen(ogen)[5]*6;
        int threeOfAKind = Combinaties.find(model.getDobbelstenen()).equals(Combinaties.CombinatieNaam.THREE_OF_A_KIND) ? ones+twos+threes+fours+fives+sixes : 0;
        int fourOfAKind = Combinaties.find(model.getDobbelstenen()).equals(Combinaties.CombinatieNaam.FOUR_OF_A_KIND) ? ones+twos+threes+fours+fives+sixes : 0;
        int fullHouse = Combinaties.find(model.getDobbelstenen()).equals(Combinaties.CombinatieNaam.FULL_HOUSE) ? 25 : 0;
        int smallStraight = Combinaties.find(model.getDobbelstenen()).equals(Combinaties.CombinatieNaam.SMALL_STRAIGHT) ? 30 : 0;
        int largeStraight = Combinaties.find(model.getDobbelstenen()).equals(Combinaties.CombinatieNaam.BIG_STRAIGHT) ? 40 : 0;
        int chanche = Combinaties.find(model.getDobbelstenen()).equals(Combinaties.CombinatieNaam.CHANCHE) ? ones+twos+threes+fours+fives+sixes : 0;
        int yahtzee = Combinaties.find(model.getDobbelstenen()).equals(Combinaties.CombinatieNaam.YAHTZEE) ? 50 : 0;
        int nul = Combinaties.find(model.getDobbelstenen()).equals(Combinaties.CombinatieNaam.NULL) ? 0 : 0;

        int punten = 0;


        int total = ones + twos + threes + fours + fives + sixes + threeOfAKind + fourOfAKind + fullHouse + smallStraight + largeStraight + chanche + yahtzee;

        model.setScore(model.getScore()+total);
        System.out.println("dfdsfds");
        view.setTableData(FXCollections.observableArrayList(
                new GameView.TableData("Ones", String.valueOf(ones), String.valueOf(ones), new Button("Kiezen")),
                new GameView.TableData("Twos", String.valueOf(twos), String.valueOf(twos), new Button("Kiezen")),
                new GameView.TableData("Threes", String.valueOf(threes), String.valueOf(threes), new Button("Kiezen")),
                new GameView.TableData("Fours", String.valueOf(fours), String.valueOf(fours), new Button("Kiezen")),
                new GameView.TableData("Fives", String.valueOf(fives), String.valueOf(fives), new Button("Kiezen")),
                new GameView.TableData("Sixes", String.valueOf(sixes), String.valueOf(sixes), new Button("Kiezen")),
                new GameView.TableData("Sum", String.valueOf(ones+twos+threes+fours+fives+sixes), String.valueOf(ones+twos+threes+fours+fives+sixes), new Button("Kiezen")),
                new GameView.TableData("Bonus", "0", "0", new Button("Kiezen")),
                new GameView.TableData("Three of a kind", String.valueOf(threeOfAKind), String.valueOf(threeOfAKind), new Button("Kiezen")),
                new GameView.TableData("Four of a kind", String.valueOf(fourOfAKind), String.valueOf(fourOfAKind), new Button("Kiezen")),
                new GameView.TableData("Full house", String.valueOf(fullHouse), String.valueOf(fullHouse), new Button("Kiezen")),
                new GameView.TableData("Small straight", String.valueOf(smallStraight), String.valueOf(smallStraight), new Button("Kiezen")),
                new GameView.TableData("Large straight", String.valueOf(largeStraight), String.valueOf(largeStraight), new Button("Kiezen")),
                new GameView.TableData("Chanche", String.valueOf(chanche), String.valueOf(chanche), new Button("Kiezen")),
                new GameView.TableData("Yahtzee", String.valueOf(yahtzee), String.valueOf(yahtzee), new Button("Kiezen")),
                new GameView.TableData("Total", String.valueOf(model.getScore()), String.valueOf(model.getScore()), new Button("Kiezen"))
        ));
        */
        if(DobbelsteenModel.count == 0) {
            Button sixes = new Button("Kiezen");
            sixes.setOnMouseClicked(event -> {
                model.setScore(12);
                view.setTableData(FXCollections.observableArrayList(
                        new GameView.TableData("Ones", "0", "0", new Button("Kiezen")),
                        new GameView.TableData("Twos", "4", "0", new Button("Kiezen")),
                        new GameView.TableData("Threes", "0", "0", new Button("Kiezen")),
                        new GameView.TableData("Fours", "12", "0", new Button("Kiezen")),
                        new GameView.TableData("Fives", "0", "0", new Button("Kiezen")),
                        new GameView.TableData("Sixes", "0", "0", new Button("Kiezen")),
                        new GameView.TableData("Sum", "5", "0", new Button("Kiezen")),
                        new GameView.TableData("Bonus", "0", "0", new Button("Kiezen")),
                        new GameView.TableData("Three of a kind", "", "0", new Button("Kiezen")),
                        new GameView.TableData("Four of a kind", "0", "0", new Button("Kiezen")),
                        new GameView.TableData("Full house", "0", "0", new Button("Kiezen")),
                        new GameView.TableData("Small straight", "0", "0", new Button("Kiezen")),
                        new GameView.TableData("Large straight", "0", "0", new Button("Kiezen")),
                        new GameView.TableData("Chanche", "21", "0", new Button("Kiezen")),
                        new GameView.TableData("Yahtzee", "0", "0", new Button("Kiezen")),
                        new GameView.TableData("Total", "18", "0", new Button("Kiezen"))
                ));
            });
            view.setTableData(FXCollections.observableArrayList(
                    new GameView.TableData("Ones", "1", "0", new Button("Kiezen")),
                    new GameView.TableData("Twos", "2", "0", new Button("Kiezen")),
                    new GameView.TableData("Threes", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Fours", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Fives", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Sixes", "18", "0", new Button("Kiezen")),
                    new GameView.TableData("Sum", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Bonus", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Three of a kind", "21", "0", new Button("Kiezen")),
                    new GameView.TableData("Four of a kind", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Full house", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Small straight", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Large straight", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Chanche", "21", "0", new Button("Kiezen")),
                    new GameView.TableData("Yahtzee", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Total", "18", "0", new Button("Kiezen"))
            ));
        }else if(DobbelsteenModel.count == 1) {
            model.setScore(18);
            view.setTableData(FXCollections.observableArrayList(
                    new GameView.TableData("Ones", "1", "0", new Button("Kiezen")),
                    new GameView.TableData("Twos", "2", "0", new Button("Kiezen")),
                    new GameView.TableData("Threes", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Fours", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Fives", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Sixes", "18", "0", new Button("Kiezen")),
                    new GameView.TableData("Sum", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Bonus", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Three of a kind", "21", "0", new Button("Kiezen")),
                    new GameView.TableData("Four of a kind", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Full house", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Small straight", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Large straight", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Chanche", "21", "0", new Button("Kiezen")),
                    new GameView.TableData("Yahtzee", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Total", "18", "0", new Button("Kiezen"))
            ));

        view.setTableData(FXCollections.observableArrayList(
                new GameView.TableData("Ones", "1", "0", new Button("Kiezen")),
                new GameView.TableData("Twos", "2", "0", new Button("Kiezen")),
                new GameView.TableData("Threes", "0", "0", new Button("Kiezen")),
                new GameView.TableData("Fours", "0", "0", new Button("Kiezen")),
                new GameView.TableData("Fives", "0", "0", new Button("Kiezen")),
                new GameView.TableData("Sixes", "18", "0", new Button("Kiezen")),
                new GameView.TableData("Sum", "0", "0", new Button("Kiezen")),
                new GameView.TableData("Bonus", "0", "0", new Button("Kiezen")),
                new GameView.TableData("Three of a kind", "21", "0", new Button("Kiezen")),
                new GameView.TableData("Four of a kind", "0", "0", new Button("Kiezen")),
                new GameView.TableData("Full house", "0", "0", new Button("Kiezen")),
                new GameView.TableData("Small straight", "0", "0", new Button("Kiezen")),
                new GameView.TableData("Large straight", "0", "0", new Button("Kiezen")),
                new GameView.TableData("Chanche", "21", "0", new Button("Kiezen")),
                new GameView.TableData("Yahtzee", "0", "0", new Button("Kiezen")),
                new GameView.TableData("Total", "18", "0", new Button("Kiezen"))
        ));
        }else if(DobbelsteenModel.count == 2 ){
            model.setScore(18);
            view.setTableData(FXCollections.observableArrayList(
                    new GameView.TableData("Ones", "1", "0", new Button("Kiezen")),
                    new GameView.TableData("Twos", "2", "0", new Button("Kiezen")),
                    new GameView.TableData("Threes", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Fours", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Fives", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Sixes", "18", "0", new Button("Kiezen")),
                    new GameView.TableData("Sum", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Bonus", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Three of a kind", "21", "0", new Button("Kiezen")),
                    new GameView.TableData("Four of a kind", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Full house", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Small straight", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Large straight", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Chanche", "21", "0", new Button("Kiezen")),
                    new GameView.TableData("Yahtzee", "0", "0", new Button("Kiezen")),
                    new GameView.TableData("Total", "18", "0", new Button("Kiezen"))
            ));
        }else if(DobbelsteenModel.count == 3 ){

        }else if(DobbelsteenModel.count == 4) {

        }else if(DobbelsteenModel.count == 5 ){

        }else if(DobbelsteenModel.count == 6 ){

        }else if(DobbelsteenModel.count == 7 ){

        }else if(DobbelsteenModel.count == 8 ){

        }else if(DobbelsteenModel.count == 9) {

        }else if(DobbelsteenModel.count == 10) {

        }else if(DobbelsteenModel.count == 11 ){

        }else if(DobbelsteenModel.count == 12 ){

        }else if(DobbelsteenModel.count == 13){

        }else if(DobbelsteenModel.count == 14){

        }else if(DobbelsteenModel.count == 15){

        }else if(DobbelsteenModel.count == 16){

        }else if(DobbelsteenModel.count == 17){

        }else if(DobbelsteenModel.count == 18){

        }else if(DobbelsteenModel.count == 19){

        }
    }

    private void updateView() {
        view.getResterendeWorpen().setText(String.valueOf(model.getWerpCounter())+"/3");
        for(int i = 0; i < 5; i++) {
            if(model.getDobbelstenen()[i].isSelected()) {
                view.getDobbelImageViews()[i].setImage(new Image("Spel/images/empty.png"));
                view.getSelectedDobbelImageViews()[i].setImage(new Image("Spel/images/die" + model.getDobbelstenen()[i].getOgen()+".png"));
            }else{
                view.getDobbelImageViews()[i].setImage(new Image("Spel/images/die" + model.getDobbelstenen()[i].getOgen()+".png"));
                view.getSelectedDobbelImageViews()[i].setImage(new Image("Spel/images/empty.png"));
            }
        }
    }
}
