package example2;

import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

public class CounterFx extends Application {

    private TextField display;
    private Button addBtn;
    private int count = 0;

    @Override
    public void start(Stage stage) throws Exception {

        this.display = new TextField("0");
        this.display.setEditable(false);
        addBtn = new Button("Add One");
        addBtn.setOnAction(event -> this.display.setText("" + ++this.count));

        FlowPane pane = new FlowPane();
        pane.setPadding(new Insets(15, 5, 15, 5));
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(new Label("Count: "), this.display, this.addBtn);

        Scene scene = new Scene(pane, 400, 100);

        stage.setTitle("Counter using JavaFX");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args){
        CounterFx.launch(args);
    }

}