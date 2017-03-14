package Spel.view.jathzee;

import Spel.model.Combinaties;
import Spel.model.DobbelsteenModel;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.control.TableRow;
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
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    Node node = ((Node) event.getTarget()).getParent();
                    TableRow row;
                    if (node instanceof TableRow) {
                        row = (TableRow) node;
                    } else {
                        // clicking on text part
                        row = (TableRow) node.getParent();
                    }
                    System.out.println((GameView.TableData)(row.getItem()));
                }
            }


        });

        view.getBtnWerp().setOnAction(event -> {
            if(model.allSelected()) {
                model.werp(true);

                int[] ogen = model.dobbelStenenToIntArray();
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

                int total = ones + twos + threes + fours + fives + sixes + threeOfAKind + fourOfAKind + fullHouse + smallStraight + largeStraight + chanche + yahtzee;
                model.setScore(model.getScore()+total);
                System.out.println("dfdsfds");
                view.setTableData(FXCollections.observableArrayList(
                        new GameView.TableData("Ones", String.valueOf(ones), String.valueOf(ones)),
                        new GameView.TableData("Twos", String.valueOf(twos), String.valueOf(twos)),
                        new GameView.TableData("Threes", String.valueOf(threes), String.valueOf(threes)),
                        new GameView.TableData("Fours", String.valueOf(fours), String.valueOf(fours)),
                        new GameView.TableData("Fives", String.valueOf(fives), String.valueOf(fives)),
                        new GameView.TableData("Sixes", String.valueOf(sixes), String.valueOf(sixes)),
                        new GameView.TableData("Sum", String.valueOf(ones+twos+threes+fours+fives+sixes), String.valueOf(ones+twos+threes+fours+fives+sixes)),
                        new GameView.TableData("Bonus", "0", "0"),
                        new GameView.TableData("Three of a kind", String.valueOf(threeOfAKind), String.valueOf(threeOfAKind)),
                        new GameView.TableData("Four of a kind", String.valueOf(fourOfAKind), String.valueOf(fourOfAKind)),
                        new GameView.TableData("Full house", String.valueOf(fullHouse), String.valueOf(fullHouse)),
                        new GameView.TableData("Small straight", String.valueOf(smallStraight), String.valueOf(smallStraight)),
                        new GameView.TableData("Large straight", String.valueOf(largeStraight), String.valueOf(largeStraight)),
                        new GameView.TableData("Chanche", String.valueOf(chanche), String.valueOf(chanche)),
                        new GameView.TableData("Yahtzee", String.valueOf(yahtzee), String.valueOf(yahtzee)),
                        new GameView.TableData("Total", String.valueOf(model.getScore()), String.valueOf(model.getScore()))
                ));

            }else{
                model.werp(false);
            }
            updateView();

        });


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
