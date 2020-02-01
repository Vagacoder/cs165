package example3;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class CalculatorFx extends Application {

    private TextField display;
    private String contentToDisplay;

    @Override
    public void start(Stage stage) throws Exception {

        this.contentToDisplay = "";
        this.display = new TextField(contentToDisplay);
        this.display.setEditable(false);
        this.display.setAlignment(Pos.CENTER_RIGHT);

        var buttonPane = new GridPane();
        buttonPane.setPadding(new Insets(15, 0, 15, 0));
        buttonPane.setVgap(5);
        buttonPane.setHgap(5);

        int colNum = 4;
        int rowNum = 4;
        ColumnConstraints[] columns = new ColumnConstraints[colNum];
        for (int i = 0; i < colNum; i++) {
            columns[i] = new ColumnConstraints();
            columns[i].setHgrow(Priority.ALWAYS);
            columns[i].setFillWidth(true);
            buttonPane.getColumnConstraints().add(columns[i]);
        }

        Button[] btns = new Button[16];
        String[] btnLabels = { 
            "7", "8", "9", "+", 
            "4", "5", "6", "-", 
            "1", "2", "3", "*", 
            "C", "0", "=", "/" 
        };

        for (int i = 0; i < btns.length; i++) {
            var btn = new Button(btnLabels[i]);
            btn.setOnAction(new buttonHandler());
            btn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            btns[i] = btn;
            buttonPane.add(btn, i % colNum, i / colNum);
        }

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setTop(this.display);
        root.setCenter(buttonPane);

        Scene scene = new Scene(root, 400, 400);

        stage.setTitle("Calculator using JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    class buttonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            String thisBtnLabel = ((Button) event.getSource()).getText();
            System.out.println(thisBtnLabel + " is clicked!");
            parseInput(thisBtnLabel);
        }
    }

    private void parseInput(String input){
        if(!input.equals("=")){
            this.contentToDisplay += input;
        }else{
            // TODO : calculate
            this.contentToDisplay = "";
        }
        CalculatorFx.this.display.setText(this.contentToDisplay);
    }
    public static void main(String[] args) {
        CalculatorFx.launch(args);
    }

}