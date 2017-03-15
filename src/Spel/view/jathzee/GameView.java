package Spel.view.jathzee;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * Created by yassinemoumouh on 7/03/17.
 */
public class GameView extends BorderPane{
    private Button btnWerp;
    private HBox dobbelBox;
    private ImageView[] dobbelImageViews;
    private HBox selectedDobbelBox;
    private ImageView[] selectedDobbelImageViews;
    private VBox bottomElements;
    private Label resterendeWorpen;

    private TableView<TableData> table;


    public static class TableData {
        private final SimpleStringProperty comment;
        private final SimpleStringProperty player1;
        private final SimpleStringProperty player2;

        public TableData(String comment, String player1, String player2) {
            this.comment = new SimpleStringProperty(comment);
            this.player1 = new SimpleStringProperty(player1);
            this.player2 = new SimpleStringProperty(player2);
        }

        public String getComment() {
            return comment.get();
        }

        public void setComment(String comment) {
            this.comment.set(comment);
        }

        public String getPlayer1() {
            return player1.get();
        }

        public void setPlayer1(String player1) {
            this.player1.set(player1);
        }

        public String getPlayer2() {
            return player2.get();
        }


        public void setPlayer2(String player2) {
            this.player2.set(player2);
        }


    }

    public GameView() {
        initialiseNodes();
        layoutNodes();
    }


    private void initialiseNodes() {
        btnWerp = new Button("Werp");
        table = new TableView<>();
        dobbelBox = new HBox();
        selectedDobbelBox = new HBox();
        bottomElements = new VBox();
        dobbelImageViews = new ImageView[5];
        selectedDobbelImageViews = new ImageView[5];
        for(int i = 0; i < 5; i++) {
            dobbelImageViews[i] = new ImageView();
            selectedDobbelImageViews[i] = new ImageView();
        }
        resterendeWorpen = new Label();
    }

    private void layoutNodes() {
        dobbelBox.setSpacing(20.0);
        dobbelBox.setCenterShape(true);
        for(int i = 0; i < 5; i++) {
            dobbelBox.getChildren().add(dobbelImageViews[i]);
            selectedDobbelBox.getChildren().add(selectedDobbelImageViews[i]);
        }
        selectedDobbelBox.setSpacing(20.0);
        selectedDobbelBox.setCenterShape(true);
        selectedDobbelBox.setStyle("-fx-background-color: darkgrey;");

        this.getChildren().add(dobbelBox);
        bottomElements.getChildren().addAll(selectedDobbelBox,btnWerp,resterendeWorpen);
        this.setBottom(bottomElements);
        btnWerp.setPrefSize(80.0,20.0);
        BorderPane.setAlignment(btnWerp, Pos.CENTER);

        table.setEditable(false);
        TableColumn commentCol = new TableColumn("");
        commentCol.setCellValueFactory(new PropertyValueFactory<>("comment"));
        TableColumn speler1Col = new TableColumn("Speler 1");
        speler1Col.setCellValueFactory(new PropertyValueFactory<>("player1"));
        TableColumn speler2Col = new TableColumn("Speler 2");
        speler1Col.setCellValueFactory(new PropertyValueFactory<>("player2"));
        setTableData(FXCollections.observableArrayList(
                new TableData("Ones", "0", "0"),
                new TableData("Twos", "0", "0"),
                new TableData("Threes", "0", "0"),
                new TableData("Fours", "0", "0"),
                new TableData("Fives", "0", "0"),
                new TableData("Sixes", "0", "0"),
                new TableData("Sum", "0", "0"),
                new TableData("Bonus", "0", "0"),
                new TableData("Three of a kind", "0", "0"),
                new TableData("Four of a kind", "0", "0"),
                new TableData("Full house", "0", "0"),
                new TableData("Small straight", "0", "0"),
                new TableData("Large straight", "0", "0"),
                new TableData("Chanche", "0", "0"),
                new TableData("Yahtzee", "0", "0"),
                new TableData("Total", "0", "0")
        ));
        table.getColumns().addAll(commentCol, speler1Col, speler2Col);

        final HBox hbox = new HBox();
        hbox.setSpacing(5);
        hbox.setPadding(new Insets(10, 0, 0, 10));
        hbox.getChildren().add(table);
        this.setRight(hbox);
    }

    public void setTableData(ObservableList<TableData> data) {
        table.setItems(data);
    }

    public ImageView[] getDobbelImageViews() {
        return dobbelImageViews;
    }

    public ImageView[] getSelectedDobbelImageViews() {
        return selectedDobbelImageViews;
    }

    public Button getBtnWerp() {
        return btnWerp;
    }

    public Label getResterendeWorpen() { return resterendeWorpen; }

    public TableView<TableData> getTable() {
        return table;
    }
}

